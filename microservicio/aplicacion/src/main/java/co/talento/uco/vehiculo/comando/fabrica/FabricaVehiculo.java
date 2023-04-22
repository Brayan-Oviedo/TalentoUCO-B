package co.talento.uco.vehiculo.comando.fabrica;

import co.talento.uco.vehiculo.comando.RequestVehiculoTransaccion;
import co.talento.uco.vehiculo.modelo.dominio.Vehiculo;
import org.springframework.stereotype.Component;


@Component
public class FabricaVehiculo {

    public Vehiculo crear(RequestVehiculoTransaccion requestVehiculoTransaccion){
        return new Vehiculo(
                requestVehiculoTransaccion.getPlaca()
        );
    }
}
