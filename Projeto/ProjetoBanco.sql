drop database sugestao;
create database Sugestao;

use sugestao;

create table colaborador(
ra 				int 			not null,
nome			varchar(45)		not null,
sobrenome 		varchar(45)		not null,
dataNascimento	date			not null,
telefone		char(11)		not null,
sexo			char(1)			not null,		
usuario			varchar(45)		not null,
senha			varchar(45)		not null,

primary key (ra)
);


create table avaliador(
id				int 			not null,
nome			varchar(45)		not null,
sobrenome 		varchar(45)		not null,
dataNascimento	date			not null,
telefone		char(11)		not null,
sexo			char(1)			not null,		
usuario			varchar(45)		not null,
senha			varchar(45)		not null,

primary key (id)
);


create table superior(
id				int 			not null,
nome			varchar(45)		not null,
sobrenome 		varchar(45)		not null,
dataNascimento	date			not null,
telefone		char(11)		not null,
sexo			char(1)			not null,		
usuario			varchar(45)		not null,
senha			varchar(45)		not null,

primary key (id)
);


