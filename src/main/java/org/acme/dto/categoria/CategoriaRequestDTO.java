package org.acme.dto.categoria;

import org.acme.enums.TipoLancamento;

public record CategoriaRequestDTO(
        String nome,
        TipoLancamento tipo
) {
}
