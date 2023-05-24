package co.talento.uco.oferta.puerto.repositorio;

import co.talento.uco.oferta.modelo.dominio.Oferta;

public interface RepositorioOferta {

    Long guardar(Oferta oferta);

    boolean eliminarPorId(Long id);

}
