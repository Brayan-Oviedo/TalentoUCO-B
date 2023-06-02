package co.talento.uco.postulaciones.comando.manejador;

import co.talento.uco.oferta.comando.consulta.ConsultaOferta;
import co.talento.uco.oferta.comando.fabrica.FabricaOferta;
import co.talento.uco.postulacion.servicio.ServicioGuardarPostulacion;
import co.talento.uco.postulaciones.comando.SolicitudPostulacion;
import co.talento.uco.postulaciones.comando.fabrica.FabricaPostulacion;
import co.talento.uco.usuario.comando.manejador.ManejadorObtenerUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ManejadorGuardarPostulaciones {
    private final ServicioGuardarPostulacion servicioGuardarPostulacion;
    private final ConsultaOferta consultaOferta;
    private final ManejadorObtenerUsuario manejadorObtenerUsuario;
    private final FabricaPostulacion fabricaPostulacion;
    private final FabricaOferta fabricaOferta;

    public boolean ejecutar(SolicitudPostulacion solicitudPostulacion){
        var respuestaOferta = this.consultaOferta.consultar(solicitudPostulacion.getIdOferta());
        var ofertaDetalle = this.fabricaOferta.crearOfertaDetalleDeSolicitud(respuestaOferta);
        var respuestaUsuario = this.manejadorObtenerUsuario.ejecutar(solicitudPostulacion.getSolicitudUsuarioConsulta());
        var postulacionDetalle = this.fabricaPostulacion.crearPostulacionDetalle(solicitudPostulacion,ofertaDetalle);
        return this.servicioGuardarPostulacion.ejecutar(postulacionDetalle, respuestaUsuario);
    }

}
