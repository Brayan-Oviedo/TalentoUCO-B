package co.talento.uco.postulacion.modelo.dominio;

import co.talento.uco.ValidadorParametro;
import co.talento.uco.usuario.modelo.dominio.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class Postulacion {

    private static final String INGRESE_EL_POSTULANTE = "Ingrese el postulante";
    private static final String INGRESE_LA_FECHA = "Ingrese la fecha";
    private static final String INGRESE_ALGUN_ADJUNTO = "Ingrese algun adjunto";

    private Long id;
    private Usuario postulante;
    private Date fecha;
    private String adjunto;

    public Postulacion(Usuario postulante, Date fecha, String adjunto) {

        ValidadorParametro.validarValorNulo(postulante, INGRESE_EL_POSTULANTE);
        ValidadorParametro.validarValorNulo(fecha, INGRESE_LA_FECHA);
        ValidadorParametro.validarValorNulo(adjunto, INGRESE_ALGUN_ADJUNTO);

        this.postulante = postulante;
        this.fecha = fecha;
        this.adjunto = adjunto;
    }


}
