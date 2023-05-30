package co.talento.uco.oferta.adaptador;

import co.talento.uco.postdetails.adaptador.contacto.adaptador.MapperContacto;
import co.talento.uco.oferta.entidad.EntidadOferta;
import co.talento.uco.oferta.modelo.dominio.Oferta;
import co.talento.uco.oferta.modelo.dtoRespuesta.RespuestaOferta;
import co.talento.uco.postdetails.adaptador.MapperPostDetails;
import co.talento.uco.postulacion.adaptador.MapperPostulacion;
import co.talento.uco.usuario.adaptador.MapperUsuario;
import org.springframework.stereotype.Component;

@Component

public class MapperOferta {

    private final MapperContacto mapperContacto;
    private final MapperPostDetails mapperPostDetails;
    private final MapperUsuario mapperUsuario;

    private final MapperPostulacion mapperPostulacion;

    public MapperOferta(MapperContacto mapperContacto, MapperPostDetails mapperPostDetails, MapperUsuario mapperUsuario, MapperPostulacion mapperPostulacion) {
        this.mapperContacto = mapperContacto;
        this.mapperPostDetails = mapperPostDetails;
        this.mapperUsuario = mapperUsuario;
        this.mapperPostulacion = mapperPostulacion;
    }


    public EntidadOferta crearEntidadOferta(Oferta oferta){
        return new EntidadOferta(
                this.mapperUsuario.crearEntidad(oferta.getUsuario()),
                this.mapperPostDetails.crearEntidad(oferta.getPostDetails()),
                this.mapperContacto.crearEntidad(oferta.getContacto()),
                oferta.isEstaActiva(),
                oferta.getTags(),
                this.mapperPostulacion.crearListaEntidad(oferta.getPostulaciones())
        );
    }

    public RespuestaOferta crearRespuesta(EntidadOferta entidadOferta){
        return new RespuestaOferta(
                entidadOferta.getIdOferta(),
                this.mapperUsuario.crearRespuesta(entidadOferta.getEntidadUsuario()),
                this.mapperPostDetails.crearRespuesta(entidadOferta.getEntidadPostDetails()),
                this.mapperContacto.crearRespuesta(entidadOferta.getEntidadContacto()),
                entidadOferta.isActive(),
                entidadOferta.getTags(),
                this.mapperPostulacion.crearListaRespuesta(entidadOferta.getPustulaciones())
        );
    }
}
