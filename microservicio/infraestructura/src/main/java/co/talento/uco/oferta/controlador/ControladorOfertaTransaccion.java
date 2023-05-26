package co.talento.uco.oferta.controlador;

import co.talento.uco.oferta.comando.SolicitudOfertaTransaccion;
import co.talento.uco.oferta.comando.manejador.ManejadorGuardarOferta;
import co.talento.uco.usuario.comando.SolicitudUsuarioConsulta;
import co.talento.uco.usuario.comando.manejador.ManejadorObtenerUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oferta")
public class ControladorOfertaTransaccion {

    private final ManejadorGuardarOferta manejadorGuardarOferta;
    private final ManejadorObtenerUsuario manejadorObtenerUsuario;

    @Autowired
    public ControladorOfertaTransaccion(ManejadorGuardarOferta manejadorGuardarOferta, ManejadorObtenerUsuario manejadorObtenerUsuario) {
        this.manejadorGuardarOferta = manejadorGuardarOferta;
        this.manejadorObtenerUsuario = manejadorObtenerUsuario;
    }

    @PostMapping
    public Long guardarOferta(@RequestBody SolicitudOfertaTransaccion solicitudOfertaTransaccion) {
        return this.manejadorGuardarOferta.ejecutar(solicitudOfertaTransaccion);
    }


    @GetMapping
    public String getJson() {
        return this.manejadorObtenerUsuario.ejecutar(new SolicitudUsuarioConsulta("fan")).toString();
        /*return new Gson().toJson(new SolicitudOfertaTransaccion(
                new SolicitudUsuarioConsulta("fan"),
                new RequestPostDetails("Primer post", "Prueba microservicio"),
                new RequestContactoTransaccion("Contacto", "contacto@gmail.com", "3500000000", "Marinilla", "Cra"),
                true,
                new ArrayList<String>()
        ));*/
    }

}
