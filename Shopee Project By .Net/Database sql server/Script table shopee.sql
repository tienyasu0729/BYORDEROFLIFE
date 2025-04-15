-- Tạo database nếu chưa tồn tại (SQL Server không hỗ trợ IF NOT EXISTS trực tiếp trong CREATE DATABASE)
IF DB_ID('shopee') IS NULL
    CREATE DATABASE shopee;
GO
USE shopee;
GO

-- Bảng area
CREATE TABLE area (
    area_id INT PRIMARY KEY IDENTITY(1,1),
    name_area NVARCHAR(200) NOT NULL UNIQUE,
    CHECK (name_area LIKE '%[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸỳỵỷỹ ]%')
);
GO

-- Bảng main_account
CREATE TABLE main_account (
    id_main_account INT IDENTITY(1,1) PRIMARY KEY,
    business_ID VARCHAR(500) NOT NULL UNIQUE,
    password VARCHAR(99) NOT NULL,
    account_area INT NOT NULL,
    phone_number VARCHAR(14) NOT NULL UNIQUE,
    email VARCHAR(500) NOT NULL UNIQUE,
    CHECK (LEN(password) >= 8 AND password NOT LIKE '% %'),
    CHECK (business_ID LIKE REPLICATE('[a-zA-Z0-9]', 8) + '%'),
    CHECK (phone_number LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]%'),
    CHECK (email LIKE '_%@_%._%'),
    FOREIGN KEY (account_area) REFERENCES area(area_id)
);
GO

-- Bảng shop
CREATE TABLE shop (
    id_shop INT IDENTITY(1,1) PRIMARY KEY,
    phone_number VARCHAR(14) NOT NULL UNIQUE,
    password VARCHAR(99) NOT NULL,
    email VARCHAR(500) NOT NULL UNIQUE,
    shop_name NVARCHAR(20) NOT NULL UNIQUE,
    shop_avatar_image VARCHAR(500) NULL,
    status BIT NOT NULL DEFAULT 0,
    id_main_account INT NULL,
    CHECK (LEN(password) >= 8 AND password NOT LIKE '% %'),
    CHECK (phone_number LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]%'),
    CHECK (email LIKE '_%@_%._%'),
    CHECK (shop_name LIKE '%[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸỳỵỷỹ -]%'),
    FOREIGN KEY (id_main_account) REFERENCES main_account(id_main_account) ON DELETE SET NULL
);
GO

-- Bảng user
CREATE TABLE [user] (
    id_user INT IDENTITY(1,1) PRIMARY KEY,
    phone_number VARCHAR(15) NOT NULL,
    password VARCHAR(99) NOT NULL,
    account_name VARCHAR(500) NULL,
    real_name VARCHAR(500) NULL,
    email VARCHAR(500) NULL,
    sex CHAR(1) NULL,
    date_of_birth DATE NULL,
    avatar_image VARCHAR(500) NULL,
    joining_date DATE DEFAULT GETDATE()
);
GO

-- Bảng blocked_user
CREATE TABLE blocked_user (
    id_shop INT NOT NULL,
    id_user INT NOT NULL,
    block_dateTime DATETIME DEFAULT GETDATE(),
    PRIMARY KEY (id_shop, id_user),
    FOREIGN KEY (id_shop) REFERENCES shop(id_shop) ON DELETE CASCADE,
    FOREIGN KEY (id_user) REFERENCES [user](id_user) ON DELETE CASCADE
);
GO
-- Bảng list_email_to_receive_electronic_invoices
CREATE TABLE list_email_to_receive_electronic_invoices (
    id_email_receive_electronic INT IDENTITY(1,1) PRIMARY KEY,
    email_address VARCHAR(500) NOT NULL UNIQUE,
    id_shop INT NOT NULL,
    FOREIGN KEY (id_shop) REFERENCES shop(id_shop) ON DELETE CASCADE
);
GO

