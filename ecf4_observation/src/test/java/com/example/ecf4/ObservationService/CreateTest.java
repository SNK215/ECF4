package com.example.ecf4.ObservationService;

import com.example.ecf4.exception.InvalidCelestialObjectException;
import com.example.ecf4.exception.InvalidParamException;
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
public class CreateTest {

    @InjectMocks
    private ObservationService observationService;

    @Test
    void testShouldThrowExceptionIfInvalidDescription() {
        Assertions.assertThrowsExactly(InvalidParamException.class, () -> {
            observationService.create("","test",1);
        });
    }

    @Test
    void testShouldThrowExceptionIfInvalidPhotoUrl() {
        Assertions.assertThrowsExactly(InvalidParamException.class, () -> {
            observationService.create("test","",1);
        });
    }

    @Test
    void testShouldThrowExceptionIfInvalidCelestialObjectId() {
        Assertions.assertThrowsExactly(InvalidParamException.class, () -> {
            observationService.create("test","test",0);
        });
    }

    @Test
    void testShouldThrowExceptionIfInvalidCelestialObjectId2() {
        Assertions.assertThrowsExactly(InvalidParamException.class, () -> {
            observationService.create("test","test",-1);
        });
    }
}
