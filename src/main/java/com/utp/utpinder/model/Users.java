package com.utp.utpinder.model;
import jakarta.persistence.*;
@Entity
@Table(name = "users")
public class Users {
    @Id
    private String dni;
    private String names;
    @Column(name = "last_names")
    private String last_names;
    private String mailutp;
    private String password;
    private int age;
    private String photo;
    private int career_id;
    private int cycle;
    private int sede_id;
    private Status status;

    public Users() {}

    // Constructor con los campos relevantes
    public Users(String dni, String names, String last_names, String mailutp, String password, int age, int career_id, int cycle, int sede_id, Status status) {
        this.dni = dni;
        this.names = names;
        this.last_names = last_names;
        this.mailutp = mailutp;
        this.password = password;
        this.age = age;
        this.career_id = career_id;
        this.cycle = cycle;
        this.sede_id = sede_id;
        this.status = status;
    }

    // Getters y setters para todos los atributos
    // ... (Omíto los getters y setters para ahorrar espacio)

    public enum Status {
        ACTIVE,
        INACTIVE
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLast_names() {
        return last_names;
    }

    public void setLast_names(String last_names) {
        this.last_names = last_names;
    }

    public String getMailutp() {
        return mailutp;
    }

    public void setMailutp(String mailutp) {
        this.mailutp = mailutp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getCareer_id() {
        return career_id;
    }

    public void setCareer_id(int career_id) {
        this.career_id = career_id;
    }

    public int getCycle() {
        return cycle;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    public int getSede_id() {
        return sede_id;
    }

    public void setSede_id(int sede_id) {
        this.sede_id = sede_id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
