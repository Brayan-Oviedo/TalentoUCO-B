package co.talento.uco.usuario.adaptador.dao;

import co.talento.uco.usuario.adaptador.MapperUsuario;
import co.talento.uco.usuario.adaptador.RepositorioUsuarioJpa;
import co.talento.uco.usuario.modelo.dtoRespuesta.RespuestaUsuario;
import co.talento.uco.usuario.puerto.dao.DaoUsuario;
import org.springframework.stereotype.Repository;


@Repository
public class DaoUsuarioSql implements DaoUsuario {

    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final MapperUsuario mapperUsuario;

    public DaoUsuarioSql(RepositorioUsuarioJpa repositorioUsuarioJpa, MapperUsuario mapperUsuario) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.mapperUsuario = mapperUsuario;
    }

    @Override
    public RespuestaUsuario obtenerUsuarioPorNombreDeUsuario(String nombreUsuario) {
        var entidad = this.repositorioUsuarioJpa.findByNombreUsuario(nombreUsuario);
        return this.mapperUsuario.crearRespuesta(entidad);
    }

}
