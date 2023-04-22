package co.talento.uco.usuario.puerto.repositorio;

import co.talento.uco.usuario.modelo.dominio.UsuarioPerfil;

public interface RepositorioUsuarioPerfil {

    boolean existePorNombreUsuario(String nombreUsuario);
    boolean guardarUsuarioPerfil(UsuarioPerfil usuarioPerfil);
}
