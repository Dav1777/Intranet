package com.saf.intranet.dtos;

import com.saf.intranet.models.Endereco;
import com.saf.intranet.models.Funcionario;
import com.saf.intranet.models.Setor;

public record FuncionarioResponseDTO(
        Long id,
        String nome,
        String email,
        String cpf,
        String cargo,
        String telefone,
        Setor setor,
        Endereco endereco
) {
    public FuncionarioResponseDTO(Funcionario f) {
        this(
                f.getId(),
                f.getNome(),
                f.getEmail(),
                f.getCpf(),
                f.getCargo(),
                f.getTelefone(),
                f.getSetor(),
                f.getEndereco()
        );
    }
}
