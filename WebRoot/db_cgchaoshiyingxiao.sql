/*
Navicat MySQL Data Transfer

Source Server         : sql
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : db_cgchaoshiyingxiao

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2020-02-06 15:53:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_admin`
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `adminPassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`adminId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'admin', 'admin');

-- ----------------------------
-- Table structure for `t_bumen`
-- ----------------------------
DROP TABLE IF EXISTS `t_bumen`;
CREATE TABLE `t_bumen` (
  `bumenId` int(11) NOT NULL AUTO_INCREMENT,
  `bumenName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `bumenMark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `bumenMark1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `bumenMark2` int(11) DEFAULT NULL,
  PRIMARY KEY (`bumenId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_bumen
-- ----------------------------
INSERT INTO `t_bumen` VALUES ('2', '采购', '采购', null, null);
INSERT INTO `t_bumen` VALUES ('3', '销售', '销售', null, null);

-- ----------------------------
-- Table structure for `t_shangpin`
-- ----------------------------
DROP TABLE IF EXISTS `t_shangpin`;
CREATE TABLE `t_shangpin` (
  `shangpinId` int(11) NOT NULL AUTO_INCREMENT,
  `shangpinName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `shangpinMark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `shangpinMark1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `shangpinMark2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `shangpinMark3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `shangpinDate` datetime DEFAULT NULL,
  `shangpinDate1` datetime DEFAULT NULL,
  `shangpinZong` int(11) DEFAULT NULL,
  `shangpinJin` double DEFAULT NULL,
  `shangpinXiao` double DEFAULT NULL,
  `shangpinLirun` double DEFAULT NULL,
  `shangpinType` int(11) DEFAULT NULL,
  `shangpinType1` int(11) DEFAULT NULL,
  `shangpinImg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `shangpinImgName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sptypeId` int(11) DEFAULT NULL,
  `sptypeName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `bumenId` int(11) DEFAULT NULL,
  `bumenName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  `roleName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`shangpinId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_shangpin
-- ----------------------------
INSERT INTO `t_shangpin` VALUES ('1', '面粉', null, '面粉', null, null, '2019-03-17 10:19:23', null, '300', '10048000', '1701200', '-8346800', '0', '300', null, null, '1', '日用品', null, null, null, null, null, null);
INSERT INTO `t_shangpin` VALUES ('2', '筷子', null, '筷子', null, null, '2019-03-17 10:19:31', null, '412', '15000', '172800', '157800', '0', '300', null, null, '1', '日用品', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `t_spcangku`
-- ----------------------------
DROP TABLE IF EXISTS `t_spcangku`;
CREATE TABLE `t_spcangku` (
  `spcangkuId` int(11) NOT NULL AUTO_INCREMENT,
  `spcangkuName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `spcangkuMark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `spcangkuMark1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `spcangkuMark2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `spcangkuPhone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `spcangkuDizhi` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `spcangkuDate` datetime DEFAULT NULL,
  `spcangkuDate1` datetime DEFAULT NULL,
  `spcangkuType` int(11) DEFAULT NULL,
  `spcangkuType1` int(11) DEFAULT NULL,
  PRIMARY KEY (`spcangkuId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_spcangku
-- ----------------------------
INSERT INTO `t_spcangku` VALUES ('1', '仓库1', '文具', null, null, '123456789', '仓库1', null, null, null, null);
INSERT INTO `t_spcangku` VALUES ('2', '仓库2', '日用品', null, null, '12345678', '仓库2', null, null, null, null);

-- ----------------------------
-- Table structure for `t_spchu`
-- ----------------------------
DROP TABLE IF EXISTS `t_spchu`;
CREATE TABLE `t_spchu` (
  `spchuId` int(11) NOT NULL AUTO_INCREMENT,
  `spchuName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `spchuMark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `spchuMark1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `spchuMark2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `spchuMark3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `spchuDate` datetime DEFAULT NULL,
  `spchuDate1` datetime DEFAULT NULL,
  `spchuZong` int(11) DEFAULT NULL,
  `spchuJine` double DEFAULT NULL,
  `spchuZe` double DEFAULT NULL,
  `spchuType` int(11) DEFAULT NULL,
  `spchuType1` int(11) DEFAULT NULL,
  `shangpinId` int(11) DEFAULT NULL,
  `shangpinName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sptypeId` int(11) DEFAULT NULL,
  `sptypeName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `yonghuId` int(11) DEFAULT NULL,
  `yonghuName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `yhroleId` int(11) DEFAULT NULL,
  `yhroleName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `yhbumenId` int(11) DEFAULT NULL,
  `yhbumenName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `bumenId` int(11) DEFAULT NULL,
  `bumenName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  `roleName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `spchuImg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `spchuImgName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`spchuId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_spchu
-- ----------------------------
INSERT INTO `t_spchu` VALUES ('1', null, null, null, null, null, '2019-03-17 10:20:59', null, '22', '600', '13200', '0', null, '1', '面粉', '1', '日用品', '1', 'yonghu1', null, null, null, null, '2', 'user2', '3', '销售', null, null, null, null);
INSERT INTO `t_spchu` VALUES ('2', null, null, null, null, null, '2019-03-17 10:21:08', null, '55', '400', '22000', '0', null, '1', '面粉', '1', '日用品', '1', 'yonghu1', null, null, null, null, '2', 'user2', '3', '销售', null, null, null, null);
INSERT INTO `t_spchu` VALUES ('3', null, null, null, null, null, '2019-03-17 10:21:36', null, '88', '600', '52800', '0', null, '2', '筷子', '1', '日用品', '1', 'yonghu1', null, null, null, null, '2', 'user2', '3', '销售', null, null, null, null);
INSERT INTO `t_spchu` VALUES ('4', null, null, null, null, null, '2019-04-10 22:33:53', null, '10', '600', '6000', '0', null, '1', '面粉', '1', '日用品', '1', 'yonghu1', null, null, null, null, '2', 'user2', '3', '销售', null, null, null, null);
INSERT INTO `t_spchu` VALUES ('5', null, null, null, null, null, '2019-04-11 18:40:27', null, '50', '600', '30000', '0', null, '1', '面粉', '1', '日用品', '1', 'yonghu1', null, null, null, null, '2', 'user2', '3', '销售', null, null, null, null);
INSERT INTO `t_spchu` VALUES ('7', null, null, null, null, null, '2019-04-17 10:40:42', null, '200', '600', '120000', '0', null, '2', '筷子', '1', '日用品', null, null, null, null, null, null, '2', 'user2', '3', '销售', null, null, null, null);

-- ----------------------------
-- Table structure for `t_spgys`
-- ----------------------------
DROP TABLE IF EXISTS `t_spgys`;
CREATE TABLE `t_spgys` (
  `spgysId` int(11) NOT NULL AUTO_INCREMENT,
  `spgysName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `spgysMark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `spgysMark1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `spgysMark2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `spgysPhone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `spgysDizhi` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `spgysDate` datetime DEFAULT NULL,
  `spgysDate1` datetime DEFAULT NULL,
  `spgysType` int(11) DEFAULT NULL,
  `spgysType1` int(11) DEFAULT NULL,
  PRIMARY KEY (`spgysId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_spgys
-- ----------------------------
INSERT INTO `t_spgys` VALUES ('1', '供应商1', '供应商1', null, null, '13012345678', '供应商1', null, null, null, null);
INSERT INTO `t_spgys` VALUES ('2', '供应商2', '老王', null, null, '123456789', '洛阳', null, null, null, null);

-- ----------------------------
-- Table structure for `t_spjin`
-- ----------------------------
DROP TABLE IF EXISTS `t_spjin`;
CREATE TABLE `t_spjin` (
  `spjinId` int(11) NOT NULL AUTO_INCREMENT,
  `spjinName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `spjinMark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `spjinMark1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `spjinMark2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `spjinMark3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `spjinDate` datetime DEFAULT NULL,
  `spjinDate1` datetime DEFAULT NULL,
  `spjinZong` int(11) DEFAULT NULL,
  `spjinJine` double DEFAULT NULL,
  `spjinZe` double DEFAULT NULL,
  `spjinType` int(11) DEFAULT NULL,
  `spjinType1` int(11) DEFAULT NULL,
  `shangpinId` int(11) DEFAULT NULL,
  `shangpinName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sptypeId` int(11) DEFAULT NULL,
  `sptypeName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `spcangkuId` int(11) DEFAULT NULL,
  `spcangkuName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `spgysId` int(11) DEFAULT NULL,
  `spgysName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `bumenId` int(11) DEFAULT NULL,
  `bumenName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  `roleName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `spjinImg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `spjinImgName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`spjinId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_spjin
-- ----------------------------
INSERT INTO `t_spjin` VALUES ('1', null, null, null, null, null, '2019-03-17 10:19:54', null, '300', '10', '3000', '1', null, '1', '面粉', '1', '日用品', '1', '仓库1', '1', '供应商1', '1', 'user1', '2', '采购', null, null, null, null);
INSERT INTO `t_spjin` VALUES ('2', null, null, null, null, null, '2019-03-17 10:20:01', null, '500', '10', '5000', '1', null, '2', '筷子', '1', '日用品', '1', '仓库1', '1', '供应商1', '1', 'user1', '2', '采购', null, null, null, null);
INSERT INTO `t_spjin` VALUES ('4', null, null, null, null, null, '2019-04-14 13:10:07', null, '100', '400', '40000', '1', null, '1', '面粉', '1', '日用品', '1', '仓库1', '1', '供应商1', '1', 'user1', '2', '采购', null, null, null, null);
INSERT INTO `t_spjin` VALUES ('5', null, null, null, null, null, '2019-04-17 10:41:24', null, '200', '50', '10000', '1', null, '2', '筷子', '1', '日用品', '1', '仓库1', '1', '供应商1', '1', 'user1', '2', '采购', null, null, null, null);
INSERT INTO `t_spjin` VALUES ('6', null, null, null, null, null, '2019-04-17 17:22:17', null, '100', '50', '5000', '1', null, '1', '面粉', '1', '日用品', null, null, null, null, '1', 'user1', '2', '采购', null, null, null, null);

-- ----------------------------
-- Table structure for `t_sptype`
-- ----------------------------
DROP TABLE IF EXISTS `t_sptype`;
CREATE TABLE `t_sptype` (
  `sptypeId` int(11) NOT NULL AUTO_INCREMENT,
  `sptypeName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sptypeMark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sptypeMark1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sptypeMark2` int(11) DEFAULT NULL,
  PRIMARY KEY (`sptypeId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_sptype
-- ----------------------------
INSERT INTO `t_sptype` VALUES ('3', '食品', '土豆', null, null);
INSERT INTO `t_sptype` VALUES ('4', '文具', '橡皮', null, null);

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userPassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userXingming` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userSex` int(11) DEFAULT NULL,
  `userAge` int(11) DEFAULT NULL,
  `userPhone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userMark1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userMark2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userMark3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userMark4` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userDate1` datetime DEFAULT NULL,
  `userDate2` datetime DEFAULT NULL,
  `userType1` int(11) DEFAULT NULL,
  `userType2` int(11) DEFAULT NULL,
  `userImg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userImgName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  `roleName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `bumenId` int(11) DEFAULT NULL,
  `bumenName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'user1', 'user1', 'user1', '0', '22', '13012345678', 'user1', null, null, null, null, null, null, null, null, null, null, null, '2', '采购');
INSERT INTO `t_user` VALUES ('2', 'user2', 'user2', 'user2', '0', '22', '13012345678', 'user2', null, null, null, null, null, null, null, null, null, null, null, '3', '销售');

-- ----------------------------
-- Table structure for `t_yonghu`
-- ----------------------------
DROP TABLE IF EXISTS `t_yonghu`;
CREATE TABLE `t_yonghu` (
  `yonghuId` int(11) NOT NULL AUTO_INCREMENT,
  `yonghuName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `yonghuPassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `yonghuXingming` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `yonghuSex` int(11) DEFAULT NULL,
  `yonghuAge` int(11) DEFAULT NULL,
  `yonghuPhone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `yonghuMark1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `yonghuMark2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `yonghuMark3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `yonghuMark4` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `yonghuDate1` datetime DEFAULT NULL,
  `yonghuDate2` datetime DEFAULT NULL,
  `yonghuType1` int(11) DEFAULT NULL,
  `yonghuType2` int(11) DEFAULT NULL,
  `yonghuImg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `yonghuImgName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `yhroleId` int(11) DEFAULT NULL,
  `yhroleName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `yhbumenId` int(11) DEFAULT NULL,
  `yhbumenName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`yonghuId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_yonghu
-- ----------------------------
INSERT INTO `t_yonghu` VALUES ('1', 'yonghu1', null, null, '1', '22', '13012345678', 'yonghu1', '2019-03-12', 'yonghu1', 'yonghu1', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_yonghu` VALUES ('2', '崔雨田', null, null, '0', '21', '151151515151', '河南', '2020-02-06', '女', '代码', null, null, null, null, null, null, null, null, null, null);
