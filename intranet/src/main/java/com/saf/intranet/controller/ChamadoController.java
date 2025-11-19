package com.saf.intranet.controller;

import com.saf.intranet.dtos.ChamadoRequestDTO;
import com.saf.intranet.dtos.ChamadoResponseDTO;
import com.saf.intranet.models.Chamado;
import com.saf.intranet.repositories.ChamadoRepository;
import com.saf.intranet.services.ChamadoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/intranet/chamados")
public class ChamadoController {

    private final ChamadoService chamadoService;

    public ChamadoController(ChamadoService chamadoService){
        this.chamadoService = chamadoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Chamado criarChamado(@RequestBody @Valid ChamadoRequestDTO dto){
        return (Chamado) chamadoService.criarChamado(dto);
    }

    @GetMapping("/{id}")
    public ChamadoResponseDTO buscarPorId(@PathVariable Long id){
        return chamadoService.buscarChamado(id);
    }

    @GetMapping
    public List<ChamadoResponseDTO> listarTodos(){
        return chamadoService.listarTodos();
    }
}
