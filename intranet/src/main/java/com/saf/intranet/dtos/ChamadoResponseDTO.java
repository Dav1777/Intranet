package com.saf.intranet.dtos;

import com.saf.intranet.models.Prioridade;
import com.saf.intranet.models.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class ChamadoResponseDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private Status status;
    private Prioridade prioridade;
    private LocalDateTime dataCriacao;
    private Long setorId;
    private String nomeSetor;

}
