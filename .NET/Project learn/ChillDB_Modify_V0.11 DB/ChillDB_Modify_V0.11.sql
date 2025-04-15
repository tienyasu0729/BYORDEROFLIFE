USE master

CREATE DATABASE Chill_Computer

USE Chill_Computer

CREATE TABLE Role_
(
	Role_Id INT PRIMARY KEY,
	Role_Position NVARCHAR(20) NOT NULL
)

CREATE TABLE Account
(
	UserName VARCHAR(20) PRIMARY KEY,
	_Password VARCHAR(20) NOT NULL,
	Role_Id INT NOT NULL,
	FOREIGN KEY (Role_Id) REFERENCES Role_(Role_Id)
)

CREATE TABLE User_
(
	UserId INT IDENTITY(1,1) PRIMARY KEY,
	FullName NVARCHAR(100) NOT NULL,
	Email VARCHAR(30) UNIQUE NOT NULL,
	Dob DATE NULL,
	Phone VARCHAR(10) UNIQUE  NULL,
	Address_ NVARCHAR(50) NULL,
	UserName VARCHAR(20) NULL,
	FOREIGN KEY (UserName) REFERENCES Account(UserName)
)

CREATE TABLE Product_Type
(
	Type_Id_ INT IDENTITY(1,1) PRIMARY KEY,
	Type_Name_ NVARCHAR(30) NOT NULL,
	Type_Imgs NVARCHAR(100) NOT NULL
)

CREATE TABLE Brand (
    Brand_Id INT IDENTITY(1,1) PRIMARY KEY,
    Brand_Name NVARCHAR(50) NOT NULL UNIQUE
)

CREATE TABLE Series (
    Series_Id INT IDENTITY(1,1) PRIMARY KEY,
    Series_Name NVARCHAR(50) NOT NULL,
    Brand_Id INT NOT NULL,
    FOREIGN KEY (Brand_Id) REFERENCES Brand(Brand_Id)
)

CREATE TABLE Product
(
	Product_Id INT IDENTITY(1,1) PRIMARY KEY,
	Product_Name NVARCHAR(100) NOT NULL,
	Price INT NOT NULL,
	FormattedPrice AS REPLACE(FORMAT(Price, '#,##0.##', 'vi-VN'), '.', ','),-- Format the Price column without trailing zeros
	STOCK INT NOT NULL,
	img1 VARCHAR(200) NULL,
	img2 VARCHAR(200) NULL,
	img3 VARCHAR(200) NULL,
	Color NVARCHAR(50) NULL,
	Version_ NVARCHAR(100) NULL,
	Type_Id_ INT,
	Brand_Id INT,
	Series_Id INT NULL,
	FOREIGN KEY (Type_Id_) REFERENCES Product_Type(Type_Id_),
	FOREIGN KEY (Brand_Id) REFERENCES Brand(Brand_Id),
    FOREIGN KEY (Series_Id) REFERENCES Series(Series_Id)
)

--Bo sung bang attribute
CREATE TABLE Attribute
(
	Attribute_Id INT IDENTITY(1,1) PRIMARY KEY,
	Attribute_Name NVARCHAR(100) NOT NULL,
	Type_Id_ INT,
	Parent_Id INT NULL,
	FOREIGN KEY (Type_Id_) REFERENCES Product_Type(Type_Id_),
	FOREIGN KEY (Parent_Id) REFERENCES Attribute(Attribute_Id)
)

CREATE TABLE Product_Attribute
(
	Product_Id INT,
	Attribute_Id INT,
	Attribute_Value NVARCHAR(max),
	FOREIGN KEY (Product_Id) REFERENCES Product(Product_Id),
	FOREIGN KEY (Attribute_Id) REFERENCES Attribute(Attribute_Id)
)

CREATE TABLE Product_Type_Filter
(
	Filter_Id INT IDENTITY(1,1) PRIMARY KEY,
	Filter_Name NVARCHAR(50) NOT NULL,
	Type_Id_ INT,
	FOREIGN KEY (Type_Id_) REFERENCES Product_Type(Type_Id_)
)

CREATE TABLE Filter_Category
(
	Category_Id INT IDENTITY(1,1) PRIMARY KEY,
	Category_Name NVARCHAR(50) NOT NULL,
	Parent_Id INT NULL,
	Filter_Id INT,
	FOREIGN KEY (Parent_Id) REFERENCES Filter_Category(Category_Id),
	FOREIGN KEY (Filter_Id) REFERENCES Product_Type_Filter(Filter_Id)
)

CREATE TABLE PC
(
	PC_Id INT IDENTITY(1,1) PRIMARY KEY,
	Price MONEY NOT NULL,
)

CREATE TABLE PcComponent
(
	Product_Id INT NOT NULL,
	PC_Id INT NOT NULL,
	FOREIGN KEY (Product_Id) REFERENCES Product(Product_Id),
	FOREIGN KEY (PC_Id) REFERENCES PC(PC_Id)
)

CREATE TABLE ShoppingCart
(
	Cart_Id INT IDENTITY(1,1) PRIMARY KEY,
	UserId INT NOT NULL,
	FOREIGN KEY (UserId) REFERENCES User_(UserId),
)

CREATE TABLE CartItem
(
	Cart_Item_Id INT IDENTITY(1,1) PRIMARY KEY,
	Product_Id INT NULL,
	Cart_Id INT NULL,
	PC_Id INT NULL,
	Item_Quantity INT NOT NULL,
	FOREIGN KEY (Product_Id) REFERENCES Product(Product_Id),
	FOREIGN KEY (Cart_Id) REFERENCES ShoppingCart(Cart_Id),
	FOREIGN KEY (PC_Id) REFERENCES PC(PC_Id)
)

CREATE TABLE Order_
(
	Order_Id INT IDENTITY(1,1) PRIMARY KEY,
	Order_Date DATE NOT NULL,
	Total_Price MONEY NOT NULL,
	Order_Status NVARCHAR(50) NULL,
	UserId INT NOT NULL,
	FOREIGN KEY (UserId) REFERENCES User_(UserId)
)

CREATE TABLE OrderItem
(
	Order_Id INT NULL,
	Product_Id INT NULL,
	PC_Id INT NULL,
	FOREIGN KEY (Order_Id) REFERENCES Order_(Order_Id),
	FOREIGN KEY (Product_Id) REFERENCES Product(Product_Id),
	FOREIGN KEY (PC_Id) REFERENCES PC(PC_Id)
)

