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
    product_group_id INT AUTO_INCREMENT PRIMARY KEY,
    name_group VARCHAR(100),
    shop_id INT,
    FOREIGN KEY (shop_id) REFERENCES shop(shop_id)
);

CREATE TABLE product_shipping_method (
    product_shipping_method_id INT AUTO_INCREMENT PRIMARY KEY,
    id_classification INT,
    shop_shipping_method_id INT,
    FOREIGN KEY (id_classification) REFERENCES product(product_id),
    FOREIGN KEY (shop_shipping_method_id) REFERENCES shop_shipping_method(shop_shipping_method_id)
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

CREATE TABLE user_orders (
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
    id INT PRIMARY KEY,
    number_coin INT,
    notification_subject VARCHAR(255),
    notification_receipt_date DATE
);

CREATE TABLE payment_method (
    id_payment_metod INT PRIMARY KEY,
    payment_method_name VARCHAR(255)
);

CREATE TABLE shop_voucher (
    id_shop_voucher INT PRIMARY KEY,
    discount_percentage FLOAT,
    maximum_discount_amount int,
    discount_start_date DATE,
    discount_end_date DATE,
    offer_description TEXT,
    đơn_vị_vận_chuyển VARCHAR(255),
    thiết_bị VARCHAR(255)
);

CREATE TABLE web_voucher (
    id_shop_voucher INT PRIMARY KEY,
    discount_percentage FLOAT,
    maximum_discount_amount int,
    discount_start_date DATE,
    discount_end_date DATE,
    offer_description TEXT,
    đơn_vị_vận_chuyển VARCHAR(255),
    thiết_bị VARCHAR(255)
);

CREATE TABLE delivery_voucher (
    id_shop_voucher INT PRIMARY KEY,
    discount_percentage FLOAT,
    maximum_discount_amount int,
    discount_start_date DATE,
    discount_end_date DATE,
    offer_description TEXT,
    đơn_vị_vận_chuyển VARCHAR(255),
    thiết_bị VARCHAR(255)
);

CREATE TABLE user_order (
    id_order INT PRIMARY KEY,
    total_price int
);

CREATE TABLE blocked_user (
    id_blocked_user INT PRIMARY KEY,
    block_dateTime datetime
);

CREATE TABLE image_and_short_video_product (
    id_blocked_user INT PRIMARY KEY,
    video varchar(500),
    folder_image varchar(500)
);

CREATE TABLE product (
    id INT PRIMARY KEY,
    name_product VARCHAR(255),
    product_description TEXT,
    pre_order BOOLEAN,
    condition_product VARCHAR(255),
    SKU_product VARCHAR(255)
);

CREATE TABLE list_item_in_order (
    id_list INT PRIMARY KEY,
    product_quantity int,
    note_to_seller varchar(500)
);

CREATE TABLE classification_value (
    id INT PRIMARY KEY,
    classification VARCHAR(255),
    price DECIMAL(10, 2),
    inventory_quantity INT,
    SKU_classification VARCHAR(255),
    packaged_length DECIMAL(10, 2),
    packaged_width DECIMAL(10, 2),
    packaged_weight DECIMAL(10, 2),
    packaged_height DECIMAL(10, 2),
    allowed_package_inspection BOOLEAN
);

CREATE TABLE classification (
    id_classification  INT PRIMARY KEY,
    classification_name varchar(500)
);

CREATE TABLE category (
    id_category INT PRIMARY KEY,
    name_category varchar(500)
    
);

CREATE TABLE category_attribute (
    id_category_attribute INT PRIMARY KEY,
    attribute_name varchar(500)
);

CREATE TABLE category_value (
    id_category_value INT PRIMARY KEY,
    attribute_value  varchar(500)
);

CREATE TABLE product_review (
    id_review INT PRIMARY KEY,
    user_comment varchar(500),
    shop_answer varchar(500),
    star int
);






























































































































































































