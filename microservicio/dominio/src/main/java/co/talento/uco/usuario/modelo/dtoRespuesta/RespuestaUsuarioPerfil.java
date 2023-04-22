package co.talento.uco.usuario.modelo.dtoRespuesta;
import co.talento.uco.vehiculo.modelo.dtoRespuesta.RespuestaVehiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaUsuarioPerfil {

    private String nombreUsuario;
    private Set<String> roles;
    private List<RespuestaVehiculo> vehiculos;
}
