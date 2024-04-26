create database tien_thanh;
use tien_thanh;

CREATE TABLE LichSuThayDoi (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Action TEXT,
    ThoiGianChinhSua TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    DuLieuCu JSON,
    DuLieuMoi JSON
);

	create table android_phone(
		id varchar(20) primary key,
		name_owner text,
		name_phone text,
		id_of_phone text,
		price int,
		start_Date date,
		phone_number_owner text,
		status text,
		password text,
		note text
	);
