USE Fsoft_Training

GO
SELECT * FROM dbo.Trainer

GO
-- MAX Function
SELECT *
FROM dbo.Trainer tr
WHERE TR.TrnSalary = 
	(SELECT MAX(TrnSalary) FROM Trainer)

GO
--MIN
SELECT *
FROM dbo.Trainer tr
WHERE TR.TrnAge = 
	(SELECT MIN(TrnAge) FROM Trainer)

GO
-- AVG
SELECT *
FROM dbo.Trainer tr
WHERE TR.TrnSalary >= 
	(SELECT AVG(TrnSalary) FROM Trainer)

GO
-- Create table
IF EXISTS (SELECT * FROM sys.tables WHERE name = 'Students')
	DROP TABLE Students

GO
CREATE TABLE Students(
	StudentId		INT IDENTITY PRIMARY KEY
,	StudentName		VARCHAR(50)
,	SubjectId		CHAR(5)
,	StudentMark		FLOAT
)

GO
INSERT INTO Students
VALUES	('John',  'DBS', 76.5),
		('John',  'IAI', 72.25),
		('Mary',  'DBS', 60.5),
		('Mand',  'PR1', 63.25),
		('Mand',  'PR2', 35.0), 
		('Jane',  'IAI', 54.5)
GO
SELECT * FROM dbo.Students

GO
--SUM
SELECT s.StudentName, SUM(s.StudentMark) AS MarkSum
FROM dbo.Students s
GROUP BY s.StudentName

GO
--OR 
SELECT s.StudentName, ROUND(AVG(s.StudentMark),1) AS MarkAvg
FROM dbo.Students s
GROUP BY s.StudentName
ORDER BY MarkAvg DESC

GO
-- Having
SELECT s.StudentName, COUNT(s.SubjectId) AS SubjectNumber
FROM dbo.Students s
GROUP BY s.StudentName
HAVING COUNT(s.SubjectId) >= 2

GO

-- UNION ALL
SELECT p.P_Id AS Id, p.LastName + ' ' + p.FirstName AS Name, p.Address, p.City, '1' AS Flag
FROM Persons p
UNION ALL
SELECT c.CustomerID, c.CustomerName, c.Address, c.City, '2' AS Flag
FROM Customer c
