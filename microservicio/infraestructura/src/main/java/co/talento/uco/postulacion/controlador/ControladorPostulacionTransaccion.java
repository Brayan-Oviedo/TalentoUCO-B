package co.talento.uco.postulacion.controlador;

import co.talento.uco.oferta.comando.SolicitudOfertaTransaccion;
import co.talento.uco.postulaciones.comando.SolicitudPostulacion;
import co.talento.uco.postulaciones.comando.manejador.ManejadorGuardarPostulaciones;
import co.talento.uco.usuario.comando.SolicitudUsuarioConsulta;
import co.talento.uco.usuario.comando.manejador.ManejadorObtenerUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/postulacion")
public class ControladorPostulacionTransaccion {

    private final ManejadorGuardarPostulaciones manejadorGuardarPostulaciones;
    private final ManejadorObtenerUsuario manejadorObtenerUsuario;
    @Autowired
    public ControladorPostulacionTransaccion(ManejadorGuardarPostulaciones manejadorGuardarPostulaciones, ManejadorObtenerUsuario manejadorObtenerUsuario) {
        this.manejadorGuardarPostulaciones = manejadorGuardarPostulaciones;
        this.manejadorObtenerUsuario = manejadorObtenerUsuario;
    }




    @PostMapping
    public Long guardarPostulacion(@RequestBody SolicitudPostulacion solicitudPostulacion,Long id) {
        return this.manejadorGuardarPostulaciones.ejecutar(solicitudPostulacion,id);
    }

}
