CREATE DATABASE IF NOT EXISTS Fake_shopee;
USE Fake_shopee;

create table area (
	area_id int primary key,
    name_area varchar(200) not null	
);    

CREATE TABLE main_account (
    id_main_account INT AUTO_INCREMENT PRIMARY KEY,
	business_ID varchar(500) not null, -- đại diện cho tên đăng nhập và khi đăng nhập sẽ kèm theo :main gì đó phía sau có lẽ để phân biệt quyền gì đó
    password varchar(99) not null,
    account_area int not null, -- đại diện cho đất nước người này quản lý chính
    phone_number varchar(14) not null,
    email varchar(500) not null,
	FOREIGN KEY (account_area) REFERENCES area(area_id) 
);

CREATE TABLE shop (
    id_shop INT AUTO_INCREMENT PRIMARY KEY,
    phone_number VARCHAR(15) NOT NULL,
	password VARCHAR(99) NOT NULL,
    email VARCHAR(500) NOT NULL,
    shop_name VARCHAR(20) NOT NULL,
	shop_avatar_image VARCHAR(500) null,
	status boolean default 0 not null,
    id_main_account INT null,
    FOREIGN KEY (id_main_account) REFERENCES main_account(id_main_account) ON DELETE SET NULL
);

CREATE TABLE list_email_to_receive_electronic_invoices (
    id_email_receive_electronic INT PRIMARY KEY AUTO_INCREMENT,
    email_address VARCHAR(500) NOT NULL unique,
    id_shop INT not null,
    FOREIGN KEY (id_shop) REFERENCES shop(id_shop) ON DELETE CASCADE
);

CREATE TABLE partner_platform (
    id_platform INT AUTO_INCREMENT PRIMARY KEY,
    shop_id INT not null,
    FOREIGN KEY (shop_id) REFERENCES shop(shop_id) ON DELETE CASCADE
);

CREATE TABLE payment_settings (
    shop_id INT PRIMARY KEY,
    automatic_withdrawal boolean default 0 not null,
    pin_code VARCHAR(255) null,
    FOREIGN KEY (shop_id) REFERENCES shop(shop_id) ON DELETE CASCADE
);

CREATE TABLE chat_settings (
    shop_id INT PRIMARY KEY,
    Receive_messages_from_Shopee_Rewards BOOLEAN default 0 not null,
    Receive_messages_from_Personal_Page BOOLEAN default 0 not null,
    Play_sound_notification_for_new_messages BOOLEAN default 0 not null,
    Push_new_popup_message BOOLEAN default 0 not null,
    FOREIGN KEY (shop_id) REFERENCES shop(shop_id) ON DELETE CASCADE
);

CREATE TABLE notification_settings (
    shop_id INT PRIMARY KEY,
    order_update_notification boolean default 0 not null,
    Newsletter_notification boolean default 0 not null,
    Product_Update_Notification boolean default 0 not null,
    Personal_Content_Notification boolean default 0 not null,
    Chat_Messages_Reminder boolean default 0 not null,
    FOREIGN KEY (shop_id) REFERENCES shop(shop_id) ON DELETE CASCADE
);

CREATE TABLE business_information (
    shop_id INT PRIMARY KEY,
    business_type VARCHAR(100) NOT NULL,
    address_to_take_product VARCHAR(100) NOT NULL,
    registered_business_address  VARCHAR(100) NOT NULL,
    tax_identìication_number VARCHAR(50) null,
    FOREIGN KEY (shop_id) REFERENCES shop(shop_id) ON DELETE CASCADE
);

create table form_of_identification (
	form_id int auto_increment primary key,
    name_form varchar(500)
);

CREATE TABLE identification_shop (
    shgop_id INT PRIMARY KEY,
    form_of_identification int not null,
    identification_number varchar(500) not null,
    identification_name varchar(500) not null,
    image_identification_front varchar(500) not null,
    image_identification_back varchar(500) not null,
    FOREIGN KEY (form_of_identification) REFERENCES form_of_identification(form_id),
    FOREIGN KEY (shop_id) REFERENCES shop(shop_id) ON DELETE CASCADE
);

CREATE TABLE shipping_method (
    id_shipping_method INT AUTO_INCREMENT PRIMARY KEY,
    method_name VARCHAR(100) not null
);

CREATE TABLE shop_shipping_method (
    id_shop_shipping_method INT AUTO_INCREMENT PRIMARY KEY,
    id_shop INT,
    id_shipping_method INT,
    FOREIGN KEY (id_shop) REFERENCES shop(id_shop) ON DELETE CASCADE,
    FOREIGN KEY (id_shipping_method) REFERENCES shipping_method(id_shipping_method) ON DELETE CASCADE
);

