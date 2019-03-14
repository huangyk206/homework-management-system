/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : scau_homework

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 14/03/2019 11:04:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `teacherId` bigint(20) NOT NULL COMMENT '教师id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程名',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `valid` tinyint(4) NOT NULL DEFAULT 1 COMMENT '1有效，0删除',
  `startTime` datetime(0) NOT NULL COMMENT '开始时间',
  `endTime` datetime(0) NOT NULL COMMENT '结束时间',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `course_fk`(`teacherId`) USING BTREE,
  CONSTRAINT `course_fk` FOREIGN KEY (`teacherId`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, 3, '算法', '234243435323543534543534啊啊啊啊啊23424242342342424242', 1, '2019-02-22 08:46:03', '2019-06-30 08:46:28', '2019-03-03 08:46:40', NULL);
INSERT INTO `course` VALUES (2, 3, 'Java123', '122', 1, '2019-02-22 08:46:03', '2019-06-30 08:46:28', '2019-03-03 08:47:24', NULL);
INSERT INTO `course` VALUES (3, 3, '大数据安全与隐私', '3423', 1, '2019-02-22 08:46:03', '2019-03-02 08:46:28', '2019-03-03 08:48:07', '2019-03-03 08:48:10');
INSERT INTO `course` VALUES (4, 4, '数据结构', '432', 1, '2019-02-22 08:46:03', '2019-06-30 08:46:28', '2019-03-03 08:48:48', '2019-03-03 08:48:53');
INSERT INTO `course` VALUES (5, 3, '12342', '4', 0, '2019-01-02 11:00:11', '2019-01-02 11:00:11', '2019-03-10 09:59:23', '2019-03-10 09:59:23');
INSERT INTO `course` VALUES (6, 3, '1', '432', 1, '2019-01-02 11:00:11', '2019-01-02 11:00:11', NULL, NULL);
INSERT INTO `course` VALUES (7, 3, '1231', '43', 1, '2019-01-02 11:00:11', '2019-01-02 11:00:11', '2019-03-10 10:17:44', '2019-03-10 10:17:44');
INSERT INTO `course` VALUES (8, 3, 'adsfsdf', '432', 1, '2019-01-05 11:00:11', '2019-01-02 11:00:11', NULL, NULL);
INSERT INTO `course` VALUES (9, 3, '12342', '432423', 1, '2019-01-05 11:00:11', '2019-01-02 11:00:11', '2019-03-10 10:26:22', '2019-03-10 10:26:22');
INSERT INTO `course` VALUES (10, 3, '1232', '23423423', 1, '2019-03-10 00:00:00', '2019-03-10 00:00:00', '2019-03-10 16:53:01', '2019-03-10 16:53:01');
INSERT INTO `course` VALUES (11, 3, '123424', '234242', 1, '2019-03-13 00:00:00', '2019-03-10 00:00:00', '2019-03-10 16:56:04', '2019-03-10 16:56:04');
INSERT INTO `course` VALUES (12, 3, '3245', '34636', 1, '2019-03-10 00:00:00', '2019-03-30 00:00:00', '2019-03-10 19:05:45', '2019-03-10 19:05:45');
INSERT INTO `course` VALUES (13, 3, '4363', '3464363', 1, '2019-03-10 00:00:00', '2019-03-22 00:00:00', '2019-03-10 19:05:59', '2019-03-10 19:05:59');
INSERT INTO `course` VALUES (14, 3, '234', '32424', 1, '2019-03-10 00:00:00', '2019-03-10 00:00:00', '2019-03-10 19:11:24', '2019-03-10 19:11:24');
INSERT INTO `course` VALUES (15, 3, '2342', '4242', 0, '2019-03-10 00:00:00', '2019-03-10 00:00:00', '2019-03-10 19:11:36', '2019-03-10 19:11:36');
INSERT INTO `course` VALUES (16, 3, '23423', '23434', 0, '2019-03-10 00:00:00', '2019-03-10 00:00:00', '2019-03-10 19:12:41', '2019-03-10 19:12:41');
INSERT INTO `course` VALUES (17, 3, '232432', '34242342', 1, '2019-03-11 00:00:00', '2019-03-23 00:00:00', '2019-03-11 21:10:37', '2019-03-11 21:10:37');
INSERT INTO `course` VALUES (18, 3, '3', '132423', 1, '2019-03-11 00:00:00', '2019-03-30 00:00:00', '2019-03-11 21:11:02', '2019-03-11 21:11:02');
INSERT INTO `course` VALUES (19, 3, '32425', '32423242342', 1, '2019-03-11 00:00:00', '2019-03-11 00:00:00', '2019-03-11 22:36:15', '2019-03-11 22:36:15');

