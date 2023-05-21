package co.talento.uco.contacto.comando.fabrica;

import co.talento.uco.contacto.comando.RequestContactoTransaccion;
import co.talento.uco.contacto.modelo.dominio.Contacto;
import org.springframework.stereotype.Component;

@Component
public class FabricaContacto {

    public Contacto crear(RequestContactoTransaccion requestContactoTransaccion){
        return new Contacto(
                requestContactoTransaccion.getNombre(),
                requestContactoTransaccion.getCorreo(),
                requestContactoTransaccion.getCelular(),
                requestContactoTransaccion.getCiudad(),
                requestContactoTransaccion.getDireccion()
        );
    }
}
