package co.talento.uco.oferta.controlador;

import co.talento.uco.oferta.comando.SolicitudOfertaTransaccion;
import co.talento.uco.oferta.comando.consulta.ConsultaOfertaLista;
import co.talento.uco.oferta.comando.manejador.ManejadorGuardarOferta;
import co.talento.uco.oferta.modelo.dtoRespuesta.RespuestaOferta;
import co.talento.uco.usuario.comando.SolicitudUsuarioConsulta;
import co.talento.uco.usuario.comando.manejador.ManejadorObtenerUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oferta")
public class ControladorOfertaTransaccion {

    private final ManejadorGuardarOferta manejadorGuardarOferta;
    private final ManejadorObtenerUsuario manejadorObtenerUsuario;
    private final ConsultaOfertaLista consultaOfertaLista;

    @Autowired
    public ControladorOfertaTransaccion(ManejadorGuardarOferta manejadorGuardarOferta, ManejadorObtenerUsuario manejadorObtenerUsuario, ConsultaOfertaLista consultaOfertaLista) {
        this.manejadorGuardarOferta = manejadorGuardarOferta;
        this.manejadorObtenerUsuario = manejadorObtenerUsuario;
        this.consultaOfertaLista = consultaOfertaLista;
    }

    @PostMapping
    public Long guardarOferta(@RequestBody SolicitudOfertaTransaccion solicitudOfertaTransaccion) {
        return this.manejadorGuardarOferta.ejecutar(solicitudOfertaTransaccion);
    }

    @GetMapping
    public List<RespuestaOferta> obtenerOfertas() {
        return this.consultaOfertaLista.consultar();
    }
}
