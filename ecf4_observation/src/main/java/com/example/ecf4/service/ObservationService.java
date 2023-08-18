package com.example.ecf4.service;

import com.example.ecf4.dto.ObservationResponseDto;
import com.example.ecf4.entity.Observation;
import com.example.ecf4.exception.InvalidCelestialObjectException;
import com.example.ecf4.exception.InvalidDateFormatException;
import com.example.ecf4.exception.InvalidIdException;
import com.example.ecf4.exception.InvalidParamException;
import com.example.ecf4.repository.ObservationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ecf4.tool.RestClient;
import com.example.ecf4.dto.CelestialObjectResponseDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ObservationService {

    @Autowired
    ObservationRepository observationRepository;
    ModelMapper modelMapper = new ModelMapper();

    public boolean create(String description, String photoUrl, int celestialObjectId) throws InvalidParamException {
        if (description.isEmpty() || photoUrl.isEmpty() || celestialObjectId <= 0) {
            throw new InvalidParamException();
        } else {
            Observation observation = new Observation(description, photoUrl, celestialObjectId);
            observationRepository.save(observation);
            return true;
        }
    }

    public List<ObservationResponseDto> findAll() {
        try {
            List<Observation> observationList = (List<Observation>) observationRepository.findAll();
            List<ObservationResponseDto> observationResponseDtoList = new ArrayList<>();
            for (Observation o : observationList) {
                ObservationResponseDto observationResponseDto = modelMapper.map(o, ObservationResponseDto.class);
                observationResponseDtoList.add(observationResponseDto);
            }
            return observationResponseDtoList;
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Observation findById(int id) throws InvalidIdException {
        try {
            Observation observation = observationRepository.findById(id).get();
            return observation;
        }
        catch (Exception e) {
            throw new InvalidIdException();
        }
    }

    public List<Observation> findByDate(String date) throws InvalidDateFormatException {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate searchDate = LocalDate.parse(date, formatter);
            return observationRepository.findAllByDate(searchDate);
        }
        catch (Exception e) {
            throw new InvalidDateFormatException();
        }
    }

    public ObservationResponseDto findByCelestialObject(String name) throws InvalidCelestialObjectException {
        try {
            //On récupère l'objet celeste qui correspond au name
            RestClient<CelestialObjectResponseDto, String> restClient = new RestClient<>();
            CelestialObjectResponseDto celestialObjectResponseDto = restClient.get("celestialObject/name/"+name, CelestialObjectResponseDto.class);
            //On récupère toutes les observations ayant un celestialObjectId qui correspond à l'Id de l'objet celeste
            List<Observation> observationList = new ArrayList<>();
            for (Observation o: observationRepository.findAll()) {
                if (o.getCelestialObjectId() == celestialObjectResponseDto.getId()) {
                    observationList.add(o);
                }
            }
            //On construit l'observationDto qui contient la liste des observations et l'objet celeste correspondant et on la renvoie
            ObservationResponseDto observationResponseDto = new ObservationResponseDto(observationList, celestialObjectResponseDto);
            return observationResponseDto;
        }
        catch (Exception e) {
            throw new InvalidCelestialObjectException();
        }
    }




}
