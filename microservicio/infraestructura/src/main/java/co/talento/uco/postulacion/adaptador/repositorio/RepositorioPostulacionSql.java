package co.talento.uco.postulacion.adaptador.repositorio;

import co.talento.uco.oferta.puerto.repositorio.RepositorioOferta;
import co.talento.uco.postulacion.adaptador.MapperPostulacion;
import co.talento.uco.postulacion.adaptador.RepositorioPostulacionJpa;
import co.talento.uco.postulacion.modelo.dominio.Postulacion;
import co.talento.uco.postulacion.modelo.respuesta.RespuestaPostulacion;
import co.talento.uco.postulacion.puerto.repositorio.RepositorioPostulacion;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class RepositorioPostulacionSql implements RepositorioPostulacion {

    private final RepositorioOferta repositorioOferta;
    private final MapperPostulacion mapperPostulacion;
    private final RepositorioPostulacionJpa repositorioPostulacionJpa;

    public RepositorioPostulacionSql(RepositorioOferta repositorioOferta, MapperPostulacion mapperPostulacion, RepositorioPostulacionJpa repositorioPostulacionJpa) {
        this.repositorioOferta = repositorioOferta;
        this.mapperPostulacion = mapperPostulacion;
        this.repositorioPostulacionJpa = repositorioPostulacionJpa;
    }


}
