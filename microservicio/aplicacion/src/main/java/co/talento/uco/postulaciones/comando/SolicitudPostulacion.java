package co.talento.uco.postulaciones.comando;

import co.talento.uco.usuario.comando.SolicitudUsuarioConsulta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudPostulacion {
    private Long idOferta;
    private SolicitudUsuarioConsulta usuario;
    private String adjunto;
}
