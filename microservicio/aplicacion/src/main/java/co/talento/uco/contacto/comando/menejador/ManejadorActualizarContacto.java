package co.talento.uco.contacto.comando.menejador;

import co.talento.uco.contacto.comando.RequestContactoTransaccion;
import co.talento.uco.contacto.comando.fabrica.FabricaContacto;
import co.talento.uco.contacto.modelo.dtoRespuesta.RespuestaContacto;
import co.talento.uco.contacto.servicio.ServicioActualizarContacto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ManejadorActualizarContacto {

    private final ServicioActualizarContacto servicioActualizarContacto;
    private final FabricaContacto fabricaContacto;

    public boolean ejecutar(RequestContactoTransaccion requestContactoTransaccion) {
        var contacto = this.fabricaContacto.crear(requestContactoTransaccion);
        return this.servicioActualizarContacto.ejecutar(contacto);
    }
}
