package co.talento.uco.auth.adaptador;

import co.talento.uco.auth.config.JwTokenProveedor;
import co.talento.uco.excepcion.ExcepcionCredencialesIncorrectas;
import co.talento.uco.excepcion.ExcepcionInexistente;
import co.talento.uco.jwToken.modelo.dto.RespuestaJwToken;
import co.talento.uco.usuario.modelo.dominio.Usuario;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class Auth {

    private final AuthenticationManager authenticationManager;
    private final JwTokenProveedor jwTokenProvider;

    public Auth(AuthenticationManager authenticationManager, JwTokenProveedor jwTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.jwTokenProvider = jwTokenProvider;
    }

    public RespuestaJwToken login(Usuario usuario) {
        try {
            var usuarioAuth = new UsernamePasswordAuthenticationToken(usuario.getNombreUsuario(), usuario.getContrasena());
            var auth = this.authenticationManager.authenticate(usuarioAuth);
            var token = this.jwTokenProvider.generarToken(auth);
            SecurityContextHolder.getContext().setAuthentication(auth);
            return new RespuestaJwToken(token);

        } catch (BadCredentialsException e) {
            throw new ExcepcionCredencialesIncorrectas("Credenciales de autenticación incorrectas");
        } catch (InternalAuthenticationServiceException e) {
            throw new ExcepcionInexistente(e.getMessage());
        }
    }
}
