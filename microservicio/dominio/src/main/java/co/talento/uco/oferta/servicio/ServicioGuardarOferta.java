package co.talento.uco.oferta.servicio;

import co.talento.uco.oferta.modelo.dominio.OfertaDetalle;
import co.talento.uco.oferta.puerto.repositorio.RepositorioOferta;
import co.talento.uco.usuario.modelo.dtoRespuesta.RespuestaUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServicioGuardarOferta {
    private final RepositorioOferta repositorioOferta;
    private final ServicioProcesarOferta servicioProcesarOferta;

    public Long ejecutar(OfertaDetalle ofertaDetalle, RespuestaUsuario respuestaUsuario) {
        var oferta = this.servicioProcesarOferta.ejecutar(ofertaDetalle, respuestaUsuario);
        return this.repositorioOferta.guardar(oferta);
    }
}
