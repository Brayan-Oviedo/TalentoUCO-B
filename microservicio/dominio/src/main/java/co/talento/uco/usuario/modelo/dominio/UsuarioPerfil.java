package co.talento.uco.usuario.modelo.dominio;

import co.talento.uco.ValidadorParametro;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class UsuarioPerfil {

    public static final String EL_PERFIL_DEBE_PERTENECER_A_UN_USUARIO = "El perfil debe pertenecer a un usuario";

    private Usuario usuario;

    public UsuarioPerfil(Usuario usuario) {

        ValidadorParametro.validarValorNulo(usuario, EL_PERFIL_DEBE_PERTENECER_A_UN_USUARIO);
        this.usuario = usuario;
    }
}


