package co.talento.uco.oferta.dominio;

import co.talento.uco.contacto.modelo.dominio.Contacto;
import co.talento.uco.oferta.modelo.dominio.Oferta;
import co.talento.uco.postdetails.modelo.dominio.PostDetails;
import co.talento.uco.usuario.modelo.dominio.Usuario;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class OfertaTest {

    @Test
    public void deberiaCrearCorrectamenteContacto(){
        //Arrange
        Set<String> roles = new HashSet<>();
        roles.add("Administrador");
        var usuario = new Usuario("usaurio","contrasena",roles);
        var postDetails = new PostDetails("titulo","descripcion");
        var contacto = new Contacto("nombre","correo","celular","ciudad","diraccion");
        var lista = new ArrayList<String>();
        lista.add("tag");
        var oferta = new Oferta(usuario, postDetails, contacto, true, lista);

        //Assert
        assertEquals(usuario, oferta.getUsuario());
        assertEquals(postDetails, oferta.getPostDetails());
        assertEquals(contacto, oferta.getContacto());
        assertEquals(true, oferta.isEstaActiva());
        assertEquals(lista, oferta.getTags());
    }
}
