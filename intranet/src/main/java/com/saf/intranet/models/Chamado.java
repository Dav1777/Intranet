package com.saf.intranet.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table("chamados")
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String descricao;
    private Status status;
    private Prioridade prioridade;
    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao;
}
