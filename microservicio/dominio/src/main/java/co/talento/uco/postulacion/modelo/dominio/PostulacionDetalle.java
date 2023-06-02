package co.talento.uco.postulacion.modelo.dominio;

import co.talento.uco.ValidadorParametro;
import co.talento.uco.oferta.modelo.dominio.OfertaDetalle;
import co.talento.uco.usuario.modelo.dominio.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
public class PostulacionDetalle {

    private static final String INGRESE_EL_ID = "Ingrese el id";
    private static final String INGRESE_LA_FECHA = "Ingrese la fecha";
    private static final String INGRESE_ALGUN_ADJUNTO = "Ingrese algun adjunto";

    private Long id;
    private Date fecha;
    private String adjunto;
    private OfertaDetalle ofertaDetalle;

    public PostulacionDetalle(Date fecha, String adjunto, OfertaDetalle ofertaDetalle) {

        ValidadorParametro.validarValorNulo(fecha, INGRESE_LA_FECHA);
        ValidadorParametro.validarValorNulo(adjunto, INGRESE_ALGUN_ADJUNTO);

        this.fecha = fecha;
        this.adjunto = adjunto;
        this.ofertaDetalle = ofertaDetalle;
    }

    public PostulacionDetalle(Long id, Date fecha, String adjunto) {

        ValidadorParametro.validarValorNulo(id, INGRESE_EL_ID);
        ValidadorParametro.validarValorNulo(fecha, INGRESE_LA_FECHA);
        ValidadorParametro.validarValorNulo(adjunto, INGRESE_ALGUN_ADJUNTO);

        this.id = id;
        this.fecha = fecha;
        this.adjunto = adjunto;
    }

}
