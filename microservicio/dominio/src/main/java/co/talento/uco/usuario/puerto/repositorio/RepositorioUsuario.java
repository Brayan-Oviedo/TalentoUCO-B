package co.talento.uco.usuario.puerto.repositorio;

import co.talento.uco.usuario.modelo.dominio.Usuario;

public interface RepositorioUsuario {

    boolean existePorNombreUsuario(String nombreUsuario);
    boolean guardarUsuario(Usuario usuario);
}
