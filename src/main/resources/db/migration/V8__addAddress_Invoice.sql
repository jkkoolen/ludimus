drop table  if exists `hours`;
drop table  if exists `action`;

CREATE TABLE `address` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `version` int(11) NOT NULL,
    `last_updated` datetime NULL,
    `created` datetime NULL,
    `user_id` bigint(20) NOT NULL,
    `street` varchar(80) NOT NULL,
    `street_number` varchar(20) NOT NULL,
    `postalcode` varchar(20) NOT NULL,
    `city` varchar(80) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `user` ADD COLUMN `bank`  varchar(50) DEFAULT NULL;
ALTER TABLE `user` ADD COLUMN `iban`  varchar(50) DEFAULT NULL;
ALTER TABLE `user` ADD COLUMN `bic`  varchar(50) DEFAULT NULL;
ALTER TABLE `user` ADD COLUMN `coc`  bigint(20)  DEFAULT NULL;
ALTER TABLE `user` ADD COLUMN `vat_number` varchar(20) DEFAULT NULL;

update `user` set bank = 'rabobank',iban = 'NL03RABO0165839546',bic='RABONL2U',coc=60892528,vat_number='NL152819502B01' where `name` = 'jkkoolen';
INSERT into `address` (`version`,`created`,`last_updated`,`user_id`,`street`,`street_number`,`postalcode`,`city`)
	VALUES(0,now(),now(),(select id from `user` where name = 'jkkoolen'),'Mattenbiesstraat','137','1087GC','Amsterdam');