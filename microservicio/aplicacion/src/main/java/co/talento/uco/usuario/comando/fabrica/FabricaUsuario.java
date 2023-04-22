package co.talento.uco.usuario.comando.fabrica;


import co.talento.uco.usuario.comando.RequestUsuarioTransaccion;
import co.talento.uco.usuario.modelo.dominio.Usuario;
import co.talento.uco.usuario.modelo.dtoRespuesta.RespuestaUsuario;
import org.springframework.stereotype.Component;

@Component
public class FabricaUsuario {

    public Usuario crear(RequestUsuarioTransaccion requestUsuarioTransaccion) {
        return new Usuario(
                requestUsuarioTransaccion.getNombreUsuario(),
                requestUsuarioTransaccion.getContrasena(),
                requestUsuarioTransaccion.getRoles()
        );
    }

    public Usuario crear(RespuestaUsuario respuestaUsuario) {
        return new Usuario(
                respuestaUsuario.getNombreUsuario(),
                respuestaUsuario.getContrasena(),
                respuestaUsuario.getRoles()
        );
    }
}
