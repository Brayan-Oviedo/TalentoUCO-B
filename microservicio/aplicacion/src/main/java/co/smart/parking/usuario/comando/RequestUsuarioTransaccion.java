package co.smart.parking.usuario.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestUsuarioTransaccion {

    private String nombreUsuario;
    private String contrasena;
    private List<String> roles;
}