CREATE TABLE Blog
(
	Blog_Id INT IDENTITY(1,1) PRIMARY KEY,
	Blog_Content NVARCHAR(500) NOT NULL,
	Date_Publish DATE NOT NULL,
	Publisher NVARCHAR(20) NOT NULL
)

CREATE TABLE Payment
(
	Payment_Id INT IDENTITY(1,1) PRIMARY KEY,
	Payment_Date DATE NOT NULL,
	Cart_Id INT NOT NULL,
	UserId INT NOT NULL,
	FOREIGN KEY (Cart_Id) REFERENCES ShoppingCart(Cart_Id),
	FOREIGN KEY (UserId) REFERENCES User_(UserId)
)

CREATE TABLE Discount (
    Discount_Id INT IDENTITY(1,1) PRIMARY KEY,
    Discount_Code NVARCHAR(20) NOT NULL UNIQUE,
    Discount_Amount MONEY NOT NULL,
    Start_Date DATE NOT NULL,
    End_Date DATE NOT NULL,
    Is_Active BIT NOT NULL DEFAULT 1  -- Mặc định là ACTIVE
);


INSERT INTO Role_ (Role_Id, Role_Position) VALUES
(1, 'Admin'),
(2, 'Customer'),
(3, 'Employee');
GO

INSERT INTO Account (UserName, _Password, Role_Id) VALUES 
('employee1', '123', 3),   
('employee2', '123', 3),   
('customer1', '123', 2), 
('customer2', '123', 2),
('admin1', '123', 1); 
GO

INSERT INTO User_ (FullName, Email, Dob, Phone, Address_, UserName) VALUES 
(N'TienT' ,'Tien123@gmail.com', '2003-01-01', '0123456789', N'Đà Nẵng', 'employee1'),
(N'LinhHV' ,'Linh123@gmail.com', '2002-02-02', '0123456788', N'Quảng Nam', 'employee2'),
(N'QuangH' ,'Quang132@gmail.com', '2000-03-03', '0123456787', N'Đà Nẵng', 'customer1'),
(N'PhucNVH' ,'PhucNVH@gmail.com', '2004-09-27', '0123456786', N'Đà Nẵng', 'customer2'),
(N'BaoLT' ,'BaoLT1404@gmail.com', '2004-04-14', '0123456785', N'Đà Nẵng', 'admin1');
GO

INSERT INTO Brand(Brand_Name) VALUES
('Asus'), --1
('Lenovo'), --2
('Dell'), --3
('Acer'), --4
('HP'), --5
('MSI'), --6
('Razer'), --7
('LG'), --8
('Akko') --9

INSERT INTO Series(Brand_Id, Series_Name) VALUES

(2, 'ThinkPad'), --5
(2, 'Yoga'), --6
(2, 'ThinkBook'), --7
(2, 'Legion'), --8
(2, 'LOQ'), --9
(3, 'XPS'), --10
(3, 'Inspiron'), --11
(3, 'Precision'), --12
(3, 'Latitude'), --13
(3, 'Alienware'), --14
(4, 'Swift'), --15
(4, 'Nitro'), --16
(4, 'Predator'), --17
(5, 'ENVY'), --18
(5, 'OMEN'), --19
(5, 'Victus'), --20
(5, 'Pavilion'), --21
(5, 'Elite'), --22
(6, 'Modern'), --23
(6, 'Raider'), --24
(6, 'Stealth'), --25

INSERT INTO Product_Type (Type_Name_, Type_Imgs) VALUES
(N'Laptop', 'https://i.postimg.cc/RCJp1qdS/laptop-1-1.webp'), --1
(N'Tai nghe', 'https://i.postimg.cc/cC3Dd5Cg/image8.png'), --2
(N'Chuột','https://i.postimg.cc/tJRnxcyc/image14.png'), --3
(N'Bàn phím', 'https://i.postimg.cc/Y9ZnKwrB/image7.png'), --4
(N'Màn hình', 'https://i.postimg.cc/d0QSGBHp/image6.png'), --5
(N'Main', 'https://i.postimg.cc/HWtQkwHK/image11.png'), --6
(N'CPU', 'https://i.postimg.cc/m2XCQTPy/image12.png'), --7
(N'VGA - Card màn hình', 'https://i.postimg.cc/Pq6Vyw0x/image9.png'), --8
(N'RAM', 'https://i.postimg.cc/RVVw6WZ0/image13.png'), --9
(N'SSD', 'https://i.postimg.cc/Y2vZXdrw/image.png'), --10
(N'HDD', 'https://i.postimg.cc/fTXFskS2/image2.png'), --11
(N'Case', 'https://i.postimg.cc/wxnPnDMR/image3.png'), --12
(N'Nguồn', 'https://i.postimg.cc/x12Z1YK0/image4.png'), --13
(N'Tản nhiệt', 'https://i.postimg.cc/W1wHDKn0/image5.png'), --14
(N'PC', 'https://i.postimg.cc/ydkQbNzT/image10.png'); --15
GO

INSERT INTO Product_Type_Filter (Filter_Name, Type_Id_) VALUES 
--Laptop
(N'Thương hiệu', 1), --1
(N'Nhu Cầu', 1), --2   
(N'CPU', 1), --3
(N'Card đồ họa', 1), --4
(N'Khoảng giá', 1), --5
(N'Dung lượng RAM', 1), --6
(N'Kích thước màn hình', 1), --7
(N'Tần số quét', 1), --8
(N'Độ phân giải', 1), --9
--Tai nghe
(N'Thương hiệu tai nghe', 2), --10
(N'Tai nghe theo giá', 2), --11
--Chuột
(N'Thương hiệu chuột', 3), --12
(N'Chuột theo giá', 3), --13
--Bàn phím
(N'Thương hiệu bàn phím', 4), --14
(N'Bàn phím theo giá', 4),  --15
--Màn hình
(N'Thương hiệu', 5), --16
(N'Giá tiền', 5), --17
(N'Kích thước', 5), --18
(N'Tần số quét', 5), --19
(N'Độ phân giải', 5), --20
--Main
(N'Thương hiệu main',6), --21
(N'Chipset', 6), --22
(N'Kích thước', 6), --23
(N'Loại RAM', 6), --24
(N'Socket', 6), --25
--CPU 
(N'Thương hiệu CPU', 7), --26
(N'Dòng CPU', 7), --27
(N'Socket', 7), --28
--VGA - Card màn hình
(N'Thương hiệu VGA', 8), --29 
(N'Khoảng giá', 8), --30
(N'Nhân đồ họa', 8), --31
(N'Dòng VGA', 8), --32
--RAM
(N'Thương hiệu RAM', 9), --33
(N'Bus RAM', 9), --34
(N'Dung lượng', 9), --35
(N'Loại RAM', 9), --36
--SSD
(N'Thương hiệu SSD', 10), --37
(N'Giá tiền', 10), --38
(N'Dung lượng', 10), --39
(N'Loại SSD', 10), --40
--HDD
(N'Thương hiệu HDD', 11), --41
(N'Giá tiền', 11), --42
(N'Dung lượng', 11), --43
--Case
(N'Thương hiệu case', 12), --44
(N'Giá tiền', 12), --45
(N'Hỗ trợ main',12), --46
(N'Kích cỡ', 12), --47
(N'Màu sắc', 12), --48
--Nguồn
(N'Thương hiệu nguồn', 13), --49
(N'Công suất', 13), --50
--Tản nhiệt
(N'Thương hiệu tản nhiệt',14), --51
(N'Giá tiền', 14), --52
(N'Màu sắc', 14), --53
(N'Kích thước', 14), --54
(N'Loại tản nhiệt', 14); --55
GO

