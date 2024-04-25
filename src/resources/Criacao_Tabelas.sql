create database contador;
use contador;

create table conta (
idConta int  primary key unique auto_increment not null,
nome varChar(18)  not null,
valor double not null,
descricao varChar(18),
dataPagamento Date,
dataVencimento Date not null
);

create table Conta_FormaPagamento (
FormaPagamento int not null,
Conta int not null,
primary key (FormaPagamento, Conta),
foreign key (FormaPagamento) references formaPagamento(idFormaPagamento),
foreign key (Conta) references conta(idConta)
);
drop table Conta_FormaPagamento;
create table Conta_Categoria (
Categoria int not null,
Conta int not null,
primary key (Categoria, Conta),
foreign key (Categoria) references categoria(idCategoria),
foreign key (Conta) references conta(idConta)
);
drop table Conta_Categoria;

create table Despesa_FormaPagamento (
FormaPagamento int not null,
Despesa int not null,
primary key (FormaPagamento, Despesa),
foreign key (FormaPagamento) references formaPagamento(idFormaPagamento),
foreign key (Despesa) references despesa(idDespesa)
);
drop table Despesa_FormaPagamento;
drop table Despesa_Categoria;

create table Despesa_Categoria (
Categoria int not null,
Despesa int not null,
primary key (Categoria, Despesa),
foreign key (Categoria) references categoria(idCategoria),
foreign key (Despesa) references despesa(idDespesa)
);

create table despesa (
idDespesa int  primary key unique auto_increment not null,
nome varChar(18)  not null,
valor double not null,
descricao varChar(18),
dataPagamento Date not null
);

create table categoria (
idCategoria int  primary key unique auto_increment not null,
nome varChar(20)  not null unique

);
drop table usuario;
drop table conta;
drop table despesa;
drop table categoria;
drop table formapagamento;

create table formaPagamento (
idFormaPagamento int  primary key unique auto_increment not null,
nome varChar(20)  not null unique

);

create table usuario (
idUsuario int  primary key unique auto_increment not null,
nome varChar(18)  not null,
login varChar(18)  not null,
email varChar(30)  not null,
senha varBinary(18)  not null
);

select * from formapagamento;