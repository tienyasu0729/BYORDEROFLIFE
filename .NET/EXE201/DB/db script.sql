CREATE DATABASE PeekMed;
USE PeekMed;

-- Bảng User (bệnh nhân/người dùng)
CREATE TABLE Users (
    UserId INT AUTO_INCREMENT PRIMARY KEY,
    FirstName VARCHAR(100),
    MiddleName VARCHAR(100),
    LastName VARCHAR(100),
    DateOfBirth DATE,
    Address VARCHAR(255),
    Password VARCHAR(255) NOT NULL,
    Sex ENUM('Male','Female','Other'),
    Email VARCHAR(150) UNIQUE
);

-- Bảng Hospital (bệnh viện)
CREATE TABLE Hospitals (
    HospitalId INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(200),
    Address VARCHAR(255),
    Email VARCHAR(150) UNIQUE,
    Password VARCHAR(255) NOT NULL,
    Role VARCHAR(50)
);

-- Bảng Department (khoa thuộc bệnh viện)
CREATE TABLE Departments (
    DepartmentId INT AUTO_INCREMENT PRIMARY KEY,
    HospitalId INT NOT NULL,
    DepartmentName VARCHAR(150),
    Description TEXT,
    FOREIGN KEY (HospitalId) REFERENCES Hospitals(HospitalId)
        ON DELETE CASCADE
);

-- Bảng Doctor (bác sĩ, thuộc khoa)
CREATE TABLE Doctors (
    DoctorId INT AUTO_INCREMENT PRIMARY KEY,
    DepartmentId INT NOT NULL,
    FirstName VARCHAR(100),
    MiddleName VARCHAR(100),
    LastName VARCHAR(100),
    DateOfBirth DATE,
    Address VARCHAR(255),
    Password VARCHAR(255) NOT NULL,
    Sex ENUM('Male','Female','Other'),
    Email VARCHAR(150) UNIQUE,
    Role VARCHAR(50),
    FOREIGN KEY (DepartmentId) REFERENCES Departments(DepartmentId)
        ON DELETE CASCADE
);

-- Bảng Appointment (cuộc hẹn)
CREATE TABLE Appointments (
    AppointmentId INT AUTO_INCREMENT PRIMARY KEY,
    UserId INT NOT NULL,
    DoctorId INT NOT NULL,
    DepartmentId INT NOT NULL,
    HospitalId INT NOT NULL,
    AppointmentDate DATE,
    TimeSlot VARCHAR(50),
    Status VARCHAR(50),
    CreatedAt DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (UserId) REFERENCES Users(UserId) ON DELETE CASCADE,
    FOREIGN KEY (DoctorId) REFERENCES Doctors(DoctorId) ON DELETE CASCADE,
    FOREIGN KEY (DepartmentId) REFERENCES Departments(DepartmentId) ON DELETE CASCADE,
    FOREIGN KEY (HospitalId) REFERENCES Hospitals(HospitalId) ON DELETE CASCADE
);

-- Bảng Queue (hàng chờ, 1 appointment chỉ có 1 queue)
CREATE TABLE Queue (
    QueueId INT AUTO_INCREMENT PRIMARY KEY,
    AppointmentId INT UNIQUE, -- đảm bảo 1-1
    QueueNumber INT,
    Status VARCHAR(50),
    CreatedAt DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (AppointmentId) REFERENCES Appointments(AppointmentId)
        ON DELETE CASCADE
);

-- Bảng Notification (thông báo gửi đến User)
CREATE TABLE Notifications (
    NotificationId INT AUTO_INCREMENT PRIMARY KEY,
    UserId INT NOT NULL,
    Title VARCHAR(150),
    Message TEXT,
    IsRead BOOLEAN DEFAULT FALSE,
    CreatedAt DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (UserId) REFERENCES Users(UserId)
        ON DELETE CASCADE
);