-- ----------------------------
-- Table structure for homework
-- ----------------------------
DROP TABLE IF EXISTS `homework`;
CREATE TABLE `homework`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `courseId` bigint(20) NOT NULL,
  `typeId` bigint(20) NOT NULL COMMENT '类型id',
  `subject` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主题',
  `keyword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关键字',
  `require` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '要求',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `srcPath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附件资源',
  `fileType` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '学生提交附件类型：zip|rar|doc',
  `fileSize` int(20) NULL DEFAULT 2 COMMENT '附件大小（单位：M）',
  `deadline` datetime(0) NOT NULL COMMENT '期限',
  `valid` tinyint(4) NOT NULL DEFAULT 1 COMMENT '1有效，0删除',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `homework_fk1`(`courseId`) USING BTREE,
  INDEX `homework_fk2`(`typeId`) USING BTREE,
  CONSTRAINT `homework_fk1` FOREIGN KEY (`courseId`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of homework
-- ----------------------------
INSERT INTO `homework` VALUES (1, 1, 1, '实验一', 'C++，实验', '2312321312312312312312312312312312321313213                                 312312323213213                   123123123213                13123312           131312321', '23234324324234234', '/upload/附件11552528580371.docx', '', 1, '2019-03-15 08:51:33', 1, '2019-03-03 08:51:37', NULL);
INSERT INTO `homework` VALUES (2, 1, 1, '实验二', 'C++，实验', '2312321312312312312312312312312312321313213                                 312312323213213                   123123123213                13123312           131312321', '23234324324234234', '/upload/附件21552528595000.docx', 'zip|rar|doc', 1, '2019-03-21 08:37:17', 1, '2019-03-03 08:51:37', NULL);
INSERT INTO `homework` VALUES (4, 1, 2, '作业一', 'C++，实验', '2312321312312312312312312312312312321313213                                 312312323213213                   123123123213                13123312           131312321', '23234324324234234', '', 'rar|zip|doc', 1, '2019-03-21 20:37:17', 1, '2019-03-03 08:51:37', '2019-03-03 08:51:40');
INSERT INTO `homework` VALUES (5, 2, 2, '作业二', 'C++，实验', '2312321312312312312312312312312312321313213                                 312312323213213                   123123123213                13123312           131312321', '23234324324234234', '/upload/附件31552528602647.docx', 'zip|rar|doc', 1, '2019-03-21 08:37:17', 1, '2019-03-03 08:51:37', NULL);
INSERT INTO `homework` VALUES (6, 2, 2, '作业三', 'C++，实验', '2312321312312312312312312312312312321313213                                 312312323213213                   123123123213                13123312           131312321', '23234324324234234', '/upload/附件41552528611999.docx', 'zip|rar|doc', 1, '2019-03-21 08:37:17', 1, '2019-03-03 08:51:37', NULL);
INSERT INTO `homework` VALUES (7, 2, 3, '作业三', 'C++，实验', '2312321312312312312312312312312312321313213                                 312312323213213                   123123123213                13123312           131312321', '23234324324234234', '', 'rar|zip|doc', 1, '2019-03-21 20:37:17', 1, '2019-03-03 08:51:37', '2019-03-03 08:51:40');
INSERT INTO `homework` VALUES (8, 3, 1, '实验一', 'C++，实验', '2312321312312312312312312312312312321313213                                 312312323213213                   123123123213                13123312           131312321', '23234324324234234', '', 'rar|zip|doc', 1, '2019-03-21 20:37:17', 1, '2019-03-03 08:51:37', '2019-03-03 08:51:40');
INSERT INTO `homework` VALUES (9, 3, 1, '实验二', 'C++，实验', '2312321312312312312312312312312312321313213                                 312312323213213                   123123123213                13123312           131312321', '23234324324234234', '', 'rar|zip|doc', 1, '2019-03-03 08:51:33', 0, '2019-03-03 08:51:37', '2019-03-03 08:51:40');
INSERT INTO `homework` VALUES (10, 1, 1, '实验3', 'C++，实验', '2312321312312312312312312312312312321313213                                 312312323213213                   123123123213                13123312           131312321', '23234324324234234', '', 'rar|zip|doc', 1, '2019-03-03 08:51:33', 0, '2019-03-03 08:51:37', '2019-03-03 08:51:40');
INSERT INTO `homework` VALUES (11, 1, 1, '实验4', 'C++，实验', '2312321312312312312312312312312312321313213                                 312312323213213                   123123123213                13123312           131312321342342432424242432', '23234324324234234', '', 'rar|doc', 1, '2019-03-29 08:51:33', 1, '2019-03-03 08:51:37', NULL);
INSERT INTO `homework` VALUES (12, 1, 2, '作业3', 'C++，实验', '2312321312312312312312312312312312321313213                                 312312323213213                   123123123213                13123312           131312321', '23234324324234234', '', '', 1, '2019-03-30 08:51:33', 1, '2019-03-03 08:51:37', NULL);
INSERT INTO `homework` VALUES (13, 2, 2, '作业4', 'C++，实验', '2312321312312312312312312312312312321313213                                 312312323213213                   123123123213                13123312           131312321', '23234324324234234', '', '', 1, '2019-03-30 08:51:33', 1, '2019-03-03 08:51:37', NULL);
INSERT INTO `homework` VALUES (14, 2, 2, '作业4', 'C++，实验', '2312321312312312312312312312312312321313213                                 312312323213213                   123123123213                13123312           131312321', '23234324324234234', '', '', 1, '2019-03-30 08:51:33', 1, '2019-03-03 08:51:37', NULL);
INSERT INTO `homework` VALUES (15, 2, 3, '作业5', 'C++，实验', '2312321312312312312312312312312312321313213                                 312312323213213                   123123123213                13123312           131312321', '23234324324234234', '', '', 1, '2019-03-03 08:51:33', 1, '2019-03-03 08:51:37', '2019-03-03 08:51:40');
INSERT INTO `homework` VALUES (16, 3, 1, '实验4', 'C++，实验', '2312321312312312312312312312312312321313213                                 312312323213213                   123123123213                13123312           131312321', '23234324324234234', '', '', 1, '2019-03-30 08:51:33', 1, '2019-03-03 08:51:37', NULL);
INSERT INTO `homework` VALUES (17, 3, 1, '实验5', 'C++，实验', '2312321312312312312312312312312312321313213                                 312312323213213                   123123123213                13123312           131312321', '23234324324234234', '', '', 1, '2019-03-03 08:51:33', 1, '2019-03-03 08:51:37', '2019-03-03 08:51:40');
INSERT INTO `homework` VALUES (18, 1, 1, '23', '242342', '4242342', '2423424', '', 'rar|doc', 2, '2019-03-30 12:00:00', 1, '2019-03-11 21:54:59', NULL);
INSERT INTO `homework` VALUES (19, 1, 1, '23', '242342', '4242342', '2423424', '', '', 2, '2019-03-11 00:00:00', 1, '2019-03-11 21:56:13', '2019-03-11 21:56:13');
INSERT INTO `homework` VALUES (20, 1, 1, '23242', '3434', '34342342<img src=\"C:\\Users\\Pennsy\\Desktop\\homework-management-system(2)\\homework-management-system(2)\\src\\main\\resources\\static\\image\\20190311\\2e47320f77dc40969e2538d858d5a56e.png\" alt=\"undefined\">234234234234242', '42342342', '', '', 2, '2019-03-11 12:00:00', 1, '2019-03-11 22:16:48', NULL);
INSERT INTO `homework` VALUES (21, 2, 1, '0314', '1323', '213131232123123', '132132423432423432', '/upload/附件11552530744538.docx', 'zip|rar|doc|docx', 2, '2019-03-30 00:00:00', 1, '2019-03-14 10:32:31', '2019-03-14 10:32:31');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `courseId` bigint(20) NOT NULL COMMENT '课程id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '正文内容',
  `isPublish` tinyint(4) NULL DEFAULT NULL COMMENT '是否发布',
  `publishTime` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `notice_fk`(`courseId`) USING BTREE,
  CONSTRAINT `notice_fk` FOREIGN KEY (`courseId`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (1, 1, '通知一', '没什么事，啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦阿拉啦啦啦啦啦啦啦阿拉啦啦啦啦', 0, '2019-03-01 08:55:19', '2019-03-03 08:55:22', '2019-03-03 08:55:25');
INSERT INTO `notice` VALUES (3, 1, '通知三', '没什么事，啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦阿拉啦啦啦啦啦啦啦阿拉啦啦啦啦', 0, '2019-03-01 08:55:19', '2019-03-03 08:55:22', '2019-03-03 08:55:25');
INSERT INTO `notice` VALUES (4, 2, '通知一', '没什么事，啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦阿拉啦啦啦啦啦啦啦阿拉啦啦啦啦', 0, '2019-03-02 08:55:19', '2019-03-03 08:55:22', '2019-03-03 08:55:25');
INSERT INTO `notice` VALUES (6, 1, '通知一', '没什么事，啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦阿拉啦啦啦啦啦啦啦阿拉啦啦啦啦', 0, '2019-03-01 08:55:19', '2019-03-03 08:55:22', '2019-03-03 08:55:25');
INSERT INTO `notice` VALUES (8, 1, '通知三', '没什么事，啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦阿拉啦啦啦啦啦啦啦阿拉啦啦啦啦', 1, '2019-03-14 10:12:55', '2019-03-03 08:55:22', '2019-03-03 08:55:25');
INSERT INTO `notice` VALUES (9, 2, '通知一', '没什么事，啦', 1, '2019-03-14 10:12:54', '2019-03-03 08:55:22', NULL);
INSERT INTO `notice` VALUES (11, 1, '通知一', '没什么事，啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦阿拉啦啦啦啦啦啦啦阿拉啦啦啦啦', 0, '2019-03-01 08:55:19', '2019-03-03 08:55:22', '2019-03-03 08:55:25');
INSERT INTO `notice` VALUES (12, 1, '通知二', '没什么事，啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦阿拉啦啦啦啦啦啦啦阿拉啦啦啦啦', 1, '2019-03-14 10:12:55', '2019-03-03 08:55:22', '2019-03-03 08:55:25');
INSERT INTO `notice` VALUES (13, 1, '通知三', '没什么事，啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦阿拉啦啦啦啦啦啦啦阿拉啦啦啦啦', 0, '2019-03-03 08:55:19', '2019-03-03 08:55:22', '2019-03-03 08:55:25');
INSERT INTO `notice` VALUES (14, 2, '通知一', '没什么事，啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦阿拉啦啦啦啦啦啦啦阿拉啦啦啦啦', 0, '2019-03-02 08:55:19', '2019-03-03 08:55:22', '2019-03-03 08:55:25');
INSERT INTO `notice` VALUES (15, 3, '通知二', '没什么事，啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦阿拉啦啦啦啦啦啦啦阿拉啦啦啦啦', 0, '2019-03-03 08:55:19', '2019-03-03 08:55:22', '2019-03-03 08:55:25');
INSERT INTO `notice` VALUES (16, 3, '通知二', '没什么事', 1, '2019-03-14 10:12:54', '2019-03-11 20:30:46', NULL);
INSERT INTO `notice` VALUES (17, 2, '323', '<img src=\"C:\\Users\\Pennsy\\Desktop\\homework-management-system(2)\\homework-management-system(2)\\src\\main\\resources\\static\\image\\20190311\\a7f3387402734e0ca55ca484148b1978.png\" alt=\"undefined\">324234234324', 1, '2019-03-14 00:09:52', '2019-03-11 20:38:54', '2019-03-11 20:38:54');

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `courseId` bigint(20) NOT NULL COMMENT '课程id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源名称',
  `typeId` tinyint(4) NOT NULL,
  `srcPath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源路径',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `resource_fk`(`courseId`) USING BTREE,
  CONSTRAINT `resource_fk` FOREIGN KEY (`courseId`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES (2, 1, '资源二', 7, '/upload/附件31552528602647.docx', '啦啦啦啦阿拉阿拉啦啊啊阿拉阿拉啦啦啦啦', '2019-03-03 08:59:26', '2019-03-03 08:59:28');
INSERT INTO `resource` VALUES (3, 1, '资源三', 7, '/upload/附件31552528602647.docx', '啦啦啦啦阿拉阿拉啦啊啊阿拉阿拉啦啦啦啦', '2019-03-03 08:59:26', '2019-03-03 08:59:28');
INSERT INTO `resource` VALUES (4, 1, '资源四', 7, '/upload/附件31552528602647.docx', '啦啦啦啦阿拉阿拉啦啊啊阿拉阿拉啦啦啦啦', '2019-03-03 08:59:26', '2019-03-03 08:59:28');
INSERT INTO `resource` VALUES (5, 1, '资源五', 7, '/upload/附件31552528602647.docx', '啦啦啦啦阿拉阿拉啦啊啊阿拉阿拉啦啦啦啦', '2019-03-03 08:59:26', '2019-03-03 08:59:28');
INSERT INTO `resource` VALUES (6, 2, '资源一', 6, '/upload/附件31552528602647.docx', '啦啦啦啦阿拉阿拉啦啊啊阿拉阿拉啦啦啦啦', '2019-03-03 08:59:26', '2019-03-03 08:59:28');
INSERT INTO `resource` VALUES (7, 2, '资源2', 6, '/upload/附件31552528602647.docx', '啦啦啦啦阿拉阿拉啦啊啊阿拉阿拉啦啦啦啦', '2019-03-03 08:59:26', '2019-03-03 08:59:28');
INSERT INTO `resource` VALUES (8, 2, '资源3', 6, '/upload/附件31552528602647.docx', '啦啦啦啦阿拉阿拉啦啊啊阿拉阿拉啦啦啦啦', '2019-03-03 08:59:26', '2019-03-03 08:59:28');
INSERT INTO `resource` VALUES (9, 2, '资源4', 7, '/upload/附件31552528602647.docx', '啦啦啦啦阿拉阿拉啦啊啊阿拉阿拉啦啦啦啦', '2019-03-03 08:59:26', '2019-03-03 08:59:28');
INSERT INTO `resource` VALUES (10, 2, '资源5', 6, '/upload/附件31552528602647.docx', '啦啦啦啦阿拉阿拉啦啊啊阿拉阿拉啦啦啦啦', '2019-03-03 08:59:26', '2019-03-03 08:59:28');
INSERT INTO `resource` VALUES (11, 2, '资源6', 6, '/upload/附件31552528602647.docx', '啦啦啦啦阿拉阿拉啦啊啊阿拉阿拉啦啦啦啦', '2019-03-03 08:59:26', '2019-03-03 08:59:28');
INSERT INTO `resource` VALUES (14, 2, '资源9', 7, '/upload/附件31552528602647.docx', '啦啦啦啦阿拉阿拉啦啊啊阿拉阿拉啦啦啦啦', '2019-03-03 08:59:26', '2019-03-03 08:59:28');
INSERT INTO `resource` VALUES (15, 2, '资源10', 7, '/upload/附件31552528602647.docx', '啦啦啦啦阿拉阿拉啦啊啊阿拉阿拉啦啦啦啦', '2019-03-03 08:59:26', '2019-03-03 08:59:28');
INSERT INTO `resource` VALUES (16, 2, '资源11', 7, '/upload/附件31552528602647.docx', '啦啦啦啦阿拉阿拉啦啊啊阿拉阿拉啦啦啦啦', '2019-03-03 08:59:26', '2019-03-03 08:59:28');

-- ----------------------------
-- Table structure for stu_course
-- ----------------------------
DROP TABLE IF EXISTS `stu_course`;
CREATE TABLE `stu_course`  (
  `stuId` bigint(20) NOT NULL COMMENT '学生id',
  `courseId` bigint(20) NOT NULL COMMENT '课程id',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  INDEX `stu_course_fk1`(`stuId`) USING BTREE,
  INDEX `stu_course_fk2`(`courseId`) USING BTREE,
  CONSTRAINT `stu_course_fk1` FOREIGN KEY (`stuId`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `stu_course_fk2` FOREIGN KEY (`courseId`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu_course
-- ----------------------------
INSERT INTO `stu_course` VALUES (2, 2, '2019-03-03 09:04:10', '2019-03-03 09:04:13');
INSERT INTO `stu_course` VALUES (2, 3, '2019-03-03 09:04:21', '2019-03-03 09:04:18');
INSERT INTO `stu_course` VALUES (2, 1, NULL, NULL);

-- ----------------------------
-- Table structure for stu_homework
-- ----------------------------
DROP TABLE IF EXISTS `stu_homework`;
CREATE TABLE `stu_homework`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `stuId` bigint(20) NOT NULL COMMENT '学生id',
  `homeworkId` bigint(20) NOT NULL COMMENT '作业id',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `srcPath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '文件路径',
  `isRevise` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否批改',
  `score` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分数',
  `feedback` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '反馈',
  `submitTime` datetime(0) NULL DEFAULT NULL,
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `stu_homework_fk1`(`stuId`) USING BTREE,
  INDEX `stu_homework_fk2`(`homeworkId`) USING BTREE,
  CONSTRAINT `stu_homework_fk1` FOREIGN KEY (`stuId`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `stu_homework_fk2` FOREIGN KEY (`homeworkId`) REFERENCES `homework` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu_homework
-- ----------------------------
INSERT INTO `stu_homework` VALUES (1, 2, 1, '2131231213', '', 1, '70', '1232131', '2019-03-12 10:52:39', '2019-03-03 09:05:43', '2019-03-12 10:52:39');
INSERT INTO `stu_homework` VALUES (2, 2, 2, '', '', 1, '78', '拉拉拉拉拉拉阿拉', '2019-03-14 08:43:59', '2019-03-03 09:05:43', '2019-03-14 08:43:59');
INSERT INTO `stu_homework` VALUES (5, 2, 5, '', '/upload/11552528790690.rar', 1, '160', '324423', '2019-03-14 09:59:52', '2019-03-03 09:05:43', '2019-03-14 09:59:52');
INSERT INTO `stu_homework` VALUES (6, 2, 6, '123121', '', 1, NULL, NULL, '2019-03-12 10:02:09', '2019-03-03 09:05:43', '2019-03-12 10:02:09');
INSERT INTO `stu_homework` VALUES (7, 2, 7, '', '', 1, NULL, NULL, '2019-03-14 09:33:02', '2019-03-03 09:05:43', '2019-03-14 09:33:02');
INSERT INTO `stu_homework` VALUES (8, 2, 8, '', '/upload/11552530450906.rar', 1, '100', '234234242', '2019-03-14 10:27:34', '2019-03-03 09:05:43', '2019-03-14 10:27:34');
INSERT INTO `stu_homework` VALUES (10, 2, 4, '', '/upload/11552527281222.rar', 0, NULL, NULL, '2019-03-14 09:34:51', NULL, NULL);
INSERT INTO `stu_homework` VALUES (11, 2, 11, '0314', '/upload/11552530902716.rar', 1, '60', '23243354', '2019-03-14 10:35:08', NULL, '2019-03-14 10:35:08');
INSERT INTO `stu_homework` VALUES (12, 2, 16, '123213122312', NULL, 1, '100', '', '2019-03-14 10:38:07', NULL, NULL);

-- ----------------------------
-- Table structure for sys_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_info`;
CREATE TABLE `sys_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `keyCode` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createTime` datetime(0) NULL DEFAULT NULL,
  `updateTime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_info
-- ----------------------------
INSERT INTO `sys_info` VALUES (1, 'fileType', 'zip|rar|doc|docx|xsl|jpg|gif|docx', '2019-03-10 22:42:23', '2019-03-10 22:42:26');
INSERT INTO `sys_info` VALUES (2, 'notice', '哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈<br>哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈<br>哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈<br>', '2019-03-12 08:25:21', '2019-03-12 08:25:25');
INSERT INTO `sys_info` VALUES (3, 'maxFileSize', '20', '2019-03-12 08:29:07', '2019-03-12 08:29:11');
INSERT INTO `sys_info` VALUES (4, 'copyright', '23234324<br>23234324<br>哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈<br>呵呵呵呵呵呵呵呵呵呵或或或或<br>哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈<br>', '2019-03-12 10:57:16', '2019-03-12 10:57:19');
INSERT INTO `sys_info` VALUES (5, 'icon', '&#xe770;-用户', '2019-03-12 16:21:09', '2019-03-12 16:21:11');
INSERT INTO `sys_info` VALUES (6, 'icon', '&#xe64a;-图片', '2019-03-12 16:22:04', '2019-03-12 16:22:07');
INSERT INTO `sys_info` VALUES (7, 'icon', '&#xe62a;-选项卡', '2019-03-12 16:22:25', '2019-03-12 16:22:28');
INSERT INTO `sys_info` VALUES (8, 'icon', '&#xe620;-设置', '2019-03-12 16:22:52', '2019-03-12 16:22:55');
INSERT INTO `sys_info` VALUES (9, 'icon', '&#xe613;-群组', '2019-03-12 16:23:08', '2019-03-12 16:23:10');
INSERT INTO `sys_info` VALUES (10, 'icon', '&#xe606;-客服', '2019-03-12 16:23:28', '2019-03-12 16:23:31');
INSERT INTO `sys_info` VALUES (11, 'icon', '&#xe658;-收藏', '2019-03-12 16:23:54', '2019-03-12 16:23:56');
INSERT INTO `sys_info` VALUES (12, 'version', '作业管理系统 1.1.0##哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈', '2019-03-01 23:51:06', '2019-03-01 23:51:10');
INSERT INTO `sys_info` VALUES (13, 'version', '作业管理系统 1.2.0##哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈', '2019-03-02 23:51:47', '2019-03-02 23:51:51');
INSERT INTO `sys_info` VALUES (14, 'version', '作业管理系统 1.3.0##哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈', '2019-03-03 23:52:27', '2019-03-03 23:52:32');
INSERT INTO `sys_info` VALUES (15, 'version', '作业管理系统 1.4.0##哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈', '2019-03-04 23:52:50', '2019-03-04 23:52:54');
INSERT INTO `sys_info` VALUES (16, 'version', '作业管理系统 1.5.0##哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈', '2019-03-05 23:52:50', '2019-03-05 23:52:54');

-- ----------------------------
-- Table structure for sys_login_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_log`;
CREATE TABLE `sys_login_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `loginTime` datetime(0) NULL DEFAULT NULL COMMENT '登录时间',
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录ip',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '登录状态（1成功，0失败）',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `keyCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限键值',
  `resourceId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源id',
  `valid` tinyint(4) NULL DEFAULT 1,
  `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '1有效，0删除',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, '312312', '232', '3', 1, 1, '2019-03-12 15:16:10', '2019-03-12 15:16:12');
INSERT INTO `sys_permission` VALUES (2, '324234', '32342', '3', 1, 1, '2019-03-12 15:16:18', NULL);
INSERT INTO `sys_permission` VALUES (3, '8980', '454', '3', 1, 2, '2019-03-12 15:16:33', NULL);
INSERT INTO `sys_permission` VALUES (4, '343543', '23324', '3', 1, 1, '2019-03-12 15:16:40', '2019-03-12 15:16:42');

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parentId` bigint(20) NULL DEFAULT NULL COMMENT '父级资源id',
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '名称',
  `icon` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '图标',
  `url` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '资源路径',
  `valid` tinyint(4) NULL DEFAULT 1,
  `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态：0-删除，1-可用，2-禁用',
  `isBlank` tinyint(255) NOT NULL COMMENT '是否打开新窗口：1-打开，2-不打开',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `sys_resource_id`(`parentId`) USING BTREE,
  CONSTRAINT `sys_resource_id` FOREIGN KEY (`parentId`) REFERENCES `sys_resource` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES (1, NULL, '12343', '&#xe620;', '3243', 1, 2, 2, '2019-03-12 14:14:38', NULL);
INSERT INTO `sys_resource` VALUES (2, 3, '234', '213', '23424', 1, 2, 2, '2019-03-12 14:15:18', NULL);
INSERT INTO `sys_resource` VALUES (3, 3, '2324', '%EE%99%8A', '2322', 1, 1, 2, '2019-03-12 14:15:43', NULL);
INSERT INTO `sys_resource` VALUES (4, 3, '3224', '2', '23234', 1, 1, 1, '2019-03-12 16:02:25', NULL);
INSERT INTO `sys_resource` VALUES (5, NULL, '343', '%3F', '243', 1, 2, 1, '2019-03-12 18:20:38', '2019-03-12 18:20:38');
INSERT INTO `sys_resource` VALUES (6, NULL, '244', NULL, '343', 1, 2, 1, '2019-03-12 18:30:11', '2019-03-12 18:30:11');
INSERT INTO `sys_resource` VALUES (7, NULL, '3435', NULL, '3534', 1, 2, 1, '2019-03-12 18:30:24', '2019-03-12 18:30:24');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '1有效，0删除',
  `valid` tinyint(4) NULL DEFAULT 1,
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '管理员', 2, 1, '2019-02-27 13:02:16', NULL);
INSERT INTO `sys_role` VALUES (2, '教师', 2, 1, '2019-03-03 08:41:17', NULL);
INSERT INTO `sys_role` VALUES (3, '学生', 2, 1, '2019-03-03 08:41:36', '2019-03-03 08:41:39');
INSERT INTO `sys_role` VALUES (4, '24', 1, 1, '2019-03-12 15:27:32', NULL);
INSERT INTO `sys_role` VALUES (5, '2234', 1, 1, '2019-03-12 15:27:43', NULL);
INSERT INTO `sys_role` VALUES (6, '232', 2, 0, '2019-03-12 15:27:49', '2019-03-12 15:27:52');
INSERT INTO `sys_role` VALUES (7, '23', 2, 0, '2019-03-12 15:27:58', '2019-03-12 15:27:55');
INSERT INTO `sys_role` VALUES (8, '1323223', 1, 1, '2019-03-12 15:43:38', NULL);
INSERT INTO `sys_role` VALUES (9, '13232', 2, 1, '2019-03-12 15:43:46', '2019-03-12 15:43:46');
INSERT INTO `sys_role` VALUES (10, '234342', 2, 1, '2019-03-12 19:18:57', NULL);

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `roleId` bigint(20) NOT NULL COMMENT '角色id',
  `permissionId` bigint(20) NOT NULL COMMENT '权限id',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  INDEX `role_permission_fk1`(`roleId`) USING BTREE,
  INDEX `role_permission_fk2`(`permissionId`) USING BTREE,
  CONSTRAINT `role_permission_fk1` FOREIGN KEY (`roleId`) REFERENCES `sys_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `role_permission_fk2` FOREIGN KEY (`permissionId`) REFERENCES `sys_permission` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `valid` tinyint(4) NOT NULL DEFAULT 1 COMMENT '1有效，0删除',
  `keyCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES (1, '实验', 1, 'homework', '2019-02-21 14:42:40', '2019-02-21 14:42:42');
INSERT INTO `type` VALUES (2, '课后练习', 1, 'homework', '2019-03-03 08:44:16', '2019-03-03 08:44:18');
INSERT INTO `type` VALUES (3, '选做作业', 1, 'homework', '2019-03-03 08:44:34', '2019-03-03 08:44:37');
INSERT INTO `type` VALUES (4, '课程设计', 1, 'homework', '2019-03-03 08:44:55', '2019-03-03 08:44:59');
INSERT INTO `type` VALUES (6, '课件', 1, 'resource', '2019-03-03 20:38:16', '2019-03-03 20:38:19');
INSERT INTO `type` VALUES (7, '复习资料', 1, 'resource', '2019-03-03 20:39:05', '2019-03-03 20:39:08');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `roleId` bigint(20) NOT NULL COMMENT '角色id',
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `sex` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `clazz` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `valid` tinyint(4) NULL DEFAULT 1,
  `status` tinyint(4) NULL DEFAULT 1 COMMENT '1有效，0删除',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_fk`(`roleId`) USING BTREE,
  CONSTRAINT `user_fk` FOREIGN KEY (`roleId`) REFERENCES `sys_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 1, '管理员', '女', 'admin', 'e10adc3949ba59abbe56e057f20f883e', NULL, '13322221111', '734803752@qq.com', 1, 1, '2019-02-27 13:02:44', '2019-02-27 13:02:46');
