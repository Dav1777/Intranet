--liquibase formatted sql
--changeset vinicius:202606101833
--comment: chamados table create

CREATE TABLE chamados (
                          id BIGINT NOT NULL AUTO_INCREMENT,
                          setor_id BIGINT,
                          funcionario_id BIGINT,
                          titulo VARCHAR(255),
                          descricao TEXT,
                          status VARCHAR(255),
                          prioridade VARCHAR(255),
                          data_criacao DATETIME(6),

                          CONSTRAINT pk_chamados PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;