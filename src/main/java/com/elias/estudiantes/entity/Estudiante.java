package com.elias.estudiantes.entity;

import jakarta.persistence.*;

@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String correo;
    private int edad;

    // Constructor vacío obligatorio para JPA
    public Estudiante() {
    }

    // Constructor con argumentos
    public Estudiante(Long id, String nombre, String correo, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.edad = edad;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public int getEdad() {
        return edad;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
