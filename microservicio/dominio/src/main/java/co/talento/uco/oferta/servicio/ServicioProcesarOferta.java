package co.talento.uco.oferta.servicio;

import co.talento.uco.oferta.modelo.dominio.Oferta;
import co.talento.uco.oferta.modelo.dominio.OfertaDetalle;
import co.talento.uco.postulacion.modelo.dominio.Postulacion;
import co.talento.uco.usuario.modelo.dominio.Usuario;
import co.talento.uco.usuario.modelo.dtoRespuesta.RespuestaUsuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioProcesarOferta {


    public Oferta ejecutar(OfertaDetalle ofertaDetalle, RespuestaUsuario respuestaUsuario) {
        var usuario = new Usuario(respuestaUsuario.getNombreUsuario(), respuestaUsuario.getContrasena(), respuestaUsuario.getRoles());
        var postulaciones = ofertaDetalle.getPostulaciones().stream().map(postulacion -> {
            return new Postulacion(postulacion.getId(), usuario, postulacion.getFecha(), postulacion.getAdjunto());
        }).toList();
        return buildOffer(ofertaDetalle, usuario, postulaciones);
    }


    private Oferta buildOffer(OfertaDetalle ofertaDetalle, Usuario usuario, List<Postulacion> postulaciones) {
        return new Oferta(
                ofertaDetalle.getId(),
                usuario,
                ofertaDetalle.getPostDetails(),
                ofertaDetalle.getContacto(),
                ofertaDetalle.isEstaActiva(),
                ofertaDetalle.getTags(),
                postulaciones
        );
    }
}
