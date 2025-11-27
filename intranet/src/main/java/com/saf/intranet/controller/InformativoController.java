package com.saf.intranet.controller;

import com.saf.intranet.dtos.InformativoRequestDTO;
import com.saf.intranet.dtos.InformativoResponseDTO;
import com.saf.intranet.models.Informativo;
import com.saf.intranet.services.InformativoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/informativos")
public class InformativoController {

    private final InformativoService informativoService;

    public InformativoController(InformativoService informativoService) {
        this.informativoService = informativoService;
    }

    private InformativoResponseDTO toResponseDTO(Informativo informativo){
        return new InformativoResponseDTO(informativo);
    }

    @PostMapping
    public ResponseEntity<InformativoResponseDTO> criarInformativo(@RequestBody InformativoRequestDTO dto){
        Informativo salvo = informativoService.salvar(dto);
        InformativoResponseDTO responseDTO = new InformativoResponseDTO(salvo);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    //esse aqui tambem nao tem o ("/")
    @GetMapping
    public ResponseEntity<List<InformativoResponseDTO>> listarTodosInformativos(){
        List<InformativoResponseDTO> informativos = informativoService.listarTodos();

        return ResponseEntity.ok(informativos);
    }

    @GetMapping("/publico")
    public List<InformativoResponseDTO> listarAtivos(){
        return informativoService.listarVisiveis();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InformativoResponseDTO> findById(@PathVariable Long id){
        return informativoService.buscarPorId(id)
                .map(this::toResponseDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<InformativoResponseDTO>> buscarInformativosPorTitulo(@RequestParam String titulo){
        List<InformativoResponseDTO> resultados = informativoService.buscarPorTitulo(titulo).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(resultados);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarInformativo(@PathVariable Long id){
        informativoService.deletar(id);
    }
}
