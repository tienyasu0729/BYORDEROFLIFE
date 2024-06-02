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
