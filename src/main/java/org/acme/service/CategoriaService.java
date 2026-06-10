package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.dto.categoria.CategoriaRequestDTO;
import org.acme.dto.categoria.CategoriaResponseDTO;
import org.acme.entity.Categoria;
import org.acme.mapper.CategoriaMapper;
import org.acme.repository.CategoriaRepository;

@ApplicationScoped
public class CategoriaService {

       private final CategoriaMapper categoriaMapper;
       private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaMapper categoriaMapper, CategoriaRepository categoriaRepository) {
        this.categoriaMapper = categoriaMapper;
        this.categoriaRepository = categoriaRepository;
    }

    public CategoriaResponseDTO criarCategoria(CategoriaRequestDTO categoriaRequestDTO) {
        Categoria categoria = categoriaMapper.toEntity(categoriaRequestDTO);
        categoria.dataCriacao = java.time.LocalDateTime.now();
        categoria.ativo = true;

        categoriaRepository.persist(categoria);
        return categoriaMapper.toResponseDTO(categoria);
        // Lógica para criar categoria
    }
}
