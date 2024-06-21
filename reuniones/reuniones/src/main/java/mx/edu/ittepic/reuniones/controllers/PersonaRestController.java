package mx.edu.ittepic.reuniones.controllers;

import mx.edu.ittepic.reuniones.models.Persona;
import mx.edu.ittepic.reuniones.services.PersonaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/personas")
public class PersonaRestController {

    private PersonaService personaService;

    public PersonaRestController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaService.getAllPersonas();
    }
}