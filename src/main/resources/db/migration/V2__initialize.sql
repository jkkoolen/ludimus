CREATE TABLE `user` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `version` int(11) NOT NULL,
    `created` datetime NULL,
    `last_updated` datetime NULL,
    `name` varchar(255) NOT NULL UNIQUE,
    `password` varchar(255) NOT NULL,
    `active` boolean default false,
    `role` varchar(255) NOT NULL,
    `reset_token` varchar(32) NULL,
    PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT into `user` (`version`,`created`,`last_updated`,`name`,`password`,`active`,`role`,`reset_token`)
	VALUES(0,now(),now(),'admin','21232f297a57a5a743894a0e4a801fc3',TRUE,'ROLE_ADMIN','reset');
INSERT into `user` (`version`,`created`,`last_updated`,`name`,`password`,`active`,`role`,`reset_token`)
	VALUES(0,now(),now(),'user','ee11cbb19052e40b07aac0ca060c23ee',TRUE,'ROLE_USER','reset');