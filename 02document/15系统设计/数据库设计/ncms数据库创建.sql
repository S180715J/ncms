drop table if exists T_CHANGECLASS;

drop table if exists T_CHANNEL;

drop table if exists T_CHANNEL_INFO;

drop table if exists T_CLASS;

drop table if exists T_CLASS_USER_REL;

drop table if exists T_COMMENT;

drop table if exists T_COMMENT_TAG;

drop table if exists T_DICT;

drop table if exists T_DOCTYPE;

drop table if exists T_DOCUMENT;

drop table if exists T_DOCUMENT_TYPE_REL;

drop table if exists T_ROLE;

drop table if exists T_ROLEUSER;

drop table if exists T_STUDENT;

drop table if exists T_USER;


/*==============================================================*/
/* Table: T_CHANGECLASS                                         */
/*==============================================================*/
create table T_CHANGECLASS
(
   ID                   bigint not null auto_increment,
   STUID                bigint,
   CLASSID              int,
   STUCODE              varchar(20),
   OLDCLASSID           int,
   OLDSTUCODE           varchar(20),
   CHANGEDATE           datetime,
   OPTDATE              datetime,
   primary key (ID)
);

/*==============================================================*/
/* Table: T_CHANNEL                                             */
/*==============================================================*/
create table T_CHANNEL
(
   CHANNELID            int not null auto_increment,
   CHNLNAME             varchar(200),
   CHNLDESC             varchar(200),
   CHNLNAMEPATH         varchar(2000),
   PARENTID             int,
   CHNLORDER            int,
   CRTIME               datetime,
   primary key (CHANNELID)
);

/*==============================================================*/
/* Table: T_CHANNEL_INFO                                        */
/*==============================================================*/
create table T_CHANNEL_INFO
(
   CHANNELID            bigint,
   DOCID                int
);

/*==============================================================*/
/* Table: T_CLASS                                               */
/*==============================================================*/
create table T_CLASS
(
   CLASSID              int not null auto_increment,
   CODE                 varchar(100),
   SCHOOLAREA           int,
   SPECIALTY            int,
   BEGINDATE            datetime,
   ENDDATE              datetime,
   INITCOUNT            int,
   ONLINECOUNT          int,
   STATUS               int,
   ENDCOUNT             int,
   EXAMCOUNT            int,
   PASSCOUNT            varchar(100),
   JOBCOUNT             int,
   PRAISECOUNT          int,
   MISSCOUNT            int,
   ISDELETE             int,
   primary key (CLASSID)
);

/*==============================================================*/
/* Table: T_CLASS_USER_REL                                      */
/*==============================================================*/
create table T_CLASS_USER_REL
(
   CLASSID              int,
   USERID               int
);

/*==============================================================*/
/* Table: T_COMMENT                                             */
/*==============================================================*/
create table T_COMMENT
(
   COMMENTID            BIGINT not null auto_increment,
   COMMENTCONTENT       varchar(1000),
   PARENTID             BIGINT,
   CRTIME               datetime,
   USERID               INT,
   SUBJECTID            bigint,
   ISNEWQUEST           varchar(2),
   primary key (COMMENTID)
);

/*==============================================================*/
/* Table: T_COMMENT_TAG                                         */
/*==============================================================*/
create table T_COMMENT_TAG
(
   TAG                  int,
   INTRO                varchar(100),
   OPTIME               datetime
);


/*==============================================================*/
/* Table: T_DICT                                                */
/*==============================================================*/
create table T_DICT
(
   DICTTYPE             varchar(50),
   DICTID               varchar(50),
   DICNAME              varchar(100),
   SORTNO               int,
   REMARK               varchar(250)
);

/*==============================================================*/
/* Table: T_DOCTYPE                                             */
/*==============================================================*/
create table T_DOCTYPE
(
   TYPEID               int not null,
   TYPENAME             varchar(150),
   CRTIME               datetime,
   SORTNUM              int,
   primary key (TYPEID)
);

/*==============================================================*/
/* Table: T_DOCUMENT                                            */
/*==============================================================*/
create table T_DOCUMENT
(
   DOCID                bigint not null auto_increment,
   DOCCHANNEL           bigint,
   DOCTITLE             varchar(1000),
   DOCSUBTITLE          varchar(1000),
   DOCABSTRACT          varchar(2000),
   DOCIMAGE             varchar(250),
   PUBTYPE              int,
   ISTOP                int comment '1÷√∂• 0ªÚ≤ªÃÓ≤ª÷√∂•',
   ISHIGHLIGHT          int,
   DOCAUTHOR            varchar(200),
   DOCVALID             datetime,
   DOCUNVALID           datetime,
   DOCSOURCE            varchar(250),
   URL                  varchar(2000),
   DOCHTMLCON           text,
   DOCRELTIME           datetime,
   USERID               int,
   DOCSTATUS            int,
   ISDELETE             int DEFAULT '0',
   primary key (DOCID)
);

/*==============================================================*/
/* Table: T_DOCUMENT_TYPE_REL                                   */
/*==============================================================*/
create table T_DOCUMENT_TYPE_REL
(
   DOCID                bigint,
   TYPEID               int
);

/*==============================================================*/
/* Table: T_ROLE                                                */
/*==============================================================*/
create table T_ROLE
(
   ROLEID               INT not null auto_increment,
   ROLENAME             varchar(50),
   ROLECODE             varchar(20),
   ROLEDESC             varchar(250),
   CRTIME               datetime,
   primary key (ROLEID)
);

/*==============================================================*/
/* Table: T_ROLEUSER                                            */
/*==============================================================*/
create table T_ROLEUSER
(
   USERID               INT,
   ROLEID               INT,
   CRTIME               datetime,
   CUSERID              INT
);

/*==============================================================*/
/* Table: T_STUDENT                                             */
/*==============================================================*/
create table T_STUDENT
(
   STUID                bigint not null auto_increment,
   STUCODE              varchar(15),
   PASSWORD             varchar(20) default '88888888',
   NAME                 varchar(250),
   PINYING              varchar(100),
   SEX                  int,
   CLASSID              int,
   SPECIALTY            int,
   SCHOOLAREA           int,
   NATION               varchar(50),
   IDCARD               varchar(20),
   EDU                  int,
   ENDSCHOOL            varchar(150),
   CONTACT              varchar(250),
   HOMECONTACT          varchar(250),
   HOMEADDRESS          varchar(250),
   POSTCODE             varchar(15),
   QQ                   varchar(20),
   ISDEBT               int,
   JOBCITY              varchar(100),
   JOBCOMPANY           varchar(250),
   JOBSAL               decimal,
   JOB                  varchar(100),
   REMARK               varchar(500),
   ISDELETE             int,
   OPTTIME              datetime default CURRENT_TIMESTAMP,
   primary key (STUID)
);

/*==============================================================*/
/* Table: T_USER                                                */
/*==============================================================*/
create table T_USER
(
   USERID               int not null auto_increment,
   USERNAME             varchar(50),
   REALNAME             varchar(250),
   NICKNAME             varchar(250),
   PASSWORD             varchar(50),
   CRTIME               datetime,
   ISDELETE             INT,
   primary key (USERID)
);