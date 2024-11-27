package com.northcoders.drinksapi.controller;

import com.northcoders.drinksapi.service.TeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeaController {

    @Autowired
    private TeaService teaService;


}