INSERT INTO `user` VALUES (2, 3, 'huangyk', '男', 'huangyk', 'c4ca4238a0b923820dcc509a6f75849b', '15计机2班', '13427546836', '25872442433@qq.com', 1, 1, '2019-03-03 08:42:14', NULL);
INSERT INTO `user` VALUES (3, 2, '陈老师', '男', '2019', 'c4ca4238a0b923820dcc509a6f75849b', NULL, '13427542123', '1111@qq.com', 1, 1, '2019-03-09 17:44:39', '2019-03-09 17:44:42');
INSERT INTO `user` VALUES (4, 2, '吴老师', NULL, '20190303', '2019-02-22 08:46:03', NULL, NULL, NULL, 1, 1, '2019-03-03 08:49:38', NULL);
INSERT INTO `user` VALUES (5, 3, '2324', NULL, '34343', 'e10adc3949ba59abbe56e057f20f883e', NULL, NULL, NULL, 1, 1, NULL, NULL);
INSERT INTO `user` VALUES (6, 3, '32432', NULL, '3434434', 'e10adc3949ba59abbe56e057f20f883e', NULL, NULL, NULL, 1, 1, NULL, NULL);
INSERT INTO `user` VALUES (7, 3, '32431', NULL, '3423', 'e10adc3949ba59abbe56e057f20f883e', NULL, NULL, NULL, 0, 1, NULL, NULL);
INSERT INTO `user` VALUES (8, 3, '32434', NULL, '32431', 'e10adc3949ba59abbe56e057f20f883e', NULL, NULL, NULL, 0, 1, NULL, NULL);
INSERT INTO `user` VALUES (9, 3, '2423', NULL, 'huangyk123', 'e10adc3949ba59abbe56e057f20f883e', NULL, NULL, NULL, 1, 1, '2019-03-11 23:01:09', NULL);
INSERT INTO `user` VALUES (10, 3, '2015', NULL, '2015', 'e10adc3949ba59abbe56e057f20f883e', NULL, NULL, NULL, 1, 1, '2019-03-14 00:10:41', '2019-03-14 00:10:41');

SET FOREIGN_KEY_CHECKS = 1;
