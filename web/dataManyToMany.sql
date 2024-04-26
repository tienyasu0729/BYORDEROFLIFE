create database many_to_many;
use many_to_many;

CREATE TABLE `many_to_many`.`user` (
  `idUser` INT NOT NULL,
  `fullName` TEXT,
  `code` TEXT,
  `birthdate` DATE,
  `timeBuild` datetime,
  PRIMARY KEY (`idUser`));

CREATE TABLE `many_to_many`.`role` (
  `idRole` INT NOT NULL,
  `role` TEXT,
  PRIMARY KEY (`idRole`));

create table midd(
	idUser int,
    idRole int,
	foreign key (idUser) references user(idUser),
	foreign key (idRole) references role(idRole),
    primary key (idUser, idRole)
);
-- data many to many
INSERT INTO `many_to_many`.`user` (`idUser`, `fullName`, `code`, `birthdate`, `timeBuild`) VALUES ('1', 'a', 'u-1123', '2023-05-26', '2023-05-26');
INSERT INTO `many_to_many`.`user` (`idUser`, `fullName`, `code`, `birthdate`, `timeBuild`) VALUES ('2', 'b', '1124', '2023-05-26', '2023-05-26');
INSERT INTO `many_to_many`.`user` (`idUser`, `fullName`, `code`, `birthdate`, `timeBuild`) VALUES ('3', 'c', '1125', '2023-05-26', '2023-05-26');
INSERT INTO `many_to_many`.`user` (`idUser`, `fullName`, `code`, `birthdate`, `timeBuild`) VALUES ('4', 'd', '1126', '2023-05-26', '2023-05-26');

INSERT INTO `many_to_many`.`role` (`idRole`, `role`) VALUES ('1', 'user');
INSERT INTO `many_to_many`.`role` (`idRole`, `role`) VALUES ('2', 'admin');

INSERT INTO `many_to_many`.`midd` (`idUser`, `idRole`) VALUES ('1', '1');
INSERT INTO `many_to_many`.`midd` (`idUser`, `idRole`) VALUES ('2', '1');
INSERT INTO `many_to_many`.`midd` (`idUser`, `idRole`) VALUES ('3', '1');
INSERT INTO `many_to_many`.`midd` (`idUser`, `idRole`) VALUES ('4', '1');
INSERT INTO `many_to_many`.`midd` (`idUser`, `idRole`) VALUES ('1', '2');
INSERT INTO `many_to_many`.`midd` (`idUser`, `idRole`) VALUES ('2', '2');
INSERT INTO `many_to_many`.`midd` (`idUser`, `idRole`) VALUES ('3', '2');
INSERT INTO `many_to_many`.`midd` (`idUser`, `idRole`) VALUES ('4', '2');


-- DELETE FROM user
-- WHERE idUser = 1;

-- DELETE user, midd
-- FROM user
-- JOIN midd ON user.idUser = midd.idUser
-- WHERE user.idUser = 1;