-- Bảng partner_platform
CREATE TABLE partner_platform (
    id_platform INT IDENTITY(1,1) PRIMARY KEY,
    id_shop INT NOT NULL,
    FOREIGN KEY (id_shop) REFERENCES shop(id_shop) ON DELETE CASCADE
);
GO

-- Bảng payment_settings
CREATE TABLE payment_settings (
    id_shop INT PRIMARY KEY,
    automatic_withdrawal BIT NOT NULL DEFAULT 0,
    pin_code VARCHAR(255) NULL,
    FOREIGN KEY (id_shop) REFERENCES shop(id_shop) ON DELETE CASCADE
);
GO

-- Bảng chat_settings
CREATE TABLE chat_settings (
    id_shop INT PRIMARY KEY,
    Receive_messages_from_Shopee_Rewards BIT NOT NULL DEFAULT 0,
    Receive_messages_from_Personal_Page BIT NOT NULL DEFAULT 0,
    Play_sound_notification_for_new_messages BIT NOT NULL DEFAULT 0,
    Push_new_popup_message BIT NOT NULL DEFAULT 0,
    FOREIGN KEY (id_shop) REFERENCES shop(id_shop) ON DELETE CASCADE
);
GO

-- Bảng notification_settings
CREATE TABLE notification_settings (
    id_shop INT PRIMARY KEY,
    order_update_notification BIT NOT NULL DEFAULT 0,
    Newsletter_notification BIT NOT NULL DEFAULT 0,
    Product_Update_Notification BIT NOT NULL DEFAULT 0,
    Personal_Content_Notification BIT NOT NULL DEFAULT 0,
    Chat_Messages_Reminder BIT NOT NULL DEFAULT 0,
    FOREIGN KEY (id_shop) REFERENCES shop(id_shop) ON DELETE CASCADE
);
GO

-- Bảng business_information
CREATE TABLE business_information (
    id_shop INT PRIMARY KEY,
    business_type VARCHAR(100) NOT NULL,
    address_to_take_product VARCHAR(100) NOT NULL,
    registered_business_address VARCHAR(100) NOT NULL,
    tax_identification_number VARCHAR(50) NULL,
    FOREIGN KEY (id_shop) REFERENCES shop(id_shop) ON DELETE CASCADE
);
GO
-- Bảng form_of_identification
CREATE TABLE form_of_identification (
    form_id INT IDENTITY(1,1) PRIMARY KEY,
    name_form VARCHAR(500) NOT NULL CHECK (
        name_form LIKE '%'
        -- SQL Server không hỗ trợ REGEXP trực tiếp. Bạn cần xử lý validation regex ở tầng ứng dụng hoặc dùng CLR nếu cần regex nâng cao.
    )
);
GO

-- Bảng identification_shop
CREATE TABLE identification_shop (
    id_shop INT PRIMARY KEY,
    form_of_identification INT NOT NULL,
    identification_number VARCHAR(500) NOT NULL,
    identification_name VARCHAR(500) NOT NULL,
    image_identification_front VARCHAR(500) NOT NULL,
    image_identification_back VARCHAR(500) NOT NULL,
    FOREIGN KEY (form_of_identification) REFERENCES form_of_identification(form_id),
    FOREIGN KEY (id_shop) REFERENCES shop(id_shop) ON DELETE CASCADE
);
GO

-- Bảng shipping_method
CREATE TABLE shipping_method (
    id_shipping_method INT IDENTITY(1,1) PRIMARY KEY,
    method_name VARCHAR(100) NOT NULL
);
GO

-- Bảng shop_shipping_method
CREATE TABLE shop_shipping_method (
    id_shop_shipping_method INT IDENTITY(1,1) PRIMARY KEY,
    id_shop INT NOT NULL,
    id_shipping_method INT NOT NULL,
    FOREIGN KEY (id_shop) REFERENCES shop(id_shop) ON DELETE CASCADE,
    FOREIGN KEY (id_shipping_method) REFERENCES shipping_method(id_shipping_method) ON DELETE CASCADE
);
GO

