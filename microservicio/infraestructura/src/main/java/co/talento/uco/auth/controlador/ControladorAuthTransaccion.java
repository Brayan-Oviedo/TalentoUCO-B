package co.talento.uco.auth.controlador;

import co.talento.uco.auth.adaptador.Auth;
import co.talento.uco.jwToken.modelo.dto.RespuestaJwToken;
import co.talento.uco.rabbitmq.adaptador.EscritorMensaje;
import co.talento.uco.usuario.comando.RequestUsuarioTransaccion;
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

    private final EscritorMensaje escritorMensaje;

    @Autowired
    public ControladorAuthTransaccion(Auth auth, FabricaUsuario fabricaUsuario, ManejadorGuardarUsuario manejadorGuardarUsuario, EscritorMensaje escritorMensaje) {
        this.auth = auth;
        this.fabricaUsuario = fabricaUsuario;
        this.manejadorGuardarUsuario = manejadorGuardarUsuario;
        this.escritorMensaje = escritorMensaje;
    }

    @PostMapping
    public RespuestaJwToken ingresarUsuario(@RequestBody RequestUsuarioTransaccion requestUsuarioTransaccion){
        var usuario = this.fabricaUsuario.crear(requestUsuarioTransaccion);
        return this.auth.login(usuario);
    }

    @PutMapping
    public boolean registrarUsuario(@RequestBody RequestUsuarioTransaccion requestUsuarioTransaccion) {
        return this.manejadorGuardarUsuario.ejecutar(requestUsuarioTransaccion);
    }

}
