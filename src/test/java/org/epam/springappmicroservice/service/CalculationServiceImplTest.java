package org.epam.springappmicroservice.service;

import org.epam.springappmicroservice.configuration.Journal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@ExtendWith(MockitoExtension.class)
class CalculationServiceImplTest {

    @Mock
    Journal journal;

    @Mock
    ApplicationEventPublisher applicationEventPublisher;

    @InjectMocks
    CalculationServiceImpl calculationService;

    @Test
    void logarithm() {
        Double actual = calculationService.logarithm(4.0, 2.0);
        assertEquals("wrong actual value", 2.0, actual);
        actual = calculationService.logarithm(0.0, 0.0);
        assertTrue("logarithm should be NaN", Double.isNaN(actual));
    }
}