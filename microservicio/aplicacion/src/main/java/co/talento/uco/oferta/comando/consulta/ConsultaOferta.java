package co.talento.uco.oferta.comando.consulta;

import co.talento.uco.oferta.modelo.dtoRespuesta.RespuestaOferta;
import co.talento.uco.oferta.puerto.dao.DaoOferta;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsultaOferta {

    private final DaoOferta daoOferta;

    public RespuestaOferta consultar(Long id){
        return daoOferta.consultarOferta(id);
    }
}
