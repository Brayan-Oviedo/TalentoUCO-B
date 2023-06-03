package co.talento.uco.postdetails.dominio;

import co.talento.uco.postdetails.modelo.dominio.PostDetails;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PostDetailsTest {
    @Test
    public void deberiaCrearCorrectamentePostDetails(){
        var postDetails = new PostDetails("titulo prueba","descripcion prueba");
        assertEquals("titulo prueba", postDetails.getTitulo());
        assertEquals("descripcion prueba", postDetails.getDescripcion());
    }
}
