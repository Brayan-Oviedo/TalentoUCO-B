package co.talento.uco.contacto.modelo.dominio;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Contacto {
    private String nombre;
    private String correo;
    private String celular;
    private String ciudad;
    private String direccion;
}
