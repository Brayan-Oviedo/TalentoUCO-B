package co.talento.uco.oferta.adaptador.dao;

import co.talento.uco.excepcion.ExcepcionInexistente;
import co.talento.uco.oferta.adaptador.MapperOferta;
import co.talento.uco.oferta.adaptador.RepositorioOfertaJpa;
import co.talento.uco.oferta.modelo.dtoRespuesta.RespuestaOferta;
import co.talento.uco.oferta.puerto.dao.DaoOferta;
import co.talento.uco.postulacion.adaptador.MapperPostulacion;
import co.talento.uco.postulacion.puerto.dao.DaoPostulacion;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoOfertaSql implements DaoOferta {

    public static final String LA_OFERTA_NO_EXISTE = "La oferta no existe";
    private final RepositorioOfertaJpa repositorioOfertaJpa;
    private final DaoPostulacion daoPostulacion;
    private final MapperOferta mapperOferta;

    public DaoOfertaSql(RepositorioOfertaJpa repositorioOfertaJpa, DaoPostulacion daoPostulacion, MapperOferta mapperOferta) {
        this.repositorioOfertaJpa = repositorioOfertaJpa;
        this.daoPostulacion = daoPostulacion;
        this.mapperOferta = mapperOferta;
    }

    @Override
    public RespuestaOferta consultarOferta(Long id) {

        if(!this.repositorioOfertaJpa.existsById(id)) {
           throw new ExcepcionInexistente(LA_OFERTA_NO_EXISTE);
        }

        var entidadOferta = this.repositorioOfertaJpa.findById(id).get();
        var respuestaPostulaciones = this.daoPostulacion.obtenerPorOferta(this.mapperOferta.crearDominio(entidadOferta));
        return this.mapperOferta.crearRespuestaDesdeEntidad(entidadOferta, respuestaPostulaciones);
    }

    @Override
    public List<RespuestaOferta> consultarOfertalista() {
        var listaEntidad = this.repositorioOfertaJpa.findAll();
        return this.mapperOferta.crearListaRespuestaOfertaDesdeEntidad(listaEntidad);
    }
}
