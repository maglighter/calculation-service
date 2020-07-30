package org.epam.springappmicroservice.configuration;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Component
public class Journal {

    private static final org.slf4j.Logger Logger =
            org.slf4j.LoggerFactory.getLogger(Journal.class);

    public void log(String message) {
        // fluentd config filter
        MDC.put("dest", "journal");
        Logger.info(message);
    }
}
