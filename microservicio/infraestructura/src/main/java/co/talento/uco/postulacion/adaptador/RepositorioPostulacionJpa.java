package co.talento.uco.postulacion.adaptador;

import co.talento.uco.postulacion.entidad.EntidadPostulacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioPostulacionJpa extends JpaRepository<Long, EntidadPostulacion> {
}
