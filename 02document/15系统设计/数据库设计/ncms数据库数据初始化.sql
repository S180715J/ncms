-- 1����ɫ�� T_ROLE
INSERT INTO T_ROLE(ROLENAME,ROLECODE,ROLEDESC,CRTIME)values('��������Ա','ROLE_001','�ý�ɫ����ά������Ա��ά��Ƶ�����������',NOW());
INSERT INTO T_ROLE(ROLENAME,ROLECODE,ROLEDESC,CRTIME)values('����Ա','ROLE_002','�ý�ɫά���༶����ʦ',NOW());
INSERT INTO T_ROLE(ROLENAME,ROLECODE,ROLEDESC,CRTIME)values('��ʦ','ROLE_003','�ý�ɫ����ѧ�����������ݣ����¡���Ƶ��',NOW());
INSERT INTO T_ROLE(ROLENAME,ROLECODE,ROLEDESC,CRTIME)values('ѧ��','ROLE_004','�ý�ɫ�����Ķ����¡��������ۡ�����',NOW());
INSERT INTO T_ROLE(ROLENAME,ROLECODE,ROLEDESC,CRTIME)values('�ο�','ROLE_005','�ý�ɫ�����Ķ����¡��������ۡ�����',NOW());

-- 2����������Ա  T_ROLE��T_ROLEUSER��T_USER
INSERT INTO T_USER(USERNAME,REALNAME,NICKNAME,PASSWORD,CRTIME,ISDELETE)VALUES('root','�����û�','�����û�','88888888',NOW(),0);
-- ���ó�������Ա��ɫ
INSERT INTO T_ROLEUSER (USERID,ROLEID,CRTIME,CUSERID)SELECT MIN(USERID) USERID, MIN(ROLEID),NOW(),0 FROM  T_USER,T_ROLE;

-- 3���Ƿ�ر����۱�ʶ��
INSERT INTO T_COMMENT_TAG(TAG,INTRO,OPTIME) VALUES(1,'�Ƿ�ر����۱�ʶ��0�������۹��ܣ�1�ر�����',NOW());

-- 4�������ֵ�
  -- �༶״̬�� �ڶ������
  -- �Ƿ���ɾ���� ��  ��
  -- �Ա��С�Ů
  -- רҵ����Java��Ƕ��ʽ����׿�����ԡ�ǰ��
  -- �ɷ���������ڡ�����ѽ���   ����ȷ�ϣ�
  -- У�����ֿƴ�У������һУ��������У��
  -- �Ļ��̶ȣ�Сѧ�����С����С���ר�����ơ�˶ʿ�о�������ʿ
  
  -- �ĵ��йأ�
  -- �������ͣ��ⲿURL������
  -- �Ƿ��ö����ǡ���
  -- �Ƿ�Ӿ����ǡ���
  -- �ĵ�״̬�����ύ���ѷ�����δ����
  
  -- �����йأ�
  -- ����״̬�������  �����  �Ѳ���
  
  -- ��ɫ������
  -- ��������Ա ����Ա ��ʦ ѧ�� ��ʦ
 


  
  
-- �Ƿ���ɾ���� ����
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('isdelete','0','��',10,'�Ƿ���ɾ��-��');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('isdelete','1','��',10,'�Ƿ���ɾ��-��');  

-- �Ա��С�Ů
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('sex','1','��',50,'��');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('sex','2','Ů',10,'Ů');

-- �༶״̬�� �ڶ������
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('class_status','1','�ڶ�',50,'�༶״̬-�ڶ�');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('class_status','2','���',10,'�༶״̬-���');
-- רҵ����Java��Ƕ��ʽ����׿�����ԡ�ǰ��
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('specialty','1','Java',80,'רҵ����');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('specialty','2','Ƕ��ʽ',60,'רҵ����');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('specialty','3','��׿',40,'רҵ����');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('specialty','4','����',20,'רҵ����');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('specialty','5','Webǰ��',10,'רҵ����');

-- �ɷ����:���ڡ�����ѽ���
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('pay_type','1','����',10,'�ɷ����');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('pay_type','2','����',10,'�ɷ����');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('pay_type','3','�ѽ���',10,'�ɷ����');

-- �Ƿ�Ƿ�ѣ��ǡ���
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('isdebt','0','��',80,'�Ƿ�Ƿ��-��');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('isdebt','1','��',50,'�Ƿ�Ƿ��-��');



-- У�����ֿƴ�У������һУ��������У��
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('school_area','1','�ֿƴ�У��',80,'У��');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('school_area','2','��һУ��',50,'У��');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('school_area','3','����У��',10,'У��');

-- �Ļ��̶ȣ�Сѧ�����С����С���ר�����ơ�˶ʿ�о�������ʿ
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('education','1','Сѧ',10,'�Ļ��̶�');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('education','2','����',20,'�Ļ��̶�');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('education','3','����',40,'�Ļ��̶�');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('education','4','��ר',80,'�Ļ��̶�');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('education','5','����',90,'�Ļ��̶�');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('education','6','˶ʿ�о���',60,'�Ļ��̶�');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('education','7','��ʿ',50,'�Ļ��̶�');


-- �ĵ��������ͣ��ⲿURL������
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('doc_publish_type','1','�ⲿURL',10,'��������');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('doc_publish_type','2','����',50,'��������');

-- �ĵ��Ƿ��ö����ǡ���
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('doc_top','0','���ö�',50,'�������Ͳ��ö�');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('doc_top','1','�ö�',10,'���������ö�');

-- �ĵ��Ƿ�Ӿ����ǡ���
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('doc_highlight','0','��',10,'���²����üӾ�');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('doc_highlight','1','��',40,'���²����üӾ�');

-- �ĵ�״̬�����ύ���ѷ�����δ����
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('doc_state','1','���ύ',10,'�ĵ���״̬');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('doc_state','2','�ѷ���',30,'�ĵ���״̬');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('doc_state','3','δ����',70,'�ĵ���״̬');

-- ���۹��ܿ������ر�
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('comm_tag','0','�ѿ���',70,'���ۿ���');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('comm_tag','1','�ѹر�',70,'���۹ر�');

-- ����״̬
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('flow_state','1','�����',10,'����״̬');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('flow_state','2','�����',30,'����״̬');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('flow_state','3','�Ѳ���',70,'����״̬');

-- ��ɫ����
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('role_const','ROLE_001','��������Ա',70,'��������Ա');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('role_const','ROLE_002','����Ա',70,'����Ա');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('role_const','ROLE_003','��ʦ',70,'��ʦ');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('role_const','ROLE_004','ѧ��',70,'ѧ��');
INSERT INTO T_DICT(DICTTYPE,DICTID,DICNAME,SORTNO,REMARK)VALUES('role_const','ROLE_005','�ο�',70,'�ο�');
