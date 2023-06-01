package co.talento.uco.postulacion.adaptador;

import co.talento.uco.postulacion.entidad.EntidadPostulacion;
import co.talento.uco.postulacion.modelo.dominio.Postulacion;
import co.talento.uco.postulacion.modelo.respuesta.RespuestaPostulacion;
import co.talento.uco.usuario.adaptador.MapperUsuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapperPostulacion {

    private final MapperUsuario mapperUsuario;

    public MapperPostulacion(MapperUsuario mapperUsuario) {
        this.mapperUsuario = mapperUsuario;
    }

    public EntidadPostulacion crearEntidad(Postulacion postulacion){
        return new EntidadPostulacion(
                this.mapperUsuario.crearEntidad(postulacion.getPostulante()),
                postulacion.getFecha(),
                postulacion.getAdjunto()
                );
    }

    public List<EntidadPostulacion> crearListaEntidad(List<Postulacion> postulacions){
       return postulacions.stream().map(this::crearEntidad).toList();
    }



    /*public RespuestaPostulacion crearRespuesta(EntidadPostulacion entidadPostulacion){
        return new RespuestaPostulacion(
                entidadPostulacion.getId(),
                this.mapperUsuario.crearDomio(entidadPostulacion.getPostulante()),
                entidadPostulacion.getFecha(),
                entidadPostulacion.getAdjunto()
        );
    }

    public List<RespuestaPostulacion> crearListaRespuesta(List<EntidadPostulacion> entidadPostulacions){
        return entidadPostulacions.stream().map(this::crearRespuesta).toList();
    }*/

    public Postulacion crearDominio(EntidadPostulacion entidadPostulacion){
        return new Postulacion(
          entidadPostulacion.getId(),
          mapperUsuario.crearDomio(entidadPostulacion.getPostulante()),
          entidadPostulacion.getFecha(),
          entidadPostulacion.getAdjunto()
        );
    }

    public List<Postulacion> crearListaDominio(List<EntidadPostulacion> entidadPostulacions){
      return entidadPostulacions.stream().map(this::crearDominio).toList();
    }
}