INSERT INTO Filter_Category (Category_Name, Parent_Id, Filter_Id) VALUES 
--Laptop
(N'Dell', NULL, 1), --1
(N'Acer', NULL, 1 ), --2
(N'Razer', NULL, 1), --3
(N'Lenovo', NULL, 1), --4
(N'Asus', NULL, 1), --5
(N'HP', NULL, 1), --6
(N'MSI', NULL, 1), --7
(N'LG', NULL, 1), --8
(N'Sinh viên', NULL, 2), --9
(N'Gaming', NULL, 2), --10
(N'Đồ họa', NULL, 2), --11
(N'Lập trình', NULL, 2), --12
(N'Mỏng nhẹ', NULL, 2), --13
(N'Văn phòng', NULL, 2), --14
(N'Intel', NULL, 3), --15
(N'AMD', NULL, 3), --16
(N'Core i3', 15, 3), --17
(N'Ryzen 3', 16, 3), --18
(N'Core i5', 15, 3), --19
(N'Ryzen 5', 16, 3), --20
(N'Core i7', 15, 3), --21
(N'Ryzen 7', 16, 3), --22
(N'Core i9', 15, 3), --23
(N'Ryzen 9', 16, 3), --24
(N'AMD Radeon Series', NULL, 4), --25
(N'NVIDIA GeForce Series', NULL, 4), --26
(N'Card Onboard', NULL, 4), --27
(N'Dưới 10 triệu', NULL, 5), --28
(N'Từ 10 - 15 triệu', NULL, 5), --29
(N'Từ 15 - 20 triệu', NULL, 5), --30
(N'Từ 20 - 25 triệu', NULL, 5), --31
(N'Từ 25 - 30 triệu', NULL, 5), --32
(N'Từ 30 - 40 triệu', NULL, 5), --33
(N'Trên 40 triệu', NULL, 5), --34
(N'8 GB', NULL, 6), --35
(N'12 GB', NULL, 6), --36
(N'16 GB', NULL, 6), --37
(N'24 GB', NULL, 6), --38
(N'32 GB', NULL, 6), --39
(N'256 GB', NULL, 6), --40
(N'512 GB', NULL, 6), --41
(N'1 TB', NULL, 6), --42
(N'13 Inch', NULL, 7), --43
(N'14 Inch', NULL, 7), --44
(N'15 Inch', NULL, 7), --45
(N'Từ 16 Inch trở lên', NULL, 7), --46
(N'60 Hz', NULL, 8), --47
(N'120 Hz', NULL, 8), --48
(N'144 Hz', NULL, 8), --49
(N'165 Hz', NULL, 8), --50
(N'240 Hz', NULL, 8), --51
(N'FHD', NULL, 9), --52
(N'2K', NULL, 9), --53
(N'4K', NULL, 9), --54
--Tai nghe
(N'Asus', NULL, 10), --55
(N'Hyper X', NULL, 10), --56
(N'Corsair', NULL, 10), --57
(N'Razer', NULL, 10), --58
(N'Logitech', NULL, 10), -- 59
(N'Steelseries', NULL, 10), --60
(N'Dưới 1 triệu', NULL, 11), --61
(N'Từ 1 - 2 triệu', NULL, 11), --62
(N'Từ 2 - 3 triệu', NULL, 11), --63
(N'Từ 3 - 4 triệu', NULL, 11), --64
(N'Trên 4 triệu', NULL, 11), --65
--Chuột
(N'Asus' , NULL, 12), --66
(N'Logitech', NULL, 12), --67
(N'Corsair', NULL, 12), --68
(N'Razer', NULL, 12), --69
(N'Dareu', NULL, 12), --70
(N'Steelseries', NULL, 12), --71
(N'Rapoo', NULL, 12), --72
(N'Dưới 500 nghìn',NULL, 13), --73
(N'Từ 500 nghìn - 1 triệu',NULL, 13), --74
(N'Từ 1 - 2 triệu',NULL, 13), --75
(N'Từ 2 - 3 triệu',NULL, 13), --76
(N'Trên 3 triệu',NULL, 13), --77
--Bàn phím
(N'Asus',NULL, 14), --78
(N'Akko',NULL, 14), --79
(N'AULA',NULL, 14), --80
(N'FL-Esports',NULL, 14), --81
(N'Corsair',NULL, 14), --82
(N'Dareu',NULL, 14), --83
(N'Logitech',NULL, 14), --84
(N'E-Dra',NULL, 14), --85
(N'Razer',NULL, 14), --86
(N'Rapoo',NULL, 14), --87
(N'Steelseries',NULL, 14), --88
(N'Dưới 1 triệu',NULL, 15), --89
(N'Từ 1 - 2 triệu',NULL, 15), --90
(N'Từ 2 - 3 triệu',NULL, 15), --91
(N'Từ 3 - 4 triệu',NULL, 15), --92
(N'Trên 4 triệu',NULL, 15), --93
--Màn hình
(N'LG',NULL, 16), --94
(N'MSI',NULL, 16), --95
(N'Asus',NULL, 16), --96
(N'Lenovo',NULL, 16), --97
(N'ViewSonic',NULL, 16), --98
(N'Samsung',NULL, 16), --99
(N'Dell',NULL, 16), --100
(N'E-Dra',NULL, 16), --101
(N'Acer',NULL, 16), --102
(N'Gigabyte',NULL, 16), --103
(N'HKC',NULL, 16), --104
(N'Philips',NULL, 16), --105
(N'Dưới 5 triệu',NULL, 17), --106
(N'Từ 5 - 10 triệu',NULL, 17), --107
(N'Từ 10 - 20 triệu',NULL, 17), --108
(N'Từ 20 - 30 triệu',NULL, 17), --109
(N'Trên 30 triệu',NULL, 17), --110
(N'22 Inch',NULL, 18), --111
(N'24 Inch',NULL, 18), --112
(N'25 Inch',NULL, 18), --113
(N'27 Inch',NULL, 18), --114
(N'29 Inch',NULL, 18), --115
(N'32 Inch',NULL, 18), --116
(N'38 Inch',NULL, 18), --117
(N'45 Inch',NULL, 18), --118
(N'60 Hz',NULL, 19), --119
(N'75 Hz',NULL, 19), --120
(N'100 Hz',NULL, 19), --121
(N'120 Hz',NULL, 19), --122
(N'144 Hz',NULL, 19), --123
(N'165 Hz',NULL, 19), --124
(N'240 Hz',NULL, 19), --125
(N'280 Hz',NULL, 19), --126
(N'300 Hz',NULL, 19), --127
(N'360 Hz',NULL, 19), --128
(N'380 Hz',NULL, 19), --129
(N'480 Hz',NULL, 19), --130
(N'540 Hz',NULL, 19), --131
(N'FHD',NULL, 20), --132
(N'2K',NULL, 20), --133
(N'4K',NULL, 20), --134
--Main
(N'ASRock' ,NULL, 21), --135
(N'Asus',NULL, 21), --136
(N'Colorful',NULL, 21), --137
(N'Gigabyte',NULL, 21), --138
(N'MSI',NULL, 21), --139
(N'AMD A450',NULL, 22), --140
(N'AMD B550',NULL, 22), --141
(N'AMD B650',NULL, 22), --142
(N'AMD TRX40',NULL, 22), --143
(N'AMD TRX40 (sTR4)',NULL, 22), --144
(N'AMD TRX50',NULL, 22), --145
(N'AMD X570',NULL, 22), --146
(N'AMD X670',NULL, 22), --147
(N'AMD X870',NULL, 22), --148
(N'Intel B560',NULL, 22), --149
(N'Intel B660',NULL, 22), --150
(N'Intel B760',NULL, 22), --151
(N'Intel H510',NULL, 22), --152
(N'Intel H610',NULL, 22), --153
(N'Intel Z690',NULL, 22), --154
(N'Intel Z790',NULL, 22), --155
(N'Intel Z890',NULL, 22), --156
(N'ATX',NULL, 23), --157
(N'E-ATX',NULL, 23), --158
(N'Mini-ITX',NULL, 23), --159
(N'mATX',NULL, 23), --160
(N'DDR4',NULL, 24), --161
(N'DDR5',NULL, 24), --162
(N'AM4',NULL, 25), --163
(N'AM5',NULL, 25), --164
(N'AMD sTR4',NULL, 25), --165
(N'LGA 1200',NULL, 25), --166
(N'LGA 1700',NULL, 25), --167
(N'LGA 1851',NULL, 25), --168
(N'sTR5',NULL, 25), --169
(N'sTRX4',NULL, 25), --170
--CPU
(N'Intel',NULL, 26), --171
(N'AMD',NULL, 26), --172
(N'Core i3', 171, 27), --173
(N'Core i5', 171, 27), --174
(N'Core i7', 171, 27), --175
(N'Core i9', 171, 27), --176
(N'Ryzen 3', 172, 27), --177
(N'Ryzen 5', 172, 27), --178
(N'Ryzen 7', 172, 27), --179
(N'Ryzen 9', 172, 27), --180
(N'AM4',NULL, 28), --181
(N'AM5',NULL, 28), --182
(N'LGA 1200',NULL, 28), --183
(N'LGA 1700',NULL, 28), --184
(N'LGA 1851',NULL, 28), --185
(N'sTR5',NULL, 28), --186
(N'sWRX8',NULL, 28), --187
--VGA - Card đồ họa
(N'Asus',NULL, 29), --188
(N'Gigabyte',NULL, 29), --189
(N'MSI',NULL, 29), --190
(N'Từ 5 - 10 triệu',NULL, 30), --191
(N'Từ 10 - 20 triệu',NULL, 30), --192
(N'Từ 20 - 30 triệu',NULL, 30), --193
(N'Từ 30 - 40 triệu',NULL, 30), --194
(N'Trên 40 triệu',NULL, 30), --195
(N'NVIDIA',NULL, 31), --196
(N'AMD', NULL, 31), --197
(N'RTX 3050', 188, 32), --198
(N'RTX 3060', 188, 32), --199
(N'RTX 4060', 188, 32), --200
(N'RTX 4060Ti', 188, 32), --201
(N'RTX 4070 Super', 188, 32), --202
(N'RTX 4070 Ti Super', 188, 32), --203
(N'RTX 4080 Super', 188, 32), --204
(N'RTX 5090', 188, 32), --205
(N'RX 6600', 189, 32), --206
(N'RX 6500 XT', 189, 32), --207
--RAM
(N'Adata',NULL, 33), --208
(N'Corsair',NULL, 33), --209
(N'G.Skill',NULL, 33), --210
(N'GIGABYTE',NULL, 33), --211
(N'Kingston',NULL, 33), --212
(N'PNY',NULL, 33), --213
(N'Patriot',NULL, 33), --214
(N'Team Group',NULL, 33), --215
(N'V-Color',NULL, 33), --216
(N'3200MHz',NULL, 34), --217
(N'3600MHz',NULL, 34), --218
(N'5200MHz',NULL, 34), --219 
(N'5600MHz',NULL, 34), --220 
(N'6000MHz',NULL, 34), --221
(N'6200MHz',NULL, 34), --222
(N'8 GB', NULL, 35), --223
(N'16 GB', NULL, 35), --224
(N'32 GB', NULL, 35), --225
(N'64 GB', NULL, 35), --226
(N'DDR4', NULL, 36), --227
(N'DDR5', NULL, 36), --228
--SSD
(N'Kingston', NULL, 37), --229
(N'Samsung', NULL, 37), --230
(N'Western Digital', NULL, 37), --231
(N'Dưới 1 triệu', NULL, 38), --232
(N'Từ 1 - 2 triệu', NULL, 38), --233
(N'Từ 2 - 3 triệu', NULL, 38), --234
(N'Trên 3 triệu', NULL, 38), --235
(N'240 - 256 GB', NULL, 39), --236
(N'480 - 512 GB', NULL, 39) ,--237
(N'960 - 1 TB', NULL, 39), --238
(N'Trên 2 TB', NULL, 39), --249
(N'M.2 PCIe 3.0', NULL, 40), --240
(N'M.2 PCIe 4.0', NULL, 40), --241
(N'M.2 PCIe 5.0', NULL, 40), --242
(N'M.2 SATA', NULL, 40), --243
(N'Sata 3 (2.5 inch)', NULL, 40), --244
--HDD
(N'Seagate', NULL, 41), --245
(N'Western Digital', NULL, 41), --246
(N'Dưới 1 triệu', NULL, 42), --247
(N'Từ 1 - 2 triệu', NULL, 42), --248
(N'Từ 2 - 3 triệu', NULL, 42), --249
(N'Trên 3 triệu', NULL, 42), --250
(N'1 TB', NULL, 43), --251
(N'10 TB', NULL, 43), --252
(N'2 TB', NULL, 43), --253
(N'4 TB', NULL, 43), --254
(N'6 TB', NULL, 43), --255
--Case
(N'Xigmatek', NULL, 44), --256
(N'Cooler Master', NULL, 44), --257
(N'Asus', NULL, 44), --258
(N'Corsair', NULL, 44), --259
(N'MSI', NULL, 44), --260
(N'Dưới 1 triệu', NULL, 45), --261
(N'Từ 1 - 2 triệu', NULL, 45), --262
(N'Từ 2 - 3 triệu', NULL, 45), --263
(N'Từ 3 - 5 triệu', NULL, 45), --264
(N'Trên 5 triệu', NULL, 45), --265
(N'ATX', NULL, 46), --266
(N'Mini-ITX', NULL, 46), --267
(N'Mid Tower', NULL, 47), --268
(N'Mini Tower', NULL, 47), --269
(N'Đen', NULL, 48), --270
(N'Trắng', NULL, 48), --271
--Nguồn 
(N'Asus', NULL, 49), --272
(N'Cooler Master', NULL, 49), --273
(N'Corsair', NULL, 49), --274
(N'Deepcool', NULL, 49), --275
(N'Gigabyte', NULL, 49), --276
(N'MSI', NULL, 49), --277
(N'Từ 400w - 500w', NULL, 50), --278
(N'Từ 500w - 600w', NULL, 50), --279
(N'Từ 700w - 800w', NULL, 50), --280
(N'Trên 800w', NULL, 50), --281
--Tản nhiệt
(N'Asus', NULL, 51), --282
(N'Cooler Master', NULL, 51), --283
(N'Corsair', NULL, 51), --284
(N'Deepcool', NULL, 51), --285
(N'MSI', NULL, 51), --286
(N'Dưới 1 triệu', NULL, 52), --287
(N'Từ 1 - 2 triệu', NULL, 52), --288
(N'Từ 2 - 3 triệu', NULL, 52), --289
(N'Từ 3 - 5 triệu', NULL, 52), --290
(N'Trên 5 triệu', NULL, 52), --291
(N'Đen', NULL, 53), --292
(N'Trắng', NULL, 53), --293
(N'140mm', NULL, 54), --294
(N'240mm', NULL, 54), --295
(N'280mm', NULL, 54), --296
(N'360mm', NULL, 54), --297
(N'4200mm', NULL, 54), --298
(N'Tản nhiệt khí', NULL, 55), --299
(N'Tản nhiệt nước', NULL, 55); --300
GO


