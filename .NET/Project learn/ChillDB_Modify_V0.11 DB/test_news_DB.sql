create database test_news_DB

use test_news_DB

CREATE TABLE NewsCategory (
    Category_Id INT IDENTITY(1,1) PRIMARY KEY,
    Category_Name NVARCHAR(100) NOT NULL,
    Parent_Id INT NULL,
    FOREIGN KEY (Parent_Id) REFERENCES NewsCategory(Category_Id)
);

CREATE TABLE News (
    News_Id INT IDENTITY(1,1) PRIMARY KEY,
    Title NVARCHAR(200) NOT NULL,
    Slug NVARCHAR(200) NOT NULL UNIQUE,           -- Dùng để tạo URL thân thiện (ví dụ: tin-tuc-moi-nhat)
    Summary NVARCHAR(500) NULL,                   -- Mô tả ngắn gọn
    Content NVARCHAR(MAX) NOT NULL,               -- Nội dung HTML từ CKEditor
    Thumbnail NVARCHAR(255) NULL,                 -- Đường dẫn ảnh đại diện
    Date_Publish DATETIME NOT NULL DEFAULT GETDATE(), -- Ngày đăng (có thể là ngày submit)
    Author_UserName VARCHAR(20) NOT NULL,         -- Người viết bài (liên kết tới Account)
    Category_Id INT NULL,                         -- Chuyên mục (có thể null)
    Is_Visible BIT NOT NULL DEFAULT 1,            -- Có được hiển thị công khai không

    -- Trạng thái kiểm duyệt
    ApprovalStatus NVARCHAR(20) NOT NULL DEFAULT 'Pending', -- ['Pending', 'Approved', 'Rejected']
    ApprovedBy VARCHAR(20) NULL,                             -- Người kiểm duyệt
    ApprovalDate DATETIME NULL,                              -- Thời gian duyệt

    FOREIGN KEY (Author_UserName) REFERENCES Account(UserName),
    FOREIGN KEY (ApprovedBy) REFERENCES Account(UserName),
    FOREIGN KEY (Category_Id) REFERENCES NewsCategory(Category_Id)
);

-- dữ liệu news category

INSERT INTO NewsCategory (Category_Name, Parent_Id)
VALUES
('Tin tức công nghệ', NULL),  -- Chuyên mục cấp cao, không có Parent_Id
('Phần mềm', 1),              -- Chuyên mục con, thuộc Tin tức công nghệ (Category_Id = 1)
('Phần cứng', 1),             -- Chuyên mục con, thuộc Tin tức công nghệ (Category_Id = 1)
('Tin tức giải trí', NULL),   -- Chuyên mục cấp cao, không có Parent_Id
('Âm nhạc', 4);              -- Chuyên mục con, thuộc Tin tức giải trí (Category_Id = 4)

-- dữ liệu bảng news

INSERT INTO News (Title, Slug, Summary, Content, Thumbnail, Author_UserName, Category_Id, ApprovalStatus, ApprovedBy, ApprovalDate)
VALUES
('Tiêu đề bài viết 1', 'tieu-de-bai-viet-1', 'Đây là mô tả ngắn của bài viết 1.', '<p>Nội dung chi tiết của bài viết 1.</p>', '/path/to/thumbnail1.jpg', 'employee1', 1, 'Approved', 'admin1', '2025-05-05 10:00:00'),

('Tiêu đề bài viết 2', 'tieu-de-bai-viet-2', 'Đây là mô tả ngắn của bài viết 2.', '<p>Nội dung chi tiết của bài viết 2.</p>', '/path/to/thumbnail2.jpg', 'employee2', 2, 'Pending', 'admin1', NULL),

('Tiêu đề bài viết 3', 'tieu-de-bai-viet-3', 'Đây là mô tả ngắn của bài viết 3.', '<p>Nội dung chi tiết của bài viết 3.</p>', '/path/to/thumbnail3.jpg', 'employee1', NULL, 'Pending', 'admin1', NULL);
