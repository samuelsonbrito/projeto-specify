create database if not exists softwareIC;

create table if not exists projeto(
	codigo int not null auto_increment primary key,
    diaHoraCriacao timestamp,
	nome varchar(1000) not null,
    dataInicio date not null,
    dataAproxTermino date not null, 
    descricao varchar(5000) not null,
    recursosFinanceiros double not null
);

create table if not exists requisito(
	codigo int not null auto_increment primary key,
    diaHoraCriacao timestamp,
	id varchar(1000) not null unique, 
    sujeito varchar(1000) not null,
    acaoRestricao varchar(5000) not null,
    valorRazao varchar(5000) not null,
    grauPrioridade enum('BAIXA','MEDIA','ALTA') default 'MEDIA' not null, 
    grauDificuldade enum('BAIXA','MEDIA','ALTA') default 'MEDIA' not null, 
    estimativa int,  -- pode ser nula
	tipoRequisito enum('FUNCIONAL', 'NAOFUNCIONAL', 'USUARIO', 'NEGOCIO') not null
);

create table if not exists interessado(
	codigo integer auto_increment not null primary key,
	nome varchar(100),
    sobrenome varchar(100),
    endereco varchar(300),
    rg varchar(14),
    cpf varchar(14),
    telefone varchar(15),
    email varchar(50)

);

alter table requisito add column pcodigo int not null;
alter table requisito add foreign key (pcodigo) references projeto(codigo)
			on delete cascade
            on update cascade;
