package com.utp.utpinder.model;

import jakarta.persistence.*;

@Entity
@Table(name = "careers")
public class Careers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  long id;
    private String careers;

    public Careers(){

    }

    public Careers(String careers) {
        this.careers = careers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCareers() {
        return careers;
    }

    public void setCareers(String careers) {
        this.careers = careers;
    }
}
