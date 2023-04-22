package co.talento.uco.vehiculo.modelo.dominio;


import co.talento.uco.ValidadorParametro;
import lombok.Getter;

@Getter
public class Vehiculo {

    private static final String LA_PLACA_NO_PUEDE_SER_VACIA = "La plcaca no puede ser vacia";

    private String placa;

    public Vehiculo(String placa) {
        ValidadorParametro.validarValorVacio(placa, LA_PLACA_NO_PUEDE_SER_VACIA);
        this.placa = placa;
    }
}
