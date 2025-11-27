package com.saf.intranet.services;

import com.saf.intranet.dtos.ChamadoRequestDTO;
import com.saf.intranet.dtos.ChamadoResponseDTO;
import com.saf.intranet.models.Chamado;
import com.saf.intranet.repositories.ChamadoRepository;
import com.saf.intranet.repositories.SetorRepository;
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

    public ChamadoResponseDTO toResponseDTO(Chamado chamado){
        return new ChamadoResponseDTO(
                chamado.getId(),
                chamado.getTitulo(),
                chamado.getDescricao(),
                chamado.getStatus(),
                chamado.getPrioridade(),
                chamado.getDataCriacao(),
                chamado.getSetor() != null ? chamado.getSetor().getId() : null,
                chamado.getSetor() != null ? chamado.getSetor().getNome() : "Não informado"
        );
    }

    public List<ChamadoResponseDTO> listarTodos() {
        return chamadoRepository.findAllWithSetor().stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public ChamadoResponseDTO buscarChamado(Long id){
        Chamado chamado = buscarPorId(id);
        return toResponseDTO(chamado);
    }

    public ChamadoResponseDTO criarChamado(ChamadoRequestDTO dto) {
        var setor = setorRepository.findById(dto.idSetor())
                .orElseThrow(() -> new RuntimeException("Setor não encontrado"));

        Chamado chamado = new Chamado();

        chamado.setTitulo(dto.titulo());
        chamado.setDescricao(dto.descricao());
        chamado.setPrioridade(dto.prioridade());
        chamado.setSetor(setor);

        Chamado chamadoSalvo = chamadoRepository.save(chamado);

        return toResponseDTO(chamadoSalvo);
    }
}
