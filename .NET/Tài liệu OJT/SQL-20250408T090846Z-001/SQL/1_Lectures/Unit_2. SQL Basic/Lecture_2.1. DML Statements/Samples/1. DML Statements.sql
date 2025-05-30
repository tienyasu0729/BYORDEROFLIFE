USE Fsoft_Training

GO
-- Insert dữ liệu cho tất cả các cột
INSERT INTO dbo.Persons 
VALUES ( 1,'Tom', 'B. Erichsen','Skagen 21','Stavanger')

GO
-- Insert dữ liệu cho các cột được chỉ định
INSERT INTO dbo.Customer (CustomerName, City, Country)
VALUES ('Cardinal', 'Stavanger', 'Norway');
INSERT INTO dbo.Customer (CustomerName, City, Country)
VALUES ('Wartian Herkku', 'Oulu', 'Norway');
INSERT INTO dbo.Customer (CustomerName, City, Country)
VALUES ('Wolski', 'Walla', 'Germany');

GO
-- FROM VERSION 2008
INSERT INTO dbo.Customer 
VALUES  ('Wellington Importadora', 'Paula Parente', 'Rua do Mercado, 12', 'Resende', '08737-363','Brazil'),
		('White Clover Markets', 'Karl Jablonski', '305 - 14th Ave. S. Suite 3B', 'Seattle', '98128','USA'),
		('Wilman Kala', 'Matti Karttunen', 'Keskuskatu 45', 'Helsinki', '21240','Finland')
		
GO
-- Sử dụng INSERT ... SELECT
INSERT dbo.Employee(EmployeeID, FirstName, LastName, AddressDetail, BirthDate, Gender)
SELECT 	EmployeeID
		,	'Bill' + CAST(EmployeeID AS VARCHAR(10)) AS FirstName
		,	'Gates' + CAST(EmployeeID AS VARCHAR(10)) AS LastName
		,	NationalIDNumber
		,	BirthDate
		,	Gender
FROM AdventureWorks.HumanResources.Employee

GO
SELECT * FROM dbo.Employee
SELECT * FROM AdventureWorks.HumanResources.Employee
GO
-- Using SELECT... INTO 
SELECT 	EmployeeID
		,	'Bill' + CAST(EmployeeID AS VARCHAR(10)) AS FirstName
		,	'Gates' + CAST(EmployeeID AS VARCHAR(10)) AS LastName
		,	NationalIDNumber
		,	BirthDate
		,	Gender
INTO dbo.Employee2
FROM AdventureWorks.HumanResources.Employee

GO

UPDATE dbo.Customer
SET PostalCode = '4006'
WHERE Country = 'Norway'
SELECT @@ROWCOUNT AS ROW_COUNT

GO
SELECT * FROM dbo.Customer
GO

DELETE dbo.Customer
WHERE Country = 'Germany'
SELECT @@ROWCOUNT AS ROW_COUNT

GO
-- Delete All Data
DELETE FROM dbo.Persons

GO
-- SELECT ALL
SELECT * FROM dbo.Customer
TRUNCATE TABLE dbo.Customer

GO
-- SELECT Statemets
SELECT * FROM dbo.Customer
-- Select TOP
SELECT TOP 2 * FROM dbo.Customer;

GO
-- Select TOP PERCENT
SELECT TOP 50 PERCENT * FROM dbo.Customer;

GO
-- SELECT with DISTINCT
SELECT * FROM dbo.Employee
GO
SELECT DISTINCT Gender
FROM dbo.Employee 

GO
-- Select WHERE clause
SELECT * FROM dbo.Customer
WHERE City='Oulu'

GO
-- Select SQL Operations
SELECT * FROM dbo.Customer
WHERE Country='Norway' 
AND (City='Berlin' OR City='Stavanger')

GO
