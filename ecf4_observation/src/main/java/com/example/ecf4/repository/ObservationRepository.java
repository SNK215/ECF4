package com.example.ecf4.repository;

import com.example.ecf4.entity.Observation;
import org.springframework.cglib.core.Local;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ObservationRepository extends CrudRepository<Observation,Integer> {
    public List<Observation> findAllByDate(LocalDate date);
}
