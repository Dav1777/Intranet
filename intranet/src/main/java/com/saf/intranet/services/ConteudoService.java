package com.saf.intranet.services;

import com.saf.intranet.dtos.ConteudoRequestDTO;
import com.saf.intranet.models.Chamado;
import com.saf.intranet.models.Conteudo;
import com.saf.intranet.repositories.ChamadoRepository;
import com.saf.intranet.repositories.ConteudoRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConteudoService {

    private final ConteudoRepository conteudoRepository;
    private final ChamadoRepository chamadoRepository;

    private static final String UPLOAD_DIR = "upload/prints/";

    public Conteudo salvarComArquivo(@Valid ConteudoRequestDTO dto){

        Chamado chamado = chamadoRepository.findById(dto.getIdChamado())
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado"));

        String caminhoDoArquivo = null;

        MultipartFile arquivo = dto.getArquivo();

        if (arquivo != null && !arquivo.isEmpty()) {
            try {
                String nomeOriginal = arquivo.getOriginalFilename();
                String nomeUnico = chamado.getId() + "_" + System.currentTimeMillis() + "_" + nomeOriginal;

                Path caminhoCompleto = Paths.get(UPLOAD_DIR, nomeUnico);

                Files.createDirectories(caminhoCompleto.getParent());
                Files.copy(arquivo.getInputStream(), caminhoCompleto);

                caminhoDoArquivo = "/" + UPLOAD_DIR + nomeUnico;

            } catch (IOException e) {
                throw new RuntimeException("Erro ao salvar arquivo do chamado.", e);
            }
        }

        Conteudo conteudo = new Conteudo();
        conteudo.setChamado(chamado);
        conteudo.setTexto(dto.getTexto());
        conteudo.setCaminhoArquivo(caminhoDoArquivo);

        conteudo.setAutorId(dto.getAutorMatricula());

        return conteudoRepository.save(conteudo);
    }


    public List<Conteudo> buscarPorChamado(Long chamadoId) {
        return conteudoRepository.findByChamadoId(chamadoId);
    }

    public List<Conteudo> listarTodos(){
        return conteudoRepository.findAll();
    }
}
