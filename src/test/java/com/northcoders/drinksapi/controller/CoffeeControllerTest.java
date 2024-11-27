package com.northcoders.drinksapi.controller;

import com.northcoders.drinksapi.model.Coffee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
public class CoffeeControllerTest {

    @Autowired
    private MockMvc mockMvcController;


    @Test
    public void testCoffeeLatteCappucino() throws Exception {

        // Arrange
        Coffee latte = new Coffee(0, "latte");
        Coffee cappucino = new Coffee(1, "cappucino");

        // Act 1
        this.mockMvcController.perform(
                        //Make a GET request to the '/' endpoint
                        MockMvcRequestBuilders.get("/coffee"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(latte.name()));

        // Act 2
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/coffee")
                                .param("name", "cappucino"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(cappucino.name()));
    }

}
