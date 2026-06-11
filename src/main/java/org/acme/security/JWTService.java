package org.acme.security;

import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.Usuario;

import java.time.Duration;
import java.util.Set;

@ApplicationScoped
public class JWTService {

    public String gerarToken(Usuario usuario) {

        return Jwt.issuer("gestao-financeira-igreja")
                .subject(usuario.id.toString())
                .claim("email", usuario.email)
                .groups(Set.of(usuario.perfil.name()))
                .expiresIn(Duration.ofHours(2))
                .sign();
    }
}
