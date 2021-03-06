create schema biografia;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on biografia.* to user@'localhost';

use biografia;

create table jog_jogador (
    jog_id bigint unsigned not null auto_increment,
    jog_nome varchar(100) not null,
    jog_idade int not null,
    jog_funcao varchar(50) not null,
    jog_nickname varchar(50) not null,
    primary key (jog_id),
    unique key uni_jogador_nickname (jog_nickname)
);

create table per_personagem (
    per_id bigint unsigned not null auto_increment,
    per_nome varchar(100) not null,
    per_data_nascimento datetime not null,
    per_nivel int not null,
    primary key (per_id),
    unique key uni_personagem_nome (per_nome)
);

create table hab_habilidade (
    hab_id bigint unsigned not null auto_increment,
    hab_nome varchar(100) not null,
    hab_descricao varchar(200),
    hab_elemento varchar(10) not null,
    primary key (hab_id),
    unique key uni_habilidade_nome (hab_nome)
);

create table jer_jogador_personagem (
    jog_id bigint unsigned not null,
    per_id bigint unsigned not null,
    primary key (jog_id, per_id),
    foreign key jer_jog_fk (jog_id)
        references jog_jogador (jog_id)
        on delete restrict on update cascade,
    foreign key jer_per_fk (per_id)
        references per_personagem (per_id)
        on delete restrict on update cascade
);

create table pha_personagem_habilidade (
    per_id bigint unsigned not null,
    hab_id bigint unsigned not null,
    primary key (per_id, hab_id),
    foreign key pha_per_fk (per_id)
        references per_personagem (per_id)
        on delete restrict on update cascade,
    foreign key pha_hab_fk (hab_id)
        references hab_habilidade (hab_id)
        on delete restrict on update cascade
);

create table bio_biografia (
    bio_id bigint unsigned not null auto_increment,
    bio_data datetime not null,
    bio_entrada varchar(300) not null,
    per_id bigint unsigned not null,
    primary key (bio_id),
    foreign key bio_per_fk (per_id)
        references per_personagem (per_id)
        on delete restrict on update cascade
);

create table usr_usuario (
    usr_id bigint unsigned not null auto_increment,
    usr_nome varchar(20) not null,
    usr_email varchar(100) not null,
    usr_senha varchar(100) not null,
    primary key (usr_id),
    unique key uni_usuario_nome (usr_nome),
    unique key uni_usuario_email (usr_email)
);

create table aut_autorizacao (
    aut_id bigint unsigned not null auto_increment,
    aut_nome varchar(20) not null,
    primary key (aut_id),
    unique key uni_aut_nome (aut_nome)
);

create table uau_usuario_autorizacao (
    usr_id bigint unsigned not null,
    aut_id bigint unsigned not null,
    primary key (usr_id, aut_id),
    foreign key uau_usr_fk (usr_id)
        references usr_usuario (usr_id)
        on delete restrict on update cascade,
    foreign key uau_aut_fk (aut_id)
        references aut_autorizacao (aut_id)
        on delete restrict on update cascade
);

insert into usr_usuario (usr_nome, usr_email, usr_senha)
    values ('admin', 'admin@email.com', '$2a$10$i3.Z8Yv1Fwl0I5SNjdCGkOTRGQjGvHjh/gMZhdc3e7LIovAklqM6C');
insert into aut_autorizacao (aut_nome)
    values ('ROLE_ADMIN');
insert into uau_usuario_autorizacao values (1, 1);