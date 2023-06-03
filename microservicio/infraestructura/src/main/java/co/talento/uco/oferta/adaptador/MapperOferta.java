package co.talento.uco.oferta.adaptador;

import co.talento.uco.oferta.puerto.repositorio.RepositorioMapperOferta;
import co.talento.uco.postdetails.adaptador.contacto.adaptador.MapperContacto;
import co.talento.uco.oferta.entidad.EntidadOferta;
import co.talento.uco.oferta.modelo.dominio.Oferta;
import co.talento.uco.oferta.modelo.dtoRespuesta.RespuestaOferta;
import co.talento.uco.postdetails.adaptador.MapperPostDetails;
import co.talento.uco.postulacion.adaptador.MapperPostulacion;
import co.talento.uco.postulacion.entidad.EntidadPostulacion;
import co.talento.uco.postulacion.modelo.respuesta.RespuestaPostulacion;
import co.talento.uco.usuario.adaptador.MapperUsuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class MapperOferta implements RepositorioMapperOferta {

    private final MapperContacto mapperContacto;
    private final MapperPostDetails mapperPostDetails;
    private final MapperUsuario mapperUsuario;


    public MapperOferta(MapperContacto mapperContacto, MapperPostDetails mapperPostDetails, MapperUsuario mapperUsuario) {
        this.mapperContacto = mapperContacto;
        this.mapperPostDetails = mapperPostDetails;
        this.mapperUsuario = mapperUsuario;
    }


    public EntidadOferta crearEntidadOferta(Oferta oferta){
        return new EntidadOferta(
                oferta.getId(),
                this.mapperUsuario.crearEntidad(oferta.getUsuario()),
                this.mapperPostDetails.crearEntidad(oferta.getPostDetails()),
                this.mapperContacto.crearEntidad(oferta.getContacto()),
                oferta.isEstaActiva(),
                oferta.getTags()
        );
    }

    public RespuestaOferta crearRespuestaDesdeEntidad(EntidadOferta entidadOferta, List<RespuestaPostulacion> postulaciones){
        return new RespuestaOferta(
                entidadOferta.getIdOferta(),
                this.mapperUsuario.crearRespuesta(entidadOferta.getEntidadUsuario()),
                this.mapperPostDetails.crearRespuesta(entidadOferta.getEntidadPostDetails()),
                this.mapperContacto.crearRespuesta(entidadOferta.getEntidadContacto()),
                entidadOferta.isActive(),
                entidadOferta.getTags()
        );
    }

    public RespuestaOferta crearRespuestaDesdeEntidad2(EntidadOferta entidadOferta){
        return new RespuestaOferta(
                entidadOferta.getIdOferta(),
                this.mapperUsuario.crearRespuesta(entidadOferta.getEntidadUsuario()),
                this.mapperPostDetails.crearRespuesta(entidadOferta.getEntidadPostDetails()),
                this.mapperContacto.crearRespuesta(entidadOferta.getEntidadContacto()),
                entidadOferta.isActive(),
                entidadOferta.getTags()
        );
    }

    public List<RespuestaOferta> crearListaRespuestaOfertaDesdeEntidad(List<EntidadOferta> entidadOfertas){
        return entidadOfertas.stream().map(this::crearRespuestaDesdeEntidad2).toList();
    }

    public Oferta crearDominio(EntidadOferta entidadOferta){
        return new Oferta(
                entidadOferta.getIdOferta(),
                this.mapperUsuario.crearDomio(entidadOferta.getEntidadUsuario()),
                this.mapperPostDetails.crearDominio(entidadOferta.getEntidadPostDetails()),
                this.mapperContacto.crearDominio(entidadOferta.getEntidadContacto()),
                entidadOferta.isActive(),
                entidadOferta.getTags()
        );
    }

    @Override
    public RespuestaOferta crearRespuesta(Oferta Oferta) {
        /*return new RespuestaOferta(
                Oferta.getId(),
                this.mapperUsuario.crearRespuesta(entidadOferta.getEntidadUsuario()),
                this.mapperPostDetails.crearRespuesta(entidadOferta.getEntidadPostDetails()),
                this.mapperContacto.crearRespuesta(entidadOferta.getEntidadContacto()),
                entidadOferta.isActive(),
                entidadOferta.getTags(),
                this.mapperPostulacion.crearListaRespuesta(entidadOferta.getPustulaciones())
        );*/
        return null;
    }

    /*public EntidadOferta crearEntidadOfertaConId(RespuestaOferta respuestaOferta){
        return new EntidadOferta(
                respuestaOferta.getId(),
                this.mapperUsuario.crearEntidadDeRespuesta(respuestaOferta.getRespuestaUsuario()),
                this.mapperPostDetails.crearEntidadDeRespuesta(respuestaOferta.getRespuestaPostDetails()),
                this.mapperContacto.crearEntidadDeRespuesta(respuestaOferta.getRespuestaContacto()),
                this.mapperPostulacion.crearListaEntidad(respuestaOferta.getRespuestaPostulacions()),
                respuestaOferta.isEstaActiva(),
                respuestaOferta.getTags()
                );
    }*/
}
