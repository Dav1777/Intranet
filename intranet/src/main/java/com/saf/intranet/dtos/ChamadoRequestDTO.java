package com.saf.intranet.dtos;

import com.saf.intranet.models.Prioridade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ChamadoRequestDTO(

        @NotBlank
        String titulo,
        @NotBlank
        String descricao,
        @NotNull
        Long idSetor,
        @NotNull
        Prioridade prioridade
) {
}
