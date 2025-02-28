ALTER TABLE tb_mensalidade DROP COLUMN valor;

CREATE TABLE tb_plano (
    id bigint not null auto_increment,
    plano varchar(100),
    valor float(53),
    primary key (id)
) engine=InnoDB;

ALTER TABLE tb_mensalidade ADD COLUMN plano_id bigint not null;

ALTER TABLE tb_mensalidade ADD CONSTRAINT FK_plano_mensalidade
        FOREIGN KEY (plano_id) REFERENCES tb_plano(id);