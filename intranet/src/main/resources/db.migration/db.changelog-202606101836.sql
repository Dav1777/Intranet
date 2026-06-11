--liquibase formatted sql
--changeset vinicius:202606101836
--comment: conteudos_chamado table create

CREATE TABLE conteudos_chamado (
                                   id BIGINT NOT NULL AUTO_INCREMENT,
                                   texto LONGTEXT,
                                   chamado_id BIGINT NOT NULL,
                                   autor_id BIGINT,
                                   data_criacao DATETIME(6),
                                   caminho_arquivo VARCHAR(255),

                                   CONSTRAINT pk_conteudos_chamado PRIMARY KEY (id),
                                   CONSTRAINT fk_conteudos_chamado FOREIGN KEY (chamado_id) REFERENCES chamados(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;