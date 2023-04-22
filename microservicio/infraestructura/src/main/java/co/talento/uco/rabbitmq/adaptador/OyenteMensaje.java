package co.talento.uco.rabbitmq.adaptador;

import co.talento.uco.gson.GsonAdaptador;
import co.talento.uco.vehiculo.modelo.dominio.VehiculoMovimiento;
import org.springframework.stereotype.Component;

@Component
public class OyenteMensaje implements GsonAdaptador {
    
    //@RabbitListener(queues = "${parking.queue}")
    public void recibirMensaje(String mensaje) {

        try {
            var vehiculoMovimiento = fromJson(mensaje, VehiculoMovimiento.class);
            System.out.println("Mensaje: " + mensaje);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
