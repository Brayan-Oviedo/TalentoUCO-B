package co.talento.uco.vehiculo.consulta;

import co.talento.uco.vehiculo.modelo.dtoRespuesta.RespuestaVehiculo;
import co.talento.uco.vehiculo.puerto.dao.DaoVehiculo;
import org.springframework.stereotype.Component;

@Component
public class ConsultaVehiculo {

    private final DaoVehiculo daoVehiculo;
    private final ConsultaEstadoVehiculo consultaEstadoVehiculo;

    public ConsultaVehiculo(DaoVehiculo daoVehiculo, ConsultaEstadoVehiculo consultaEstadoVehiculo) {
        this.daoVehiculo = daoVehiculo;
        this.consultaEstadoVehiculo = consultaEstadoVehiculo;
    }

    public RespuestaVehiculo ejecutar(String placa){
       var vehiculo = this.daoVehiculo.obtenerVehiculoPorPlaca(placa);
       vehiculo.setActivo(this.consultaEstadoVehiculo.ejecutar(placa));
       return vehiculo;
    }
}
