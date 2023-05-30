package co.talento.uco.oferta.puerto.dao;

import co.talento.uco.oferta.modelo.dtoRespuesta.RespuestaOferta;

public interface DaoOferta {

    RespuestaOferta consultarOferta(Long id);
}
