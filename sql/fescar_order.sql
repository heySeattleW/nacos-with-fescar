/*
Navicat MySQL Data Transfer

Source Server         : 新网管
Source Server Version : 50614
Source Host           : localhost:33660
Source Database       : fescar_order

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2019-03-19 16:11:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `order_price` decimal(10,2) NOT NULL,
  `order_status` int(2) NOT NULL DEFAULT '0' COMMENT '订单状态，默认0未支付，1是已支付',
  `goods_id` int(4) NOT NULL,
  `user_id` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('2', '200.20', '0', '1', '1');
INSERT INTO `order_detail` VALUES ('3', '200.20', '0', '1', '1');
INSERT INTO `order_detail` VALUES ('4', '200.20', '0', '1', '1');
INSERT INTO `order_detail` VALUES ('5', '200.20', '0', '1', '1');
INSERT INTO `order_detail` VALUES ('6', '200.20', '0', '1', '1');
INSERT INTO `order_detail` VALUES ('7', '200.20', '0', '1', '1');
INSERT INTO `order_detail` VALUES ('8', '200.20', '0', '1', '1');
INSERT INTO `order_detail` VALUES ('9', '200.20', '1', '1', '1');
INSERT INTO `order_detail` VALUES ('10', '200.20', '1', '1', '1');
INSERT INTO `order_detail` VALUES ('11', '200.20', '1', '1', '1');
INSERT INTO `order_detail` VALUES ('12', '200.20', '1', '1', '1');

-- ----------------------------
-- Table structure for `undo_log`
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  `ext` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of undo_log
-- ----------------------------
