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
@Table(name = "informativos")
public class Informativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String titulo;
    @Lob
    @Column(nullable = false)
    private String conteudo;

    @Column(name = "data_publicacao", nullable = false)
    private LocalDateTime dataPublicacao = LocalDateTime.now();

    @Column(nullable = false)
    private boolean ativo = true;

    public static void setTitulo(Object titulo) {
    }

    public static void setConteudo(Object conteudo) {
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return "";
    }

    public String getConteudo() {
        return "";
    }

    public LocalDateTime getDataPublicacao() {
        return null;
    }

    public boolean isAtivo() {
        return false;
    }
}
