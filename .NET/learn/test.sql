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