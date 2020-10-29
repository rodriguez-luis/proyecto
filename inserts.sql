delimiter //
CREATE TRIGGER tg_ins_h_inventory AFTER INSERT  ON inventory
       FOR EACH ROW
       BEGIN
	   INSERT INTO h_inventory VALUES ( 1, NEW.in_stock, NEW.last_update_time, NEW.tx_id, NEW.tx_host, NEW.tx_user_id, NEW.tx_date);
       END;//
delimiter ;

SET FOREIGN_KEY_CHECKS=0;
insert into inventory value(1,5,now(), 1, '192.168.0.1',1, now());
insert into transaction value(1, '192.168.0.1',1, now());


