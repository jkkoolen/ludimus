ALTER TABLE `user` ADD COLUMN `full_name`  varchar(100) DEFAULT NULL;

update `user` set full_name = 'Jan-Karel Koolen' where `name` = 'jkkoolen';
