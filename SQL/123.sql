create database test;
create table NhanVien2(
	MaNV int primary key,
    HoTenNV nvarchar(50),
    GioiTinh bit,
    QueQuan nvarchar(100) default n'Đà Nẵng',
    Tuoi int check (Tuoi >= 18)
);
create table LoaiSP(
	MaLoaiSP varchar(10),
    TenLoaiSP nvarchar(100),
    constraint pk_maloaisp primary key (MaLoaiSP)
);
alter table LoaiSP add constraint primary key (MaLoaiSP);
create table sanpham(
	masp int primary key,
    tensp nvarchar(50),
    maloaisp varchar(10),
    giaban int,
    constraint fk_sanpham_loaisp foreign key (maloaisp)
    references loaisp(maloaisp)
);
create table banhang(
	manv int,
    masp int,
    soluongdaban int check(soluongdaban > 0),
    constraint primary key (manv, masp),
    constraint fk_banhang_sp foreign key (masp)
    references sanpham(masp)
);
alter table banhang add constraint pk_banhang_nv
foreign key (manv) references nhanvien(manv);
alter table banhang add note text;
select * from NhanVien
where HoTenNV like 'Nguyen%';
select * from NhanVien
where HoTenNV like '______' -- % _