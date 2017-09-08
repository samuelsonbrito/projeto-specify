create database if not exists softwareIC;

create table if not exists projeto(
	codigo int not null auto_increment primary key,
    diaHoraCriacao timestamp,
    ultimaAtualizacao timestamp default null on update current_timestamp,
	nome varchar(1000) not null unique,
    dataInicio date not null,
    dataAproxTermino date not null, 
    descricao varchar(5000) not null,
    recursosFinanceiros double not null,

);

create table if not exists requisito(
	codigo int not null auto_increment primary key,
    diaHoraCriacao timestamp,
	ultimaAtualizacao timestamp null on update current_timestamp,
	id varchar(1000) not null unique, 
    sujeito varchar(1000) not null,
    acaoRestricao varchar(5000) not null,
    valorRazao varchar(5000) not null,
    grauPrioridade enum('BAIXA','MEDIA','ALTA') default 'MEDIA' not null, 
    grauDificuldade enum('BAIXA','MEDIA','ALTA') default 'MEDIA' not null, 
    estimativa int,  -- pode ser nula
	tipoRequisito enum('FUNCIONAL', 'NAOFUNCIONAL', 'USUARIO', 'NEGOCIO') not null
);

alter table requisito add column pcodigo int not null;
alter table requisito add foreign key (pcodigo) references projeto(codigo)
			on delete no action
            on update cascade;

create table if not exists interessado(
	codigo integer auto_increment not null primary key,
	nome varchar(100) not null,
    sobrenome varchar(100) not null,
    endereco varchar(300) not null,
    rg varchar(14) not null,
    cpf varchar(14) not null,
    telefone varchar(15) not null,
    email varchar(50) not null
	
);

create table if not exists interessadoProjeto(
	dataEntrada timestamp default current_timestamp,
	dataSaida timestamp null on update current_timestamp,
    papelDesempenhado varchar(1000) not null,
	
    projCodigo INTEGER NOT NULL references projeto(codigo) ON DELETE no action ON UPDATE cascade,
    intersCodigo INTEGER NOT NULL references interessado(codigo) ON DELETE no action ON UPDATE cascade,
    
    PRIMARY KEY(projCodigo, intersCodigo)
);

