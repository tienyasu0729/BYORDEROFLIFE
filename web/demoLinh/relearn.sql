create database relearn;
use relearn;

create table customers(
	id int not null primary key auto_increment,
    name text,
    age int
);

create table employees(
	id int not null primary key auto_increment,
    name text,
	age int,
	number int
);

select id, name, age from customers
union
select id, name, age from employees