CREATE TABLE `kmr` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `last_updated` datetime NULL,
    `created` datetime NULL,
    `day` datetime NULL,
    `is_business` tinyint(1) DEFAULT TRUE,
    `origin` varchar(100) NOT NULL,
    `destination` varchar(100) NOT NULL,
    `start_total` MEDIUMINT,
    `end_total` MEDIUMINT,
    `user_id` bigint(20) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;