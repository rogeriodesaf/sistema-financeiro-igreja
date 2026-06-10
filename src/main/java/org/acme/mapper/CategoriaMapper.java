package org.acme.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.dto.categoria.CategoriaRequestDTO;
import org.acme.dto.categoria.CategoriaResponseDTO;
import org.acme.entity.Categoria;

@ApplicationScoped
public class CategoriaMapper {

    public Categoria toEntity(CategoriaRequestDTO categoriaRequestDTO) {
        Categoria categoria = new Categoria();
        categoria.nome = categoriaRequestDTO.nome();
        categoria.tipo = categoriaRequestDTO.tipo();

        return categoria;
    }

    public CategoriaResponseDTO toResponseDTO(Categoria categoria) {
        return new CategoriaResponseDTO(
                categoria.id,
                categoria.nome,
                categoria.tipo,
                categoria.dataCriacao.toString(),
                categoria.dataAtualizacao.toString(),
                categoria.ativo
        );
    }
}
