create database softwareIC;

create table projeto(
	codigo int not null auto_increment primary key,
    diaHoraCriacao timestamp,
	nome varchar(1000) not null,
    dataInicio date not null,
    dataAproxTermino date not null, 
    descricao varchar(5000) not null,
    recursosFinanceiros double not null
);

create table requisito(
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

alter table requisito add column projCodigo int not null;
alter table requisito add foreign key (projCodigo) references projeto(codigo)
			on delete restrict 
            on update cascade;
