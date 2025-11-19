package com.saf.intranet.controller;

import com.saf.intranet.dtos.FuncionarioRequestDTO;
import com.saf.intranet.dtos.FuncionarioResponseDTO;
import com.saf.intranet.services.FuncionarioService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService){
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public ResponseEntity<FuncionarioResponseDTO> save(@RequestBody FuncionarioRequestDTO funcionarioRequestDTO, UriComponentsBuilder uriComponentsBuilder){
        var funcionarioResponseDTO = funcionarioService.save(funcionarioRequestDTO);
        var uri = uriComponentsBuilder.path("/funcionario/{id}").buildAndExpand(funcionarioResponseDTO.id()).toUri();
        return ResponseEntity.created(uri).body(funcionarioResponseDTO);
    }

    @GetMapping
    public ResponseEntity<Page<FuncionarioResponseDTO>> findAll(@PageableDefault Pageable pageable){
        return ResponseEntity.ok(funcionarioService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(funcionarioService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        funcionarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
