package co.talento.uco.contacto.adaptador;


import co.talento.uco.contacto.entidad.EntidadContacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioContactoJpa extends JpaRepository<EntidadContacto, Long> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM talentouco.contacto where correo== :correo")

    List<EntidadContacto> BuscarCorreo(@Param("correo") String correo);

    List<EntidadContacto> findAllByCorreo(String name);
}
