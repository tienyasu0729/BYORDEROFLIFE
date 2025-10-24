-- Kiểm tra và tạo cơ sở dữ liệu nếu chưa tồn tại
IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'PeekMed')
BEGIN
    CREATE DATABASE PeekMed;
END
GO

USE PeekMed;
GO

-- Bảng User (bệnh nhân/người dùng)
CREATE TABLE Users (
    UserId INT IDENTITY(1,1) PRIMARY KEY,
    FirstName NVARCHAR(100),
    MiddleName NVARCHAR(100),
    LastName NVARCHAR(100),
    DateOfBirth DATE,
    Address NVARCHAR(255),
    PhoneNumber NVARCHAR(20) UNIQUE,
    PasswordHash NVARCHAR(255) NOT NULL,
    Sex NVARCHAR(10) CHECK (Sex IN ('Male', 'Female', 'Other')),
    Email NVARCHAR(150) UNIQUE,
    CreatedAt DATETIME DEFAULT GETDATE(),
    UpdatedAt DATETIME DEFAULT GETDATE()
);
GO

-- Bảng Hospital (bệnh viện)
CREATE TABLE Hospitals (
    HospitalId INT IDENTITY(1,1) PRIMARY KEY,
    Name NVARCHAR(200),
    Address NVARCHAR(255),
    PhoneNumber NVARCHAR(20),
    Email NVARCHAR(150) UNIQUE,
    PasswordHash NVARCHAR(255) NOT NULL,
    CreatedAt DATETIME DEFAULT GETDATE(),
    UpdatedAt DATETIME DEFAULT GETDATE()
);
GO

-- Bảng Department (khoa thuộc bệnh viện)
CREATE TABLE Departments (
    DepartmentId INT IDENTITY(1,1) PRIMARY KEY,
    HospitalId INT NOT NULL,
    DepartmentName NVARCHAR(150),
    Description NVARCHAR(MAX),
    FOREIGN KEY (HospitalId) REFERENCES Hospitals(HospitalId) ON DELETE CASCADE
);
GO

-- Bảng Doctor (bác sĩ, thuộc khoa)
CREATE TABLE Doctors (
    DoctorId INT IDENTITY(1,1) PRIMARY KEY,
    DepartmentId INT NOT NULL,
    FirstName NVARCHAR(100),
    MiddleName NVARCHAR(100),
    LastName NVARCHAR(100),
    Specialty NVARCHAR(150),
    DateOfBirth DATE,
    Address NVARCHAR(255),
    PhoneNumber NVARCHAR(20) UNIQUE,
    PasswordHash NVARCHAR(255) NOT NULL,
    Sex NVARCHAR(10) CHECK (Sex IN ('Male', 'Female', 'Other')),
    Email NVARCHAR(150) UNIQUE,
    Role NVARCHAR(50),
    CreatedAt DATETIME DEFAULT GETDATE(),
    UpdatedAt DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (DepartmentId) REFERENCES Departments(DepartmentId) ON DELETE CASCADE
);
GO

-- Bảng Appointment (cuộc hẹn) - ĐÃ SỬA LỖI
CREATE TABLE Appointments (
    AppointmentId INT IDENTITY(1,1) PRIMARY KEY,
    UserId INT NOT NULL,
    DoctorId INT NOT NULL,
    DepartmentId INT NOT NULL,
    HospitalId INT NOT NULL,
    AppointmentDateTime DATETIME,
    ReasonForVisit NVARCHAR(MAX),
    Status NVARCHAR(20) DEFAULT 'Scheduled' CHECK (Status IN ('Scheduled', 'Completed', 'Cancelled', 'NoShow')),
    CreatedAt DATETIME DEFAULT GETDATE(),
    UpdatedAt DATETIME DEFAULT GETDATE(),
    
    FOREIGN KEY (UserId) REFERENCES Users(UserId) ON DELETE CASCADE,
    FOREIGN KEY (DoctorId) REFERENCES Doctors(DoctorId) ON DELETE CASCADE,
    
    -- Bỏ CASCADE để tránh lỗi multiple paths
    FOREIGN KEY (DepartmentId) REFERENCES Departments(DepartmentId) ON DELETE NO ACTION, 
    FOREIGN KEY (HospitalId) REFERENCES Hospitals(HospitalId) ON DELETE NO ACTION
);
GO

