create database library;
use library;

create table book(
	id_book varchar(50) not null primary key,
    name_book text,
    author_book text,
    describe_book text,
    quantity_book int
);

create table student(
	id_student varchar(50) not null primary key,
    name_student text,
    class_student text
);

create table book_loan_card(
	id_loan_card varchar(50) not null primary key,
    id_book varchar(50),	
    id_student varchar(50),
    status_loan_card bit,
    borrowed_date date,
    return_date date,
    foreign key (id_book) references book(id_book),
	foreign key (id_student) references student(id_student)
);

INSERT INTO `library`.`book` (`id_book`, `name_book`, `author_book`, `describe_book`, `quantity_book`) VALUES ('a1', 'tt', 'tien', 'romace', 9);
INSERT INTO `library`.`book` (`id_book`, `name_book`, `author_book`, `describe_book`, `quantity_book`) VALUES ('a2', 'cách làm người', 'huấn rose', 'đạo đức', 8);
INSERT INTO `library`.`book` (`id_book`, `name_book`, `author_book`, `describe_book`, `quantity_book`) VALUES ('a3', 'còn cái nịt', 'tiến bịp', 'đạo chít', 2);

INSERT INTO `library`.`student` (`id_student`, `name_student`, `class_student`) VALUES ('1', 'tien', 'gg');
INSERT INTO `library`.`student` (`id_student`, `name_student`, `class_student`) VALUES ('2', 'nam', 'hh');
INSERT INTO `library`.`student` (`id_student`, `name_student`, `class_student`) VALUES ('3', 'linh', 'jj');

INSERT INTO `library`.`book_loan_card` (`id_loan_card`, `id_book`, `id_student`, `status_loan_card`, `borrowed_date`, `return_date`) VALUES ('ms-1', 'a1', '3', 1, '2023-05-21', '2023-05-31');
INSERT INTO `library`.`book_loan_card` (`id_loan_card`, `id_book`, `id_student`, `status_loan_card`, `borrowed_date`, `return_date`) VALUES ('ms-4', 'a1', '1', 1, '2023-05-21', '2023-05-31');
INSERT INTO `library`.`book_loan_card` (`id_loan_card`, `id_book`, `id_student`, `status_loan_card`, `borrowed_date`, `return_date`) VALUES ('ms-5', 'a1', '1', 1, '2023-05-21', '2023-06-07');

