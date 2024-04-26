-- này là trigger để lưu lại lịch sử thay đổi sau khi chúng ta chỉnh sửa ( gia hạn )
DELIMITER //

CREATE TRIGGER trigger_extend
AFTER UPDATE ON android_phone
FOR EACH ROW
BEGIN
    IF New.id != OLD.id 
    OR New.name_owner != OLD.name_owner 
    OR New.name_phone != OLD.name_phone 
    OR New.id_of_phone != OLD.id_of_phone 
    OR NEW.price != OLD.price 
    OR NEW.start_Date != OLD.start_Date 
    OR NEW.phone_number_owner != OLD.phone_number_owner 
    OR NEW.status != OLD.status
    OR NEW.password != OLD.password
    OR NEW.note != OLD.note THEN
    
        INSERT INTO LichSuThayDoi (Action, DuLieuCu, DuLieuMoi)
        VALUES ('EXTEND', 
        JSON_OBJECT(
        'id', OLD.id,
        'name_owner', OLD.name_owner,
        'name_phone', OLD.name_phone ,
        'id_of_phone', OLD.id_of_phone,
        'price', OLD.price,
        'start_Date', OLD.start_Date,
        'phone_number_owner', OLD.phone_number_owner,
        'status', OLD.status,
        'password', OLD.password,
        'note', OLD.note
			),
		
        JSON_OBJECT(
        'id', NEW.id,
        'name_owner', NEW.name_owner,
        'name_phone', NEW.name_phone ,
        'id_of_phone', NEW.id_of_phone,
        'price', NEW.price,
        'start_Date', NEW.start_Date,
        'phone_number_owner', NEW.phone_number_owner,
        'status', NEW.status,
        'password', NEW.password,
        'note', NEW.note
			)
		);
    END IF;
END //

DELIMITER ;

DISABLE Trigger tien_thanh.trigger_extend ON android_phone

-- này là trigger để lưu lại lịch sử thay đổi sau khi chúng ta chỉnh sửa ( edit )
DELIMITER //

CREATE TRIGGER trigger_edit
AFTER UPDATE ON android_phone
FOR EACH ROW
BEGIN
    IF NEW.start_Date != OLD.start_Date THEN
        INSERT INTO LichSuThayDoi (Action, DuLieuCu, DuLieuMoi)
        VALUES ('EDIT', 
        JSON_OBJECT(
        'id', OLD.id,
        'name_owner', OLD.name_owner,
        'name_phone', OLD.name_phone ,
        'id_of_phone', OLD.id_of_phone,
        'price', OLD.price,
        'start_Date', OLD.start_Date,
        'phone_number_owner', OLD.phone_number_owner,
        'status', OLD.status,
        'password', OLD.password,
        'note', OLD.note
			),
		
        JSON_OBJECT(
        'id', NEW.id,
        'name_owner', NEW.name_owner,
        'name_phone', NEW.name_phone ,
        'id_of_phone', NEW.id_of_phone,
        'price', NEW.price,
        'start_Date', NEW.start_Date,
        'phone_number_owner', NEW.phone_number_owner,
        'status', NEW.status,
        'password', NEW.password,
        'note', NEW.note
			)
		);
    END IF;
END //

DELIMITER ;

-- này là trigger lưu lại lịch sử khi chúng ta thêm dữ liệu mới vào
DELIMITER //

CREATE TRIGGER trigger_add
AFTER INSERT ON android_phone
FOR EACH ROW
BEGIN
    INSERT INTO LichSuThayDoi (Action, DuLieuMoi)
    VALUES ('ADD', JSON_OBJECT(
                    'id', NEW.id,
                    'name_owner', NEW.name_owner,
                    'name_phone', NEW.name_phone,
                    'id_of_phone', NEW.id_of_phone,
                    'price', NEW.price,
                    'start_Date', NEW.start_Date,
                    'phone_number_owner', NEW.phone_number_owner,
                    'status', NEW.status,
                    'password', NEW.password,
                    'note', NEW.note
					)
			);
END //

DELIMITER ;

-- này là trigger lưu lại lịch sử khi chúng ta xoá một dữ liệu nào đó (delete)
DELIMITER //

CREATE TRIGGER trigger_delete
AFTER DELETE ON android_phone
FOR EACH ROW
BEGIN
    INSERT INTO LichSuThayDoi (Action, DuLieuCu)
    VALUES ('DELETE', JSON_OBJECT(
                    'id', OLD.id,
                    'name_owner', OLD.name_owner,
                    'name_phone', OLD.name_phone,
                    'id_of_phone', OLD.id_of_phone,
                    'price', OLD.price,
                    'start_Date', OLD.start_Date,
                    'phone_number_owner', OLD.phone_number_owner,
                    'status', OLD.status,
                    'password', OLD.password,
                    'note', OLD.note
					)
			);
END //

DELIMITER ;

-- này là trigger lưu lại lịch sử khi chúng ta xoá một dữ liệu nào đó (take the product)
DELIMITER //

