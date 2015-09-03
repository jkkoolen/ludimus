CREATE TABLE `action` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `last_updated` datetime NULL,
    `created` datetime NULL,
    `value` varchar(100) NOT NULL,
    `user_id` bigint(20) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `hours` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `last_updated` datetime NULL,
    `created` datetime NULL,
    `user_id` bigint(20) NOT NULL,
    `action_id` bigint(20) NOT NULL,
    `date` DATE NOT NULL,
    `start_time` TIME NOT NULL,
    `end_time` TIME NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE `ticket` ADD COLUMN `user_id` bigint(20) NOT NULL;