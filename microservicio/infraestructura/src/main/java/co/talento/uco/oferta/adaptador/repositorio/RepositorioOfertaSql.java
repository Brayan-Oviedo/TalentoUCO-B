package co.talento.uco.oferta.adaptador.repositorio;

import co.talento.uco.oferta.adaptador.MapperOferta;
import co.talento.uco.oferta.adaptador.RepositorioOfertaJpa;
import co.talento.uco.oferta.modelo.dominio.Oferta;
import co.talento.uco.oferta.puerto.repositorio.RepositorioOferta;
import co.talento.uco.postulacion.adaptador.MapperPostulacion;
import org.springframework.stereotype.Repository;


@Repository
public class RepositorioOfertaSql implements RepositorioOferta {

    private final RepositorioOfertaJpa repositorioOfertaJpa;

    private final MapperOferta mapperOferta;

    public RepositorioOfertaSql(RepositorioOfertaJpa repositorioOfertaJpa, MapperOferta mapperOferta) {
        this.repositorioOfertaJpa = repositorioOfertaJpa;
        this.mapperOferta = mapperOferta;
    }


    @Override
    public Long guardar(Oferta oferta) {
        var entidadOferta = this.mapperOferta.crearEntidadOferta(oferta);
        return this.repositorioOfertaJpa.save(entidadOferta).getIdOferta();
    }

    @Override
    public boolean eliminarPorId(Long id) {
        this.repositorioOfertaJpa.deleteById(id);
        return true;
    }


}
