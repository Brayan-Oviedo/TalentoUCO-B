package co.talento.uco.vehiculo.servicio;

import co.talento.uco.excepcion.ExcepcionDuplicidad;
import co.talento.uco.vehiculo.modelo.dtoRespuesta.RespuestaVehiculo;
import co.talento.uco.vehiculo.puerto.dao.DaoVehiculo;
import co.talento.uco.vehiculo.puerto.repositorio.RepositorioVehiculo;
import co.talento.uco.vehiculo.modelo.dominio.Vehiculo;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarVehiculo {

    private static final String NO_SE_PUDO_GUARDAR = "No se pudo guardar";

    private final RepositorioVehiculo repositorioVehiculo;
    private final DaoVehiculo daoVehiculo;


    public ServicioGuardarVehiculo(RepositorioVehiculo repositorioVehiculo, DaoVehiculo daoVehiculo) {
        this.repositorioVehiculo = repositorioVehiculo;
        this.daoVehiculo = daoVehiculo;
    }


    public RespuestaVehiculo ejecutar(Vehiculo vehiculo) {
        validarExistencia(vehiculo);
        this.repositorioVehiculo.guardar(vehiculo);
        return this.daoVehiculo.obtenerVehiculoPorPlaca(vehiculo.getPlaca());
    }


    private void validarExistencia(Vehiculo vehiculo){
        if (this.repositorioVehiculo.existePorPlaca(vehiculo.getPlaca())) {
            throw new ExcepcionDuplicidad(NO_SE_PUDO_GUARDAR);
        }
    }
}
