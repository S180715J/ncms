-- 1、角色表 T_ROLE
INSERT INTO T_ROLE(ROLENAME,ROLECODE,ROLEDESC,CRTIME)values('超级管理员','ROLE_001','该角色可以维护管理员、维护频道、审核内容',NOW());
INSERT INTO T_ROLE(ROLENAME,ROLECODE,ROLEDESC,CRTIME)values('管理员','ROLE_002','该角色维护班级、教师',NOW());
INSERT INTO T_ROLE(ROLENAME,ROLECODE,ROLEDESC,CRTIME)values('教师','ROLE_003','该角色导入学生、发布内容（文章、视频）',NOW());
INSERT INTO T_ROLE(ROLENAME,ROLECODE,ROLEDESC,CRTIME)values('学生','ROLE_004','该角色可以阅读文章、发表评论、提问',NOW());
INSERT INTO T_ROLE(ROLENAME,ROLECODE,ROLEDESC,CRTIME)values('游客','ROLE_005','该角色可以阅读文章、发表评论、提问',NOW());

-- 2、超级管理员  T_ROLE、T_ROLEUSER、T_USER
INSERT INTO T_USER(USERNAME,REALNAME,NICKNAME,PASSWORD,CRTIME,ISDELETE)VALUES('root','超级用户','超级用户','88888888',NOW(),0);
-- 设置超级管理员角色
INSERT INTO T_ROLEUSER (USERID,ROLEID,CRTIME,CUSERID)SELECT MIN(USERID) USERID, MIN(ROLEID),NOW(),0 FROM  T_USER,T_ROLE;

-- 3、是否关闭评论标识表
INSERT INTO T_COMMENT_TAG(TAG,INTRO,OPTIME) VALUES(1,'是否关闭评论标识，0开启评论功能，1关闭评论',NOW());

-- 4、数据字典
  -- 班级状态： 在读、结课
  -- 是否已删除： 是  否
  -- 性别：男、女
  -- 专业方向：Java、嵌入式、安卓、测试、前端
  -- 缴费情况：分期、贷款、已缴清   （待确认）
  -- 校区：林科大校区、五一校区、涉外校区
  -- 文化程度：小学、初中、高中、大专、本科、硕士研究生、博士
  
  -- 文档有关：
  -- 发布类型：外部URL、正文
  -- 是否置顶：是、否
  -- 是否加精：是、否
  -- 文档状态：已提交、已发布、未发布
  
  -- 流程有关：
  -- 流程状态：待审核  已审核  已驳回
  
  -- 角色常量：
  -- 超级管理员 管理员 教师 学生 教师
 


  
  
-- 是否已删除： 否、是
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('isdelete','0','否',10,'是否已删除-否');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('isdelete','1','是',10,'是否已删除-是');  

-- 性别：男、女
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('sex','1','男',50,'男');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('sex','2','女',10,'女');

-- 班级状态： 在读、结课
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('class_status','1','在读',50,'班级状态-在读');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('class_status','2','结课',10,'班级状态-结课');
-- 专业方向：Java、嵌入式、安卓、测试、前端
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('specialty','1','Java',80,'专业方向');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('specialty','2','嵌入式',60,'专业方向');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('specialty','3','安卓',40,'专业方向');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('specialty','4','测试',20,'专业方向');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('specialty','5','Web前端',10,'专业方向');

-- 缴费情况:分期、贷款、已缴清
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('pay_type','1','分期',10,'缴费情况');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('pay_type','2','贷款',10,'缴费情况');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('pay_type','3','已缴清',10,'缴费情况');

-- 是否欠费：是、否
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('isdebt','0','否',80,'是否欠费-否');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('isdebt','1','是',50,'是否欠费-是');



-- 校区：林科大校区、五一校区、涉外校区
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('school_area','1','林科大校区',80,'校区');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('school_area','2','五一校区',50,'校区');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('school_area','3','涉外校区',10,'校区');

-- 文化程度：小学、初中、高中、大专、本科、硕士研究生、博士
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('education','1','小学',10,'文化程度');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('education','2','初中',20,'文化程度');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('education','3','高中',40,'文化程度');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('education','4','大专',80,'文化程度');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('education','5','本科',90,'文化程度');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('education','6','硕士研究生',60,'文化程度');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('education','7','博士',50,'文化程度');


-- 文档发布类型：外部URL、正文
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('doc_publish_type','1','外部URL',10,'发布类型');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('doc_publish_type','2','正文',50,'发布类型');

-- 文档是否置顶：是、否
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('doc_top','0','不置顶',50,'文章类型不置顶');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('doc_top','1','置顶',10,'文章类型置顶');

-- 文档是否加精：是、否
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('doc_highlight','0','否',10,'文章不设置加精');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('doc_highlight','1','是',40,'文章不设置加精');

-- 文档状态：已提交、已发布、未发布
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('doc_state','1','已提交',10,'文档的状态');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('doc_state','2','已发布',30,'文档的状态');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('doc_state','3','未发布',70,'文档的状态');

-- 评论功能开启、关闭
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('comm_tag','0','已开启',70,'评论开启');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('comm_tag','1','已关闭',70,'评论关闭');

-- 流程状态
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('flow_state','1','待审核',10,'流程状态');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('flow_state','2','已审核',30,'流程状态');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('flow_state','3','已驳回',70,'流程状态');

-- 角色常量
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('role_const','ROLE_001','超级管理员',70,'超级管理员');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('role_const','ROLE_002','管理员',70,'管理员');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('role_const','ROLE_003','教师',70,'教师');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('role_const','ROLE_004','学生',70,'学生');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('role_const','ROLE_005','游客',70,'游客');
