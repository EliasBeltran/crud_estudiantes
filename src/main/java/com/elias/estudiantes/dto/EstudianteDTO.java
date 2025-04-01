package com.elias.estudiantes.dto;

import lombok.Data;

@Data
public class EstudianteDTO {
    private String nombre;
    private String correo;
    private int edad;

    // Getters
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
