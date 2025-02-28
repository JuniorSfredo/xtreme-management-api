SET foreign_key_checks = 0;

DELETE FROM tb_treino_exercicio;
DELETE FROM tb_mensalidade;
DELETE FROM tb_dobra_cutanea;
DELETE FROM tb_avaliacao;
DELETE FROM tb_exercicio;
DELETE FROM tb_treino;
DELETE FROM tb_professor;
DELETE FROM tb_aluno;
DELETE FROM tb_plano;

SET foreign_key_checks = 1;

ALTER TABLE tb_aluno AUTO_INCREMENT = 1;
ALTER TABLE tb_avaliacao AUTO_INCREMENT = 1;
ALTER TABLE tb_dobra_cutanea AUTO_INCREMENT = 1;
ALTER TABLE tb_exercicio AUTO_INCREMENT = 1;
ALTER TABLE tb_plano AUTO_INCREMENT = 1;
ALTER TABLE tb_mensalidade AUTO_INCREMENT = 1;
ALTER TABLE tb_professor AUTO_INCREMENT = 1;
ALTER TABLE tb_treino AUTO_INCREMENT = 1;
ALTER TABLE tb_treino_exercicio AUTO_INCREMENT = 1;

INSERT INTO tb_exercicio (id, name, qtd_series, min_repeticoes, max_repeticoes) VALUES (1, 'Puxada Alta', 4, 8, 12);
INSERT INTO tb_exercicio (id, name, qtd_series, min_repeticoes, max_repeticoes) VALUES (2, 'Pulldown', 4, 8, 12);
INSERT INTO tb_exercicio (id, name, qtd_series, min_repeticoes, max_repeticoes) VALUES (3, 'Remada Baixa', 4, 8, 12);


INSERT INTO tb_exercicio (id, name, qtd_series, min_repeticoes, max_repeticoes) VALUES (4, 'Supino Reto', 4, 8, 12);
INSERT INTO tb_exercicio (id, name, qtd_series, min_repeticoes, max_repeticoes) VALUES (5, 'Supino Inclinado', 4, 8, 12);
INSERT INTO tb_exercicio (id, name, qtd_series, min_repeticoes, max_repeticoes) VALUES (6, 'Crucifixo', 4, 8, 12);

INSERT INTO tb_exercicio (id, name, qtd_series, min_repeticoes, max_repeticoes) VALUES (7, 'Crucifixo Invertido', 4, 8, 12);
INSERT INTO tb_exercicio (id, name, qtd_series, min_repeticoes, max_repeticoes) VALUES (8, 'Puxada Baixa', 4, 8, 12);
INSERT INTO tb_exercicio (id, name, qtd_series, min_repeticoes, max_repeticoes) VALUES (9, 'Remada Cavalinho', 4, 8, 12);

INSERT INTO tb_exercicio (id, name, qtd_series, min_repeticoes, max_repeticoes) VALUES (10, 'Crucifixo Invertido', 4, 8, 12);
INSERT INTO tb_exercicio (id, name, qtd_series, min_repeticoes, max_repeticoes) VALUES (11, 'Puxada Baixa', 4, 8, 12);
INSERT INTO tb_exercicio (id, name, qtd_series, min_repeticoes, max_repeticoes) VALUES (12, 'Remada Cavalinho', 4, 8, 12);
INSERT INTO tb_exercicio (id, name, qtd_series, min_repeticoes, max_repeticoes) VALUES (13, 'Crucifixo Invertido', 4, 8, 12);
INSERT INTO tb_exercicio (id, name, qtd_series, min_repeticoes, max_repeticoes) VALUES (14, 'Puxada Baixa', 4, 8, 12);
INSERT INTO tb_exercicio (id, name, qtd_series, min_repeticoes, max_repeticoes) VALUES (15, 'Remada Cavalinho', 4, 8, 12);

INSERT INTO tb_aluno (id, nome, peso, altura, cpf, ativo, data_cadastro, data_nascimento, endereco)
    VALUES
        (1, 'Junior', 90, 1.83, '123456', true, CURRENT_DATE, '2003-12-08', 'São Paulo'),
        (2, 'Maria', 68, 1.65, '234567', true, CURRENT_DATE, '1995-07-15', 'Rio de Janeiro'),
        (3, 'Carlos', 82, 1.75, '345678', false, CURRENT_DATE, '1988-03-22', 'Belo Horizonte');

INSERT INTO tb_professor (id, nome, peso, altura, cpf, data_contratacao, data_nascimento, salario, endereco)
    VALUES
        (1, 'Marcos Oliveira', 78.5, 1.75, 123456789, '2019-03-10', '1980-01-15', 4500.00, 'Avenida Paulista, São Paulo'),
        (2, 'Claudia Mendes', 62.3, 1.65, 234567890, '2021-06-15', '1992-05-20', 3900.00, 'Rua das Flores, Rio de Janeiro'),
        (3, 'Roberto Silva', 85.0, 1.82, 345678901, '2020-09-05', '1985-10-30', 5000.00, 'Praça da Sé, São Paulo');

INSERT INTO tb_treino (id, nome, professor_id, aluno_id)
    VALUES
        (1, 'COSTAS', 1, 1),
        (2, 'PEITO', 1, 1);


INSERT INTO tb_treino_exercicio (exercicio_id, treino_id)
    VALUES
        (1, 1), (2, 1), (3, 1), (7, 1), (8, 1), (9, 1), (10, 1), (11, 1), (12, 1), (13, 1),(4, 2), (5, 2), (6, 2);

INSERT INTO tb_avaliacao (id, percentual_de_gordura, imc, aluno_id, professor_id, observacao, data, peso)
    VALUES
        (1, 25.6, 25, 1, 1, 'Obs teste', '2024-12-05', 82.8);

INSERT INTO tb_dobra_cutanea (id, dobra, mm, avaliacao_id)
    VALUES
        (1, 'COSTAS', 12, 1),
        (2, 'PEITO', 9, 1),
        (3, 'ABDOMEN', 16, 1),
        (4, 'BICEPS', 5, 1),
        (5, 'TRICEPS', 11, 1),
        (6, 'AXILAR', 8, 1),
        (7, 'QUADRICEPS', 10, 1);

INSERT INTO tb_avaliacao (id, percentual_de_gordura, imc, aluno_id, professor_id, observacao, data, peso)
VALUES
    (2, 22.3, 25, 1, 2, 'Obs teste', '2024-10-05', 85.3);

INSERT INTO tb_dobra_cutanea (id, dobra, mm, avaliacao_id)
VALUES
    (8, 'ABDOMEN', 20, 2);

INSERT INTO tb_plano (id, plano, valor)
VALUES
    (1, 'MENSAL', 200.0);

INSERT INTO tb_mensalidade (id, data_vencimento, status_pagamento, plano_id, aluno_id)
VALUES
    (1, '2025-03-20', 'PAGO', 1, 1);

INSERT INTO tb_mensalidade (id, data_vencimento, status_pagamento, plano_id, aluno_id)
VALUES
    (2, '2025-04-20', 'AGUARDANDO_PAGAMENTO', 1, 1);