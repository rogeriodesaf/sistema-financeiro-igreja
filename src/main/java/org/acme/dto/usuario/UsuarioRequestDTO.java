package org.acme.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.acme.enums.PerfilUsuario;

public record UsuarioRequestDTO(

        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotBlank(message = "O email é obrigatório")
        @Email
        String email,

        @NotBlank(message = "A senha é obrigatória")
        String senha,

        @NotNull(message = "O perfil é obrigatório")
        PerfilUsuario perfil
) {
}
