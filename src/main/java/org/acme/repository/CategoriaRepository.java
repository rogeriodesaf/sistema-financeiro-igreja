package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.Categoria;

@ApplicationScoped
public class CategoriaRepository implements PanacheRepository<Categoria> {
}
