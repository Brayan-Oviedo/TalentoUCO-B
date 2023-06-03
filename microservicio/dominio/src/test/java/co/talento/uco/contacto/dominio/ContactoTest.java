package co.talento.uco.contacto.dominio;

import co.talento.uco.contacto.modelo.dominio.Contacto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactoTest {
    @Test
    public void deberiaCrearCorrectamenteContacto(){
        //Arrange
        var contacto = new Contacto("nombre","correo","celular","ciudad","direccion");
        //Assert
        assertEquals("nombre", contacto.getNombre());
        assertEquals("correo", contacto.getCorreo());
        assertEquals("celular", contacto.getCelular());
        assertEquals("ciudad", contacto.getCiudad());
        assertEquals("direccion", contacto.getDireccion());

    }
}