-- Bảng category
CREATE TABLE category (
    id_category INT IDENTITY(1,1) PRIMARY KEY,
    name_category VARCHAR(255) NOT NULL,
    id_parent INT NULL,

	-- này bị lỗi vì ON DELETE CASCADE trong sql server không dùng được trong cùng 1 bảng
	-- FOREIGN KEY (id_parent) REFERENCES category(id_category) ON DELETE CASCADE

	-- câu lệnh này để fix lỗi trên bằng cách xoá ON DELETE CASCADE hoặc có thể dùng trigger
	FOREIGN KEY (id_parent) REFERENCES category(id_category) 
);
GO

-- Bảng category_attribute
CREATE TABLE category_attribute (
    id_category_attribute INT IDENTITY(1,1) PRIMARY KEY,
    name_attribute VARCHAR(500) NOT NULL,
    id_category INT NOT NULL,
    FOREIGN KEY (id_category) REFERENCES category(id_category) ON DELETE CASCADE
);
GO

-- Bảng product
CREATE TABLE product (
    id_product INT IDENTITY(1,1) PRIMARY KEY,
    name_product VARCHAR(255) NOT NULL,
    product_description TEXT NOT NULL,
    pre_order INT DEFAULT 0,
    condition_product VARCHAR(255) NOT NULL,
    SKU_product VARCHAR(255) NULL,
    id_category INT NULL,
    id_shop INT NOT NULL,
    FOREIGN KEY (id_shop) REFERENCES shop(id_shop) ON DELETE CASCADE,
    FOREIGN KEY (id_category) REFERENCES category(id_category)
);
GO

-- Bảng image_and_short_video_product
CREATE TABLE image_and_short_video_product (
    id_product INT PRIMARY KEY,
    video VARCHAR(500) NULL,
    folder_image VARCHAR(500) NOT NULL,
    FOREIGN KEY (id_product) REFERENCES product(id_product) ON DELETE CASCADE
);
GO

-- Bảng category_value
CREATE TABLE category_value (
    id_product INT NOT NULL,
    id_category_attribute INT NOT NULL,
    attribute_value VARCHAR(100),
    PRIMARY KEY (id_product, id_category_attribute),
    FOREIGN KEY (id_product) REFERENCES product(id_product) ON DELETE CASCADE,
    FOREIGN KEY (id_category_attribute) REFERENCES category_attribute(id_category_attribute) ON DELETE CASCADE
);
GO

-- Bảng classification
CREATE TABLE classification (
    id_classification INT IDENTITY(1,1) PRIMARY KEY,
    classification_name VARCHAR(500) NOT NULL,
    id_product INT NOT NULL,
    FOREIGN KEY (id_product) REFERENCES product(id_product) ON DELETE CASCADE
);
GO

-- Bảng classification_value
CREATE TABLE classification_value (
    id_classification_value INT IDENTITY(1,1) PRIMARY KEY,
    classification_value VARCHAR(255),
    price INT NOT NULL,
    inventory_quantity INT DEFAULT 0,
    SKU_classification VARCHAR(255) NULL,
    packaged_length DECIMAL(10,2) NOT NULL,
    packaged_width DECIMAL(10,2) NOT NULL,
    packaged_weight DECIMAL(10,2) NOT NULL,
    packaged_height DECIMAL(10,2) NOT NULL,
    allowed_package_inspection BIT DEFAULT 0,
    status BIT,
    id_classification INT NOT NULL,
    FOREIGN KEY (id_classification) REFERENCES classification(id_classification) ON DELETE CASCADE
);
GO

-- Bảng product_shipping_method
CREATE TABLE product_shipping_method (
    id_product_shipping_method INT IDENTITY(1,1) PRIMARY KEY,
    id_classification_value INT NOT NULL,
    id_shop_shipping_method INT NOT NULL,

	-- bị lỗi có nhiều hơn 1 khoá ngoại dùng ON DELETE CASCADE
    -- FOREIGN KEY (id_classification_value) REFERENCES classification_value(id_classification_value) ON DELETE CASCADE,
    -- FOREIGN KEY (id_shop_shipping_method) REFERENCES shop_shipping_method(id_shop_shipping_method) ON DELETE CASCADE

	-- này để fix lỗi trên
	FOREIGN KEY (id_classification_value) REFERENCES classification_value(id_classification_value),
    FOREIGN KEY (id_shop_shipping_method) REFERENCES shop_shipping_method(id_shop_shipping_method) ON DELETE CASCADE
);
GO

