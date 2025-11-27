package com.saf.intranet.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;

    @Column(unique = true)
    private String cpf;

    private String cargo;

    @ManyToOne
    @JoinColumn(name = "setor_id")
    private Setor setor;

    private String senha;

    @Embedded
    private Endereco endereco;

    private String telefone;
}
