DROP DATABASE IF EXISTS `transaction_history`;
CREATE DATABASE `transaction_history`; 
USE `transaction_history`;

SET NAMES utf8 ;
SET character_set_client = utf8mb4 ;

CREATE TABLE `transactions` (
	`id` int NOT NULL AUTO_INCREMENT,
    `certificateID` varChar(16) NOT NULL,
    `status` tinyint(5) NOT NULL,
    `time_In` DATETIME,
    `time_Out` DATETIME,
	`embarking_station_ID` tinyint(10),
	`ending_station_ID` tinyint(10),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`certificateID`) REFERENCES travelling_certificate.certificate_info(id),
    FOREIGN KEY (`embarking_station_ID`) REFERENCES station_system.station(id),
    FOREIGN KEY (`ending_station_ID`) REFERENCES station_system.station(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- For prepaid card  
INSERT INTO `transactions` VALUES('1', '9ac2197d9258257b', '1', '2019-11-08 13:17:17', null, '2', null);
INSERT INTO `transactions` VALUES('2', 'c34ab6abb7b2bb59', '2', '2019-11-08 13:17:17', '2019-11-08 13:17:17', '3', '7');
INSERT INTO `transactions` VALUES('3', '2f858775d71cc4ec', '0', null, null, null, null);
INSERT INTO `transactions` VALUES('7', 'c34ab6abb7b2bb59', '0', null, null, null, null);
INSERT INTO `transactions` VALUES('10', 'acea9bbeb39f5ff3', '0', null, null, null, null);

-- For oneway ticket  
INSERT INTO `transactions` VALUES('4', 'e8dc4081b13434b4', '0', null, null, null, null); -- abcdefgh 17.5 e8dc4081b13434b4
INSERT INTO `transactions` VALUES('5', '7885fd6de6fc9a36', '1', '2019-11-08 14:16:17', null, '5', null);  -- lgfdkawl 3.1 7885fd6de6fc9a36
INSERT INTO `transactions` VALUES('6', '50221250d5a5d20c', '2', '2019-11-08 17:17:17', '2019-11-08 18:17:17', '4', '5');  -- kdcesheo 10.4 50221250d5a5d20c

-- For 24hour ticket
INSERT INTO `transactions` VALUES('8','07c84c6c4ba59f88', '0',null,null,null,null); -- ijklmnop 
INSERT INTO `transactions` VALUES('9','45fcaeafd8ebec14', '1','2019-11-25 12:17:17',null,'2',null); -- tttttttt