CREATE TABLE product_group (
    id_shop INT not null,
    id_product INT not null,
    name_group VARCHAR(100),
    PRIMARY KEY (id_shop, id_product),
    FOREIGN KEY (id_shop) REFERENCES shop(id_shop) ON DELETE CASCADE,
    FOREIGN KEY (id_product) REFERENCES product(id_product) ON DELETE CASCADE
);

CREATE TABLE user (
    id_user INT PRIMARY KEY auto_increment,
    phone_number VARCHAR(15) NOT NULL,
    password  VARCHAR(99) NOT NULL,
    account_name varchar(500) null,
    real_name  VARCHAR(500) null,
    email varchar(500) null,
    sex char null,
    date_of_birth date null,
    avatar_image varchar(500) null,
    joining_date DATE DEFAULT (current_date())
);

CREATE TABLE user_wallet (
    id_user INT PRIMARY KEY,
	user_wallet int default 0,
	FOREIGN KEY (id_user) REFERENCES user(id_user) ON DELETE CASCADE
);

CREATE TABLE user_identification_information (
    id_user INT PRIMARY KEY,
    cccd VARCHAR(12) NULL,
    image_selfie VARCHAR(500) null,
    image_cccd_front VARCHAR(500) null,
    image_cccd_back VARCHAR(500) null,
	FOREIGN KEY (id_user) REFERENCES user(id_user) ON DELETE CASCADE
);

CREATE TABLE user_spending (
    id_user INT PRIMARY KEY,
	order_number int default 0,
    spending long default 0,
    FOREIGN KEY (id_user) REFERENCES user(id_user) ON DELETE CASCADE
);

CREATE TABLE user_notifications (
    id_user INT PRIMARY KEY,
	email_notification_switch boolean default 0,
	order_update_via_email boolean default 0,
	promotional_email_notification boolean default 0,
	survey_notification_via_email boolean default 0,
	SMS_notification_switch boolean default 0,
	promotional_SMS_notification boolean default 0,
    FOREIGN KEY (id_user) REFERENCES user(id_user) ON DELETE CASCADE
);

CREATE TABLE user_address(
    id_user INT PRIMARY KEY,
    name_address VARCHAR(255) not null,
	phone_number  VARCHAR(15) not null,
    apartment_number VARCHAR(255) not null,
    street_name VARCHAR(255) not null,
    District VARCHAR(255) not null,
    Ward VARCHAR(255) not null,
    city VARCHAR(255) not null,
    is_default BOOLEAN default 0,
    FOREIGN KEY (id_user) REFERENCES user(id_user) ON DELETE CASCADE
);

CREATE TABLE coin_history (
    id_coin_history INT PRIMARY KEY,
    number_coin INT default 0,
    notification_subject VARCHAR(255) not null,
    notification_receipt_date DATE DEFAULT (current_date())
);

CREATE TABLE payment_method (
    id_payment_metod INT PRIMARY KEY,
    payment_method_name VARCHAR(255) not null
);

CREATE TABLE shop_voucher (
    id_shop_voucher INT PRIMARY KEY auto_increment,
    discount_percentage FLOAT not null,
    maximum_discount_amount int not null,
    discount_start_date DATE not null,
    discount_end_date DATE not null,
    offer_description TEXT not null,
    đơn_vị_vận_chuyển VARCHAR(255) not null,
    thiết_bị VARCHAR(255) not null
);

CREATE TABLE web_voucher (
    id_web_voucher INT PRIMARY KEY auto_increment,
    discount_percentage FLOAT not null,
    maximum_discount_amount int not null,
    discount_start_date DATE not null,
    discount_end_date DATE not null,
    offer_description TEXT not null,
    đơn_vị_vận_chuyển VARCHAR(255) not null,
    thiết_bị VARCHAR(255) not null
);

CREATE TABLE delivery_voucher (
    id_delivery_voucher INT PRIMARY KEY auto_increment,
    discount_percentage FLOAT not null,
    maximum_discount_amount int not null,
    discount_start_date DATE not null,
    discount_end_date DATE not null,
    offer_description TEXT not null,
    đơn_vị_vận_chuyển VARCHAR(255) not null,
    thiết_bị VARCHAR(255) not null
);

CREATE TABLE user_order (
    id_order INT PRIMARY KEY auto_increment,
    id_user int not null,
    id_payment_metod int not null,
    id_shop_voucher int not null,
    id_web_voucher int not null,
    id_delivery_voucher int not null,
    note_to_seller varchar(500),
    FOREIGN KEY (id_user) REFERENCES user(id_user),
    FOREIGN KEY (id_payment_metod) REFERENCES payment_method(id_payment_metod),
    FOREIGN KEY (id_shop_voucher) REFERENCES shop_voucher(id_shop_voucher),
    FOREIGN KEY (id_web_voucher) REFERENCES web_voucher(id_web_voucher),
    FOREIGN KEY (id_delivery_voucher) REFERENCES delivery_voucher(id_delivery_voucher)
);

