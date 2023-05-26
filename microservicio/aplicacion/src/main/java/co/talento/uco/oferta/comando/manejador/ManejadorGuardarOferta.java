package co.talento.uco.oferta.comando.manejador;

import co.talento.uco.oferta.comando.SolicitudOfertaTransaccion;
import co.talento.uco.oferta.comando.fabrica.FabricaOferta;
import co.talento.uco.oferta.servicio.ServicioGuardarOferta;
import co.talento.uco.usuario.comando.manejador.ManejadorObtenerUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ManejadorGuardarOferta {
    private final FabricaOferta fabricaOferta;
    private final ServicioGuardarOferta servicioGuardarOferta;
    private final ManejadorObtenerUsuario manejadorObtenerUsuario;

    public Long ejecutar(SolicitudOfertaTransaccion solicitudOfertaTransaccion) {
        var usuario = this.manejadorObtenerUsuario.ejecutar(solicitudOfertaTransaccion.getSolicitudUsuarioConsulta());
        var ofertaDetalle = this.fabricaOferta.crear(solicitudOfertaTransaccion);
        return this.servicioGuardarOferta.ejecutar(ofertaDetalle, usuario);
    }
}
