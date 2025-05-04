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
