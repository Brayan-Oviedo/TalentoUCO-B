package co.talento.uco.oferta.modelo.dominio;

import co.talento.uco.contacto.modelo.dominio.Contacto;
import co.talento.uco.postdetails.modelo.dominio.PostDetails;
import co.talento.uco.postulacion.modelo.dominio.Postulacion;
import co.talento.uco.postulacion.modelo.dominio.PostulacionDetalle;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class OfertaDetalle {
    private Long id;
    private PostDetails postDetails;
    private Contacto contacto;
    private boolean estaActiva;
    private List<String> tags;
    private List<PostulacionDetalle> postulaciones;

    public OfertaDetalle(PostDetails postDetails, Contacto contacto, boolean estaActiva, List<String> tags, List<PostulacionDetalle> postulaciones) {
        this.postDetails = postDetails;
        this.contacto = contacto;
        this.estaActiva = estaActiva;
        this.tags = tags;
        this.postulaciones = postulaciones;
    }
}
