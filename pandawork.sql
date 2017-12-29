/*
Navicat MySQL Data Transfer

Source Server         : laragon
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : pandawork

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-12-29 11:28:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_admin`
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'voidking', 'voidking');

-- ----------------------------
-- Table structure for `t_line`
-- ----------------------------
DROP TABLE IF EXISTS `t_line`;
CREATE TABLE `t_line` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `bus_name` varchar(32) NOT NULL,
  `full_name` tinytext NOT NULL,
  `first_stop` varchar(32) DEFAULT NULL,
  `last_stop` varchar(32) DEFAULT NULL,
  `deleted` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_line
-- ----------------------------
INSERT INTO `t_line` VALUES ('1', '160', '160路', '净月潭', '长春站', '0');
INSERT INTO `t_line` VALUES ('2', '281', '281路', '东方万达城', '长春站', '0');
INSERT INTO `t_line` VALUES ('4', '306', '306路', '市政府', '长春站', '0');
INSERT INTO `t_line` VALUES ('5', '164', '164路', '欧亚卖场', '长信学院', '0');
INSERT INTO `t_line` VALUES ('6', '88', '88路', '卫星广场', '长春站北口', '0');
INSERT INTO `t_line` VALUES ('7', '218', '218路A线', '光华学院', '朝阳公园', '0');
INSERT INTO `t_line` VALUES ('8', '124', '124路', '富锋', '太阳城', '0');
INSERT INTO `t_line` VALUES ('9', '222', '222路', '高新开发区', '长春站', '0');
INSERT INTO `t_line` VALUES ('10', '80', '80路', '体育场', '体育场', '0');
INSERT INTO `t_line` VALUES ('11', '110', '110路', '华正批发', '后水泉', '0');
INSERT INTO `t_line` VALUES ('12', '54', '54路', '西安大路', '工农大路', '0');
INSERT INTO `t_line` VALUES ('13', '17', '17路', '般若寺', '中海水岸春城', '0');
INSERT INTO `t_line` VALUES ('14', '17', '17路', '般若寺', '中海水岸春城', '1');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  `email` varchar(64) DEFAULT NULL,
  `tel` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'voidking', 'voidking-new', 'voidking@qq.com', '15195890000');
INSERT INTO `t_user` VALUES ('3', 'voidking3', 'voidking', null, null);
INSERT INTO `t_user` VALUES ('4', 'haojin', 'haojin', null, null);
INSERT INTO `t_user` VALUES ('5', 'voidking', 'voidking', null, null);
