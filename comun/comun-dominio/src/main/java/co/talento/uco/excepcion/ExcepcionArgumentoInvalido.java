package co.talento.uco.excepcion;

public class ExcepcionArgumentoInvalido extends RuntimeException {

    public ExcepcionArgumentoInvalido(String mensaje) {
        super(mensaje);
    }
}
