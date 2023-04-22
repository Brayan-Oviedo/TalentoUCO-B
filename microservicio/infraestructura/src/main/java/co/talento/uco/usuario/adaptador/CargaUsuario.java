package co.talento.uco.usuario.adaptador;

import co.talento.uco.usuario.consulta.ConsultarUsuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CargaUsuario implements UserDetailsService {

    private final ConsultarUsuario consultarUsuario;
    private final MapperUsuarioDetalles mapperUsuarioDetalles;

    public CargaUsuario(ConsultarUsuario consultarUsuario, MapperUsuarioDetalles mapperUsuarioDetalles) {
        this.consultarUsuario = consultarUsuario;
        this.mapperUsuarioDetalles = mapperUsuarioDetalles;
    }

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        var usuario = this.consultarUsuario.ejecutar(nombreUsuario);
        return this.mapperUsuarioDetalles.crearModelo(usuario);
    }
}
