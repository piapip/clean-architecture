DROP DATABASE IF EXISTS `travelling_certificate`;
CREATE DATABASE `travelling_certificate`; 
USE `travelling_certificate`;

SET NAMES utf8 ;
SET character_set_client = utf8mb4 ;

CREATE TABLE `certificate_info` (
	`id` varChar(16) NOT NULL,
    `type` int NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- For prepaid card 
INSERT INTO `certificate_info` VALUES('9ac2197d9258257b', '3');
INSERT INTO `certificate_info` VALUES('c34ab6abb7b2bb59', '3');
INSERT INTO `certificate_info` VALUES('2f858775d71cc4ec', '3');
INSERT INTO `certificate_info` VALUES('acea9bbeb39f5ff3', '3');

-- For oneway ticket 
INSERT INTO `certificate_info` VALUES('e8dc4081b13434b4', '1');
INSERT INTO `certificate_info` VALUES('7885fd6de6fc9a36', '1');
INSERT INTO `certificate_info` VALUES('50221250d5a5d20c', '1');

-- For hour24 ticket
INSERT INTO `certificate_info` VALUES('07c84c6c4ba59f88', '2');
INSERT INTO `certificate_info` VALUES('45fcaeafd8ebec14', '2');
INSERT INTO `certificate_info` VALUES('bab1246b02772bb0', '2');

CREATE TABLE `prepaid_card` (
	`id` varChar(16) NOT NULL,
    `balance` double NOT NULL,
    FOREIGN KEY (`id`) REFERENCES certificate_info(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `prepaid_card` VALUES('9ac2197d9258257b', '18.5'); -- ABCDEFGH
INSERT INTO `prepaid_card` VALUES('c34ab6abb7b2bb59', '18.5'); -- AAAAAAAA
INSERT INTO `prepaid_card` VALUES('2f858775d71cc4ec', '2.4'); -- BBBBBBBB
INSERT INTO `prepaid_card` VALUES('acea9bbeb39f5ff3', '0.0'); -- CCCCCCCC

CREATE TABLE `oneway_ticket` (
	`id` varChar(16) NOT NULL,
	`status` tinyint(5) NOT NULL DEFAULT 0,
    `d_start_station_ID` tinyint(10),
	`d_end_station_ID` tinyint(10),
	`d_fare` double NOT NULL,
    FOREIGN KEY (`id`) REFERENCES certificate_info(id),
    FOREIGN KEY (`d_start_station_ID`) REFERENCES station_system.station(id),
    FOREIGN KEY (`d_end_station_ID`) REFERENCES station_system.station(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `oneway_ticket` VALUES('e8dc4081b13434b4', '0','4', '9','4.7'); -- abcdefgh 17.5 e8dc4081b13434b4
INSERT INTO `oneway_ticket` VALUES('7885fd6de6fc9a36', '1','5', '6','1.9'); -- lgfdkawl 3.1 7885fd6de6fc9a36
INSERT INTO `oneway_ticket` VALUES('50221250d5a5d20c', '2','3', '6','3.1'); -- kdcesheo 10.4 50221250d5a5d20c

CREATE TABLE `hour24_ticket` (
	`id` varChar(16) NOT NULL,
	`status` tinyint(5) NOT NULL DEFAULT 0,
    `activeTime` DATETIME,
	`expiredTime` DATETIME,
    FOREIGN KEY (`id`) REFERENCES certificate_info(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `hour24_ticket` VALUES('07c84c6c4ba59f88', '0', null,null);-- ijklmnop
INSERT INTO `hour24_ticket` VALUES('45fcaeafd8ebec14', '3','2019-11-25 12:17:17','2019-11-25 17:00:00');-- tttttttt
INSERT INTO `hour24_ticket` VALUES('bab1246b02772bb0', '1', '2019-12-04 12:17:17','2019-12-05 12:00:00');-- pomnlkji
