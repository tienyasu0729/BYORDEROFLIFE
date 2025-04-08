USE Fsoft_Training

GO

CREATE TABLE dbo.PhoneBook
(
	LastName		varchar(50) NOT NULL
,	FirstName		varchar(50) NOT NULL
,	PhoneNumber		varchar(50) NOT NULL
);

GO
INSERT INTO dbo.PhoneBook 
VALUES  ('Alexander','Mary', '344-555-0133'),
		('Kurtz','Jeffrey','452-555-0179'),
		('Vessa','Robert','560-555-0171'),
		('Thames','Judy','799-555-0118'),
		('Martinez','Frank','171-555-0147'),
		('Haines','Betty','867-555-0114'),
		('Burnett','Linda','121-555-0121'),
		('Harris','Keith','170-555-0127'),
		('Kitt','Sandra','303-555-0134'),
		('Campbell','Frank','491-555-0132'),
		('Logan', 'Todd', '783-555-0110'),
		('Clayton','Jane','206-555-0195'),
		('Johnson','Brian','320-555-0134'),
		('Liu','David','440-555-0132'),
		('Diaz','Brenda','147-555-0192')
GO
SELECT p.PhoneNumber
FROM dbo.PhoneBook p
WHERE P.LastName = 'Logan' AND P.FirstName = 'Todd';

GO
CREATE CLUSTERED INDEX IX_PhoneBook_CI
ON dbo.PhoneBook (LastName, FirstName)

GO
DROP INDEX PhoneBook.IX_PhoneBook_CI
-- OR
GO

CREATE NONCLUSTERED INDEX IX_PhoneBook_CI
ON dbo.PhoneBook(LastName, FirstName)
GO

