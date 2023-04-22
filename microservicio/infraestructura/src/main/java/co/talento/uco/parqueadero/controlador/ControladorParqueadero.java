package co.talento.uco.parqueadero.controlador;

import co.talento.uco.parqueadero.comando.RequestParqueaderoTransaccion;
import co.talento.uco.parqueadero.modelo.dtoRespuesta.ResponseParqueaderoGuardarCapacidad;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("parqueadero")
public class ControladorParqueadero {




    @PostMapping
    public ResponseEntity<ResponseParqueaderoGuardarCapacidad> guardarCapacidad(@RequestBody RequestParqueaderoTransaccion dtoPrestamo){

       /* try {
            //Guardar
            return new ResponseEntity<>(ResponseParqueaderoGuardarCapacidad, HttpStatus.OK);
        } catch (Exception exception) {

            return new ResponseEntity<>(dtoPrestamo, HttpStatus.BAD_REQUEST);
        }
*/
        return null;
        }

}
