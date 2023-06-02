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
        return crearOferta(ofertaDetalle, usuario);
    }


    private Oferta crearOferta(OfertaDetalle ofertaDetalle, Usuario usuario) {
        return new Oferta(
                ofertaDetalle.getId(),
                usuario,
                ofertaDetalle.getPostDetails(),
                ofertaDetalle.getContacto(),
                ofertaDetalle.isEstaActiva(),
                ofertaDetalle.getTags()
        );
    }
}