INSERT INTO Discount (Discount_Code, Discount_Amount, Start_Date, End_Date, Is_Active) VALUES 
('TET2025', 0.15, '2025-01-01', '2025-01-31', 1),    
('GPMN2025', 0.10, '2025-04-30', '2025-05-01', 1),   
('QK2025', 0.12, '2025-09-01', '2025-09-02', 1),      
('VAL2025', 0.08, '2025-02-14', '2025-02-15', 1),      
('BD2025', 0.20, '2025-11-20', '2025-11-30', 1);       
GO

--Insert Attribute
INSERT INTO Attribute (Attribute_Name, Type_Id_, Parent_Id) VALUES 
(N'Bộ xử lý', 1 , NULL),    -- Assuming Type_Id_ 1 refers to Laptop (1)
(N'Loại CPU', 1, 1), --2
(N'Tốc độ', 1, 1), --3
(N'Bộ nhớ đệm', 1, 1), --4
(N'Card đồ họa', 1, NULL ), --5
(N'Card onboard', 1 , 5),     --6
(N'Card rời', 1, 5), --7
(N'RAM', 1, NULL), --8
(N'Dung lượng RAM', 1, 8), --9
(N'Hỗ trợ tối đa', 1, 8), --10
(N'Ô cứng', 1, NULL), --11
(N'Dung lượng SSD', 1, 11), --12
(N'Màn hình', 1, NULL), --13
(N'Màn hình', 1, 13), --14
(N'Thông số khác', 1, 13), --15
(N'Pin', 1, NULL), --16
(N'Dung lượng pin', 1, 16), --17
(N'Cổng kết nối', 1, NULL), --18
(N'Cổng kết nối', 1, 18), --19
(N'Khe thẻ SD/ Micro SD', 1, 18), --20
(N'Kết nối', 1, NULL), --21
(N'Wifi', 1, 21), --22
(N'Bluetooth', 1, 21), --23
(N'Hệ điều hành', 1, NULL), --24
(N'Hệ điều hành', 1, 24),
(N'Ổ lưu trữ', 1),        -- 3
(N'Màn hình', 1),         -- 5
(N'Cổng giao tiếp', 1),   -- 6
(N'Thời lượng sử dụng Pin', 2),  -- Assuming Type_Id_ 2 refers to Earphone (7)
(N'Dải tần số', 2),      -- 8
(N'Trọng lượng', 2),     -- 9
(N'Bluetooth', 2),       -- 10
(N'Switch', 3),          -- Assuming Type_Id_ 3 refers to Mouse (11)
(N'IPS', 3),             -- 12
(N'Độ dài dây (cm)', 3), -- 13
(N'LED', 3),             -- 14
(N'Tuổi thọ', 3),       -- 15
(N'Layout', 4),          -- Assuming Type_Id_ 4 refers to Keyboard (16)
(N'Switch', 4),          -- 17
(N'Keycap', 4),          -- 18
(N'Tốc độ phản hồi', 4),  -- 19
(N'Kết nối', 4),         -- 20
(N'Đèn nền', 4),         -- 21
(N'Bộ nhớ onboard', 4),  -- 22
(N'Chất liệu khung', 4),  -- 23
(N'Kích thước màn hình', 5),    -- Assuming Type_Id_ 5 refers to Monitor (24)
(N'Độ phân giải', 5),    -- 25
(N'Tỷ lệ màn hình', 5),  -- 26
(N'Lớp phủ bề mặt', 5),  -- 27
(N'Tấm nền', 5),         -- 28
(N'Tần số quét', 5),     -- 29
(N'Độ phủ màu', 5),      -- 30
(N'Độ sáng', 5),         -- 31
(N'Độ tương phản', 5),   -- 32
(N'Màn hình cảm ứng', 5), -- 33
(N'CPU', 6),             -- Assuming Type_Id_ 6 refers to Mainboard (34)
(N'Chipset', 6),         -- 35
(N'Bộ nhớ', 6),         -- 36
(N'Khe PCIe', 6),        -- 37
(N'Cổng xuất hình', 6),  -- 38
(N'Cổng SATA', 6),       -- 39
(N'Khe SSD M.2', 6),     -- 40
(N'Audio', 6),           -- 41
(N'LAN', 6),             -- 42
(N'Đầu nối nguồn', 6),    -- 43
(N'Cổng USB', 6),       -- 44
(N'Đầu nối quạt', 6),    -- 45
(N'Kết nối hệ thống', 6), -- 46
(N'Jumpers', 6),         -- 47
(N'Đèn LED', 6),         -- 48
(N'Kích thước', 6),      -- 49
(N'Số nhân', 7),         -- Assuming Type_Id_ 7 refers to CPU (50)
(N'Số luồng', 7),        -- 51
(N'Xung nhịp cơ bản', 7), -- 52
(N'Xung nhịp tối đa', 7), -- 53
(N'Bộ nhớ đệm L2', 7),   -- 54
(N'Bộ nhớ đệm L3', 7),   -- 55
(N'Khả năng ép xung', 7), -- 56
(N'Tiến trình', 7),      -- 57
(N'Socket', 7),          -- 58
(N'Phiên bản PCI Express', 7), -- 59
(N'Điện năng tiêu thụ', 7), -- 60
(N'RAM hỗ trợ', 7),      -- 61
(N'Hỗ trợ công nghệ', 7),   -- 62
(N'Nhân đồ họa', 8),          -- Assuming Type_Id_ 8 refers to VGA (63)
(N'Bus tiêu chuẩn', 8),       -- 64
(N'Bộ nhớ', 8),               -- 65
(N'Xung nhịp', 8),            -- 66
(N'Nhân CUDA', 8),            -- 67
(N'Tốc độ bộ nhớ', 8),         -- 68
(N'Giao thức bộ nhớ', 8),     -- 69
(N'Độ phân giải', 8),         -- 70
(N'Giao thức', 8),            -- 71
(N'Số lượng màn hình tối đa hỗ trợ', 8), -- 72
(N'Hỗ trợ NVlink/Crossfire', 8), -- 73
(N'Kích thước', 8),          -- 74
(N'PSU kiến nghị', 8),        -- 75
(N'Kết nối nguồn', 8),        -- 76
(N'Khe cắm', 8),             -- 77
(N'Dòng RAM', 9),             -- Assuming Type_Id_ 9 refers to RAM (78)
(N'Thế hệ', 9),               -- 79
(N'Thiết bị tương thích', 9), -- 80
(N'Dung lượng', 9),           -- 81
(N'Bus', 9),                  -- 82
(N'Thương hiệu', 10),         -- Assuming Type_Id_ 10 refers to SSD (83)
(N'Model', 10),               -- 84
(N'Kích thước', 10),         -- 85
(N'Giao diện', 10),          -- 86
(N'Mức dung lượng', 10),      -- 87
(N'Đọc/ghi tuần tự', 10),     -- 88
(N'Độ bền', 10),             -- 89
(N'Nhiệt độ bảo quản', 10),   -- 90
(N'Nhiệt độ vận hành', 10),   -- 91
(N'Thương hiệu', 11),         -- Assuming Type_Id_ 11 refers to Storage (Ổ cứng) (92)
(N'Giao thức kết nối', 11),   -- 93
(N'Dung lượng', 11),          -- 94
(N'Độ bền', 11),              -- 95
(N'Kích thước', 11),         -- 96
(N'Kiểu dáng', 11),           -- 97
(N'Tốc độ đọc', 11),          -- 98
(N'Tốc độ ghi', 11),          -- 99
(N'Kích thước', 12),          -- Assuming Type_Id_ 12 refers to Case (100)
(N'Vật liệu', 12),           -- 101
(N'Hỗ trợ', 12),              -- 102
(N'Khe mở rộng', 12),         -- 103
(N'Hỗ trợ Mainboard', 12),    -- 104
(N'Cổng kết nối', 12),        -- 105
(N'Cổng quạt dành riêng', 12), -- 106
(N'Hỗ trợ tản nhiệt (CPU)', 12), -- 107
(N'Hỗ trợ VGA', 12),          -- 108
(N'Chiều dài PSU', 12),      -- 109
(N'Mặt kính', 12),           -- 110
(N'Thương hiệu', 13),         -- Assuming Type_Id_ 13 refers to PSU (Nguồn) (111)
(N'Công kết nối ATX', 13),    -- 112
(N'Phiên bản ATX12V', 13),    -- 113
(N'Loại cáp', 13),           -- 114
(N'Công suất', 13),           -- 115
(N'Số cổng cắm', 13),        -- 116
(N'Hiệu suất', 13),          -- 117
(N'Quạt làm mát', 13),       -- 118
(N'MTBF Hours', 13),         -- 119
(N'Hỗ trợ nhiều GPU', 13),   -- 120
(N'Cổng kết nối SATA', 13),   -- 121
(N'Cổng kết nối PATA', 13),   -- 122
(N'Cổng kết nối PCIe', 13),   -- 123
(N'Hệ số công suất', 13),    -- 124
(N'Ánh sáng', 14),             -- Assuming Type_Id_ 14 refers to Tản nhiệt (125)
(N'Kích thước Radiator', 14), -- 126
(N'Số lượng quạt', 14),       -- 127
(N'Chất liệu tấm lạnh', 14),   -- 128
(N'Chất liệu Radiator', 14),   -- 129
(N'Kích thước quạt', 14),     -- 130
(N'Tương thích Socket', 14),   -- 131
(N'Tốc độ quạt', 14),          -- 132
(N'Luồng không khí của quạt', 14), -- 133
(N'Áp suất tĩnh của quạt', 14), -- 134
(N'Phần mềm iCUE', 14),        -- 135
(N'Chiều dài ống', 14),        -- 136
(N'Kích thước tấm lạnh', 14),  -- 137
(N'Vật liệu ống', 14),         -- 138
(N'Phương pháp điều khiển quạt', 14), -- 139
(N'Bộ xử lý AMD được hỗ trợ', 14), -- 140
(N'Bộ xử lý Intel được hỗ trợ', 14), -- 141
(N'PWM', 14),                  -- 142
(N'Cân nặng', 14),             -- 143
(N'Mainboard', 15),            -- Assuming Type_Id_ 15 refers to PC (144)
(N'CPU', 15),                  -- 145
(N'RAM', 15),                  -- 146
(N'VGA', 15),                  -- 147
(N'HDD', 15),                  -- 148
(N'SSD', 15),                  -- 149
(N'PSU', 15),                  -- 150
(N'Case', 15),                 -- 151
(N'Cooler', 15);               -- 152	
GO
---Insert Product---
INSERT INTO Product(Product_Name, Price, STOCK, img1, img2, img3, color, Version_, Type_Id_, Brand_Id, Series_Id) VALUES
--Laptop
('Asus Gaming ROG Zephyrus G16 GU603VV-N4022W', 40590000, 5, 'https://i.postimg.cc/SRwd49kL/laptop-asus-gaming-rog-zephyrus-g16-1.png', 'https://i.postimg.cc/2yqGgGR8/laptop-asus-gaming-rog-zephyrus-g16-2.png','https://i.postimg.cc/sXHKn8LN/laptop-asus-gaming-rog-zephyrus-g16-3.png'
, 'Eclipse Gray', 'i7 13620H, RTX 4060 8GB, 16GB, 512 GB, WQXGA 240Hz', 1, 1, 4),
('ASUS TUF Gaming A15 FA507NUR-LP101W - R7 7435HS', 24490000, 12, 'https://i.postimg.cc/QCd9gGHF/laptop-asus-tuf-gaming-a15-fa507nur-lp101w-1.png,', 'https://i.postimg.cc/prc9qGFq/laptop-asus-tuf-gaming-a15-fa507nur-lp101w-2.png', 'https://i.postimg.cc/XJ8By77M/laptop-asus-tuf-gaming-a15-fa507nur-lp101w-3.png' 
, 'Jaeger Gray', 'R7 7435HS, RTX 4050 6GB, 16GB, 512GB, FHD 144Hz', 1, 1, 3),
('Asus Zenbook S 13 OLED UX5304MA-NQ117W', 41990000, 2, 'https://i.postimg.cc/HsqvDqLG/laptop-asus-zenbook-s-13-1.png', 'https://i.postimg.cc/6pCj9M78/laptop-asus-zenbook-s-13-2.png', 'https://i.postimg.cc/Qx9Yz8hk/laptop-asus-zenbook-s-13-3.png'
, 'Basalt Grey', 'Ultra 7 155U, 32GB, 1TB, 3K OLED', 1, 1, 2),
('ASUS Vivobook Pro 15 OLED Q533', 23990000, 3, 'https://i.postimg.cc/YqhTwNfF/asus-vivobook-pro-15-oled-q533-1.png', 'https://i.postimg.cc/L6ww4qNb/asus-vivobook-pro-15-oled-q533-2.png', 'https://i.postimg.cc/wxWnP4JH/asus-vivobook-pro-15-3.png'
, 'Earl Gray', 'Ultra 7 155H, RTX 3050 6GB, 16GB, 1TB, FHD OLED', 1, 1, 1),
('Asus Zenbook 14 OLED Q415', 14990000, 4, 'https://i.postimg.cc/bJRfszs2/asus-zenbook-14-oled-q415.png', 'https://i.postimg.cc/Y0nczbNr/asus-zenbook-14-oled-q415-2.png', 'https://i.postimg.cc/tJmfx7y7/asus-zenbook-14-oled-q415-3.png'
, 'Xám (Carbon Gray)', 'Ultra 5 125H, 8GB, 512GB, FHD+ OLED Touch', 1, 1, 2),
('Lenovo ThinkPad X1 Carbon Gen 11', 26790000, 14, 'https://imagor.owtg.one/unsafe/fit-in/1760x990/https://d28jzcg6y4v9j1.cloudfront.net/media/core/products/2022/12/23/lenovo-thinkpad-x1-carbon-gen-11-thinkpro-01.png', 'https://imagor.owtg.one/unsafe/fit-in/1760x990/https://d28jzcg6y4v9j1.cloudfront.net/media/core/products/2022/12/23/lenovo-thinkpad-x1-carbon-gen-11-thinkpro-05.png', 'https://imagor.owtg.one/unsafe/fit-in/1760x990/https://d28jzcg6y4v9j1.cloudfront.net/media/core/products/2022/12/23/lenovo-thinkpad-x1-carbon-gen-11-thinkpro-02.png'
, 'Black', 'i7 1355U, 16GB, 512GB, FHD+', 1, 2, 1),
('Lenovo ThinkPad X1 Carbon Gen 11', 26790000, 14, 'https://imagor.owtg.one/unsafe/fit-in/1760x990/https://d28jzcg6y4v9j1.cloudfront.net/media/core/products/2022/12/23/lenovo-thinkpad-x1-carbon-gen-11-thinkpro-01.png', 'https://imagor.owtg.one/unsafe/fit-in/1760x990/https://d28jzcg6y4v9j1.cloudfront.net/media/core/products/2022/12/23/lenovo-thinkpad-x1-carbon-gen-11-thinkpro-05.png', 'https://imagor.owtg.one/unsafe/fit-in/1760x990/https://d28jzcg6y4v9j1.cloudfront.net/media/core/products/2022/12/23/lenovo-thinkpad-x1-carbon-gen-11-thinkpro-02.png'
, 'Black', 'i7 1370P, 64GB, 512GB, 2.8K OLED', 1, 2, 1),
('Lenovo ThinkPad X1 Carbon Gen 11', 26790000, 14, 'https://imagor.owtg.one/unsafe/fit-in/1760x990/https://d28jzcg6y4v9j1.cloudfront.net/media/core/products/2022/12/23/lenovo-thinkpad-x1-carbon-gen-11-thinkpro-01.png', 'https://imagor.owtg.one/unsafe/fit-in/1760x990/https://d28jzcg6y4v9j1.cloudfront.net/media/core/products/2022/12/23/lenovo-thinkpad-x1-carbon-gen-11-thinkpro-05.png', 'https://imagor.owtg.one/unsafe/fit-in/1760x990/https://d28jzcg6y4v9j1.cloudfront.net/media/core/products/2022/12/23/lenovo-thinkpad-x1-carbon-gen-11-thinkpro-02.png'
, 'Black', 'i7 1355U, 32GB, 512GB, FHD+', 1, 2, 1)
--Bàn phím
('Bàn phím cơ AKKO 5098B (Akko V3 Piano Pro Switch', 1990000, 12, 'https://i.postimg.cc/T31PtJd4/ban-phim-akko-5098b-1.png', 'https://i.postimg.cc/MpLpNfXK/ban-phim-akko-5098b-2.png', 'https://i.postimg.cc/nLQhJVQK/ban-phim-akko-5098b-3.png'
, 'Black Gold', 'Akko V3 Piano Pro Switch', 4, 9, NULL),
('Bàn phím cơ AKKO 5098B (Akko V3 Piano Pro Switch', 2190000, 12, 'https://i.postimg.cc/PqHRt2C6/ban-phim-akko-5098b-waste-1.png', 'https://i.postimg.cc/wBkb3LJ9/ban-phim-akko-5098b-waste-2.png', 'https://i.postimg.cc/QtxY7Ck1/ban-phim-akko-5098b-waste-3.png'
, 'Wasteland Survival', 'Akko V3 Piano Pro Switch', 4, 9, NULL),
('Bàn phím cơ AKKO 5098B (Akko V3 Piano Pro Switch', 1990000, 12, 'https://i.postimg.cc/CLytPhFT/ban-phim-akko-5098b-undefined-b4-E.jpg', 'https://i.postimg.cc/xTKZBwCk/ban-phim-akko-5098b-undefined-e88.jpg', 'https://i.postimg.cc/QdhzDf9f/ban-phim-akko-5098b-undefined-Lx-Q.jpg'
, 'Prunus Lannesian', 'Akko V3 Piano Pro Switch', 4, 9, NULL)

