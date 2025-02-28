create table tb_aluno
(
    endereco        varchar(255) not null,
    data_nascimento date         not null,
    peso            float(53)    not null,
    altura          float(53)    not null,
    cpf             varchar(11)  not null,
    nome            varchar(200) not null,
    ativo           bit          not null,
    data_cadastro   timestamp default current_timestamp,
    id              bigint       not null auto_increment,
    primary key (id)
) engine=InnoDB;

create table tb_avaliacao
(
    imc                   float(53),
    percentual_de_gordura float(53),
    aluno_id              bigint,
    id                    bigint not null auto_increment,
    professor_id          bigint,
    data                  date,
    observacao            varchar(255),
    primary key (id)
) engine=InnoDB;

create table tb_dobra_cutanea
(
    mm           float(53),
    avaliacao_id bigint,
    id           bigint not null auto_increment,
    dobra        varchar(255),
    primary key (id)
) engine=InnoDB;

create table tb_exercicio
(
    id             bigint not null auto_increment,
    name           varchar(255),
    qtd_series     int,
    min_repeticoes int,
    max_repeticoes int,
    primary key (id)
) engine=InnoDB;

create table tb_mensalidade
(
    data_vencimento date,
    valor           float(53),
    aluno_id        bigint,
    id              bigint not null auto_increment,
    primary key (id)
) engine=InnoDB;

create table tb_professor
(
    endereco         varchar(255) not null,
    data_nascimento  date         not null,
    peso             float(53)    not null,
    altura           float(53)    not null,
    cpf              varchar(11)  not null,
    nome             varchar(200) not null,
    data_contratacao date,
    salario          float(53),
    id               bigint       not null auto_increment,
    primary key (id)
) engine=InnoDB;

create table tb_treino
(
    aluno_id     bigint,
    id           bigint not null auto_increment,
    professor_id bigint,
    nome         varchar(255),
    primary key (id)
) engine=InnoDB;

create table tb_treino_exercicio
(
    exercicio_id bigint not null,
    treino_id    bigint not null
) engine=InnoDB;

alter table tb_avaliacao
    add constraint FKodcn55938dhrhkud4vt0cb21r foreign key (aluno_id) references tb_aluno (id);
alter table tb_avaliacao
    add constraint FKamnd4hqx5cae2e20xk17w2fh6 foreign key (professor_id) references tb_professor (id);
alter table tb_dobra_cutanea
    add constraint FKf6mtk8wag5awwh5irwtov5fw6 foreign key (avaliacao_id) references tb_avaliacao (id);
alter table tb_mensalidade
    add constraint FKskn319v4db9h5rocqrccti8in foreign key (aluno_id) references tb_aluno (id);
alter table tb_treino
    add constraint FKfywas00mgcg2ldaarbyg9fjd2 foreign key (aluno_id) references tb_aluno (id);
alter table tb_treino
    add constraint FKjys54x7nd9yignd0x8wk45qjr foreign key (professor_id) references tb_professor (id);
alter table tb_treino_exercicio
    add constraint FKk9boig5nd3iug4qed3kqdeb00 foreign key (exercicio_id) references tb_exercicio (id);
alter table tb_treino_exercicio
    add constraint FKfqw4g1347twekai4j793qrje1 foreign key (treino_id) references tb_treino (id);