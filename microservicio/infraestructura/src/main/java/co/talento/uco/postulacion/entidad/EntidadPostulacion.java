package co.talento.uco.postulacion.entidad;

import co.talento.uco.oferta.entidad.EntidadOferta;
import co.talento.uco.usuario.adaptador.entidad.EntidadUsuario;

import javax.persistence.*;
import java.util.Date;

@Entity
public class EntidadPostulacion {
    @Id
    @Column(name = "id_postulacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "nombreUsuario")
    private EntidadUsuario postulante;

    @ManyToOne()
    @JoinColumn(name = "id_oferta")
    private EntidadOferta oferta ;

    @Column
    private Date fecha;

    @Column
    private String adjunto;


    public EntidadPostulacion(Long id, EntidadUsuario postulante, EntidadOferta oferta, Date fecha, String adjunto) {
        this.id = id;
        this.postulante = postulante;
        this.oferta = oferta;
        this.fecha = fecha;
        this.adjunto = adjunto;
    }

    public EntidadPostulacion(EntidadUsuario postulante, Date fecha, String adjunto) {
        this.postulante = postulante;
        this.fecha = fecha;
        this.adjunto = adjunto;
    }


    public EntidadPostulacion() {

    }

    public EntidadOferta getOferta() {
        return oferta;
    }

    public Long getId() {
        return id;
    }

    public EntidadUsuario getPostulante() {
        return postulante;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getAdjunto() {
        return adjunto;
    }
}
