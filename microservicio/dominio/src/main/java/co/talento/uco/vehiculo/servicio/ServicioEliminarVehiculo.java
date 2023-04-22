package co.talento.uco.vehiculo.servicio;

import co.talento.uco.excepcion.ExcepcionInexistente;
import co.talento.uco.vehiculo.puerto.dao.DaoVehiculo;
import co.talento.uco.vehiculo.puerto.repositorio.RepositorioVehiculo;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarVehiculo {

    private static final String NO_SE_PUDO_ELIMINAR_EL_VEHICULO = "No se pudo eliminar";

    private final RepositorioVehiculo repositorioVehiculo;
    private final DaoVehiculo daoVehiculo;


    public ServicioEliminarVehiculo(RepositorioVehiculo repositorioVehiculo, DaoVehiculo daoVehiculo) {
        this.repositorioVehiculo = repositorioVehiculo;
        this.daoVehiculo = daoVehiculo;
    }


    public boolean ejecutar(String placa){
        validarExistencia(placa);
        var vehiculo = this.daoVehiculo.obtenerVehiculoPorPlaca(placa);
        return this.repositorioVehiculo.eliminarPorPlaca(vehiculo.getPlaca());
    }


    private void validarExistencia(String placa){
        if (!this.repositorioVehiculo.existePorPlaca(placa)) {
            throw new ExcepcionInexistente(NO_SE_PUDO_ELIMINAR_EL_VEHICULO);
        }
    }

}
