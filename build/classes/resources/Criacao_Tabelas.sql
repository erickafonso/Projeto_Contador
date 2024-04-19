create database contador;
use contador;

create table conta (
idConta int  primary key unique not null,
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

create table Conta_Categoria (
Categoria int not null,
Conta int not null,
primary key (Categoria, Conta),
foreign key (Categoria) references categoria(idCategoria),
foreign key (Conta) references conta(idConta)
);

create table Despesa_FormaPagamento (
FormaPagamento int not null,
Despesa int not null,
primary key (FormaPagamento, Despesa),
foreign key (FormaPagamento) references formaPagamento(idFormaPagamento),
foreign key (Despesa) references despesa(idDespesa)
);

create table Despesa_Categoria (
Categoria int not null,
Despesa int not null,
primary key (Categoria, Despesa),
foreign key (Categoria) references categoria(idCategoria),
foreign key (Despesa) references despesa(idDespesa)
);

create table despesa (
idDespesa int  primary key unique not null,
nome varChar(18)  not null,
valor double not null,
descricao varChar(18),
dataPagamento Date not null
);

create table categoria (
idCategoria int  primary key unique not null,
nome varChar(20)  not null

);

create table formaPagamento (
idFormaPagamento int  primary key unique not null,
nome varChar(20)  not null

);

create table usuario (
idUsuario int  primary key unique not null,
nome varChar(18)  not null,
login varChar(18)  not null,
email varChar(30)  not null,
senha varBinary(18)  not null
);