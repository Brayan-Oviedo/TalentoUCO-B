package co.talento.uco.postulacion.servicio;

import co.talento.uco.contacto.modelo.dominio.Contacto;
import co.talento.uco.oferta.modelo.dominio.Oferta;
import co.talento.uco.oferta.modelo.dominio.OfertaDetalle;
import co.talento.uco.oferta.servicio.ServicioProcesarOferta;
import co.talento.uco.postdetails.modelo.dominio.PostDetails;
import co.talento.uco.postulacion.modelo.dominio.PostulacionDetalle;
import co.talento.uco.usuario.modelo.dominio.Usuario;
import co.talento.uco.usuario.modelo.dtoRespuesta.RespuestaUsuario;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioProcesarPostulacionTest {

    @Test
    public void deberiaProcesarPostulacionCorrectamente(){
        //Arrange
        Set<String> roles = new HashSet<>();
        roles.add("Administrador");

        var postDetails = new PostDetails("titulo","descripcion");
        var contacto = new Contacto("nombre","correo","celular","ciudad","diraccion");
        var lista = new ArrayList<String>();
        lista.add("tag");
        var ofertaDetalle = new OfertaDetalle(postDetails, contacto, true, lista);
        var respuestaUsuario = new RespuestaUsuario("usaurio","contrasena",roles);
        var usuario = new Usuario(respuestaUsuario.getNombreUsuario(),respuestaUsuario.getContrasena(),respuestaUsuario.getRoles());
        var fecha = new Date();
        var postulacionDetalle = new PostulacionDetalle(fecha,"adjunto",ofertaDetalle);
        var oferta = new Oferta(1L,usuario,postDetails,contacto,true,lista);


        var servicioProcesarOferta = Mockito.mock(ServicioProcesarOferta.class);
        var servicioProcesarPostulacion = new ServicioProcesarPostulacion(servicioProcesarOferta);

        Mockito.when(servicioProcesarOferta.ejecutar(postulacionDetalle.getOfertaDetalle(),respuestaUsuario)).thenReturn(oferta);

        //Act
        var resultado = servicioProcesarPostulacion.ejecutar(postulacionDetalle,respuestaUsuario);

        //Assert
        assertEquals(usuario.getNombreUsuario(),resultado.getPostulante().getNombreUsuario());
        assertEquals(usuario.getContrasena(),resultado.getPostulante().getContrasena());
        assertEquals(usuario.getRoles(),resultado.getPostulante().getRoles());
        assertEquals(postulacionDetalle.getAdjunto(),resultado.getAdjunto());
        assertEquals(postulacionDetalle.getFecha(),resultado.getFecha());
        assertEquals(postulacionDetalle.getId(),resultado.getId());
        assertEquals(postulacionDetalle.getOfertaDetalle().getTags(),resultado.getOferta().getTags());
        assertEquals(postulacionDetalle.getOfertaDetalle().isEstaActiva(),resultado.getOferta().isEstaActiva());
        assertEquals(postulacionDetalle.getOfertaDetalle().getContacto(),resultado.getOferta().getContacto());
        assertEquals(postulacionDetalle.getOfertaDetalle().getPostDetails(),resultado.getOferta().getPostDetails());
        //id?
        //assertEquals(postulacionDetalle.getOfertaDetalle().getId(),resultado.getOferta().getId());

        Mockito.verify(servicioProcesarOferta,Mockito.times(1)).ejecutar(ofertaDetalle,respuestaUsuario);
    }
}
