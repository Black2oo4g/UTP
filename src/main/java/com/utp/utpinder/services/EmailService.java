package com.utp.utpinder.services;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.utp.utpinder.model.EmailUtp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.RandomStringUtils;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.IContext;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;



import java.util.Date;
import java.lang.*;
import java.util.Map;

import static java.lang.System.currentTimeMillis;

@Service
public class EmailService {
    private final static String MY_EMAIL = "U21304958@utp.edu.pe";
    @Autowired
    private AmazonSimpleEmailServiceClient client;
    @Autowired
    private TemplateEngine templateEngine;
    private Date expirationDate;

    public String generateSecurityCode() {
        // ...

        // Verifica que la fecha de expiración no haya caducado
        Date now = new Date();
        if (expirationDate != null && now.after(expirationDate)) {
            // El código de verificación ha caducado
            return null;
        }

        return RandomStringUtils.randomNumeric(6);
    }

    public EmailUtp createEmail(String to, String subject, Map<String, Object> templateModel) {
        // Crea el cuerpo del correo usando Thymeleaf
        Context context = new Context();
        context.setVariables(templateModel);
        String body = templateEngine.process("emailTemplate", context);
        return new EmailUtp(to, subject, body, calculateExpirationDate());
    }


    private Date calculateExpirationDate() {
        // Calcula y devuelve la fecha de expiración
        return new Date(System.currentTimeMillis() + 300000); // 5 minutos de expiración
    }


    public void sendEmail(EmailUtp email) {
        try {
            // Crea un objeto Message y asigna el asunto y el cuerpo
            Message message = new Message()
                    .withSubject(new Content(email.getSubject()))
                    .withBody(new Body().withHtml(new Content(email.getBody())));

            // Crea un objeto Destination y asigna la dirección de correo electrónico del destinatario
            Destination destination = new Destination().withToAddresses(email.getTo());

            // Crea un objeto SendEmailRequest y asigna el remitente, el destinatario y el mensaje
            SendEmailRequest request = new SendEmailRequest()
                    .withSource(MY_EMAIL)
                    .withDestination(destination)
                    .withMessage(message);

            // Envía el correo electrónico usando Amazon SES
            client.sendEmail(request);

        } catch (Exception ex) {
            // Maneja los errores de envío de correo electrónico
            System.err.println("Error al enviar correo electrónico: " + ex.getMessage());
            // Puedes implementar lógica adicional para notificar a los administradores o registrar el error en un log
        }
    }

}
