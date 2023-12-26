package com.utp.utpinder.controller;

import com.utp.utpinder.services.EmailService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email1")
public class EmailController1 {
    @Autowired
    private EmailService1 emailService;
    @GetMapping("/enviar1")
    void sendEmail(){
        emailService.sendemail();
    }
}
