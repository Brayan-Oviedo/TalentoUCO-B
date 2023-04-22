package co.talento.uco.vehiculo.puerto.repositorio;

import co.talento.uco.vehiculo.modelo.dominio.VehiculoMovimiento;

public interface RepositorioVehiculoMqp {

    void procesarMovimiento(VehiculoMovimiento vehiculoMovimiento);
}
