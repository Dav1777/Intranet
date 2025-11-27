package com.saf.intranet.controller;

import com.saf.intranet.dtos.ConteudoRequestDTO;
import com.saf.intranet.dtos.ConteudoResponseDTO;
import com.saf.intranet.models.Conteudo;
import com.saf.intranet.services.ConteudoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/intranet/conteudos")
@RequiredArgsConstructor
public class ConteudoController {

    private final ConteudoService conteudoService;

    public ConteudoResponseDTO toResponseDTO(Conteudo conteudo){
        return new ConteudoResponseDTO(conteudo);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ConteudoResponseDTO> criarConteudoComArquivo(
            @ModelAttribute @Valid ConteudoRequestDTO dto){

        Conteudo salvo = conteudoService.salvarComArquivo(dto);
        ConteudoResponseDTO responseDTO = toResponseDTO(salvo);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/chamado/{chamadoId}")
    public ResponseEntity<List<ConteudoResponseDTO>> listarConteudosPorChamado(@PathVariable Long chamadoId) {
        List<ConteudoResponseDTO> dtos = conteudoService.buscarPorChamado(chamadoId).stream()
                .map(this::toResponseDTO)
                .toList();

        return ResponseEntity.ok(dtos);
    }
}
