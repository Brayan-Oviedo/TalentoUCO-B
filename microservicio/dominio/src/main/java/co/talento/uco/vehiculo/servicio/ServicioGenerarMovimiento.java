package co.talento.uco.vehiculo.servicio;

import co.talento.uco.vehiculo.TipoVehiculoMovimiento;
import co.talento.uco.vehiculo.modelo.dominio.Vehiculo;
import co.talento.uco.vehiculo.modelo.dominio.VehiculoMovimiento;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ServicioGenerarMovimiento {

    public VehiculoMovimiento ejecutar(Vehiculo vehiculo, TipoVehiculoMovimiento tipoMovimiento) {
        return new VehiculoMovimiento(
                vehiculo,
                tipoMovimiento,
                LocalDateTime.now()
        );
    }
}
