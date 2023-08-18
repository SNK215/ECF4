package com.example.ecf4_celestialobject.repository;

import com.example.ecf4_celestialobject.entity.CelestialObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CelestialObjectRepository extends CrudRepository<CelestialObject,Integer> {

    public CelestialObject findByName(String name);
}
