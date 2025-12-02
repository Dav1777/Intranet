package com.saf.intranet.services;

import com.saf.intranet.dtos.InformativoRequestDTO;
import com.saf.intranet.dtos.InformativoResponseDTO;
import com.saf.intranet.models.Informativo;
import com.saf.intranet.repositories.InformativoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InformativoService {

    private final InformativoRepository informativoRepository;

    public InformativoService(InformativoRepository informativoRepository) {
        this.informativoRepository = informativoRepository;
    }

    public InformativoResponseDTO toResponseDTO(Informativo informativo) {
        return new InformativoResponseDTO(informativo);
    }

    public List<InformativoResponseDTO> listarVisiveis() {
        return informativoRepository.findByAtivoTrueOrderByDataPublicacaoDesc().stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public List<InformativoResponseDTO> listarTodos() {
        return informativoRepository.findAll().stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public List<Informativo> buscarPorTitulo(String titulo) {
        return informativoRepository.findByTituloContainingIgnoreCase(titulo);
    }

    public Optional<Informativo> buscarPorId(Long id) {
        return informativoRepository.findById(id);
    }

    public Informativo salvar(InformativoRequestDTO dto) {
        Informativo informativo = new Informativo();

        informativo.setTitulo(dto.titulo());
        informativo.setConteudo(dto.conteudo());
        informativo.setDataPublicacao(LocalDateTime.now());
        informativo.setAtivo(true);

        return informativoRepository.save(informativo);
    }

    public void deletar(Long id) {
        informativoRepository.deleteById(id);
    }


}