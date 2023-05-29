package co.talento.uco.oferta.adaptador;

import co.talento.uco.contacto.adaptador.MapperContacto;
import co.talento.uco.oferta.entidad.EntidadOferta;
import co.talento.uco.oferta.modelo.dominio.Oferta;
import co.talento.uco.postdetails.adaptador.MapperPostDetails;
import co.talento.uco.usuario.adaptador.MapperUsuario;
import org.springframework.stereotype.Component;

@Component

public class MapperOferta {

    private final MapperContacto mapperContacto;
    private final MapperPostDetails mapperPostDetails;
    private final MapperUsuario mapperUsuario;

    public MapperOferta(MapperContacto mapperContacto, MapperPostDetails mapperPostDetails, MapperUsuario mapperUsuario) {
        this.mapperContacto = mapperContacto;
        this.mapperPostDetails = mapperPostDetails;
        this.mapperUsuario = mapperUsuario;
    }


    public EntidadOferta crearEntidadOferta(Oferta oferta){
        return new EntidadOferta(
                this.mapperUsuario.crearEntidad(oferta.getUsuario()),
                this.mapperPostDetails.crearEntidad(oferta.getPostDetails()),
                this.mapperContacto.crearEntidad(oferta.getContacto()),
                oferta.estaActiva(),
                oferta.getTags(),
                oferta.getPostulaciones()
        );
    }
}
