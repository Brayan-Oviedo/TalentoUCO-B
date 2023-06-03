package co.talento.uco.postulacion.dominio;

import co.talento.uco.contacto.modelo.dominio.Contacto;
import co.talento.uco.oferta.modelo.dominio.Oferta;
import co.talento.uco.postdetails.modelo.dominio.PostDetails;
import co.talento.uco.postulacion.modelo.dominio.Postulacion;
import co.talento.uco.usuario.modelo.dominio.Usuario;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class PostulacionTest {

    @Test
    public void deberiaCrearCorrectamentePostulacion(){
        //Arrange
        Set<String> roles = new HashSet<>();
        roles.add("Administrador");
        var usuario = new Usuario("usaurio","contrasena",roles);
        var postulante = new Usuario("usaurio","contrasena",roles);
        var postDetails = new PostDetails("titulo","descripcion");
        var contacto = new Contacto("nombre","correo","celular","ciudad","diraccion");
        var lista = new ArrayList<String>();
        lista.add("tag");
        var fecha = new Date();
        var oferta = new Oferta(usuario, postDetails, contacto, true, lista);
        var postulacion = new Postulacion(postulante, fecha,"adjunto",oferta);

        assertEquals(postulante.getNombreUsuario(), postulacion.getPostulante().getNombreUsuario());
        assertEquals(postulante.getContrasena(), postulacion.getPostulante().getContrasena());
        assertEquals(postulante.getRoles(), postulacion.getPostulante().getRoles());
        assertEquals(fecha, postulacion.getFecha());
        assertEquals("adjunto", postulacion.getAdjunto());
        assertEquals(oferta,postulacion.getOferta());
    }
}
