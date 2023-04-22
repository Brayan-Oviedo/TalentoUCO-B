package co.talento.uco.excepcion;

public class ExcepcionDuplicidad extends RuntimeException {

    public ExcepcionDuplicidad(String mensaje) {
        super(mensaje);
    }
}
