package co.talento.uco.rol.adaptador.entidad;

import co.talento.uco.Role;

import javax.persistence.*;

@Entity
@Table(name = "rol")
public class EntidadRol {

    @Id
    @Column
    @Enumerated(EnumType.STRING)
    private Role rol;

    public EntidadRol() {
        super();
    }

    public EntidadRol(Role role) {
        super();
        this.rol = role;
    }

    public Role getRol() {
        return rol;
    }

    public void setRol(Role rol) {
        this.rol = rol;
    }
}
