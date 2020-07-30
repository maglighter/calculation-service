package org.epam.springappmicroservice.event;

public class CalculationEvent extends GenericEvent<String> {

    public CalculationEvent(String what, boolean success) {
        super(what, success);
    }

}
