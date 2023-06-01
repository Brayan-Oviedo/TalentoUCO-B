package co.talento.uco.postdetails.modelo.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostDetails {
    private Long id;
    private String titulo;
    private String descripcion;

    public PostDetails(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }
}
