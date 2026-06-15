package org.acme.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.dto.usuario.UsuarioRequestDTO;
import org.acme.dto.usuario.UsuarioResponseDTO;
import org.acme.entity.Usuario;

@ApplicationScoped
public class UsuarioMapper {

    public Usuario toEntity(UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = new Usuario();
        usuario.nome = usuarioRequestDTO.nome();
        usuario.email = usuarioRequestDTO.email();
        usuario.senha = usuarioRequestDTO.senha();
        usuario.perfil = usuarioRequestDTO.perfil();



        return usuario;
    }

    public UsuarioResponseDTO toResponse(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.id,
                usuario.nome,
                usuario.email,
                usuario.perfil,
                usuario.ativo,
                usuario.dataCriacao,
                usuario.dataAtualizacao
        );
    }
}
