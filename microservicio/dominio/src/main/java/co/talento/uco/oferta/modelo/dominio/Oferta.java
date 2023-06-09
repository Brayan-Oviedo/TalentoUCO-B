package co.talento.uco.oferta.modelo.dominio;

import co.talento.uco.contacto.modelo.dominio.Contacto;
import co.talento.uco.postdetails.modelo.dominio.PostDetails;
import co.talento.uco.postulacion.modelo.dominio.Postulacion;
import co.talento.uco.usuario.modelo.dominio.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Oferta {
    private Long id;
    private Usuario usuario;
    private PostDetails postDetails;
    private Contacto contacto;
    private boolean estaActiva;
    private List<String> tags;

    public Oferta(Usuario usuario, PostDetails postDetails, Contacto contacto, boolean estaActiva, List<String> tags) {
        this.usuario = usuario;
        this.postDetails = postDetails;
        this.contacto = contacto;
        this.estaActiva = estaActiva;
        this.tags = tags;
    }
}
