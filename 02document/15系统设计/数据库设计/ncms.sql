/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.7.17 : Database - ncms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ncms` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `ncms`;

/*Table structure for table `t_changeclass` */

DROP TABLE IF EXISTS `t_changeclass`;

CREATE TABLE `t_changeclass` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `STUID` bigint(20) DEFAULT NULL COMMENT '学生编号',
  `CLASSID` int(11) DEFAULT NULL COMMENT '现班级ID',
  `STUCODE` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '现学号',
  `OLDCLASSID` int(11) DEFAULT NULL COMMENT '原班级ID',
  `OLDSTUCODE` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '原学号',
  `CHANGEDATE` datetime DEFAULT NULL COMMENT '转班日期',
  `OPTDATE` datetime DEFAULT NULL COMMENT '操作日期',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='转班记录表';

/*Data for the table `t_changeclass` */

/*Table structure for table `t_channel` */

DROP TABLE IF EXISTS `t_channel`;

CREATE TABLE `t_channel` (
  `CHANNELID` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `CHNLNAME` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '名称(唯一标识)',
  `CHNLDESC` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '描述(显示名称)',
  `CHNLNAMEPATH` varchar(2000) COLLATE utf8_bin DEFAULT NULL COMMENT '栏目路径',
  `PARENTID` int(11) DEFAULT NULL COMMENT '父栏目编号',
  `CHNLORDER` int(11) DEFAULT NULL COMMENT '排序号',
  `CRTIME` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`CHANNELID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='频道表';

/*Data for the table `t_channel` */

/*Table structure for table `t_channel_info` */

DROP TABLE IF EXISTS `t_channel_info`;

