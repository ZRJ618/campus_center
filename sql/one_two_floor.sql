/*
 Navicat Premium Data Transfer

 Source Server         : mysql8.0
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : one_two_floor

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 17/09/2021 22:46:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`  (
  `activity_id` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `activity_title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `total_num` int(0) NOT NULL,
  `join_num` int(0) NOT NULL,
  `activity_image` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `activity_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `activity_start_time` datetime(0) NOT NULL,
  `activity_end_time` datetime(0) NOT NULL,
  `recruit_start_time` datetime(0) NOT NULL,
  `recruit_end_time` datetime(0) NOT NULL,
  `real_name` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `activity_object` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `activity_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `activity_place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `activity_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `modify_time` datetime(0) NOT NULL,
  `deleted` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`activity_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('51fe34a36de1463caa660e4819c06fe5', '工学院拔河选拔赛', 50, 0, 'http://localhost:9090/image/activity28d0e525720a40629116806a601c0ed3.jpg', '工学院拔河选拔赛', '2021-05-10 00:00:00', '2021-05-19 00:00:00', '2021-05-10 00:00:00', '2021-05-10 00:00:00', '18359057713', 'ff561db1ee3c4b07befcfe573de6dba3', '自愿报名', '线下主题活动', 'beijing', '1栋篮球场', '2021-05-08 14:45:14', '2021-05-08 14:45:14', 0);
INSERT INTO `activity` VALUES ('c6fec19e030b424483828ca2631b08fe', '活动11111', 5, 0, 'http://localhost:9090/image/activityf9c65c8338d2480e94105bb155e414ef.jpg', '打发士大夫士大夫地方都是', '2021-05-10 00:00:00', '2021-05-20 00:00:00', '2021-05-09 00:00:00', '2021-05-10 00:00:00', '18359057713', '9e1ab8a387db47649076d08160e1185b', '自愿报名', '日常聚会', 'shanghai', '撒旦发射点发射点第三方', '2021-05-08 11:21:17', '2021-05-08 11:21:17', 0);

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer`  (
  `self_add` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `answer_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '回答id',
  `question_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '其问题id',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '其user_id',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `like_num` int(0) NULL DEFAULT NULL COMMENT '点赞数',
  `unlike_num` int(0) NULL DEFAULT NULL COMMENT '不喜欢数',
  `comment_num` int(0) NULL DEFAULT NULL COMMENT '评论数',
  `scan_num` int(0) NULL DEFAULT NULL COMMENT '浏览量',
  `status` int(0) NULL DEFAULT NULL COMMENT '0为删除，1为正常',
  PRIMARY KEY (`self_add`, `answer_id`, `question_id`) USING BTREE,
  INDEX `answer_id`(`answer_id`) USING BTREE,
  INDEX `answer_user_id`(`user_id`) USING BTREE,
  INDEX `answer_question_id`(`question_id`) USING BTREE,
  CONSTRAINT `answer_question_id` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `answer_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES (20, 'e92ac980-a093-4000-9444-450b4d2afbed', '151ff010-3ef6-4ddb-9530-c5594eeed29d', '237fd7e7ee414834bc6f6f8a6680f632', '<p>一楼的米饭好吃！！</p><p>一楼的米饭好吃！！</p><p>一楼的米饭好吃！！</p><p>一楼的米饭好吃！！</p><p><br></p><p class=\"ql-align-center\"><img src=\"http://localhost:9090/static/answerImage/13291aa4-71b5-404e-a199-5e63f58a3aa5.jpg\" height=\"228\" width=\"342\"></p><p>一楼的米饭好吃！！</p><p>一楼的米饭好吃！！</p><p>一楼的米饭好吃！！</p><p><br></p>', '2021-05-08 06:59:09', 1, 0, 0, NULL, 1);
INSERT INTO `answer` VALUES (22, 'df3f340c-7fdc-450c-9803-ab3deb83c8e5', '151ff010-3ef6-4ddb-9530-c5594eeed29d', '237fd7e7ee414834bc6f6f8a6680f632', '<p>二楼的牛肉好吃！！！</p><p>二楼的牛肉好吃！！！</p><p>二楼的牛肉好吃！！！</p><p class=\"ql-align-center\"><img src=\"http://localhost:9090/static/answerImage/4fb1ad0f-7719-49df-ba35-dc8ea1d1d475.jpg\" height=\"247\" width=\"371\"></p><p>二楼的牛肉好吃！！</p>', '2021-05-08 07:03:49', 0, 0, 0, NULL, 1);

-- ----------------------------
-- Table structure for answer_like
-- ----------------------------
DROP TABLE IF EXISTS `answer_like`;
CREATE TABLE `answer_like`  (
  `self_add` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '此处应为点赞者的userId',
  `answer_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'answerId',
  PRIMARY KEY (`self_add`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `answer_id`(`answer_id`) USING BTREE,
  CONSTRAINT `answer_like_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `answer_like_ibfk_2` FOREIGN KEY (`answer_id`) REFERENCES `answer` (`answer_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of answer_like
-- ----------------------------
INSERT INTO `answer_like` VALUES (12, '237fd7e7ee414834bc6f6f8a6680f632', 'e92ac980-a093-4000-9444-450b4d2afbed');

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `self_add` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `article_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章id',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'user_id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `like_num` int(0) NULL DEFAULT NULL COMMENT '点赞数',
  `unlike_num` int(0) NULL DEFAULT NULL COMMENT '踩',
  `comment_num` int(0) NULL DEFAULT NULL COMMENT '评论数',
  `article_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封面URL',
  `scan_num` int(0) NULL DEFAULT NULL COMMENT '浏览量',
  `status` int(0) NULL DEFAULT NULL COMMENT '0为删除，1为正常',
  PRIMARY KEY (`self_add`, `article_id`) USING BTREE,
  INDEX `article_id`(`article_id`) USING BTREE,
  INDEX `article_user_id`(`user_id`) USING BTREE,
  CONSTRAINT `article_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (45, 'b736ecf4-b933-48ab-8528-1bd2a1c293f1', '9e1ab8a387db47649076d08160e1185b', '撒旦发射点', '<p>撒旦发射点</p>', '2021-05-08 03:32:20', 0, 0, 0, NULL, 6, 1);
INSERT INTO `article` VALUES (46, 'd384f9d3-655c-4f9d-a219-2e4af1eb3ca7', '237fd7e7ee414834bc6f6f8a6680f632', '心情愉悦的一天', '<p>心情愉悦的一天</p><p>心情愉悦的一天</p><p>心情愉悦的一天</p><p>心情愉悦的一天</p><p>心情愉悦的一天</p><p>心情愉悦的一天</p>', '2021-05-08 07:12:46', 0, 0, 0, NULL, 1, 1);
INSERT INTO `article` VALUES (47, '22fbfb21-2d8c-44db-8cad-c850fc0321d3', '237fd7e7ee414834bc6f6f8a6680f632', '红烧狮子头', '<p>大师傅士大夫</p><p>胜多负少</p><p>士大夫</p><p>士大夫</p><p>士大夫</p>', '2021-05-08 07:16:44', 0, 0, 0, NULL, 3, 1);

-- ----------------------------
-- Table structure for article_label
-- ----------------------------
DROP TABLE IF EXISTS `article_label`;
CREATE TABLE `article_label`  (
  `self_add` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `article_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `label_self_add` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`self_add`) USING BTREE,
  INDEX `a_l_article_id`(`article_id`) USING BTREE,
  INDEX `a_l_label_self_add`(`label_self_add`) USING BTREE,
  CONSTRAINT `a_l_article_id` FOREIGN KEY (`article_id`) REFERENCES `article` (`article_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `a_l_label_self_add` FOREIGN KEY (`label_self_add`) REFERENCES `label` (`self_add`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 74 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of article_label
-- ----------------------------
INSERT INTO `article_label` VALUES (66, 'd384f9d3-655c-4f9d-a219-2e4af1eb3ca7', 1);
INSERT INTO `article_label` VALUES (67, 'd384f9d3-655c-4f9d-a219-2e4af1eb3ca7', 2);
INSERT INTO `article_label` VALUES (68, 'd384f9d3-655c-4f9d-a219-2e4af1eb3ca7', 4);
INSERT INTO `article_label` VALUES (69, 'd384f9d3-655c-4f9d-a219-2e4af1eb3ca7', 3);
INSERT INTO `article_label` VALUES (70, '22fbfb21-2d8c-44db-8cad-c850fc0321d3', 1);
INSERT INTO `article_label` VALUES (71, '22fbfb21-2d8c-44db-8cad-c850fc0321d3', 2);
INSERT INTO `article_label` VALUES (72, '22fbfb21-2d8c-44db-8cad-c850fc0321d3', 4);
INSERT INTO `article_label` VALUES (73, '22fbfb21-2d8c-44db-8cad-c850fc0321d3', 3);

-- ----------------------------
-- Table structure for article_like
-- ----------------------------
DROP TABLE IF EXISTS `article_like`;
CREATE TABLE `article_like`  (
  `self_add` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '此处应为点赞者的userId',
  `article_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'articleId',
  PRIMARY KEY (`self_add`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for collection_answer
-- ----------------------------
DROP TABLE IF EXISTS `collection_answer`;
CREATE TABLE `collection_answer`  (
  `self_add` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `answer_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT NULL COMMENT '0为删除，1为正常',
  PRIMARY KEY (`self_add`) USING BTREE,
  INDEX `c_a_user_id`(`user_id`) USING BTREE,
  INDEX `c_a_answer_id`(`answer_id`) USING BTREE,
  CONSTRAINT `c_a_answer_id` FOREIGN KEY (`answer_id`) REFERENCES `answer` (`answer_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `c_a_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of collection_answer
-- ----------------------------
INSERT INTO `collection_answer` VALUES (12, '237fd7e7ee414834bc6f6f8a6680f632', 'e92ac980-a093-4000-9444-450b4d2afbed', 1);
INSERT INTO `collection_answer` VALUES (13, '237fd7e7ee414834bc6f6f8a6680f632', 'df3f340c-7fdc-450c-9803-ab3deb83c8e5', 1);

-- ----------------------------
-- Table structure for collection_article
-- ----------------------------
DROP TABLE IF EXISTS `collection_article`;
CREATE TABLE `collection_article`  (
  `self_add` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'user_id',
  `article_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'article_id',
  `status` int(0) NULL DEFAULT NULL COMMENT '0删除，1正常',
  PRIMARY KEY (`self_add`) USING BTREE,
  INDEX `c_ar_user_id`(`user_id`) USING BTREE,
  INDEX `c_ar_article_id`(`article_id`) USING BTREE,
  CONSTRAINT `c_ar_article_id` FOREIGN KEY (`article_id`) REFERENCES `article` (`article_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `c_ar_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for collection_question
-- ----------------------------
DROP TABLE IF EXISTS `collection_question`;
CREATE TABLE `collection_question`  (
  `self_add` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `question_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT NULL COMMENT '0删除，1正常',
  PRIMARY KEY (`self_add`) USING BTREE,
  INDEX `c_q_user_id`(`user_id`) USING BTREE,
  INDEX `question_id`(`question_id`) USING BTREE,
  CONSTRAINT `c_q_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `collection_question_ibfk_1` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of collection_question
-- ----------------------------
INSERT INTO `collection_question` VALUES (10, '237fd7e7ee414834bc6f6f8a6680f632', '151ff010-3ef6-4ddb-9530-c5594eeed29d', 1);

-- ----------------------------
-- Table structure for comment_answer
-- ----------------------------
DROP TABLE IF EXISTS `comment_answer`;
CREATE TABLE `comment_answer`  (
  `self_add` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `comment_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `answer_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `like_num` int(0) NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT NULL COMMENT '0为删除，1为正常',
  PRIMARY KEY (`self_add`) USING BTREE,
  INDEX `c_an_answer_id`(`answer_id`) USING BTREE,
  INDEX `c_an_user_id`(`user_id`) USING BTREE,
  INDEX `comment_id`(`comment_id`) USING BTREE,
  CONSTRAINT `c_an_answer_id` FOREIGN KEY (`answer_id`) REFERENCES `answer` (`answer_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `c_an_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for comment_article
-- ----------------------------
DROP TABLE IF EXISTS `comment_article`;
CREATE TABLE `comment_article`  (
  `self_add` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `comment_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论id',
  `article_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所评论的id',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论者id',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `like_num` int(0) NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT NULL COMMENT '0为删除，1为正常',
  PRIMARY KEY (`self_add`) USING BTREE,
  INDEX `c_art_user_id`(`user_id`) USING BTREE,
  INDEX `c_art_article_id`(`article_id`) USING BTREE,
  INDEX `comment_id`(`comment_id`) USING BTREE,
  CONSTRAINT `c_art_article_id` FOREIGN KEY (`article_id`) REFERENCES `article` (`article_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `c_art_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for comment_like
-- ----------------------------
DROP TABLE IF EXISTS `comment_like`;
CREATE TABLE `comment_like`  (
  `self_add` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'user_id',
  `comment_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'comment_id',
  PRIMARY KEY (`self_add`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `comment_id`(`comment_id`) USING BTREE,
  CONSTRAINT `comment_like_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for dep_check
-- ----------------------------
DROP TABLE IF EXISTS `dep_check`;
CREATE TABLE `dep_check`  (
  `dep_check_id` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `real_name` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `grade` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `positive_path` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `back_path` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `modify_time` datetime(0) NOT NULL,
  `deleted` int(0) NULL DEFAULT 0,
  `department_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `department_Name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `check_status` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`dep_check_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for dep_introduce
-- ----------------------------
DROP TABLE IF EXISTS `dep_introduce`;
CREATE TABLE `dep_introduce`  (
  `department_id` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `brief_introduce` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `work_introduce` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `recruit` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dep_image` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `charge_one` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `charge_two` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `charge_three` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NOT NULL,
  `modify_time` datetime(0) NOT NULL,
  PRIMARY KEY (`department_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for dep_member
-- ----------------------------
DROP TABLE IF EXISTS `dep_member`;
CREATE TABLE `dep_member`  (
  `member_id` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `department_id` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `department_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `position` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `modify_time` datetime(0) NOT NULL,
  `deleted` int(0) NOT NULL DEFAULT 0,
  `is_old` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`member_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `department_id` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `department_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `people_num` int(0) NOT NULL DEFAULT 0,
  `parent_id` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `department_grade` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `modify_time` datetime(0) NOT NULL,
  `deleted` int(0) NULL DEFAULT 0,
  `parent_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`department_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for fans
-- ----------------------------
DROP TABLE IF EXISTS `fans`;
CREATE TABLE `fans`  (
  `self_add` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '被关注者',
  `fans_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'fans的user_id',
  PRIMARY KEY (`self_add`) USING BTREE,
  INDEX `fans_user_id`(`user_id`) USING BTREE,
  INDEX `fans_fans_id`(`fans_id`) USING BTREE,
  CONSTRAINT `fans_fans_id` FOREIGN KEY (`fans_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fans_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for image_path
-- ----------------------------
DROP TABLE IF EXISTS `image_path`;
CREATE TABLE `image_path`  (
  `image_id` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `image_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `student_id` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `path` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `modify_time` datetime(0) NOT NULL,
  PRIMARY KEY (`image_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for interview_info
-- ----------------------------
DROP TABLE IF EXISTS `interview_info`;
CREATE TABLE `interview_info`  (
  `interview_id` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `department_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rank` int(0) NOT NULL,
  `know` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `advantage` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `disadvantage` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `modify_time` datetime(0) NOT NULL,
  `deleted` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`interview_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for interview_time
-- ----------------------------
DROP TABLE IF EXISTS `interview_time`;
CREATE TABLE `interview_time`  (
  `time_id` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `student_id` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `department_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `start_time` datetime(0) NOT NULL,
  `end_time` datetime(0) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `modify_time` datetime(0) NOT NULL,
  `deleted` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`time_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for join_activity
-- ----------------------------
DROP TABLE IF EXISTS `join_activity`;
CREATE TABLE `join_activity`  (
  `join_id` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `activity_id` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `modify_time` datetime(0) NOT NULL,
  PRIMARY KEY (`join_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for label
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label`  (
  `self_add` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `label` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签描述',
  PRIMARY KEY (`self_add`, `label`) USING BTREE,
  INDEX `self_add`(`self_add`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of label
-- ----------------------------
INSERT INTO `label` VALUES (1, '学习');
INSERT INTO `label` VALUES (2, '感情');
INSERT INTO `label` VALUES (3, '生活');
INSERT INTO `label` VALUES (4, '考试');

-- ----------------------------
-- Table structure for leave_apply
-- ----------------------------
DROP TABLE IF EXISTS `leave_apply`;
CREATE TABLE `leave_apply`  (
  `apply_id` char(50) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `user_id` char(50) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `leave_type` char(40) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `start_time` datetime(0) NOT NULL,
  `end_time` datetime(0) NOT NULL,
  `reason` text CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `apply_status` int(0) UNSIGNED NULL DEFAULT 0,
  `apply_user` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `modify_time` datetime(0) NOT NULL,
  `department_id` char(50) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `deleted` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`apply_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for logger
-- ----------------------------
DROP TABLE IF EXISTS `logger`;
CREATE TABLE `logger`  (
  `logger_id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `param` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `result` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `execution_time` datetime(0) NOT NULL,
  PRIMARY KEY (`logger_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 535 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of logger
-- ----------------------------
INSERT INTO `logger` VALUES (511, '237fd7e7ee414834bc6f6f8a6680f632', 'showCollectionAnswer', '237fd7e7ee414834bc6f6f8a6680f632', '200', '2021-09-17 01:04:16');
INSERT INTO `logger` VALUES (512, '237fd7e7ee414834bc6f6f8a6680f632', 'showCollectionAnswer', '237fd7e7ee414834bc6f6f8a6680f632', '200', '2021-09-17 01:07:42');
INSERT INTO `logger` VALUES (513, '237fd7e7ee414834bc6f6f8a6680f632', 'showCollectionAnswer', '237fd7e7ee414834bc6f6f8a6680f632', '200', '2021-09-17 01:14:28');
INSERT INTO `logger` VALUES (514, '237fd7e7ee414834bc6f6f8a6680f632', 'showCollectionAnswer', '237fd7e7ee414834bc6f6f8a6680f632-', '200', '2021-09-17 01:17:45');
INSERT INTO `logger` VALUES (515, '237fd7e7ee414834bc6f6f8a6680f632', 'showCollectionAnswer', '237fd7e7ee414834bc6f6f8a6680f632-', '200', '2021-09-17 01:17:54');
INSERT INTO `logger` VALUES (516, '237fd7e7ee414834bc6f6f8a6680f632', 'homePage2', '', '200', '2021-09-17 01:18:57');
INSERT INTO `logger` VALUES (517, '237fd7e7ee414834bc6f6f8a6680f632', 'showAll', '', '200', '2021-09-17 01:19:16');
INSERT INTO `logger` VALUES (518, '237fd7e7ee414834bc6f6f8a6680f632', 'showAllAnswer', '1111-', '200', '2021-09-17 11:01:23');
INSERT INTO `logger` VALUES (519, '237fd7e7ee414834bc6f6f8a6680f632', 'showCollectionAnswer', '237fd7e7ee414834bc6f6f8a6680f632-', '200', '2021-09-17 11:02:34');
INSERT INTO `logger` VALUES (520, '237fd7e7ee414834bc6f6f8a6680f632', 'showCollectionAnswer', '1111111111-', '200', '2021-09-17 11:02:46');
INSERT INTO `logger` VALUES (521, '237fd7e7ee414834bc6f6f8a6680f632', 'showCollectionAnswer', '237fd7e7ee414834bc6f6f8a6680f632-', '200', '2021-09-17 11:02:50');
INSERT INTO `logger` VALUES (522, '237fd7e7ee414834bc6f6f8a6680f632', 'showCollectionAnswer', '237fd7e7ee414834bc6f6f8a6680f632-', '200', '2021-09-17 11:03:15');
INSERT INTO `logger` VALUES (523, '237fd7e7ee414834bc6f6f8a6680f632', 'CollectionAnswer', 'e92ac980-a093-4000-9444-450b4d2afbed-org.apache.catalina.connector.RequestFacade@60226100-', '500', '2021-09-17 11:03:42');
INSERT INTO `logger` VALUES (524, '237fd7e7ee414834bc6f6f8a6680f632', 'CollectionAnswer', 'df3f340c-7fdc-450c-9803-ab3deb83c8e5-org.apache.catalina.connector.RequestFacade@60226100-', '200', '2021-09-17 11:04:16');
INSERT INTO `logger` VALUES (525, '237fd7e7ee414834bc6f6f8a6680f632', 'showCollectionAnswer', '237fd7e7ee414834bc6f6f8a6680f632-', '200', '2021-09-17 11:04:22');
INSERT INTO `logger` VALUES (526, '237fd7e7ee414834bc6f6f8a6680f632', 'showAllAnswer', '237fd7e7ee414834bc6f6f8a6680f632-', '200', '2021-09-17 11:13:03');
INSERT INTO `logger` VALUES (527, '237fd7e7ee414834bc6f6f8a6680f632', 'login', '1111111111-a1111111111-1111-1111-', '200', '2021-09-17 11:15:17');
INSERT INTO `logger` VALUES (528, '237fd7e7ee414834bc6f6f8a6680f632', 'showCollectionAnswer', '237fd7e7ee414834bc6f6f8a6680f632-', '200', '2021-09-17 22:09:58');
INSERT INTO `logger` VALUES (529, '237fd7e7ee414834bc6f6f8a6680f632', 'showCollectionAnswer', '237fd7e7ee414834bc6f6f8a6680f632-', '200', '2021-09-17 22:10:22');
INSERT INTO `logger` VALUES (530, '237fd7e7ee414834bc6f6f8a6680f632', 'showCollectionAnswer', '237fd7e7ee414834bc6f6f8a6680f632-', '200', '2021-09-17 22:10:24');
INSERT INTO `logger` VALUES (531, '237fd7e7ee414834bc6f6f8a6680f632', 'showCollectionAnswer', '237fd7e7ee414834bc6f6f8a6680f632-', '200', '2021-09-17 22:10:24');
INSERT INTO `logger` VALUES (532, '237fd7e7ee414834bc6f6f8a6680f632', 'showCollectionAnswer', '237fd7e7ee414834bc6f6f8a6680f632-', '200', '2021-09-17 22:10:24');
INSERT INTO `logger` VALUES (533, '237fd7e7ee414834bc6f6f8a6680f632', 'showCollectionAnswer', '237fd7e7ee414834bc6f6f8a6680f632-', '200', '2021-09-17 22:10:25');
INSERT INTO `logger` VALUES (534, '237fd7e7ee414834bc6f6f8a6680f632', 'showCollectionAnswer', '237fd7e7ee414834bc6f6f8a6680f632-', '200', '2021-09-17 22:10:25');
INSERT INTO `logger` VALUES (535, '237fd7e7ee414834bc6f6f8a6680f632', 'login', '1111111111-a1111111111-3432343-3432343-', '200', '2021-09-17 22:44:17');
INSERT INTO `logger` VALUES (536, '237fd7e7ee414834bc6f6f8a6680f632', 'showCollectionAnswer', '237fd7e7ee414834bc6f6f8a6680f632-', '200', '2021-09-17 22:44:50');
INSERT INTO `logger` VALUES (537, '237fd7e7ee414834bc6f6f8a6680f632', 'showCollectionAnswer', '237fd7e7ee414834bc6f6f8a6680f632-', '200', '2021-09-17 22:44:59');
INSERT INTO `logger` VALUES (538, '237fd7e7ee414834bc6f6f8a6680f632', 'showCollectionAnswer', '237fd7e7ee414834bc6f6f8a6680f632-', '200', '2021-09-17 22:44:59');

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `self_add` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `question_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'question_id',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '提出者',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '问题描述',
  `All_answer_like_num` int(0) NULL DEFAULT NULL COMMENT '其下所有回答的点赞数总和',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `question_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'question的封面图片',
  `scan_num` int(0) NULL DEFAULT NULL COMMENT '浏览量',
  `status` int(0) NULL DEFAULT NULL COMMENT '0为删除，1为正常',
  PRIMARY KEY (`self_add`, `question_id`) USING BTREE,
  INDEX `question_id`(`question_id`) USING BTREE,
  INDEX `q_l_s_a_user_id`(`user_id`) USING BTREE,
  CONSTRAINT `q_l_s_a_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES (27, '00211781-24f1-4e65-bc4a-e678625025b7', 'ff561db1ee3c4b07befcfe573de6dba3', '我们学校的大学生医保卡要怎么领取？', '<p>的方式发送 撒旦发射点发射点</p><p><strong>是对方身上</strong></p><p><strong>士大夫</strong></p><p>大师傅士大夫</p>', NULL, '2021-09-08 06:30:29', NULL, NULL, 1);
INSERT INTO `question` VALUES (28, 'bf48f607-fd8a-43b6-826d-326362629c7f', 'ff561db1ee3c4b07befcfe573de6dba3', '第十七届校园辩论赛，赛果如何？', '<p>复苏的速度</p><p>士大夫十分</p><p>撒旦发射点</p><p>士大夫胜多负少</p><p>手动阀手动阀</p><p>地方</p>', NULL, '2021-09-08 06:31:21', NULL, NULL, 1);
INSERT INTO `question` VALUES (29, 'b2ec5263-f1a2-452e-b46d-6c93b2b18eba', 'ff561db1ee3c4b07befcfe573de6dba3', '听说工学院大三要实训？什么时候开始？', '<p>大师傅似的</p><p>的说法是</p><p>士大夫ds发</p><p>打发士大夫</p><p>大是大非</p>', NULL, '2021-09-08 06:32:52', NULL, NULL, 1);
INSERT INTO `question` VALUES (30, '151ff010-3ef6-4ddb-9530-c5594eeed29d', '237fd7e7ee414834bc6f6f8a6680f632', '食堂有哪些菜比较好吃，推荐一波？', '<p>食堂有哪些菜比较好吃，推荐一波？食堂有哪些菜比较好吃，推荐一波？</p><p><strong>食堂有哪些菜比较好吃，推荐一波？</strong></p><p>食堂有哪些菜比较好吃，推荐一波？</p><p>食堂有哪些菜比较好吃，推荐一波？食堂有哪些菜比较好吃，推荐一波？</p>', 1, '2021-09-08 06:57:43', NULL, NULL, 1);

-- ----------------------------
-- Table structure for question_label
-- ----------------------------
DROP TABLE IF EXISTS `question_label`;
CREATE TABLE `question_label`  (
  `self_add` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `question_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `label_self_add` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`self_add`) USING BTREE,
  INDEX `q_l_question_id`(`question_id`) USING BTREE,
  CONSTRAINT `q_l_question_id` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 73 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of question_label
-- ----------------------------
INSERT INTO `question_label` VALUES (70, '151ff010-3ef6-4ddb-9530-c5594eeed29d', '1');
INSERT INTO `question_label` VALUES (71, '151ff010-3ef6-4ddb-9530-c5594eeed29d', '2');
INSERT INTO `question_label` VALUES (72, '151ff010-3ef6-4ddb-9530-c5594eeed29d', '3');
INSERT INTO `question_label` VALUES (73, '151ff010-3ef6-4ddb-9530-c5594eeed29d', '4');

-- ----------------------------
-- Table structure for scan_history
-- ----------------------------
DROP TABLE IF EXISTS `scan_history`;
CREATE TABLE `scan_history`  (
  `self_add` int(0) NOT NULL AUTO_INCREMENT,
  `scan_history_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `article_or_answer_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT NULL COMMENT '0删除，1正常',
  PRIMARY KEY (`self_add`) USING BTREE,
  INDEX `scan_h_user_id`(`user_id`) USING BTREE,
  CONSTRAINT `scan_h_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 72 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of scan_history
-- ----------------------------
INSERT INTO `scan_history` VALUES (62, 'fbe27268-7b4c-4df3-a5fb-3b9b470af2ad', '9e1ab8a387db47649076d08160e1185b', 'b736ecf4-b933-48ab-8528-1bd2a1c293f1', '2021-05-08 11:32:20', 1);
INSERT INTO `scan_history` VALUES (63, '152b509c-c384-4363-bc1b-75b2311185dd', '9e1ab8a387db47649076d08160e1185b', 'b736ecf4-b933-48ab-8528-1bd2a1c293f1', '2021-05-08 11:32:33', 1);
INSERT INTO `scan_history` VALUES (64, 'e8e88b75-61bd-4fff-9eaa-36cc0df9ad2c', '9e1ab8a387db47649076d08160e1185b', 'b736ecf4-b933-48ab-8528-1bd2a1c293f1', '2021-05-08 11:32:36', 1);
INSERT INTO `scan_history` VALUES (65, '49149f4f-a1e7-4134-9286-a53236c51773', '9e1ab8a387db47649076d08160e1185b', 'b736ecf4-b933-48ab-8528-1bd2a1c293f1', '2021-05-08 11:32:44', 1);
INSERT INTO `scan_history` VALUES (66, '582b97ef-621a-4352-8407-98797d07a263', '9e1ab8a387db47649076d08160e1185b', 'b736ecf4-b933-48ab-8528-1bd2a1c293f1', '2021-05-08 11:33:06', 1);
INSERT INTO `scan_history` VALUES (67, '9ed0a83c-bab5-4f1b-ba3d-03603325ef86', '9e1ab8a387db47649076d08160e1185b', 'b736ecf4-b933-48ab-8528-1bd2a1c293f1', '2021-05-08 11:33:19', 1);
INSERT INTO `scan_history` VALUES (68, '649caf88-2f53-4779-9ec6-15ff4d325648', '237fd7e7ee414834bc6f6f8a6680f632', 'd384f9d3-655c-4f9d-a219-2e4af1eb3ca7', '2021-05-08 15:12:46', 1);
INSERT INTO `scan_history` VALUES (69, '7f54cc06-11da-4bb4-bed9-13d921d7ab14', '237fd7e7ee414834bc6f6f8a6680f632', '22fbfb21-2d8c-44db-8cad-c850fc0321d3', '2021-05-08 15:16:44', 1);
INSERT INTO `scan_history` VALUES (70, '6e81c080-aab4-43eb-b57b-3e8b6d3e34b7', '237fd7e7ee414834bc6f6f8a6680f632', '22fbfb21-2d8c-44db-8cad-c850fc0321d3', '2021-05-08 15:16:50', 1);
INSERT INTO `scan_history` VALUES (71, '6f60b877-d38c-43de-acf8-2ff707230fd8', '237fd7e7ee414834bc6f6f8a6680f632', '22fbfb21-2d8c-44db-8cad-c850fc0321d3', '2021-09-15 17:07:47', 1);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `userId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `StudentId` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userName` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userRealName` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `grade` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `major` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `powerId` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `headPortrait` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createTime` datetime(0) NOT NULL,
  `modifyTime` datetime(0) NOT NULL,
  `deleted` int(0) NOT NULL DEFAULT 0,
  `InchPhoto` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`StudentId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `self_add` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'user_id',
  `student_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  `enter_school_time` date NULL DEFAULT NULL COMMENT '入学时间',
  `major` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `mobile_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `self_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像URl',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '账号创建日期',
  `status` int(0) NULL DEFAULT 0 COMMENT '0为注销，1为正常',
  `idol_sum` int(0) NULL DEFAULT NULL COMMENT 'idol数',
  `fans_sum` int(0) NULL DEFAULT NULL COMMENT '粉丝数',
  `activation_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '激活码（用于注册时激活）',
  `modify_time` datetime(0) NULL DEFAULT NULL,
  `deleted` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`self_add`, `user_id`, `student_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (38, '9e1ab8a387db47649076d08160e1185b', '6666666666', 'YTY2NjY2NjY2NjZmemdzeHk=', '十八666', '18359057713', '男', '2021-05-08', '2021-05-20', '2021-05-08', 'zhang', '2261839618@qq.com', NULL, '2021-05-08 11:17:09', 1, NULL, NULL, '7843', '2021-05-08 11:17:09', NULL);
INSERT INTO `user` VALUES (39, '62e7978403f84356b7aee08f6a3e813f', '5555555555', 'YTU1NTU1NTU1NTVmemdzeHk=', '你好345', '18359057713', '男', '2021-05-06', '2021-05-13', '2021-05-06', '到付即可', '2261839618@qq.com', NULL, '2021-05-08 11:35:28', 1, NULL, NULL, '8132', '2021-05-08 11:35:28', NULL);
INSERT INTO `user` VALUES (40, 'ff561db1ee3c4b07befcfe573de6dba3', '3333333333', 'YTMzMzMzMzMzMzNmemdzeHk=', '发的说说333', '18359057713', '男', '2021-05-20', '2021-05-11', '2021-05-20', '的方式', '2261839618@qq.com', NULL, '2021-05-08 13:46:43', 1, NULL, NULL, '22up', '2021-05-08 13:46:43', NULL);
INSERT INTO `user` VALUES (41, '237fd7e7ee414834bc6f6f8a6680f632', '1111111111', 'YTExMTExMTExMTFmemdzeHk=', '张三1111', '18359057713', '男', '2021-05-12', '2021-05-06', '2021-05-12', '张三', '2261839618@qq.com', NULL, '2021-05-08 14:51:59', 1, NULL, NULL, '77dy', '2021-05-08 14:51:59', NULL);

SET FOREIGN_KEY_CHECKS = 1;
