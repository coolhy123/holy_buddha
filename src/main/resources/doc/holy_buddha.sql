/*
Navicat MySQL Data Transfer

Source Server         : hydu
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : holy_buddha

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-06-07 23:20:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `permission_id` int(10) NOT NULL COMMENT '权限id',
  `request_url` varchar(50) DEFAULT NULL COMMENT '请求url',
  `permission_name` varchar(50) DEFAULT NULL COMMENT '权限名称',
  `permission_status` varchar(50) DEFAULT NULL COMMENT '权限标识',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('0', '/addMember', 'addMember', '0');
INSERT INTO `permission` VALUES ('1', '/showMember', 'showMember', '0');
INSERT INTO `permission` VALUES ('2', '/deleteMember', 'deleteMember', '0');
INSERT INTO `permission` VALUES ('3', '/updateMember', 'updateMember', '0');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名',
  `role_description` varchar(50) DEFAULT NULL COMMENT '角色说明',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('0', 'admin', '超级管理员');
INSERT INTO `role` VALUES ('1', 'add', '添加管理员');
INSERT INTO `role` VALUES ('2', 'delete', '删除管理员');
INSERT INTO `role` VALUES ('3', 'update', '更新管理员');
INSERT INTO `role` VALUES ('4', 'show', '查询管理员');

-- ----------------------------
-- Table structure for `role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `role_id` int(10) NOT NULL COMMENT '角色id',
  `permission_id` int(10) NOT NULL COMMENT '权限id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('0', '1');
INSERT INTO `role_permission` VALUES ('0', '2');
INSERT INTO `role_permission` VALUES ('0', '0');
INSERT INTO `role_permission` VALUES ('0', '3');
INSERT INTO `role_permission` VALUES ('1', '0');
INSERT INTO `role_permission` VALUES ('2', '2');
INSERT INTO `role_permission` VALUES ('3', '3');
INSERT INTO `role_permission` VALUES ('4', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'userid',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名称',
  `user_real_name` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `create_date` date DEFAULT NULL COMMENT '创建时间',
  `last_login_time` date DEFAULT NULL COMMENT '最后登录时间',
  `overdue` int(5) DEFAULT NULL COMMENT '是否过期0否、1是',
  `user_status` int(5) DEFAULT '1' COMMENT '是否可用0否 1是',
  `islocking` int(5) DEFAULT NULL COMMENT '是否锁定0否、1是',
  `certificate_overdue` int(5) DEFAULT NULL COMMENT '证书是否过期0否、1是',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0', 'admin', 'heyong', 'admin', '2020-06-07', '2020-06-07', '0', '1', '0', '0');
INSERT INTO `user` VALUES ('1', 'heyong', 'heyong', 'heyong', '2020-06-07', '2020-06-07', '0', '1', '0', '0');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` int(10) NOT NULL COMMENT '用户id',
  `role_id` int(10) NOT NULL COMMENT '角色id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('0', '0');
INSERT INTO `user_role` VALUES ('1', '4');
