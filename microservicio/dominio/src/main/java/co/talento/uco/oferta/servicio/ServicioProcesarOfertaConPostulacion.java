package co.talento.uco.oferta.servicio;

import co.talento.uco.oferta.modelo.dominio.Oferta;
import co.talento.uco.oferta.modelo.dominio.OfertaDetalle;
import co.talento.uco.postulacion.modelo.dominio.Postulacion;
import co.talento.uco.usuario.modelo.dominio.Usuario;
import co.talento.uco.usuario.modelo.dtoRespuesta.RespuestaUsuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioProcesarOfertaConPostulacion {


    public Oferta ejecutar(OfertaDetalle ofertaDetalle, RespuestaUsuario respuestaUsuario, Postulacion postulacion) {
        var usuario = new Usuario(respuestaUsuario.getNombreUsuario(), respuestaUsuario.getContrasena(), respuestaUsuario.getRoles());
        var lista = new ArrayList<Postulacion>();
        lista.addAll(ofertaDetalle.getPostulaciones());
        lista.add(postulacion);
        return new Oferta(
                usuario,
                ofertaDetalle.getPostDetails(),
                ofertaDetalle.getContacto(),
                ofertaDetalle.isEstaActiva(),
                ofertaDetalle.getTags(),
                lista
        );
    }
}
