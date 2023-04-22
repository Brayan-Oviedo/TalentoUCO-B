package co.talento.uco.parqueadero.adaptador.repositorio;

import co.talento.uco.parqueadero.adaptador.entidad.EntidadParqueadero;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioParqueaderoJpa extends JpaRepository<EntidadParqueadero, Long> {

    EntidadParqueadero findByid(Long id);
}
