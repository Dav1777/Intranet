package com.saf.intranet.controller;

import com.saf.intranet.dtos.SetorRequestDTO;
import com.saf.intranet.dtos.SetorResponseDTO;
import com.saf.intranet.models.Setor;
import com.saf.intranet.services.SetorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/intranet/setores")
public class SetorController {

    private final SetorService setorService;

    public SetorController(SetorService setorService) {
        this.setorService = setorService;
    }

    private SetorResponseDTO toResponseDTO(Setor setor){
        return new SetorResponseDTO(setor);
    }

    @PostMapping
    public ResponseEntity<SetorResponseDTO> criarSetor(@RequestBody SetorRequestDTO dto){
        Setor salvo = setorService.salvar(dto);
        SetorResponseDTO responseDTO = new SetorResponseDTO(salvo);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SetorResponseDTO>> litarTodosSetores(){
        List<SetorResponseDTO> setor = setorService.listarTodos();
        return ResponseEntity.ok(setor);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<SetorResponseDTO>> buscarSetorPorTitulo(@RequestParam String titulo){
        List<SetorResponseDTO> resultados = setorService.buscarPorNome(titulo).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(resultados);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarInformativo(@PathVariable Long id){
        setorService.deletar(id);
    }
}
