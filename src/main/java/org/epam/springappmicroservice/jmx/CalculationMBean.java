package org.epam.springappmicroservice.jmx;

import lombok.extern.slf4j.Slf4j;
import org.epam.springappmicroservice.event.GenericEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Service
@ManagedResource
public class CalculationMBean {

    private final AtomicLong counter = new AtomicLong(0);

    @EventListener
    public void handleSuccessful(GenericEvent<String> event) {
        log.info("Event recieved");
        counter.incrementAndGet();
    }

    @ManagedAttribute
    public long getLogarithmRequestCount() {
        return counter.get();
    }

}
