package com.utp.utpinder.model;

import javax.validation.constraints.Email;
import java.util.regex.Pattern;
import java.util.Date;

public class EmailUtp {
    private String to;
    private String subject;
    private String body;
    private Date expirationDate;

    public EmailUtp() {
    }

    public EmailUtp(String to, String subject, String body, Date expirationDate) {
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.expirationDate = expirationDate;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}