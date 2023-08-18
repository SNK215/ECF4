package com.example.ecf4.ObservationService;

import com.example.ecf4.exception.InvalidDateFormatException;
import com.example.ecf4.exception.InvalidIdException;
import com.example.ecf4.repository.ObservationRepository;
import com.example.ecf4.service.ObservationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FindByDateTest {

    @InjectMocks
    private ObservationService observationService;

    @Test
    void testShouldThrowExceptionIfInvalidDateFormat() {
        Assertions.assertThrowsExactly(InvalidDateFormatException.class, ()-> {
            observationService.findByDate("17-08-2023");
        });
    }
}
