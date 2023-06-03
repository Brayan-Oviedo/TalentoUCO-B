package co.talento.uco.oferta.modelo.dtoRespuesta;

import co.talento.uco.contacto.modelo.dtoRespuesta.RespuestaContacto;
import co.talento.uco.postdetails.modelo.dtoRespuesta.RespuestaPostDetails;
import co.talento.uco.usuario.modelo.dtoRespuesta.RespuestaUsuario;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaOferta {
    private Long id;
    private RespuestaUsuario usuario;
    private RespuestaPostDetails postDetalle;
    private RespuestaContacto contacto;
    private boolean estaActiva;
    private List<String> tags;
}
