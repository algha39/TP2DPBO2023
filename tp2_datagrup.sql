/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : tp2_datagrup

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2023-04-15 22:15:14
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `akun`
-- ----------------------------
DROP TABLE IF EXISTS `akun`;
CREATE TABLE `akun` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of akun
-- ----------------------------
INSERT INTO `akun` VALUES ('1', 'admin', 'admin');
INSERT INTO `akun` VALUES ('16', 'alga', 'alga');
INSERT INTO `akun` VALUES ('20', 'nopal', 'nopal');

-- ----------------------------
-- Table structure for `grup`
-- ----------------------------
DROP TABLE IF EXISTS `grup`;
CREATE TABLE `grup` (
  `id_grup` int(11) NOT NULL AUTO_INCREMENT,
  `nama_grup` varchar(255) NOT NULL,
  `foto_grup` varchar(255) NOT NULL,
  PRIMARY KEY (`id_grup`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of grup
-- ----------------------------
INSERT INTO `grup` VALUES ('7', 'Twice', 'Twice.png');

-- ----------------------------
-- Table structure for `idol`
-- ----------------------------
DROP TABLE IF EXISTS `idol`;
CREATE TABLE `idol` (
  `id_idol` int(11) NOT NULL AUTO_INCREMENT,
  `id_grup` int(11) NOT NULL,
  `nama_idol` varchar(255) NOT NULL,
  `foto_idol` varchar(255) NOT NULL,
  PRIMARY KEY (`id_idol`),
  KEY `id_grup` (`id_grup`),
  CONSTRAINT `idol_ibfk_1` FOREIGN KEY (`id_grup`) REFERENCES `grup` (`id_grup`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of idol
-- ----------------------------
INSERT INTO `idol` VALUES ('26', '7', 'momo', 'src\\assets\\momo.jpg');
