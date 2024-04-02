/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : db_second_hand

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 02/04/2024 22:48:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sh_address
-- ----------------------------
DROP TABLE IF EXISTS `sh_address`;
CREATE TABLE `sh_address`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `consignee_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人姓名',
  `consignee_phone` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人手机号',
  `province_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '省',
  `city_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '市',
  `region_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '区',
  `detail_address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '详细地址',
  `default_flag` tinyint(4) NOT NULL COMMENT '是否默认地址',
  `user_id` bigint(20) NOT NULL COMMENT '用户主键id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id_index`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sh_address
-- ----------------------------
INSERT INTO `sh_address` VALUES (39, '四号用户', '15133333333', '河北省', '唐山市', '路北区', '街道1', 1, 14);
INSERT INTO `sh_address` VALUES (40, '李四', '12222222222', '山西省', '阳泉市', '郊区', '街道', 1, 11);
INSERT INTO `sh_address` VALUES (41, '王五', '13211111111', '香港特别行政区', '香港特别行政区', '中西区', '街道', 1, 12);
INSERT INTO `sh_address` VALUES (42, '123', '12111111111', '山西省', '阳泉市', '郊区', 'jiedao', 1, 20);
INSERT INTO `sh_address` VALUES (43, '123', '12133333333', '内蒙古自治区', '呼和浩特市', '玉泉区', 'jiedao', 0, 20);

-- ----------------------------
-- Table structure for sh_admin
-- ----------------------------
DROP TABLE IF EXISTS `sh_admin`;
CREATE TABLE `sh_admin`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `account_number` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员账号',
  `admin_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `admin_name` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员名字',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `account_number`(`account_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sh_admin
-- ----------------------------
INSERT INTO `sh_admin` VALUES (1, 'java', '436cf59f1ada546167c0bc81613d5583', '超级管理员');

-- ----------------------------
-- Table structure for sh_adv
-- ----------------------------
DROP TABLE IF EXISTS `sh_adv`;
CREATE TABLE `sh_adv`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '广告id',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '广告图片路径',
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作者',
  `status` tinyint(2) NOT NULL DEFAULT 1 COMMENT '广告状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sh_adv
-- ----------------------------
INSERT INTO `sh_adv` VALUES (45, '[\"http://localhost:8080/image?imageName=file17116071189911019跳蚤市场.png\"]', '高凡深', 1);
INSERT INTO `sh_adv` VALUES (46, '[\"http://localhost:8080/image?imageName=file17116071248961020篮球社.png\"]', '高凡深', 1);
INSERT INTO `sh_adv` VALUES (47, '[\"http://localhost:8080/image?imageName=file17116071310791021学生会.png\"]', '高凡深', 1);
INSERT INTO `sh_adv` VALUES (48, '[\"http://localhost:8080/image?imageName=file17116071376061022音乐节.png\"]', '高凡深', 0);
INSERT INTO `sh_adv` VALUES (49, '[\"http://localhost:8080/image?imageName=file17116073401841023跳蚤市场.png\"]', '高凡深', 0);
INSERT INTO `sh_adv` VALUES (50, '[\"http://localhost:8080/image?imageName=file17116076388871024音乐节.png\"]', 'gfs', 0);
INSERT INTO `sh_adv` VALUES (51, '[\"http://localhost:8080/image?imageName=file17116347758641002音乐节.png\"]', '高凡深', 1);

-- ----------------------------
-- Table structure for sh_favorite
-- ----------------------------
DROP TABLE IF EXISTS `sh_favorite`;
CREATE TABLE `sh_favorite`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键id',
  `create_time` datetime(0) NOT NULL COMMENT '加入收藏的时间',
  `user_id` bigint(20) NOT NULL COMMENT '用户主键id',
  `idle_id` bigint(20) NOT NULL COMMENT '闲置物主键id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id`, `idle_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sh_favorite
-- ----------------------------
INSERT INTO `sh_favorite` VALUES (2, '2024-03-30 22:19:27', 21, 143);

-- ----------------------------
-- Table structure for sh_idle_item
-- ----------------------------
DROP TABLE IF EXISTS `sh_idle_item`;
CREATE TABLE `sh_idle_item`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `idle_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '闲置物名称',
  `idle_details` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '详情',
  `picture_list` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图集',
  `idle_price` decimal(10, 2) NOT NULL COMMENT '价格',
  `idle_place` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发货地区',
  `idle_label` int(11) NOT NULL COMMENT '分类标签',
  `release_time` datetime(0) NOT NULL COMMENT '发布时间',
  `idle_status` tinyint(4) NOT NULL COMMENT '状态（发布1、下架2、删除0）',
  `user_id` bigint(20) NOT NULL COMMENT '用户主键id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id_index`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 149 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sh_idle_item
