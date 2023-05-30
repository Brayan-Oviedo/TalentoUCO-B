package co.talento.uco.postdetails.modelo.dtoRespuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaPostDetails {
    private Long id;
    private String titulo;
    private String descripcion;
}
