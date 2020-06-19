/*
 Navicat Premium Data Transfer

 Source Server         : fuxizhiku-Test
 Source Server Type    : MySQL
 Source Server Version : 50614
 Source Host           : 47.94.247.60:3306
 Source Schema         : exchange-chain

 Target Server Type    : MySQL
 Target Server Version : 50614
 File Encoding         : 65001

 Date: 19/06/2020 13:58:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for area_address
-- ----------------------------
DROP TABLE IF EXISTS `area_address`;
CREATE TABLE `area_address` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(30) NOT NULL DEFAULT '' COMMENT '名称',
  `parent_id` int(20) NOT NULL DEFAULT '-1' COMMENT '父id，-1表示无父节点',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3526 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '表主键',
  `code` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户编码（等于账号编码） ',
  `user_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户姓名',
  `mobile` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `logical_del` tinyint(2) DEFAULT '0' COMMENT '删除标记:0 正常 1 删除\r\n0：正常       \r\n1：禁用(删除)\r\n',
  `avatar` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像',
  `individual_signature` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '个人简介',
  `user_type` int(11) DEFAULT '0' COMMENT '0--普通用户，1--待定，2--待定',
  `is_displaypage` tinyint(4) DEFAULT '0' COMMENT '是否显示首页 0-- 否；1--是',
  `login_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '登录名（可以是别名）',
  `password` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '登陆密码',
  `current_token` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '登陆后的TOKEN',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后一次登陆时间',
  `account_address` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '账户链上地址',
  `salt` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '盐',
  `level` int(4) DEFAULT NULL COMMENT '状态:0：普通 1：实名：2：商户或组织',
  `last_login_ip` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '最后一次登陆的ip',
  `id_card` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '身份证号',
  PRIMARY KEY (`id`),
  KEY `user_code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for customer_purchase_record
-- ----------------------------
DROP TABLE IF EXISTS `customer_purchase_record`;
CREATE TABLE `customer_purchase_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `customer_id` bigint(20) NOT NULL COMMENT '用户id',
  `domain_id` bigint(20) NOT NULL COMMENT '资源id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` tinyint(1) NOT NULL COMMENT '是否有效1有效 0无效',
  PRIMARY KEY (`id`),
  KEY `customer_id01` (`customer_id`),
  KEY `domain_id01` (`domain_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户购买获取的资源列表';

-- ----------------------------
-- Table structure for exchange_domain
-- ----------------------------
DROP TABLE IF EXISTS `exchange_domain`;
CREATE TABLE `exchange_domain` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `domain` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '域名',
  `domain_hash` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '域名哈希串',
  `hash_code` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '生成的hash串(摘要)',
  `dns_parse_record` text COLLATE utf8mb4_unicode_ci COMMENT 'dns解析记录',
  `owner` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '域名持有者',
  `position` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '位置',
  `mail_address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '通讯地址',
  `maill_no` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮编',
  `email` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱号',
  `contact_phone` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `customer_id` bigint(11) DEFAULT NULL COMMENT '所有者id',
  `customer_address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所属地址账户',
  `content_items` int(11) DEFAULT NULL COMMENT '所填的信息的项目数',
  `wi_registrar_support` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '注册商',
  `wi_create_time` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建时间',
  `wi_expiration_time` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '过期时间',
  `wi_server_ip` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '域名服务器',
  `wi_dns` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'dns',
  `logical_del` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标识 0 未删除 1删除',
  `status` tinyint(1) DEFAULT NULL COMMENT '生效状态1生效0不生效',
  `transaction_hash` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '交易哈希',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for search_log
-- ----------------------------
DROP TABLE IF EXISTS `search_log`;
CREATE TABLE `search_log` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `domain` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '查询的域名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `digest_hash` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '摘要hash',
  `ip` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '访问ip',
  `visit_id` bigint(20) DEFAULT NULL COMMENT '访问者id',
  `remark` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  `ext_1` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ext_2` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

SET FOREIGN_KEY_CHECKS = 1;
