package com.example.ecf4.controller;

import com.example.ecf4.dto.ObservationResponseDto;
import com.example.ecf4.entity.Observation;
import com.example.ecf4.exception.InvalidCelestialObjectException;
import com.example.ecf4.exception.InvalidDateFormatException;
import com.example.ecf4.exception.InvalidIdException;
import com.example.ecf4.exception.InvalidParamException;
import com.example.ecf4.service.ObservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/observation")
public class ObservationController {

    @Autowired
    ObservationService observationService;

    @PostMapping("/create")
    public ResponseEntity create(@RequestParam String description, @RequestParam String photoUrl, @RequestParam int celestialObjectId) throws InvalidParamException {
        observationService.create(description, photoUrl, celestialObjectId);
        return ResponseEntity.ok("Observation created");
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable int id) throws InvalidIdException {
        Observation observation = observationService.findById(id);
        return ResponseEntity.ok(observation);
    }

    @GetMapping("/all")
    public ResponseEntity getAll() {
        List<ObservationResponseDto> observationResponseDtoList = observationService.findAll();
        return ResponseEntity.ok(observationResponseDtoList);
    }

    @GetMapping("/object/{name}")
    public ResponseEntity getByCelestialObject(@PathVariable String name) throws InvalidCelestialObjectException {
        ObservationResponseDto observationResponseDto = observationService.findByCelestialObject(name);
        return ResponseEntity.ok(observationResponseDto);
    }

    //La date doit être au format yyyy-MM-dd
    @GetMapping("/date")
    public ResponseEntity getByDate(@RequestParam String date) throws InvalidDateFormatException {
        List<Observation> observationList = observationService.findByDate(date);
        return ResponseEntity.ok(observationList);
    }
}
