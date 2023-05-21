package co.talento.uco.contacto.adaptador;

import co.talento.uco.contacto.entidad.EntidadContacto;
import co.talento.uco.contacto.modelo.dominio.Contacto;
import co.talento.uco.contacto.modelo.dtoRespuesta.RespuestaContacto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class MapperContacto {

    public List<RespuestaContacto> crearRespuestas(List<EntidadContacto> entidadContactos) {
        var respuestaContactos = new ArrayList<RespuestaContacto>();

        entidadContactos.forEach(entidadContacto -> {
            respuestaContactos.add(this.crearRespuesta(entidadContacto));
        });

        return respuestaContactos;
    }

    public RespuestaContacto crearRespuesta(EntidadContacto entidadContacto){

        return new RespuestaContacto(
                entidadContacto.getNombre(),
                entidadContacto.getCorreo(),
                entidadContacto.getCelular(),
                entidadContacto.getCiudad(),
                entidadContacto.getDireccion()
        );
    }

    public EntidadContacto crearEntidad(Contacto contacto){
        return new EntidadContacto(
                contacto.getNombre(),
                contacto.getCorreo(),
                contacto.getCelular(),
                contacto.getCiudad(),
                contacto.getDireccion()
        );
    }
}
