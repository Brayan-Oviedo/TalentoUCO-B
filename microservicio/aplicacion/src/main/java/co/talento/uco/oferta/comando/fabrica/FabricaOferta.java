package co.talento.uco.oferta.comando.fabrica;

import co.talento.uco.contacto.comando.fabrica.FabricaContacto;
import co.talento.uco.oferta.comando.SolicitudOfertaTransaccion;
import co.talento.uco.oferta.modelo.dominio.OfertaDetalle;
import co.talento.uco.oferta.modelo.dtoRespuesta.RespuestaOferta;
import co.talento.uco.postdetails.comando.fabrica.FabricaPostDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FabricaOferta {

    private final FabricaContacto fabricaContacto;
    private final FabricaPostDetails fabricaPostDetails;

    public OfertaDetalle crear(SolicitudOfertaTransaccion solicitudOfertaTransaccion){
        return new OfertaDetalle(
                this.fabricaPostDetails.crear(solicitudOfertaTransaccion.getRequestPostDetails()),
                this.fabricaContacto.crear(solicitudOfertaTransaccion.getRequestContactoTransaccion()),
                solicitudOfertaTransaccion.isEstaActivo(),
                solicitudOfertaTransaccion.getTags()
        );
    }

    public OfertaDetalle crearOfertaDetalleDeSolicitud(RespuestaOferta respuestaOferta){
        return new OfertaDetalle(
                respuestaOferta.getId(),
                fabricaPostDetails.crearDominio(respuestaOferta.getRespuestaPostDetails()),
                fabricaContacto.crearDominio(respuestaOferta.getRespuestaContacto()),
                respuestaOferta.isEstaActiva(),
                respuestaOferta.getTags()
        );
    }



}
