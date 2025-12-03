package com.saf.intranet.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class ConteudoRequestDTO {

    private String texto;

    @NotNull
    private Long idChamado;

    private Long autorId;

    private MultipartFile arquivo;
}
