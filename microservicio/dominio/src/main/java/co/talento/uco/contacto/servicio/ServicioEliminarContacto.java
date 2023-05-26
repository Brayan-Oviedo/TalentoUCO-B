package co.talento.uco.contacto.servicio;

import co.talento.uco.contacto.puerto.repositorio.RepositorioContacto;
import co.talento.uco.excepcion.ExcepcionInexistente;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarContacto {
    private static final String NO_SE_PUDO_ELIMINAR_EL_VEHICULO = "No se pudo eliminar";

    private final RepositorioContacto repositorioContacto;

    public ServicioEliminarContacto(RepositorioContacto repositorioContacto) {
        this.repositorioContacto = repositorioContacto;
    }


    public boolean ejecutar(Long id){
        validarExistencia(id);
        return this.repositorioContacto.eliminarPorId(id);
    }


    private void validarExistencia(Long id){
        if (!this.repositorioContacto.existePorId(id)) {
            throw new ExcepcionInexistente(NO_SE_PUDO_ELIMINAR_EL_VEHICULO);
        }
    }
}
