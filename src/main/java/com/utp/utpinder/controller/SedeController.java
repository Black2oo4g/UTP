package com.utp.utpinder.controller;

import com.utp.utpinder.model.Sede;
import com.utp.utpinder.services.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/sede")
public class SedeController {

    @Autowired
    private SedeService sedeService;

    @GetMapping("/all")
    public ArrayList<Sede> getAllCampus(){return sedeService.getAllCampus();}
}
