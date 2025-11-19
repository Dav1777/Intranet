package com.saf.intranet.dtos;

import com.saf.intranet.models.Funcionario;

public record FuncionarioResponseDTO(Long id, String nome, String email) {
    public FuncionarioResponseDTO(Funcionario funcionario){
        this(Long.valueOf(funcionario.getMatricula()), funcionario.getNome(), funcionario.getEmail());
    }
}
