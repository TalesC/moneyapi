create table lancamento (
	id BIGINT(20) primary key auto_increment,
	descricao varchar(50) not null,
	data_vencimento date not null,
	data_pagamento date,
	valor DECIMAL(10,2) not null,
	observacao varchar(100),
	tipo varchar(20) not null,
	id_categoria BIGINT(20) not null,
	id_pessoa BIGINT(20) not null,
	foreign key (id_categoria) references categoria(id),
	foreign key (id_pessoa) references pessoa(id)
) ENGINE=InnoDB default CHARSET=utf8;

insert into lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, id_categoria, id_pessoa) values('Salário mensal', '2019-06-10', null, 6500.00, 'Distribuição de lucros', 'RECEITA', 1, 1); 
insert into lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, id_categoria, id_pessoa) values('Bahamas', '2019-02-10', '2019-02-10', 100.32, null, 'DESPESA', 2, 2);
insert into lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, id_categoria, id_pessoa) values('Top Club', '2019-06-10', null, 120, null, 'RECEITA', 3, 3);
insert into lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, id_categoria, id_pessoa) values('CMIG', '2019-02-10', '2019-02-10', 110.44, 'Geração', 'RECEITA', 3, 4);
insert into lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, id_categoria, id_pessoa) values('DMAE', '2019-06-10', null, 200.30, null, 'DESPESA', 3, 5);
insert into lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, id_categoria, id_pessoa) values('Extra', '2019-03-10', '2019-03-10', 110.44, 'Geração', 'RECEITA', 4, 5);
insert into lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, id_categoria, id_pessoa) values('Bahamas', '2019-06-10', null, 500, null, 'RECEITA', 1, 5);
insert into lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, id_categoria, id_pessoa) values('Top Club', '2019-03-10', '2019-03-10', 400.32, null, 'DESPESA', 4, 5);
insert into lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, id_categoria, id_pessoa) values('Despachante', '2019-06-10', null, 123.64, 'Multas', 'DESPESA', 3, 5);
insert into lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, id_categoria, id_pessoa) values('Pneus', '2019-04-10', '2019-04-10', 665.33, null, 'RECEITA', 5, 5);
insert into lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, id_categoria, id_pessoa) values('Café', '2019-06-10', null, 8.32, null, 'DESPESA', 1, 5);
insert into lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, id_categoria, id_pessoa) values('Eletrônicos', '2019-04-10', '2019-04-10', 2100.32, null, 'DESPESA', 5, 4);
insert into lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, id_categoria, id_pessoa) values('Instrumentos', '2019-06-10', null, 1040.32, null, 'DESPESA', 4, 3);
insert into lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, id_categoria, id_pessoa) values('Café', '2019-04-10', '2019-04-10', 4.32, null, 'DESPESA', 4, 2);
insert into lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, id_categoria, id_pessoa) values('Lanche', '2019-06-10', null, 10.20, null, 'DESPESA', 4, 1);