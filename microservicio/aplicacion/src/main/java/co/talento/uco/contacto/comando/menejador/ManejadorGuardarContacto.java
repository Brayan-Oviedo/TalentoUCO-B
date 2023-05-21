package co.talento.uco.contacto.comando.menejador;

import co.talento.uco.contacto.comando.RequestContactoTransaccion;
import co.talento.uco.contacto.comando.fabrica.FabricaContacto;
import co.talento.uco.contacto.modelo.dtoRespuesta.RespuestaContacto;
import co.talento.uco.contacto.servicio.ServicioGuardarContacto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ManejadorGuardarContacto {

    private final FabricaContacto fabricaContacto;
    private final ServicioGuardarContacto servicioGuardarContacto;

    public RespuestaContacto ejecutar(RequestContactoTransaccion requestContactoTransaccion) {
        var contacto = this.fabricaContacto.crear(requestContactoTransaccion);
        return this.servicioGuardarContacto.ejecutar(contacto);
    }
}
