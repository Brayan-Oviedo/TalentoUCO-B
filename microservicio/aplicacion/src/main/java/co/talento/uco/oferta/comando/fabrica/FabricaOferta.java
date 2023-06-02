package co.talento.uco.oferta.comando.fabrica;

import co.talento.uco.contacto.comando.fabrica.FabricaContacto;
import co.talento.uco.oferta.comando.SolicitudOfertaTransaccion;
import co.talento.uco.oferta.modelo.dominio.Oferta;
import co.talento.uco.oferta.modelo.dominio.OfertaDetalle;
import co.talento.uco.oferta.modelo.dtoRespuesta.RespuestaOferta;
import co.talento.uco.postdetails.comando.fabrica.FabricaPostDetails;
import co.talento.uco.postulacion.modelo.dominio.Postulacion;
import co.talento.uco.postulacion.modelo.dominio.PostulacionDetalle;
import co.talento.uco.postulaciones.comando.fabrica.FabricaPostulacion;
import co.talento.uco.usuario.comando.fabrica.FabricaUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class FabricaOferta {

    private final FabricaContacto fabricaContacto;
    private final FabricaPostDetails fabricaPostDetails;
    private final FabricaUsuario fabricaUsuario;
    private final FabricaPostulacion fabricaPostulacion;

    public OfertaDetalle crear(SolicitudOfertaTransaccion solicitudOfertaTransaccion){
        var postulaciones = new ArrayList<PostulacionDetalle>();
        var pustulacion = new PostulacionDetalle(new Date(),"asd");
        postulaciones.add(pustulacion);
        return new OfertaDetalle(
                this.fabricaPostDetails.crear(solicitudOfertaTransaccion.getRequestPostDetails()),
                this.fabricaContacto.crear(solicitudOfertaTransaccion.getRequestContactoTransaccion()),
                solicitudOfertaTransaccion.isEstaActivo(),
                solicitudOfertaTransaccion.getTags(),
                postulaciones
        );
    }

    public OfertaDetalle crearOfertaDetalleDeSolicitud(RespuestaOferta respuestaOferta){
        return new OfertaDetalle(
                respuestaOferta.getId(),
                fabricaPostDetails.crearDominio(respuestaOferta.getRespuestaPostDetails()),
                fabricaContacto.crearDominio(respuestaOferta.getRespuestaContacto()),
                respuestaOferta.isEstaActiva(),
                respuestaOferta.getTags(),
                fabricaPostulacion.crearPostulacionDetalles(respuestaOferta.getRespuestaPostulacions())
        );
    }



}
