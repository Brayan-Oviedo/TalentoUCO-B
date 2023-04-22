package co.talento.uco.vehiculo.puerto.dao;

import co.talento.uco.vehiculo.modelo.dtoRespuesta.RespuestaVehiculoMovimiento;


public interface DaoVehiculoMovimiento {

    RespuestaVehiculoMovimiento obtenerUltimoMovimientoPorVehiculo(String vehiculoPlaca);
}
