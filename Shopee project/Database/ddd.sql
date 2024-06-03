create database test;
use test;

CREATE TABLE user (
    id INT PRIMARY KEY,
    joining_date date default (current_date())
);

 SELECT CURDATE();