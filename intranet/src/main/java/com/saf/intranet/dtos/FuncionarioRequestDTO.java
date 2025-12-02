package com.saf.intranet.dtos;

import com.saf.intranet.models.Endereco;

public record FuncionarioRequestDTO(
        String nome,
        String email,
        String cpf,
        String cargo,
        Long idSetor,
        String senha,
        String telefone,

        String logradouro,
        Integer numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        String cep
) {}
