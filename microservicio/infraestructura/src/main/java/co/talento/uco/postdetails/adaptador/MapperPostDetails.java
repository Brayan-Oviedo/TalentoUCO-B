package co.talento.uco.postdetails.adaptador;

import co.talento.uco.postdetails.entidad.EntidadPostDetails;
import co.talento.uco.postdetails.modelo.dominio.PostDetails;
import co.talento.uco.postdetails.modelo.dtoRespuesta.RespuestaPostDetails;
import org.springframework.stereotype.Component;

@Component
public class MapperPostDetails {
    public EntidadPostDetails crearEntidad(PostDetails postDetails){
        return new EntidadPostDetails(
                postDetails.getTitulo(),
                postDetails.getDescripcion()
        );
    }

    public RespuestaPostDetails crearRespuesta(EntidadPostDetails entidadPostDetails){
        return new RespuestaPostDetails(
                entidadPostDetails.getIdPostDetails(),
                entidadPostDetails.getTitulo(),
                entidadPostDetails.getDescripcion()
        );
    }

    public PostDetails crearDominio(EntidadPostDetails entidadPostDetails){
        return new PostDetails(
                entidadPostDetails.getIdPostDetails(),
                entidadPostDetails.getTitulo(),
                entidadPostDetails.getDescripcion()
        );
    }

    public EntidadPostDetails crearEntidad(RespuestaPostDetails postDetails){
        return new EntidadPostDetails(
                postDetails.getTitulo(),
                postDetails.getDescripcion()
        );
    }
}
