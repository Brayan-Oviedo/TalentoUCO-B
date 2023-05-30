package co.talento.uco.oferta.adaptador.repositorio;

import co.talento.uco.oferta.adaptador.MapperOferta;
import co.talento.uco.oferta.adaptador.RepositorioOfertaJpa;
import co.talento.uco.oferta.modelo.dominio.Oferta;
import co.talento.uco.oferta.modelo.dtoRespuesta.RespuestaOferta;
import co.talento.uco.oferta.puerto.repositorio.RepositorioOferta;
import co.talento.uco.postulacion.adaptador.MapperPostulacion;
import co.talento.uco.postulacion.modelo.dominio.Postulacion;
import co.talento.uco.postulacion.modelo.respuesta.RespuestaPostulacion;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class RepositorioOfertaSql implements RepositorioOferta {

    private final RepositorioOfertaJpa repositorioOfertaJpa;
    private final RepositorioOferta repositorioOferta;
    private final MapperPostulacion mapperPostulacion;

    private final MapperOferta mapperOferta;

    public RepositorioOfertaSql(RepositorioOfertaJpa repositorioOfertaJpa, RepositorioOferta repositorioOferta, MapperPostulacion mapperPostulacion, MapperOferta mapperOferta) {
        this.repositorioOfertaJpa = repositorioOfertaJpa;
        this.repositorioOferta = repositorioOferta;
        this.mapperPostulacion = mapperPostulacion;
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

    @Override
    public RespuestaOferta consultarOferta(Long id) {
        var entidadOferta= this.repositorioOfertaJpa.findById(id).get();
        return this.mapperOferta.crearRespuesta(entidadOferta);
    }

    @Override
    public boolean guardarPostulacion(Postulacion postulacion, Long idOferta) {
        var respuestOferta = this.repositorioOferta.consultarOferta(idOferta);
        var lista = new ArrayList<RespuestaPostulacion>();
        lista.add(this.mapperPostulacion.crearRespuesta(this.mapperPostulacion.crearEntidad(postulacion)));
        respuestOferta.setRespuestaPostulacions(lista);
        this.repositorioOfertaJpa.save(respuestOferta);
        return false;
    }
}
