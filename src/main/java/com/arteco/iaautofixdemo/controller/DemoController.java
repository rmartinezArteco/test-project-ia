package com.arteco.iaautofixdemo.controller;

import com.arteco.iaautofixdemo.model.Persona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @PostMapping("/getNombre")
    public String getNombre(@RequestBody Persona persona) {
        return "La persona con nombre " + persona.getNombre() + " tiene la edad de " + persona.getEdad() + " años."
    }
}
