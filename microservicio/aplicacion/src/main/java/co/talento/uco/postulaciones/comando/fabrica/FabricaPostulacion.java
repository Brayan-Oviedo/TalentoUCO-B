package co.talento.uco.postulaciones.comando.fabrica;

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

    public Postulacion crearDominio(RespuestaPostulacion respuestaPostulacion){
        return new Postulacion(
                respuestaPostulacion.getId(),
                fabricaUsuario.crear(respuestaPostulacion.getRespuestaUsuario()),
                respuestaPostulacion.getFecha(),
                respuestaPostulacion.getAdjunto()
        );
    }

    public List<Postulacion> crearListaDominio(List<RespuestaPostulacion> respuestaPostulacions){
       return respuestaPostulacions.stream().map(this::crearDominio).toList();
    }

    public PostulacionDetalle crearPostulacionDetalle(SolicitudPostulacion solicitudPostulacion){
        return new PostulacionDetalle(
                solicitudPostulacion.getFecha(),
                solicitudPostulacion.getAdjunto()
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
