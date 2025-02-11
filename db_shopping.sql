/*
Navicat MySQL Data Transfer

Source Server         : a
Source Server Version : 80024
Source Host           : localhost:3306
Source Database       : db_shopping

Target Server Type    : MYSQL
Target Server Version : 80024
File Encoding         : 65001

Date: 2024-10-10 17:28:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_address
-- ----------------------------
DROP TABLE IF EXISTS `tb_address`;
CREATE TABLE `tb_address` (
  `aid` int NOT NULL AUTO_INCREMENT,
  `mno` int DEFAULT NULL,
  `mname` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `tel` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `addr` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `state` int DEFAULT NULL,
  `flag` int DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `a_id` int NOT NULL AUTO_INCREMENT,
  `a_name` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `a_pwd` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `a_role` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `a_state` int DEFAULT NULL,
  PRIMARY KEY (`a_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for tb_cart
-- ----------------------------
DROP TABLE IF EXISTS `tb_cart`;
CREATE TABLE `tb_cart` (
  `cno` int NOT NULL,
  `mno` int DEFAULT NULL,
  `pno` int DEFAULT NULL,
  `num` int DEFAULT NULL,
  PRIMARY KEY (`cno`),
  KEY `fk_mno` (`mno`),
  CONSTRAINT `fk_mno` FOREIGN KEY (`mno`) REFERENCES `tb_member` (`mno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for tb_member
-- ----------------------------
DROP TABLE IF EXISTS `tb_member`;
CREATE TABLE `tb_member` (
  `mno` int NOT NULL AUTO_INCREMENT,
  `nickName` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `sex` varchar(4) COLLATE utf8mb4_bin DEFAULT NULL,
  `password` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `tel` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `mpic` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `state` int DEFAULT NULL,
  `temp01` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`mno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `ono` varchar(200) COLLATE utf8mb4_bin NOT NULL,
  `aid` int DEFAULT NULL,
  `mno` int DEFAULT NULL,
  `totalprice` float(10,2) DEFAULT NULL,
  `order_date` datetime DEFAULT NULL,
  `pay_date` datetime DEFAULT NULL,
  `finish_date` datetime DEFAULT NULL,
  PRIMARY KEY (`ono`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for tb_order_item
-- ----------------------------
DROP TABLE IF EXISTS `tb_order_item`;
CREATE TABLE `tb_order_item` (
  `iid` int NOT NULL AUTO_INCREMENT,
  `ono` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL,
  `pno` int DEFAULT NULL,
  `num` int DEFAULT NULL,
  `price` float(10,2) DEFAULT NULL,
  PRIMARY KEY (`iid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for tb_product
-- ----------------------------
DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE `tb_product` (
  `pno` int NOT NULL AUTO_INCREMENT,
  `tno` int DEFAULT NULL,
  `pname` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `price` float(10,2) DEFAULT NULL,
  `salePrice` float(10,2) DEFAULT NULL,
  `unit` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `weight` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `pics` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `balance` int DEFAULT NULL,
  `mark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `state` int DEFAULT NULL,
  `pro_temp` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`pno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for tb_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_type`;
CREATE TABLE `tb_type` (
  `tno` int NOT NULL AUTO_INCREMENT,
  `tname` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `state` int DEFAULT NULL,
  PRIMARY KEY (`tno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
