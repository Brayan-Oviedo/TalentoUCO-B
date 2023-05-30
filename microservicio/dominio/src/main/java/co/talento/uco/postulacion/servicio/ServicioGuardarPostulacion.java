package co.talento.uco.postulacion.servicio;

import co.talento.uco.oferta.puerto.dao.DaoOferta;
import co.talento.uco.oferta.servicio.ServicioGuardarOferta;
import co.talento.uco.postulacion.modelo.dominio.Postulacion;
import co.talento.uco.postulacion.puerto.repositorio.RepositorioPostulacion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ServicioGuardarPostulacion {
    private final DaoOferta daoOferta;
    private final ServicioGuardarOferta servicioGuardarOferta;
    private final RepositorioPostulacion repositorioPostulacion;

    public Long ejecutar(Postulacion postulacion, Long idOferta){
        var respuestaOferta = this.daoOferta.consultarOferta(idOferta);
        var lista = new ArrayList<Postulacion>();
        lista.add(postulacion);
        respuestaOferta.setPostulaciones(lista);
        return this.repositorioPostulacion.guardarPostulacion(respuestaOferta);
    }

}
