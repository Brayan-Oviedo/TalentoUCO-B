package co.talento.uco.postulacion.servicio;

import co.talento.uco.oferta.modelo.dominio.Oferta;
import co.talento.uco.oferta.modelo.dtoRespuesta.RespuestaOferta;
import co.talento.uco.oferta.puerto.dao.DaoOferta;
import co.talento.uco.oferta.servicio.ServicioGuardarOferta;
import co.talento.uco.postulacion.modelo.dominio.Postulacion;
import co.talento.uco.postulacion.puerto.repositorio.RepositorioPostulacion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ServicioProcesarPostulacion {
    private final DaoOferta daoOferta;
    private final ServicioGuardarOferta servicioGuardarOferta;
    private final RepositorioPostulacion repositorioPostulacion;

    public Oferta ejecutar(Postulacion postulacion, RespuestaOferta respuestaOferta){
        var postulaciones = respuestaOferta.getPostulaciones();
        postulaciones.add(postulacion);

        return new Oferta(
                respuestaOferta.getId(),
                respuestaOferta.getUsuario(),
                respuestaOferta.getPostDetails(),
                respuestaOferta.getContacto(),oferta.isEstaActiva(),
                respuestaOferta.getTags(),
                postulaciones
        );
    }

}
