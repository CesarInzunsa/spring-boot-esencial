package mx.edu.ittepic.reuniones.services;

import mx.edu.ittepic.reuniones.data.ReunionRepository;
import mx.edu.ittepic.reuniones.models.Persona;
import mx.edu.ittepic.reuniones.models.Reunion;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReunionService {

    private final ReunionRepository reunionRepository;

    public ReunionService(ReunionRepository reunionRepository) {
        this.reunionRepository = reunionRepository;
    }

    public List<Reunion> getAllReuniones() {
        return reunionRepository.findAll();
    }

    public Optional<Reunion> getById(long id) {
        return reunionRepository.findById(id);
    }
}
