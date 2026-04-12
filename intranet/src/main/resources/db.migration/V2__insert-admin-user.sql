-- 1. Inserir o setor (O ID será gerado automaticamente como 1 se for o primeiro)
INSERT INTO setores (nome) VALUES ('Administração');

-- 2. Inserir o Admin (senha: admin123)
-- Importante: O setor_id aqui deve bater com o ID que o banco gerou acima (provavelmente 1)
INSERT INTO funcionarios (nome, email, cpf, cargo, senha, setor_id)
VALUES (
           'Admin do Sistema',
           'admin@email.com',
           '00000000000',
           'ADMIN',
           '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.TVuHOn2',
           (SELECT id FROM setores WHERE nome = 'Administração')
       );