package org.acme.dto.usuario;

import org.acme.enums.PerfilUsuario;

public record UsuarioResponseDTO (
        String token,
        String nome,
        PerfilUsuario perfil
) {
}