-- Bảng product_group
CREATE TABLE product_group (
    id_shop INT NOT NULL,
    id_product INT NOT NULL,
    name_group VARCHAR(100),
    PRIMARY KEY (id_shop, id_product),

	-- lỗi có hơn 1 khoá ngoại dùng ON DELETE CASCADE
    -- FOREIGN KEY (id_shop) REFERENCES shop(id_shop) ON DELETE CASCADE,
    -- FOREIGN KEY (id_product) REFERENCES product(id_product) ON DELETE CASCADE

	-- fix lỗi trên
	FOREIGN KEY (id_shop) REFERENCES shop(id_shop),
    FOREIGN KEY (id_product) REFERENCES product(id_product) ON DELETE CASCADE
);
GO

-- Bảng user_wallet
CREATE TABLE user_wallet (
    id_user INT PRIMARY KEY,
    user_wallet INT DEFAULT 0,
    FOREIGN KEY (id_user) REFERENCES [user](id_user) ON DELETE CASCADE
);
GO

-- Bảng user_identification_information
CREATE TABLE user_identification_information (
    id_user INT PRIMARY KEY,
    cccd VARCHAR(12) NULL,
    image_selfie VARCHAR(500) NULL,
    image_cccd_front VARCHAR(500) NULL,
    image_cccd_back VARCHAR(500) NULL,
    FOREIGN KEY (id_user) REFERENCES [user](id_user) ON DELETE CASCADE
);
GO

-- Bảng user_spending
CREATE TABLE user_spending (
    id_user INT PRIMARY KEY,
    order_number INT DEFAULT 0,
    spending BIGINT DEFAULT 0,
    FOREIGN KEY (id_user) REFERENCES [user](id_user) ON DELETE CASCADE
);
GO

-- Bảng user_notifications
CREATE TABLE user_notifications (
    id_user INT PRIMARY KEY,
    email_notification_switch BIT DEFAULT 0,
    order_update_via_email BIT DEFAULT 0,
    promotional_email_notification BIT DEFAULT 0,
    survey_notification_via_email BIT DEFAULT 0,
    SMS_notification_switch BIT DEFAULT 0,
    promotional_SMS_notification BIT DEFAULT 0,
    FOREIGN KEY (id_user) REFERENCES [user](id_user) ON DELETE CASCADE
);
GO

-- Bảng user_address
CREATE TABLE user_address (
    id_user INT IDENTITY(1,1) PRIMARY KEY,
    name_address VARCHAR(255) NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    apartment_number VARCHAR(255) NOT NULL,
    street_name VARCHAR(255) NOT NULL,
    District VARCHAR(255) NOT NULL,
    Ward VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    is_default BIT DEFAULT 0,
    -- Nếu bạn muốn lưu địa chỉ cho nhiều người, cần sửa tên cột khóa chính và thêm khóa ngoại riêng
    -- FOREIGN KEY (id_user) REFERENCES [user](id_user) ON DELETE CASCADE
);
GO

-- Bảng coin_history
CREATE TABLE coin_history (
    id_coin_history INT IDENTITY(1,1) PRIMARY KEY,
    number_coin INT DEFAULT 0,
    notification_subject VARCHAR(255) NOT NULL,
    notification_receipt_date DATE DEFAULT CAST(GETDATE() AS DATE)
);
GO

-- Bảng payment_method
CREATE TABLE payment_method (
    id_payment_metod INT IDENTITY(1,1) PRIMARY KEY,
    payment_method_name VARCHAR(255) NOT NULL
);
GO

