IF DB_ID('InnoCodeCamp2025') IS NULL
    CREATE DATABASE InnoCodeCamp2025;
GO
USE InnoCodeCamp2025;
GO

CREATE TABLE [users] (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    FullName NVARCHAR(100) NOT NULL,
    Email NVARCHAR(100) unique,
    Passwork NVARCHAR(100) NOT NULL,
	Role NVARCHAR(20) CHECK (Role IN ('student', 'lecturer')),
	CreatedAt Datetime DEFAULT GETDATE()
);

go

CREATE TABLE [Teams] (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    TeamName NVARCHAR(100) NOT NULL,
	Description NVARCHAR(200),
	LeaderID INT NULL,
	FOREIGN KEY (LeaderID) REFERENCES [users](ID)
);

go 

CREATE TABLE [Projects] (
    ID INT IDENTITY(1,1) PRIMARY KEY,
	TeamID INT NULL,
	Title NVARCHAR(100) NOT NULL,
	Summary NVARCHAR(200),
	FOREIGN KEY (TeamID) REFERENCES [Teams](ID)
);

go 

CREATE TABLE [Scores] (
    ID INT IDENTITY(1,1) PRIMARY KEY,
	ProjectID int,
	LecturerID int,
	Score INT CHECK (Score BETWEEN 0 AND 100),
	Comment NVARCHAR(500),
	FOREIGN KEY (ProjectID) REFERENCES [Projects](ID),
	FOREIGN KEY (LecturerID) REFERENCES [users](ID)
);