package co.talento.uco.postulacion.puerto.dao;

import co.talento.uco.oferta.modelo.dominio.Oferta;
import co.talento.uco.postulacion.modelo.respuesta.RespuestaPostulacion;

import java.util.List;

public interface DaoPostulacion {

    List<RespuestaPostulacion> obtenerPorOferta(Oferta oferta);
}
