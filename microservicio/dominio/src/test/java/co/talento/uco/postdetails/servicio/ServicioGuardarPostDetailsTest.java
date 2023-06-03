package co.talento.uco.postdetails.servicio;

import co.talento.uco.postdetails.modelo.dominio.PostDetails;
import co.talento.uco.postdetails.puerto.repositorio.RepositorioPoestDetails;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

public class ServicioGuardarPostDetailsTest {
    @Test
    public void deberiaGuardarPostDetailsCorrectamente() {
        var postDetails = new PostDetails("titulo", "descripcion");
        var repositorioPostDetails = Mockito.mock(RepositorioPoestDetails.class);

        var servicioGuardarPostDetails = new ServicioGuardarPostDetails(repositorioPostDetails);

        Mockito.when((repositorioPostDetails.guardar(postDetails))).thenReturn(true);
        var resultado = servicioGuardarPostDetails.ejecutar(postDetails);


        assertEquals(true,resultado);
        Mockito.verify(repositorioPostDetails, Mockito.times(1)).guardar(postDetails);
    }
}
