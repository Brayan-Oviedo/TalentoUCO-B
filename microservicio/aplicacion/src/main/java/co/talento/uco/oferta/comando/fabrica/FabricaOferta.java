package co.talento.uco.oferta.comando.fabrica;

import co.talento.uco.contacto.comando.fabrica.FabricaContacto;
import co.talento.uco.oferta.comando.SolicitudOfertaTransaccion;
import co.talento.uco.oferta.modelo.dominio.OfertaDetalle;
import co.talento.uco.postdetails.comando.fabrica.FabricaPostDetails;
import co.talento.uco.postulacion.modelo.dominio.Postulacion;
import co.talento.uco.usuario.comando.fabrica.FabricaUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class FabricaOferta {

    private final FabricaContacto fabricaContacto;
    private final FabricaPostDetails fabricaPostDetails;
    private final FabricaUsuario fabricaUsuario;


    public OfertaDetalle crear(SolicitudOfertaTransaccion solicitudOfertaTransaccion){
        var listaPostulacion = new ArrayList<Postulacion>();
        return new OfertaDetalle(
                this.fabricaPostDetails.crear(solicitudOfertaTransaccion.getRequestPostDetails()),
                this.fabricaContacto.crear(solicitudOfertaTransaccion.getRequestContactoTransaccion()),
                solicitudOfertaTransaccion.isEstaActivo(),
                solicitudOfertaTransaccion.getTags(),
                listaPostulacion
        );
    }

}
