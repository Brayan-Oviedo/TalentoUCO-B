package co.talento.uco.postulacion.servicio;

import co.talento.uco.oferta.modelo.dominio.OfertaDetalle;
import co.talento.uco.oferta.servicio.ServicioGuardarOferta;
import co.talento.uco.postulacion.modelo.dominio.Postulacion;
import co.talento.uco.postulacion.modelo.dominio.PostulacionDetalle;
import co.talento.uco.postulacion.puerto.repositorio.RepositorioPostulacion;
import co.talento.uco.usuario.modelo.dtoRespuesta.RespuestaUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServicioGuardarPostulacion {

    private final ServicioProcesarPostulacion servicioProcesarPostulacion;
    private final RepositorioPostulacion repositorioPostulacion;


    public boolean ejecutar(PostulacionDetalle postulacionDetalle,RespuestaUsuario respuestaUsuario){
        var postulacion = this.servicioProcesarPostulacion.ejecutar(postulacionDetalle, respuestaUsuario);
        return this.repositorioPostulacion.guardarPostulacion(postulacion);
    }

}
