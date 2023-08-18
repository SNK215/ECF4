package com.example.ecf4_celestialobject.controller;

import com.example.ecf4_celestialobject.entity.CelestialObject;
import com.example.ecf4_celestialobject.service.CelestialObjectService;
import jdk.jfr.Threshold;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/celestialObject")
public class CelestialObjectController {

    @Autowired
    CelestialObjectService celestialObjectService;

    @PostMapping("/create")
    public ResponseEntity create(@RequestParam String name) {
        celestialObjectService.create(name);
        return ResponseEntity.ok("CelestialObject created");
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        CelestialObject celestialObject = celestialObjectService.findById(id);
        return ResponseEntity.ok(celestialObject);
    }

    @GetMapping("/all")
    public ResponseEntity findAll() {
        List<CelestialObject> celestialObjectList = celestialObjectService.findAll();
        return ResponseEntity.ok(celestialObjectList);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity findByName(@PathVariable String name) {
        CelestialObject celestialObject = celestialObjectService.findByName(name);
        return ResponseEntity.ok(celestialObject);
    }
}
