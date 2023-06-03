package co.talento.uco.oferta.comando;

import co.talento.uco.contacto.comando.RequestContactoTransaccion;
import co.talento.uco.postdetails.comando.RequestPostDetails;
import co.talento.uco.usuario.comando.SolicitudUsuarioConsulta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudOfertaTransaccion {
    private SolicitudUsuarioConsulta usuario;
    private RequestPostDetails postDetalles;
    private RequestContactoTransaccion contacto;
    private boolean estaActiva;
    private List<String> tags;

    public SolicitudOfertaTransaccion(SolicitudUsuarioConsulta usuario, RequestPostDetails postDetalles, RequestContactoTransaccion contacto, boolean estaActiva) {
        this.usuario = usuario;
        this.postDetalles = postDetalles;
        this.contacto = contacto;
        this.estaActiva = estaActiva;
        this.tags = new ArrayList<String>();
    }
}
