package co.talento.uco.postulacion.servicio;

import co.talento.uco.oferta.modelo.dominio.OfertaDetalle;
import co.talento.uco.oferta.servicio.ServicioGuardarOferta;
import co.talento.uco.postulacion.modelo.dominio.Postulacion;
import co.talento.uco.usuario.modelo.dtoRespuesta.RespuestaUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServicioGuardarPostulacion {

    private final ServicioProcesarPostulacion servicioProcesarPostulacion;
    private final ServicioGuardarOferta servicioGuardarOferta;

    public Long guardarPostulacion(OfertaDetalle ofertaDetalle, RespuestaUsuario respuestaUsuario, Postulacion postulacion){
        ofertaDetalle = this.servicioProcesarPostulacion.ejecutar(ofertaDetalle, postulacion);
        return this.servicioGuardarOferta.ejecutar(ofertaDetalle, respuestaUsuario);
    }

}
