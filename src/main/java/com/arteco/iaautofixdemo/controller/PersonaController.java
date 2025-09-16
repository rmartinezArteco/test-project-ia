```java
package com.arteco.iaautofixdemo.controller;

import com.arteco.iaautofixdemo.model.Persona;
import com.arteco.iaautofixdemo.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    private final PersonaService personaService;

    @Autowired
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @Secured("ROLE_ADMINISTRADOR")
    @GetMapping
    public List<Persona> listarPersonas() {
        return personaService.listarTodas();
    }

    @Secured("ROLE_ADMINISTRADOR")
    @PostMapping
    public ResponseEntity<Persona> añadirPersona(@RequestBody Persona persona) {
        Persona nuevaPersona = personaService.guardar(persona);
        return ResponseEntity.ok(nuevaPersona);
    }

    @Secured("ROLE_ADMINISTRADOR")
    @PutMapping("/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable Long id, @RequestBody Persona persona) {
        Persona personaActualizada = personaService.actualizar(id, persona);
        return ResponseEntity.ok(personaActualizada);
    }

    @Secured("ROLE_ADMINISTRADOR")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarPersona(@PathVariable Long id) {
        personaService.borrar(id);
        return ResponseEntity.noContent().build();
    }
}
```