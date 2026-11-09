create table clientes (
 id_cliente Serial primary key,
 nome_cliente varchar(100)not null,
 telefone_cliente varchar(20)
);

create table produtos(
 id_produto Serial primary key,
 nome_produto varchar(100) not null,
 preco numeric(10,2) not null check(preco >=0),
 estoque int not null default 0 check (estoque>=0)
);

create table pedidos(
 id_pedido  Serial primary key,
 fk_id_cliente int not null REFERENCES clientes(id_cliente),
  data_pedido TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP
);

create table pedidos_produtos(
 id_pedido_produto  Serial primary key,
 fk_id_pedido int not null REFERENCES pedidos(id_pedido),
 fk_id_produto int not null REFERENCES produtos(id_produto),
 quantidade int not null check (quantidade>0),
 preco_unitario numeric(10,2) not null check (preco_unitario>=0)
);