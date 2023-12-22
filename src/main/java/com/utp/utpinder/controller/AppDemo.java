package com.utp.utpinder.controller;


import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@PropertySource("classpath:application.properties")
public class AppDemo {
    @GetMapping("/Saludo")
    public String hello() {
        return "Hello World";
    }




}
