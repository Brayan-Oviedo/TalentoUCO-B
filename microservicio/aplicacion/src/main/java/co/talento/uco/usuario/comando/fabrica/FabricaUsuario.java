package co.talento.uco.usuario.comando.fabrica;


import co.talento.uco.usuario.comando.SolicitudUsuarioTransaccion;
import co.talento.uco.usuario.modelo.dominio.Usuario;
import co.talento.uco.usuario.modelo.dtoRespuesta.RespuestaUsuario;
import org.springframework.stereotype.Component;

@Component
public class FabricaUsuario {

    public Usuario crear(SolicitudUsuarioTransaccion solicitudUsuarioTransaccion) {
        return new Usuario(
                solicitudUsuarioTransaccion.getNombreUsuario(),
                solicitudUsuarioTransaccion.getContrasena(),
                solicitudUsuarioTransaccion.getRoles()
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
