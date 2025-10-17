package com.saf.intranet.controller;

import com.saf.intranet.dtos.InformativoRequestDTO;
import com.saf.intranet.dtos.InformativoResponseDTO;
import com.saf.intranet.models.Informativo;
import com.saf.intranet.services.InformativoService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/informativos")
public class InformativoController {

    private final InformativoService informativoService;

    public InformativoController(InformativoService informativoService) {
        this.informativoService = informativoService;
    }

    @PostMapping
    public ResponseEntity<InformativoResponseDTO> criarInformativo(@RequestBody InformativoRequestDTO dto){
        Informativo salvo = informativoService.salvar(dto);
        InformativoResponseDTO responseDTO = new InformativoResponseDTO(salvo);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    //esse aqui tambem nao tem o ("/")
    @GetMapping
    public ResponseEntity<List<Informativo>> listarTodosInformativos(){
        List<Informativo> informativos = informativoService.listarTodos();
        return ResponseEntity.ok(informativos);
    }

    @GetMapping("/publico")
    public List<Informativo> listarAtivos(){
        return informativoService.listarVisiveis();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Informativo> findById(@PathVariable Long id){
        return informativoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Informativo>> buscarInformativosPorTitulo(@RequestParam String titulo){
        List<Informativo> resultados = informativoService.buscarPorTitulo(titulo);
        return ResponseEntity.ok(resultados);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarInformativo(@PathVariable Long id){
        informativoService.deletar(id);
    }
}
