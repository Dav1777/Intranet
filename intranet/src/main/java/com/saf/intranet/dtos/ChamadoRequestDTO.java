package com.saf.intranet.dtos;

import com.saf.intranet.models.Prioridade;
import com.saf.intranet.models.Setor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ChamadoRequestDTO {

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    @NotBlank
    private Setor setorId;

    @NotNull
    private Prioridade prioridade;
}
