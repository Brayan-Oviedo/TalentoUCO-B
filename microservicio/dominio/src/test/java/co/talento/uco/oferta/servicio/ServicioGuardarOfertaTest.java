package co.talento.uco.oferta.servicio;

import co.talento.uco.contacto.modelo.dominio.Contacto;
import co.talento.uco.oferta.modelo.dominio.Oferta;
import co.talento.uco.oferta.modelo.dominio.OfertaDetalle;
import co.talento.uco.oferta.puerto.repositorio.RepositorioOferta;
import co.talento.uco.postdetails.modelo.dominio.PostDetails;
import co.talento.uco.usuario.modelo.dominio.Usuario;
import co.talento.uco.usuario.modelo.dtoRespuesta.RespuestaUsuario;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ServicioGuardarOfertaTest {

    @Test
    public void deberiaGuardarOfertaCorrectamente(){
        //Arrange
        Set<String> roles = new HashSet<>();
        roles.add("Administrador");
        var usuario = new Usuario("usaurio","contrasena",roles);
        var postDetails = new PostDetails("titulo","descripcion");
        var contacto = new Contacto("nombre","correo","celular","ciudad","diraccion");
        var lista = new ArrayList<String>();
        lista.add("tag");
        var oferta = new Oferta(usuario, postDetails, contacto, true, lista);
        var ofertaDetalle = new OfertaDetalle(postDetails, contacto, true, lista);
        var respuestaUsuario = new RespuestaUsuario("usaurio","contrasena",roles);
        var repositorioOferta = Mockito.mock(RepositorioOferta.class);
        var servicioProcesarOferta = Mockito.mock(ServicioProcesarOferta.class);

        var servicioGuardarOferta = new ServicioGuardarOferta(repositorioOferta,servicioProcesarOferta);

        Mockito.when(servicioProcesarOferta.ejecutar(ofertaDetalle,respuestaUsuario)).thenReturn(oferta);
        Mockito.when(repositorioOferta.guardar(oferta)).thenReturn(1L);

        //Act
        var resultado = servicioGuardarOferta.ejecutar(ofertaDetalle,respuestaUsuario);

        //Assert
        assertEquals(1L,resultado);
        Mockito.verify(repositorioOferta, Mockito.times(1)).guardar(oferta);
        Mockito.verify(servicioProcesarOferta, Mockito.times(1)).ejecutar(ofertaDetalle,respuestaUsuario);

    }
}
