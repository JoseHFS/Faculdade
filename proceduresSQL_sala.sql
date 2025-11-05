create table usuario(
id_usuario serial,
nome varchar(100),
pais varchar(50),
data_cadastro date,
plano varchar(20)
) partition by list(pais);

create table usuarios_br partition of usuario for values in ('BR');
create table usuarios_uk partition of usuario for values in ('UK');

create table reproducao(
id_reproducao SERIAL,
id_usuario INT,
data_reproducao DATE,
duracao_segundos INT,
categoria VARCHAR(50)
) partition by list(categoria);

create table reproducao_filme partition of reproducao for values in ('Filme');
create table reproducao_doc partition of reproducao for values in ('Documentario');

insert into usuario (nome,pais,data_cadastro,plano) values ('Ana','BR','2023-04-23','Free'),
('Mark','UK','2024-03-15','Premium');

insert into reproducao (id_usuario,data_reproducao,duracao_segundos,categoria) values (1,'2024-05-13',23456,'Filme')
,(2,'2025-09-10',50000,'Documentario');

select tableoid::regclass as particao,* from usuario;
select tableoid::regclass as particao,* from reproducao;

