package co.talento.uco.contacto.servicio;

import co.talento.uco.contacto.modelo.dominio.Contacto;
import co.talento.uco.contacto.modelo.dtoRespuesta.RespuestaContacto;
import co.talento.uco.contacto.puerto.repositorio.RepositorioContacto;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarContacto {

    private static final String EL_CORREO_YA_EXISTE = "El correo ya existe";
    private final RepositorioContacto repositorioContacto;

    public ServicioGuardarContacto(RepositorioContacto repositorioContacto) {
        this.repositorioContacto = repositorioContacto;
    }


    public RespuestaContacto ejecutar(Contacto contacto){
        this.existe(contacto);
        return this.repositorioContacto.guardar(contacto);
    }

    public void existe(Contacto contacto){
        if(this.repositorioContacto.existeCorreo(contacto)) {
            throw new RuntimeException(String.format(EL_CORREO_YA_EXISTE));
        }
    }

}
