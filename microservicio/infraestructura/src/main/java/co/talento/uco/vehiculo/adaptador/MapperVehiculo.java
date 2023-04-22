package co.talento.uco.vehiculo.adaptador;

import co.talento.uco.vehiculo.entidad.EntidadVehiculo;
import co.talento.uco.vehiculo.modelo.dominio.Vehiculo;
import co.talento.uco.vehiculo.modelo.dtoRespuesta.RespuestaVehiculo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class MapperVehiculo {

    public List<RespuestaVehiculo> crearRespuestas(List<EntidadVehiculo> entidadVehiculos) {
        var respuestaVehiculos = new ArrayList<RespuestaVehiculo>();

        entidadVehiculos.forEach(entidadVehiculo -> {
            respuestaVehiculos.add(this.crearRespuesta(entidadVehiculo));
        });

        return respuestaVehiculos;
    }

    public RespuestaVehiculo crearRespuesta(EntidadVehiculo entidadVehiculo){

        return new RespuestaVehiculo(
                entidadVehiculo.getPlaca(),
                false
        );
    }

    public EntidadVehiculo crearEntidad(Vehiculo vehiculo){
        return new EntidadVehiculo(
                vehiculo.getPlaca()
        );
    }
}
