package co.talento.uco.postulacion.servicio;

import co.talento.uco.oferta.modelo.dtoRespuesta.RespuestaOferta;
import co.talento.uco.oferta.puerto.repositorio.DaoOferta;
import co.talento.uco.oferta.servicio.ServicioGuardarOferta;
import co.talento.uco.oferta.servicio.ServicioGuardarOfertaConPostulacion;
import co.talento.uco.postulacion.modelo.dominio.Postulacion;
import co.talento.uco.postulacion.modelo.respuesta.RespuestaPostulacion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServicioGuardarPostulacion {

    private final DaoOferta daoOferta;

    private final ServicioGuardarOfertaConPostulacion servicioGuardarOfertaConPostulacion;

    public RespuestaOferta ejecutar(Long id, Postulacion postulacion){
        var oferta = this.daoOferta.consultarOferta(id);
        this.servicioGuardarOferta.ejecutar(o)
    }

}
