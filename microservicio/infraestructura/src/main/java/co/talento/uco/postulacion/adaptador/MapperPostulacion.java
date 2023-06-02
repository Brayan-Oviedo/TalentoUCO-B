package co.talento.uco.postulacion.adaptador;

import co.talento.uco.oferta.entidad.EntidadOferta;
import co.talento.uco.oferta.modelo.dominio.Oferta;
import co.talento.uco.oferta.modelo.dtoRespuesta.RespuestaOferta;
import co.talento.uco.postdetails.adaptador.MapperPostDetails;
import co.talento.uco.postdetails.adaptador.contacto.adaptador.MapperContacto;
import co.talento.uco.postulacion.entidad.EntidadPostulacion;
import co.talento.uco.postulacion.modelo.dominio.Postulacion;
import co.talento.uco.postulacion.modelo.respuesta.RespuestaPostulacion;
import co.talento.uco.usuario.adaptador.MapperUsuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapperPostulacion {

    private final MapperUsuario mapperUsuario;
    private final MapperContacto mapperContacto;
    private final MapperPostDetails mapperPostDetails;

    public MapperPostulacion(MapperUsuario mapperUsuario, MapperContacto mapperContacto, MapperPostDetails mapperPostDetails) {
        this.mapperUsuario = mapperUsuario;
        this.mapperContacto = mapperContacto;
        this.mapperPostDetails = mapperPostDetails;
    }

    
    public EntidadPostulacion crearEntidad(Postulacion postulacion, Oferta oferta) {

        return new EntidadPostulacion(
                postulacion.getId(),
                this.mapperUsuario.crearEntidad(postulacion.getPostulante()),
                this.crearEntidadOferta(oferta),
                postulacion.getFecha(),
                postulacion.getAdjunto()
        );
    }

    /*public List<EntidadPostulacion> crearListaEntidad(List<Postulacion> postulacions, Oferta oferta){
       return postulacions.stream().map(postulacion -> this.crearEntidad(postulacion, oferta)).toList();
    }*/



    /*public RespuestaPostulacion crearRespuesta(EntidadPostulacion entidadPostulacion){
        return new RespuestaPostulacion(
                entidadPostulacion.getId(),
                this.mapperUsuario.crearRespuesta(entidadPostulacion.getPostulante()),
                entidadPostulacion.getFecha(),
                entidadPostulacion.getAdjunto(),
                this.crearRespuestaOferta(entidadPostulacion.getOferta(), entidadPostulacion)
        );
    }*/

    /*public List<RespuestaPostulacion> crearListaRespuesta(List<EntidadPostulacion> entidadPostulacions){
        return entidadPostulacions.stream().map(this::crearRespuesta).toList();
    }*/

   /* public Postulacion crearDominioConId(EntidadPostulacion entidadPostulacion){
        return new Postulacion(
          entidadPostulacion.getId(),
          mapperUsuario.crearDomio(entidadPostulacion.getPostulante()),
          entidadPostulacion.getFecha(),
          entidadPostulacion.getAdjunto()
        );
    }*/

    /*public List<Postulacion> crearListaDominioConId(List<EntidadPostulacion> entidadPostulacions){
      return entidadPostulacions.stream().map(this::crearDominio).toList();
    }*/

    public Postulacion crearDominio(EntidadPostulacion entidadPostulacion){
        return new Postulacion(
                this.mapperUsuario.crearDomio(entidadPostulacion.getPostulante()),
                entidadPostulacion.getFecha(),
                entidadPostulacion.getAdjunto()
                );
    }

    public RespuestaPostulacion crearRespuesta(EntidadPostulacion entidadPostulacion){
        return new RespuestaPostulacion(
                entidadPostulacion.getId(),
                this.mapperUsuario.crearRespuesta(entidadPostulacion.getPostulante()),
                entidadPostulacion.getFecha(),
                entidadPostulacion.getAdjunto(),
                this.crearRespuestaOferta(entidadPostulacion.getOferta())
        );
    }

    public List<RespuestaPostulacion> crearListaRespuesta(List<EntidadPostulacion> entidadPostulacions){
        return entidadPostulacions.stream().map(this::crearRespuesta).toList();
    }

    /*public EntidadPostulacion crearRespuesta(RespuestaPostulacion respuestaPostulacion){
        return new EntidadPostulacion(
                respuestaPostulacion.getId(),
                this.mapperUsuario.crearEntidadDeRespuesta(respuestaPostulacion.getRespuestaUsuario()),
                this.crearEntidadOferta(respuestaPostulacion.getRespuestaOferta()),
                respuestaPostulacion.getFecha(),
                respuestaPostulacion.getAdjunto()
        );
    }*/

    private EntidadOferta crearEntidadOferta(Oferta oferta) {
        return new EntidadOferta(
                oferta.getId(),
                this.mapperUsuario.crearEntidad(oferta.getUsuario()),
                this.mapperPostDetails.crearEntidad(oferta.getPostDetails()),
                this.mapperContacto.crearEntidad(oferta.getContacto()),
                oferta.isEstaActiva(),
                oferta.getTags()
        );
    }

   /* private EntidadOferta crearEntidadOferta(RespuestaOferta respuestaOferta) {
        return new EntidadOferta(
                respuestaOferta.getId(),
                this.mapperUsuario.crearEntidadDeRespuesta(respuestaOferta.getRespuestaUsuario()),
                this.mapperPostDetails.crearEntidad(respuestaOferta.getRespuestaPostDetails()),
                this.mapperContacto.crearEntidadDeRespuesta(respuestaOferta.getRespuestaContacto()),
                respuestaOferta.isEstaActiva(),
                respuestaOferta.getTags()
        );
    }*/

    private RespuestaOferta crearRespuestaOferta(EntidadOferta entidadOferta) {
        return new RespuestaOferta(
                entidadOferta.getIdOferta(),
                this.mapperUsuario.crearRespuesta(entidadOferta.getEntidadUsuario()),
                this.mapperPostDetails.crearRespuesta(entidadOferta.getEntidadPostDetails()),
                this.mapperContacto.crearRespuesta(entidadOferta.getEntidadContacto()),
                entidadOferta.isActive(),
                entidadOferta.getTags()
        );
    }
}
