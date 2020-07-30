package org.epam.springappmicroservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.epam.springappmicroservice.configuration.Journal;
import org.epam.springappmicroservice.event.CalculationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CalculationServiceImpl implements CalculationService {

    private final ApplicationEventPublisher applicationEventPublisher;

    private final Journal journal;

    @Override
    public Double logarithm(Double num, Double base) {
        if (base > 10) {
            publishEvent(new CalculationEvent("logarithm_event", true));
        }
        journal.log("logarithm of " + num);
        return Math.log(num) / Math.log(base);
    }

    public void publishEvent(final CalculationEvent event) {
        log.info("Publishing custom event.");
        applicationEventPublisher.publishEvent(event);
    }

}
