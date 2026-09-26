package com.example.marque.controllers;

import com.example.marque.Repositories.PersonRepository;
import com.example.marque.enteties.Person;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public Person crear(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @GetMapping
    public List<Person> listar() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public Person buscar(@PathVariable Long id) {
        return personRepository.findById(id)
                .orElse(null);
    }

    @PutMapping("/{id}")
    public Person actualizar(
            @PathVariable Long id,
            @RequestBody Person datos) {

        Person person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        person.setNombre(datos.getNombre());
        person.setApellido(datos.getApellido());
        person.setEdad(datos.getEdad());
        person.setCorreo(datos.getCorreo());

        return personRepository.save(person);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        personRepository.deleteById(id);
        return "Persona eliminada correctamente";
    }
}