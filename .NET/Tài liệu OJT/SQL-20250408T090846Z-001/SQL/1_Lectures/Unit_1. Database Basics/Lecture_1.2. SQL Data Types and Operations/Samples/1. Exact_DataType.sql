-- Exact Numberic
DECLARE @t decimal(5,3) -- up to 38. -- equality numeric
SET @t = 1
SELECT @t

GO
-- money 8 bytes, smallmoney 4 bytes
DECLARE
@mon1 MONEY,
@mon2 MONEY,
@mon3 MONEY,
@mon4 MONEY,
@num1 DECIMAL(19,4),
@num2 DECIMAL(19,4),
@num3 DECIMAL(19,4),
@num4 DECIMAL(19,4)

SELECT
@mon1 = 100, @mon2 = 339, @mon3 = 10000,
@num1 = 100, @num2 = 339, @num3 = 10000

SET @mon4 = @mon1/@mon2*@mon3
SET @num4 = @num1/@num2*@num3

SELECT @mon4 AS moneyresult,
@num4 AS numericresult

-- Khai báo biến kiểu nguyên lệnh DECLARE và gán giá trị sử dụng lệnh SET
-- hiển thị giá trị sử dụng lệnh SELECT or PRINT
GO
-- Khai báo biến kiểu BIT
DECLARE @i bit
SET @i = 1
PRINT @i

GO
-- Khai báo biến kiểu BIT và gán giá trị khác 0, 1, NULL
DECLARE @i bit
SET @i = 500
PRINT @i

GO
-- Khai báo biến kiểu BIT và gán giá trị true, false
DECLARE @i bit
 SET @i = 'False'
 PRINT @i

GO
DECLARE @i bit
 SET @i = 'TEST'
 PRINT @i