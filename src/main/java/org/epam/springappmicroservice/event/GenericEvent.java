package org.epam.springappmicroservice.event;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenericEvent<T> {

    private T what;

    protected boolean success;

}
