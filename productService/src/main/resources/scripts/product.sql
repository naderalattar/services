drop database if exists products;
create database products;
use products;

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;


INSERT INTO `product` VALUES (1,'description 1','labtob',900.00),(2,'description 2 ','oven',5500.00),(3,'description 3','fan',6500.00);

