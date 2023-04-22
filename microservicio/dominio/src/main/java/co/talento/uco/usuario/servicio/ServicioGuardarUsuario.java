package co.talento.uco.usuario.servicio;


import co.talento.uco.excepcion.ExcepcionDuplicidad;
import co.talento.uco.usuario.modelo.dominio.Usuario;
import co.talento.uco.usuario.puerto.repositorio.RepositorioUsuario;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarUsuario {

    private static final String EL_USUARIO_S_YA_EXISTE = "El usuario %s ya existe";

    private final RepositorioUsuario repositorioUsuario;

    public ServicioGuardarUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }


    public boolean ejecutar(Usuario usuario) {
        validarExistencia(usuario);
        return this.repositorioUsuario.guardarUsuario(usuario);
    }

    private void validarExistencia(Usuario usuario) {
        if(this.repositorioUsuario.existePorNombreUsuario(usuario.getNombreUsuario())) {
            throw new ExcepcionDuplicidad(String.format(EL_USUARIO_S_YA_EXISTE, usuario.getNombreUsuario()));
        }
    }

}
