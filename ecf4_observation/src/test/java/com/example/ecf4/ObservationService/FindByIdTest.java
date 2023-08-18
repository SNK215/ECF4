package com.example.ecf4.ObservationService;

import com.example.ecf4.entity.Observation;
import com.example.ecf4.exception.InvalidIdException;
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
public class FindByIdTest {

    @InjectMocks
    private ObservationService observationService;

    @Test
    void testShouldThrowExceptionIfIdEquals0() {
        Assertions.assertThrowsExactly(InvalidIdException.class, ()-> {
            observationService.findById(0);
        });
    }

    @Test
    void testShouldThrowExceptionIfIdBelow0() {
        Assertions.assertThrowsExactly(InvalidIdException.class, ()-> {
            observationService.findById(-1);
        });
    }

    @Test
    public void whenValidIdObservationShouldBeFound() throws InvalidIdException {
        Observation observation = new Observation();
        observation.setId(1);

        Observation found = observationService.findById(1);

        Assertions.assertEquals(found.getId(),observation.getId());
    }
}
