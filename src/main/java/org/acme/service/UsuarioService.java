package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.dto.usuario.UsuarioRequestDTO;
import org.acme.dto.usuario.UsuarioResponseDTO;
import org.acme.entity.Usuario;
import org.acme.mapper.UsuarioMapper;
import org.acme.repository.UsuarioRepository;
import org.acme.security.JWTService;
import org.acme.security.PasswordService;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordService passwordService;

    @Inject
    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper,  PasswordService passwordService) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.passwordService = passwordService;

    }

    @Transactional
    public UsuarioResponseDTO cadastarUsuario(UsuarioRequestDTO usuarioRequestDTO){
        var usuario = usuarioMapper.toEntity(usuarioRequestDTO);
       var existeUsuario = usuarioRepository.buscarPorEmail(usuario.email);
        if(existeUsuario.isPresent()){
            throw new RuntimeException("Já existe um usuário com esse email");
        }

        usuario.senha = passwordService.hash(usuarioRequestDTO.senha());

        usuarioRepository.persist(usuario);
        usuarioRepository.flush();
        return usuarioMapper.toResponse(usuario);
    }

    public List<UsuarioResponseDTO> listarUsuarios(){
        return usuarioRepository.listAll()
                .stream()
                .map(usuarioMapper::toResponse)
                .toList();
    }

    public UsuarioResponseDTO buscarUsuarioPorId(Long id){
      Usuario usuario =  usuarioRepository.findById(id);
      if (usuario == null){
          throw new RuntimeException("Usuário não encontrado");
      }
        return usuarioMapper.toResponse(usuario);
    }

    public UsuarioResponseDTO atualizarUsuario(Long id, UsuarioRequestDTO usuarioRequestDTO){
        Usuario usuario =  usuarioRepository.findById(id);
        if (usuario == null){
            throw new RuntimeException("Usuário não encontrado");
        }
        usuario.nome = usuarioRequestDTO.nome();
        usuario.email = usuarioRequestDTO.email();
        usuario.perfil = usuarioRequestDTO.perfil();

        return usuarioMapper.toResponse(usuario);
    }
};
