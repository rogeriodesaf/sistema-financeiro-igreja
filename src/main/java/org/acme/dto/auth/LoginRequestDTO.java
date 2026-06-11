package org.acme.dto.auth;

public record LoginRequestDTO(
        String email,
        String senha
) {
}
