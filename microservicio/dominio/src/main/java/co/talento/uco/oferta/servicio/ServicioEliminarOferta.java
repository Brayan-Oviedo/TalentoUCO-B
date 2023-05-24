package co.talento.uco.oferta.servicio;

import co.talento.uco.oferta.puerto.repositorio.RepositorioOferta;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServicioEliminarOferta {
    private final RepositorioOferta repositorioOferta;

    public boolean ejecutar(Long id){
        return this.repositorioOferta.eliminarPorId(id);
    }


}
