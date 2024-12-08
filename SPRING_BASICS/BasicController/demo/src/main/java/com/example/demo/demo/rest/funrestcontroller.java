package com.example.demo.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class funrestcontroller {
    @GetMapping("/")
    public String sayHello()
    {
    return " Hello world";
    }
}
