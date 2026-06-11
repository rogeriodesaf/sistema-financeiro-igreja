package org.acme.dto.usuario;

import org.acme.enums.PerfilUsuario;

import java.time.LocalDateTime;

public record UsuarioResponseDTO (
        Long id ,
        String nome,
        String email,
        PerfilUsuario perfil,
        Boolean ativo,
        LocalDateTime dataCriacao,
        LocalDateTime dataAtualizacao

) {
}
