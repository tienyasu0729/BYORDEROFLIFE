create database ss12;
use ss12;

create table testJDBC(
	id char(50) not null primary key,
    name text,
    price int,
    describe_product text,
    producer text
)