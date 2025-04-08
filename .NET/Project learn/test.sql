create database Employee;
use Employee;

create table SalariedEmployee(
	SSN varchar(500) primary key,
	FirstName varchar(500),
    LastName varchar(500),
    BirthDate datetime,
    Phone varchar(500),
    Email varchar(500),
    CommissionRate double,
    GrossSales double,
    BasicSalary double
);

create table HourlyEmployee(
	SSN varchar(500) primary key,
	FirstName varchar(500),
    LastName varchar(500),
    BirthDate datetime,
    Phone varchar(500),
    Email varchar(500),
    Wage double,
    WorkingHours double	
);

INSERT INTO `employee`.`hourlyemployee` (`SSN`, `FirstName`, `LastName`, `BirthDate`, `Phone`, `Email`, `Wage`, `WorkingHours`) VALUES ('a', 'trần', 'tiến', '2022-01-01 00:00:00 ', '0935430002', 'tienngqueson@gmail.com', '5', '10');
INSERT INTO `employee`.`hourlyemployee` (`SSN`, `FirstName`, `LastName`, `BirthDate`, `Phone`, `Email`, `Wage`, `WorkingHours`) VALUES ('b', 'đặng', 'nam', '2022-01-01 00:00:00 ', '0935430003', 'tienngqueson02@gmail.com', '5', '10');
INSERT INTO `employee`.`hourlyemployee` (`SSN`, `FirstName`, `LastName`, `BirthDate`, `Phone`, `Email`, `Wage`, `WorkingHours`) VALUES ('c', 'nguyễn', 'quyến', '2022-01-01 00:00:00 ', '0935430004', 'tienngqueson03@gmail.com', '5', '10');
INSERT INTO `employee`.`hourlyemployee` (`SSN`, `FirstName`, `LastName`, `BirthDate`, `Phone`, `Email`, `Wage`, `WorkingHours`) VALUES ('d', 'phan', 'trinh', '2022-01-01 00:00:00 ', '0935430005', 'tienngqueson04@gmail.com', '5', '10');


INSERT INTO `employee`.`salariedemployee` (`SSN`, `FirstName`, `LastName`, `BirthDate`, `Phone`, `Email`, `CommissionRate`, `GrossSales`, `BasicSalary`) VALUES ('1', 'bùi', 'châu', '2022-01-01 00:00:00 ', '0935430002', 'tienngqueson@gmail.com', '5', '10', '20');
INSERT INTO `employee`.`salariedemployee` (`SSN`, `FirstName`, `LastName`, `BirthDate`, `Phone`, `Email`, `CommissionRate`, `GrossSales`, `BasicSalary`) VALUES ('2', 'siêu', 'nhân', '2022-01-01 00:00:00 ', '0935430003', 'tienngqueson02@gmail.com', '5', '10', '20');
INSERT INTO `employee`.`salariedemployee` (`SSN`, `FirstName`, `LastName`, `BirthDate`, `Phone`, `Email`, `CommissionRate`, `GrossSales`, `BasicSalary`) VALUES ('3', 'vinh', 'hạnh', '2022-01-01 00:00:00 ', '0935430004', 'tienngqueson03@gmail.com', '5', '10', '20');
INSERT INTO `employee`.`salariedemployee` (`SSN`, `FirstName`, `LastName`, `BirthDate`, `Phone`, `Email`, `CommissionRate`, `GrossSales`, `BasicSalary`) VALUES ('4', 'lê', 'luyện', '2022-01-01 00:00:00 ', '0935430005', 'tienngqueson04@gmail.com', '5', '10', '20');
