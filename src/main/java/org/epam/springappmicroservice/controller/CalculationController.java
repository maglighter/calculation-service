package org.epam.springappmicroservice.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.epam.springappmicroservice.model.CalculationResponse;
import org.epam.springappmicroservice.service.CalculationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/calculation")
@RequiredArgsConstructor
public class CalculationController {

    private final CalculationService calculationService;

    @GetMapping("/logarithm")
    @ApiOperation(value = "Calculate logarithm by providing number and base (optional)")
    public CalculationResponse calculate(@RequestParam(value = "number") Double num,
                                         @RequestParam(value = "base", required = false, defaultValue = "2") Double base) {
        log.info("calculating logarithm of {} and base {}", num, base);
        Double result = calculationService.logarithm(num, base);
        return CalculationResponse.builder()
                .result(result)
                .build();
    }

}
