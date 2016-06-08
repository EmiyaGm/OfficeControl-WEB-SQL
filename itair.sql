/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : itair

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-05-16 22:22:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for controller
-- ----------------------------
DROP TABLE IF EXISTS `controller`;
CREATE TABLE `controller` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `temp` int(11) NOT NULL DEFAULT '20',
  `kind` int(11) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT '0',
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `controllerUserId` (`userId`),
  KEY `name` (`name`),
  CONSTRAINT `controllerUserId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of controller
-- ----------------------------
INSERT INTO `controller` VALUES ('3', 'ctl89232', '20', '0', '0', '1');
INSERT INTO `controller` VALUES ('5', 'ctl892231', '25', '0', '1', '1');
INSERT INTO `controller` VALUES ('7', 'ctl89234', '20', '0', '1', '6');
INSERT INTO `controller` VALUES ('8', 'ctl89235', '21', '1', '0', '1');

-- ----------------------------
-- Table structure for gather
-- ----------------------------
DROP TABLE IF EXISTS `gather`;
CREATE TABLE `gather` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `inTemp` float DEFAULT NULL,
  `outTemp` float DEFAULT NULL,
  `temp` float DEFAULT NULL,
  `humans` int(11) DEFAULT NULL,
  `humidity` float DEFAULT NULL,
  `light` float DEFAULT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `GatherUserId` (`userId`),
  CONSTRAINT `GatherUserId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gather
-- ----------------------------
INSERT INTO `gather` VALUES ('1', '设备1', '12', '23', null, null, '0.94', null, '1');
INSERT INTO `gather` VALUES ('2', '设备2', '11', '22', null, null, '0.12', null, '1');
INSERT INTO `gather` VALUES ('4', 'wxty67z', null, null, null, null, null, null, '1');
INSERT INTO `gather` VALUES ('5', 'wx78tyxz', null, null, null, null, null, null, '1');
INSERT INTO `gather` VALUES ('8', 'linux', null, null, null, null, null, null, '1');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `comd` longtext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('4', 'ctl89234', '16012,8800,4450,600,600,600,550,600,600,600,1650,600,600,600,600,550,600,600,600,600,1600,650,600,550,600,600,1650,600,600,600,600,600,550,600,600,600,600,550,600,600,600,600,600,550,600,600,1650,600,600,600,600,550,600,600,600,600,550,600,600,600,1650,600,600,600,1650,600,600,600,550,600,1700,550,600,600,19700,600,550,600,600,600,600,550,600,600,600,600,550,600,600,600,600,600,550,600,600,600,600,600,550,600,600,600,1650,600,600,600,550,600,600,600,600,600,550,600,600,600,600,550,600,600,600,600,550,600,600,600,600,600,550,600,600,600,1650,600,550,650,1650,600,1650,600');
INSERT INTO `order` VALUES ('5', 'ctl89234', '8850,-4400,600,-1650,650,-500,650,-550,650,-1600,650,-1600,650,-1650,600,-550,650,-550,650,-500,650,-550,650,-1600,650,-550,650,-550,600,-550,650,-550,650,-500,650,-550,650,-550,650,-500,650,-550,650,-550,650,-1600,650,-550,600,-550,650,-550,650,-500,650,-550,650,-550,650,-1600,650,-550,600,-1650,650,-500,650,-550,650,-1600,650,-550,600,-19650,650,-550,600,-600,600,-550,650,-550,600,-600,600,-550,650,-550,600,-550,650,-550,650,-550,600,-550,650,-550,600,-600,600,-1650,600,-600,600,-550,650,-550,600,-550,650,-550,650,-550,600,-550,650,-550,600,-600,600,-550,650,-550,600,-600,600,-550,650,-550,600,-1650,600,-600,600,-550,650,-1600,650');
INSERT INTO `order` VALUES ('6', 'ctl892231', '8850,-4350,650,-1650,650,-500,650,-550,650,-1600,650,-1600,650,-1600,650,-550,650,-550,650,-1600,650,-550,600,-550,650,-1600,650,-550,650,-550,650,-500,650,-550,650,-550,600,-550,650,-550,650,-500,650,-550,650,-1600,650,-550,600,-600,600,-550,650,-550,600,-550,650,-550,650,-1600,650,-550,600,-1650,650,-550,600,-550,650,-1650,600,-550,650,-19650,600,-550,650,-550,600,-600,600,-550,650,-550,600,-600,600,-550,650,-550,600,-600,600,-550,650,-550,600,-550,650,-550,650,-1600,650,-550,600,-600,600,-550,650,-550,600,-550,650,-550,650,-550,600,-550,650,-550,600,-600,600,-550,650,-550,600,-600,600,-550,650,-550,600,-1650,650,-1600,650,-1600,650');
INSERT INTO `order` VALUES ('7', 'ctl89232', '8850,4400,600,600,600,550,650,1600,650,550,600,600,600,550,650,550,600,600,600,550,650,1600,650,1600,650,1650,600,550,650,550,600,550,650,550,650,550,600,550,650,550,600,600,600,550,650,1600,650,550,600,600,600,550,650,550,600,550,650,550,650,1600,650,550,600,1650,600,600,600,550,650,1600,650,550,600,19650,650,550,600,600,600,550,650,550,600,550,650,550,600,600,600,550,650,550,600,550,650,550,650,550,600,550,650,1650,600,550,650,550,600,550,650,550,600,600,600,550,650,550,600,600,600,550,650,500,650,550,650,550,600,600,600,550,650,550,600,1650,600,1650,650,1600,650');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `addr` varchar(255) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `password` varchar(255) NOT NULL,
  `isSuper` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'user1', '张三', '常熟理工', '15501520655', '123', '0');
INSERT INTO `user` VALUES ('2', 'admin', '李四', '常熟理工', '15501520652', 'admin', '1');
INSERT INTO `user` VALUES ('4', 'user2', '王五', '常熟理工', '18801520988', '123', '0');
INSERT INTO `user` VALUES ('5', 'user3', '林林', '常熟理工', '18812312322', '123', '0');
INSERT INTO `user` VALUES ('6', 'user4', 'linux', '常熟理工', '18712123456', '123', '0');
