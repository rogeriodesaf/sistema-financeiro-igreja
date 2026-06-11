package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.Categoria;

import java.util.List;

@ApplicationScoped
public class CategoriaRepository implements PanacheRepository<Categoria> {
    public List<Categoria> listarCategoriasAtivas() {
        return list("ativo", true);
    }
}
