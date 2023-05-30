package co.talento.uco.oferta.modelo.dtoRespuesta;

import co.talento.uco.contacto.modelo.dtoRespuesta.RespuestaContacto;
import co.talento.uco.postdetails.modelo.dtoRespuesta.RespuestaPostDetails;
import co.talento.uco.postulacion.modelo.respuesta.RespuestaPostulacion;
import co.talento.uco.usuario.modelo.dtoRespuesta.RespuestaUsuario;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaOferta {
    private Long id;
    private RespuestaUsuario respuestaUsuariosuario;
    private RespuestaPostDetails respuestaPostDetails;
    private RespuestaContacto respuestaContacto;
    private boolean estaActiva;
    private List<String> tags;
    private List<RespuestaPostulacion> respuestaPostulacions;
}
