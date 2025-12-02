package com.saf.intranet.dtos;

import jakarta.validation.constraints.NotBlank;

public record SetorRequestDTO(
        @NotBlank
        Long id,
        @NotBlank
        String nome
) { }