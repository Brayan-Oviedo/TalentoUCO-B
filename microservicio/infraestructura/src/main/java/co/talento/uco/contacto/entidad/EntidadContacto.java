package co.talento.uco.contacto.entidad;

import javax.persistence.*;

@Entity
@Table(name="contacto")
public class EntidadContacto {
    @Id
    @Column(name = "id_contacto")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String correo;
    private String celular;
    private String ciudad;
    private String direccion;

    public EntidadContacto(String nombre, String correo, String celular, String ciudad, String direccion) {
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }

    public EntidadContacto() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
