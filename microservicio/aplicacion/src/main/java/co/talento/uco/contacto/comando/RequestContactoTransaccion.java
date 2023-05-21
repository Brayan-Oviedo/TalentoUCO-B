package co.talento.uco.contacto.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestContactoTransaccion {

    private String nombre;
    private String correo;
    private String celular;
    private String ciudad;
    private String direccion;
}
