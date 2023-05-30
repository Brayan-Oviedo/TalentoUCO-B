package co.talento.uco.oferta.adaptador.dao;

import co.talento.uco.oferta.adaptador.MapperOferta;
import co.talento.uco.oferta.adaptador.RepositorioOfertaJpa;
import co.talento.uco.oferta.modelo.dtoRespuesta.RespuestaOferta;
import co.talento.uco.oferta.puerto.dao.DaoOferta;
import org.springframework.stereotype.Repository;

@Repository
public class DaoOfertaSql implements DaoOferta {

    private final RepositorioOfertaJpa repositorioOfertaJpa;
    private final MapperOferta mapperOferta;

    public DaoOfertaSql(RepositorioOfertaJpa repositorioOfertaJpa, MapperOferta mapperOferta) {
        this.repositorioOfertaJpa = repositorioOfertaJpa;
        this.mapperOferta = mapperOferta;
    }

    @Override
    public RespuestaOferta consultarOferta(Long id) {
        var entidadOferta= this.repositorioOfertaJpa.findById(id).get();
        return this.mapperOferta.crearRespuesta(entidadOferta);
    }
}
