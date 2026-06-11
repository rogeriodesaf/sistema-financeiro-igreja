package org.acme.service;


import jakarta.enterprise.context.ApplicationScoped;
import org.acme.repository.UsuarioRepository;

@ApplicationScoped
public class AuthService {

    private final UsuarioRepository usuarioRepository;

    public AuthService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


}

