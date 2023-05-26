package co.talento.uco.usuario.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudUsuarioTransaccion {

    private String nombreUsuario;
    private String contrasena;
    private Set<String> roles;
}



