ALTER TABLE tb_avaliacao
    ADD COLUMN status varchar(8) not null;

ALTER TABLE tb_avaliacao MODIFY data date NOT NULL;