package co.talento.uco.postulacion.puerto.repositorio;

import co.talento.uco.oferta.modelo.dtoRespuesta.RespuestaOferta;
import co.talento.uco.postulacion.modelo.dominio.Postulacion;

public interface RepositorioPostulacion {

    public Long guardarPostulacion(RespuestaOferta respuestaOferta);

}