-- Bảng Queue (hàng chờ, 1 appointment chỉ có 1 queue)
CREATE TABLE Queue (
    QueueId INT IDENTITY(1,1) PRIMARY KEY,
    AppointmentId INT UNIQUE NOT NULL,
    QueueNumber INT,
    Status NVARCHAR(20) DEFAULT 'Waiting' CHECK (Status IN ('Waiting', 'In Progress', 'Done', 'Skipped')),
    CreatedAt DATETIME DEFAULT GETDATE(),
    UpdatedAt DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (AppointmentId) REFERENCES Appointments(AppointmentId) ON DELETE CASCADE
);
GO

-- Bảng Notification (thông báo gửi đến User)
CREATE TABLE Notifications (
    NotificationId INT IDENTITY(1,1) PRIMARY KEY,
    UserId INT NOT NULL,
    Title NVARCHAR(150),
    Message NVARCHAR(MAX),
    IsRead BIT DEFAULT 0,
    CreatedAt DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (UserId) REFERENCES Users(UserId) ON DELETE CASCADE
);
GO

-- TẠO CHỈ MỤC (INDEX) ĐỂ TĂNG HIỆU SUẤT
CREATE INDEX idx_appointment_datetime ON Appointments(AppointmentDateTime);
CREATE INDEX idx_appointment_status ON Appointments(Status);
CREATE INDEX idx_doctor_name ON Doctors(LastName, FirstName);
CREATE INDEX idx_notification_user ON Notifications(UserId);
GO

USE PeekMed;
GO

-- LƯU Ý: Các chuỗi 'hashed_password_placeholder...' chỉ là giả lập. 
-- Trong ứng dụng thực tế, bạn cần lưu chuỗi hash được tạo ra từ thư viện như bcrypt.

-- 1. Thêm dữ liệu cho bảng Hospitals
PRINT 'Inserting data into Hospitals...';
INSERT INTO Hospitals (Name, Address, PhoneNumber, Email, PasswordHash)
VALUES
('Bệnh viện Đa khoa Đà Nẵng', '122 Hải Phòng, Thạch Thang, Hải Châu, Đà Nẵng', '02363821118', 'info@dananghospital.vn', 'hashed_password_placeholder_hospital1'),
('Bệnh viện Quốc tế Vinmec Đà Nẵng', 'Đường 30 Tháng 4, Khu dân cư số 4 Nguyễn Tri Phương, Hoà Cường Bắc, Hải Châu, Đà Nẵng', '02363711999', 'info.dn@vinmec.com', 'hashed_password_placeholder_hospital2');
GO

-- 2. Thêm dữ liệu cho bảng Departments
PRINT 'Inserting data into Departments...';
INSERT INTO Departments (HospitalId, DepartmentName, Description)
VALUES
(1, 'Khoa Tim mạch', 'Chuyên điều trị các bệnh lý về tim và mạch máu.'),
(1, 'Khoa Ngoại Chấn thương', 'Chuyên xử lý các ca chấn thương chỉnh hình và phẫu thuật.'),
(2, 'Khoa Nhi Tổng hợp', 'Chăm sóc sức khỏe toàn diện cho trẻ em và trẻ sơ sinh.'),
(2, 'Khoa Nội Tổng hợp', 'Khám và điều trị các bệnh nội khoa phổ biến.');
GO

-- 3. Thêm dữ liệu cho bảng Doctors
PRINT 'Inserting data into Doctors...';
INSERT INTO Doctors (DepartmentId, FirstName, MiddleName, LastName, Specialty, DateOfBirth, Address, PhoneNumber, PasswordHash, Sex, Email, Role)
VALUES
(1, 'Văn', 'Thanh', 'Nguyễn', 'Bác sĩ Chuyên khoa II Tim mạch', '1975-05-20', '123 Lê Lợi, Đà Nẵng', '0905111222', 'hashed_password_placeholder_doctor1', 'Male', 'dr.nguyenvthanh@mail.com', 'Doctor'),
(2, 'Thị Mỹ', 'An', 'Trần', 'Bác sĩ Chuyên khoa I Ngoại Chấn thương', '1982-11-15', '45 Phan Chu Trinh, Đà Nẵng', '0913333444', 'hashed_password_placeholder_doctor2', 'Female', 'dr.tranthian@mail.com', 'Doctor'),
(3, 'Anh', 'Hoàng', 'Lê', 'Trưởng khoa Nhi', '1980-01-30', '200 Nguyễn Văn Linh, Đà Nẵng', '0989555666', 'hashed_password_placeholder_doctor3', 'Male', 'dr.lehanh@mail.com', 'Doctor'),
(4, 'Thị Thu', 'Hà', 'Phạm', 'Bác sĩ Nội khoa', '1988-08-10', '78 Hùng Vương, Đà Nẵng', '0905777888', 'hashed_password_placeholder_doctor4', 'Female', 'dr.phamthuha@mail.com', 'Doctor');
GO