CREATE TRIGGER trigger_take_the_product
AFTER DELETE ON android_phone
FOR EACH ROW
BEGIN
    INSERT INTO LichSuThayDoi (Action, DuLieuCu)
    VALUES ('TAKE THE PRODUCT', JSON_OBJECT(
                    'id', OLD.id,
                    'name_owner', OLD.name_owner,
                    'name_phone', OLD.name_phone,
                    'id_of_phone', OLD.id_of_phone,
                    'price', OLD.price,
                    'start_Date', OLD.start_Date,
                    'phone_number_owner', OLD.phone_number_owner,
                    'status', OLD.status,
                    'password', OLD.password,
                    'note', OLD.note
					)
			);
END //

DELIMITER ;

ALTER TABLE android_phone DISABLE TRIGGER trigger_take_the_product;
DISABLE TRIGGER myTrigger ON myTable;
ALTER TRIGGER trigger_take_the_product DISABLE;
-- đây là trigger tổng hợp của cả 3 trigger trên (bị lỗi rồi nên không thể viết cả 3 sự kiện vào 1 trigger)
DELIMITER //

CREATE TRIGGER android_phone_history_trigger
AFTER INSERT, UPDATE, DELETE ON android_phone
FOR EACH ROW
BEGIN
    DECLARE action VARCHAR(10);
    DECLARE data_old JSON;
    DECLARE data_new JSON;

    IF (INSERTING) THEN
        SET action = 'INSERT';
        SET data_new = JSON_OBJECT('price', NEW.price, 'status', NEW.status, 'note', NEW.note);
    ELSEIF (UPDATING) THEN
        SET action = 'UPDATE';
        SET data_old = JSON_OBJECT('price', OLD.price, 'status', OLD.status, 'note', OLD.note);
        SET data_new = JSON_OBJECT('price', NEW.price, 'status', NEW.status, 'note', NEW.note);
    ELSEIF (DELETING) THEN
        SET action = 'DELETE';
        SET data_old = JSON_OBJECT('price', OLD.price, 'status', OLD.status, 'note', OLD.note);
    END IF;

    INSERT INTO LichSuThayDoi (Action, DuLieuCu, DuLieuMoi)
    VALUES (action, data_old, data_new);
END //

DELIMITER ;

CALL history_for_update__extend_edit_take_product('gia hạn');

-- thay vì dùng trigger thì dùng trigger bởi vì gian hạn thì sẽ ghi sai action
DELIMITER //

CREATE PROCEDURE history_for_update__extend_edit_take_product(
		action text, 
		id varchar(20),
		name_owner text,
		name_phone text,
		id_of_phone text,
		price int,
		start_Date date,
		phone_number_owner text,
		status text,
		password text,
		note text)
BEGIN
    IF action = 'delete' OR action = 'take_the_product' THEN
        INSERT INTO LichSuThayDoi (Action, DuLieuCu)
        VALUES (
            action,
            JSON_OBJECT(
                'id', OLD.id,
                'name_owner', OLD.name_owner,
                'name_phone', OLD.name_phone,
                'id_of_phone', OLD.id_of_phone,
                'price', OLD.price,
                'start_Date', OLD.start_Date,
                'phone_number_owner', OLD.phone_number_owner,
                'status', OLD.status,
                'password', OLD.password,
                'note', OLD.note
            )
        );
    ELSE
        IF New.id != OLD.id 
    OR New.name_owner != OLD.name_owner 
    OR New.name_phone != OLD.name_phone 
    OR New.id_of_phone != OLD.id_of_phone 
    OR NEW.price != OLD.price 
    OR NEW.start_Date != OLD.start_Date 
    OR NEW.phone_number_owner != OLD.phone_number_owner 
    OR NEW.status != OLD.status
    OR NEW.password != OLD.password
    OR NEW.note != OLD.note THEN
            INSERT INTO LichSuThayDoi (Action, DuLieuCu, DuLieuMoi)
            VALUES (
                action,
                JSON_OBJECT(
                    'id', OLD.id,
                    'name_owner', OLD.name_owner,
                    'name_phone', OLD.name_phone,
                    'id_of_phone', OLD.id_of_phone,
                    'price', OLD.price,
                    'start_Date', OLD.start_Date,
                    'phone_number_owner', OLD.phone_number_owner,
                    'status', OLD.status,
                    'password', OLD.password,
                    'note', OLD.note
                ),
                JSON_OBJECT(
                    'id', NEW.id,
                    'name_owner', NEW.name_owner,
                    'name_phone', NEW.name_phone,
                    'id_of_phone', NEW.id_of_phone,
                    'price', NEW.price,
                    'start_Date', NEW.start_Date,
                    'phone_number_owner', NEW.phone_number_owner,
                    'status', NEW.status,
                    'password', NEW.password,
                    'note', NEW.note
                )
            );
        END IF;
    END IF;
END //

DELIMITER ;


drop trigger trigger_take_the_product;
