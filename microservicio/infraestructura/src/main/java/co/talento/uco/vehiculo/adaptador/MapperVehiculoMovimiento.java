package co.talento.uco.vehiculo.adaptador;

import co.talento.uco.vehiculo.entidad.EntidadVehiculoMovimiento;
import co.talento.uco.vehiculo.modelo.dominio.VehiculoMovimiento;
import co.talento.uco.vehiculo.modelo.dtoRespuesta.RespuestaVehiculoMovimiento;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperVehiculoMovimiento {

    private final MapperVehiculo mapperVehiculo;

    public MapperVehiculoMovimiento(MapperVehiculo mapperVehiculo) {
        this.mapperVehiculo = mapperVehiculo;
    }


    public RespuestaVehiculoMovimiento crearRespuesta(EntidadVehiculoMovimiento entidadVehiculo){

        return new RespuestaVehiculoMovimiento(
                entidadVehiculo.getId(),
                entidadVehiculo.getVehiculo().getPlaca(),
                entidadVehiculo.getTipoMovimiento(),
                entidadVehiculo.getFecha()
        );
    }


    public EntidadVehiculoMovimiento crearEntidad(VehiculoMovimiento vehiculoMovimiento){
        return new EntidadVehiculoMovimiento(
                this.mapperVehiculo.crearEntidad(vehiculoMovimiento.getVehiculo()),
                vehiculoMovimiento.obtenerTipoDeMovimiento(),
                vehiculoMovimiento.getFecha()
        );
    }

    public List<EntidadVehiculoMovimiento> crearEntidades(List<VehiculoMovimiento> vehiculoMovimientos) {
            var movimientos = new ArrayList<EntidadVehiculoMovimiento>();

        vehiculoMovimientos.forEach(movimiento -> {
            movimientos.add(this.crearEntidad(movimiento));
        });

        return movimientos;
    }

}
