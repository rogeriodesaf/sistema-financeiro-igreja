package org.acme.security;

import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PasswordService {

    public String hash(String senha) {
        // Implementação de hashing de senha (ex: BCrypt)
        return BcryptUtil.bcryptHash(senha); // Placeholder, substitua pela implementação real
    }

    public boolean matches(String senhaDigitada, String senhaCriptografada) {
        // Implementação de verificação de senha

        return BcryptUtil.matches(
                senhaDigitada,
                senhaCriptografada);
    }
}
