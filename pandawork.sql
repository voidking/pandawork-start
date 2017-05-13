/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : pandawork

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-05-13 14:48:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'voidking', 'voidking-new');
INSERT INTO `t_user` VALUES ('3', 'voidking', 'voidking');
INSERT INTO `t_user` VALUES ('4', 'voidking', 'voidking');
INSERT INTO `t_user` VALUES ('5', 'voidking', 'voidking');
INSERT INTO `t_user` VALUES ('6', 'voidking', 'voidking');
INSERT INTO `t_user` VALUES ('7', 'voidking', 'voidking');
