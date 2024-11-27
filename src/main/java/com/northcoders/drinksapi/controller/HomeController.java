package com.northcoders.drinksapi.controller;

import com.northcoders.drinksapi.model.Coffee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private int coffeeId = 0;

    @GetMapping("/")
    public String home() {
        return "Welcome to the Drinks API!";
    }

    @GetMapping("/coffeelover")
    public String coffeeLover() {
        return "I like coffee!";
    }

    @GetMapping("/coffee")
    public ResponseEntity<Coffee> coffee(@RequestParam(value = "name",
            defaultValue = "latte") String name) {
        Coffee coffee = new Coffee(coffeeId++, name);
        return new ResponseEntity<>(coffee, HttpStatus.OK);
    }

}
