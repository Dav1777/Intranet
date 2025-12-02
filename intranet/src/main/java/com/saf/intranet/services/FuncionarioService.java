package com.saf.intranet.services;

import com.saf.intranet.dtos.FuncionarioRequestDTO;
import com.saf.intranet.dtos.FuncionarioResponseDTO;
import com.saf.intranet.models.Endereco;
import com.saf.intranet.models.Funcionario;
import com.saf.intranet.models.Setor;
import com.saf.intranet.repositories.FuncionarioRepository;
import com.saf.intranet.repositories.SetorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final SetorRepository setorRepository;

    // SAVE
    public FuncionarioResponseDTO save(FuncionarioRequestDTO dto) {

        Setor setor = setorRepository.findById(dto.idSetor())
                .orElseThrow(() -> new RuntimeException("Setor não encontrado."));

        Endereco endereco = new Endereco();

        endereco.setLogradouro(dto.logradouro());
        endereco.setNumero(dto.numero());
        endereco.setComplemento(dto.complemento());
        endereco.setBairro(dto.bairro());
        endereco.setCidade(dto.cidade());
        endereco.setEstado(dto.estado());
        endereco.setCep(dto.cep());

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(dto.nome());
        funcionario.setEmail(dto.email());
        funcionario.setCpf(dto.cpf());
        funcionario.setCargo(dto.cargo());
        funcionario.setTelefone(dto.telefone());
        funcionario.setSenha(dto.senha());

        funcionario.setSetor(setor);
        funcionario.setEndereco(endereco);

        Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);

        return new FuncionarioResponseDTO(funcionarioSalvo);
    }

    public FuncionarioResponseDTO findById(Long id) {
        Funcionario f = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado."));
        return new FuncionarioResponseDTO(f);
    }

    public Page<FuncionarioResponseDTO> findAll(Pageable pageable) {
        return funcionarioRepository.findAll(pageable)
                .map(FuncionarioResponseDTO::new);
    }

    public void delete(Long id) {
        if (!funcionarioRepository.existsById(id)) {
            throw new RuntimeException("Funcionário não encontrado.");
        }
        funcionarioRepository.deleteById(id);
    }
}
