package co.talento.uco.contacto.comando.menejador;

import co.talento.uco.contacto.servicio.ServicioEliminarContacto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ManejadorEliminarContacto {
    private final ServicioEliminarContacto servicioEliminarContacto;

    public boolean ejecutar(Long id){
        return this.servicioEliminarContacto.ejecutar(id);
    }
}
