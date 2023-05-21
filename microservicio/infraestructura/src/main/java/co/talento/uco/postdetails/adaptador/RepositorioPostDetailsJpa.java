package co.talento.uco.postdetails.adaptador;

import co.talento.uco.postdetails.entidad.EntidadPostDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioPostDetailsJpa extends JpaRepository<EntidadPostDetails, String> {


}
