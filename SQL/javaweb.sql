create database testjdbc;
use testjdbc;

create table test(
	id varchar(50) not null primary key,
    name text,
    price int,
    describeproduct text,
    producer text
);

INSERT INTO `testjdbc`.`test` (`id`, `name`, `price`, `describeproduct`, `producer`) VALUES ('dv001', 'tien1', '1000', 'a1', 'tienthanh1');
INSERT INTO `testjdbc`.`test` (`id`, `name`, `price`, `describeproduct`, `producer`) VALUES ('dv002', 'tien2', '2000', 'a2', 'tienthanh2');
INSERT INTO `testjdbc`.`test` (`id`, `name`, `price`, `describeproduct`, `producer`) VALUES ('dv003', 'tien3', '3000', 'a3', 'tienthanh3');
INSERT INTO `testjdbc`.`test` (`id`, `name`, `price`, `describeproduct`, `producer`) VALUES ('dv004', 'tien4', '4000', 'a4', 'tienthanh4');
INSERT INTO `testjdbc`.`test` (`id`, `name`, `price`, `describeproduct`, `producer`) VALUES ('dv005', 'tien5', '5000', 'a5', 'tienthanh5');
