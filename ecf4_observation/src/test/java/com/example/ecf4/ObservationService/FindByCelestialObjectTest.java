package com.example.ecf4.ObservationService;

import com.example.ecf4.exception.InvalidCelestialObjectException;
import com.example.ecf4.repository.ObservationRepository;
import com.example.ecf4.service.ObservationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FindByCelestialObjectTest {

    @InjectMocks
    private ObservationService observationService;

    @Test
    void testShouldThrowExceptionIfInvalidName() {
        Assertions.assertThrowsExactly(InvalidCelestialObjectException.class, () -> {
            observationService.findByCelestialObject("wrongName");
        });
    }

    @Test
    void testShouldThrowExceptionIfEmptyName() {
        Assertions.assertThrowsExactly(InvalidCelestialObjectException.class, () -> {
            observationService.findByCelestialObject("");
        });
    }


}
