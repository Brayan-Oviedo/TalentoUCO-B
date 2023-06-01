package co.talento.uco.postdetails.adaptador.contacto.adaptador;

import co.talento.uco.postdetails.adaptador.contacto.entidad.EntidadContacto;
import co.talento.uco.contacto.modelo.dominio.Contacto;
import co.talento.uco.contacto.modelo.dtoRespuesta.RespuestaContacto;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class MapperContacto {

    public List<RespuestaContacto> crearRespuestas(List<EntidadContacto> entidadContactos) {

       return entidadContactos.stream().map(this::crearRespuesta)
                .toList();
    }

    public RespuestaContacto crearRespuesta(EntidadContacto entidadContacto){

        return new RespuestaContacto(
                entidadContacto.getId(),
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

    public Contacto crearDominio(EntidadContacto entidadContacto){
        return new Contacto(
                entidadContacto.getId(),
                entidadContacto.getNombre(),
                entidadContacto.getCorreo(),
                entidadContacto.getCelular(),
                entidadContacto.getCiudad(),
                entidadContacto.getDireccion()
        );
    }


}
