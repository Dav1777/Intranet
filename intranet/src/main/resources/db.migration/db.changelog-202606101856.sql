--liquibase formatted sql
--changeset vinicius:202606101856
--comment: insert initial sector and admin user

INSERT INTO setores (nome)
VALUES ('Administração');

INSERT INTO funcionario (nome, email, cpf, cargo, senha, setor_id)
VALUES (
           'Admin do Sistema',
           'admin@email.com',
           '00000000000',
           'ADMIN',
           '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.TVuHOn2',
           (SELECT id FROM setores WHERE nome = 'Administração' LIMIT 1)
    );