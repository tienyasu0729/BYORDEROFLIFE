create database linh;
use linh;

create table job(
	jobid int not null primary key auto_increment,
    jobnam text,
    highestSalary int,
    lowestSalary int
);

create table employee(
	employeeId int not null primary key auto_increment,
    name text,
    birthday date,
    address text,
    startDate date,
    endDate date,
    salary int,
    jobid int,
    foreign key ( jobid ) references job (jobid)
);