-- 4. Thêm dữ liệu cho bảng Users (Bệnh nhân)
PRINT 'Inserting data into Users...';
INSERT INTO Users (FirstName, MiddleName, LastName, DateOfBirth, Address, PhoneNumber, PasswordHash, Sex, Email)
VALUES
('Minh', 'Hoàng', 'Trần', '1995-03-12', 'K12/34 Ông Ích Khiêm, Đà Nẵng', '0905123456', 'hashed_password_placeholder_user1', 'Male', 'hoangminh.tran@email.com'),
('Phương', 'Thảo', 'Lê', '2001-07-22', '56 Nguyễn Hoàng, Đà Nẵng', '0918654321', 'hashed_password_placeholder_user2', 'Female', 'thaophuong.le@email.com'),
('Anh', 'Bảo', 'Võ', '1989-10-01', '33 Pasteur, Đà Nẵng', '0935987654', 'hashed_password_placeholder_user3', 'Male', 'baoanh.vo@email.com');
GO

-- 5. Thêm dữ liệu cho bảng Appointments
-- LƯU Ý: Đảm bảo DoctorId, DepartmentId, và HospitalId phải nhất quán với nhau.
-- Ví dụ: Bác sĩ Nguyễn Văn Thanh (DoctorId=1) thuộc Khoa Tim mạch (DepartmentId=1) của Bệnh viện Đa khoa Đà Nẵng (HospitalId=1).
PRINT 'Inserting data into Appointments...';
INSERT INTO Appointments (UserId, DoctorId, DepartmentId, HospitalId, AppointmentDateTime, ReasonForVisit, Status)
VALUES
(1, 1, 1, 1, '2025-09-26 09:00:00', 'Khám định kỳ, kiểm tra huyết áp', 'Scheduled'),
(2, 3, 3, 2, '2025-09-27 10:30:00', 'Tư vấn dinh dưỡng cho trẻ', 'Scheduled'),
(3, 2, 2, 1, '2025-09-15 14:00:00', 'Tái khám sau khi bó bột tay', 'Completed'),
(1, 4, 4, 2, '2025-09-18 08:00:00', 'Cảm cúm, sốt nhẹ', 'Completed'),
(2, 1, 1, 1, '2025-09-20 11:00:00', 'Khó thở khi vận động', 'Cancelled');
GO

-- 6. Thêm dữ liệu cho bảng Queue
-- Chỉ thêm vào hàng chờ cho những lịch hẹn đã/đang diễn ra (Completed hoặc Scheduled hôm nay)
PRINT 'Inserting data into Queue...';
INSERT INTO Queue (AppointmentId, QueueNumber, Status)
VALUES
(3, 101, 'Done'), -- Lịch hẹn đã hoàn thành
(4, 25, 'Done');   -- Lịch hẹn đã hoàn thành
GO

-- 7. Thêm dữ liệu cho bảng Notifications
PRINT 'Inserting data into Notifications...';
INSERT INTO Notifications (UserId, Title, Message, IsRead)
VALUES
(1, 'Xác nhận lịch hẹn thành công', 'Lịch hẹn của bạn với Bác sĩ Nguyễn Văn Thanh vào lúc 09:00 ngày 26/09/2025 đã được xác nhận.', 0),
(2, 'Nhắc nhở lịch hẹn', 'Bạn có lịch hẹn với Bác sĩ Lê Hoàng Anh vào ngày mai (27/09/2025). Vui lòng đến trước 15 phút.', 0),
(1, 'Kết quả khám bệnh đã có', 'Kết quả khám ngày 18/09/2025 của bạn đã có. Vui lòng truy cập ứng dụng để xem chi tiết.', 1);
GO

PRINT 'Dummy data insertion completed successfully!';
GO