-- Bảng shop_voucher
CREATE TABLE shop_voucher (
    id_shop_voucher INT IDENTITY(1,1) PRIMARY KEY,
    discount_percentage FLOAT NOT NULL,
    maximum_discount_amount INT NOT NULL,
    discount_start_date DATE NOT NULL,
    discount_end_date DATE NOT NULL,
    offer_description TEXT NOT NULL,
    [đơn_vị_vận_chuyển] VARCHAR(255) NOT NULL,
    [thiết_bị] VARCHAR(255) NOT NULL
);
GO

-- Bảng web_voucher
CREATE TABLE web_voucher (
    id_web_voucher INT IDENTITY(1,1) PRIMARY KEY,
    discount_percentage FLOAT NOT NULL,
    maximum_discount_amount INT NOT NULL,
    discount_start_date DATE NOT NULL,
    discount_end_date DATE NOT NULL,
    offer_description TEXT NOT NULL,
    [đơn_vị_vận_chuyển] VARCHAR(255) NOT NULL,
    [thiết_bị] VARCHAR(255) NOT NULL
);
GO

-- Bảng delivery_voucher
CREATE TABLE delivery_voucher (
    id_delivery_voucher INT IDENTITY(1,1) PRIMARY KEY,
    discount_percentage FLOAT NOT NULL,
    maximum_discount_amount INT NOT NULL,
    discount_start_date DATE NOT NULL,
    discount_end_date DATE NOT NULL,
    offer_description TEXT NOT NULL,
    [đơn_vị_vận_chuyển] VARCHAR(255) NOT NULL,
    [thiết_bị] VARCHAR(255) NOT NULL
);
GO
-- user_order_pending_payment
CREATE TABLE user_order_pending_payment (
    id_order_pending_payment INT IDENTITY(1,1) PRIMARY KEY,
    id_user INT NOT NULL,
    id_payment_metod INT NOT NULL,
    id_shop_voucher INT NOT NULL,
    id_web_voucher INT NOT NULL,
    id_delivery_voucher INT NOT NULL,
    note_to_seller VARCHAR(500) NULL,
    order_datetime DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (id_user) REFERENCES [user](id_user) ON DELETE CASCADE,
    FOREIGN KEY (id_payment_metod) REFERENCES payment_method(id_payment_metod),
    FOREIGN KEY (id_shop_voucher) REFERENCES shop_voucher(id_shop_voucher),
    FOREIGN KEY (id_web_voucher) REFERENCES web_voucher(id_web_voucher),
    FOREIGN KEY (id_delivery_voucher) REFERENCES delivery_voucher(id_delivery_voucher)
);
GO

-- list_item_in_order_pending_payment
CREATE TABLE list_item_in_order_pending_payment (
    id_order_pending_payment INT NOT NULL,
    id_classification_value INT NOT NULL,
    product_quantity INT NOT NULL,
    PRIMARY KEY (id_order_pending_payment, id_classification_value),
    FOREIGN KEY (id_order_pending_payment) REFERENCES user_order_pending_payment(id_order_pending_payment) ON DELETE CASCADE,
    FOREIGN KEY (id_classification_value) REFERENCES classification_value(id_classification_value)
);
GO

-- user_order_in_transit
CREATE TABLE user_order_in_transit (
    id_order_in_transit INT IDENTITY(1,1) PRIMARY KEY,
    id_user INT NOT NULL,
    id_payment_metod INT NOT NULL,
    shop_voucher INT NOT NULL,
    web_voucher INT NOT NULL,
    delivery_voucher INT NOT NULL,
    note_to_seller VARCHAR(500) NULL,
    order_datetime DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (id_user) REFERENCES [user](id_user) ON DELETE CASCADE,
    FOREIGN KEY (id_payment_metod) REFERENCES payment_method(id_payment_metod),
    FOREIGN KEY (shop_voucher) REFERENCES shop_voucher(id_shop_voucher),
    FOREIGN KEY (web_voucher) REFERENCES web_voucher(id_web_voucher),
    FOREIGN KEY (delivery_voucher) REFERENCES delivery_voucher(id_delivery_voucher)
);
GO

