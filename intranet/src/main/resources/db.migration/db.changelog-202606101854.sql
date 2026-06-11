--liquibase formatted sql
--changeset vinicius:202606101854
--comment: constraints and foreign keys
ALTER TABLE funcionario
    ADD CONSTRAINT uc_funcionario_cpf UNIQUE (cpf);

ALTER TABLE chamados
    ADD CONSTRAINT FK_CHAMADOS_ON_SETOR FOREIGN KEY (setor_id) REFERENCES setores (id);

ALTER TABLE conteudos_chamado
    ADD CONSTRAINT FK_CONTEUDOS_CHAMADO_ON_CHAMADO FOREIGN KEY (chamado_id) REFERENCES chamados (id);

ALTER TABLE funcionario
    ADD CONSTRAINT FK_FUNCIONARIO_ON_SETOR FOREIGN KEY (setor_id) REFERENCES setores (id);

ALTER TABLE chamados
    ADD CONSTRAINT FK_CHAMADOS_ON_FUNCIONARIO FOREIGN KEY (funcionario_id) REFERENCES funcionario (id);