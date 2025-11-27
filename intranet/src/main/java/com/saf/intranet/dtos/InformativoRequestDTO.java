package com.saf.intranet.dtos;

import jakarta.validation.constraints.NotBlank;

public record InformativoRequestDTO(

        @NotBlank
        String titulo,
        @NotBlank
        String conteudo
) {

}