CREATE TABLE blocked_user (
    id_shop INT not null,
    id_user INT not null,
    block_dateTime datetime default (current_timestamp()),
    PRIMARY KEY (id_shop, id_user),
    FOREIGN KEY (id_shop) REFERENCES shop(id_shop) ON DELETE CASCADE,
    FOREIGN KEY (id_user) REFERENCES user(id_user) ON DELETE CASCADE
);

CREATE TABLE image_and_short_video_product (
    id_product INT PRIMARY KEY,
    video varchar(500) null,
    folder_image varchar(500) not null,
    FOREIGN KEY (id_product) REFERENCES product(id_product) ON DELETE CASCADE
);

CREATE TABLE product (
    id_product INT PRIMARY KEY auto_increment,
    name_product VARCHAR(255) not null,
    product_description TEXT not null,
    pre_order int default 0, -- đây để đánh dấu có phải hàng đặt trước không , nếu này lớn hơn 0 nghĩa là số ngày cần để có hàng
    condition_product VARCHAR(255) not null,
    SKU_product VARCHAR(255) null,
    id_category int default null,
    FOREIGN KEY (id_category) REFERENCES category(id_category)
);

CREATE TABLE list_item_in_order (
    id_order int not null,
    id_classification  int not null,
    product_quantity int,
    note_to_seller varchar(500),
    PRIMARY KEY (id_order, id_classification),
    FOREIGN KEY (id_order) REFERENCES user_order(id_order) ON DELETE CASCADE,
    FOREIGN KEY (id_classification) REFERENCES classification_value(id_classification)
);

CREATE TABLE classification (
    id_classification INT PRIMARY KEY,
    classification_name varchar(500) not null,
    id_product int not null,
    FOREIGN KEY (id_product) REFERENCES product(id_product) ON DELETE CASCADE
);

CREATE TABLE classification_value (
    id_classification_value INT PRIMARY KEY,
    classification_value VARCHAR(255),
    price int not null,
    inventory_quantity INT default 0, -- này là số lượng hàng tồn kho
    SKU_classification VARCHAR(255) null,
    packaged_length DECIMAL(10, 2) not null,
    packaged_width DECIMAL(10, 2) not null,
    packaged_weight DECIMAL(10, 2) not null,
    packaged_height DECIMAL(10, 2) not null,
    allowed_package_inspection BOOLEAN default 0, -- này để xem có cho phép kiểm tra hàng trước khi nhận không
    id_classification int not null,
    FOREIGN KEY (id_classification) REFERENCES classification(id_classification) ON DELETE CASCADE
);

CREATE TABLE product_shipping_method (
    id_product_shipping_method INT PRIMARY KEY AUTO_INCREMENT,
    id_classification_value INT not null,
    id_shop_shipping_method INT not null,
    FOREIGN KEY (id_classification_value) REFERENCES classification_value(id_classification_value) ON DELETE CASCADE,
    FOREIGN KEY (id_shop_shipping_method) REFERENCES shop_shipping_method(id_shop_shipping_method) ON DELETE CASCADE
);

CREATE TABLE category (
    id_category INT PRIMARY KEY AUTO_INCREMENT,
    name_category VARCHAR(255) NOT NULL,
    id_parent INT null UNIQUE,
    FOREIGN KEY (parentID) REFERENCES category(id_category) ON DELETE CASCADE
);

CREATE TABLE category_attribute (
    id_category_attribute INT PRIMARY KEY auto_increment,
    name_attribute varchar(500) not null,
    id_category int not null,
    FOREIGN KEY (id_category) REFERENCES category(id_category) ON DELETE CASCADE
);

CREATE TABLE category_value (
    id_product int not null,
    id_category_attribute int not null,
    attribute_value varchar(100),
    PRIMARY KEY (id_product, id_category_attribute),
    FOREIGN KEY (id_product) REFERENCES product(id_product) ON DELETE CASCADE,
    FOREIGN KEY (id_category_attribute) REFERENCES category_attribute(id_category_attribute) ON DELETE CASCADE
);

CREATE TABLE product_review (
    id_user int not null,
    id_product int not null,
    user_comment varchar(500) not null,
    shop_answer varchar(500) null,
    star int not null,
	PRIMARY KEY (id_product, id_category_attribute),
    FOREIGN KEY (id_product) REFERENCES product(id_product) ON DELETE CASCADE,
    FOREIGN KEY (id_category_attribute) REFERENCES category_attribute(id_category_attribute) ON DELETE CASCADE
);






























































































































































































