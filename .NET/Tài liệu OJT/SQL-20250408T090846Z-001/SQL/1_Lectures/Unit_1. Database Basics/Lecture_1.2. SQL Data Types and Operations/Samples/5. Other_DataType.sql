-- TimeStamp
CREATE TABLE MyTest(
	myKey	int PRIMARY KEY
,	myValue int
,	RV rowversion
)
GO 
INSERT INTO MyTest (myKey, myValue) VALUES (3, 0);
INSERT INTO MyTest (myKey, myValue) VALUES (4, 0);
GO

SELECT * FROM MyTest

-- SQL_VARIANT
DECLARE @t SQL_VARIANT
SET @t = '2012-12-12'
SELECT @t
SET @t = 1
SELECT @t

-- Khai báo biến với khác kiểu khác trong SQL Server
DECLARE @a UNIQUEIDENTIFIER
SET @a = NEWID()
PRINT @a 
