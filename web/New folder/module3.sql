create database module;
use module;
-- alter table product change column category idcategory text;

create table category(
	idcategory int not null primary key auto_increment,
    namecategory text
);

CREATE TABLE product (
  id int primary key NOT NULL auto_increment,
  name TEXT,
  price INT,
  quantity INT,
  color TEXT,
  description TEXT,
  idcategory int,
	foreign key (idcategory) references category(idcategory)
	
);

