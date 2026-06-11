--liquibase formatted sql
--changeset vinicius:202606101846
--comment: setores table create

CREATE TABLE setores (
                         id BIGINT NOT NULL AUTO_INCREMENT,
                         nome VARCHAR(255),

                         CONSTRAINT pk_setores PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;