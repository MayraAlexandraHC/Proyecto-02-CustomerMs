package com.bank.CustomerMs.model;

import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {
    private Integer id;
    private String name;
    private String lastname;
    private String dni;
    private String email;

    // Constructor
    public Client(String name, String lastname, String dni, String email){
        //Restricciones para los datos a ingresar.
        if (name.matches("^[a-zA-Z]{1,20}$") && lastname.matches("^[a-zA-Z]{1,20}$")) {
            if (!isCorrectDNI(dni)) {
                System.out.println("Por favor, ingrese un DNI válido.");
                return;
            }
            if (!isCorrectEmail(email)) {
                System.out.println("Por favor, ingrese un correo válido.");
                return;
            }
            this.name = name;
            this.lastname = lastname;
            this.dni = dni;
            this.email = email;
        } else {
            System.out.println("Por favor, llenar todos los campos según corresponda.");
            return;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if(isCorrectDNI(dni)) this.dni = dni;
        else System.out.println("Por favor, ingrese un DNI válido.");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(isCorrectEmail(email)) this.email = email;
        else System.out.println("Por favor, ingrese un correo válido.");
    }

    //Metodo para validar el formato del correo.
    private boolean isCorrectEmail(String email) {
        String emailModel = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return email.matches(emailModel);
    }

    //Metodo para validar el formato del DNI (Se consideran 8 dígitos, tal y como es un DNI en Perú).
    private boolean isCorrectDNI(String dni) {
        String dniModel = "^[0-9]{8}$";
        return dni.matches(dniModel);
    }
}