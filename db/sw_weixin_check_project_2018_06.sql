/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : sw_weixin_check_project_2018_01

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2018-01-25 20:25:32
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
  `orders` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order` (`orders`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

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
INSERT INTO `goods` VALUES ('13', '单片机', '0', '0', '2012-12-12', '12');
INSERT INTO `goods` VALUES ('14', '单片机', '0', '0', '2012-12-12', '13');
INSERT INTO `goods` VALUES ('15', '单片机', '0', '0', '2012-12-12', '14');
INSERT INTO `goods` VALUES ('16', '单片机', '1', '1', '2018-01-24', '15');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `stuIds` varchar(255) DEFAULT NULL,
  `loantimes` datetime DEFAULT NULL,
  `backtimes` datetime DEFAULT NULL,
  `orders` int(10) unsigned NOT NULL,
  `goodsname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('1', '22', '2018-01-25 20:19:25', '2018-01-25 20:19:29', '1', '单片机');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123456', '胡伟');
INSERT INTO `user` VALUES ('4', '5120164197', '123456', '胡伟');
