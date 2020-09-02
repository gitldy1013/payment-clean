drop table if exists pcac_risk_info;

/*==============================================================*/
/* Table: pcac_risk_info   黑名单提示信息表                                     */
/*==============================================================*/
create table pcac_risk_info
(
   id                   long not null comment 'id序号',
   up_date              varchar(10) comment '推送日期',
   reg_name             varbinary(128) comment '商户名称',
   cus_name             varchar(128) comment '商户简称',
   doc_type             varchar(2) comment '法人证件类型',
   doc_code             varchar(64) comment '法人证件号码',
   leg_doc_name         varchar(64) comment '法定代表人姓名',
   leg_doc_type         varchar(2) comment '法定代表人姓名',
   leg_doc_code         varchar(64) comment '法定代表人（负责人） 证件号码',
   level                varchar(2) comment '风险信息等级',
   risk_type            varchar(2) comment '风险类型',
   valid_date           varchar(10) comment '有效期',
   valid_status         varchar(2) comment '有效性',
   cus_type             varchar(2) comment '商户类型',
   occurarea            varchar(256) comment '风险事件发生地域，省级/地市，可多选，逗号隔开',
   bank_no              varchar(128) comment '银行结算账户',
   url                  varchar(512) comment '网址',
   registered_code      varchar(256) comment '商户注册号',
   primary key (id)
);