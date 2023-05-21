package co.talento.uco.postdetails.comando.manejador;

import co.talento.uco.postdetails.comando.RequestPostDetails;
import co.talento.uco.postdetails.comando.fabrica.FabricaPostDetails;
import co.talento.uco.postdetails.servicio.ServicioGuardarPostDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ManejadorGuardarPostDetails {
    private final FabricaPostDetails fabricaPostDetails;
    private final ServicioGuardarPostDetails servicioGuardarPostDetails;

    public boolean ejecutar(RequestPostDetails requestPostDetails) {
        var contacto = this.fabricaPostDetails.crear(requestPostDetails);
        return this.servicioGuardarPostDetails.ejecutar(contacto);
    }
}
