package org.acme.dto.auth;

import org.acme.enums.PerfilUsuario;

public record LoginResponseDTO(
        String token,
        Long usuarioId,
        String nome,
        PerfilUsuario perfil
) {
}
