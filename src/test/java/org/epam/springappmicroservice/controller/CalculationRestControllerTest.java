package org.epam.springappmicroservice.controller;

import org.epam.springappmicroservice.service.CalculationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@WebMvcTest(controllers = CalculationController.class)
class CalculationRestControllerTest {

    @MockBean
    CalculationService calculationService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetMapping() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculation/logarithm")
                .param("base", "2.0")
                .param("number", "4.0"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"result\":0.0}"));

    }
}