---Product_Attribute---
INSERT INTO Product_Attribute (Product_Id, Attribute_Id, Attribute_Value) VALUES
--laptop 1
(1, 2, N'Intel Core i7 13620H'),
(1, 3, N'2.4GHz , Lên tới 4.9GHz'),
(1, 4, N'24MB'),
(1, 6, N'Intel UHD Graphics'),
(1, 7, N'Nvidia GeForce RTX 4060 8GB'),
(1, 9, N'16GB DDR4 3200MHz'),
(1, 10, N'48GB (Có thể nâng cấp)'),
(1, 12, N'512 GB (M.2 NVMe)'),
(1, 14, N'16inches, 2560 x 1600px, 240Hz'),
(1, 15, N'Tỉ lệ 16:10, IPS, 500Nits, 100% sRGB'),
(1, 17, N'90WHr'),
(1, 19, N'2 x USB Type C, 2 x USB Type A, 1x HDMI 2.1 FRL, 1 x Jack tai nghe 3.5mm, 1 x RJ45'),
(1, 20, N'1 khe micro SD'),
(1, 22, N'Wi-Fi 6E'),
(1, 23, N'5.3'),
(1, 25, N'Windows 11'),
--laptop 2
(9, 2, N'Intel Core i7 1355U'),
(9, 3, N'1.0GHz , Lên tới 4.6GHz'),
(9, 4, N'12MB'),
(9, 6, N'Intel Iris Xe Graphics'),
(9, 7, N'Không'),
(9, 9, N'16GB LPDDR5 6400MHz'),
(9, 10, N'16GB (Không thể nâng cấp)'),
(9, 12, N'512 GB (M.2 NVMe)'),
(9, 14, N'14inches, 1920 x 1200px, 60Hz'),
(9, 15, N'Tỉ lệ 16:10, IPS, 400Nits, 100% sRGB'),
(9, 17, N'57WHr Li-Polymer'),
(9, 19, N'2 x USB Type C, 1 x USB Type A, 1 x HDMI, Jack tai nghe 3.5mm'),
(9, 20, N'Không khe thẻ SD, Không khe micro SD'),
(9, 22, N'Có hỗ trợ'),
(9, 23, N'Có hỗ trợ'),
(9, 25, N'Windows 11'),

