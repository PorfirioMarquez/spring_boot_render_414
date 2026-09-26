package com.example.marque.Service;

import com.example.marque.enteties.Person;
import com.example.marque.Repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // GET - Obtener todas las personas
    public List<Person> listarPersonas() {
        return personRepository.findAll();
    }

    // GET - Obtener persona por ID
    public Optional<Person> buscarPorId(Long id) {
        return personRepository.findById(id);
    }

    // POST - Guardar persona
    public Person guardarPersona(Person person) {
        return personRepository.save(person);
    }

    // DELETE - Eliminar persona
    public void eliminarPersona(Long id) {
        personRepository.deleteById(id);
    }

    // Verificar si existe
    public boolean existePersona(Long id) {
        return personRepository.existsById(id);
    }
}
