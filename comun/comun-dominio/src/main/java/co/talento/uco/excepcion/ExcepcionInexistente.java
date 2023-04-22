package co.talento.uco.excepcion;

public class ExcepcionInexistente extends RuntimeException {

    public ExcepcionInexistente(String mensaje) {
        super(mensaje);
    }
}
