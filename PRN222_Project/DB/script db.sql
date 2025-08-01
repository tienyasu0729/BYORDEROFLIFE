-- Tạo database nếu chưa tồn tại (SQL Server không hỗ trợ IF NOT EXISTS trực tiếp trong CREATE DATABASE)
IF DB_ID('PawnShop') IS NULL
    CREATE DATABASE PawnShop;
GO
USE PawnShop;
GO
-- =================================================================
--                              Bảng User
-- =================================================================
-- Bảng này lưu trữ thông tin về người dùng/khách hàng.
CREATE TABLE [user] (
    [Id] INT PRIMARY KEY IDENTITY(1,1),
    [PhoneNumber] VARCHAR(20) UNIQUE not null,
    [Password] NVARCHAR(255),
    [Name] NVARCHAR(100),
    [Email] VARCHAR(255),
    [Sex] NVARCHAR(10),
    [DateOfBirth] DATE,
    [AvatarImage] NVARCHAR(MAX), -- Lưu URL hoặc đường dẫn file
    [Joining_date] DATETIME DEFAULT GETDATE()
);

-- =================================================================
--                              Bảng Shop
-- =================================================================
-- Bảng này lưu trữ thông tin về các cửa hàng cầm đồ.
CREATE TABLE [shop] (
    [Id] INT PRIMARY KEY IDENTITY(1,1),
    [PhoneNumber] VARCHAR(20) UNIQUE NOT NULL,
    [ShopName] NVARCHAR(255) NOT NULL,
	[ShopAddress] NVARCHAR(255) NOT NULL,
    [Email] VARCHAR(255) UNIQUE NOT NULL,
    [Password] NVARCHAR(255) NOT NULL, 
    [ShopAvatarImage] NVARCHAR(MAX), -- Lưu URL hoặc đường dẫn file
    [Status] bit not null
);

-- =================================================================
--                            Bảng Category
-- =================================================================
-- Bảng này dùng để phân loại sản phẩm, có hỗ trợ danh mục cha-con.
CREATE TABLE [category] (
    [Id] INT PRIMARY KEY IDENTITY(1,1),
    [CategoryName] NVARCHAR(255) NOT NULL,
    [ParentID] INT,
    -- Tạo ràng buộc khóa ngoại cho danh mục cha
    CONSTRAINT [FK_category_parent] FOREIGN KEY ([parentID]) REFERENCES [category]([Id])
);

-- =================================================================
--                             Bảng Product
-- =================================================================
-- Bảng này có thể được dùng như một danh mục các sản phẩm mẫu hoặc các sản phẩm đã được niêm yết.
CREATE TABLE [product] (
    [Id] INT PRIMARY KEY IDENTITY(1,1),
    [IdCategory] INT not null,
    [NameProduct] NVARCHAR(255) NOT NULL,
    [ProductDescription] NVARCHAR(MAX),
    [Condition] NVARCHAR(100),
    [OriginalPrice] int not null,
    [ImageFolder] NVARCHAR(MAX), -- Lưu URL hoặc đường dẫn file
    -- Tạo ràng buộc khóa ngoại tới bảng category
    CONSTRAINT [FK_product_category] FOREIGN KEY ([IdCategory]) REFERENCES [category]([Id])
);

-- =================================================================
--                            Bảng Pawn_Item
-- =================================================================
-- Bảng chính lưu trữ thông tin về các món đồ đang được cầm cố.
-- Khóa chính "id_product" trong sơ đồ có vẻ là lỗi. Đã đổi thành "id_pawn_item" để rõ ràng hơn.
CREATE TABLE [PawnItem] (
    [Id] INT PRIMARY KEY IDENTITY(1,1),
    [IdUser] INT NOT NULL,
    [IdShop] INT NOT NULL,
    [IdCategory] INT,
    [NameProduct] NVARCHAR(255) NOT NULL,
    [ProductDescription] NVARCHAR(MAX),
    [PawnPrice] int NOT NULL,
    [condition] NVARCHAR(100),
    [PawnDate] DATE NOT NULL,
    [PawnTime] int,
    [ImageFolder] NVARCHAR(MAX),
    -- Tạo các ràng buộc khóa ngoại
    CONSTRAINT [FK_Pawn_Item_user] FOREIGN KEY ([IdUser]) REFERENCES [user]([Id]),
    CONSTRAINT [FK_Pawn_Item_shop] FOREIGN KEY ([IdShop]) REFERENCES [shop]([Id]),
    CONSTRAINT [FK_Pawn_Item_category] FOREIGN KEY ([IdCategory]) REFERENCES [category]([Id])
);

-- =================================================================
--                          Bảng Pawn_History
-- =================================================================
-- Bảng này ghi lại lịch sử các giao dịch cho mỗi món đồ.
-- Tương tự, khóa chính "id_product" trong sơ đồ đã được đổi thành "id_pawn_history".
CREATE TABLE [Pawn_History] (
    [Id] INT PRIMARY KEY IDENTITY(1,1),
    [IdPawnItem] INT NOT NULL,
    [IdShop] INT NOT NULL,
    [NameProduct] NVARCHAR(255),
    [Condition] NVARCHAR(100),
    [PawnPrice] int not null,
    [PawnDate] DATE not null,
    [PawnTime] int,
    [PawnPickupDate] Date,
    [ItemDescription] NVARCHAR(MAX),
    [DateCreate] DATETIME DEFAULT GETDATE(),
    [TypeOfHistory] NVARCHAR(100) NOT NULL, -- Ví dụ: 'Tạo mới', 'Gia hạn', 'Thanh lý'
    -- Tạo các ràng buộc khóa ngoại
    CONSTRAINT [FK_Pawn_History_Pawn_Item] FOREIGN KEY ([IdPawnItem]) REFERENCES [PawnItem]([Id]),
    CONSTRAINT [FK_Pawn_History_shop] FOREIGN KEY ([IdShop]) REFERENCES [shop]([Id])
);