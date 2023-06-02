package co.talento.uco.postulacion.adaptador.dao;

import co.talento.uco.oferta.adaptador.MapperOferta;
import co.talento.uco.oferta.modelo.dominio.Oferta;
import co.talento.uco.postulacion.adaptador.MapperPostulacion;
import co.talento.uco.postulacion.adaptador.RepositorioPostulacionJpa;
import co.talento.uco.postulacion.modelo.respuesta.RespuestaPostulacion;
import co.talento.uco.postulacion.puerto.dao.DaoPostulacion;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoPostulacionSql implements DaoPostulacion {

    public static final String LA_OFERTA_NO_EXISTE = "La oferta no existe";
    private final RepositorioPostulacionJpa repositorioPostulacionJpa;
    private final MapperPostulacion mapperPostulacion;
    private final MapperOferta mapperOferta;

    public DaoPostulacionSql(RepositorioPostulacionJpa repositorioPostulacionJpa, MapperPostulacion mapperPostulacion, MapperOferta mapperOferta) {
        this.repositorioPostulacionJpa = repositorioPostulacionJpa;
        this.mapperPostulacion = mapperPostulacion;
        this.mapperOferta = mapperOferta;
    }

    @Override
    public List<RespuestaPostulacion> obtenerPorOferta(Oferta oferta) {
        var entidadOferta = this.mapperOferta.crearEntidadOferta(oferta);
        var respuesta = this.mapperPostulacion.crearListaRespuesta(this.repositorioPostulacionJpa.findByOferta(entidadOferta));
        return respuesta;
    }
}
