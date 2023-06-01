package co.talento.uco.contacto.comando.fabrica;

import co.talento.uco.contacto.comando.RequestContactoTransaccion;
import co.talento.uco.contacto.modelo.dominio.Contacto;
import co.talento.uco.contacto.modelo.dtoRespuesta.RespuestaContacto;
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

    public Contacto crearDominio(RespuestaContacto respuestaContacto){
        return new Contacto(
                respuestaContacto.getId(),
                respuestaContacto.getNombre(),
                respuestaContacto.getCorreo(),
                respuestaContacto.getCelular(),
                respuestaContacto.getCiudad(),
                respuestaContacto.getDireccion()
        );
    }
}
