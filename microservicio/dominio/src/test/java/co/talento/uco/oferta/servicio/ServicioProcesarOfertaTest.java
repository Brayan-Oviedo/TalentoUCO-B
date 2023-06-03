package co.talento.uco.oferta.servicio;

import co.talento.uco.contacto.modelo.dominio.Contacto;
import co.talento.uco.oferta.modelo.dominio.OfertaDetalle;
import co.talento.uco.postdetails.modelo.dominio.PostDetails;
import co.talento.uco.usuario.modelo.dominio.Usuario;
import co.talento.uco.usuario.modelo.dtoRespuesta.RespuestaUsuario;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioProcesarOfertaTest {

    @Test
    public void deberiaProcesarOfertaCorrectamente(){
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

        var servicioProcesarOferta = new ServicioProcesarOferta();


        //Act
        var resultado = servicioProcesarOferta.ejecutar(ofertaDetalle,respuestaUsuario);

        //Assert
        assertEquals(usuario.getNombreUsuario(),resultado.getUsuario().getNombreUsuario());
        assertEquals(usuario.getContrasena(),resultado.getUsuario().getContrasena());
        assertEquals(usuario.getRoles(),resultado.getUsuario().getRoles());
        assertEquals(ofertaDetalle.getPostDetails(),resultado.getPostDetails());
        assertEquals(ofertaDetalle.getContacto(),resultado.getContacto());
        assertEquals(ofertaDetalle.isEstaActiva(),resultado.isEstaActiva());
        assertEquals(ofertaDetalle.getTags(),resultado.getTags());
    }
}
