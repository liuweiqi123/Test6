/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : db_person

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2019-09-09 19:31:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_department
-- ----------------------------
DROP TABLE IF EXISTS `user_department`;
CREATE TABLE `user_department` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `department_code` varchar(10) DEFAULT NULL COMMENT '部门编码',
  `department_name` varchar(30) DEFAULT NULL COMMENT '部门名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='员工部门表';

-- ----------------------------
-- Records of user_department
-- ----------------------------
INSERT INTO `user_department` VALUES ('1', '1', '技术开发部');
INSERT INTO `user_department` VALUES ('2', '2', '研发部');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(11) NOT NULL COMMENT '用户姓名',
  `password` varchar(50) NOT NULL COMMENT '用户密码',
  `usercode` varchar(30) NOT NULL COMMENT '用户工号',
  `dpartment_code` varchar(30) NOT NULL COMMENT '部门编码',
  `station_code` varchar(50) NOT NULL COMMENT '岗位编码',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '刘炜琪', '123456', '1', '1', '1', '2019-09-02 10:35:44');
INSERT INTO `user_info` VALUES ('2', 'root', '123456', '2', '2', '2', '2019-09-02 22:37:48');

-- ----------------------------
-- Table structure for user_station
-- ----------------------------
DROP TABLE IF EXISTS `user_station`;
CREATE TABLE `user_station` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '职位ID',
  `station_name` varchar(50) DEFAULT NULL COMMENT '职位名称',
  `station_code` varchar(50) DEFAULT NULL COMMENT '职位编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='员工职位';

-- ----------------------------
-- Records of user_station
-- ----------------------------
INSERT INTO `user_station` VALUES ('1', 'java开发工程师', '1');
INSERT INTO `user_station` VALUES ('2', '前端开发工程师', '2');
