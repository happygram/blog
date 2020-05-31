-- DDL
CREATE TABLE `authorities` (
  `username` varchar(50) COLLATE utf8_bin NOT NULL,
  `authority` varchar(50) COLLATE utf8_bin NOT NULL,
  UNIQUE KEY `ix_auth_username` (`username`,`authority`),
  CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `board` (
  `seq_no` int(11) NOT NULL AUTO_INCREMENT,
  `writer` varchar(50) NOT NULL,
  `title` varchar(100) NOT NULL,
  `category_nm` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `reg_dt_tm` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `mod_dt_tm` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `hit` int(11) NOT NULL,
  `hidden` tinyint(1) NOT NULL,
  PRIMARY KEY (`seq_no`),
  KEY `board_categoy_fk` (`category_nm`),
  CONSTRAINT `board_category_fk` FOREIGN KEY (`category_nm`) REFERENCES `category` (`nm`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `category` (
  `order_no` int(11) NOT NULL,
  `nm` varchar(100) NOT NULL,
  `label_nm` varchar(500) NOT NULL,
  PRIMARY KEY (`nm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `file` (
  `seq_no` int(11) NOT NULL AUTO_INCREMENT,
  `origin_nm` varchar(1000) NOT NULL,
  `system_nm` varchar(1000) NOT NULL,
  `board_seq_no` int(11) NOT NULL,
  PRIMARY KEY (`seq_no`),
  KEY `file_board_fk` (`board_seq_no`),
  CONSTRAINT `file_board_fk` FOREIGN KEY (`board_seq_no`) REFERENCES `board` (`seq_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `reply` (
  `seq_no` int(11) NOT NULL AUTO_INCREMENT,
  `writer` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `content` varchar(5000) NOT NULL,
  `reg_dt_tm` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `mod_dt_tm` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `hidden` tinyint(1) NOT NULL,
  `board_seq_no` int(11) NOT NULL,
  PRIMARY KEY (`seq_no`),
  KEY `reply_board_fk` (`board_seq_no`),
  CONSTRAINT `reply_board_fk` FOREIGN KEY (`board_seq_no`) REFERENCES `board` (`seq_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `reply_sub` (
  `seq_no` int(11) NOT NULL AUTO_INCREMENT,
  `writer` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `content` varchar(5000) NOT NULL,
  `reg_dt_tm` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `mod_dt_tm` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `hidden` tinyint(1) NOT NULL,
  `reply_seq_no` int(11) NOT NULL,
  PRIMARY KEY (`seq_no`),
  KEY `reply_sub_reply_sub_fk` (`reply_seq_no`),
  CONSTRAINT `reply_sub_reply_sub_fk` FOREIGN KEY (`reply_seq_no`) REFERENCES `reply_sub` (`seq_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `users` (
  `username` varchar(50) COLLATE utf8_bin NOT NULL,
  `password` varchar(500) COLLATE utf8_bin NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- DML
INSERT INTO blog.users
(username, password, enabled)
VALUES('seongbeom.jeong', '$2a$10$TF5aYn21cisD8nCJqyPIGOoMURGgs0Wx.QoSFgDDk9ygA6hGoSLOq', 1);
INSERT INTO blog.users
(username, password, enabled)
VALUES('hyemi.yu', '$2a$10$bDeQo.IqQdOSKBYPxwUrleDqQmQwO3M1N0H5KLc0iPvAydqDJVu3.', 1);


INSERT INTO blog.authorities
(username, authority)
VALUES('seongbeom.jeong', 'ROLE_ADMIN');
INSERT INTO blog.authorities
(username, authority)
VALUES('hyemi.yu', 'ROLE_ADMIN');