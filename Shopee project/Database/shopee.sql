CREATE DATABASE IF NOT EXISTS Fake_shopee;
USE Fake_shopee;

create table area (
	area_id int primary key,
    name_area varchar(200)
);

CREATE TABLE main_account (
    main_account_id INT AUTO_INCREMENT PRIMARY KEY,
	business_ID varchar(500),
    password varchar(99),
    account_area int,
    phone_number varchar(14),
    email varchar(500),
	FOREIGN KEY (account_area) REFERENCES area(area_id)
);
    

CREATE TABLE list_email_to_receive_electronic_invoices (
    email_receive_electronic_id INT AUTO_INCREMENT PRIMARY KEY,
    email_address VARCHAR(500 ) NOT NULL,
    main_account_id INT,
    FOREIGN KEY (main_account_id) REFERENCES main_account(main_account_id)
);

CREATE TABLE partner_platform (
    platform_id INT AUTO_INCREMENT PRIMARY KEY,
    main_account_id INT,
    FOREIGN KEY (main_account_id) REFERENCES main_account(main_account_id)
);

CREATE TABLE payment_settings (
    payment_settings_id INT AUTO_INCREMENT PRIMARY KEY,
    automatic_withdrawal boolean,
    pin_code VARCHAR(255),
    main_account_id INT,
    FOREIGN KEY (main_account_id) REFERENCES main_account(main_account_id)
);

CREATE TABLE chat_settings (
    chat_settings_id INT AUTO_INCREMENT PRIMARY KEY,
    Receive_messages_from_Shopee_Rewards BOOLEAN,
    Receive_messages_from_Personal_Page BOOLEAN,
    Play_sound_notification_for_new_messages BOOLEAN,
    Push_new_popup_message BOOLEAN,
    main_account_id INT,
    FOREIGN KEY (main_account_id) REFERENCES main_account(main_account_id)
);

CREATE TABLE notification_settings (
    notification_settings_id INT AUTO_INCREMENT PRIMARY KEY,
    order_update_notification boolean,
    Newsletter_notification boolean,
    Product_Update_Notification boolean,
    Personal_Content_Notification boolean,
    Chat_Messages_Reminder boolean,
    main_account_id INT,
    FOREIGN KEY (main_account_id) REFERENCES main_account(main_account_id)
);

CREATE TABLE shop (
    shop_id INT AUTO_INCREMENT PRIMARY KEY,
    phone_number VARCHAR(15) NOT NULL,
    shop_name VARCHAR(100) NOT NULL,
	email VARCHAR(500 ) NOT NULL,
	password VARCHAR(99) NOT NULL,
	shop_avatar_image VARCHAR(500 ) NOT NULL,
	status boolean default 0 not null ,
    main_account_id INT,
    FOREIGN KEY (main_account_id) REFERENCES main_account(main_account_id)
);

CREATE TABLE business_information (
    business_id INT AUTO_INCREMENT PRIMARY KEY,
    business_type VARCHAR(100) NOT NULL,
    address_to_take_product VARCHAR(100) NOT NULL,
    registered_business_address  VARCHAR(100) NOT NULL,
    tax_identìication_number VARCHAR(50),
    shop_id INT,
    FOREIGN KEY (shop_id) REFERENCES shop(shop_id)
);

create table form_of_identification (
	form_id int auto_increment primary key,
    name_form varchar(500)
);

CREATE TABLE identification_shop (
    identification_shop_id INT AUTO_INCREMENT PRIMARY KEY,
    form_of_identification int not null,
    identification_number varchar(500) not null,
    identification_name varchar(500) not null,
    image_identification_front varchar(500) not null,
    image_identification_back varchar(500) not null,
    shgop_id INT,
    FOREIGN KEY (shop_id) REFERENCES shop(shop_id)
);

CREATE TABLE shipping_method (
    shipping_method_id INT AUTO_INCREMENT PRIMARY KEY,
    method_name VARCHAR(100)
);

CREATE TABLE shop_shipping_method (
    shop_shipping_method_id INT AUTO_INCREMENT PRIMARY KEY,
    shop_id INT,
    shipping_method_id INT,
    FOREIGN KEY (shop_id) REFERENCES shop(shop_id),
    FOREIGN KEY (shipping_method_id) REFERENCES shipping_method(shipping_method_id)
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
    id INT PRIMARY KEY,
    phone_number  VARCHAR(15) NOT NULL,
    password  VARCHAR(99) NOT NULL,
    account_name varchar(500) not null,
    real_name  VARCHAR(500),
    email varchar(500),
    sex char,
    date_of_birth date,
    avatar_image varchar(500),
    joining_date DATE DEFAULT (current_date())
);

CREATE TABLE user_wallet (
    id_wallet INT PRIMARY KEY auto_increment,
	user_wallet int
);

CREATE TABLE identification_information (
    id INT PRIMARY KEY auto_increment,
    cccd VARCHAR(12) NOT NULL,
    image_selfie VARCHAR(500),
    image_cccd_front  VARCHAR(500),
    image_cccd_back VARCHAR(500)
);

CREATE TABLE user_orders (
    id INT PRIMARY KEY auto_increment,
	order_number int,
    spending long
);

CREATE TABLE user_notifications (
    id INT PRIMARY KEY auto_increment,
	email_notification_switch boolean,
	order_update_via_email boolean,
	promotional_email_notification boolean,
	survey_notification_via_email boolean,
	SMS_notification_switch boolean,
	promotional_SMS_notification boolean
);

CREATE TABLE address (
    id INT PRIMARY KEY,
    name_address VARCHAR(255),
	phone_number  VARCHAR(15) NOT NULL,
    apartment_number VARCHAR(255),
    street_name VARCHAR(255),
    District VARCHAR(255),
    Ward VARCHAR(255),
    city VARCHAR(255),
    is_default BOOLEAN
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






























































































































































































