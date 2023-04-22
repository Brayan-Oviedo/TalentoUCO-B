package co.talento.uco.vehiculo.servicio;

import co.talento.uco.vehiculo.TipoVehiculoMovimiento;
import co.talento.uco.vehiculo.puerto.dao.DaoVehiculoMovimiento;
import org.springframework.stereotype.Service;

@Service
public class ServicioObtenerEstadoVehiculo {

    private final DaoVehiculoMovimiento daoVehiculoMovimiento;

    public ServicioObtenerEstadoVehiculo(DaoVehiculoMovimiento daoVehiculoMovimiento) {
        this.daoVehiculoMovimiento = daoVehiculoMovimiento;
    }

    public boolean ejecutar(String vehiculoPlaca) {

        var ultimoMovimiento = this.daoVehiculoMovimiento.obtenerUltimoMovimientoPorVehiculo(vehiculoPlaca);

        if(ultimoMovimiento == null) {
            return false;
        }

        return ultimoMovimiento.getTipoMovimiento().equals(TipoVehiculoMovimiento.ENTRADA.name());
    }

}
