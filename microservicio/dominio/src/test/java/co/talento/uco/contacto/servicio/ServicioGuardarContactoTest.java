package co.talento.uco.contacto.servicio;

import co.talento.uco.contacto.modelo.dominio.Contacto;
import co.talento.uco.contacto.modelo.dtoRespuesta.RespuestaContacto;
import co.talento.uco.contacto.puerto.repositorio.RepositorioContacto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioGuardarContactoTest {
    @Test
    public void deberiaGuardarContactoCorrectamente() {
        //Arrange
        var contacto = new Contacto("nombre","correo","celular","ciudad","direccion");
        var respuestaContacto= new RespuestaContacto(1L, contacto.getNombre(),contacto.getCorreo(),contacto.getCelular(),contacto.getCiudad(),contacto.getDireccion());
        var repositorioContacto = Mockito.mock(RepositorioContacto.class);

        var servicioGuardarContacto = new ServicioGuardarContacto(repositorioContacto);

        Mockito.when(repositorioContacto.existeCorreo(contacto)).thenReturn(false);
        Mockito.when((repositorioContacto.guardar(contacto))).thenReturn(respuestaContacto);

        //Act
        var resultado = servicioGuardarContacto.ejecutar(contacto);

        //Assert
        assertEquals(respuestaContacto,resultado);
        Mockito.verify(repositorioContacto, Mockito.times(1)).existeCorreo(contacto);
        Mockito.verify(repositorioContacto, Mockito.times(1)).guardar(contacto);
    }
}
