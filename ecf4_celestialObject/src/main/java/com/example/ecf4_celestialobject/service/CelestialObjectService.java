package com.example.ecf4_celestialobject.service;

import com.example.ecf4_celestialobject.entity.CelestialObject;
import com.example.ecf4_celestialobject.repository.CelestialObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CelestialObjectService {

    @Autowired
    CelestialObjectRepository celestialObjectRepository;

    public void create(String name) {
        if (!name.isEmpty()) {
            CelestialObject celestialObject = new CelestialObject();
            celestialObject.setName(name);
            celestialObjectRepository.save(celestialObject);
        } else {
            throw new RuntimeException("Name is empty");
        }
    }

    public CelestialObject findById(int id) {
        if (id <= 0) {
            throw new RuntimeException("Id cannot be equal or below 0");
        } else {
            if (celestialObjectRepository.findById(id).isPresent()) {
               return celestialObjectRepository.findById(id).get();
            }
            throw new RuntimeException("CelestialObject with id:"+id+" not found");
        }
    }

    public List<CelestialObject> findAll() {
        return (List<CelestialObject>) celestialObjectRepository.findAll();
    }

    public CelestialObject findByName(String name) {
        if (!name.isEmpty()) {
            return celestialObjectRepository.findByName(name);
        }
        throw new RuntimeException("Name is empty");
    }
}
