package co.talento.uco.oferta.servicio;

import co.talento.uco.oferta.puerto.repositorio.RepositorioOferta;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioEliminarOfertaTest {
    @Test
    public void deberiaElimiarOfertaCorrectamente(){
    var repositorioOferta = Mockito.mock(RepositorioOferta.class);
    var servicioEliminarOferta = new ServicioEliminarOferta(repositorioOferta);

    Mockito.when(repositorioOferta.eliminarPorId(1L)).thenReturn(true);

    //Act
        var resultado = servicioEliminarOferta.ejecutar(1L);
        assertEquals(true,resultado);
        Mockito.verify(repositorioOferta, Mockito.times(1)).eliminarPorId(1L);
    }
}
