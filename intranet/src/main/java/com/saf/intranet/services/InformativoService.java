package com.saf.intranet.services;

import com.saf.intranet.dtos.InformativoRequestDTO;
import com.saf.intranet.models.Informativo;
import com.saf.intranet.repositories.InformativoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InformativoService {

    private final InformativoRepository informativoRepository;

    public InformativoService(InformativoRepository informativoRepository) {
        this.informativoRepository = informativoRepository;
    }

    public List<Informativo> listarVisiveis() {
        return informativoRepository.findByAtivoTrueOrderByDataPublicacaoDesc();
    }

    public List<Informativo> buscarPorTitulo(String titulo) {
        return informativoRepository.findByTituloContainingIgnoreCase(titulo);
    }

    public Optional<Informativo> buscarPorId(Long id) {
        return informativoRepository.findById(id);
    }
    //salvar == criar
    public Informativo salvar(InformativoRequestDTO dto) {
        Informativo informativo = new Informativo();
        informativo.setTitulo(dto.getTitulo());
        informativo.setConteudo(dto.getConteudo());
        return informativoRepository.save(informativo);
    }

    public List<Informativo> listarTodos() {
        return informativoRepository.findAll();
    }

    public void deletar(Long id) {
        informativoRepository.deleteById(id);
    }
}