package co.talento.uco.postulacion.servicio;

import co.talento.uco.contacto.modelo.dominio.Contacto;
import co.talento.uco.oferta.modelo.dominio.Oferta;
import co.talento.uco.oferta.modelo.dominio.OfertaDetalle;
import co.talento.uco.postdetails.modelo.dominio.PostDetails;
import co.talento.uco.postulacion.modelo.dominio.Postulacion;
import co.talento.uco.postulacion.modelo.dominio.PostulacionDetalle;
import co.talento.uco.postulacion.puerto.repositorio.RepositorioPostulacion;
import co.talento.uco.usuario.modelo.dominio.Usuario;
import co.talento.uco.usuario.modelo.dtoRespuesta.RespuestaUsuario;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioGuardarPostulacionTest {

    @Test
    public void deberiaGuardarPostulacionCorrectamente(){
        //Arrange
        Set<String> roles = new HashSet<>();
        roles.add("Administrador");
        var usuario = new Usuario("usaurio","contrasena",roles);
        var postulante = new Usuario("usaurio","contrasena",roles);
        var postDetails = new PostDetails("titulo","descripcion");
        var contacto = new Contacto("nombre","correo","celular","ciudad","diraccion");
        var lista = new ArrayList<String>();
        lista.add("tag");
        var oferta = new Oferta(usuario, postDetails, contacto, true, lista);
        var fecha = new Date();
        var ofertaDetalle = new OfertaDetalle(postDetails,contacto,true,lista);
        var postulacionDetalle = new PostulacionDetalle(fecha,"adjunto",ofertaDetalle);
        var respuestaUsuario = new RespuestaUsuario("usaurio","contrasena",roles);
        var postulacion = new Postulacion(postulante,fecha,"adjunto",new Oferta(
                1L,oferta.getUsuario(),oferta.getPostDetails(),oferta.getContacto(),
                oferta.isEstaActiva(),oferta.getTags()
        ));


        var repositorioPostulacion = Mockito.mock(RepositorioPostulacion.class);
        var servicioProcesarPostulacion = Mockito.mock(ServicioProcesarPostulacion.class);

        var servicioGuardarPostulacion = new ServicioGuardarPostulacion(servicioProcesarPostulacion, repositorioPostulacion);

        Mockito.when(servicioProcesarPostulacion.ejecutar(postulacionDetalle,respuestaUsuario)).thenReturn(postulacion);
        Mockito.when(repositorioPostulacion.guardarPostulacion(postulacion)).thenReturn(true);

        //Act
        var resultado = servicioGuardarPostulacion.ejecutar(postulacionDetalle,respuestaUsuario);

        //Assert
        assertEquals(true,resultado);
        Mockito.verify(repositorioPostulacion, Mockito.times(1)).guardarPostulacion(postulacion);
        Mockito.verify(servicioProcesarPostulacion, Mockito.times(1)).ejecutar(postulacionDetalle,respuestaUsuario);

    }
}
