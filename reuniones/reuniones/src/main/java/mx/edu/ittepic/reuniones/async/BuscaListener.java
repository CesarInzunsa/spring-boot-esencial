package mx.edu.ittepic.reuniones.async;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mx.edu.ittepic.reuniones.models.Persona;
import mx.edu.ittepic.reuniones.models.Reunion;
import mx.edu.ittepic.reuniones.services.PersonaService;
import mx.edu.ittepic.reuniones.services.ReunionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BuscaListener {
    private static final Logger logger = LoggerFactory.getLogger(BuscaListener.class);

    private final ObjectMapper mapper;
    private final PersonaService personaService;
    private final ReunionService reunionService;

    public BuscaListener(ObjectMapper mapper, PersonaService personaService, ReunionService reunionService) {
        this.mapper = mapper;
        this.personaService = personaService;
        this.reunionService = reunionService;
    }

    public void recibirMensaje(String mensaje) {
        try {
            InfoBusca info = mapper.readValue(mensaje, InfoBusca.class);
            Optional<Persona> persona = personaService.getById(info.getIdAsistente());
            if (persona.isEmpty()) {
                logger.warn("Persona no encontrada", info.getIdAsistente());
                return;
            }
            Optional<Reunion> reunion = reunionService.getById(info.getIdReunion());
            if (reunion.isEmpty()) {
                logger.warn("Reunion no encontrada", info.getIdReunion());
                return;
            }
            if (persona.isPresent() && reunion.isPresent()) {
                logger.info("{} {} tiene una reunion a las {}",
                        persona.get().getNombre(), persona.get().getApellidos(), reunion.get().getFecha()
                );
            }
        } catch (JsonProcessingException e) {
            logger.warn("Mensaje incorrecto", e);
        }
    }
}
