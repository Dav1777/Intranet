package com.saf.intranet.services;

import com.saf.intranet.dtos.SetorRequestDTO;
import com.saf.intranet.dtos.SetorResponseDTO;
import com.saf.intranet.models.Setor;
import com.saf.intranet.repositories.SetorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetorService {

    private final SetorRepository setorRepository;

    public SetorService(SetorRepository setorRepository) {
        this.setorRepository = setorRepository;
    }

    public SetorResponseDTO toResponseDTO(Setor setor){
        return new SetorResponseDTO(setor);
    }

    public List<SetorResponseDTO> listarTodos() {
        return setorRepository.findAll().stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public Setor salvar(SetorRequestDTO dto) {
        Setor setor = new Setor();

        //setor.setId(dto.id());
        setor.setNome(dto.nome());

        return setorRepository.save(setor);
    }

    public void deletar(Long id) {
        setorRepository.deleteById(id);
    }

    public List<Setor> buscarPorNome(String nome) {
        return setorRepository.findByNomeContainingIgnoreCase(nome);
    }
}
