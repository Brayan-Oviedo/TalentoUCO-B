package co.talento.uco.oferta.adaptador;

import co.talento.uco.oferta.entidad.EntidadOferta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioOfertaJpa extends JpaRepository<EntidadOferta,Long> {


}
