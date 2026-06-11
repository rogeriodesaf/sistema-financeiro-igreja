package org.acme.service;


import jakarta.enterprise.context.ApplicationScoped;
import org.acme.dto.auth.LoginRequestDTO;
import org.acme.dto.auth.LoginResponseDTO;
import org.acme.entity.Usuario;
import org.acme.repository.UsuarioRepository;
import org.acme.security.JWTService;
import org.acme.security.PasswordService;

@ApplicationScoped
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordService passwordService;
    private final JWTService jwtService;

    public AuthService(UsuarioRepository usuarioRepository, PasswordService passwordService, JWTService jwtService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordService = passwordService;
        this.jwtService = jwtService;
    }

    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        Usuario usuario = usuarioRepository.buscarPorEmail(loginRequestDTO.email())
                .orElseThrow(()->
                        new RuntimeException("Usuário não encontrado"));
        if (!usuario.ativo) {
            throw new RuntimeException("Usuário inativo");
        }
        if (!passwordService.matches(loginRequestDTO.senha(), usuario.senha)) {
            throw new RuntimeException("Senha incorreta");
        }
        String token = jwtService.gerarToken(usuario);
        return new LoginResponseDTO(token, usuario.id, usuario.nome, usuario.perfil);
    }

}

