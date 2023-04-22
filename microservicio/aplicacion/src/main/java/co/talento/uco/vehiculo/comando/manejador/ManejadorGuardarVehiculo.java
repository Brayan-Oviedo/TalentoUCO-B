package co.talento.uco.vehiculo.comando.manejador;

import co.talento.uco.vehiculo.comando.RequestVehiculoTransaccion;
import co.talento.uco.vehiculo.comando.fabrica.FabricaVehiculo;
import co.talento.uco.vehiculo.modelo.dtoRespuesta.RespuestaVehiculo;
import co.talento.uco.vehiculo.servicio.ServicioGuardarVehiculo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorGuardarVehiculo {

    private final FabricaVehiculo fabricaVehiculo;
    private final ServicioGuardarVehiculo servicioGuardarVehiculo;

    public ManejadorGuardarVehiculo(FabricaVehiculo fabricaVehiculo, ServicioGuardarVehiculo servicioGuardarVehiculo) {
        this.fabricaVehiculo = fabricaVehiculo;
        this.servicioGuardarVehiculo = servicioGuardarVehiculo;
    }

    public RespuestaVehiculo ejecutar(RequestVehiculoTransaccion requestVehiculoTransaccion) {
        var vehiculo = this.fabricaVehiculo.crear(requestVehiculoTransaccion);
        return this.servicioGuardarVehiculo.ejecutar(vehiculo);
    }

}
