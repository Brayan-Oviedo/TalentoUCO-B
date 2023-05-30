package co.talento.uco.oferta.puerto.repositorio;

import co.talento.uco.oferta.modelo.dominio.Oferta;
import co.talento.uco.oferta.modelo.dtoRespuesta.RespuestaOferta;
import co.talento.uco.postulacion.modelo.dominio.Postulacion;

public interface RepositorioOferta {

    Long guardar(Oferta oferta);

    boolean eliminarPorId(Long id);

    RespuestaOferta consultarOferta(Long id);

    boolean guardarPostulacion(Postulacion postulacion, Long idOferta);

}