-- ----------------------------
INSERT INTO `sh_idle_item` VALUES (143, 'ipad', 'ipad', '[\"http://localhost:8080/image?imageName=file17117916390841002ipad.jpg\"]', 3100.00, '市辖区', 1, '2024-03-30 17:40:40', 2, 20);
INSERT INTO `sh_idle_item` VALUES (144, '剪刀', '剪刀', '[\"http://localhost:8080/image?imageName=file17117917323661003剪刀.jpg\"]', 20.00, '市辖区', 3, '2024-03-30 17:42:13', 2, 21);
INSERT INTO `sh_idle_item` VALUES (145, '11', '11', '[\"http://localhost:8080/image?imageName=file17118085338821004键盘.jpg\"]', 30.00, '大同市', 2, '2024-03-30 22:22:15', 2, 21);
INSERT INTO `sh_idle_item` VALUES (146, '杯子', '杯子', '[\"http://localhost:8080/image?imageName=file17118659422671002杯子.jpg\"]', 20.00, '秦皇岛市', 2, '2024-03-31 14:19:03', 1, 21);
INSERT INTO `sh_idle_item` VALUES (147, '33', '233', '[\"http://localhost:8080/image?imageName=file17118782866541002小刀.jpg\"]', 50.00, '张家口市', 4, '2024-03-31 17:44:47', 2, 21);
INSERT INTO `sh_idle_item` VALUES (148, '66', '66', '[\"http://localhost:8080/image?imageName=file17118782992221003音响.jpg\"]', 30.00, '阳泉市', 5, '2024-03-31 17:45:00', 1, 21);

-- ----------------------------
-- Table structure for sh_message
-- ----------------------------
DROP TABLE IF EXISTS `sh_message`;
CREATE TABLE `sh_message`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户主键id',
  `idle_id` bigint(20) NOT NULL COMMENT '闲置主键id',
  `content` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '留言内容',
  `create_time` datetime(0) NOT NULL COMMENT '留言时间',
  `to_user` bigint(20) NOT NULL COMMENT '所回复的用户',
  `to_message` bigint(20) NULL DEFAULT NULL COMMENT '所回复的留言',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id_index`(`user_id`) USING BTREE,
  INDEX `idle_id_index`(`idle_id`) USING BTREE,
  INDEX `to_user_index`(`to_user`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sh_message
-- ----------------------------
INSERT INTO `sh_message` VALUES (1, 11, 114, '好用', '2024-03-02 17:53:22', 16, NULL);
INSERT INTO `sh_message` VALUES (2, 16, 114, 'duohaoyong', '2024-03-02 17:54:21', 11, 1);
INSERT INTO `sh_message` VALUES (3, 16, 114, '非常好用', '2024-03-02 17:55:23', 16, 2);
INSERT INTO `sh_message` VALUES (4, 16, 114, '宿舍', '2024-03-02 17:55:54', 11, 1);
INSERT INTO `sh_message` VALUES (15, 18, 115, '这个键盘好用吗', '2024-03-02 21:25:49', 14, NULL);
INSERT INTO `sh_message` VALUES (16, 20, 140, '111', '2024-03-29 20:19:16', 11, NULL);
INSERT INTO `sh_message` VALUES (17, 20, 146, '这个杯子好用吗', '2024-03-31 14:19:47', 21, NULL);
INSERT INTO `sh_message` VALUES (18, 21, 146, '非常好用', '2024-03-31 14:20:17', 20, 17);
INSERT INTO `sh_message` VALUES (19, 20, 146, '有多么好用', '2024-03-31 14:20:52', 21, 18);

-- ----------------------------
-- Table structure for sh_order
-- ----------------------------
DROP TABLE IF EXISTS `sh_order`;
CREATE TABLE `sh_order`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `order_number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户主键id',
  `idle_id` bigint(20) NOT NULL COMMENT '闲置物品主键id',
  `order_price` decimal(10, 2) NOT NULL COMMENT '订单总价',
  `payment_status` tinyint(4) NOT NULL COMMENT '支付状态',
  `payment_way` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付方式',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `order_status` tinyint(4) NOT NULL COMMENT '订单状态',
  `is_deleted` tinyint(4) NULL DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 114 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sh_order
