package co.talento.uco.oferta.entidad;

import co.talento.uco.postdetails.adaptador.contacto.entidad.EntidadContacto;
import co.talento.uco.postdetails.entidad.EntidadPostDetails;
import co.talento.uco.postulacion.entidad.EntidadPostulacion;
import co.talento.uco.usuario.adaptador.entidad.EntidadUsuario;

import javax.persistence.*;
import java.util.List;

@Entity
public class EntidadOferta {
    @Id
    @Column(name = "id_oferta")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idOferta;
    @OneToOne
    @JoinColumn(name = "nombreUsuario")
    private EntidadUsuario entidadUsuario;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "id_post_details")
    private EntidadPostDetails entidadPostDetails;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "id_contacto")
    private EntidadContacto entidadContacto;

    @OneToMany(mappedBy = "postulacion", cascade = CascadeType.ALL)
    private List<EntidadPostulacion> pustulaciones;

    private boolean isActive;

    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> tags;

    public EntidadOferta(EntidadUsuario entidadUsuario, EntidadPostDetails entidadPostDetails, EntidadContacto entidadContacto, boolean isActive, List<String> tags, List<EntidadPostulacion> pustulaciones) {
        this.entidadUsuario = entidadUsuario;
        this.entidadPostDetails = entidadPostDetails;
        this.entidadContacto = entidadContacto;
        this.isActive = isActive;
        this.tags = tags;
        this.pustulaciones = pustulaciones;
    }

    public Long getIdOferta() {
        return idOferta;
    }

    public EntidadUsuario getEntidadUsuario() {
        return entidadUsuario;
    }

    public EntidadPostDetails getEntidadPostDetails() {
        return entidadPostDetails;
    }

    public EntidadContacto getEntidadContacto() {
        return entidadContacto;
    }

    public boolean isActive() {
        return isActive;
    }

    public List<String> getTags() {
        return tags;
    }

    public List<EntidadPostulacion> getPustulaciones() {
        return pustulaciones;
    }
}
