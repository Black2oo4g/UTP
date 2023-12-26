package com.utp.utpinder.controller;
import com.utp.utpinder.model.EmailUtp;
import com.utp.utpinder.services.EmailService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/enviar")
    void sendVerificationEmail(@RequestParam("to") String toEmail) {
        String securityCode = emailService.generateSecurityCode();
        Map<String, Object> model = Map.of("welcomeMessage", "¡Bienvenido al sistema de verificación de autenticidad para alumnos de la UTP!",
                "appDescription", "Esta aplicación ha sido desarrollada por un alumno de la UTP con el propósito de implementar una red social exclusiva para estudiantes que forman parte de la Universidad Tecnológica del Perú.",
                "codeofsecurity", "Código de verificación: " + securityCode);
        EmailUtp email = emailService.createEmail(toEmail, "Verificación de autenticidad alumno UTP", model);
        emailService.sendEmail(email);
    }
}