-- list_item_in_order_in_transit
CREATE TABLE list_item_in_order_in_transit (
    id_order_in_transit INT NOT NULL,
    id_classification_value INT NOT NULL,
    product_quantity INT NOT NULL,
    PRIMARY KEY (id_order_in_transit, id_classification_value),
    FOREIGN KEY (id_order_in_transit) REFERENCES user_order_in_transit(id_order_in_transit) ON DELETE CASCADE,
    FOREIGN KEY (id_classification_value) REFERENCES classification_value(id_classification_value)
);
GO

-- user_order_pending_shipment
CREATE TABLE user_order_pending_shipment (
    id_order_pending_shipment INT IDENTITY(1,1) PRIMARY KEY,
    id_user INT NOT NULL,
    id_payment_metod INT NOT NULL,
    shop_voucher INT NOT NULL,
    web_voucher INT NOT NULL,
    delivery_voucher INT NOT NULL,
    note_to_seller VARCHAR(500) NULL,
    order_datetime DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (id_user) REFERENCES [user](id_user) ON DELETE CASCADE,
    FOREIGN KEY (id_payment_metod) REFERENCES payment_method(id_payment_metod),
    FOREIGN KEY (shop_voucher) REFERENCES shop_voucher(id_shop_voucher),
    FOREIGN KEY (web_voucher) REFERENCES web_voucher(id_web_voucher),
    FOREIGN KEY (delivery_voucher) REFERENCES delivery_voucher(id_delivery_voucher)
);
GO

-- list_item_in_order_pending_shipment
CREATE TABLE list_item_in_order_pending_shipment (
    id_list_pending_shipment INT IDENTITY(1,1) PRIMARY KEY,
    id_order_pending_shipment INT NOT NULL,
    id_classification_value INT NULL,
    product_quantity INT NOT NULL,
    product_details_deleted NVARCHAR(MAX) NULL, -- JSON không hỗ trợ riêng, dùng NVARCHAR(MAX)
    FOREIGN KEY (id_order_pending_shipment) REFERENCES user_order_pending_shipment(id_order_pending_shipment) ON DELETE CASCADE,
    FOREIGN KEY (id_classification_value) REFERENCES classification_value(id_classification_value)
);
GO

-- user_order_completed
CREATE TABLE user_order_completed (
    id_order_completed INT IDENTITY(1,1) PRIMARY KEY,
    id_user INT NOT NULL,
    id_payment_metod INT NOT NULL,
    shop_voucher INT NOT NULL,
    web_voucher INT NOT NULL,
    delivery_voucher INT NOT NULL,
    note_to_seller VARCHAR(500) NULL,
    order_datetime DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (id_user) REFERENCES [user](id_user) ON DELETE CASCADE,
    FOREIGN KEY (id_payment_metod) REFERENCES payment_method(id_payment_metod),
    FOREIGN KEY (shop_voucher) REFERENCES shop_voucher(id_shop_voucher),
    FOREIGN KEY (web_voucher) REFERENCES web_voucher(id_web_voucher),
    FOREIGN KEY (delivery_voucher) REFERENCES delivery_voucher(id_delivery_voucher)
);
GO

-- list_item_in_order_completed
CREATE TABLE list_item_in_order_completed (
    id_list_order_completed INT IDENTITY(1,1) PRIMARY KEY,
    id_order_completed INT NOT NULL,
    id_classification_value INT NULL,
    product_quantity INT NOT NULL,
    product_details_deleted NVARCHAR(MAX) NULL, -- JSON dạng chuỗi
    FOREIGN KEY (id_order_completed) REFERENCES user_order_completed(id_order_completed) ON DELETE CASCADE,
    FOREIGN KEY (id_classification_value) REFERENCES classification_value(id_classification_value)
);
GO
-- user_order_cancelled
CREATE TABLE user_order_cancelled (
    id_order_cancelled INT IDENTITY(1,1) PRIMARY KEY,
    id_user INT NOT NULL,
    id_payment_metod INT NOT NULL,
    shop_voucher INT NOT NULL,
    web_voucher INT NOT NULL,
    delivery_voucher INT NOT NULL,
    note_to_seller VARCHAR(500) NULL,
    order_datetime DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (id_user) REFERENCES [user](id_user) ON DELETE CASCADE,
    FOREIGN KEY (id_payment_metod) REFERENCES payment_method(id_payment_metod),
    FOREIGN KEY (shop_voucher) REFERENCES shop_voucher(id_shop_voucher),
    FOREIGN KEY (web_voucher) REFERENCES web_voucher(id_web_voucher),
    FOREIGN KEY (delivery_voucher) REFERENCES delivery_voucher(id_delivery_voucher)
);
GO

