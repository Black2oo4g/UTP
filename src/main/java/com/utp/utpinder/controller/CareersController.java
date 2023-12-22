package com.utp.utpinder.controller;

import com.utp.utpinder.model.Careers;
import com.utp.utpinder.services.CareersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/careers")
public class CareersController {

    @Autowired
    private CareersService careersService;

    @GetMapping("/all")
    public ArrayList<Careers> getAllCareers() {
        return careersService.getAllcareers();
    }
}
