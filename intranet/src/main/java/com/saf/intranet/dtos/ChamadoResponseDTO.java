package com.saf.intranet.dtos;

import com.saf.intranet.models.Prioridade;
import com.saf.intranet.models.Status;

import java.time.LocalDateTime;

public record ChamadoResponseDTO(

        Long id,
        String titulo,
        String descricao,
        Status status,
        Prioridade prioridade,
        LocalDateTime dataCriacao,
        Long setorId,
        String nomeSetor
) {

}
