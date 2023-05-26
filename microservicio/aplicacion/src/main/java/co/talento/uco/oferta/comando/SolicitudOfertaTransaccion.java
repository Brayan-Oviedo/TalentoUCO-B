package co.talento.uco.oferta.comando;

import co.talento.uco.contacto.comando.RequestContactoTransaccion;
import co.talento.uco.postdetails.comando.RequestPostDetails;
import co.talento.uco.usuario.comando.SolicitudUsuarioConsulta;
import co.talento.uco.usuario.comando.SolicitudUsuarioTransaccion;
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
    private SolicitudUsuarioConsulta solicitudUsuarioConsulta;
    private RequestPostDetails requestPostDetails;
    private RequestContactoTransaccion requestContactoTransaccion;
    private boolean estaActivo;
    private List<String> tags;

    public SolicitudOfertaTransaccion(SolicitudUsuarioConsulta solicitudUsuarioConsulta, RequestPostDetails requestPostDetails, RequestContactoTransaccion requestContactoTransaccion, boolean estaActivo) {
        this.solicitudUsuarioConsulta = solicitudUsuarioConsulta;
        this.requestPostDetails = requestPostDetails;
        this.requestContactoTransaccion = requestContactoTransaccion;
        this.estaActivo = estaActivo;
        this.tags = new ArrayList<String>();
    }
}
