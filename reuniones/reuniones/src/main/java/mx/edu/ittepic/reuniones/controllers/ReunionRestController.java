package mx.edu.ittepic.reuniones.controllers;

import mx.edu.ittepic.reuniones.models.Reunion;
import mx.edu.ittepic.reuniones.services.ReunionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reuniones")
public class ReunionRestController {

    private ReunionService reunionService;

    public ReunionRestController(ReunionService reunionService) {
        this.reunionService = reunionService;
    }

    @GetMapping
    public List<Reunion> getAllReuniones() {
        return reunionService.getAllReuniones();
    }
}
