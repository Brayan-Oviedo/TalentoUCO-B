package co.talento.uco.contacto.servicio;

import co.talento.uco.contacto.modelo.dominio.Contacto;
import co.talento.uco.contacto.puerto.repositorio.RepositorioContacto;
import org.springframework.stereotype.Service;

@Service
public class ServicioActualizarContacto {
    private static final String NO_SE_PUEDE_ACTUALIZAR = "No se puede actualizar ya que no existe";

    private final RepositorioContacto repositorioContacto;

    public ServicioActualizarContacto(RepositorioContacto repositorioContacto) {
        this.repositorioContacto = repositorioContacto;
    }

    public boolean ejecutar(Contacto contacto){
        validarExistencia(contacto);
        return this.repositorioContacto.actualizar(contacto);
    }

    private void validarExistencia(Contacto contacto){
        /*if (!this.repositorioContacto.existePorId(contacto.getPlaca())) {
            throw new ExcepcionInexistente(NO_SE_PUEDE_ACTUALIZAR);
        }*/
    }


}
