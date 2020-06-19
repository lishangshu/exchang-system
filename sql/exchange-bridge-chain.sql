/*
 Navicat Premium Data Transfer

 Source Server         : fuxizhiku-Test
 Source Server Type    : MySQL
 Source Server Version : 50614
 Source Host           : 47.94.247.60:3306
 Source Schema         : exchange-bridge-chain

 Target Server Type    : MySQL
 Target Server Version : 50614
 File Encoding         : 65001

 Date: 19/06/2020 13:57:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account_address
-- ----------------------------
DROP TABLE IF EXISTS `account_address`;
CREATE TABLE `account_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '客户账户信息id',
  `user_code` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '关联的客户信息',
  `address` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地址信息',
  `public_key` varchar(150) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '公钥',
  `private_key` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '私钥',
  `credentials` text COLLATE utf8mb4_unicode_ci COMMENT '证书文件内容',
  `balance` decimal(20,8) DEFAULT NULL COMMENT '预留',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(1) DEFAULT NULL COMMENT '是否可用',
  `ext_1` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '扩展1',
  `ext_2` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '扩展2',
  `ext_3` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '扩展3',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_code` (`user_code`),
  UNIQUE KEY `address` (`address`),
  KEY `address0` (`address`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for transaction_log
-- ----------------------------
DROP TABLE IF EXISTS `transaction_log`;
CREATE TABLE `transaction_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `address` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '合约地址',
  `block_hash` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '块hash',
  `block_number` int(11) DEFAULT NULL COMMENT '块高度',
  `data` text COLLATE utf8mb4_unicode_ci COMMENT '数据内容（需解析）',
  `log_index` bigint(20) DEFAULT NULL COMMENT '块内日志编号',
  `removed` tinyint(1) DEFAULT NULL COMMENT '0否1是',
  `transaction_hash` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '交易哈希',
  `transaction_index` int(11) DEFAULT NULL COMMENT '交易编号',
  `event_in_address` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '转入地址',
  `event_out_address` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '转出地址',
  `event_amount` decimal(20,8) DEFAULT NULL COMMENT '交易量',
  `event_message` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '链上备注信息',
  `event_timestamp` datetime DEFAULT NULL COMMENT '交易时间',
  `event_timestampV` bigint(20) DEFAULT NULL COMMENT '交易时间戳',
  `create_time` datetime DEFAULT NULL COMMENT '系统收录时间',
  PRIMARY KEY (`id`),
  KEY `in_adddress` (`event_in_address`),
  KEY `out_adddress` (`event_out_address`)
) ENGINE=InnoDB AUTO_INCREMENT=154 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

SET FOREIGN_KEY_CHECKS = 1;
