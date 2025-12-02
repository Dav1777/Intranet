package com.saf.intranet.dtos;

import com.saf.intranet.models.Setor;

public record SetorResponseDTO(
        Long id,
        String nome
) {
    public SetorResponseDTO(Setor setor){
        this(
                setor.getId(),
                setor.getNome()
        );
    }
}
