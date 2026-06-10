package org.acme.dto.usuario;

public record UsuarioRequestDTO(
        String email,
        String senha
) {
}
