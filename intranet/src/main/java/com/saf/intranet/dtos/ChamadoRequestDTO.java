package com.saf.intranet.dtos;

import com.saf.intranet.models.Funcionario;
import com.saf.intranet.models.Prioridade;
import com.saf.intranet.models.Status;
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
        Prioridade prioridade,
        @NotNull
        Long idFuncionario,
        @NotNull
        Status status,
        @NotNull
        String mensagem
) {
}
