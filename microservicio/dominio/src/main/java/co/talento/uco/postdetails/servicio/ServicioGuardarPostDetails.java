package co.talento.uco.postdetails.servicio;

import co.talento.uco.contacto.modelo.dominio.Contacto;
import co.talento.uco.contacto.modelo.dtoRespuesta.RespuestaContacto;
import co.talento.uco.postdetails.modelo.dominio.PostDetails;
import co.talento.uco.postdetails.puerto.repositorio.RepositorioPoestDetails;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarPostDetails {
    private final RepositorioPoestDetails repositorioPoestDetails;

    public ServicioGuardarPostDetails(RepositorioPoestDetails repositorioPoestDetails) {
        this.repositorioPoestDetails = repositorioPoestDetails;
    }

    public boolean ejecutar(PostDetails postDetails){
        return this.repositorioPoestDetails.guardar(postDetails);
    }


}
