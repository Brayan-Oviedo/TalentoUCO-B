package co.talento.uco.usuario.adaptador;

import co.talento.uco.usuario.model.UsuarioDetalle;
import co.talento.uco.rol.adaptador.MapperRol;
import co.talento.uco.usuario.modelo.dtoRespuesta.RespuestaUsuario;
import org.springframework.stereotype.Component;

@Component
public class MapperUsuarioDetalles {

    private final MapperRol mapperRol;

    public MapperUsuarioDetalles(MapperRol mapperRol) {
        this.mapperRol = mapperRol;
    }

    public UsuarioDetalle crearModelo(RespuestaUsuario respuestaUsuario) {
        return new UsuarioDetalle(
               respuestaUsuario.getNombreUsuario(),
               respuestaUsuario.getContrasena(),
               this.mapperRol.crearAutoridades(respuestaUsuario.getRoles())
        );
    }
}
