package co.talento.uco.vehiculo.controlador;

import co.talento.uco.vehiculo.comando.RequestVehiculoTransaccion;
import co.talento.uco.vehiculo.comando.manejador.ManejadorEliminarVehiculo;
import co.talento.uco.vehiculo.comando.manejador.ManejadorGuardarVehiculo;
import co.talento.uco.vehiculo.comando.manejador.ManejadorParquearVehiculo;
import co.talento.uco.vehiculo.modelo.dtoRespuesta.RespuestaVehiculo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/vehiculo")
public class ControladorVehiculoTransaccion {

   private final ManejadorGuardarVehiculo manejadorGuardarVehiculo;
   private final ManejadorParquearVehiculo manejadorParquearVehiculo;
   private final ManejadorEliminarVehiculo manejadorEliminarVehiculo;

    public ControladorVehiculoTransaccion(ManejadorGuardarVehiculo manejadorGuardarVehiculo, ManejadorParquearVehiculo manejadorParquearVehiculo, ManejadorEliminarVehiculo manejadorEliminarVehiculo) {
        this.manejadorGuardarVehiculo = manejadorGuardarVehiculo;
        this.manejadorParquearVehiculo = manejadorParquearVehiculo;
        this.manejadorEliminarVehiculo = manejadorEliminarVehiculo;
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public boolean parquearVehiculo(@RequestBody RequestVehiculoTransaccion requestVehiculoTransaccion) {
        return this.manejadorParquearVehiculo.ejecutar(requestVehiculoTransaccion);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public RespuestaVehiculo guardarVehiculo(@RequestBody RequestVehiculoTransaccion requestVehiculoTransaccion) {
        return this.manejadorGuardarVehiculo.ejecutar(requestVehiculoTransaccion);
    }

    @DeleteMapping(value = "/{placa}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public boolean eliminarVehiculo(@PathVariable String placa) {
        return this.manejadorEliminarVehiculo.ejecutar(placa);
    }

}
