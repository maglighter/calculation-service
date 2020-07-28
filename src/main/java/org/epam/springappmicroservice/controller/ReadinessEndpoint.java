package org.epam.springappmicroservice.controller;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.time.Duration;

@Component
@Endpoint(id="readiness")
public class ReadinessEndpoint {

    public static final Duration MICROSERVICE_READy_TIME = Duration.ofSeconds(60);

    @ReadOperation
    public String readiness() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        Duration uptime = Duration.ofMillis(runtimeMXBean.getUptime());
        if (uptime.toMillis() < MICROSERVICE_READy_TIME.toMillis()) {
            return "DOWN";
        }
        return "UP";
    }

}
