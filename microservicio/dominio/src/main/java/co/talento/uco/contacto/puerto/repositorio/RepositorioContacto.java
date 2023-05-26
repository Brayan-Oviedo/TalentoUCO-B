package co.talento.uco.contacto.puerto.repositorio;

import co.talento.uco.contacto.modelo.dominio.Contacto;
import co.talento.uco.contacto.modelo.dtoRespuesta.RespuestaContacto;

public interface RepositorioContacto {
    RespuestaContacto guardar(Contacto contacto);

    boolean actualizar(Contacto contacto);

    boolean existeCorreo(Contacto contacto);

    boolean eliminarPorId(Long id);

    boolean existePorId(Long id);
}
