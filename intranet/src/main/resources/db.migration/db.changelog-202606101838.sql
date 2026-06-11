--liquibase formatted sql
--changeset vinicius:202606101838
--comment: funcionario table create

CREATE TABLE funcionario (
                             id BIGINT NOT NULL AUTO_INCREMENT,
                             nome VARCHAR(255),
                             email VARCHAR(255),
                             cpf VARCHAR(11),
                             cargo VARCHAR(255),
                             setor_id BIGINT,
                             senha VARCHAR(255),
                             telefone VARCHAR(20),
                             logradouro VARCHAR(255),
                             numero INT,
                             complemento VARCHAR(255),
                             bairro VARCHAR(255),
                             cidade VARCHAR(255),
                             estado VARCHAR(2),
                             cep VARCHAR(8),

                             CONSTRAINT pk_funcionario PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;