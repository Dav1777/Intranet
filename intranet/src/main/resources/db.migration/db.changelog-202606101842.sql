--liquibase formatted sql
--changeset vinicius:202606101842
--comment: informativos table create

CREATE TABLE informativos (
                              id BIGINT NOT NULL AUTO_INCREMENT,
                              titulo VARCHAR(100) NOT NULL,
                              conteudo LONGTEXT NOT NULL,
                              data_publicacao DATETIME(6) NOT NULL,
                              ativo TINYINT(1) NOT NULL DEFAULT 1,

                              CONSTRAINT pk_informativos PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;