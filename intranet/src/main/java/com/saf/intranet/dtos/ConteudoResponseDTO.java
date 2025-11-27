package com.saf.intranet.dtos;

import com.saf.intranet.models.Conteudo;

import java.time.LocalDateTime;

public record ConteudoResponseDTO(

        Long id,
        String texto,
        Long idChamado,
        String autorMatricula,
        String caminhoArquivo,
        LocalDateTime dataCriacao
) {
    public ConteudoResponseDTO(Conteudo conteudo){
        this(
                conteudo.getId(),
                conteudo.getTexto(),
                conteudo.getChamado().getId(),
                conteudo.getAutorMatricula(),
                conteudo.getCaminhoArquivo(),
                conteudo.getDataCriacao()
        );
    }


}
