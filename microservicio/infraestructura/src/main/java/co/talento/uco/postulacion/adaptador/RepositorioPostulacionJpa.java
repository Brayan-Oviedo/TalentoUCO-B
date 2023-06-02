package co.talento.uco.postulacion.adaptador;

import co.talento.uco.oferta.entidad.EntidadOferta;
import co.talento.uco.postulacion.entidad.EntidadPostulacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RepositorioPostulacionJpa extends JpaRepository<EntidadPostulacion, Long> {

    List<EntidadPostulacion> findByOferta(EntidadOferta entidadOferta);

}
