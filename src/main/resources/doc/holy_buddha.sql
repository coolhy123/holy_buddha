/*
Navicat MySQL Data Transfer

Source Server         : heyong1
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : holy_buddha

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-06-09 15:30:22
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
INSERT INTO `permission` VALUES ('0', '/addMember', '添加用户', 'addMember');
INSERT INTO `permission` VALUES ('1', '/showMember', '查询用户', 'showMember');
INSERT INTO `permission` VALUES ('2', '/deleteMember', '删除用户', 'deleteMember');
INSERT INTO `permission` VALUES ('3', '/updateMember', '更新用户', 'updateMember');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名',
  `role_description` varchar(50) DEFAULT NULL COMMENT '角色说明',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

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
  `id` int(10) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `realname` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `lastLoginTime` date DEFAULT NULL,
  `enabled` int(5) DEFAULT NULL,
  `accountNonExpired` int(5) DEFAULT NULL,
  `accountNonLocked` int(5) DEFAULT NULL,
  `credentialsNonExpired` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0', 'admin', '何永', '2c8e5dfa187f49630f27d969a8cb3d8d', '2018-11-13', '2018-11-13', '1', '1', '1', '1');
INSERT INTO `user` VALUES ('1', 'heyong', '何永', 'e2693cd3f8ed9bcc3821f3f8a9ff081c', '2018-11-13', '2018-11-13', '1', '1', '1', '1');

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
