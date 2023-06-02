package co.talento.uco.postulacion.servicio;

import co.talento.uco.oferta.servicio.ServicioProcesarOferta;
import co.talento.uco.postulacion.modelo.dominio.Postulacion;
import co.talento.uco.postulacion.modelo.dominio.PostulacionDetalle;
import co.talento.uco.usuario.modelo.dominio.Usuario;
import co.talento.uco.usuario.modelo.dtoRespuesta.RespuestaUsuario;
import org.springframework.stereotype.Service;

@Service
public class ServicioProcesarPostulacion {
 private final ServicioProcesarOferta servicioProcesarOferta;

    public ServicioProcesarPostulacion(ServicioProcesarOferta servicioProcesarOferta) {
        this.servicioProcesarOferta = servicioProcesarOferta;
    }

    public Postulacion ejecutar(PostulacionDetalle postulacionDetalle, RespuestaUsuario respuestaUsuario) {
        var usuario = new Usuario(respuestaUsuario.getNombreUsuario(),respuestaUsuario.getContrasena(),respuestaUsuario.getRoles());
        var oferta = servicioProcesarOferta.ejecutar(postulacionDetalle.getOfertaDetalle(),respuestaUsuario);
        return new Postulacion(
                postulacionDetalle.getId(),
                usuario,
                postulacionDetalle.getFecha(),
                postulacionDetalle.getAdjunto(),
                oferta
        );
    }
}
