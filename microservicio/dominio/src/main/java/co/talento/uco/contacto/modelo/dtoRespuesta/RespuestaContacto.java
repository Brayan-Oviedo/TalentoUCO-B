package co.talento.uco.contacto.modelo.dtoRespuesta;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaContacto {
    private String nombre;
    private String correo;
    private String celular;
    private String ciudad;
    private String direccion;
}
