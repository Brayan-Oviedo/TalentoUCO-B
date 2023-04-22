package co.talento.uco.usuario.puerto.dao;

import co.talento.uco.usuario.modelo.dtoRespuesta.RespuestaUsuario;

public interface DaoUsuario {

    RespuestaUsuario obtenerUsuarioPorNombreDeUsuario(String nombreUsuario);
}
