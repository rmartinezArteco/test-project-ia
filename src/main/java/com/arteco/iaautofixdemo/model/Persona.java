package com.arteco.iaautofixdemo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Persona {
    private Long id;
    private String nombre;
    private String apellidos;
    private String dni;
    private int edad; // Nuevo atributo agregado
}
