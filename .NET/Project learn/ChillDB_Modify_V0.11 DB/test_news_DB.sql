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




CREATE TABLE Review (
    ReviewId INT PRIMARY KEY IDENTITY(1,1),
    Product_Id INT NOT NULL,
    UserId INT NOT NULL,
    Rating INT CHECK (Rating BETWEEN 1 AND 5),
    Comment NVARCHAR(MAX),
    CreatedAt DATETIME DEFAULT GETDATE(),

    FOREIGN KEY (Product_Id) REFERENCES Product(Product_Id) ON DELETE CASCADE,
    FOREIGN KEY (UserId) REFERENCES User_(UserId) ON DELETE CASCADE
);

4	súng đạn	sung-dan	súng ống	<p>súng</p><p>cò súng</p><p>băng đạn</p><p>máu</p>	a	2025-05-05 12:22:43.550	admin1	5	True	Pending	NULL	NULL

INSERT INTO News (
    Title, 
    Slug, 
    Summary, 
    Content, 
    Thumbnail, 
    Date_Publish, 
    Author_UserName, 
    Category_Id, 
    Is_Visible, 
    ApprovalStatus, 
    ApprovedBy, 
    ApprovalDate
)
VALUES (
    N'Cách sử dụng Hailuo AI video chuyển đổi văn bản thành video nhanh chóng',         -- Title
    N'hailuo-ai11',         -- Slug
    N'Hiện nay, Hailuo AI nổi lên như một giải pháp đột phá, mang đến khả năng chuyển đổi văn bản thành video một cách nhanh chóng và dễ dàng. Với giao diện thân thiện và các tính năng mạnh mẽ, Hailuo AI mở ra cánh cửa sáng tạo nội dung video cho bất kỳ ai, từ những nhà sáng tạo nội dung chuyên nghiệp đến những người mới bắt đầu. Trong bài viết này, GEARVN sẽ hướng dẫn bạn cách sử dụng Hailuo AI, giúp bạn tối ưu hóa quy trình sản xuất video và nâng cao hiệu quả truyền thông.',         -- Summary
    N'<p>Hiện nay,<strong> Hailuo AI</strong> nổi lên như một giải pháp đột phá, mang đến khả năng chuyển đổi văn bản thành video một cách nhanh chóng và dễ dàng. Với giao diện thân thiện và các tính năng mạnh mẽ, Hailuo AI mở ra cánh cửa sáng tạo nội dung video cho bất kỳ ai, từ những nhà sáng tạo nội dung chuyên nghiệp đến những người mới bắt đầu. Trong bài viết này, GEARVN&nbsp;sẽ hướng dẫn bạn&nbsp;cách sử dụng Hailuo AI, giúp bạn tối ưu hóa quy trình sản xuất video và nâng cao hiệu quả truyền thông.</p><h2><strong>Hailuo AI là gì?</strong></h2><p>Hailuo AI là một nền tảng trực tuyến ứng dụng trí tuệ nhân tạo để tự động hóa quá trình tạo video từ văn bản. Thay vì phải trải qua các bước phức tạp như viết kịch bản chi tiết, tìm kiếm diễn viên, thiết lập bối cảnh, quay phim, và chỉnh sửa hậu kỳ, Hailuo AI cho phép người dùng tạo ra những video chất lượng cao chỉ bằng cách cung cấp văn bản đầu vào.</p><p><img src="https://file.hstatic.net/200000722513/file/hailuo_ai-mobile-3_f33c06c5baaa4897b993145c13ee02e6_1024x1024.jpg" alt="hailuo ai"></p><p><strong>Những ưu điểm vượt trội của Hailuo AI:</strong></p><p><strong>Tiết kiệm thời gian và chi phí: </strong>Hailuo AI loại bỏ nhiều công đoạn tốn thời gian và chi phí trong quy trình sản xuất video truyền thống, giúp bạn tạo ra video một cách nhanh chóng và hiệu quả về mặt kinh tế.</p><p><strong>Dễ dàng sử dụng: </strong>Giao diện trực quan và thân thiện với người dùng của Hailuo AI cho phép bất kỳ ai, kể cả những người không có kinh nghiệm làm video, cũng có thể dễ dàng tạo ra những video chuyên nghiệp.</p><p><strong>Đa dạng hóa nội dung: </strong>Với khả năng tùy chỉnh cao, Hailuo AI cho phép bạn tạo ra nhiều loại video khác nhau, từ video giải thích, video quảng cáo, video hướng dẫn, đến video tin tức và nhiều hơn nữa.</p><p><strong>Tăng cường khả năng tiếp cận: </strong>Việc chuyển đổi văn bản thành video giúp nội dung của bạn trở nên hấp dẫn và dễ tiếp cận hơn với nhiều đối tượng khán giả khác nhau, đặc biệt là những người thích xem video hơn là đọc văn bản.</p><p><strong>Tối ưu hóa SEO:</strong> Video thường có xu hướng được ưu tiên hiển thị trên các công cụ tìm kiếm, việc sử dụng Hailuo AI để tạo video từ nội dung hiện có có thể giúp bạn cải thiện thứ hạng SEO và thu hút nhiều lưu lượng truy cập hơn.</p><p><img src="https://file.hstatic.net/200000722513/file/hailuo_ai-mobile-2_7b8a3e4855394f57bf9745a3277c63bd_1024x1024.jpg" alt="hailuo ai video"></p><p><strong>&gt;&gt;&gt; Xem thêm: </strong><a href="https://gearvn.com/blogs/thu-thuat-giai-dap/tao-anh-bang-ai"><strong>TOP 10 website tạo ảnh bằng AI từ văn bản, ảnh thật siêu chất</strong></a></p><h2><strong>Hướng dẫn chi tiết cách sử dụng Hailuo AI để chuyển đổi văn bản thành video</strong></h2><p>Hailuo AI mang đến sự tiện lợi tối đa khi cho phép người dùng tạo video từ văn bản trên cả thiết bị di động và <a href="https://gearvn.com/pages/pc-gvn">máy tính</a>. Dù bạn đang di chuyển hay làm việc tại văn phòng, bạn đều có thể dễ dàng biến ý tưởng thành những thước phim hấp dẫn. Dưới đây là hướng dẫn chi tiết cho từng nền tảng:</p><h3><strong>Cách sử dụng Hailuo AI trên điện thoại di động</strong></h3><p>Hailuo AI thường cung cấp giao diện web di động được tối ưu hóa hoặc ứng dụng di động riêng. Tuy nhiên, để tận dụng khả năng chuyển đổi văn bản thành video của Hailuo AI trên thiết bị di động, người dùng có thể truy cập trực tiếp thông qua trình duyệt web mà không cần cài đặt ứng dụng. Quy trình thực hiện được trình bày chi tiết qua các bước sau:</p><p><strong>Bước 1: </strong>Khởi đầu bằng việc truy cập đường dẫn chính thức: https://hailuoai.video. Tại giao diện trang chủ, định vị và chọn mục "<strong>Me</strong>" thường được bố trí ở góc phải màn hình để tiến hành xác thực tài khoản thông qua Google.</p><p><img src="https://file.hstatic.net/200000722513/file/hailuo_ai-mobile_edd335eb6858425fae303a4308b29c13_1024x1024.jpg" alt="hailuo ai video"></p><p><strong>Bước 2:</strong> Sau khi quá trình đăng nhập thành công, hệ thống sẽ điều hướng trở lại trang chủ. Tại đây, người dùng tìm và nhấn vào biểu tượng ngôi sao, thường được đặt ở vị trí trung tâm màn hình. Tiếp theo, nhập nội dung mô tả chi tiết cho video mong muốn vào trường văn bản được cung cấp, sau đó kích hoạt quá trình tạo video bằng cách nhấn vào biểu tượng hình vỏ sò đặc trưng của Hailuo AI.</p><p><strong>Bước 3:</strong> Khi quá trình xử lý và tạo video hoàn tất, người dùng chỉ cần chọn video đã được tạo và nhấn tùy chọn "<strong>Download</strong>" để lưu trữ trực tiếp tệp video về thiết bị di động của mình.</p><p><img src="https://file.hstatic.net/200000722513/file/hailuo_ai-mobile-1_8d19499744db45da9bb27b6f3cddbe77_1024x1024.jpg" alt="hailuo ai video"></p><h3><strong>Cách sử dụng Hailuo AI trên máy tính, laptop</strong></h3><p>Sử dụng Hailuo AI trên máy tính thường mang lại trải nghiệm đầy đủ tính năng hơn với <a href="https://gearvn.com/pages/man-hinh">màn hình</a> lớn và khả năng thao tác chi tiết hơn.</p><p><strong>Bước 1:</strong>&nbsp;Mở trình duyệt web (<a href="https://gearvn.com/blogs/thu-thuat-giai-dap/cach-tai-va-su-dung-chrome-remote-desktop">Chrome</a>, Firefox, Safari, Edge,...) trên máy tính của bạn và truy cập trang web chính thức của Hailuo AI.</p><p><strong>Bước 2:</strong>&nbsp;Sử dụng thông tin đăng nhập hiện có hoặc tạo tài khoản mới theo hướng dẫn trên trang web.</p><p><img src="https://file.hstatic.net/200000722513/file/hailuo_ai-pc-login_2015f8c8c8394ffe8827df89ecf90dcf_1024x1024.jpg" alt="hailuo ai video pc"></p><p><strong>Bước 3:&nbsp;</strong>Tìm và nhấp vào nút "<strong>Tạo video mới</strong>", "<strong>Dự án mới</strong>" hoặc tương tự trên giao diện trang web. Bạn sẽ có các tùy chọn nhập văn bản tương tự như trên điện thoại:</p><ul><li>&nbsp;</li></ul><p>Sao chép và dán văn bản vào trình soạn thảo.</p><p>Tải lên tệp văn bản từ máy tính.</p><p>Nhập URL của trang web (nếu được hỗ trợ).</p><p><strong>Bước 4:</strong>&nbsp;Giao diện trên máy tính thường cung cấp nhiều tùy chọn tùy chỉnh hơn và dễ dàng thao tác bằng chuột và bàn phím:</p><p>Chọn giọng đọc: Duyệt và nghe thử các giọng đọc AI khác nhau.</p><p>Thư viện tích hợp: Tìm kiếm và chọn hình ảnh, video clip từ thư viện của Hailuo AI.</p><p>Tải lên từ máy tính: Tải lên các tệp đa phương tiện từ <a href="https://gearvn.com/collections/ssd-o-cung-the-ran">ổ cứng máy tính</a> của bạn. Bạn thường có thể chỉ định hình ảnh/video cho từng đoạn văn bản cụ thể.</p><p>Chọn và tùy chỉnh nhạc nền: Duyệt thư viện nhạc nền, nghe thử và chọn một bản nhạc phù hợp. Bạn cũng có thể tải lên tệp âm thanh của riêng mình.</p><p>Thiết kế giao diện: Tùy chỉnh màu sắc chủ đạo, màu chữ, phông chữ, thêm logo và các yếu tố thương hiệu khác.</p><p>Thêm hiệu ứng và chuyển cảnh: Áp dụng các hiệu ứng động và chuyển cảnh giữa các phân đoạn để video thêm sinh động.</p><p>Điều chỉnh thời gian và tốc độ: Thiết lập thời lượng hiển thị cho từng cảnh và điều chỉnh tốc độ đọc của giọng AI một cách chính xác.</p><p>Chèn tiêu đề, phụ đề và các yếu tố văn bản khác: Thêm chữ tiêu đề, phụ đề hoặc các đoạn text bổ sung vào video.</p><p><img src="https://file.hstatic.net/200000722513/file/hailuo-ai-pc_d6ca1c6e6a91452d9b36ca432394f6c6_1024x1024.png" alt="hailuo ai video pc"></p><p><strong>Bước 5:&nbsp;</strong>Nhấp vào nút "<strong>Xem trước</strong>" để xem toàn bộ video trên màn hình lớn. Sử dụng các công cụ chỉnh sửa (nếu có) để điều chỉnh thời gian, thay đổi hình ảnh, âm thanh hoặc các yếu tố khác cho đến khi bạn hài lòng.</p><p><strong>Bước 6:&nbsp;</strong>Nhấp vào nút "<strong>Xuất video</strong>" hoặc "<strong>Tải xuống</strong>". Chọn các tùy chọn mong muốn và bắt đầu quá trình xuất video. Thời gian xuất có thể tùy thuộc vào độ dài và độ phức tạp của video. Sau khi hoàn tất, video sẽ được tải xuống máy tính của bạn.</p><p><img src="https://file.hstatic.net/200000722513/file/hailuo-ai-pc-3__1__5f24b63dfeca483ea195066575bd32aa_1024x1024.png" alt="hailuo ai video pc"></p><h2><strong>Mẹo và thủ thuật để tối ưu hóa video tạo bằng Hailuo AI</strong></h2><p>Để tận dụng tối đa sức mạnh của Hailuo AI, bạn hãy lưu ý một số mẹo và thủ thuật sau:</p><p>Chuẩn bị văn bản chất lượng: Văn bản đầu vào rõ ràng, mạch lạc và hấp dẫn sẽ giúp Hailuo AI tạo ra video chất lượng cao hơn. Hãy chú trọng vào cấu trúc câu, từ ngữ và thông điệp bạn muốn truyền tải.</p><p>Chọn giọng đọc phù hợp: Lựa chọn giọng đọc có ngữ điệu và phong cách phù hợp với nội dung và đối tượng khán giả của bạn.</p><p>Sử dụng hình ảnh và video clip liên quan: Hình ảnh và video clip trực quan sẽ giúp minh họa cho nội dung văn bản và tăng tính hấp dẫn của video. Hãy chọn những hình ảnh và video có chất lượng tốt và liên quan đến thông điệp bạn muốn truyền tải.</p><p>Lựa chọn nhạc nền phù hợp: Nhạc nền có thể tạo ra không khí và cảm xúc cho video. Hãy chọn nhạc nền phù hợp với tông giọng và nội dung của video.</p><p>Thiết kế giao diện chuyên nghiệp: Tùy chỉnh màu sắc, phông chữ và logo để video của bạn trông chuyên nghiệp và nhất quán với thương hiệu cá nhân hoặc doanh nghiệp.</p><p>Kiểm tra kỹ lưỡng trước khi xuất: Luôn xem trước video để đảm bảo mọi thứ diễn ra suôn sẻ và không có lỗi.</p><p>Thử nghiệm với các tùy chọn khác nhau: Đừng ngại thử nghiệm với các giọng đọc, hình ảnh, nhạc nền và hiệu ứng khác nhau để tìm ra phong cách video phù hợp nhất với bạn.</p><p><img src="https://file.hstatic.net/200000722513/file/hailuo-ai-pc-tip_689d0fbb04b24a5aa92e804c9ef5ee85_1024x1024.jpeg" alt="hailuo ai video pc"></p><h2><strong>Lời kết</strong></h2><p>Với những bước hướng dẫn chi tiết và trực quan trên, hy vọng bạn đã nắm vững quy trình sử dụng<strong> Hailuo AI video </strong>để chuyển đổi văn bản thành những video độc đáo và thu hút. Sự tiện lợi và tốc độ mà công cụ này mang lại chắc chắn sẽ là một trợ thủ đắc lực trong việc tạo ra nội dung video đa dạng cho công việc, học tập hay giải trí. Hãy bắt đầu khám phá và tận dụng sức mạnh của Hailuo AI ngay hôm nay để thổi hồn vào những con chữ, biến chúng thành những câu chuyện video sống động và đầy màu sắc!</p>',         -- Content (HTML từ CKEditor)
    N'a',         -- Thumbnail (đường dẫn ảnh)
    '2025-05-05 12:24:15.880', -- Date_Publish hoặc dùng GETDATE()
    'admin1',          -- Author_UserName (phải có trong bảng Account)
    1,        -- Category_Id (hoặc số, hoặc NULL nếu không có)
    1,           -- Is_Visible (1: hiển thị, 0: ẩn)
    N'Pending',  -- ApprovalStatus ('Pending', 'Approved', 'Rejected')
    NULL,        -- ApprovedBy (hoặc tên tài khoản kiểm duyệt)
    NULL         -- ApprovalDate (hoặc 'YYYY-MM-DD HH:MM:SS')
);






