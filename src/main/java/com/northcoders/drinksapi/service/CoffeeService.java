package com.northcoders.drinksapi.service;

import com.northcoders.drinksapi.model.Coffee;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class CoffeeService {
    private AtomicLong coffeeId = new AtomicLong();

    public Coffee makeCoffee(String name) {
        return new Coffee(coffeeId.incrementAndGet(), name);
    }

}
