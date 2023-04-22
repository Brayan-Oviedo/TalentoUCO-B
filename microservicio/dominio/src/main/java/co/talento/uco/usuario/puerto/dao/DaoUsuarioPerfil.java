package co.talento.uco.usuario.puerto.dao;

import co.talento.uco.usuario.modelo.dtoRespuesta.RespuestaUsuarioPerfil;

public interface DaoUsuarioPerfil {

    RespuestaUsuarioPerfil obtenerUsuarioPorNombreDeUsuario(String nombreUsuario);
}
