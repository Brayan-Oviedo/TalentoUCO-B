package co.talento.uco.excepcion;

public class ExcepcionCredencialesIncorrectas extends RuntimeException {

    public ExcepcionCredencialesIncorrectas(String message) {
        super(message);
    }
}
