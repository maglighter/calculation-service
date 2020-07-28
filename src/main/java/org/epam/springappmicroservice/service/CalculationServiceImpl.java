package org.epam.springappmicroservice.service;

import org.springframework.stereotype.Service;

@Service
public class CalculationServiceImpl implements CalculationService {

    @Override
    public Double logarithm(Double num, Double base) {
        return Math.log(num) / Math.log(base);
    }

}
