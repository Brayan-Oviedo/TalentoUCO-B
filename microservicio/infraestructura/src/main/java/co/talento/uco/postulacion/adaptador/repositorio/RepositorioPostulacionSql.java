package co.talento.uco.postulacion.adaptador.repositorio;

import co.talento.uco.oferta.adaptador.MapperOferta;
import co.talento.uco.oferta.adaptador.RepositorioOfertaJpa;
import co.talento.uco.oferta.modelo.dominio.Oferta;
import co.talento.uco.oferta.modelo.dtoRespuesta.RespuestaOferta;
import co.talento.uco.oferta.puerto.repositorio.RepositorioOferta;
import co.talento.uco.postulacion.adaptador.MapperPostulacion;
import co.talento.uco.postulacion.adaptador.RepositorioPostulacionJpa;
import co.talento.uco.postulacion.puerto.repositorio.RepositorioPostulacion;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPostulacionSql implements RepositorioPostulacion {

    private final MapperPostulacion mapperPostulacion;
    private final RepositorioPostulacionJpa repositorioPostulacionJpa;

    public RepositorioPostulacionSql(MapperPostulacion mapperPostulacion, RepositorioPostulacionJpa repositorioPostulacionJpa) {
        this.mapperPostulacion = mapperPostulacion;
        this.repositorioPostulacionJpa = repositorioPostulacionJpa;
    }
}
