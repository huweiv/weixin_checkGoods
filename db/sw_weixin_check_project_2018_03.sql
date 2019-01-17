/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : sw_weixin_check_project_2018_01

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2018-01-24 13:07:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `consumables` int(2) DEFAULT NULL,
  `state` int(2) DEFAULT NULL,
  `stortime` date DEFAULT NULL,
  `order` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order` (`order`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('2', '单片机', '0', '0', '2012-12-12', '1');
INSERT INTO `goods` VALUES ('3', '单片机', '0', '1', '2018-01-23', '2');
INSERT INTO `goods` VALUES ('4', '单片机', '0', '0', '2012-12-09', '3');
INSERT INTO `goods` VALUES ('5', '胶带', '1', '0', '2018-12-17', '4');
INSERT INTO `goods` VALUES ('6', '单片机', '0', '0', '2012-12-12', '5');
INSERT INTO `goods` VALUES ('7', '单片机', '0', '0', '2012-12-12', '6');
INSERT INTO `goods` VALUES ('8', '单片机', '0', '0', '2012-12-12', '7');
INSERT INTO `goods` VALUES ('9', '单片机', '0', '0', '2012-12-12', '8');
INSERT INTO `goods` VALUES ('10', '单片机', '0', '0', '2012-12-12', '9');
INSERT INTO `goods` VALUES ('11', '单片机', '0', '0', '2012-12-12', '10');
INSERT INTO `goods` VALUES ('12', '单片机', '0', '0', '2012-12-12', '11');
INSERT INTO `goods` VALUES ('13', '单片机', '0', '0', '2012-12-12', '11');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `stuIds` varchar(255) DEFAULT NULL,
  `loantimes` datetime DEFAULT NULL,
  `backtimes` datetime DEFAULT NULL,
  `order` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `goodsOrder` (`order`),
  CONSTRAINT `goodsOrder` FOREIGN KEY (`order`) REFERENCES `goods` (`order`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `studId` varchar(255) DEFAULT NULL,
  `passward` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`,`studId`),
  KEY `studId` (`studId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123456', '胡伟');
