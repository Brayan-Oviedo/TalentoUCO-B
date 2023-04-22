package co.talento.uco.vehiculo.puerto.repositorio;

import co.talento.uco.vehiculo.modelo.dominio.Vehiculo;


public interface RepositorioVehiculo {

    String guardar(Vehiculo vehiculo);
    boolean actualizar(Vehiculo vehiculo);
    boolean existePorPlaca(String placa);
    boolean eliminarPorPlaca(String placa);
}
