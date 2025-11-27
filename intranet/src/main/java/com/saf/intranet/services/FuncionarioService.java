package com.saf.intranet.services;

import com.saf.intranet.dtos.EnderecoRequestDTO;
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

        EnderecoRequestDTO e = dto.endereco();
        Endereco endereco = new Endereco(
                e.logradouro(),
                e.numero(),
                e.complemento(),
                e.bairro(),
                e.cidade(),
                e.estado(),
                e.cep()
        );

        Funcionario f = new Funcionario();
        f.setNome(dto.nome());
        f.setEmail(dto.email());
        f.setCpf(dto.cpf());
        f.setCargo(dto.cargo());
        f.setSenha(dto.senha());
        f.setTelefone(dto.telefone());
        f.setSetor(setor);
        f.setEndereco(endereco);

        Funcionario salvo = funcionarioRepository.save(f);

        return new FuncionarioResponseDTO(salvo);
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
