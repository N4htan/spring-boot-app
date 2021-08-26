create schema spring;

use spring;


create user 'user'@'localhost' identified by 'sistem@';

grant select, insert, delete, update on spring.* to user@'localhost';


create table usr_usuario {
	user_id bigint unsigned not null auto_increment,
	user_nome varchar (20) not null,
	user_senha varchar (50) not null,
	primary key (userr_id),
	unique key uni_usuario_nome (user_nome)
	
};

create table aut_autorizacao (
  aut_id bigint unsigned not null auto_increment,
  aut_nome varchar(20) not null,
  primary key (aut_id),
  unique key uni_aut_nome (aut_nome)
);

create table uau_usuario_autorizacao (
  user_id bigint unsigned not null,
  aut_id bigint unsigned not null,
  primary key (user_id, aut_id),
  foreign key aut_usuario_fk (user_id) references usr_usuario (user_id) on delete restrict on update cascade,
  foreign key aut_autorizacao_fk (aut_id) references aut_autorizacao (aut_id) on delete restrict on update cascade
);