package com.example.ecf4.dto;

import com.example.ecf4.entity.Observation;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ObservationResponseDto {
    private List<Observation> observationList;
    private CelestialObjectResponseDto celestialObjectResponseDto;
}
