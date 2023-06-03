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
                this.fabricaPostDetails.crear(solicitudOfertaTransaccion.getPostDetalles()),
                this.fabricaContacto.crear(solicitudOfertaTransaccion.getContacto()),
                solicitudOfertaTransaccion.isEstaActiva(),
                solicitudOfertaTransaccion.getTags()
        );
    }

    public OfertaDetalle crearOfertaDetalleDeSolicitud(RespuestaOferta respuestaOferta){
        return new OfertaDetalle(
                respuestaOferta.getId(),
                fabricaPostDetails.crearDominio(respuestaOferta.getPostDetalles()),
                fabricaContacto.crearDominio(respuestaOferta.getContacto()),
                respuestaOferta.isEstaActiva(),
                respuestaOferta.getTags()
        );
    }



}
