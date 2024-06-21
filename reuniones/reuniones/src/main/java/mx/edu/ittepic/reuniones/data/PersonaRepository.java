package mx.edu.ittepic.reuniones.data;

import mx.edu.ittepic.reuniones.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "personas")
public interface PersonaRepository extends JpaRepository<Persona, Long> {


}
