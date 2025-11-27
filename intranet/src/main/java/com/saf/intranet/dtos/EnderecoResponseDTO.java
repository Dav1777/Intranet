package com.saf.intranet.dtos;

import com.saf.intranet.models.Endereco;

public record EnderecoResponseDTO(

        String logradouro,
        String bairro,
        String cidade,
        String estado,
        String cep,
        Integer numero,
        String complemento
) {
    public EnderecoResponseDTO(Endereco endereco) {
        this(
                endereco.getLogradouro(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getCep(),
                endereco.getNumero(),
                endereco.getComplemento()
        );
    }
}
