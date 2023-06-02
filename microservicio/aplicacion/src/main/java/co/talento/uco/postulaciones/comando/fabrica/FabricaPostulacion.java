package co.talento.uco.postulaciones.comando.fabrica;

import co.talento.uco.oferta.comando.fabrica.FabricaOferta;
import co.talento.uco.oferta.modelo.dominio.OfertaDetalle;
import co.talento.uco.postulacion.modelo.dominio.Postulacion;
import co.talento.uco.postulacion.modelo.dominio.PostulacionDetalle;
import co.talento.uco.postulacion.modelo.respuesta.RespuestaPostulacion;
import co.talento.uco.postulaciones.comando.SolicitudPostulacion;
import co.talento.uco.usuario.comando.fabrica.FabricaUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FabricaPostulacion {
    private final FabricaUsuario fabricaUsuario;
    private final FabricaOferta fabricaOferta;

    /*public Postulacion crearDominio(RespuestaPostulacion respuestaPostulacion){
        return new Postulacion(
                respuestaPostulacion.getId(),
                fabricaUsuario.crear(respuestaPostulacion.getRespuestaUsuario()),
                respuestaPostulacion.getFecha(),
                respuestaPostulacion.getAdjunto(),
                fabricaOferta.respuestaPostulacion.getRespuestaOferta()
        );
    }*/

    /*public List<Postulacion> crearListaDominio(List<RespuestaPostulacion> respuestaPostulacions){
       return respuestaPostulacions.stream().map(this::crearDominio).toList();
    }*/

    public PostulacionDetalle crearPostulacionDetalle(SolicitudPostulacion solicitudPostulacion, OfertaDetalle ofertaDetalle){
        return new PostulacionDetalle(
                solicitudPostulacion.getFecha(),
                solicitudPostulacion.getAdjunto(),
                ofertaDetalle
        );
    }

    public PostulacionDetalle crearPostulacionDetalleDeSolicitud(RespuestaPostulacion respuestaPostulacion){
        return new PostulacionDetalle(
                respuestaPostulacion.getId(),
                respuestaPostulacion.getFecha(),
                respuestaPostulacion.getAdjunto()
        );
    }

    public List<PostulacionDetalle> crearPostulacionDetalles(List<RespuestaPostulacion> respuestaPostulaciones){
        return respuestaPostulaciones.stream().map(this::crearPostulacionDetalleDeSolicitud).toList();
    }
}
