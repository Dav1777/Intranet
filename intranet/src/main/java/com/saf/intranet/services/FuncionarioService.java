package com.saf.intranet.services;

import com.saf.intranet.models.Funcionario;
import com.saf.intranet.repositories.FuncionarioRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    public FuncionarioResponseDTO save(FuncionarioRequestDTo funcionarioRequestDTo) {
        Funcionario funcionario = new Funcionario(null, usuarioRequest.nome(), usuarioRequest.email(), usuarioRequest.senha(), LocalDateTime.now());
        funcionarioRepository.save(funcionario);
        return new FuncionarioResponseDTO(funcionario);
    }

    public FuncionarioResponseDTO findById(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return new FuncionarioResponseDTO(funcionario);
    }

    public Page<FuncionarioResponseDTO> findAll(Pageable pageable) {
        return funcionarioRepository.findAll(pageable).map(FuncionarioResponseDTO::new);
    }

    public void delete(Long id) {
        if (funcionarioRepository.existsById(id)) {
            funcionarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }
}
