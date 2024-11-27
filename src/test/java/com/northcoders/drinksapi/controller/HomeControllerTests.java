package com.northcoders.drinksapi.controller;

import com.northcoders.drinksapi.model.Coffee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//package definition omitted for brevity
//The @AutoConfigureMockMvc is an annotation
//It tells the test class to enable and configure auto-configuration of MockMvc.
//MockMvc is the Main entry point for server-side Spring MVC testing
//It is useful because you can test the controller without running the controller within a server
@AutoConfigureMockMvc
@SpringBootTest
public class HomeControllerTests {

    //This @Autowired is part of Spring
    //It enables objects(beans) to be injected at runtime by Spring Dependency Injection mechanism
    @Autowired
    private MockMvc mockMvcController;

    @Test
    public void testGetHome() throws Exception {
        //Arrange, Act and Assert chained within the following statements

        String expectedContent = "Welcome to the Drinks API!";

        this.mockMvcController.perform(
                        //Make a GET request to the '/' endpoint
                        MockMvcRequestBuilders.get("/"))
                //Matchers are helpful methods that help you write your assertions
                //According to the requirement, we expect 200 OK Status Code as a Response
                //According to the requirement, we expect the string as a Response
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }
        @Test
        public void testCoffeeLover() throws Exception {
            //Arrange, Act and Assert chained within the following statements

            String expectedContent = "I like coffee!";

            this.mockMvcController.perform(
                            //Make a GET request to the '/' endpoint
                            MockMvcRequestBuilders.get("/coffeelover"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string(expectedContent));
        }

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