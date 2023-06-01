package co.talento.uco.contacto.modelo.dominio;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Contacto {
    private Long id;
    private String nombre;
    private String correo;
    private String celular;
    private String ciudad;
    private String direccion;

    public Contacto(String nombre, String correo, String celular, String ciudad, String direccion) {
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }
}
