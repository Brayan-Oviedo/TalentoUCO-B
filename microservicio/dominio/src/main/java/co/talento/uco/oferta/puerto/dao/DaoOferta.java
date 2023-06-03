package co.talento.uco.oferta.puerto.dao;

import co.talento.uco.oferta.modelo.dtoRespuesta.RespuestaOferta;

import java.util.List;

public interface DaoOferta {

    RespuestaOferta consultarOferta(Long id);

    List<RespuestaOferta> consultarOfertalista();
}
