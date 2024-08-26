package com.example.springboot.form.app.models.domain;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Usuario {
    private String uuid; /* campo que no se modifica y se pasa por medio de session*/
    /* @NotEmpty para la validacion, que el valor no sea null */
    @NotEmpty(message = "El nombre no puede estar vacio")  /*mensaje de error*/
    private String name;
    @NotEmpty
    private String last_name;
    @NotEmpty
    @Size(min = 3,max = 8)   /* para string para int es min y max*/
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    @Email    /* validacion de email */
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
