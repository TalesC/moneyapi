create table categoria (
	id BIGINT(20) primary key auto_increment,
	name VARCHAR(50) not null
) engine=InnoDB default charset=utf8;

insert into categoria (name) values ('Lazer');
insert into categoria (name) values ('Alimentação');
insert into categoria (name) values ('Supermercado');
insert into categoria (name) values ('Farmácia');
insert into categoria (name) values ('Outros');
