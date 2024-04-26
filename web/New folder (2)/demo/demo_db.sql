create database demo_db;
use demo_db;

create table cong_viec (
	ma_cong_viec varchar(50),
    ten_cong_viec varchar(50),
    luong_thap_nhat double,
    luong_cao_nhat double,
primary key(ma_cong_viec));

create table nhan_vien (
	ma_nhan_vien varchar(10),
    ho_ten varchar(50),
    ngay_sinh varchar(50),
    dia_chi varchar(50),
    ngay_bat_dau_lam varchar(50),
    ngay_ket_thuc_lam varchar(50),
    luong double,
    ma_cong_viec varchar(50),
    foreign key(ma_cong_viec) references cong_viec(ma_cong_viec),
primary key(ma_nhan_vien));