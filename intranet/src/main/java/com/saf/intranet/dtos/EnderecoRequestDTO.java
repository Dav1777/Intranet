package com.saf.intranet.dtos;

public record EnderecoRequestDTO(
        String logradouro,
        Integer numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        String cep
) {}
