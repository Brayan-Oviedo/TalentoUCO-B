package co.talento.uco.usuario.consulta;

import co.talento.uco.usuario.modelo.dtoRespuesta.RespuestaUsuario;
import co.talento.uco.usuario.servicio.ServicioConsultarUsuario;
import org.springframework.stereotype.Component;

@Component
public class ConsultarUsuario {

    private final ServicioConsultarUsuario servicioConsultarUsuario;

    public ConsultarUsuario(ServicioConsultarUsuario servicioConsultarUsuario) {
        this.servicioConsultarUsuario = servicioConsultarUsuario;
    }

    public RespuestaUsuario ejecutar(String nombreUsuario) {
        return this.servicioConsultarUsuario.ejecutar(nombreUsuario);
    }
}
