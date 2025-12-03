package com.saf.intranet.controller;

import com.saf.intranet.dtos.ChamadoRequestDTO;
import com.saf.intranet.dtos.ChamadoResponseDTO;
import com.saf.intranet.dtos.ConteudoRequestDTO;
import com.saf.intranet.models.Chamado;
import com.saf.intranet.services.ChamadoService;
import com.saf.intranet.services.ConteudoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/intranet/chamados")
public class ChamadoController {

    private final ChamadoService chamadoService;
    private final ConteudoService conteudoService;

    public ChamadoController(ChamadoService chamadoService, ConteudoService conteudoService){
        this.chamadoService = chamadoService;
        this.conteudoService = conteudoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ChamadoResponseDTO criarChamado(@RequestBody @Valid ChamadoRequestDTO dto){
        return chamadoService.criarChamado(dto);
    }

    @GetMapping("/{id}")
    public ChamadoResponseDTO buscarPorId(@PathVariable Long id){
        return chamadoService.buscarChamado(id);
    }

    @GetMapping
    public List<ChamadoResponseDTO> listarTodos(){
        return chamadoService.listarTodos();
    }

    @PatchMapping("{id}/conteudo")
    @ResponseStatus(HttpStatus.OK)
    public ChamadoResponseDTO adicionarConteudo(
            @PathVariable("id") Long id,
            @ModelAttribute @Valid ConteudoRequestDTO dto){
        dto.setIdChamado(id);
        conteudoService.salvarComArquivo(dto);
        var chamado = chamadoService.buscarPorId(id);
        return chamadoService.atualizarChamado(id, dto);
    }
}
