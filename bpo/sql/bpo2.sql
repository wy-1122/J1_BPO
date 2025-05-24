/*
 Navicat Premium Data Transfer

 Source Server         : 39.106.248.162_3306
 Source Server Type    : MySQL
 Source Server Version : 80024
 Source Host           : 39.106.248.162:3306
 Source Schema         : bpo2

 Target Server Type    : MySQL
 Target Server Version : 80024
 File Encoding         : 65001

 Date: 24/05/2025 09:11:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_for_project
-- ----------------------------
DROP TABLE IF EXISTS `admin_for_project`;
CREATE TABLE `admin_for_project`  (
  `User_Project_Admin_ID` int(0) NOT NULL,
  `Project_Admin_Name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`User_Project_Admin_ID`) USING BTREE,
  CONSTRAINT `FK_Reference_26` FOREIGN KEY (`User_Project_Admin_ID`) REFERENCES `user_role` (`User_Role_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_for_project
-- ----------------------------
INSERT INTO `admin_for_project` VALUES (3, 'admin');

-- ----------------------------
-- Table structure for bidding_scheme
-- ----------------------------
DROP TABLE IF EXISTS `bidding_scheme`;
CREATE TABLE `bidding_scheme`  (
  `User_Employee_ID` int(0) NOT NULL,
  `Project_ID` int(0) NOT NULL,
  `User_Employer_ID` int(0) NOT NULL,
  `Project_Period` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Project_Amout` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Project_Superiority` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Bidding_Example` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `User_Employee_Name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `User_Employee_Tel` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Bidding_Status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`User_Employee_ID`, `Project_ID`, `User_Employer_ID`) USING BTREE,
  INDEX `FK_Reference_13`(`Project_ID`) USING BTREE,
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`User_Employee_ID`) REFERENCES `user_employee` (`User_employee_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_13` FOREIGN KEY (`Project_ID`) REFERENCES `project` (`Project_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bidding_scheme
-- ----------------------------
INSERT INTO `bidding_scheme` VALUES (2, 1, 1, '4', '4444', '44', '44', '444', '44444444444', '竞标中');
INSERT INTO `bidding_scheme` VALUES (7, 1, 1, '11', '11', '11', '1', '12323', '12222221111', '已选中');
INSERT INTO `bidding_scheme` VALUES (17, 2, 1, '22', '2222', '22222', '22222', '2222', '22222222222', '已选中');
INSERT INTO `bidding_scheme` VALUES (21, 6, 18, '14', '14', '陈艺宁', '陈艺宁', '陈艺宁', 'ccccccccccc', '已选中');

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill`  (
  `Bill_ID` int(0) NOT NULL AUTO_INCREMENT,
  `User_ID` int(0) NULL DEFAULT NULL,
  `Bill_Value` float NULL DEFAULT NULL,
  `Bill_Type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Bill_Time` datetime(0) NULL DEFAULT NULL,
  `Bill_Description` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Bill_ID`) USING BTREE,
  INDEX `FK_Reference_7`(`User_ID`) USING BTREE,
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`User_ID`) REFERENCES `user` (`User_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES (4, 9, 2.8, '支付定金', '2025-05-23 23:20:09', '服务外包发布方定金');
INSERT INTO `bill` VALUES (5, 10, 1.4, '支付定金', '2025-05-23 23:20:50', '服务外包承包方定金');
INSERT INTO `bill` VALUES (6, 9, 11.2, '支付尾款', '2025-05-23 23:22:22', '服务外包支付尾款');
INSERT INTO `bill` VALUES (7, 10, 15.4, '全额转付', '2025-05-23 23:22:54', '服务外包全额转付');

-- ----------------------------
-- Table structure for case_project
-- ----------------------------
DROP TABLE IF EXISTS `case_project`;
CREATE TABLE `case_project`  (
  `User_employee` int(0) NOT NULL,
  `Project_Name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Project_Period` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Role_In_Project` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Tech_In_Project` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Project_Introduction` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`User_employee`) USING BTREE,
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`User_employee`) REFERENCES `user_employee` (`User_employee_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of case_project
-- ----------------------------

-- ----------------------------
-- Table structure for cash_flow
-- ----------------------------
DROP TABLE IF EXISTS `cash_flow`;
CREATE TABLE `cash_flow`  (
  `Flow_ID` int(0) NOT NULL AUTO_INCREMENT,
  `Money_ID` int(0) NOT NULL,
  `Money_Admin_ID` int(0) NULL DEFAULT NULL,
  `Order_Type_ID` int(0) NULL DEFAULT NULL,
  `Open_Balance_Income` float NULL DEFAULT NULL,
  `Open_Balance_Outcome` float NULL DEFAULT NULL,
  `Current_Occurence_Amount_Income` float NULL DEFAULT NULL,
  `Current_Occurence_Amount_Outcome` float NULL DEFAULT NULL,
  `Accumulated_Amount_Income` float NULL DEFAULT NULL,
  `Accumulated_Amount_Outcome` float NULL DEFAULT NULL,
  `Closing_Balance_Income` float NULL DEFAULT NULL,
  `Closing_Balance_Outcome` float NULL DEFAULT NULL,
  PRIMARY KEY (`Flow_ID`, `Money_ID`) USING BTREE,
  INDEX `FK_Reference_31`(`Money_ID`) USING BTREE,
  INDEX `FK_Reference_33`(`Money_Admin_ID`) USING BTREE,
  INDEX `FK_Reference_34`(`Order_Type_ID`) USING BTREE,
  CONSTRAINT `FK_Reference_31` FOREIGN KEY (`Money_ID`) REFERENCES `money_notification` (`Money_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_33` FOREIGN KEY (`Money_Admin_ID`) REFERENCES `money_admin` (`Money_Admin_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_34` FOREIGN KEY (`Order_Type_ID`) REFERENCES `transaction_type` (`Order_Type_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cash_flow
-- ----------------------------
INSERT INTO `cash_flow` VALUES (2, 4, NULL, 1, 0, 0, 2.8, 0, 2.8, 0, 2.8, 0);
INSERT INTO `cash_flow` VALUES (3, 5, NULL, 1, 2.8, 0, 1.4, 0, 4.2, 0, 4.2, 0);
INSERT INTO `cash_flow` VALUES (4, 6, NULL, 2, 4.2, 0, 11.2, 0, 15.4, 0, 15.4, 0);
INSERT INTO `cash_flow` VALUES (5, 7, NULL, 6, 15.4, 0, 0, 15.4, 15.4, 15.4, 0, 0);

-- ----------------------------
-- Table structure for client_support
-- ----------------------------
DROP TABLE IF EXISTS `client_support`;
CREATE TABLE `client_support`  (
  `Equipment_ID` int(0) NOT NULL AUTO_INCREMENT,
  `Equipment_Name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Equipment_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of client_support
-- ----------------------------
INSERT INTO `client_support` VALUES (1, '网站');
INSERT INTO `client_support` VALUES (2, '桌面软件');
INSERT INTO `client_support` VALUES (3, '小程序');
INSERT INTO `client_support` VALUES (4, '微信公众号');
INSERT INTO `client_support` VALUES (5, 'H5页面');
INSERT INTO `client_support` VALUES (6, 'IOS');
INSERT INTO `client_support` VALUES (7, '安卓');
INSERT INTO `client_support` VALUES (8, '其他形式');
INSERT INTO `client_support` VALUES (9, NULL);

-- ----------------------------
-- Table structure for employee_skills
-- ----------------------------
DROP TABLE IF EXISTS `employee_skills`;
CREATE TABLE `employee_skills`  (
  `User_Employee` int(0) NOT NULL,
  `Application_Type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Project_Type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Development_Language` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Development_Skills` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Position_Availble` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Product` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`User_Employee`) USING BTREE,
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`User_Employee`) REFERENCES `user_employee` (`User_employee_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee_skills
-- ----------------------------

-- ----------------------------
-- Table structure for evaluation
-- ----------------------------
DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE `evaluation`  (
  `Evaluation_ID` int(0) NOT NULL AUTO_INCREMENT,
  `User_Role_ID` int(0) NOT NULL,
  `Order_ID` int(0) NOT NULL,
  `Evaluation_Time` datetime(0) NULL DEFAULT NULL,
  `Evaluation_Details` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Evaluation_ID`, `User_Role_ID`, `Order_ID`) USING BTREE,
  INDEX `FK_Reference_18`(`Order_ID`) USING BTREE,
  INDEX `FK_Reference_37`(`User_Role_ID`) USING BTREE,
  CONSTRAINT `FK_Reference_18` FOREIGN KEY (`Order_ID`) REFERENCES `orders` (`Order_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_37` FOREIGN KEY (`User_Role_ID`) REFERENCES `user_role` (`User_Role_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of evaluation
-- ----------------------------
INSERT INTO `evaluation` VALUES (1, 21, 3, '2025-05-24 08:25:47', '谢谢你cyn');
INSERT INTO `evaluation` VALUES (2, 18, 3, '2025-05-24 08:52:34', '谢谢你，王雅');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `Message_ID` int(0) NOT NULL AUTO_INCREMENT,
  `User_ID` int(0) NULL DEFAULT NULL,
  `Role_ID` int(0) NULL DEFAULT NULL,
  `Message_Time` datetime(0) NULL DEFAULT NULL,
  `Message_Info` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Message_ID`) USING BTREE,
  INDEX `FK_Reference_5`(`User_ID`) USING BTREE,
  INDEX `FK_Reference_6`(`Role_ID`) USING BTREE,
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`User_ID`) REFERENCES `user` (`User_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`Role_ID`) REFERENCES `role` (`Role_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------

-- ----------------------------
-- Table structure for money_admin
-- ----------------------------
DROP TABLE IF EXISTS `money_admin`;
CREATE TABLE `money_admin`  (
  `Money_Admin_ID` int(0) NOT NULL,
  `Money_Admin_Name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Money_Admin_ID`) USING BTREE,
  CONSTRAINT `FK_Reference_36` FOREIGN KEY (`Money_Admin_ID`) REFERENCES `user_role` (`User_Role_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of money_admin
-- ----------------------------

-- ----------------------------
-- Table structure for money_notification
-- ----------------------------
DROP TABLE IF EXISTS `money_notification`;
CREATE TABLE `money_notification`  (
  `Money_ID` int(0) NOT NULL AUTO_INCREMENT,
  `Order_ID` int(0) NOT NULL,
  `User_ID` int(0) NULL DEFAULT NULL,
  `Order_Admin_ID` int(0) NULL DEFAULT NULL,
  `Money_Time` datetime(0) NULL DEFAULT NULL,
  `Amount` float NULL DEFAULT NULL,
  `Money_Type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Money_Description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Money_ID`) USING BTREE,
  INDEX `FK_Reference_30`(`Order_Admin_ID`) USING BTREE,
  INDEX `FK_Reference_32`(`Order_ID`) USING BTREE,
  INDEX `FK_Reference_38`(`User_ID`) USING BTREE,
  INDEX `FK_Reference_39`(`Money_Type`) USING BTREE,
  CONSTRAINT `FK_Reference_30` FOREIGN KEY (`Order_Admin_ID`) REFERENCES `order_admin` (`Order_Admin_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_32` FOREIGN KEY (`Order_ID`) REFERENCES `orders` (`Order_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_38` FOREIGN KEY (`User_ID`) REFERENCES `user` (`User_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of money_notification
-- ----------------------------
INSERT INTO `money_notification` VALUES (4, 3, 9, NULL, '2025-05-23 23:20:09', 2.8, '支付定金', '服务外包发布方定金');
INSERT INTO `money_notification` VALUES (5, 3, 10, NULL, '2025-05-23 23:20:50', 1.4, '支付定金', '服务外包承包方定金');
INSERT INTO `money_notification` VALUES (6, 3, 9, NULL, '2025-05-23 23:22:22', 11.2, '支付尾款', '服务外包支付尾款');
INSERT INTO `money_notification` VALUES (7, 3, 10, NULL, '2025-05-23 23:22:54', 15.4, '全额转付', '服务外包全额转付');

-- ----------------------------
-- Table structure for order_admin
-- ----------------------------
DROP TABLE IF EXISTS `order_admin`;
CREATE TABLE `order_admin`  (
  `Order_Admin_ID` int(0) NOT NULL,
  `Order_Admin_Name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Order_Admin_ID`) USING BTREE,
  CONSTRAINT `FK_Reference_35` FOREIGN KEY (`Order_Admin_ID`) REFERENCES `user_role` (`User_Role_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_admin
-- ----------------------------

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `Order_ID` int(0) NOT NULL AUTO_INCREMENT,
  `Project_ID` int(0) NOT NULL,
  `User_employee_ID` int(0) NULL DEFAULT NULL,
  `User_Employer_ID` int(0) NULL DEFAULT NULL,
  `Order_Start_Time` datetime(0) NULL DEFAULT NULL,
  `Order_State` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Order_Amount` float NULL DEFAULT NULL,
  `Schedule` int(0) NULL DEFAULT NULL,
  `Employer_Deposit` float NULL DEFAULT NULL,
  `Employee_Deposit` float NULL DEFAULT NULL,
  PRIMARY KEY (`Order_ID`) USING BTREE,
  INDEX `FK_Reference_16`(`Project_ID`) USING BTREE,
  INDEX `FK_ORDERS_REFERENCE_USER_EMP2`(`User_employee_ID`) USING BTREE,
  INDEX `FK_Reference_23`(`User_Employer_ID`) USING BTREE,
  INDEX `FK_Reference_40`(`Order_State`) USING BTREE,
  CONSTRAINT `FK_ORDERS_REFERENCE_USER_EMP2` FOREIGN KEY (`User_employee_ID`) REFERENCES `user_employee` (`User_employee_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_16` FOREIGN KEY (`Project_ID`) REFERENCES `project` (`Project_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_23` FOREIGN KEY (`User_Employer_ID`) REFERENCES `user_employer` (`User_Employer_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, 1, 7, 1, '2025-05-22 23:19:02', '未付定金', 11, 11, 2.2, 1.1);
INSERT INTO `orders` VALUES (2, 2, 17, 1, '2025-05-23 10:22:37', '未付定金', 2222, 22, 444.4, 222.2);
INSERT INTO `orders` VALUES (3, 6, 21, 18, '2025-05-23 22:35:15', '评价完成', 14, 14, 2.8, 1.4);

-- ----------------------------
-- Table structure for orders_state
-- ----------------------------
DROP TABLE IF EXISTS `orders_state`;
CREATE TABLE `orders_state`  (
  `Orders_State_ID` int(0) NOT NULL,
  `Order_State` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Orders_State_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders_state
-- ----------------------------
INSERT INTO `orders_state` VALUES (1, '支付定金');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `permission_ID` int(0) NOT NULL AUTO_INCREMENT,
  `Permission_Name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Permission_Description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`permission_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `Project_ID` int(0) NOT NULL AUTO_INCREMENT,
  `User_Employer_ID` int(0) NOT NULL,
  `Equipment_ID` int(0) NULL DEFAULT NULL,
  `Project_Type_ID` int(0) NULL DEFAULT NULL,
  `Project_Admin_ID` int(0) NULL DEFAULT NULL,
  `Project_Name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Skills_Requirement` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Project_Requirement` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Project_Period` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Project_Budget` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Project_Status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Connect_Tel` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Connect_Name` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Project_ID`) USING BTREE,
  INDEX `FK_Reference_15`(`User_Employer_ID`) USING BTREE,
  INDEX `FK_Reference_27`(`Equipment_ID`) USING BTREE,
  INDEX `FK_Reference_28`(`Project_Type_ID`) USING BTREE,
  INDEX `FK_Reference_29`(`Project_Admin_ID`) USING BTREE,
  CONSTRAINT `FK_Reference_15` FOREIGN KEY (`User_Employer_ID`) REFERENCES `user_employer` (`User_Employer_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_27` FOREIGN KEY (`Equipment_ID`) REFERENCES `client_support` (`Equipment_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_28` FOREIGN KEY (`Project_Type_ID`) REFERENCES `project_type` (`Project_Type_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_29` FOREIGN KEY (`Project_Admin_ID`) REFERENCES `admin_for_project` (`User_Project_Admin_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES (1, 1, 1, 3, 3, '服务中标', 'Hibernate,Python,C++,Java', '服务中保', '30', '10000-50000', '已出单', '18967777777', 'hhh');
INSERT INTO `project` VALUES (2, 1, 2, 2, 3, 'nnn', 'PHP,C++,Netty', 'nnn', '122', '5000以下', '已出单', '12312312321', '123');
INSERT INTO `project` VALUES (3, 1, 5, 11, 3, '11233', 'PHP,Java', '132312', '33', '10000-50000', '已通过', '13312321321', '33333');
INSERT INTO `project` VALUES (4, 18, 2, 7, 3, '服务外包', 'Java', '服务外包', '123', '5000-10000', '已通过', '11011011011', '王雅');
INSERT INTO `project` VALUES (5, 18, 1, 1, 3, '服务外包2', 'Java', '服务外包2', '123', '5000以下', '已通过', '22222222222', '王雅');
INSERT INTO `project` VALUES (6, 18, 1, 1, 3, '服务外包', 'Java', '服务外包', '123', '可议价', '已完成', '11111111111', '王雅');

-- ----------------------------
-- Table structure for project_type
-- ----------------------------
DROP TABLE IF EXISTS `project_type`;
CREATE TABLE `project_type`  (
  `Project_Type_ID` int(0) NOT NULL AUTO_INCREMENT,
  `Project_Type_Name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Project_Type_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project_type
-- ----------------------------
INSERT INTO `project_type` VALUES (1, '视频图像类');
INSERT INTO `project_type` VALUES (2, '虚拟现实类');
INSERT INTO `project_type` VALUES (3, '人工智能类');
INSERT INTO `project_type` VALUES (4, '电商应用类');
INSERT INTO `project_type` VALUES (5, '游戏娱乐类');
INSERT INTO `project_type` VALUES (6, '办公管理类');
INSERT INTO `project_type` VALUES (7, '金融交易类');
INSERT INTO `project_type` VALUES (8, '物联网应用类');
INSERT INTO `project_type` VALUES (9, '工具支持类');
INSERT INTO `project_type` VALUES (10, '底层研发类');
INSERT INTO `project_type` VALUES (11, '嵌入式开发类');
INSERT INTO `project_type` VALUES (12, '视图设计类');
INSERT INTO `project_type` VALUES (13, '其他项目类');
INSERT INTO `project_type` VALUES (14, NULL);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `Role_ID` int(0) NOT NULL AUTO_INCREMENT,
  `Role_Name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Role_Description` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Role_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '发包方', NULL);
INSERT INTO `role` VALUES (2, '承包方', NULL);
INSERT INTO `role` VALUES (3, '项目管理员', NULL);

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `Role_ID` int(0) NOT NULL,
  `Permission_ID` int(0) NOT NULL,
  PRIMARY KEY (`Role_ID`, `Permission_ID`) USING BTREE,
  INDEX `FK_Reference_4`(`Permission_ID`) USING BTREE,
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`Role_ID`) REFERENCES `role` (`Role_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`Permission_ID`) REFERENCES `permission` (`permission_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for transaction_type
-- ----------------------------
DROP TABLE IF EXISTS `transaction_type`;
CREATE TABLE `transaction_type`  (
  `Order_Type_ID` int(0) NOT NULL AUTO_INCREMENT,
  `Order_Type_Name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Order_Type_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of transaction_type
-- ----------------------------
INSERT INTO `transaction_type` VALUES (1, '支付定金');
INSERT INTO `transaction_type` VALUES (2, '支付尾款');
INSERT INTO `transaction_type` VALUES (3, '违约扣款');
INSERT INTO `transaction_type` VALUES (4, '违约赔偿');
INSERT INTO `transaction_type` VALUES (5, '定金退还');
INSERT INTO `transaction_type` VALUES (6, '全额转付');
INSERT INTO `transaction_type` VALUES (7, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `User_ID` int(0) NOT NULL AUTO_INCREMENT,
  `User_Name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Money` float NULL DEFAULT 0,
  PRIMARY KEY (`User_ID`) USING BTREE,
  UNIQUE INDEX `AK_UQ_USER_NAME`(`User_Name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'b', 'b', 0);
INSERT INTO `user` VALUES (2, 'admin', 'admin', 0);
INSERT INTO `user` VALUES (3, 'c', 'c', 0);
INSERT INTO `user` VALUES (4, 'hzw', 'hzw', 0);
INSERT INTO `user` VALUES (5, 'aaa', 'aaa', 0);
INSERT INTO `user` VALUES (6, 'ba', 'ba', 0);
INSERT INTO `user` VALUES (7, 'asdf', 'ad', 0);
INSERT INTO `user` VALUES (8, 'gg', 'gg', 0);
INSERT INTO `user` VALUES (9, 'wy', 'wy', -14);
INSERT INTO `user` VALUES (10, 'cyn', 'cyn', 14);

-- ----------------------------
-- Table structure for user_employee
-- ----------------------------
DROP TABLE IF EXISTS `user_employee`;
CREATE TABLE `user_employee`  (
  `User_employee_ID` int(0) NOT NULL,
  `Employee_Name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Employee_Region` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Employee_Enterprise` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Employee_Self_Introduction` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Employee_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`User_employee_ID`) USING BTREE,
  CONSTRAINT `FK_Reference_24` FOREIGN KEY (`User_employee_ID`) REFERENCES `user_role` (`User_Role_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_employee
-- ----------------------------
INSERT INTO `user_employee` VALUES (2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_employee` VALUES (7, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_employee` VALUES (9, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_employee` VALUES (11, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_employee` VALUES (13, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_employee` VALUES (15, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_employee` VALUES (17, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_employee` VALUES (19, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_employee` VALUES (21, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user_employer
-- ----------------------------
DROP TABLE IF EXISTS `user_employer`;
CREATE TABLE `user_employer`  (
  `User_Employer_ID` int(0) NOT NULL,
  `User_Employer_Name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `User_Employer_Region` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `User_Employer_Inctroduction` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `User_Employer_Tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`User_Employer_ID`) USING BTREE,
  CONSTRAINT `FK_USER_EMP_REFERENCE_USER_ROL2` FOREIGN KEY (`User_Employer_ID`) REFERENCES `user_role` (`User_Role_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_employer
-- ----------------------------
INSERT INTO `user_employer` VALUES (1, 'b', NULL, NULL, NULL);
INSERT INTO `user_employer` VALUES (6, 'c', NULL, NULL, NULL);
INSERT INTO `user_employer` VALUES (8, 'hzw', NULL, NULL, NULL);
INSERT INTO `user_employer` VALUES (10, 'aaa', NULL, NULL, NULL);
INSERT INTO `user_employer` VALUES (12, 'ba', NULL, NULL, NULL);
INSERT INTO `user_employer` VALUES (14, 'asdf', NULL, NULL, NULL);
INSERT INTO `user_employer` VALUES (16, 'gg', NULL, NULL, NULL);
INSERT INTO `user_employer` VALUES (18, 'wy', NULL, NULL, NULL);
INSERT INTO `user_employer` VALUES (20, 'cyn', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `User_ID` int(0) NOT NULL,
  `Role_ID` int(0) NOT NULL,
  `User_Role_ID` int(0) NOT NULL AUTO_INCREMENT,
  `Money` float NULL DEFAULT NULL,
  PRIMARY KEY (`User_Role_ID`) USING BTREE,
  INDEX `FK_Reference_1`(`User_ID`) USING BTREE,
  INDEX `FK_Reference_2`(`Role_ID`) USING BTREE,
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`User_ID`) REFERENCES `user` (`User_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`Role_ID`) REFERENCES `role` (`Role_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1, NULL);
INSERT INTO `user_role` VALUES (1, 2, 2, NULL);
INSERT INTO `user_role` VALUES (2, 3, 3, NULL);
INSERT INTO `user_role` VALUES (2, 1, 4, NULL);
INSERT INTO `user_role` VALUES (2, 2, 5, NULL);
INSERT INTO `user_role` VALUES (3, 1, 6, NULL);
INSERT INTO `user_role` VALUES (3, 2, 7, NULL);
INSERT INTO `user_role` VALUES (4, 1, 8, NULL);
INSERT INTO `user_role` VALUES (4, 2, 9, NULL);
INSERT INTO `user_role` VALUES (5, 1, 10, NULL);
INSERT INTO `user_role` VALUES (5, 2, 11, NULL);
INSERT INTO `user_role` VALUES (6, 1, 12, NULL);
INSERT INTO `user_role` VALUES (6, 2, 13, NULL);
INSERT INTO `user_role` VALUES (7, 1, 14, NULL);
INSERT INTO `user_role` VALUES (7, 2, 15, NULL);
INSERT INTO `user_role` VALUES (8, 1, 16, NULL);
INSERT INTO `user_role` VALUES (8, 2, 17, NULL);
INSERT INTO `user_role` VALUES (9, 1, 18, NULL);
INSERT INTO `user_role` VALUES (9, 2, 19, NULL);
INSERT INTO `user_role` VALUES (10, 1, 20, NULL);
INSERT INTO `user_role` VALUES (10, 2, 21, NULL);

-- ----------------------------
-- View structure for cashflowdetail
-- ----------------------------
DROP VIEW IF EXISTS `cashflowdetail`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `cashflowdetail` AS select `cash_flow`.`Flow_ID` AS `Flow_ID`,`cash_flow`.`Money_ID` AS `Money_ID`,`cash_flow`.`Money_Admin_ID` AS `Money_Admin_ID`,`cash_flow`.`Order_Type_ID` AS `Order_Type_ID`,`cash_flow`.`Open_Balance_Income` AS `Open_Balance_Income`,`cash_flow`.`Open_Balance_Outcome` AS `Open_Balance_Outcome`,`cash_flow`.`Current_Occurence_Amount_Income` AS `Current_Occurence_Amount_Income`,`cash_flow`.`Current_Occurence_Amount_Outcome` AS `Current_Occurence_Amount_Outcome`,`cash_flow`.`Accumulated_Amount_Income` AS `Accumulated_Amount_Income`,`cash_flow`.`Accumulated_Amount_Outcome` AS `Accumulated_Amount_Outcome`,`cash_flow`.`Closing_Balance_Income` AS `Closing_Balance_Income`,`cash_flow`.`Closing_Balance_Outcome` AS `Closing_Balance_Outcome`,`transaction_type`.`Order_Type_Name` AS `Order_Type_Name`,`money_notification`.`Money_Time` AS `Money_Time` from ((`cash_flow` join `transaction_type`) join `money_notification`) where ((`cash_flow`.`Order_Type_ID` = `transaction_type`.`Order_Type_ID`) and (`cash_flow`.`Money_ID` = `money_notification`.`Money_ID`));

-- ----------------------------
-- View structure for evaluationdetails
-- ----------------------------
DROP VIEW IF EXISTS `evaluationdetails`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `evaluationdetails` AS select `evaluation`.`Evaluation_ID` AS `Evaluation_ID`,`evaluation`.`User_Role_ID` AS `User_Role_ID`,`evaluation`.`Order_ID` AS `Order_ID`,`evaluation`.`Evaluation_Time` AS `Evaluation_Time`,`evaluation`.`Evaluation_Details` AS `Evaluation_Details`,`project`.`Project_Name` AS `Project_Name` from ((`evaluation` join `orders` on((`orders`.`Order_ID` = `evaluation`.`Order_ID`))) join `project` on((`orders`.`Project_ID` = `project`.`Project_ID`)));

-- ----------------------------
-- View structure for orderwithcontact
-- ----------------------------
DROP VIEW IF EXISTS `orderwithcontact`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `orderwithcontact` AS select `orders`.`Order_ID` AS `Order_ID`,`project`.`Project_ID` AS `Project_ID`,`project`.`User_Employer_ID` AS `User_Employer_ID`,`bidding_scheme`.`User_Employee_ID` AS `User_Employee_ID`,`project`.`Project_Name` AS `Project_Name`,`project`.`Connect_Name` AS `Connect_Name`,`project`.`Connect_Tel` AS `Connect_Tel`,`bidding_scheme`.`User_Employee_Name` AS `User_Employee_Name`,`bidding_scheme`.`User_Employee_Tel` AS `User_Employee_Tel`,`orders`.`Schedule` AS `Schedule`,`orders`.`Order_Start_Time` AS `Order_Start_Time`,`orders`.`Order_State` AS `Order_State`,`orders`.`Order_Amount` AS `Order_Amount`,`orders`.`Employer_Deposit` AS `Employer_Deposit`,`orders`.`Employee_Deposit` AS `Employee_Deposit` from ((`orders` join `project` on((`orders`.`Project_ID` = `project`.`Project_ID`))) join `bidding_scheme` on(((`bidding_scheme`.`User_Employee_ID` = `orders`.`User_employee_ID`) and (`bidding_scheme`.`Project_ID` = `project`.`Project_ID`))));

-- ----------------------------
-- View structure for schemewithprojectname
-- ----------------------------
DROP VIEW IF EXISTS `schemewithprojectname`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `schemewithprojectname` AS select `bidding_scheme`.`User_Employee_ID` AS `User_Employee_ID`,`bidding_scheme`.`Project_ID` AS `Project_ID`,`bidding_scheme`.`User_Employer_ID` AS `User_Employer_ID`,`bidding_scheme`.`Project_Period` AS `Project_Period`,`bidding_scheme`.`Project_Amout` AS `Project_Amout`,`bidding_scheme`.`Project_Superiority` AS `Project_Superiority`,`bidding_scheme`.`Bidding_Example` AS `Bidding_Example`,`bidding_scheme`.`User_Employee_Name` AS `User_Employee_Name`,`bidding_scheme`.`User_Employee_Tel` AS `User_Employee_Tel`,`bidding_scheme`.`Bidding_Status` AS `Bidding_Status`,`project`.`Project_Name` AS `Project_Name` from (`bidding_scheme` join `project` on((`bidding_scheme`.`Project_ID` = `project`.`Project_ID`)));

-- ----------------------------
-- View structure for userrolepermission
-- ----------------------------
DROP VIEW IF EXISTS `userrolepermission`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `userrolepermission` AS select `user`.`User_ID` AS `User_ID`,`user`.`User_Name` AS `User_Name`,`user`.`Password` AS `Password`,`user_role`.`User_Role_ID` AS `User_Role_ID`,`user_role`.`Role_ID` AS `Role_ID`,`role`.`Role_Name` AS `Role_Name`,`role`.`Role_Description` AS `Role_Description`,`permission`.`permission_ID` AS `permission_ID`,`permission`.`Permission_Name` AS `Permission_Name`,`permission`.`Permission_Description` AS `Permission_Description` from ((((`user` join `user_role` on((`user`.`User_ID` = `user_role`.`User_ID`))) join `role` on((`user_role`.`Role_ID` = `role`.`Role_ID`))) join `role_permission` on((`role_permission`.`Role_ID` = `role`.`Role_ID`))) join `permission` on((`permission`.`permission_ID` = `role_permission`.`Permission_ID`))) order by `user`.`User_ID`;

SET FOREIGN_KEY_CHECKS = 1;
