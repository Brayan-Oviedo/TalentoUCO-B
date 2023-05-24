package co.talento.uco.oferta.servicio;

import co.talento.uco.oferta.modelo.dominio.Oferta;
import co.talento.uco.oferta.puerto.repositorio.RepositorioOferta;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServicioGuardarOferta {
    private final RepositorioOferta repositorioOferta;

    public Long ejecutar(Oferta oferta){
        return this.repositorioOferta.guardar(oferta);
    }
}
