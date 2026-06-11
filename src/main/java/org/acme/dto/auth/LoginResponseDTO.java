package org.acme.dto.auth;

import org.acme.enums.PerfilUsuario;

public record LoginResponseDTO(
        String token,
        String usuarioId,
        String nome,
        PerfilUsuario perfil
) {
}
