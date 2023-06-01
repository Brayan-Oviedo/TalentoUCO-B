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

    private final RepositorioOferta repositorioOferta;
    private final MapperPostulacion mapperPostulacion;
    private final RepositorioPostulacionJpa repositorioPostulacionJpa;
    private final RepositorioOfertaJpa repositorioOfertaJpa;
    private final MapperOferta mapperOferta;

    public RepositorioPostulacionSql(RepositorioOferta repositorioOferta, MapperPostulacion mapperPostulacion, RepositorioPostulacionJpa repositorioPostulacionJpa, RepositorioOfertaJpa repositorioOfertaJpa, MapperOferta mapperOferta) {
        this.repositorioOferta = repositorioOferta;
        this.mapperPostulacion = mapperPostulacion;
        this.repositorioPostulacionJpa = repositorioPostulacionJpa;
        this.repositorioOfertaJpa = repositorioOfertaJpa;
        this.mapperOferta = mapperOferta;
    }


}
