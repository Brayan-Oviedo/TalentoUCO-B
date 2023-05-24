package co.talento.uco.postdetails.puerto.repositorio;

import co.talento.uco.postdetails.modelo.dominio.PostDetails;

public interface RepositorioPoestDetails {

    boolean guardar(PostDetails postDetails);

    boolean actualizar(PostDetails postDetails);

    boolean eliminarPorId(String id);

    boolean existePorId(String id);
}
