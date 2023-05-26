package co.talento.uco.usuario.comando.manejador;

import co.talento.uco.usuario.comando.SolicitudUsuarioTransaccion;
import co.talento.uco.usuario.comando.fabrica.FabricaUsuario;
import co.talento.uco.usuario.servicio.ServicioGuardarUsuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorGuardarUsuario {

    private final ServicioGuardarUsuario servicioGuardarUsuario;
    private final FabricaUsuario fabricaUsuario;


    public ManejadorGuardarUsuario(ServicioGuardarUsuario servicioGuardarUsuario, FabricaUsuario fabricaUsuario) {
        this.servicioGuardarUsuario = servicioGuardarUsuario;
        this.fabricaUsuario = fabricaUsuario;
    }

    public boolean ejecutar(SolicitudUsuarioTransaccion solicitudUsuarioTransaccion) {
        var usuario = this.fabricaUsuario.crear(solicitudUsuarioTransaccion);
        return this.servicioGuardarUsuario.ejecutar(usuario);
    }
}
