package com.saf.intranet.dtos;

import com.saf.intranet.models.Informativo;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter @Setter
public class InformativoResponseDTO {

    private Long id;
    private String titulo;
    private String conteudo;
    private LocalDateTime dataPublicacao;
    private boolean ativo;

    public InformativoResponseDTO(Informativo informativo){
        this.id = informativo.getId();
        this.titulo = informativo.getTitulo();
        this.conteudo = informativo.getConteudo();
        this.dataPublicacao = informativo.getDataPublicacao();
        this.ativo = informativo.isAtivo();
    }
}