-- list_item_in_order_cancelled
CREATE TABLE list_item_in_order_cancelled (
    id_list_order_cancelled INT IDENTITY(1,1) PRIMARY KEY,
    id_order_cancelled INT NOT NULL,
    id_classification_value INT NULL,
    product_quantity INT NOT NULL,
    product_details_deleted NVARCHAR(MAX) NULL, -- JSON được lưu dạng NVARCHAR
    FOREIGN KEY (id_order_cancelled) REFERENCES user_order_cancelled(id_order_cancelled) ON DELETE CASCADE,
    FOREIGN KEY (id_classification_value) REFERENCES classification_value(id_classification_value)
);
GO

-- user_order_returned
CREATE TABLE user_order_returned (
    id_order_returned INT IDENTITY(1,1) PRIMARY KEY,
    id_user INT NOT NULL,
    id_payment_metod INT NOT NULL,
    shop_voucher INT NOT NULL,
    web_voucher INT NOT NULL,
    delivery_voucher INT NOT NULL,
    note_to_seller VARCHAR(500) NULL,
    order_datetime DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (id_user) REFERENCES [user](id_user) ON DELETE CASCADE,
    FOREIGN KEY (id_payment_metod) REFERENCES payment_method(id_payment_metod),
    FOREIGN KEY (shop_voucher) REFERENCES shop_voucher(id_shop_voucher),
    FOREIGN KEY (web_voucher) REFERENCES web_voucher(id_web_voucher),
    FOREIGN KEY (delivery_voucher) REFERENCES delivery_voucher(id_delivery_voucher)
);
GO

-- list_item_in_order_returned
CREATE TABLE list_item_in_order_returned (
    id_list_order_returned INT IDENTITY(1,1) PRIMARY KEY,
    id_order_returned INT NOT NULL,
    id_classification_value INT NULL,
    product_quantity INT NOT NULL,
    product_details_deleted NVARCHAR(MAX) NULL,
    FOREIGN KEY (id_order_returned) REFERENCES user_order_returned(id_order_returned) ON DELETE CASCADE,
    FOREIGN KEY (id_classification_value) REFERENCES classification_value(id_classification_value)
);
GO

-- product_review
CREATE TABLE product_review (
    id_user INT NOT NULL,
    id_shop INT NOT NULL,
    id_classification_value INT NOT NULL,
    user_comment VARCHAR(500) NOT NULL,
    shop_answer VARCHAR(500) NULL,
    star INT NOT NULL,
    PRIMARY KEY (id_user, id_shop, id_classification_value),

	-- lỗi có nhiều hơn 1 khoá dùng ON DELETE CASCADE
    -- FOREIGN KEY (id_user) REFERENCES [user](id_user) ON DELETE CASCADE,
    -- FOREIGN KEY (id_shop) REFERENCES shop(id_shop) ON DELETE CASCADE,
    -- FOREIGN KEY (id_classification_value) REFERENCES classification_value(id_classification_value) ON DELETE CASCADE

	-- fix lỗi trên
	FOREIGN KEY (id_user) REFERENCES [user](id_user),
    FOREIGN KEY (id_shop) REFERENCES shop(id_shop),
    FOREIGN KEY (id_classification_value) REFERENCES classification_value(id_classification_value) ON DELETE CASCADE
);
GO
