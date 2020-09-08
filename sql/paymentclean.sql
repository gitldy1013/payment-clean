CREATE DATABASE if not exists `paymentclean` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

drop table if exists pcac_assistance_info;

create table pcac_assistance_info
(
    pcac_assistance_info_id                   int(64) not null auto_increment comment 'id序号',
    up_date              date comment '推送日期',
    cus_code             varchar(64) comment '商户代码',
    reg_name             varchar(64) comment '商户名称',
    leg_doc_name         varchar(128) comment '法定代表人（负责人）姓名',
    primary key (pcac_assistance_info_id)
) comment '商户信息比对协查信息表';

drop table if exists pcac_opt_log;
create table pcac_opt_log
(
    pcac_opt_log_id            int(64) not null comment 'id序号',
    created_by    varchar(32)    comment '操作人' ,
    opt_content   varchar(128)    comment '操作内容' ,
    created_time  datetime    comment '操作时间' ,
    updated_by    varchar(32)    comment '更新人' ,
    updated_time  datetime    comment '更新时间',
    primary key (pcac_opt_log_id)
) comment = '操作日志表 ';


drop table if exists pcac_risk_info;

create table pcac_risk_info
(
   pcac_risk_info_id    int(64) not null auto_increment comment 'id序号',
   pushListType         varchar(2) comment '推送名单类型,01黑名单，02风险提示信息',
   up_date              varchar(10) comment '推送日期',
   reg_name             varchar(128) comment '商户名称',
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
   primary key (pcac_risk_info_id)
)comment = '清算协会推送黑名单和风险提示信息表 ';


drop table if exists risk_merchant_risk_sync_info;

create table risk_merchant_risk_sync_info
(
   cus_type             varchar(2) comment '商户类型',
   risk_type            varchar(2) comment '风险类型',
   cus_nature           varchar(2) comment '商户属性',
   cus_number           varchar(20) comment '商户编号',
   level                varchar(2) comment '风险信息等级',
   valid_date           date comment '有效期',
   occurtimeb           date comment '风险事件发生时间',
   occurtimee           date comment '风险事件结束时间',
   note                 varchar(2048) comment '风险事件描述',
   source_channel       varchar(4) comment '风险信息来源',
   operator             varchar(10) comment '操作人',
   operate_time         date comment '操作时间'
)comment = '风控商户风险信息同步表 ';



drop table if exists risk_person_risk_sync_info;

create table risk_person_risk_sync_info
(
   risk_type            varchar(2) comment '风险类型',
   usrNo                varchar(20) comment '内部用户号',
   valid_date           date comment '有效期',
   occurtimeb           date comment '风险事件发生时间',
   occurtimee           date comment '风险事件结束时间',
   occurchan            varchar(2) comment '风险事件发生渠道',
   note                 varchar(2048) comment '风险事件描述',
   source_channel       varchar(4) comment '风险信息来源',
   occurarea            varchar(256) comment '风险事件发生地域',
   operator             varchar(10) comment '操作人',
   operate_time         date comment '操作时间'
)comment = '风控个人风险信息同步表 ';

drop table if exists risk_enterprise_risk_sync_info;

create table risk_enterprise_risk_sync_info
(
   risk_type            varchar(2) comment '风险类型',
   payAccountNo         varchar(30) comment '单位支付账户编号',
   occurtimeb           date comment '风险事件发生时间',
   occurtimee           date comment '风险事件结束时间',
   note                 varchar(2048) comment '风险事件描述',
   source_channel       varchar(4) comment '风险信息来源',
   valid_date           date comment '有效期',
   operator             varchar(10) comment '操作人',
   operate_time         date comment '操作时间'
)comment = '风控企业风险信息同步表 ';




