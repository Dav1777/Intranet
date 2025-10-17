package com.saf.intranet.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String matricula;
    private String nome;
    private String email;
    private String cpf;
    private String cargo;
    private Setor setor;
    private String senha;
    @Embedded
    private Endereco endereco;
    private Long telefone;



}
