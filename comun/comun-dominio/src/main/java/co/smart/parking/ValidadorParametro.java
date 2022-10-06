package co.smart.parking;

import co.smart.parking.excepcion.ExcepcionArgumentoInvalido;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;

public class ValidadorParametro {

    public static void validarValorNulo(Object valor, String mensaje) {
        if(valor == null) {
            throw new ExcepcionArgumentoInvalido(mensaje);
        }
    }


    public static void validarValorVacio(String valor, String mensaje) {
        if(!StringUtils.hasText(valor)) {
            throw new ExcepcionArgumentoInvalido(mensaje);
        }
    }

    public static <T> void validarVacio(Collection<T> list, String mensaje) {
        if(list.isEmpty()) {
            throw new ExcepcionArgumentoInvalido(mensaje);
        }
    }
}
