package co.talento.uco.postulacion.servicio;

import co.talento.uco.oferta.modelo.dominio.OfertaDetalle;
import co.talento.uco.postulacion.modelo.dominio.PostulacionDetalle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioProcesarPostulacion {


    public OfertaDetalle ejecutar(OfertaDetalle ofertaDetalle, PostulacionDetalle postulacion) {
        var lista = new ArrayList<PostulacionDetalle>();
        //lista.addAll(ofertaDetalle.getPostulaciones());
        lista.add(postulacion);
        return new OfertaDetalle(
                ofertaDetalle.getId(),
                ofertaDetalle.getPostDetails(),
                ofertaDetalle.getContacto(),
                ofertaDetalle.isEstaActiva(),
                ofertaDetalle.getTags()
        );
    }
}
