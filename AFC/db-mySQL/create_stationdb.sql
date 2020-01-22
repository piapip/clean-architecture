DROP DATABASE IF EXISTS `station_system`;
CREATE DATABASE `station_system`; 
USE `station_system`;

SET NAMES utf8 ;
SET character_set_client = utf8mb4 ;

CREATE TABLE `station` (
	`id` tinyint(10) NOT NULL AUTO_INCREMENT,
    `name` varchar(50) NOT NULL,
    `distance_to_terminus` double NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `station` VALUES('1', 'Saint-Lazare', '0.0');
INSERT INTO `station` VALUES('2', 'Madelein', '5.0');
INSERT INTO `station` VALUES('3', 'Pyramides', '8.5');
INSERT INTO `station` VALUES('4', 'Chatelet', '11.3');
INSERT INTO `station` VALUES('5', 'Gare de Lyon', '15.8');
INSERT INTO `station` VALUES('6', 'Bercy', '18.9');
INSERT INTO `station` VALUES('7', 'Cour Saint-Emilion', '22.0');
INSERT INTO `station` VALUES('8', 'Bibliotheque', '25.3');
INSERT INTO `station` VALUES('9', 'Olympiade', '28.8');
