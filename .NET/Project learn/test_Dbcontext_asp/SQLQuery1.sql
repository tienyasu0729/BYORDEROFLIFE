IF DB_ID('test_DBFirst_ASP') IS NULL
    CREATE DATABASE test_DBFirst_ASP;
GO
USE test_DBFirst_ASP;
GO

-- Bảng main_account
CREATE TABLE colord (
    id_color INT IDENTITY(1,1) PRIMARY KEY,
    color VARCHAR(500) NOT NULL UNIQUE
);
GO

-- Bảng area
CREATE TABLE car (
    id_car INT PRIMARY KEY IDENTITY(1,1),
    name_car NVARCHAR(200) NOT NULL UNIQUE,
	id_color int,
	FOREIGN KEY (id_color) REFERENCES colord(id_color)
);
GO