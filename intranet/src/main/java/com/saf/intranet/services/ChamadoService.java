package com.saf.intranet.services;

import com.saf.intranet.dtos.ChamadoRequestDTO;
import com.saf.intranet.dtos.ChamadoResponseDTO;
import com.saf.intranet.dtos.ConteudoRequestDTO;
import com.saf.intranet.models.Chamado;
import com.saf.intranet.models.Conteudo;
import com.saf.intranet.repositories.ChamadoRepository;
import com.saf.intranet.repositories.ConteudoRepository;
import com.saf.intranet.repositories.FuncionarioRepository;
import com.saf.intranet.repositories.SetorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChamadoService {

    private final ChamadoRepository chamadoRepository;
    private final SetorRepository setorRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final ConteudoRepository conteudoRepository;

    public ChamadoService(ChamadoRepository chamadoRepository, SetorRepository setorRepository,
                          FuncionarioRepository funcionarioRepository,
                          ConteudoRepository conteudoRepository){
        this.chamadoRepository = chamadoRepository;
        this.setorRepository = setorRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.conteudoRepository = conteudoRepository;
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

        var funcionario = funcionarioRepository.findById(dto.idFuncionario())
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));


        Chamado chamado = new Chamado();

        chamado.setTitulo(dto.titulo());
        chamado.setDescricao(dto.descricao());
        chamado.setPrioridade(dto.prioridade());
        chamado.setSetor(setor);
        chamado.setFuncionario(funcionario);
        chamado.setStatus(dto.status());


        Chamado chamadoSalvo = chamadoRepository.save(chamado);

        return toResponseDTO(chamadoSalvo);
    }

    public Chamado atualizarChamado(ConteudoRequestDTO conteudoRequestDTO){
        var chamado = chamadoRepository.findById(conteudoRequestDTO.getIdChamado()).orElseThrow();
        var conteudo = new Conteudo();
        chamado.getConteudos().add(conteudo);


        return chamadoRepository.save(chamado);
    }
}
