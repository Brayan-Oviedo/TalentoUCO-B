package co.talento.uco.vehiculo.consulta;

import co.talento.uco.vehiculo.servicio.ServicioObtenerEstadoVehiculo;
import org.springframework.stereotype.Component;

@Component
public class ConsultaEstadoVehiculo {

    private final ServicioObtenerEstadoVehiculo servicioObtenerEstadoVehiculo;

    public ConsultaEstadoVehiculo(ServicioObtenerEstadoVehiculo servicioObtenerEstadoVehiculo) {
        this.servicioObtenerEstadoVehiculo = servicioObtenerEstadoVehiculo;
    }

    public boolean ejecutar(String vehiculoPlaca) {
        return this.servicioObtenerEstadoVehiculo.ejecutar(vehiculoPlaca);
    }
}
