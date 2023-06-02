package co.talento.uco.postulacion.modelo.respuesta;

import co.talento.uco.oferta.modelo.dtoRespuesta.RespuestaOferta;
import co.talento.uco.usuario.modelo.dominio.Usuario;
import co.talento.uco.usuario.modelo.dtoRespuesta.RespuestaUsuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaPostulacion {
    private Long id;
    private RespuestaUsuario respuestaUsuario;
    private Date fecha;
    private String adjunto;
    private RespuestaOferta respuestaOferta;
}