-- ----------------------------
INSERT INTO `sh_order` VALUES (101, '171013890135310003', 14, 123, 10.00, 1, '支付宝', '2024-03-11 14:35:01', '2024-03-11 14:36:02', 1, NULL);
INSERT INTO `sh_order` VALUES (102, '171013897352910004', 14, 122, 70.00, 0, NULL, '2024-03-11 14:36:14', NULL, 4, NULL);
INSERT INTO `sh_order` VALUES (103, '171014363473410005', 14, 122, 70.00, 1, '支付宝', '2024-03-11 15:53:55', '2024-03-11 15:53:56', 1, NULL);
INSERT INTO `sh_order` VALUES (105, '171023210550910003', 11, 124, 40.00, 1, '支付宝', '2024-03-12 16:28:26', '2024-03-12 16:28:27', 1, NULL);
INSERT INTO `sh_order` VALUES (106, '171076463162110002', 11, 121, 60.00, 1, '支付宝', '2024-03-18 20:23:52', '2024-03-18 20:23:54', 1, NULL);
INSERT INTO `sh_order` VALUES (108, '171083869319410002', 12, 120, 130.00, 1, '支付宝', '2024-03-19 16:58:13', '2024-03-19 16:58:15', 1, NULL);
INSERT INTO `sh_order` VALUES (109, '171083926439010003', 12, 119, 50.00, 1, '支付宝', '2024-03-19 17:07:44', '2024-03-19 17:07:46', 1, NULL);
INSERT INTO `sh_order` VALUES (110, '171160761134010002', 12, 141, 20.00, 1, '支付宝', '2024-03-28 14:33:31', '2024-03-28 14:33:33', 1, NULL);
INSERT INTO `sh_order` VALUES (111, '171180854583310002', 21, 143, 3100.00, 0, NULL, '2024-03-30 22:22:26', NULL, 0, NULL);
INSERT INTO `sh_order` VALUES (112, '171180863592110003', 20, 145, 30.00, 1, '支付宝', '2024-03-30 22:23:56', '2024-03-30 22:23:58', 1, NULL);
INSERT INTO `sh_order` VALUES (113, '171187832511610002', 20, 147, 50.00, 1, '支付宝', '2024-03-31 17:45:25', '2024-03-31 17:45:27', 1, NULL);

-- ----------------------------
-- Table structure for sh_order_address
-- ----------------------------
DROP TABLE IF EXISTS `sh_order_address`;
CREATE TABLE `sh_order_address`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `consignee_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人',
  `consignee_phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `detail_address` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货地址',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `orderId`(`order_id`) USING BTREE,
  INDEX `order_id_index`(`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sh_order_address
-- ----------------------------
INSERT INTO `sh_order_address` VALUES (35, 101, '四号用户', '15133333333', '河北省唐山市路北区街道1');
INSERT INTO `sh_order_address` VALUES (36, 102, '四号用户', '15133333333', '河北省唐山市路北区街道1');
INSERT INTO `sh_order_address` VALUES (37, 103, '四号用户', '15133333333', '河北省唐山市路北区街道1');
INSERT INTO `sh_order_address` VALUES (38, 104, '李四', '12222222222', '山西省阳泉市郊区街道');
INSERT INTO `sh_order_address` VALUES (39, 105, '李四', '12222222222', '山西省阳泉市郊区街道');
INSERT INTO `sh_order_address` VALUES (40, 106, '李四', '12222222222', '山西省阳泉市郊区街道');
INSERT INTO `sh_order_address` VALUES (41, 107, '王五', '13211111111', '香港特别行政区香港特别行政区中西区街道');
INSERT INTO `sh_order_address` VALUES (42, 108, '王五', '13211111111', '香港特别行政区香港特别行政区中西区街道');
INSERT INTO `sh_order_address` VALUES (43, 109, '王五', '13211111111', '香港特别行政区香港特别行政区中西区街道');
INSERT INTO `sh_order_address` VALUES (44, 110, '王五', '13211111111', '香港特别行政区香港特别行政区中西区街道');
INSERT INTO `sh_order_address` VALUES (45, 112, '123', '12111111111', '山西省阳泉市郊区jiedao');
INSERT INTO `sh_order_address` VALUES (46, 113, '123', '12111111111', '山西省阳泉市郊区jiedao');

-- ----------------------------
-- Table structure for sh_user
-- ----------------------------
DROP TABLE IF EXISTS `sh_user`;
CREATE TABLE `sh_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `account_number` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号（手机号）',
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  `nickname` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `avatar` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '头像',
  `sign_in_time` datetime(0) NOT NULL COMMENT '注册时间',
  `user_status` tinyint(4) NULL DEFAULT NULL COMMENT '状态（1代表封禁）',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `account_number`(`account_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sh_user
-- ----------------------------
INSERT INTO `sh_user` VALUES (20, 'username0', '2915e9333e6803f10f64d41346facea6', '小王', 'http://localhost:8080/image?imageName=file17117894539151002头像1.jpg', '2024-03-28 17:02:44', NULL);
INSERT INTO `sh_user` VALUES (21, 'username1', '2915e9333e6803f10f64d41346facea6', '小艺', 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png', '2024-03-30 17:41:20', 0);

SET FOREIGN_KEY_CHECKS = 1;
