package com.utp.utpinder.services;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.apache.commons.lang3.RandomStringUtils;


@Service
public class EmailService1 {
    private final static String MY_EMAIL = "U21304958@utp.edu.pe";
    @Autowired
    private AmazonSimpleEmailServiceClient client;
    @Autowired
    private TemplateEngine templateEngine;
    public void sendemail(){
        // Genera un código de seguridad aleatorio
        String SecurityCode = RandomStringUtils.randomNumeric(6);
        //Mensajes del correo
        String welcomeMessage = "¡Bienvenido al sistema de verificación de autenticidad para alumnos de la UTP!";
        String appDescription = "Esta aplicación ha sido desarrollada por un alumno de la UTP con el propósito de implementar una red social exclusiva para estudiantes que forman parte de la Universidad Tecnológica del Perú.";
        String codeofsecurity = "Codigo de verificación: ";
        // Crea un objeto Message y asigna el asunto y el cuerpo
        Destination destination = new Destination();
        destination.withToAddresses("navarrogianfranco9@gmail.com");

        Message message = new Message()
                .withSubject(new Content("Verificación de autenticidad alumno UTP"))
                .withBody(new Body().withHtml(new Content().withData(
                        "<p>" + welcomeMessage + "</p>" +
                        "<p>" + appDescription + "</p>" +
                         "<p>" + codeofsecurity + SecurityCode)));
        SendEmailRequest emailRequest = new SendEmailRequest();
        emailRequest.withSource(MY_EMAIL)
                .withDestination(destination)
                .withMessage(message);
        client.sendEmail(emailRequest);
    }
}
