```java
package com.arteco.iaautofixdemo.service;

import com.arteco.iaautofixdemo.entity.Persona;
import com.arteco.iaautofixdemo.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    @Autowired
    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    public Optional<Persona> getPersonaById(Long id) {
        return personaRepository.findById(id);
    }

    public Persona addPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public Persona updatePersona(Long id, Persona personaDetails) {
        Optional<Persona> personaOptional = personaRepository.findById(id);
        if (personaOptional.isPresent()) {
            Persona personaToUpdate = personaOptional.get();
            personaToUpdate.setNombre(personaDetails.getNombre());
            personaToUpdate.setApellido(personaDetails.getApellido());
            personaToUpdate.setDireccion(personaDetails.getDireccion());
            return personaRepository.save(personaToUpdate);
        } else {
            throw new RuntimeException("Persona not found with id " + id);
        }
    }

    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }
}
```