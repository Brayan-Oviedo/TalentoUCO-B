package co.talento.uco.vehiculo.adaptador.repositorio;

import co.talento.uco.rabbitmq.adaptador.EscritorMensaje;
import co.talento.uco.vehiculo.adaptador.MapperVehiculo;
import co.talento.uco.vehiculo.modelo.dominio.VehiculoMovimiento;
import co.talento.uco.vehiculo.puerto.repositorio.RepositorioVehiculoMqp;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioVehiculoRabbitMq implements RepositorioVehiculoMqp {

    private final EscritorMensaje escritorMensaje;
    private final MapperVehiculo mapperVehiculo;

    public RepositorioVehiculoRabbitMq(EscritorMensaje escritorMensaje, MapperVehiculo mapperVehiculo) {
        this.escritorMensaje = escritorMensaje;
        this.mapperVehiculo = mapperVehiculo;
    }

    @Override
    public void procesarMovimiento(VehiculoMovimiento vehiculoMovimiento) {
        this.escritorMensaje.escribirMensaje(vehiculoMovimiento);
    }
}
