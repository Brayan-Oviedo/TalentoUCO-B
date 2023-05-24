package co.talento.uco.contacto.adaptador;

import co.talento.uco.contacto.entidad.EntidadContacto;
import co.talento.uco.contacto.modelo.dominio.Contacto;
import co.talento.uco.contacto.modelo.dtoRespuesta.RespuestaContacto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class MapperContacto {

    public List<RespuestaContacto> crearRespuestas(List<EntidadContacto> entidadContactos) {

       return entidadContactos.stream().map(this::crearRespuesta)
                .toList();
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
