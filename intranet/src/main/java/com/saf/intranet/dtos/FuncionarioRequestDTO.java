package com.saf.intranet.dtos;

public record FuncionarioRequestDTO(
        String nome,
        String email,
        String cpf,
        String cargo,
        Long idSetor,
        String senha,
        String telefone,
        EnderecoRequestDTO endereco
) {}
