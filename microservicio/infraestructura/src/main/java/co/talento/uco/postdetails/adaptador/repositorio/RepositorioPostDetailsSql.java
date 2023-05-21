package co.talento.uco.postdetails.adaptador.repositorio;

import co.talento.uco.postdetails.adaptador.MapperPostDetails;
import co.talento.uco.postdetails.adaptador.RepositorioPostDetailsJpa;
import co.talento.uco.postdetails.entidad.EntidadPostDetails;
import co.talento.uco.postdetails.modelo.dominio.PostDetails;
import co.talento.uco.postdetails.puerto.repositorio.RepositorioPoestDetails;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPostDetailsSql implements RepositorioPoestDetails {
    private final MapperPostDetails mapperPostDetails;
    private final RepositorioPostDetailsJpa repositorioPostDetailsJpa;

    public RepositorioPostDetailsSql(MapperPostDetails mapperPostDetails, RepositorioPostDetailsJpa repositorioPostDetailsJpa) {
        this.mapperPostDetails = mapperPostDetails;
        this.repositorioPostDetailsJpa = repositorioPostDetailsJpa;
    }

    @Override
    public boolean guardar(PostDetails postDetails) {
        EntidadPostDetails entidadPostDetails = this.mapperPostDetails.crearEntidad(postDetails);
        this.repositorioPostDetailsJpa.save(entidadPostDetails);
        return true;
    }

    @Override
    public boolean actualizar(PostDetails postDetails) {
        return false;
    }

    @Override
    public boolean eliminarPorId(String id) {
        this.repositorioPostDetailsJpa.deleteById(id);
        return true;
    }

    @Override
    public boolean existePorId(String id) {
        var lista = this.repositorioPostDetailsJpa.findById(id);
        if (lista == null) {
            return false;
        }
        return true;
    }
}
