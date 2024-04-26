-- SELECT * FROM android_phone WHERE start_Date < '2023-04-22';

alter table android_phone add name_of_the_phone text;

select * from android_phone order by android_phone.id desc;

ALTER TABLE android_phone
ADD COLUMN phone_number_owner TEXT AFTER start_Date;