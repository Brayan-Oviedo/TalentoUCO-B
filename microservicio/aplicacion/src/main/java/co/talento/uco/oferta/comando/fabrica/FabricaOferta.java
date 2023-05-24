package co.talento.uco.oferta.comando.fabrica;

import co.talento.uco.contacto.comando.RequestContactoTransaccion;
import co.talento.uco.contacto.comando.fabrica.FabricaContacto;
import co.talento.uco.contacto.modelo.dominio.Contacto;
import co.talento.uco.oferta.comando.RequestOfertaTransaccion;
import co.talento.uco.oferta.modelo.dominio.Oferta;
import co.talento.uco.postdetails.comando.fabrica.FabricaPostDetails;
import co.talento.uco.usuario.comando.fabrica.FabricaUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FabricaOferta {

    private final FabricaContacto fabricaContacto;
    private final FabricaPostDetails fabricaPostDetails;
    private final FabricaUsuario fabricaUsuario;


    public Oferta crear(RequestOfertaTransaccion requestOfertaTransaccion){
        return new Oferta(
                this.fabricaUsuario.crear(requestOfertaTransaccion.getRequestUsuarioTransaccion()),
                this.fabricaPostDetails.crear(requestOfertaTransaccion.getRequestPostDetails()),
                this.fabricaContacto.crear(requestOfertaTransaccion.getRequestContactoTransaccion()),
                requestOfertaTransaccion.isActive(),
                requestOfertaTransaccion.getTags()
        );
    }
}
