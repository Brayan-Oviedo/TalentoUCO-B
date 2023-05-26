package co.talento.uco.auth.controlador;

import co.talento.uco.auth.adaptador.Auth;
import co.talento.uco.jwToken.modelo.dto.RespuestaJwToken;
import co.talento.uco.usuario.comando.SolicitudUsuarioTransaccion;
import co.talento.uco.usuario.comando.fabrica.FabricaUsuario;
import co.talento.uco.usuario.comando.manejador.ManejadorGuardarUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class ControladorAuthTransaccion {

    private final Auth auth;
    private final FabricaUsuario fabricaUsuario;
    private final ManejadorGuardarUsuario manejadorGuardarUsuario;


    @Autowired
    public ControladorAuthTransaccion(Auth auth, FabricaUsuario fabricaUsuario, ManejadorGuardarUsuario manejadorGuardarUsuario) {
        this.auth = auth;
        this.fabricaUsuario = fabricaUsuario;
        this.manejadorGuardarUsuario = manejadorGuardarUsuario;

    }

    @PutMapping
    public RespuestaJwToken ingresarUsuario(@RequestBody SolicitudUsuarioTransaccion solicitudUsuarioTransaccion){
        var usuario = this.fabricaUsuario.crear(solicitudUsuarioTransaccion);
        return this.auth.login(usuario);
    }

    @PostMapping
    public boolean registrarUsuario(@RequestBody SolicitudUsuarioTransaccion solicitudUsuarioTransaccion) {
        return this.manejadorGuardarUsuario.ejecutar(solicitudUsuarioTransaccion);
    }

}
