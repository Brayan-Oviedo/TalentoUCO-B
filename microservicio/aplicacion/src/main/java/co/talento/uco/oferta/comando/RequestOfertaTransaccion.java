package co.talento.uco.oferta.comando;

import co.talento.uco.contacto.comando.RequestContactoTransaccion;
import co.talento.uco.postdetails.comando.RequestPostDetails;
import co.talento.uco.usuario.comando.RequestUsuarioTransaccion;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@Getter
@AllArgsConstructor
public class RequestOfertaTransaccion {
    private RequestUsuarioTransaccion requestUsuarioTransaccion;
    private RequestPostDetails requestPostDetails;
    private RequestContactoTransaccion requestContactoTransaccion;
    private boolean isActive;
    private List<String> tags;
}
