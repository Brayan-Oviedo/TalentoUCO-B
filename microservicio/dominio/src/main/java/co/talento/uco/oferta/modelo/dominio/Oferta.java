package co.talento.uco.oferta.modelo.dominio;

import co.talento.uco.contacto.modelo.dominio.Contacto;
import co.talento.uco.postdetails.modelo.dominio.PostDetails;
import co.talento.uco.usuario.modelo.dominio.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Oferta {
    private Usuario usuario;
    private PostDetails postDetails;
    private Contacto contacto;
    private boolean isActive;
    private List<String> tags;
}
