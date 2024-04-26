create database module3;
use module3;
-- alter table product change column category idcategory text;

CREATE TABLE product (
--   stt INT NOT NULL AUTO_INCREMENT,
  id VARCHAR(50) NOT NULL,
  name TEXT,
  price INT,
  quantity INT,
  color TEXT,
  description TEXT,
  idcategory TEXT,
  PRIMARY KEY (id)
--   UNIQUE (stt)
);

create table category(
	idcategory varchar(50) not null primary key,
    namecategory text
);