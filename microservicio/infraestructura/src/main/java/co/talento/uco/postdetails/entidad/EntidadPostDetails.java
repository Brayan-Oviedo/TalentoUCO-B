package co.talento.uco.postdetails.entidad;

import javax.persistence.*;

@Entity
public class EntidadPostDetails {

    @Id
    @Column(name = "id_post_details")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String idPostDetails;

    private String titulo;

    private String descripcion;


    public EntidadPostDetails(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public EntidadPostDetails() {}

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
