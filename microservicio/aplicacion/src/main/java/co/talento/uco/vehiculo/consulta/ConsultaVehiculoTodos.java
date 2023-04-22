package co.talento.uco.vehiculo.consulta;

import co.talento.uco.vehiculo.modelo.dtoRespuesta.RespuestaVehiculo;
import co.talento.uco.vehiculo.puerto.dao.DaoVehiculo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsultaVehiculoTodos {

    private final DaoVehiculo daoVehiculo;

    public ConsultaVehiculoTodos(DaoVehiculo daoVehiculo) {
        this.daoVehiculo = daoVehiculo;
    }

    public List<RespuestaVehiculo> ejecutar(){
       return this.daoVehiculo.obtenerVehiculos();
    }
}
