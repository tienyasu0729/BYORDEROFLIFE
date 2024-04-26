	create database ss2;
use ss2;
create table VatTu(
	MaVTU varchar(45) primary key,
    TenVTU varchar(45)
);
create table PhieuXuat(
	SoPX varchar(45) primary key,
    NgayXuat date
);
create table PhieuNHap(
	SoPN varchar(45) primary key,
    NgayNhap date
);

create table NhaCC(
	MaNhaCC varchar(45) primary key,
    TenNhaCC varchar(45),
    DiaChi varchar(100),
    SoDH varchar(45)
);
create table DonDH(
	SoDH varchar(45) primary key,
    NgayDH date,
    MaNhaCC varchar(45),
    foreign key (MaNhaCC) references NhaCC(MaNhaCC)
);
create table ChiTietPhieuXuat(
	SoPX varchar(45),
	MaVTU varchar(45),
    foreign key (SoPX) references PhieuXuat(SoPX),
    foreign key (MaVTU) references VatTu(MaVTU),
	DGXuat int,
    SLXuat int
);
create table ChiTietPhieuNhap(
	MaVTU varchar(45),
	SoPN varchar(45),
    foreign key (MaVTU) references VatTu(MaVTU),
    foreign key (SoPN) references PhieuNhap(SoPN),
    DGNhap int,
    SLNhap int
);
create table SDT (
	SDT mediumint,
    MaNhaCC varchar(10),
    primary key (SDT, MaNhaCC),
    foreign key (MaNhaCC) REFERENCES NhaCC(MaNhaCC)
);
create table ChiTietDatHang(
	MaVTU varchar(45),
    SoDH varchar(45),
    foreign key (MaVTU) references VatTu(MaVTU),
    foreign key (SoDH) references DonDH(SoDH)
);






