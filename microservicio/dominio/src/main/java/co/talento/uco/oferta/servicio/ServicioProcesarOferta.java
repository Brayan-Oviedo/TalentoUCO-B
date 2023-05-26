package co.talento.uco.oferta.servicio;

import co.talento.uco.oferta.modelo.dominio.Oferta;
import co.talento.uco.oferta.modelo.dominio.OfertaDetalle;
import co.talento.uco.usuario.modelo.dominio.Usuario;
import co.talento.uco.usuario.modelo.dtoRespuesta.RespuestaUsuario;
import org.springframework.stereotype.Service;

@Service
public class ServicioProcesarOferta {


    public Oferta ejecutar(OfertaDetalle ofertaDetalle, RespuestaUsuario respuestaUsuario) {
        var usuario = new Usuario(respuestaUsuario.getNombreUsuario(), respuestaUsuario.getContrasena(), respuestaUsuario.getRoles());
        return new Oferta(
                usuario,
                ofertaDetalle.getPostDetails(),
                ofertaDetalle.getContacto(),
                ofertaDetalle.isEstaActiva(),
                ofertaDetalle.getTags()
        );
    }
}
