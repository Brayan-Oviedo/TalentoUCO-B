package co.talento.uco.vehiculo.puerto.dao;

import co.talento.uco.vehiculo.modelo.dtoRespuesta.RespuestaVehiculo;

import java.util.List;

public interface DaoVehiculo {

    RespuestaVehiculo obtenerVehiculoPorPlaca(String placa);
    List<RespuestaVehiculo> obtenerVehiculos();
    List<RespuestaVehiculo> obtenerPorUsuario(String nombreUsuario);
}
