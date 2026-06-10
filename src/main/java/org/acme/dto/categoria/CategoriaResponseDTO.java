package org.acme.dto.categoria;

import org.acme.enums.TipoLancamento;

public record CategoriaResponseDTO (
        Long id,
        String nome,
        TipoLancamento tipo,
        String dataCriacao,
        String dataAtualizacao,
        Boolean ativo

) {
}
