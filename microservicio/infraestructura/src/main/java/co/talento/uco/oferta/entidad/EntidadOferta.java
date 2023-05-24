package co.talento.uco.oferta.entidad;

import co.talento.uco.contacto.entidad.EntidadContacto;
import co.talento.uco.postdetails.entidad.EntidadPostDetails;
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

    @OneToOne
    @JoinColumn(name = "id_post_details")
    private EntidadPostDetails entidadPostDetails;

    @OneToOne
    @JoinColumn(name = "id_contacto")
    private EntidadContacto entidadContacto;

    private boolean isActive;

    private List<String> tags;

    public EntidadOferta(EntidadUsuario entidadUsuario, EntidadPostDetails entidadPostDetails, EntidadContacto entidadContacto, boolean isActive, List<String> tags) {
        this.entidadUsuario = entidadUsuario;
        this.entidadPostDetails = entidadPostDetails;
        this.entidadContacto = entidadContacto;
        this.isActive = isActive;
        this.tags = tags;
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
}
