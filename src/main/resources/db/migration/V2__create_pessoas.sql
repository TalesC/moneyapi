create table pessoa (
	id BIGINT(20) primary key auto_increment,
	name varchar(30) not null,
	ativo boolean default false,
	logradouro varchar(50),
	numerolog int,
	complemento varchar(30),
	bairro varchar(30),
	cep varchar(10),
	cidade varchar(30),
	estado char(2)
) engine=InnoDB default charset=utf8;

insert into pessoa (name, ativo) values ('Mario', false);
insert into pessoa (name, ativo) values ('Maria', true);
insert into pessoa (name, ativo, logradouro, numerolog, complemento, bairro, cep, cidade, estado)
	values ('Maria', false, 'Rua teste', 1, 'apt12', 'Vila Teste', '00000-000', 'São Paulo', 'SP');
	insert into pessoa (name, ativo, logradouro, numerolog, complemento, bairro, cep, cidade, estado)
	values ('Elio Rdrigues', true, 'Rua teste', 1, 'apt11', 'Vila Teste', '00000-000', 'Marilia', 'SP');

