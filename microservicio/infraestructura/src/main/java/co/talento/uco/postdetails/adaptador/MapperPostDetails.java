package co.talento.uco.postdetails.adaptador;

import co.talento.uco.postdetails.entidad.EntidadPostDetails;
import co.talento.uco.postdetails.modelo.dominio.PostDetails;
import org.springframework.stereotype.Component;

@Component
public class MapperPostDetails {
    public EntidadPostDetails crearEntidad(PostDetails postDetails){
        return new EntidadPostDetails(
                postDetails.getTitulo(),
                postDetails.getDescripcion()
        );
    }
}
