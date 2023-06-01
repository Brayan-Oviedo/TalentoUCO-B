package co.talento.uco.postdetails.comando.fabrica;

import co.talento.uco.postdetails.comando.RequestPostDetails;
import co.talento.uco.postdetails.modelo.dominio.PostDetails;
import co.talento.uco.postdetails.modelo.dtoRespuesta.RespuestaPostDetails;
import org.springframework.stereotype.Component;

@Component
public class FabricaPostDetails {

    public PostDetails crear(RequestPostDetails requestPostDetails){
        return new PostDetails(
                requestPostDetails.getTitulo(),
                requestPostDetails.getDescripcion()
        );
    }

    public PostDetails crearDominio(RespuestaPostDetails respuestaPostDetails){
        return new PostDetails(
                respuestaPostDetails.getId(),
                respuestaPostDetails.getTitulo(),
                respuestaPostDetails.getDescripcion()
        );
    }
}
