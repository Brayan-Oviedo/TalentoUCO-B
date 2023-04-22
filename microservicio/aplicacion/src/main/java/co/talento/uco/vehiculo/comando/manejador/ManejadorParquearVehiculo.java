package co.talento.uco.vehiculo.comando.manejador;

import co.talento.uco.vehiculo.comando.RequestVehiculoTransaccion;
import co.talento.uco.vehiculo.comando.fabrica.FabricaVehiculo;
import co.talento.uco.vehiculo.servicio.ServicioParquearVehiculo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorParquearVehiculo {

    private final ServicioParquearVehiculo servicioParquearVehiculo;
    private final FabricaVehiculo fabricaVehiculo;

    public ManejadorParquearVehiculo(ServicioParquearVehiculo servicioParquearVehiculo, FabricaVehiculo fabricaVehiculo) {
        this.servicioParquearVehiculo = servicioParquearVehiculo;
        this.fabricaVehiculo = fabricaVehiculo;
    }

    public boolean ejecutar(RequestVehiculoTransaccion requestVehiculoTransaccion) {
        var vehiculo = this.fabricaVehiculo.crear(requestVehiculoTransaccion);
        return this.servicioParquearVehiculo.ejecutar(vehiculo);
    }
}
