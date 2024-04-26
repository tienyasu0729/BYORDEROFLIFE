create database quan_ly_sinh_vien;
use quan_ly_sinh_vien;

create table Class(
	ClassID int primary key,
	ClassName varchar(60) Not Null,
    StartDate Datetime Not Null,
    Status Bit
);
-- ALTER TABLE Student MODIFY COLUMN StudentID int primary key auto_increment;
create table Student(
	StudentID int primary key auto_increment,
    StudentName varchar(30) Not Null,
    Address varchar(50),
    Phone varchar(20),
    Status Bit,
    ClassID Int not null,
    foreign key (ClassID) references Class(ClassID)
);

create table Subject(
	SubID int primary key,
    SubName varchar(60) not null,
    Credit Tinyint Not null Default 1 check (Credit >= 1),
    Status Bit Default 1
);

create table Mark(
	MarkID int primary key auto_increment,
    SubID Int Unique key,
    StudentID Int Unique key,
	Mark float Default 0 check (Mark BETWEEN 0 AND 100),
    ExamTimes Tinyint Default 1,
	foreign key (SubID) references Subject(SubID),
	foreign key (StudentID) references Student(StudentID)
);

INSERT INTO Class
VALUES (1, 'A1', '2008-12-20', 1);
INSERT INTO Class
VALUES (2, 'A2', '2008-12-22', 1);
INSERT INTO Class
VALUES (3, 'B3', current_date, 0);

INSERT INTO Student (StudentName, Address, Phone, Status, ClassId)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO Student (StudentName, Address, Status, ClassId)
VALUES ('Hoa', 'Hai phong', 1, 1);
INSERT INTO Student (StudentName, Address, Phone, Status, ClassId)
VALUES ('Manh', 'HCM', '0123123123', 0, 2);

INSERT INTO Subject
VALUES (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
       
INSERT INTO Mark (SubId, StudentId, Mark, ExamTimes)
VALUES (1, 1, 8, 1),
       (4, 2, 10, 2),
       (2, 3, 12, 1);       
       
       
       
select * from Student where StudentName like 'h%';
select * from class where month(StartDate) = 12 ;
select * from subject where Credit between 3 and 5;
update student 
set ClassID = 2
where StudentName = 'hung';
-- select * from Student 
-- order by mark desc, 