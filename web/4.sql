create database module3;
use module3;

create table type(
	id_type int primary key,
    name_type text
);

create table phongtro(
	id_tro int primary key auto_increment,
    name text,
    phone_number text,
    start_date date,
    id_type int,
	foreign key (id_type) references type(id_type),
    note text
);

SELECT phongtro.id_tro,phongtro.name,phongtro.phone_number,phongtro.start_date, type.name_type FROM phongtro JOIN type ON phongtro.id_type = type.id_type ORDER BY phongtro.id_type desc;

INSERT INTO `module3`.`type` (`id_type`, `name_type`) VALUES ('1', 'theo tháng');
INSERT INTO `module3`.`type` (`id_type`, `name_type`) VALUES ('2', 'theo quý');
INSERT INTO `module3`.`type` (`id_type`, `name_type`) VALUES ('3', 'theo năm');

INSERT INTO `module3`.`phongtro` (`id_tro`, `name`, `phone_number`, `start_date`, `id_type`) VALUES ('1', 'a', '0983546773', '2023-05-24', '1');
INSERT INTO `module3`.`phongtro` (`id_tro`, `name`, `phone_number`, `start_date`, `id_type`) VALUES ('2', 'b', '0983546773', '2023-05-24', '2');
INSERT INTO `module3`.`phongtro` (`id_tro`, `name`, `phone_number`, `start_date`, `id_type`) VALUES ('3', 'c', '0983546773', '2023-05-24', '2');
INSERT INTO `module3`.`phongtro` (`id_tro`, `name`, `phone_number`, `start_date`, `id_type`) VALUES ('4', 'd', '0983546773', '2023-05-24', '1');
UPDATE `module3`.`phongtro` SET `note` = '123' WHERE (`id_tro` = '1');
UPDATE `module3`.`phongtro` SET `note` = '123' WHERE (`id_tro` = '2');
UPDATE `module3`.`phongtro` SET `note` = '123' WHERE (`id_tro` = '3');
UPDATE `module3`.`phongtro` SET `note` = '123' WHERE (`id_tro` = '4');

