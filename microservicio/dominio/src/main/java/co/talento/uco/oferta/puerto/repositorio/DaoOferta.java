package co.talento.uco.oferta.puerto.repositorio;

import co.talento.uco.oferta.modelo.dtoRespuesta.RespuestaOferta;

public interface DaoOferta {
    RespuestaOferta consultarOferta(Long id);
}
