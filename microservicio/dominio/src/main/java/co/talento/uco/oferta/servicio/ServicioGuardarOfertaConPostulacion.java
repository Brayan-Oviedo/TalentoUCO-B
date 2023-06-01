package co.talento.uco.oferta.servicio;

import co.talento.uco.oferta.modelo.dominio.Oferta;
import co.talento.uco.oferta.modelo.dominio.OfertaDetalle;
import co.talento.uco.oferta.puerto.repositorio.RepositorioOferta;
import co.talento.uco.postulacion.modelo.dominio.Postulacion;
import co.talento.uco.usuario.modelo.dtoRespuesta.RespuestaUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServicioGuardarOfertaConPostulacion {
    private final RepositorioOferta repositorioOferta;
    private final ServicioProcesarOfertaConPostulacion servicioProcesarOfertaConPostulacion;

    public Long ejecutar(Oferta oferta) {
        return this.repositorioOferta.guardar(oferta);
    }
}
