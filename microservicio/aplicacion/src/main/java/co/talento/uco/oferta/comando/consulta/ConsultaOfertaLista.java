package co.talento.uco.oferta.comando.consulta;

import co.talento.uco.oferta.modelo.dtoRespuesta.RespuestaOferta;
import co.talento.uco.oferta.puerto.dao.DaoOferta;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ConsultaOfertaLista {

    private final DaoOferta daoOferta;

    public List<RespuestaOferta> consultar(){
        return daoOferta.consultarOfertalista();
    }
}
