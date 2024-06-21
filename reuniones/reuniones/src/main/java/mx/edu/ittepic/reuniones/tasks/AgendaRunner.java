package mx.edu.ittepic.reuniones.tasks;

import mx.edu.ittepic.reuniones.services.ReunionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@Order(2)
public class AgendaRunner implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(AgendaRunner.class);

    @Autowired
    private ReunionService reunionService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("Lista de reuniones");
        reunionService.getAllReuniones().forEach(reunion -> {
            logger.info(reunion.toString());
        });
        logger.info("Fin de la lista de reuniones");
    }
}
