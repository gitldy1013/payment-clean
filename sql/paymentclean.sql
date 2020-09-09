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
   risk_merchant_risk_sync_info_id    int(64) not null auto_increment comment 'id序号',
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
   operate_time         date comment '操作时间',
   primary key (risk_merchant_risk_sync_info_id)
)comment = '风控商户风险信息同步表 ';



drop table if exists risk_person_risk_sync_info;

create table risk_person_risk_sync_info
(
   risk_person_risk_sync_info_id    int(64) not null auto_increment comment 'id序号',
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
   operate_time         date comment '操作时间',
   primary key (risk_person_risk_sync_info_id)
)comment = '风控个人风险信息同步表 ';

drop table if exists risk_enterprise_risk_sync_info;

create table risk_enterprise_risk_sync_info
(
   risk_enterprise_risk_sync_info    int(64) not null auto_increment comment 'id序号',
   risk_type            varchar(2) comment '风险类型',
   payAccountNo         varchar(30) comment '单位支付账户编号',
   occurtimeb           date comment '风险事件发生时间',
   occurtimee           date comment '风险事件结束时间',
   note                 varchar(2048) comment '风险事件描述',
   source_channel       varchar(4) comment '风险信息来源',
   valid_date           date comment '有效期',
   operator             varchar(10) comment '操作人',
   operate_time         date comment '操作时间',
   primary key (risk_enterprise_risk_sync_info)
)comment = '风控企业风险信息同步表 ';


drop table if exists pcac_merchant_risk_submit_info;

/*==============================================================*/
/* Table: pcac_merchant_risk_submit_info                        */
/*==============================================================*/
create table pcac_merchant_risk_submit_info
(
   pcac_merchant_risk_submit_info_id int(64) not null auto_increment comment 'id序号',
   cus_type             varchar(2) comment '商户类型',
   cus_property         varchar(2) comment '客户属性',
   risk_type            varchar(2) comment '风险类型',
   cus_nature           varchar(2) comment '商户属性',
   cus_name             varchar(128) comment '商户简称',
   reg_name             varchar(128) comment '商户名称/企业名称',
   cus_code             varchar(32) comment '商户代码，最长不能超过 32 个字符',
   doc_type             varchar(2) comment '法人证件类型',
   doc_code             varchar(64) comment '法人证件号码',
   leg_rep_name         varchar(64) comment '法定代表人姓名',
   leg_doc_type         varchar(2) comment '法定代表人（负责人） 证件类型',
   leg_doc_code         varchar(64) comment '法定代表人（负责人）证件号码',
   is_transfer          varchar(2) comment '中转或收款 0 收款 1 中转',
   bank_no              varchar(64) comment '银行结算账号',
   open_bank            varchar(64) comment '开户行（支付账户开立机构）',
   server_ip            varchar(512) comment '服务器 IP',
   mobile_no            varchar(20) comment '法定代表人（负责人） 手机号',
   address              varchar(256) comment '商户实际办公地',
   icp                  varchar(20) comment 'ICP 备案编号',
   level                varchar(2) comment '风险信息等级',
   occurtimeb           date comment '风险事件发生时间',
   occurtimee           date comment '风险事件结束时间',
   occurchan            varchar(2) comment '风险事件发生渠道',
   occurarea            varchar(256) comment '风险事件发生地域',
   note                 varchar(2048) comment '风险事件描述',
   valid_date           date comment '有效期',
   org_id               varchar(32) comment '上报机构',
   rep_date             date comment '上报日期',
   rep_type             varchar(2) comment '上传方式（值： 03）',
   rep_person           varchar(32) comment '上传人',
   registered_area      varchar(2) comment '商户注册国家或地区',
   registered_code      varchar(256) comment '商户注册号码',
   source_channel       varchar(4) comment '风险信息来源',
   currency             varchar(3) comment '交易币种',
   amount               varchar(11) comment '交易金额',
   risk_find_time       date comment '风险事件发现时间',
   leg_control_name     varchar(64) comment '实控人姓名',
   leg_control_card_type varchar(2) comment '实控人证件类型',
   leg_control_card_code varchar(64) comment '实控人证件号',
   remarks              varchar(2048) comment '备注',
   leg_ben_name         varchar(64) comment '受益人姓名',
   leg_ben_card_type    varchar(2) comment '受益人证件类型',
   leg_ben_card_code    varchar(64) comment '受益人证件号',
   operator             varchar(10) comment '操作人',
   operate_time         date comment '操作时间',
   submit_time          date comment '上报时间',
   submit_status        varchar(2) default '0' comment '报送状态',
   result_status        varchar(2) comment '交易结果',
   result_code          varchar(6) comment '交易返回码',
   msg_detail           varchar(256) default '未上报' comment '错误详情',
   primary key (pcac_merchant_risk_submit_info_id)
);



drop table if exists pcac_person_risk_submit_info;

