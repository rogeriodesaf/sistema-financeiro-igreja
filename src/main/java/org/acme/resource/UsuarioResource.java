package org.acme.resource;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.acme.dto.usuario.UsuarioRequestDTO;
import org.acme.dto.usuario.UsuarioResponseDTO;

@Path("/auth")
public class UsuarioResource {

    @POST
    @Path("/login")
    public UsuarioResponseDTO login(UsuarioRequestDTO request) {
        // Lógica de autenticação
        // Verificar email e senha, gerar token JWT, etc.
        //return new UsuarioResponseDTO(/* dados do usuário e token */);
    }
}
