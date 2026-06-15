package org.acme.resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.usuario.UsuarioRequestDTO;
import org.acme.dto.usuario.UsuarioResponseDTO;
import org.acme.service.UsuarioService;

import java.net.URI;

@Path("user/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    private final UsuarioService usuarioService;

    @Inject
    public UsuarioResource(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @POST
    @Path("/register")
    //@RolesAllowed("ADMINISTRADOR")
    public Response createUser(UsuarioRequestDTO usuarioRequestDTO) {
        UsuarioResponseDTO response = usuarioService.cadastarUsuario(usuarioRequestDTO);

        URI uri = URI.create("/user/" + response.id());
        return Response.created(uri)
                .entity(response)
                .build();
    }
}
