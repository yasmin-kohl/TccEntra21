insert into endereco values (1, 'Victor Konder', '89012-180', 'Blumenau', 'SC', '123', 'Rua Timbó');
insert into endereco values (2, 'Velha Central', '89040-170', 'Blumenau', 'SC', '247', 'Rua Telma Maria Menestrina');
insert into endereco values (3, 'Salto do Norte', '89070-540', 'Blumenau', 'SC', '876', 'Rua Frei Henrique de Coimbra');

insert into usuario values (1, '761.964.120-35','Victor@gmail.com','Victor', 'Victor123', 3);
insert into usuario values (2, '482.372.070-92','Guilherme@gmail.com','Guilherme', '12345678', 1);
insert into usuario values (3, '119.735.000-43','João@gmail.com','João', 'João123', 2);

insert into categoria_prod values(1,'Jogos','Tabuleiro');
insert into categoria_prod values(2,'Comidas','Pizza');
insert into categoria_prod values(3,'Esporte','bola');

insert into produto values(1, 'Para pensar', 'tabuleiro de Xadrez', 50.1, 40, 'www.btt.com.br', 1, 1);
insert into produto values(2, 'Assistir filme', 'TV', 788.6, 70, 'www.tvv.com.br', 2, 3);
insert into produto values(3, 'jogar futebol', 'Bola', 68.4, 12, 'www.haa.com.br', 3, 2);



insert into pedido values(1,'cupom fiscal',1);
insert into pedido values (2,'Bola',2);
insert into pedido values(3,'feijão',3);

insert into produto_carrinho values(1,5,1,1);
insert into produto_carrinho values(2,6,2,2);
insert into produto_carrinho values(3,7,3,3);
