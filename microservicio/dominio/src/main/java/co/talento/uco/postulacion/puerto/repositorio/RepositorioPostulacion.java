package co.talento.uco.postulacion.puerto.repositorio;

import co.talento.uco.oferta.modelo.dominio.Oferta;
import co.talento.uco.postulacion.modelo.dominio.Postulacion;

public interface RepositorioPostulacion {

    boolean guardarPostulacion(Postulacion postulacion, Oferta oferta);

}
