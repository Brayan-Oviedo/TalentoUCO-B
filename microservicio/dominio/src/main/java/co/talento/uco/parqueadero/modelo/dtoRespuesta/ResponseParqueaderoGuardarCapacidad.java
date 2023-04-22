package co.talento.uco.parqueadero.modelo.dtoRespuesta;

public class ResponseParqueaderoGuardarCapacidad {

    private String mensaje;

    private int capacidadMaxima;

    public ResponseParqueaderoGuardarCapacidad(String mensaje, int capacidadMaxima) {
        this.mensaje = mensaje;
        this.capacidadMaxima = capacidadMaxima;
    }
}
