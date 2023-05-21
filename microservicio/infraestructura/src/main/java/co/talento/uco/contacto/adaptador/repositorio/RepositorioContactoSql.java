package co.talento.uco.contacto.adaptador.repositorio;

import co.talento.uco.contacto.adaptador.MapperContacto;
import co.talento.uco.contacto.adaptador.RepositorioContactoJpa;
import co.talento.uco.contacto.entidad.EntidadContacto;
import co.talento.uco.contacto.modelo.dominio.Contacto;
import co.talento.uco.contacto.modelo.dtoRespuesta.RespuestaContacto;
import co.talento.uco.contacto.puerto.repositorio.RepositorioContacto;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioContactoSql implements RepositorioContacto {
    private final RepositorioContactoJpa repositorioContactoJpa;
    private final MapperContacto mapperContacto;

    public RepositorioContactoSql(RepositorioContactoJpa repositorioContactoJpa, MapperContacto mapperContacto) {
        this.repositorioContactoJpa = repositorioContactoJpa;
        this.mapperContacto = mapperContacto;
    }


    @Override
    public RespuestaContacto guardar(Contacto contacto) {
        EntidadContacto entidadContacto = this.mapperContacto.crearEntidad(contacto);
        return this.mapperContacto.crearRespuesta(this.repositorioContactoJpa.save(entidadContacto));
    }

    @Override
    public boolean actualizar(Contacto contacto) {
        EntidadContacto entidadContacto = this.mapperContacto.crearEntidad(contacto);
        this.repositorioContactoJpa.save(entidadContacto);
        return true;
    }

    @Override
    public boolean existeCorreo(Contacto contacto) {
        var listacorreosprueba = this.repositorioContactoJpa.findAllByCorreo(contacto.getCorreo());
        var listaCorreos= this.repositorioContactoJpa.BuscarCorreo(contacto.getCorreo());
        if (listaCorreos == null || listaCorreos.size() == 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean eliminarPorId(String id) {
        this.repositorioContactoJpa.deleteById(id);
        return true;
    }

    @Override
    public boolean existePorId(String id) {
        var lista = this.repositorioContactoJpa.findById(id);
        if (lista == null) {
            return false;
        }
        return true;
    }
}
