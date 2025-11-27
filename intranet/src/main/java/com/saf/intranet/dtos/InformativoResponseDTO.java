package com.saf.intranet.dtos;

import com.saf.intranet.models.Informativo;
import java.time.LocalDateTime;

public record InformativoResponseDTO(

        Long id,
        String titulo,
        String conteudo,
        LocalDateTime dataPublicacao,
        boolean ativo
) {

    public InformativoResponseDTO(Informativo informativo){
        this(
                informativo.getId(),
                informativo.getTitulo(),
                informativo.getConteudo(),
                informativo.getDataPublicacao(),
                informativo.isAtivo()
        );
    }
}
