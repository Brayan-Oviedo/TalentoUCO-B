package co.talento.uco.vehiculo.adaptador.dao;

import co.talento.uco.vehiculo.adaptador.MapperVehiculo;
import co.talento.uco.vehiculo.adaptador.MapperVehiculoMovimiento;
import co.talento.uco.vehiculo.adaptador.RepositorioVehiculoMovimientoJpa;
import co.talento.uco.vehiculo.modelo.dtoRespuesta.RespuestaVehiculoMovimiento;
import co.talento.uco.vehiculo.puerto.dao.DaoVehiculo;
import co.talento.uco.vehiculo.puerto.dao.DaoVehiculoMovimiento;
import org.springframework.stereotype.Component;

@Component
public class DaoVehiculoMovimientoSql implements DaoVehiculoMovimiento {

    private final RepositorioVehiculoMovimientoJpa repositorioVehiculoMovimientoJpa;
    private final DaoVehiculo daoVehiculo;
    private final MapperVehiculo mapperVehiculo;
    private final MapperVehiculoMovimiento mapperVehiculoMovimiento;

    public DaoVehiculoMovimientoSql(RepositorioVehiculoMovimientoJpa repositorioVehiculoMovimientoJpa, DaoVehiculo daoVehiculo, MapperVehiculo mapperVehiculo, MapperVehiculoMovimiento mapperVehiculoMovimiento) {
        this.repositorioVehiculoMovimientoJpa = repositorioVehiculoMovimientoJpa;
        this.daoVehiculo = daoVehiculo;
        this.mapperVehiculo = mapperVehiculo;
        this.mapperVehiculoMovimiento = mapperVehiculoMovimiento;
    }

    @Override
    public RespuestaVehiculoMovimiento obtenerUltimoMovimientoPorVehiculo(String vehiculoPlaca) {
        var ultimoMovimiento = this.repositorioVehiculoMovimientoJpa.obtenerUltimoMovimientoPorVehiculo(
                vehiculoPlaca
        );
        return ultimoMovimiento.map(this.mapperVehiculoMovimiento::crearRespuesta).orElse(null);
    }
}

