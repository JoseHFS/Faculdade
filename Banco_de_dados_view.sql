-- Criando tabela de autores
CREATE TABLE autor (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

-- Criando tabela de livros
CREATE TABLE livro (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    id_autor INT NOT NULL REFERENCES autor(id),
    ano_publicacao INT
);

-- Criando tabela de usuários
CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

-- Criando tabela de empréstimos
CREATE TABLE emprestimo (
    id SERIAL PRIMARY KEY,
    id_usuario INT NOT NULL REFERENCES usuario(id),
    id_livro INT NOT NULL REFERENCES livro(id),
    data_emprestimo DATE NOT NULL,
    data_devolucao DATE
);

-- Inserindo autores
INSERT INTO autor (nome) VALUES
('Machado de Assis'),
('J. K. Rowling'),
('George Orwell'),
('Clarice Lispector');

-- Inserindo livros
INSERT INTO livro (titulo, id_autor, ano_publicacao) VALUES
('Dom Casmurro', 1, 1899),
('Harry Potter e a Pedra Filosofal', 2, 1997),
('1984', 3, 1949),
('A Hora da Estrela', 4, 1977),
('Harry Potter e a Câmara Secreta', 2, 1998);

-- Inserindo usuários
INSERT INTO usuario (nome) VALUES
('Ana'),
('Bruno'),
('Carla'),
('Diego');

-- Inserindo empréstimos
INSERT INTO emprestimo (id_usuario, id_livro, data_emprestimo, data_devolucao) VALUES
(1, 1, '2025-08-01', '2025-08-10'),
(2, 2, '2025-08-02', NULL),
(3, 3, '2025-08-05', '2025-08-15'),
(1, 5, '2025-08-07', NULL),
(4, 4, '2025-08-08', NULL);


--SIMPLES
create view livros_com_autores as
select livro.titulo,autor.nome from livro join autor on livro.id_autor=autor.id;

select*from livros_com_autores;

create view usuarios_com_emprestimos as
select usuario.nome,livro.titulo from emprestimo join usuario on usuario.id=emprestimo.id_usuario join livro on
livro.id=emprestimo.id_livro;

select*from usuarios_com_emprestimos;

create view emprestimos_em_aberto as
select usuario.nome,livro.titulo from emprestimo join usuario on 
usuario.id=emprestimo.id_usuario join livro on livro.id=emprestimo.id_livro where 
emprestimo.data_devolucao is NULL;

select*from emprestimos_em_aberto;


--MÉDIO
create view historico_emprestimos as
select usuario.nome as nome,livro.titulo as livros,autor.nome as nome_autor,emprestimo.data_emprestimo 
as data_de_emprestimo
from emprestimo join usuario on 
usuario.id=emprestimo.id_usuario join livro on livro.id=emprestimo.id_livro join autor on 
autor.id=livro.id_autor;

select*from historico_emprestimos;

create view qtd_emprestimos_por_usuario as
select usuario.nome,count(emprestimo.id) as quantidades_emprestadas 
from usuario join emprestimo on usuario.id=emprestimo.id_usuario group by usuario.nome;

select*from qtd_emprestimos_por_usuario;

create view livros_mais_recentes as
select autor.nome,livro.titulo,livro.ano_publicacao from autor join livro on autor.id=livro.id_autor 
where livro.ano_publicacao>1950;

select*from livros_mais_recentes;

create view usuarios_com_mais_de_um_emprestimo as
select usuario.nome,count(emprestimo.id) as quantidades_emprestadas 
from usuario join emprestimo on usuario.id=emprestimo.id_usuario group by usuario.nome having 
count(emprestimo.id)>1;

select*from usuarios_com_mais_de_um_emprestimo;

--PROCEDURES
create procedure cadastrar_usuario(p_nome varchar(100))
language plpgsql
as $$
begin
insert into usuario (nome) values (p_nome);
end;
$$;

call cadastrar_usuario('Marcos');

select*from usuario;



create procedure cadastrar_livro(p_titulo varchar(150),p_ano_publicacao int,p_id_autor int,p_nome_autor varchar(100))
language plpgsql
as $$
begin
 insert into autor (id,nome) values (p_id_autor,p_nome_autor);
 insert into livro (titulo,id_autor,ano_publicacao) values (p_titulo,p_id_autor,p_ano_publicacao);
 
end;
$$;

call cadastrar_livro('Diário de um banana',2004,5,'Jeff kindrey');

select*from livro;


create procedure registrar_devolucao(p_id_emprestimo int,p_data_devolucao date)
language plpgsql
as $$
begin
 update emprestimo set data_devolucao = p_data_devolucao where id=p_id_emprestimo;
end;
$$;

call registrar_devolucao(4,'2025-08-27');

select*from emprestimo;




create procedure excluir_usuario(p_id_usuario int)
language plpgsql
as $$
begin
 delete from emprestimo where id_usuario=p_id_usuario;
 delete from usuario where id=p_id_usuario;
end;
$$;

call excluir_usuario(1);

select*from usuario;