SELECT * FROM Product_Type
SELECT * FROM Product_Type_Filter
SELECT * FROM Filter_Category
SELECT * FROM Product
SELECT * FROM Attribute
SELECT * FROM Product_Attribute
SELECT * FROM Brand
SELECT * FROM Series

SELECT * FROM Product
WHERE Price >= 20000000 AND Price < 41000000

Select * from Account a 
join User_ u on a.UserName = u.UserName
join Role_ r on a.Role_Id = r.Role_Id

SELECT * FROM Product p JOIN Product_Attribute pa ON p.Product_Id = pa.Product_Id
						JOIN Attribute a ON pa.Attribute_Id = a.Attribute_Id
						WHERE p.Product_Id = 1;

SELECT * FROM Attribute join Product_Type on Attribute.Type_Id_ = Product_Type.Type_Id_
WHERE Attribute.Type_Id_ = Product_Type.Type_Id_

SELECT Product_Attribute.Attribute_Id, Product_Attribute.Product_Id, Product_Attribute.Attribute_Value
FROM Product_Attribute join Product on Product_Attribute.Product_Id = Product.Product_Id
WHERE Product_Attribute.Product_Id = Product.Product_Id

SELECT Product.Version_
FROM Product
WHERE Product.Product_Name = 'Lenovo ThinkPad X1 Carbon Gen 11'

DROP TABLE Filter_Category

ALTER TABLE Product ALTER COLUMN Product_Name NVARCHAR(50);
ALTER TABLE Product_Attribute ALTER COLUMN Attribute_Value NVARCHAR(max);
Delete from Product_Attribute
Delete from Product
USE master
DROP DATABASE Chill_Computer