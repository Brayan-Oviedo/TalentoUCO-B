package co.talento.uco.oferta.comando.manejador;

import co.talento.uco.oferta.servicio.ServicioEliminarOferta;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ManejadorEliminarOferta {

    private final ServicioEliminarOferta servicioEliminarOferta;

    public boolean ejecutar(Long id) {
        return this.servicioEliminarOferta.ejecutar(id);
    }
}
