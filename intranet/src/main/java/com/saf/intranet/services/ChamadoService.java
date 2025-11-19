package com.saf.intranet.services;

import com.saf.intranet.dtos.ChamadoRequestDTO;
import com.saf.intranet.dtos.ChamadoResponseDTO;
import com.saf.intranet.models.Chamado;
import com.saf.intranet.repositories.ChamadoRepository;
import com.saf.intranet.repositories.SetorRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChamadoService {

    private final ChamadoRepository chamadoRepository;

    private final SetorRepository setorRepository;

    public ChamadoService(ChamadoRepository chamadoRepository, SetorRepository setorRepository){
        this.chamadoRepository = chamadoRepository;
        this.setorRepository = setorRepository;
    }

    public Chamado buscarPorId(Long id){
        var aux = chamadoRepository.findById(id);
        if (aux.isEmpty()){
            throw new RuntimeException("Tem não");
        }
        return (Chamado) aux.get();
    }


    /*puta que pariu como faz isso
    public Chamado criarChamado(ChamadoRequestDTO dto){
        Setor setor = setorRepository.findById(dto.getSetorId())
                .orElseThrow(()->new RuntimeException("Setor não encontrado"));

        Chamado chamado = new Chamado();

        chamado.setTitulo(dto.getTitulo());
        chamado.setDescricao(dto.getDescricao());
        chamado.setPrioridade(dto.getPrioridade());

        return chamadoRepository.save(chamado);
    }*/

    public Object criarChamado(ChamadoRequestDTO chamadoRequestDTO) {
        Chamado chamado = new Chamado(chamadoRequestDTO.getDescricao(),
                chamadoRequestDTO.getTitulo(),
                chamadoRequestDTO.getSetorId(),
                chamadoRequestDTO.getPrioridade());
        chamadoRepository.save(chamadoRepository);
        return new ChamadoResponseDTO();
    }

    public ChamadoResponseDTO toResponseDTO(Chamado chamado){
        ChamadoResponseDTO dto = new ChamadoResponseDTO();

        dto.setId(chamado.getId());
        dto.setTitulo(chamado.getTitulo());
        dto.setDescricao(chamado.getDescricao());
        dto.setStatus(chamado.getStatus());
        dto.setPrioridade(chamado.getPrioridade());
        dto.setDataCriacao(chamado.getDataCriacao());

        if (chamado.getSetor() != null)  {
            dto.setSetorId(chamado.getSetor().getId());
            dto.setNomeSetor(chamado.getSetor().getNome());
        }

        return dto;
    }

    public List<ChamadoResponseDTO> listarTodos() {
        return chamadoRepository.findAllWithSetor().stream()
                .map(this::toResponseDTO)
                .toList();
    }


}
