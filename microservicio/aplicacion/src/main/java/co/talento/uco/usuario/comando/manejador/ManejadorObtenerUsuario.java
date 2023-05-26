package co.talento.uco.usuario.comando.manejador;

import co.talento.uco.usuario.comando.SolicitudUsuarioConsulta;
import co.talento.uco.usuario.comando.SolicitudUsuarioTransaccion;
import co.talento.uco.usuario.modelo.dtoRespuesta.RespuestaUsuario;
import co.talento.uco.usuario.puerto.dao.DaoUsuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerUsuario {

    private final DaoUsuario daoUsuario;

    public ManejadorObtenerUsuario(DaoUsuario daoUsuario) {
        this.daoUsuario = daoUsuario;
    }


    public RespuestaUsuario ejecutar(SolicitudUsuarioConsulta solicitudUsuarioConsulta) {
        return this.daoUsuario.obtenerUsuarioPorNombreDeUsuario(solicitudUsuarioConsulta.getNombreUsuario());
    }
}
