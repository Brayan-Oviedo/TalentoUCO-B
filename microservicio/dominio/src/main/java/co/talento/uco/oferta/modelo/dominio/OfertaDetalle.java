package co.talento.uco.oferta.modelo.dominio;

import co.talento.uco.contacto.modelo.dominio.Contacto;
import co.talento.uco.postdetails.modelo.dominio.PostDetails;
import co.talento.uco.postulacion.modelo.dominio.Postulacion;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class OfertaDetalle {
    private PostDetails postDetails;
    private Contacto contacto;
    private boolean estaActiva;
    private List<String> tags;
    private List<Postulacion> postulaciones;
}
