-- Create Database by using statement
IF EXISTS (SELECT * FROM sys.databases WHERE Name LIKE 'Fsoft_Training')
DROP DATABASE Fsoft_Training

GO

CREATE DATABASE Fsoft_Training

GO
-- Create schema
CREATE SCHEMA Instore

GO
-- Rename database by using statement
ALTER DATABASE Fsoft_Training2
Modify Name = Fsoft_Training

GO
-- Create table
CREATE TABLE Employee(
	EmployeeID			int
,	FirstName           nvarchar(100)
,	LastName            nvarchar(100)
,	AddressDetail		varchar(100) 
,	City				nvarchar(50)
,	BirthDate			nvarchar(10) 
,	IsDeletedFlag       bit
)		

GO
-- Add new column
ALTER TABLE Employee
ADD Gender nchar(1) 

GO
-- Delete a column
ALTER TABLE Employee
DROP COLUMN IsDeletedFlag

GO
-- Change data type of existing column
ALTER TABLE Employee
ALTER COLUMN BirthDate datetime

GO
-- Add or remove constraints
ALTER TABLE Employee ALTER COLUMN EmployeeID int NOT NULL
ALTER TABLE Employee ADD CONSTRAINT PK_Bang PRIMARY KEY (EmployeeID)

GO

-- Remove table structure and its data
DROP TABLE Employee

GO	

-- Table constraint Demo
CREATE TABLE PersonsNotNull(
	P_Id int NOT NULL
,	LastName varchar(255) NOT NULL
,	FirstName varchar(255)
,	Address varchar(255)
,	City varchar(255)
)

GO

-- Test

INSERT INTO PersonsNotNull VALUES(1, 'Ola',	'Hansen', 'Torikatu 38','Oulu')
INSERT INTO PersonsNotNull VALUES(3,'Ana','Emparedados','Avda. de la Constitución 2222','México D.F.')
INSERT INTO PersonsNotNull VALUES(4,'Antonio','Moreno Taquería','Mataderos 2312','México D.F.')
INSERT INTO PersonsNotNull VALUES(5, 'Ola 2',	'Hansen', 'Torikatu 38','Oulu')
UPDATE PersonsNotNull SET P_Id = 5 WHERE LastName = 'Ola 2'

GO

INSERT INTO PersonsNotNull 
VALUES(
	2
,	'Ola 2'
,	'Wilman Kala'
,	NULL
,	'Resende'
)

GO
-- UNIQUE Constraint
CREATE TABLE Persons(
	P_Id int NOT NULL UNIQUE
,	LastName varchar(255) NOT NULL
,	FirstName varchar(255)
,	Address varchar(255)
,	City varchar(255)
)

GO

-- Test
INSERT INTO Persons 
VALUES(
	3
,	'Tove'
,	'Svendson'
,	'Borgvn 23'
,	'Sandnes'
)

GO
-- CHECK Constraint
ALTER TABLE Persons
ADD CONSTRAINT Check_Id CHECK (P_Id>0)

GO

-- Test
INSERT INTO Persons 
VALUES(
	-100
,	'Tove'
,	'Svendson'
,	'Borgvn 23'
,	'Sandnes'
)

GO

-- PRIMARY KEY Constraint
CREATE TABLE Product(
	ProductID int
,	ProductName nvarchar(50)
,	Description nvarchar(100)
,	RetailPrice float
,	WholeSalePrice nvarchar(100)
,	PRIMARY KEY(ProductID)
)

GO
-- Test
INSERT INTO Product 
VALUES(
	NULL
,	'Kari Pettersen 3'
,	'Kari Pettersen 3'
,	500000
,	450000
)

GO

-- FOREIGN KEY constraint
CREATE TABLE Vendor(
	VendorID	int
,	VendorName	nvarchar(50)
,	Phone		varchar(50)
,	Website		varchar(50)
,	ProductID	int
,	PRIMARY KEY(VendorID)
,	FOREIGN KEY (ProductID) REFERENCES Product(ProductID)
)

GO
-- Test
INSERT INTO Vendor 
VALUES(
	3
,	'Ana Mai'
,	'0987654444'
,	'vendor.com.vn'
,	2
)

GO
-- DEFAULT Constraint
CREATE TABLE Timesheet(
	PayrollDate datetime
,	WorkingHours int DEFAULT 8
)

GO
-- Test
INSERT INTO Timesheet(PayrollDate) 
VALUES('11/06/2014')

GO
-- Create Index in Person table
CREATE INDEX PIndex
ON Persons (LastName)

GO
-- or
CREATE INDEX PIndex
ON Persons (LastName, FirstName)

GO

-- Create Identity column 
CREATE TABLE Customer(
	CustomerID		int IDENTITY(1,1) PRIMARY KEY
,	CustomerName	nvarchar(50)NOT NULL
,	ContactName		nvarchar(100)
,	Address			nvarchar(100)
,	City			nvarchar(50)
,	PostalCode		nvarchar(50)
,	Country			nvarchar(50)
)

GO
INSERT INTO Customer VALUES(
	'Alfreds Futterkiste'
,	'Maria Anders	'
,	'Obere Str. 57'
,	'Berlin'
,	'12209'
,	'Germany'
)

GO
-- Insert data to Product
INSERT INTO Product VALUES(2,'Kari Pettersen 2','Kari Pettersen 2',500000,450000)
INSERT INTO Product VALUES(3,'Adjustable Race ','Adjustable Race',800000,760000)
INSERT INTO Product VALUES(4,'Bearing Ball','Bearing Ball',1300000,1220000)
INSERT INTO Product VALUES(5,'BB Ball Bearing','BB Ball Bearing',1500000,1420000)

GO
-- Create view
CREATE VIEW [Current Product List] AS
	SELECT ProductID,ProductName
	FROM Product
	WHERE WholeSalePrice >= 400000

GO 

SELECT * FROM [Current Product List]

GO

DROP VIEW [Current Product List]


GO

-- TRUNCATE Statement
TRUNCATE TABLE PersonsNotNull

GO
CREATE TABLE Orders(
	OrderID		int IDENTITY PRIMARY KEY
,	CustomerID	int
,	EmployeeID	int
,	OrderDate	datetime
,	ShipperID	int
,	FOREIGN KEY (ShipperID) REFERENCES Shippers(ShipperID)
,	FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID)
,	FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID)
)

GO
CREATE TABLE Shippers(
	ShipperID	int IDENTITY PRIMARY KEY
,	ShipperName	nvarchar(50)
,	Phone		nvarchar(50)
)

GO
INSERT INTO dbo.Shippers VALUES ('Speedy Express', '(503) 555-9831')
INSERT INTO dbo.Shippers VALUES ('United Package', '(503) 555-3199')
INSERT INTO dbo.Shippers VALUES ('Federal Shipping', '(503) 555-9931')

GO
INSERT INTO dbo.Employee VALUES (1, 'Nancy', 'Davolio', NULL , NULL, '1968-12-08', '1')
INSERT INTO dbo.Employee VALUES (2, 'Andrew', 'Fuller', NULL , NULL, '1952-02-19', '1')
INSERT INTO dbo.Employee VALUES (3, 'Janet', 'Leverling', NULL , NULL, '1963-08-30', '0')

GO
INSERT INTO dbo.Orders VALUES (5, 1, '1996-07-04', 4)
INSERT INTO dbo.Orders VALUES (6, 3, '1996-07-05', 5)
INSERT INTO dbo.Orders VALUES (5, 1, '1996-07-08', 4)

GO

DELETE FROM dbo.Orders