/*==============================================================*/
/* Table: pcac_person_risk_submit_info                          */
/*==============================================================*/
create table pcac_person_risk_submit_info
(
   pcac_person_risk_submit_info_id int(64) not null comment 'id序号',
   cus_property         varchar(2) comment '客户属性',
   risk_type            varchar(2) comment '风险类型',
   mobile_no            varchar(20) comment '手机号',
   mac                  varchar(17) comment 'MAC 地址',
   imei                 varchar(32) comment 'Imei（Imei 必须为小于或等于 32 位数
            字组成）',
   bank_no              varchar(64) comment '付款账户/付款银行卡号（支付账户）',
   open_bank            varchar(64) comment '开户机构',
   cus_name             varchar(64) comment '个人姓名',
   doc_type             varchar(2) comment '证件类型',
   doc_code             varchar(64) comment '证件号码',
   ip                   varchar(512) comment 'IP 地址',
   address              varchar(128) comment '收货地址',
   telephone            varchar(13) comment '固定电话',
   is_transfer          varchar(2) comment '中转或收款 0 收款 1 中转',
   rec_name             varchar(128) comment '中转或收款人姓名',
   rec_doc_type         varchar(2) comment '中转或收款人证件类型',
   rec_doc_code         varchar(64) comment '中转或收款人证件号',
   rec_bank_no          varchar(64) comment '中转或收款银行卡号（支付账户） ， 不
            校验格式',
   rec_open_bank        varchar(64) comment '中转或收款开户机构',
   rec_host_area        varchar(2) comment '收款人所在国家或地区',
   email                varchar(64) comment '邮箱',
   valid_date           date comment '有效期',
   occurtimeb           date comment '风险事件发生时间',
   occurtimee           date comment '风险事件结束时间',
   occurchan            varchar(2) comment '风险事件发生渠道',
   occurarea            varchar(256) comment '风险事件发生地域',
   note                 varchar(2048) comment '风险事件描述',
   org_id               varchar(32) comment '上报机构',
   rep_date             date comment '上报日期',
   rep_type             varchar(2) comment '上传方式（值： 03）',
   rep_person           varchar(32) comment '上传人',
   source_channel       varchar(4) comment '风险信息来源',
   disk_number          varchar(128) comment '硬盘序列号',
   currency             varchar(3) comment '交易币种',
   amount               varchar(11) comment '交易金额',
   risk_find_time       date comment '风险事件发现时间',
   usrNo                varchar(20) comment '内部用户号',
   operator             varchar(10) comment '操作人',
   operate_time         date comment '操作时间',
   submit_time          date comment '上报时间',
   submit_status        varchar(2) default '0' comment '报送状态',
   result_status        varchar(2) comment '交易结果',
   result_code          varchar(6) comment '交易返回码',
   msg_detail           varchar(256) default '未上报' comment '错误详情',
   primary key (pcac_person_risk_submit_info_id)
);



drop table if exists pcac_enterprise_risk_submit_info;

/*==============================================================*/
/* Table: pcac_enterprise_risk_submit_info                      */
/*==============================================================*/
create table pcac_enterprise_risk_submit_info
(
   pcac_enterprise_risk_submit_info_id int(64) not null auto_increment comment 'id序号',
   cus_property         varchar(2) comment '客户属性',
   risk_type            varchar(2) comment '风险类型',
   cus_name             varchar(128) comment '企业简称',
   doc_type             varchar(2) comment '法人证件类型',
   doc_code             varchar(64) comment '法人证件号码',
   leg_rep_name         varchar(64) comment '法定代表人姓名',
   tax_regcer           varchar(20) comment '税务登记证（必须为 15 或 20 位数字组
            税务登记证（必须为 15 或 20 位数字组成）',
   leg_doc_type         varchar(2) comment '法定代表人（负责人） 证件类型',
   leg_doc_code         varchar(64) comment '法定代表人（负责人）证件号码',
   leg_control_card_type varchar(2) comment '实控人证件类型',
   leg_control_card_code varchar(64) comment '实控人证件号',
   remarks              varchar(2048) comment '备注',
   reg_address          varchar(256) comment '企业注册地址',
   address              varchar(256) comment '商户实际办公地',
   tele_phone           varchar(12) comment '固定电话',
   business_scope       varchar(256) comment '企业经营范围',
   leg_control_name     varchar(64) comment '实控人姓名',
   occurtimee           date comment '风险事件结束时间',
   source_channel       varchar(4) comment '风险信息来源',
   risk_find_time       date comment '风险事件发现时间',
   valid_date           date comment '有效期',
   occurarea            varchar(256) comment '风险事件发生地域',
   reg_name             varchar(128) comment '企业名称',
   cus_code             varchar(32) comment '机构代码，最长不能超过 32 个字符',
   bank_no              varchar(64) comment '银行结算账号',
   mobile_no            varchar(20) comment '法定代表人（负责人） 手机号',
   note                 varchar(2048) comment '风险事件描述',
   occurtimeb           date comment '风险事件发生时间',
   org_id               varchar(32) comment '上报机构',
   rep_date             date comment '上报日期',
   rep_type             varchar(2) comment '上传方式（值： 03）',
   rep_person           varchar(32) comment '上传人',
   operator             varchar(10) comment '操作人',
   operate_time         date comment '操作时间',
   submit_time          date comment '上报时间',
   submit_status        varchar(2) default '0' comment '报送状态',
   result_status        varchar(0) comment '交易结果',
   result_code          varchar(0) comment '交易返回码',
   msg_detail           varchar(256) default '未上报' comment '错误详情',
   primary key (pcac_enterprise_risk_submit_info_id)
);








