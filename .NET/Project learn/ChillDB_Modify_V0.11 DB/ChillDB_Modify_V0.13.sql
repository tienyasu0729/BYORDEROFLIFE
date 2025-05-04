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
	Phone VARCHAR(10) UNIQUE NOT NULL,
	Address_ NVARCHAR(50) NOT NULL,
	UserName VARCHAR(20) NOT NULL,
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
	img1 VARCHAR(max) NULL,
	img2 VARCHAR(max) NULL,
	img3 VARCHAR(max) NULL,
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
	Attribute_Value NVARCHAR(max) NULL,
	FOREIGN KEY (Product_Id) REFERENCES Product(Product_Id),
	FOREIGN KEY (Attribute_Id) REFERENCES Attribute(Attribute_Id)
)

CREATE TABLE Product_Type_Filter
(
	Filter_Id INT IDENTITY(1,1) PRIMARY KEY,
	Filter_Name NVARCHAR(50) NOT NULL,
	Filter_Tag NVARCHAR(50) NULL,
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
(N'Asus'), --1
(N'Lenovo'), --2
(N'Dell'), --3
(N'Acer'), --4
(N'HP'), --5
(N'MSI'), --6
(N'Razer'), --7
(N'LG'), --8
(N'Akko'), --9
(N'FL-Esports'), --10
(N'AULA'), --11
(N'Corsair'), --12
(N'Dareu'), --13
(N'Logitech'), --14
(N'E-Dra'), --15
(N'Rapoo'), --16
(N'Steelseries') --17

INSERT INTO Series(Brand_Id, Series_Name) VALUES
(1, 'Vivobook'), --1
(1, 'Zenbook'), --2
(1, 'TUF Gaming'), --3
(1, 'ROG Gaming'), --4
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
(8, 'Gram') --26

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

INSERT INTO Product_Type_Filter (Filter_Name, Filter_Tag, Type_Id_) VALUES 
--Laptop
(N'Thương hiệu', N'Thương hiệu' , 1), --1
(N'Nhu Cầu', N'Phù hợp', 1), --2   
(N'CPU', N'CPU' , 1), --3
(N'Card đồ họa', N'Card', 1), --4
(N'Khoảng giá', N'Giá', 1), --5
(N'Dung lượng RAM', N'RAM', 1), --6
(N'Dung lượng SSD', N'SSD', 1), --7
(N'Kích thước màn hình', N'Kích thước', 1), --8
(N'Tần số quét', N'Tần số quét', 1), --9
(N'Độ phân giải', N'Độ phân giải', 1), --10
--Tai nghe
(N'Thương hiệu tai nghe', N'Thương hiệu', 2), --11
(N'Tai nghe theo giá', N'Giá', 2), --12
--Chuột
(N'Thương hiệu chuột', N'THương hiệu', 3), --13
(N'Chuột theo giá', N'Giá', 3), --14
--Bàn phím
(N'Thương hiệu bàn phím', N'Thương hiệu', 4), --15
(N'Bàn phím theo giá', N'Giá', 4),  --16
--Màn hình
(N'Thương hiệu', N'Thương hiệu', 5), --17
(N'Giá tiền', N'Giá', 5), --18
(N'Kích thước màn hình', N'Kích thước', 5), --19
(N'Tần số quét', N'Tần số quét', 5), --20
(N'Độ phân giải', N'Độ phân giải', 5), --21
--Main
(N'Thương hiệu main', N'Thương hiệu', 6), --22
(N'Chipset', N'Chipset', 6), --23
(N'Kích thước', N'Kích thước', 6), --24
(N'Loại RAM', N'RAM', 6), --25
(N'Socket', N'Socket', 6), --26
--CPU 
(N'Thương hiệu CPU', N'Thương hiệu', 7), --27
(N'Dòng CPU', N'Dòng CPU', 7), --28
(N'Socket', N'Socket', 7), --29
--VGA - Card màn hình
(N'Thương hiệu VGA', N'Thương hiệu', 8), --30 
(N'Khoảng giá', N'Giá', 8), --31
(N'Nhân đồ họa', N'Nhân đồ họa', 8), --32
(N'Dòng VGA', N'Dòng VGA', 8), --33
--RAM
(N'Thương hiệu RAM', N'Thương hiệu', 9), --34
(N'Bus RAM', N'Bus', 9), --35
(N'Dung lượng', N'Dung lượng', 9), --37
(N'Loại RAM', N'Loại', 9), --38
--SSD
(N'Thương hiệu SSD', N'Thương hiệu', 10), --39
(N'Giá tiền', N'Giá', 10), --40
(N'Dung lượng', N'Dung lượng', 10), --41
(N'Loại SSD', N'Loại', 10), --42
--HDD
(N'Thương hiệu HDD', N'Thương hiệu', 11), --43
(N'Giá tiền', N'Giá', 11), --44
(N'Dung lượng', N'Dung lượng', 11), --45
--Case
(N'Thương hiệu case', N'Thương hiệu', 12), --46
(N'Giá tiền', N'Giá', 12), --47
(N'Hỗ trợ main', N'Hỗ trợ', 12), --48
(N'Kích cỡ', N'Kích cỡ', 12), --49
(N'Màu sắc', N'Màu', 12), --50
--Nguồn
(N'Thương hiệu nguồn', N'Thương hiệu', 13), --51
(N'Công suất', N'Công suất', 13), --52
--Tản nhiệt
(N'Thương hiệu tản nhiệt', N'Thương hiệu', 14), --53
(N'Giá tiền', N'Giá', 14), --54
(N'Màu sắc', N'Màu', 14), --55
(N'Kích thước', N'Kích thước', 14), --56
(N'Loại tản nhiệt', N'Loại', 14); --57
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
(N'AMD Radeon', NULL, 4), --25
(N'NVIDIA', NULL, 4), --26
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
(N'64 GB', NULL, 6), --40
(N'256 GB', NULL, 7), --41
(N'512 GB', NULL, 7), --42
(N'1 TB', NULL, 7), --43
(N'13 Inches', NULL, 8), --43
(N'14 Inches', NULL, 8), --44
(N'15 Inches', NULL, 8), --45
(N'Từ 16 Inches trở lên', NULL, 8), --46
(N'60Hz', NULL, 9), --47
(N'120Hz', NULL, 9), --48
(N'144Hz', NULL, 9), --49
(N'165Hz', NULL, 9), --50
(N'240Hz', NULL, 9), --51
(N'FHD', NULL, 10), --52
(N'2K', NULL, 10), --53
(N'4K', NULL, 10), --54
--Tai nghe
(N'Asus', NULL, 11), --55
(N'Hyper X', NULL, 11), --56
(N'Corsair', NULL, 11), --57
(N'Razer', NULL, 11), --58
(N'Logitech', NULL, 11), -- 59
(N'Steelseries', NULL, 11), --60
(N'Dưới 1 triệu', NULL, 12), --61
(N'Từ 1 - 2 triệu', NULL, 12), --62
(N'Từ 2 - 3 triệu', NULL, 12), --63
(N'Từ 3 - 4 triệu', NULL, 12), --64
(N'Trên 4 triệu', NULL, 12), --65
--Chuột
(N'Asus' , NULL, 13), --66
(N'Logitech', NULL, 13), --67
(N'Corsair', NULL, 13), --68
(N'Razer', NULL, 13), --69
(N'Dareu', NULL, 13), --70
(N'Steelseries', NULL, 13), --71
(N'Rapoo', NULL, 13), --72
(N'Dưới 500 nghìn',NULL, 14), --73
(N'Từ 500 nghìn - 1 triệu',NULL, 14), --74
(N'Từ 1 - 2 triệu',NULL, 14), --75
(N'Từ 2 - 3 triệu',NULL, 14), --76
(N'Trên 3 triệu',NULL, 14), --77
--Bàn phím
(N'Asus',NULL, 15), --78
(N'Akko',NULL, 15), --79
(N'AULA',NULL, 15), --80
(N'FL-Esports',NULL, 15), --81
(N'Corsair',NULL, 15), --82
(N'Dareu',NULL, 15), --83
(N'Logitech',NULL, 15), --84
(N'E-Dra',NULL, 15), --85
(N'Razer',NULL, 15), --86
(N'Rapoo',NULL, 15), --87
(N'Steelseries',NULL, 15), --88
(N'Dưới 1 triệu',NULL, 16), --89
(N'Từ 1 - 2 triệu',NULL, 16), --90
(N'Từ 2 - 3 triệu',NULL, 16), --91
(N'Từ 3 - 4 triệu',NULL, 16), --92
(N'Trên 4 triệu',NULL, 16), --93
--Màn hình
(N'LG',NULL, 17), --94
(N'MSI',NULL, 17), --95
(N'Asus',NULL, 17), --96
(N'Lenovo',NULL, 17), --97
(N'ViewSonic',NULL, 17), --98
(N'Samsung',NULL, 17), --99
(N'Dell',NULL, 17), --100
(N'E-Dra',NULL, 17), --101
(N'Acer',NULL, 17), --102
(N'Gigabyte',NULL, 17), --103
(N'HKC',NULL, 17), --104
(N'Philips',NULL, 17), --105
(N'Dưới 5 triệu',NULL, 18), --106
(N'Từ 5 - 10 triệu',NULL, 18), --107
(N'Từ 10 - 20 triệu',NULL, 18), --108
(N'Từ 20 - 30 triệu',NULL, 18), --109
(N'Trên 30 triệu',NULL, 18), --110
(N'22Inch',NULL, 19), --111
(N'24Inch',NULL, 19), --112
(N'25Inch',NULL, 19), --113
(N'27Inch',NULL, 19), --114
(N'29Inch',NULL, 19), --115
(N'32Inch',NULL, 19), --116
(N'38Inch',NULL, 19), --117
(N'45Inch',NULL, 19), --118
(N'60Hz',NULL, 20), --119
(N'75Hz',NULL, 20), --120
(N'100Hz',NULL, 20), --121
(N'120Hz',NULL, 20), --122
(N'144Hz',NULL, 20), --123
(N'165Hz',NULL, 20), --124
(N'240Hz',NULL, 20), --125
(N'280Hz',NULL, 20), --126
(N'300Hz',NULL, 20), --127
(N'360Hz',NULL, 20), --128
(N'380Hz',NULL, 20), --129
(N'480Hz',NULL, 20), --130
(N'540Hz',NULL, 20), --131
(N'FHD',NULL, 21), --132
(N'2K',NULL, 21), --133
(N'4K',NULL, 21), --134
--Main
(N'ASRock' ,NULL, 22), --135
(N'Asus',NULL, 22), --136
(N'Colorful',NULL, 22), --137
(N'Gigabyte',NULL, 22), --138
(N'MSI',NULL, 22), --139
(N'AMD A450',NULL, 23), --140
(N'AMD B550',NULL, 23), --141
(N'AMD B650',NULL, 23), --142
(N'AMD TRX40',NULL, 23), --143
(N'AMD TRX40 (sTR4)',NULL, 23), --144
(N'AMD TRX50',NULL, 23), --145
(N'AMD X570',NULL, 23), --146
(N'AMD X670',NULL, 23), --147
(N'AMD X870',NULL, 23), --148
(N'Intel B560',NULL, 23), --149
(N'Intel B660',NULL, 23), --150
(N'Intel B760',NULL, 23), --151
(N'Intel H510',NULL, 23), --152
(N'Intel H610',NULL, 23), --153
(N'Intel Z690',NULL, 23), --154
(N'Intel Z790',NULL, 23), --155
(N'Intel Z890',NULL, 23), --156
(N'ATX',NULL, 24), --157
(N'E-ATX',NULL, 24), --158
(N'Mini-ITX',NULL, 24), --159
(N'mATX',NULL, 24), --160
(N'DDR4',NULL, 25), --161
(N'DDR5',NULL, 25), --162
(N'AM4',NULL, 26), --163
(N'AM5',NULL, 26), --164
(N'AMD sTR4',NULL, 26), --165
(N'LGA 1200',NULL, 26), --166
(N'LGA 1700',NULL, 26), --167
(N'LGA 1851',NULL, 26), --168
(N'sTR5',NULL, 26), --169
(N'sTRX4',NULL, 26), --170
--CPU
(N'Intel',NULL, 27), --172
(N'AMD',NULL, 27), --173
(N'Core i3', 172, 28), --173
(N'Ryzen 3', 173, 28), --177
(N'Core i5', 172, 28), --174
(N'Ryzen 5', 173, 28), --178
(N'Core i7', 172, 28), --175
(N'Ryzen 7', 173, 28), --179
(N'Core i9', 172, 28), --176
(N'Ryzen 9', 173, 28), --180
(N'AM4',NULL, 29), --181
(N'AM5',NULL, 29), --182
(N'LGA 1200',NULL, 29), --183
(N'LGA 1700',NULL, 29), --184
(N'LGA 1851',NULL, 29), --185
(N'sTR5',NULL, 29), --186
(N'sWRX8',NULL, 29), --187
--VGA - Card đồ họa
(N'Asus',NULL, 30), --188
(N'Gigabyte',NULL, 30), --189
(N'MSI',NULL, 30), --190
(N'Từ 5 - 10 triệu',NULL, 31), --191
(N'Từ 10 - 20 triệu',NULL, 31), --192
(N'Từ 20 - 30 triệu',NULL, 31), --193
(N'Từ 30 - 40 triệu',NULL, 31), --194
(N'Trên 40 triệu',NULL, 31), --195
(N'NVIDIA',NULL, 32), --196
(N'AMD', NULL, 32), --197
(N'RTX 3050', 188, 33), --198
(N'RTX 3060', 188, 33), --199
(N'RTX 4060', 188, 33), --200
(N'RTX 4060Ti', 188, 33), --201
(N'RTX 4070 Super', 188, 33), --202
(N'RTX 4070 Ti Super', 188, 33), --203
(N'RTX 4080 Super', 188, 33), --204
(N'RTX 5090', 188, 33), --205
(N'RX 6600', 189, 33), --206
(N'RX 6500 XT', 189, 33), --207
--RAM
(N'Adata',NULL, 34), --208
(N'Corsair',NULL, 34), --209
(N'G.Skill',NULL, 34), --210
(N'GIGABYTE',NULL, 34), --211
(N'Kingston',NULL, 34), --212
(N'PNY',NULL, 34), --213
(N'Patriot',NULL, 34), --214
(N'Team Group',NULL, 34), --215
(N'V-Color',NULL, 34), --216
(N'3200MHz',NULL, 35), --217
(N'3600MHz',NULL, 35), --218
(N'5200MHz',NULL, 35), --219 
(N'5600MHz',NULL, 35), --220 
(N'6000MHz',NULL, 35), --221
(N'6200MHz',NULL, 35), --222
(N'8 GB', NULL, 36), --223
(N'16 GB', NULL, 36), --224
(N'32 GB', NULL, 36), --225
(N'64 GB', NULL, 36), --226
(N'DDR4', NULL, 37), --227
(N'DDR5', NULL, 37), --228
--SSD
(N'Kingston', NULL, 38), --229
(N'Samsung', NULL, 38), --230
(N'Western Digital', NULL, 38), --231
(N'Dưới 1 triệu', NULL, 39), --232
(N'Từ 1 - 2 triệu', NULL, 39), --233
(N'Từ 2 - 3 triệu', NULL, 39), --234
(N'Trên 3 triệu', NULL, 39), --235
(N'240 - 256 GB', NULL, 40), --236
(N'480 - 512 GB', NULL, 40) ,--237
(N'960 - 1 TB', NULL, 40), --238
(N'Trên 2 TB', NULL, 40), --249
(N'M.2 PCIe 3.0', NULL, 41), --240
(N'M.2 PCIe 4.0', NULL, 41), --241
(N'M.2 PCIe 5.0', NULL, 41), --242
(N'M.2  SATA', NULL, 41), --243
(N'Sata 3 (2.5 inch)', NULL, 41), --244
--HDD
(N'Seagate', NULL, 42), --245
(N'Western Digital', NULL, 42), --246
(N'Dưới 1 triệu', NULL, 43), --247
(N'Từ 1 - 2 triệu', NULL, 43), --248
(N'Từ 2 - 3 triệu', NULL, 43), --249
(N'Trên 3 triệu', NULL, 43), --250
(N'1 TB', NULL, 44), --251
(N'10 TB', NULL, 44), --252
(N'2 TB', NULL, 44), --253
(N'4 TB', NULL, 44), --254
(N'6 TB', NULL, 44), --255
--Case
(N'Xigmatek', NULL, 45), --256
(N'Cooler Master', NULL, 45), --257
(N'Asus', NULL, 45), --258
(N'Corsair', NULL, 45), --259
(N'MSI', NULL, 45), --260
(N'Dưới 1 triệu', NULL, 46), --261
(N'Từ 1 - 2 triệu', NULL, 46), --262
(N'Từ 2 - 3 triệu', NULL, 46), --263
(N'Từ 3 - 5 triệu', NULL, 46), --264
(N'Trên 5 triệu', NULL, 46), --265
(N'ATX', NULL, 47), --266
(N'Mini-ITX', NULL, 47), --267
(N'Mid Tower', NULL, 48), --268
(N'Mini Tower', NULL, 48), --269
(N'Đen', NULL, 49), --270
(N'Trắng', NULL, 49), --271
--Nguồn 
(N'Asus', NULL, 50), --272
(N'Cooler Master', NULL, 50), --273
(N'Corsair', NULL, 50), --274
(N'Deepcool', NULL, 50), --275
(N'Gigabyte', NULL, 50), --276
(N'MSI', NULL, 50), --277
(N'Từ 400w - 500w', NULL, 51), --278
(N'Từ 500w - 600w', NULL, 51), --279
(N'Từ 700w - 800w', NULL, 51), --280
(N'Trên 800w', NULL, 51), --281
--Tản nhiệt
(N'Asus', NULL, 52), --282
(N'Cooler Master', NULL, 52), --283
(N'Corsair', NULL, 52), --284
(N'Deepcool', NULL, 52), --285
(N'MSI', NULL, 52), --286
(N'Dưới 1 triệu', NULL, 53), --287
(N'Từ 1 - 2 triệu', NULL, 53), --288
(N'Từ 2 - 3 triệu', NULL, 53), --289
(N'Từ 3 - 5 triệu', NULL, 53), --290
(N'Trên 5 triệu', NULL, 53), --291
(N'Đen', NULL, 54), --292
(N'Trắng', NULL, 54), --293
(N'140mm', NULL, 55), --294
(N'240mm', NULL, 55), --295
(N'280mm', NULL, 55), --296
(N'360mm', NULL, 55), --297
(N'4200mm', NULL, 55), --298
(N'Tản nhiệt khí', NULL, 56), --299
(N'Tản nhiệt nước', NULL, 56); --300
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
--Laptop
(N'Thương hiệu', 1, NULL), --1
(N'Thương hiệu', 1, 1), --2
(N'Bộ xử lý', 1 , NULL),   --3
(N'Loại CPU', 1, 3), --4
(N'Tốc độ', 1, 3), --5
(N'Bộ nhớ đệm', 1, 3), --6
(N'Card đồ họa', 1, NULL ), --7
(N'Card onboard', 1 , 7),     --8
(N'Card rời', 1, 7), --9
(N'RAM', 1, NULL), --10
(N'Dung lượng RAM', 1, 10), --11
(N'Hỗ trợ tối đa', 1, 10), --12
(N'Ô cứng', 1, NULL), --13
(N'Dung lượng SSD', 1, 13), --14
(N'Màn hình', 1, NULL), --15
(N'Kích thước màn hình', 1, 15), --16
(N'Độ phân giải', 1, 15), --17
(N'Tần số quét', 1, 15), --18
(N'Thông số khác', 1, 15), --19
(N'Pin', 1, NULL), --20
(N'Dung lượng pin', 1, 20), --21
(N'Cổng kết nối', 1, NULL), --22
(N'Cổng kết nối', 1, 22), --23
(N'Khe thẻ SD/ Micro SD', 1, 22), --24
(N'Kết nối', 1, NULL), --25
(N'Wifi', 1, 25), --26
(N'Bluetooth', 1, 25), --27
(N'Hệ điều hành', 1, NULL), --28
(N'Hệ điều hành', 1, 28), --29
(N'Nhu cầu sử dụng', 1, NULL), --30
(N'Phù hợp để', 1, 30), --31
--Bàn phím
(N'Switch', 4, NULL), --32
(N'Loại switch', 4, 32),--33
(N'Đặc điểm', 4, NULL),--34
(N'Kết nối qua', 4, 34),--35
(N'Chất liệu khung', 4, 34),--36
(N'Số nút bấm', 4, 34),--37
(N'Loại bàn phím', 4, 34),--38
(N'Layout', 4, 34),--39
(N'Tương thích', 4, 34),--40
(N'Đèn led', 4, 34),--41
(N'Keycap', 4, 34),--42
(N'Khối lượng', 4, NULL),--43
(N'Khối lượng', 4, 43),--44
(N'Pin', 4, NULL),--45
(N'Thời lượng pin', 4, 45),--46
(N'Kích thước', 4, NULL),--47
(N'Chiều dài', 4, 47),--48
(N'Chiều rộng', 4, 47),--49
(N'Chiều cao', 4, 47),--50
--Chuột
(N'Thiết kế và Kích thước', 3, NULL), --51
(N'Thiết kế', 3, 51), --52
(N'Số nút bấm', 3, 51), --53
(N'Chiều dài', 3, 51), --54
(N'Chiều rộng', 3, 51), --55
(N'Chiều cao', 3, 51), --56
(N'Loại chuột', 3, 51), --57
(N'Thông số cơ bản', 3, NULL), --58
(N'Loại kết nối', 3, 58), --59
(N'Kết nối qua', 3, 58), --60
(N'Đèn LED', 3, 58), --61
(N'Tương thích', 3, 58), --62
(N'DPI', 3, 58), --63
--Tai nghe
(N'Thông số cơ bản', 2, NULL), --64
(N'Loại kết nối', 2, 64), --65
(N'Thời lượng pin', 2, 64), --66
--Màn hình
(N'Thông số cơ bản', 5, NULL), --67
(N'Cổng kết nối', 5, 67), --68
(N'Thời gian phản hồi', 5, 67), --69
(N'Tấm nền', 5, 67), --70
(N'Kích thước', 5, 67), --71
(N'Kiểu màn hình', 5, 67), --72
(N'Độ phủ màu', 5, 67), --73
(N'Tương thích VESA', 5, 67), --74
(N'Khử nhấp nháy', 5, 67), --75
(N'Độ sáng', 5, 67), --76
(N'Tần số quét', 5, 67), --77
(N'Độ phân giải', 5, 67), --78
(N'Phụ kiện', 5, NULL), --79
(N'Phụ kiện trong hộp', 5, 79), --80
--Main
(N'Thông số kỹ thuật', 6, NULL), --81
(N'CPU', 6, 81), --82
(N'Chipset', 6, 81), --83
(N'Bộ nhớ', 6, 81), --84
(N'Đồ họa tích hợp', 6, 81), --85
(N'Âm thanh', 6, 81), --86
(N'LAN', 6, 81), --87
(N'Wireless', 6, 81), --88
(N'Khe cắm mở rộng', 6, 81), --89
(N'Giao diện lưu trữ', 6, 81), --90
(N'USB', 6, 81), --91
(N'Kết nối I/O ', 6, 81), --92
(N'Kết nối mặt sau', 6, 81), --93
(N'Điều khiển I/O', 6, 81), --94
(N'Giám sát hệ thống', 6, 81), --95
(N'BIOS', 6, 81), --96
(N'Tính năng đặc biệt', 6, 81), --97
(N'Phần mềm đi kèm', 6, 81), --98
(N'Hệ điều hành', 6, 81), --99
(N'Kích thước', 6, 81), --100
--CPU Intel
(N'Thông số kỹ thuật', 7, NULL), --101
(N'Socket', 7, 101), --102
(N'Dòng CPU', 7, 101), --103
(N'CPU', 7, 101), --104
(N'Số nhân', 7, 101), --105
(N'Số luồng', 7, 101), --106
(N'Tốc độ Turbo tối đa của P-core', 7, 101), --107
(N'Tốc độ Turbo tối đa của E-core ', 7, 101), --108
(N'Tốc độ cơ bản của P-core', 7, 101), --109
(N'Tốc độ cơ bản của E-core', 7, 101), --110
(N'Điện năng tiêu thụ', 7, 101), --111
(N'Bộ nhớ đệm', 7, 101), --112
(N'Bo mạch chủ tương thích', 7, 101), --113
(N'Bộ nhớ hỗ trợ tối đa', 7, 101), --114
(N'Loại bộ nhớ', 7, 101), --115
(N'Nhân đồ họa tích hợp', 7, 101), --116
(N'Phiên bản PCI Express', 7, 101), --117
(N'Số lượng PCIe lanes', 7, 101), --118
--CPU AMD
(N'Thông số kỹ thuật', 7, NULL), --119
(N'Socket', 7 , 119), --120
(N'Số nhân', 7 , 119), --121
(N'Số luồng', 7 , 119), --122
(N'Tốc độ xử lý', 7 , 119), --123
(N'Bộ nhớ đệm L1', 7 , 119), --124
(N'Bộ nhớ đệm L2', 7 , 119), --125
(N'Bộ nhớ đệm L3', 7 , 119), --126
(N'Công nghệ xử lý cho lõi CPU', 7 , 119), --127
(N'Phiên bản PCI Express ', 7 , 119), --128
(N'Giải pháp tản nhiệt (PIB)', 7 , 119), --129
(N'Điện năng tiêu thụ mặc định', 7 , 119), --130
(N'Bộ nhớ hỗ trợ', 7 , 119), --131
(N'Tính năng đồ họa', 7 , 119), --132
(N'Công nghệ hỗ trợ', 7 , 119), --133
--VGA - Card màn hình
(N'Thông số kỹ thuật', 8, NULL), --134
(N'Hãng sản xuất', 8, 134), --135
(N'Nhân đồ họa', 8, 134), --136
(N'Chuẩn giao tiếp', 8, 134), --137
(N'Xung nhịp', 8, 134), --138
(N'Số nhân CUDA', 8, 134), --139
(N'Tốc độ bộ nhớ', 8, 134), --140
(N'Dung lượng bộ nhớ', 8, 134), --141
(N'Giao diện bộ nhớ', 8, 134), --142
(N'Cổng xuất hình', 8, 134), --143
(N'Đầu cắm nguồn', 8, 134), --144
(N'Nguồn đề xuất', 8, 134), --145
(N'Kích thước', 8, 134), --146
(N'Open GL', 8, 134), --147
(N'Đa màn hình', 8, 134), --148
(N'Độ phân giải tối đa', 8, 134), --149
--RAM
(N'Thông số kỹ thuật', 9, NULL), --150
(N'Hãng sản xuất', 9, 150), --151
(N'Chuẩn RAM', 9, 150), --152
(N'Bus', 9, 150), --153
(N'Dung lượng', 9, 150), --154
--SSD
(N'Thông số kỹ thuật', 10, NULL), --155
(N'Dung lượng', 10, 155), --156
(N'Chuẩn giao tiếp', 10, 155), --157
(N'Kích thước', 10, 155), --158
(N'Tốc độ đọc', 10, 155), --159
(N'Tốc độ ghi', 10, 155), --160
(N'Độ bền(TBW)', 10, 155), --161
--HDD
(N'Thông số kỹ thuật', 11, NULL), --162
(N'Chuẩn giao tiếp', 11, 162), --163
(N'Dung lượng', 11, 162), --164
(N'Kích thước', 11, 162), --165
(N'Tốc độ đọc', 11, 162), --166
(N'Tốc độ ghi', 11, 162), --167
(N'Tốc độ quay', 11, 162), --168
--Case
(N'Thông số kỹ thuật', 12, NULL), --169
(N'Loại case', 12, 169), --170
(N'Kích thước', 12, 169), --171
(N'Cân nặng', 12, 169), --172
(N'Chất liệu', 12, 169), --173
(N'Màu', 12, 169), --174
(N'Mainboard hỗ trợ', 12, 169), --175
(N'Khe cắm mở rộng', 12, 169), --176
(N'Khay ổ cứng', 12, 169), --177
(N'Cổng giao tiếp bên ngoài', 12, 169), --178
(N'Chuẩn nguồn', 12, 169), --179
(N'Chiều dài VGA tối đa', 12, 169), --180
(N'Chiều cao tản nhiệt CPU tối đa', 12, 169), --181
(N'Quạt gắn sẵn', 12, 169), --182
(N'Hỗ trợ quạt', 12, 169), --183
(N'Tản nhiệt nước tương thích', 12, 169), --184
--Nguồn
(N'Thông số kỹ thuật', 13, NULL), --185
(N'Công suất', 13, 185), --186
(N'Hiệu suất', 13, 185), --187
(N'Cáp rời', 13, 185), --188
(N'Kích thước quạt tản nhiệt', 13, 185), --189
(N'Vòng bi quạt', 13, 185), --190
(N'Kích thước nguồn', 13, 185), --191
(N'Loại PFC', 13, 185), --192
(N'Điện áp đầu vào', 13, 185), --193
(N'Tần số đầu vào', 13, 185), --194
(N'Chứng chỉ bảo vệ', 13, 185), --195
(N'Cổng kết nối', 13, 185), --196
--Tản nhiệt
(N'Thông số kỹ thuật', 14, NULL) --197
GO

USE Chill_Computer
SELECT * FROM Product_Type
SELECT * FROM Product_Type_Filter
SELECT * FROM Filter_Category
SELECT * FROM Product
SELECT * FROM Brand
ORDER BY Brand_Id
SELECT * FROM Series
SELECT * FROM Attribute
SELECT * FROM Product_Attribute


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

SELECT DISTINCT Product_Name, Product_Attribute.Product_Id, Product_Attribute.Attribute_Value, Attribute.Attribute_Name
FROM Product_Attribute join Product on Product_Attribute.Product_Id = Product.Product_Id
	join Attribute on Product_Attribute.Attribute_Id = Attribute.Attribute_Id
	join Product_Type on Attribute.Type_Id_ = Product_Type.Type_Id_
	join Product_Type_Filter on Product_Type.Type_Id_ = Product_Type_Filter.Type_Id_
	join Filter_Category on Product_Type_Filter.Filter_Id = Filter_Category.Filter_Id
WHERE Attribute.Attribute_Name LIKE N'%CPU%' AND Product_Attribute.Attribute_Value LIKE '%AMD%'

SELECT * FROM

SELECT * FROM Product
WHERE Product.Product_Name = 'Lenovo ThinkPad X1 Carbon Gen 11' AND Product.Version_ = 'i7 1355U, 32GB, 512GB, FHD+'

SELECT DISTINCT Product.Product_Id, Product.Product_Name, Brand.Brand_Name
FROM Brand join Product on Brand.Brand_Id = Product.Brand_Id
	join Product_Attribute on Product.Product_Id = Product_Attribute.Product_Id
WHERE Product_Attribute.Attribute_Value LIKE '%Intel%' OR Brand_Name = 'Dell'

SELECT DISTINCT Product.Product_Id, Product.Product_Name
FROM Product join Product_Attribute on Product.Product_Id = Product_Attribute.Product_Id
WHERE Product_Attribute.Attribute_Value LIKE '%Intel%'

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