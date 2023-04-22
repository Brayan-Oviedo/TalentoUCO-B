package co.talento.uco.vehiculo.domain;

import co.talento.uco.excepcion.ExcepcionArgumentoInvalido;
import co.talento.uco.vehiculo.modelo.dominio.Vehiculo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VehiculoTest {

    @Test
    public void deberiaCrearCorrectamenteVehiculo() {

        // Arrange - Act
        var vehiculo = new Vehiculo("111");

        // Assert
        assertEquals("111", vehiculo.getPlaca());
    }

    @Test
    public void deberiaFallarAlCrearVehiculoConPlacaVacia() {

        // Arrange
        var placa = "";

        // Act - Assert
        try {
            var vehiculo = new Vehiculo(placa);
            fail("Se esperaba una excepción");
        } catch (Exception e) {
            assertTrue(e instanceof ExcepcionArgumentoInvalido, "Se esperaba otra excepción");
            assertTrue(e.getMessage().contains("La plcaca no puede ser vacia"), "Se esperaba otro mensaje");
        }

    }
}
