CREATE TABLE `ticket` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `last_updated` datetime NULL,
    `created` datetime NULL,
    `ticket_date` datetime NULL,
    `invoice_number` varchar(100) NOT NULL,
    `description` varchar(255) NOT NULL,
    `price` DECIMAL(10,2),
    `vat_rate` DECIMAL(4,2),
    `ticket_image` MEDIUMBLOB,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
