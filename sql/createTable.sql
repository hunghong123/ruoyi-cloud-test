CREATE TABLE `fdu_daily_update` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `today_date` date DEFAULT NULL,
  `student_no` varchar(30) DEFAULT NULL,
  `on_campus` varchar(2) DEFAULT NULL,
  `current_district` varchar(2) DEFAULT NULL,
  `current_location` varchar(30) DEFAULT NULL,
  `temperature` varchar(2) DEFAULT NULL,
  `feeling` varchar(2) DEFAULT NULL,
  `contact1` varchar(2) DEFAULT NULL,
  `contact2` varchar(2) DEFAULT NULL,
  `isolate` varchar(2) DEFAULT NULL,
  `other` varchar(2) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `create_by` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4

CREATE TABLE `fdu_students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `student_no` varchar(30) DEFAULT NULL,
  `mobile` varchar(13) DEFAULT NULL,
  `school` varchar(20) DEFAULT NULL,
  `category` varchar(2) DEFAULT NULL,
  `type` varchar(2) DEFAULT NULL,
  `teacher` varchar(20) DEFAULT NULL,
  `remark` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4