CREATE TABLE `t_channel_info` (
  `CHANNELID` bigint(20) DEFAULT NULL COMMENT '频道ID',
  `DOCID` int(11) DEFAULT NULL COMMENT '文档ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='频道与信息关系表';

/*Data for the table `t_channel_info` */

/*Table structure for table `t_class` */

DROP TABLE IF EXISTS `t_class`;

CREATE TABLE `t_class` (
  `CLASSID` int(11) NOT NULL AUTO_INCREMENT COMMENT '班级ID',
  `CODE` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '班级编号',
  `SCHOOLAREA` int(11) DEFAULT NULL COMMENT '所属校区',
  `SPECIALTY` int(11) DEFAULT NULL COMMENT '专业方向',
  `BEGINDATE` datetime DEFAULT NULL COMMENT '开课日期',
  `ENDDATE` datetime DEFAULT NULL COMMENT '结课日期',
  `INITCOUNT` int(11) DEFAULT NULL COMMENT '开班人数',
  `ONLINECOUNT` int(11) DEFAULT NULL COMMENT '在读人数',
  `STATUS` int(11) DEFAULT NULL COMMENT '班级状态',
  `ENDCOUNT` int(11) DEFAULT NULL COMMENT '结课人数',
  `EXAMCOUNT` int(11) DEFAULT NULL COMMENT '考试人数',
  `PASSCOUNT` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '考试通过率',
  `JOBCOUNT` int(11) DEFAULT NULL COMMENT '就业人数',
  `PRAISECOUNT` int(11) DEFAULT NULL COMMENT '口碑人数',
  `MISSCOUNT` int(11) DEFAULT NULL COMMENT '流失人数',
  `ISDELETE` int(11) DEFAULT NULL COMMENT '是否已删除',
  PRIMARY KEY (`CLASSID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='班级信息表';

/*Data for the table `t_class` */

insert  into `t_class`(`CLASSID`,`CODE`,`SCHOOLAREA`,`SPECIALTY`,`BEGINDATE`,`ENDDATE`,`INITCOUNT`,`ONLINECOUNT`,`STATUS`,`ENDCOUNT`,`EXAMCOUNT`,`PASSCOUNT`,`JOBCOUNT`,`PRAISECOUNT`,`MISSCOUNT`,`ISDELETE`) values (1,'A1',1,1,'2019-03-01 11:14:23','2019-03-31 11:14:30',55,55,55,55,55,'55',55,55,55,0);

/*Table structure for table `t_class_user_rel` */

DROP TABLE IF EXISTS `t_class_user_rel`;

CREATE TABLE `t_class_user_rel` (
  `CLASSID` int(11) DEFAULT NULL COMMENT '班级ID',
  `USERID` int(11) DEFAULT NULL COMMENT '用户ID',
  KEY `FK_Reference_7` (`CLASSID`),
  KEY `FK_Reference_9` (`USERID`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`CLASSID`) REFERENCES `t_class` (`CLASSID`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`USERID`) REFERENCES `t_user` (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='班级教师关系表';

/*Data for the table `t_class_user_rel` */

/*Table structure for table `t_comment` */

DROP TABLE IF EXISTS `t_comment`;

CREATE TABLE `t_comment` (
  `COMMENTID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `COMMENTCONTENT` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '评论内容',
  `PARENTID` bigint(20) DEFAULT NULL COMMENT '父评论ID',
  `CRTIME` datetime DEFAULT NULL COMMENT '评论时间',
  `USERID` int(11) DEFAULT NULL COMMENT '评论人',
  `SUBJECTID` bigint(20) DEFAULT NULL COMMENT '评论所属主题',
  `ISNEWQUEST` varchar(2) COLLATE utf8_bin DEFAULT NULL COMMENT '是否属于新发起问题下的评论',
  PRIMARY KEY (`COMMENTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='评论表';

/*Data for the table `t_comment` */

/*Table structure for table `t_comment_tag` */

DROP TABLE IF EXISTS `t_comment_tag`;

CREATE TABLE `t_comment_tag` (
  `TAG` int(11) DEFAULT NULL COMMENT '标识',
  `INTRO` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '标识说明',
  `OPTIME` datetime DEFAULT NULL COMMENT '操作时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='评论关闭标识表';

/*Data for the table `t_comment_tag` */

insert  into `t_comment_tag`(`TAG`,`INTRO`,`OPTIME`) values (1,'是否关闭评论标识，0开启评论功能，1关闭评论','2019-03-15 22:34:01');

/*Table structure for table `t_dict` */

DROP TABLE IF EXISTS `t_dict`;

CREATE TABLE `t_dict` (
  `DICTTYPE` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '字典大类',
  `DICTID` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '字典小类',
  `DICNAME` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '字典名称',
  `SORTNO` int(11) DEFAULT NULL COMMENT '排序号',
  `REMARK` varchar(250) COLLATE utf8_bin DEFAULT NULL COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='数据字典表';

/*Data for the table `t_dict` */

insert  into `t_dict`(`DICTTYPE`,`DICTID`,`DICNAME`,`SORTNO`,`REMARK`) values ('isdelete','0','否',10,'是否已删除-否'),('isdelete','1','是',10,'是否已删除-是'),('sex','1','男',50,'男'),('sex','2','女',10,'女'),('class_status','1','在读',50,'班级状态-在读'),('class_status','2','结课',10,'班级状态-结课'),('specialty','1','Java',80,'专业方向'),('specialty','2','嵌入式',60,'专业方向'),('specialty','3','安卓',40,'专业方向'),('specialty','4','测试',20,'专业方向'),('specialty','5','Web前端',10,'专业方向'),('pay_type','1','分期',10,'缴费情况'),('pay_type','2','贷款',10,'缴费情况'),('pay_type','3','已缴清',10,'缴费情况'),('isdebt','0','否',80,'是否欠费-否'),('isdebt','1','是',50,'是否欠费-是'),('school_area','1','林科大校区',80,'校区'),('school_area','2','五一校区',50,'校区'),('school_area','3','涉外校区',10,'校区'),('education','1','小学',10,'文化程度'),('education','2','初中',20,'文化程度'),('education','3','高中',40,'文化程度'),('education','4','大专',80,'文化程度'),('education','5','本科',90,'文化程度'),('education','6','硕士研究生',60,'文化程度'),('education','7','博士',50,'文化程度'),('doc_publish_type','1','外部URL',10,'发布类型'),('doc_publish_type','2','正文',50,'发布类型'),('doc_top','0','不置顶',50,'文章类型不置顶'),('doc_top','1','置顶',10,'文章类型置顶'),('doc_highlight','0','否',10,'文章不设置加精'),('doc_highlight','1','是',40,'文章不设置加精'),('doc_state','1','已提交',10,'文档的状态'),('doc_state','2','已发布',30,'文档的状态'),('doc_state','3','未发布',70,'文档的状态'),('comm_tag','0','已开启',70,'评论开启'),('comm_tag','1','已关闭',70,'评论关闭'),('flow_state','1','待审核',10,'流程状态'),('flow_state','2','已审核',30,'流程状态'),('flow_state','3','已驳回',70,'流程状态'),('role_const','ROLE_001','超级管理员',70,'超级管理员'),('role_const','ROLE_002','管理员',70,'管理员'),('role_const','ROLE_003','教师',70,'教师'),('role_const','ROLE_004','学生',70,'学生'),('role_const','ROLE_005','游客',70,'游客');

/*Table structure for table `t_doctype` */

DROP TABLE IF EXISTS `t_doctype`;

CREATE TABLE `t_doctype` (
  `TYPEID` int(11) NOT NULL COMMENT '分类编号',
  `TYPENAME` varchar(150) COLLATE utf8_bin DEFAULT NULL COMMENT '分类名称',
  `CRTIME` datetime DEFAULT NULL COMMENT '创建时间',
  `SORTNUM` int(11) DEFAULT NULL COMMENT '排序号',
  PRIMARY KEY (`TYPEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='文档分类';

/*Data for the table `t_doctype` */

/*Table structure for table `t_document` */

DROP TABLE IF EXISTS `t_document`;

CREATE TABLE `t_document` (
  `DOCID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文档编号',
  `DOCCHANNEL` bigint(20) DEFAULT NULL COMMENT '所属栏目',
  `DOCTITLE` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '文档标题',
  `DOCSUBTITLE` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '文档副标题',
  `DOCABSTRACT` varchar(2000) COLLATE utf8_bin DEFAULT NULL COMMENT '内容摘要',
  `DOCIMAGE` varchar(250) COLLATE utf8_bin DEFAULT NULL COMMENT '微缩图片',
  `ISTOP` int(11) DEFAULT NULL COMMENT '是否置顶',
  `ISHIGHLIGHT` int(11) DEFAULT NULL COMMENT '是否加精',
  `DOCAUTHOR` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '作者',
  `DOCVALID` datetime DEFAULT NULL COMMENT '生效时间',
  `DOCUNVALID` datetime DEFAULT NULL COMMENT '失效时间',
  `DOCSOURCE` varchar(250) COLLATE utf8_bin DEFAULT NULL COMMENT '文档来源',
  `URL` varchar(2000) COLLATE utf8_bin DEFAULT NULL COMMENT '外部链接地址',
  `DOCHTMLCON` text COLLATE utf8_bin COMMENT '文章内容',
  `DOCRELTIME` datetime DEFAULT NULL COMMENT '撰写时间',
  `USERID` int(11) DEFAULT NULL COMMENT '文档创建人',
  `DOCSTATUS` int(11) DEFAULT NULL COMMENT '文档状态',
  `ISDELETE` int(11) DEFAULT '0' COMMENT '是否已删除',
  `TYPEID` int(11) DEFAULT NULL COMMENT '发布类型ID',
  PRIMARY KEY (`DOCID`),
  KEY `FK_Reference_5` (`USERID`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`USERID`) REFERENCES `t_user` (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='文档信息表';

/*Data for the table `t_document` */

/*Table structure for table `t_document_type_rel` */

DROP TABLE IF EXISTS `t_document_type_rel`;

CREATE TABLE `t_document_type_rel` (
  `DOCID` bigint(20) DEFAULT NULL COMMENT '文档编号',
  `TYPEID` int(11) DEFAULT NULL COMMENT '类型编号',
  KEY `FK_Reference_15` (`TYPEID`),
  KEY `FK_Reference_16` (`DOCID`),
  CONSTRAINT `FK_Reference_15` FOREIGN KEY (`TYPEID`) REFERENCES `t_doctype` (`TYPEID`),
  CONSTRAINT `FK_Reference_16` FOREIGN KEY (`DOCID`) REFERENCES `t_document` (`DOCID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='文档与文档分类关系表';

/*Data for the table `t_document_type_rel` */

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `ROLEID` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `ROLENAME` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '角色名称',
  `ROLECODE` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '角色编码',
  `ROLEDESC` varchar(250) COLLATE utf8_bin DEFAULT NULL COMMENT '角色描述',
  `CRTIME` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ROLEID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色表';

/*Data for the table `t_role` */

insert  into `t_role`(`ROLEID`,`ROLENAME`,`ROLECODE`,`ROLEDESC`,`CRTIME`) values (6,'超级管理员','ROLE_001','该角色可以维护管理员、维护频道、审核内容','2019-03-15 22:34:01'),(7,'管理员','ROLE_002','该角色维护班级、教师','2019-03-15 22:34:01'),(8,'教师','ROLE_003','该角色导入学生、发布内容（文章、视频）','2019-03-15 22:34:01'),(9,'学生','ROLE_004','该角色可以阅读文章、发表评论、提问','2019-03-15 22:34:01'),(10,'游客','ROLE_005','该角色可以阅读文章、发表评论、提问','2019-03-15 22:34:01');

/*Table structure for table `t_roleuser` */

DROP TABLE IF EXISTS `t_roleuser`;

CREATE TABLE `t_roleuser` (
  `USERID` int(11) DEFAULT NULL COMMENT '用户ID',
  `ROLEID` int(11) DEFAULT NULL COMMENT '角色ID',
  `CRTIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CUSERID` int(11) DEFAULT NULL COMMENT '创建用户',
  KEY `FK_Reference_1` (`USERID`),
  KEY `FK_Reference_2` (`ROLEID`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`USERID`) REFERENCES `t_user` (`USERID`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`ROLEID`) REFERENCES `t_role` (`ROLEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户角色关系表';

/*Data for the table `t_roleuser` */

/*Table structure for table `t_student` */

DROP TABLE IF EXISTS `t_student`;

CREATE TABLE `t_student` (
  `STUID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `STUCODE` varchar(15) COLLATE utf8_bin DEFAULT NULL COMMENT '学号',
  `PASSWORD` varchar(20) COLLATE utf8_bin DEFAULT '88888888' COMMENT '密码',
  `NAME` varchar(250) COLLATE utf8_bin DEFAULT NULL COMMENT '学生姓名',
  `PINYING` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '姓名拼音',
  `SEX` int(11) DEFAULT NULL COMMENT '性别',
  `CLASSID` int(11) DEFAULT NULL COMMENT '班级',
  `SPECIALTY` int(11) DEFAULT NULL COMMENT '专业方向',
  `SCHOOLAREA` int(11) DEFAULT NULL COMMENT '校区',
  `NATION` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '民族',
  `IDCARD` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '身份证号码',
  `EDU` int(11) DEFAULT NULL COMMENT '文化程度',
  `ENDSCHOOL` varchar(150) COLLATE utf8_bin DEFAULT NULL COMMENT '毕业学校',
  `CONTACT` varchar(250) COLLATE utf8_bin DEFAULT NULL COMMENT '本人联系方式',
  `HOMECONTACT` varchar(250) COLLATE utf8_bin DEFAULT NULL COMMENT '家庭联系方式',
  `HOMEADDRESS` varchar(250) COLLATE utf8_bin DEFAULT NULL COMMENT '家庭住址',
  `POSTCODE` varchar(15) COLLATE utf8_bin DEFAULT NULL COMMENT '邮编',
  `QQ` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT 'QQ',
  `ISDEBT` int(11) DEFAULT NULL COMMENT '是否欠费',
  `JOBCITY` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '就业城市',
  `JOBCOMPANY` varchar(250) COLLATE utf8_bin DEFAULT NULL COMMENT '就业企业',
  `JOBSAL` decimal(10,0) DEFAULT NULL COMMENT '就业薪资',
  `JOB` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '就业岗位',
  `REMARK` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `ISDELETE` int(11) DEFAULT NULL COMMENT '是否已删除',
  PRIMARY KEY (`STUID`),
  KEY `FK_Reference_8` (`CLASSID`),
  KEY `SPECID` (`SPECIALTY`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`CLASSID`) REFERENCES `t_class` (`CLASSID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='学生信息表';

/*Data for the table `t_student` */

insert  into `t_student`(`STUID`,`STUCODE`,`PASSWORD`,`NAME`,`PINYING`,`SEX`,`CLASSID`,`SPECIALTY`,`SCHOOLAREA`,`NATION`,`IDCARD`,`EDU`,`ENDSCHOOL`,`CONTACT`,`HOMECONTACT`,`HOMEADDRESS`,`POSTCODE`,`QQ`,`ISDEBT`,`JOBCITY`,`JOBCOMPANY`,`JOBSAL`,`JOB`,`REMARK`,`ISDELETE`) values (1,'1001','88888888','孙悟空','sunwukong',1,1,1,1,'汉族','4310255422478965442',2,'湖南信息学院','1734084524888','13685462478','长沙','47852','25646545645',0,'上海','华坤',10000,'java工程师',NULL,0),(2,'1002','88888888','猪八戒','zhubajie',1,1,1,1,'汉族','4310255425558965442',2,'湖南信息学院','1734084524822','13685464478','上海','85423','4686864654',0,'上海','华为',20000,'架构师',NULL,0),(3,'1003','88888888','唐僧','tangsheng',1,1,1,1,'汉族','4310255422888965442',2,'清华','1734084527788','13685462478','北京','46456','52366545645',0,'北京','阿里',30000,'工程师',NULL,0),(4,'1004','88888888','沙悟净','shawujing',1,1,1,1,'汉族','4310255422888965442',2,'湖南大学','13685462478','13685462478','北京','4654','646804646',0,'北京','阿里云',2000,NULL,NULL,NULL);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `USERID` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `USERNAME` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '用户登录名',
  `REALNAME` varchar(250) COLLATE utf8_bin DEFAULT NULL COMMENT '用户真实姓名',
  `NICKNAME` varchar(250) COLLATE utf8_bin DEFAULT NULL COMMENT '昵称',
  `PASSWORD` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `CRTIME` datetime DEFAULT NULL COMMENT '创建时间',
  `ISDELETE` int(11) DEFAULT NULL COMMENT '是否已删除',
  `SEX` int(11) DEFAULT NULL COMMENT '性别0为男 1为女',
  `PHONE` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '联系电话',
  `EMAIL` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `ROLEID` int(11) DEFAULT NULL COMMENT '角色id',
  `DEPT` int(11) DEFAULT NULL COMMENT '所属部门',
  PRIMARY KEY (`USERID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='后台用户信息表';

/*Data for the table `t_user` */

insert  into `t_user`(`USERID`,`USERNAME`,`REALNAME`,`NICKNAME`,`PASSWORD`,`CRTIME`,`ISDELETE`,`SEX`,`PHONE`,`EMAIL`,`ROLEID`,`DEPT`) values (2,'root','超级用户','超级用户','88888888','2019-03-15 22:34:01',0,1,'15423647','root@qq.com',7,0),(3,'yonghong','yonghong','yonghong','88888888','2019-03-15 22:35:59',0,0,'15236478','yonghong@qq.com',8,2),(4,'zhang','zhang','zhang','88888888','2019-03-16 10:48:14',0,0,'3445454','zhang@qq.com',8,3),(5,'lisa','lisa','lisa','333333','2019-03-16 10:48:42',0,0,'165465','xin@qq.com',8,4),(6,'yang','yang','yang ','3333','2019-03-16 10:49:39',0,0,'48646','yang@qq.com',8,4);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
