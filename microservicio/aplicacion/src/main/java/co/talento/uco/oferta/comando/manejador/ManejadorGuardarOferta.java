package co.talento.uco.oferta.comando.manejador;

import co.talento.uco.oferta.comando.RequestOfertaTransaccion;
import co.talento.uco.oferta.comando.fabrica.FabricaOferta;
import co.talento.uco.oferta.servicio.ServicioGuardarOferta;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ManejadorGuardarOferta {
    private final FabricaOferta fabricaOferta;
    private final ServicioGuardarOferta servicioGuardarOferta;

    public Long ejecutar(RequestOfertaTransaccion requestOfertaTransaccion) {
        var contacto = this.fabricaOferta.crear(requestOfertaTransaccion);
        return this.servicioGuardarOferta.ejecutar(contacto);
    }
}
