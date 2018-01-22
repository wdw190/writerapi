CREATE TABLE `roles` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(45) NOT NULL,
  `roledesc` varchar(128) NOT NULL,
  PRIMARY KEY (`roleid`),
  UNIQUE KEY `uni_username_role` (`role`,`roledesc`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

