package co.talento.uco.vehiculo.servicio;

import co.talento.uco.excepcion.ExcepcionInexistente;
import co.talento.uco.vehiculo.modelo.dominio.Vehiculo;
import co.talento.uco.vehiculo.puerto.repositorio.RepositorioVehiculo;
import org.springframework.stereotype.Service;

@Service
public class ServicioActualizarVehiculo {

    private static final String NO_SE_PUEDE_ACTUALIZAR = "No se puede actualizar ya que el vehiculo no existe";
    private final RepositorioVehiculo repositorioVehiculo;

    public ServicioActualizarVehiculo(RepositorioVehiculo repositorioVehiculo) {
        this.repositorioVehiculo = repositorioVehiculo;
    }

    public boolean ejecutar(Vehiculo vehiculo){
        validarExistencia(vehiculo);
        return this.repositorioVehiculo.actualizar(vehiculo);
    }

    private void validarExistencia(Vehiculo vehiculo){
        if (!this.repositorioVehiculo.existePorPlaca(vehiculo.getPlaca())) {
            throw new ExcepcionInexistente(NO_SE_PUEDE_ACTUALIZAR);
        }
    }
}
