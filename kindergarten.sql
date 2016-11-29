/*
Navicat MySQL Data Transfer

Source Server         : hainan
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : kindergarten

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2016-03-16 17:00:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_account
-- ----------------------------
DROP TABLE IF EXISTS `t_account`;
CREATE TABLE `t_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `acxh` varchar(225) DEFAULT NULL,
  `acname` varchar(225) DEFAULT NULL,
  `loginname` varchar(225) DEFAULT NULL,
  `loginpass` varchar(225) DEFAULT NULL,
  `aczy` varchar(225) DEFAULT NULL,
  `acbj` varchar(225) DEFAULT NULL,
  `acnj` varchar(225) DEFAULT NULL,
  `acqx` varchar(225) DEFAULT NULL,
  `acsex` varchar(225) DEFAULT NULL,
  `acxy` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_account
-- ----------------------------
INSERT INTO `t_account` VALUES ('1', '201107092303', '超级管理员', 'sasa', '111111', '软件工程', 'java113', '2011', '0', '女', '软件学院');
INSERT INTO `t_account` VALUES ('5', '31', '321', '231123', '111111', null, null, null, '2', '321', '312');
INSERT INTO `t_account` VALUES ('6', '5', '3', '12213', '111111', null, null, null, '2', '4', '6');
INSERT INTO `t_account` VALUES ('8', '33', '3', 'ssss', '1111', null, null, null, '2', '22', '24e3');
INSERT INTO `t_account` VALUES ('9', '33', '3', '333121', '1111', null, null, null, '2', '22', '24e3');
INSERT INTO `t_account` VALUES ('13', '2131231132', '爱迪生', 'wwww', '1111', '刘男生', '刘女士', '132321', '1', '2', 'wqqeewqw');
INSERT INTO `t_account` VALUES ('14', '12', '2121', 'mm11', '212121', '王大锤', '刘女', '2121', '1', '2', '朝阳区');
INSERT INTO `t_account` VALUES ('15', '12', '刘胖庞', '11122', '212121', '王先生', '刘女士', '12', '1', '1', '海淀区');
INSERT INTO `t_account` VALUES ('16', '15600160723', '娜娜', '23123', '3123132', '音乐', null, null, '2', '2', '156000234324');
INSERT INTO `t_account` VALUES ('17', '321321', '萨达', '1112132', '321321', '英语', null, null, '2', '2', '15600160233');
INSERT INTO `t_account` VALUES ('18', '321321', '娜娜大', '11112', '21122', '数学', null, null, '2', '2', '167977789');

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(225) DEFAULT NULL,
  `author` varchar(225) DEFAULT NULL,
  `bocbs` varchar(225) DEFAULT NULL,
  `bodj` varchar(225) DEFAULT NULL,
  `bozkj` varchar(225) DEFAULT NULL,
  `boremark` varchar(225) DEFAULT NULL,
  `bosh` varchar(225) DEFAULT NULL,
  `teid` bigint(20) DEFAULT NULL,
  `bonj` varchar(225) DEFAULT NULL,
  `bonf` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES ('1', '软件工程-原理、方法与应用', '史济民', '高等教育出版社', '28.00', '25.00', '23.00', '0', '1', '2011', '201  0');
INSERT INTO `t_book` VALUES ('2', 'IT项目管理', '杨坤', '机械工业出版社', '100.00', '80.00', '79.00', '2', '2', '132321', '2016');
INSERT INTO `t_book` VALUES ('3', '幼儿识数', '小小', '青花', '21', '18', '18', '2', '1', '132321', '2016');
INSERT INTO `t_book` VALUES ('4', '幼儿英语', 'TOMSMITH', '北京外国语学院', '30', '28', '简单实用，幼儿容易接受', '2', '1', '132321', '2016');

-- ----------------------------
-- Table structure for t_bost
-- ----------------------------
DROP TABLE IF EXISTS `t_bost`;
CREATE TABLE `t_bost` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `boid` bigint(20) DEFAULT NULL,
  `stid` bigint(20) DEFAULT NULL,
  `bj` varchar(225) DEFAULT NULL,
  `nj` varchar(225) DEFAULT NULL,
  `bonf` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_bost
-- ----------------------------
INSERT INTO `t_bost` VALUES ('18', '1', '201107092303', 'java113', '2011', '2015');

-- ----------------------------
-- Table structure for t_classes
-- ----------------------------
DROP TABLE IF EXISTS `t_classes`;
CREATE TABLE `t_classes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classesname` varchar(255) DEFAULT NULL,
  `stunum` int(11) DEFAULT NULL,
  `headmaster` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_classes
-- ----------------------------
INSERT INTO `t_classes` VALUES ('1', '32332', '3223', '32', '32322');
INSERT INTO `t_classes` VALUES ('2', 'ww', '333', 'rr', '22221333333333333333333333333');
INSERT INTO `t_classes` VALUES ('3', '2323', '213', 'qwwq', 'wqwqwq');

-- ----------------------------
-- Table structure for t_kecheng
-- ----------------------------
DROP TABLE IF EXISTS `t_kecheng`;
CREATE TABLE `t_kecheng` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `kch` varchar(225) DEFAULT NULL,
  `kcm` varchar(225) DEFAULT NULL,
  `kcxf` varchar(225) DEFAULT NULL,
  `kcnj` varchar(225) DEFAULT NULL,
  `kczy` varchar(225) DEFAULT NULL,
  `kclb` varchar(225) DEFAULT NULL,
  `kckh` varchar(225) DEFAULT NULL,
  `kcxszs` varchar(225) DEFAULT NULL,
  `teid` varchar(225) DEFAULT NULL,
  `kcsj` varchar(225) DEFAULT NULL,
  `kcnf` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_kecheng
-- ----------------------------
INSERT INTO `t_kecheng` VALUES ('1', '20003563', 'java基础', '100', '2011', '项目管理', '必修', '笔试', null, '勒右有', 'java 学习手册', '2015');
INSERT INTO `t_kecheng` VALUES ('2', '20003564', 'C#', '100', '2011', '软件学院', '必修', '笔试', null, '勒右有', 'Ｃ#', '2015');
INSERT INTO `t_kecheng` VALUES ('4', '2154256365', '没有课', '100', '2011', '软件工程', '必修', '随堂', null, '没人', '没有书', '2011');
INSERT INTO `t_kecheng` VALUES ('5', '123', '阿法迪三', '4534', '132321', '撒发生的', '阿士大夫撒', '按时发的撒', null, 's飞洒地方', '爱神的飞刀', '2015');
INSERT INTO `t_kecheng` VALUES ('6', '231', '3223', '321', '132321', '321', '231', '213', null, '321', '321', '2015');
INSERT INTO `t_kecheng` VALUES ('7', '1', '321', '100', '132321', '21321', '321321', '231321', null, '231321', '2', '2016');
INSERT INTO `t_kecheng` VALUES ('8', '我去', '11', null, '132321', null, '55', '66', null, '22', '44', '2016');
INSERT INTO `t_kecheng` VALUES ('9', '34', '432', null, '24323', null, '243', '243', null, '234', '2342', '2016');

-- ----------------------------
-- Table structure for t_kitchendisinfect
-- ----------------------------
DROP TABLE IF EXISTS `t_kitchendisinfect`;
CREATE TABLE `t_kitchendisinfect` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kitchenNo` varchar(255) DEFAULT NULL,
  `executor` varchar(255) DEFAULT NULL,
  `supervision` varchar(255) DEFAULT NULL,
  `tools` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `recordTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_kitchendisinfect
-- ----------------------------
INSERT INTO `t_kitchendisinfect` VALUES ('2', '21123', '3212', '123321', '321', '123123sadsad', '2016-03-15 15:34:12');

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(225) DEFAULT NULL,
  `jibie` bigint(20) DEFAULT NULL,
  `parent` bigint(20) DEFAULT NULL,
  `url` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', '教材管理www', '1', '0', null);
INSERT INTO `t_menu` VALUES ('2', '课表管理', '1', '0', null);
INSERT INTO `t_menu` VALUES ('3', '人员管理', '1', '0', null);
INSERT INTO `t_menu` VALUES ('4', '公告管理', '1', '0', null);
INSERT INTO `t_menu` VALUES ('5', '查看教材', '2', '1', null);
INSERT INTO `t_menu` VALUES ('6', '教材费用', '2', '1', null);
INSERT INTO `t_menu` VALUES ('7', '往年教材', '2', '1', null);
INSERT INTO `t_menu` VALUES ('8', '查看课表', '2', '2', null);
INSERT INTO `t_menu` VALUES ('9', '新增课表', '2', '2', null);
INSERT INTO `t_menu` VALUES ('10', '查看课程', '2', '2', null);
INSERT INTO `t_menu` VALUES ('11', '新增课程', '2', '2', null);
INSERT INTO `t_menu` VALUES ('12', '往年课表', '2', '2', null);
INSERT INTO `t_menu` VALUES ('13', '往年课程', '2', '2', null);
INSERT INTO `t_menu` VALUES ('14', '查看人员', '2', '3', null);
INSERT INTO `t_menu` VALUES ('15', '新增人员', '2', '3', null);
INSERT INTO `t_menu` VALUES ('16', '查看公告', '2', '4', null);

-- ----------------------------
-- Table structure for t_money
-- ----------------------------
DROP TABLE IF EXISTS `t_money`;
CREATE TABLE `t_money` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `money` varchar(225) DEFAULT NULL,
  `monj` varchar(225) DEFAULT NULL,
  `mobj` varchar(225) DEFAULT NULL,
  `moxq` varchar(225) DEFAULT NULL,
  `boid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_money
-- ----------------------------
INSERT INTO `t_money` VALUES ('1', null, '2011', '1', '1', '1');

-- ----------------------------
-- Table structure for t_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ntitle` varchar(225) DEFAULT NULL,
  `ntype` int(11) DEFAULT NULL,
  `ncontent` varchar(225) DEFAULT NULL,
  `ntime` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_notice
-- ----------------------------
INSERT INTO `t_notice` VALUES ('1', null, null, null, '2016-03-10 14:31');
INSERT INTO `t_notice` VALUES ('2', '22', null, '2额3额', '2016-03-08 16:06');
INSERT INTO `t_notice` VALUES ('3', '22', null, '22', '2016-03-08 17:00');
INSERT INTO `t_notice` VALUES ('4', null, null, null, '2016-03-14 21:28');
INSERT INTO `t_notice` VALUES ('5', '33', null, '333333', '2016-03-08 17:12');
INSERT INTO `t_notice` VALUES ('6', '33', null, '333333', '2016-03-08 17:12');
INSERT INTO `t_notice` VALUES ('7', '33222', null, '1111111111111111111111111', '2016-03-08 17:12');
INSERT INTO `t_notice` VALUES ('8', '22224444', null, 'eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee', '2016-03-09 09:19');
INSERT INTO `t_notice` VALUES ('9', '22224444', '1', 'eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee', '2016-03-09 09:20');
INSERT INTO `t_notice` VALUES ('10', '22222', '1', '222222dsadsdsa', '2016-03-09 09:20');
INSERT INTO `t_notice` VALUES ('11', '333', '0', '32423422222222222222', '2016-03-09 10:10');
INSERT INTO `t_notice` VALUES ('12', '34243243243', '2', '4324322222222222222', '2016-03-09 10:11');

-- ----------------------------
-- Table structure for t_paike
-- ----------------------------
DROP TABLE IF EXISTS `t_paike`;
CREATE TABLE `t_paike` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pknj` varchar(225) DEFAULT NULL,
  `pkqx` varchar(225) DEFAULT NULL,
  `pkxy` varchar(225) DEFAULT NULL,
  `title` varchar(225) DEFAULT NULL,
  `createtime` varchar(225) DEFAULT NULL,
  `pknf` varchar(255) DEFAULT NULL,
  `zypk` varchar(255) DEFAULT NULL,
  `tename` varchar(255) DEFAULT NULL,
  `tegh` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_paike
-- ----------------------------
INSERT INTO `t_paike` VALUES ('5', '132321', '1', '第1212个', '第1212个', '2015-01-26 18:46', '2013', '第1212个', null, null);
INSERT INTO `t_paike` VALUES ('6', '132321', '2', '红花幼儿园', '大班', '2016-03-10 14:41', '2013', null, '方法', '345');
INSERT INTO `t_paike` VALUES ('7', '132321', '1', '神力幼儿园', '201', '2016-03-10 14:54', '2016', '共24周', null, null);
INSERT INTO `t_paike` VALUES ('8', '132321', '2', '小神童幼儿园', 'qwe', '2016-03-16 10:22', '2016', null, '321', '132');
INSERT INTO `t_paike` VALUES ('9', '1', '1', '1', '1', '2016-03-16 10:25', '2016', '1', null, null);

-- ----------------------------
-- Table structure for t_pkval
-- ----------------------------
DROP TABLE IF EXISTS `t_pkval`;
CREATE TABLE `t_pkval` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pknj` varchar(225) DEFAULT NULL,
  `pkbj` varchar(225) DEFAULT NULL,
  `pkxq` varchar(225) DEFAULT NULL,
  `weid` bigint(20) DEFAULT NULL,
  `pkva_1` varchar(225) DEFAULT NULL,
  `pkid` bigint(20) DEFAULT NULL,
  `pkva_2` varchar(225) DEFAULT NULL,
  `pkva_3` varchar(225) DEFAULT NULL,
  `pkva_4` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_pkval
-- ----------------------------
INSERT INTO `t_pkval` VALUES ('22', null, null, null, '1', '第1212个', '5', '第一个', '第一个', '第一个');
INSERT INTO `t_pkval` VALUES ('23', null, null, null, '1', '1', '6', '2', '3', '4');
INSERT INTO `t_pkval` VALUES ('24', null, null, null, '2', '11', '6', '12', '13', '14');
INSERT INTO `t_pkval` VALUES ('25', null, null, null, '3', '21', '6', '22', '23', '24');
INSERT INTO `t_pkval` VALUES ('26', null, null, null, '4', '31', '6', '32', '33', '34');
INSERT INTO `t_pkval` VALUES ('27', null, null, null, '5', '41', '6', '42', '43', '44');
INSERT INTO `t_pkval` VALUES ('28', null, null, null, '6', '112', '6', '212', '2', '13');
INSERT INTO `t_pkval` VALUES ('29', null, null, null, '7', '312', '6', '31', '132', '132');
INSERT INTO `t_pkval` VALUES ('30', null, null, null, '1', 'e', '7', 'ee', 'eee', 'eeee');
INSERT INTO `t_pkval` VALUES ('31', null, null, null, '2', 'a', '7', 'aa', 'aaa', 'aaaa');
INSERT INTO `t_pkval` VALUES ('32', null, null, null, '3', 'd', '7', 'dd', 'ddd', 'dddd');
INSERT INTO `t_pkval` VALUES ('33', null, null, null, '4', 'c', '7', 'cc', 'ccc', 'ccccc');
INSERT INTO `t_pkval` VALUES ('34', null, null, null, '5', 'x', '7', 'xx', 'xxx', 'xxxxx');
INSERT INTO `t_pkval` VALUES ('35', null, null, null, '6', 's', '7', 'ss', 'sss', 'ssss');
INSERT INTO `t_pkval` VALUES ('36', null, null, null, '7', 'q', '7', 'qq', 'qqq', 'qqqq');
INSERT INTO `t_pkval` VALUES ('37', null, null, null, '1', '321', '8', '213', '21323', '231');
INSERT INTO `t_pkval` VALUES ('38', null, null, null, '2', '', '8', '', '123', '231');
INSERT INTO `t_pkval` VALUES ('39', null, null, null, '3', '', '8', '2123', '213', '1');
INSERT INTO `t_pkval` VALUES ('40', null, null, null, '4', '', '8', '', '321', '11');
INSERT INTO `t_pkval` VALUES ('41', null, null, null, '5', '', '8', '', '321', '1');
INSERT INTO `t_pkval` VALUES ('42', null, null, null, '6', '2132', '8', '', '321321', '1');
INSERT INTO `t_pkval` VALUES ('43', null, null, null, '7', '', '8', '', '1212', '1');
INSERT INTO `t_pkval` VALUES ('44', null, null, null, '1', '1', '9', '1', '1', '1');
INSERT INTO `t_pkval` VALUES ('45', null, null, null, '2', '1', '9', '1', '11', '1');
INSERT INTO `t_pkval` VALUES ('46', null, null, null, '3', '1', '9', '1', '1', '1');
INSERT INTO `t_pkval` VALUES ('47', null, null, null, '4', '2', '9', '2', '2', '2');
INSERT INTO `t_pkval` VALUES ('48', null, null, null, '5', '', '9', '', '', '');
INSERT INTO `t_pkval` VALUES ('49', null, null, null, '6', '', '9', '', '', '');
INSERT INTO `t_pkval` VALUES ('50', null, null, null, '7', '', '9', '', '', '');

-- ----------------------------
-- Table structure for t_protectmeasures
-- ----------------------------
DROP TABLE IF EXISTS `t_protectmeasures`;
CREATE TABLE `t_protectmeasures` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `executor` varchar(255) DEFAULT NULL,
  `supervision` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `recordTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_protectmeasures
-- ----------------------------
INSERT INTO `t_protectmeasures` VALUES ('1', '防护栏', 'ww', 'ss', 'qewewqewqewqweq', '2016-03-15 16:12:16');

-- ----------------------------
-- Table structure for t_regularmeeting
-- ----------------------------
DROP TABLE IF EXISTS `t_regularmeeting`;
CREATE TABLE `t_regularmeeting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `meetingTitle` varchar(255) DEFAULT NULL,
  `meetingCompere` varchar(255) DEFAULT NULL,
  `meetingContent` varchar(255) DEFAULT NULL,
  `meetingAttendee` varchar(255) DEFAULT NULL,
  `meetingAttendeeNum` int(11) DEFAULT NULL,
  `recordTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_regularmeeting
-- ----------------------------
INSERT INTO `t_regularmeeting` VALUES ('2', '2', '3', '4wewqewq', '3', '4', '2016-03-15 14:51:00');

-- ----------------------------
-- Table structure for t_schoolfee
-- ----------------------------
DROP TABLE IF EXISTS `t_schoolfee`;
CREATE TABLE `t_schoolfee` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `grade` varchar(255) DEFAULT NULL,
  `classes` varchar(255) DEFAULT NULL,
  `classnum` int(11) DEFAULT NULL,
  `projectname` varchar(255) DEFAULT NULL,
  `amount` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `addtime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_schoolfee
-- ----------------------------
INSERT INTO `t_schoolfee` VALUES ('1', '3', '2', '30', '体检', '50', '额外企鹅完全额外企鹅去', '2016');
INSERT INTO `t_schoolfee` VALUES ('2', '2', '201', '29', '午饭', '10', '粥，米饭，菜', '2016-03-10  11:31:55');
INSERT INTO `t_schoolfee` VALUES ('3', '1', '109', '23', '春游', '100', '问额外全额问问饿微微', '2016-03-10  11:44:07');
INSERT INTO `t_schoolfee` VALUES ('4', '2', '201', '29', '午饭', '12', '粥，米饭，菜', '2016-03-10  14:33:28');

-- ----------------------------
-- Table structure for t_stuaccident
-- ----------------------------
DROP TABLE IF EXISTS `t_stuaccident`;
CREATE TABLE `t_stuaccident` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classes` varchar(255) DEFAULT NULL,
  `stuName` varchar(255) DEFAULT NULL,
  `accidentDeatail` varchar(255) DEFAULT NULL,
  `recordTime` datetime DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_stuaccident
-- ----------------------------
INSERT INTO `t_stuaccident` VALUES ('2', 'ewwqe', 'ewqewq', 'ewqewewewew', '2016-03-14 20:56:00', '0');
INSERT INTO `t_stuaccident` VALUES ('3', '4455665', 'wqe', 'weqewwqe', '2016-03-14 21:28:00', '0');
INSERT INTO `t_stuaccident` VALUES ('4', '43', '34', '43345dsadsadsadsdsadsadsadsa', '2016-03-14 21:28:00', '0');

-- ----------------------------
-- Table structure for t_stumorningcheck
-- ----------------------------
DROP TABLE IF EXISTS `t_stumorningcheck`;
CREATE TABLE `t_stumorningcheck` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classes` varchar(255) DEFAULT NULL,
  `stuName` varchar(255) DEFAULT NULL,
  `isMorningCheck` int(11) DEFAULT NULL,
  `morningCheckTime` datetime DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_stumorningcheck
-- ----------------------------
INSERT INTO `t_stumorningcheck` VALUES ('1', '22', 'we', '0', '2016-03-14 16:10:00', 'ew');
INSERT INTO `t_stumorningcheck` VALUES ('2', '222', 'qwq', '0', '2016-03-14 16:10:00', 'wqqwq');
INSERT INTO `t_stumorningcheck` VALUES ('3', '22', 'ww', '0', '2016-03-14 16:10:00', 'www');
INSERT INTO `t_stumorningcheck` VALUES ('4', '222', '2222', '0', '2016-03-14 16:20:00', 'wdawadeas');
INSERT INTO `t_stumorningcheck` VALUES ('5', '233', '2332', '0', '2016-03-16 16:56:00', '32323232');

-- ----------------------------
-- Table structure for t_stusickcheck
-- ----------------------------
DROP TABLE IF EXISTS `t_stusickcheck`;
CREATE TABLE `t_stusickcheck` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classes` varchar(255) DEFAULT NULL,
  `sickLevel` int(11) DEFAULT NULL,
  `stuname` varchar(255) DEFAULT NULL,
  `sickcontent` varchar(255) DEFAULT NULL,
  `stuMChkTime` datetime DEFAULT NULL,
  `isMorningCheck` int(11) DEFAULT NULL,
  `isTakePills` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_stusickcheck
-- ----------------------------
INSERT INTO `t_stusickcheck` VALUES ('2', '222', '0', '2222222222222', '22222222222222222222222222', '2016-03-14 10:11:00', '0', '1');
INSERT INTO `t_stusickcheck` VALUES ('3', '322334', '3', '32324', '324444444444444442432', '2016-03-14 13:41:00', '0', '1');
INSERT INTO `t_stusickcheck` VALUES ('6', '3232', '0', '43432', 'qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq', '2016-03-14 15:32:00', '1', '1');
INSERT INTO `t_stusickcheck` VALUES ('8', '22', '0', 'dgg', 'gd', '2016-03-14 21:34:00', '0', '0');
INSERT INTO `t_stusickcheck` VALUES ('9', '222', '0', 'gfrgff', 'gfgf', '2016-03-14 21:34:00', '0', '0');
INSERT INTO `t_stusickcheck` VALUES ('10', '12', '0', 'wer', 'wer', '2016-03-14 21:35:00', '0', '1');
INSERT INTO `t_stusickcheck` VALUES ('11', '301', '0', '234323', '42432432432', '2016-03-16 15:02:00', '0', '0');

-- ----------------------------
-- Table structure for t_teacherstudy
-- ----------------------------
DROP TABLE IF EXISTS `t_teacherstudy`;
CREATE TABLE `t_teacherstudy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacherName` varchar(255) DEFAULT NULL,
  `course` varchar(255) DEFAULT NULL,
  `studyContent` varchar(255) DEFAULT NULL,
  `studyDetail` varchar(255) DEFAULT NULL,
  `recordTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_teacherstudy
-- ----------------------------
INSERT INTO `t_teacherstudy` VALUES ('1', '1', '1', '1', '1qwq', '2016-03-15 14:04:00');
INSERT INTO `t_teacherstudy` VALUES ('4', '1', '11', '2', '32342', '2016-03-15 09:31:00');

-- ----------------------------
-- Table structure for t_week
-- ----------------------------
DROP TABLE IF EXISTS `t_week`;
CREATE TABLE `t_week` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `week` varchar(225) DEFAULT NULL,
  `name` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_week
-- ----------------------------
INSERT INTO `t_week` VALUES ('1', '周一', 'ZY');
INSERT INTO `t_week` VALUES ('2', '周二', 'ZR');
INSERT INTO `t_week` VALUES ('3', '周三', 'ZS');
INSERT INTO `t_week` VALUES ('4', '周四', 'ZT');
INSERT INTO `t_week` VALUES ('5', '周五', 'ZF');
INSERT INTO `t_week` VALUES ('6', '周六', 'ZL');
INSERT INTO `t_week` VALUES ('7', '周日', 'ZQ');
