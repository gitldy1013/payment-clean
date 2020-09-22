CREATE DATABASE if not exists `paymentclean` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

drop table if exists pcac_assistance_info;

/*==============================================================*/
/* Table: pcac_assistance_info                                  */
/*==============================================================*/
create table pcac_assistance_info
(
   pcac_assistance_info_id int(63) not null auto_increment comment 'id序号',
   up_date              varchar(10) comment '推送日期',
   cus_code             varchar(64) comment '商户代码',
   reg_name             varchar(128) comment '商户名称',
   leg_doc_name         varchar(64) comment '法定代表人（负责人）姓名',
   dif_cus_code         varchar(64) comment '商户代码',
   dif_reg_name         varchar(128) comment '商户名称',
   dif_leg_doc_name     varchar(64) comment '法定代表人（负责人）姓名',
   primary key (pcac_assistance_info_id)
)comment '商户信息比对协查信息表';

drop table if exists pcac_opt_log;
create table pcac_opt_log
(
    pcac_opt_log_id            int(64) not null comment 'id序号',
    created_by    varchar(32)    comment '操作人' ,
    opt_content   varchar(128)    comment '操作内容' ,
    created_time  Date    comment '操作时间' ,
    updated_by    varchar(32)    comment '更新人' ,
    updated_time  Date    comment '更新时间',
    primary key (pcac_opt_log_id)
) comment = '操作日志表 ';


drop table if exists pcac_risk_info;

/*==============================================================*/
/* Table: pcac_risk_info                                        */
/*==============================================================*/
create table pcac_risk_info
(
   pcac_risk_info_id    int(64) not null auto_increment comment 'id序号',
   push_list_type       varchar(2) comment '推送名单类型,01黑名单，02风险提示信息',
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
   push_status          varchar(2) default '0' comment '推送状态0为未推送，1为已推送',
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
   cus_code           varchar(20) comment '商户编号',
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
   risk_enterprise_risk_sync_info_id    int(64) not null auto_increment comment 'id序号',
   risk_type            varchar(2) comment '风险类型',
   cus_code             varchar(30) comment '机构代码',
   occurtimeb           date comment '风险事件发生时间',
   occurtimee           date comment '风险事件结束时间',
   note                 varchar(2048) comment '风险事件描述',
   source_channel       varchar(4) comment '风险信息来源',
   valid_date           date comment '有效期',
   operator             varchar(10) comment '操作人',
   operate_time         date comment '操作时间',
   primary key (risk_enterprise_risk_sync_info_id)
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
   url                  varchar(512) comment '网址',
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
   submit_status        varchar(2) default '0' comment '报送状态0为未报送，1为已报送',
   result_status        varchar(2) comment '交易结果',
   result_code          varchar(6) comment '交易返回码',
   msg_detail           varchar(256) default '未上报' comment '错误详情',
   primary key (pcac_merchant_risk_submit_info_id)
)comment = '协会商户风险信息上报表 ';



drop table if exists pcac_person_risk_submit_info;

/*==============================================================*/
/* Table: pcac_person_risk_submit_info                          */
/*==============================================================*/
create table pcac_person_risk_submit_info
(
   pcac_person_risk_submit_info_id int(64) not null  auto_increment comment 'id序号',
   cus_property         varchar(2) comment '客户属性',
   risk_type            varchar(2) comment '风险类型',
   mobile_no            varchar(20) comment '手机号',
   mac                  varchar(17) comment 'MAC 地址',
   imei                 varchar(32) comment 'Imei（Imei 必须为小于或等于 32 位数字组成）',
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
   rec_bank_no          varchar(64) comment '中转或收款银行卡号（支付账户） ， 不校验格式',
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
   rep_date             datetime comment '上报日期',
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
   submit_status        varchar(2) default '0' comment '报送状态0为未报送，1为已报送',
   result_status        varchar(2) comment '交易结果',
   result_code          varchar(6) comment '交易返回码',
   msg_detail           varchar(256) default '未上报' comment '错误详情',
   primary key (pcac_person_risk_submit_info_id)
)comment = '协会个人风险信息上报表 ';



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
   tax_regcer           varchar(20) comment '税务登记证（必须为 15 或 20 位数字组税务登记证（必须为 15 或 20 位数字组成）',
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
   rep_date             datetime comment '上报日期',
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
)comment = '协会企业风险信息上报表 ';




drop table if exists local_associated_risk_merchant_info;

/*==============================================================*/
/* Table: local_associated_risk_merchant_info                   */
/*==============================================================*/
create table local_associated_risk_merchant_info
(
   local_associated_risk_merchant_info_id int(64) not null auto_increment comment 'id序号',
   cus_code           varchar(30) comment '商户编号',
   push_list_type       varchar(2) comment '推送名单类型',
   up_date              varchar(10) comment '推送日期',
   level                varchar(2) comment '风险信息等级',
   risk_type            varchar(2) comment '风险类型',
   cus_name             varchar(128) comment '商户简称',
   reg_name             varchar(128) comment '商户名称',
   handle_result        varchar(2) comment '处理结果',
   feedback_status      varchar(2) comment '反馈状态',
   feedback_date        date comment '反馈日期',
   doc_type             varchar(2) comment '法人证件类型',
   doc_code             varchar(64) comment '法人证件号码',
   leg_rep_name         varchar(64) comment '法人（负责人）代表姓名',
   leg_doc_type         varchar(2) comment '法定代表人证件类型',
   leg_doc_code         varchar(64) comment '法定代表人证件号码',
   valid_date           date comment '有效期',
   valid_status         varchar(2) comment '有效性',
   cus_type             varchar(2) comment '商户类型',
   occurarea            varchar(512) comment '风险事件发生地域',
   ass_mer_number       varchar(30) comment '关联商户编号',
   status               varchar(2) comment '商户状态',
   is_black             varchar(2) comment '是否加黑',
   ass_field_cnt        varchar(10) comment '关联字段个数',
   ass_field_name       varchar(20) comment '关联字段名称',
   operator             varchar(10) comment '操作人',
   msg_detail           varchar(256) comment '失败原因',
   amount               varchar(11) comment '涉及结算金额',
   primary key (local_associated_risk_merchant_info_id)
)comment = '本地关联风险商户信息表 ';


drop table if exists query_pcac_merchant_risk_info;

/*==============================================================*/
/* Table: query_pcac_merchant_risk_info                         */
/*==============================================================*/
create table query_pcac_merchant_risk_info
(
   query_pcac_merchant_risk_info_id int(64) not null auto_increment comment '序号id',
   Id                   varchar(64) comment '风险反馈主键编码',
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
   url                  varchar(512) comment '网址',
   server_ip            varchar(512) comment '服务器 IP',
   mobile_no            varchar(20) comment '法定代表人（负责人） 手机号',
   address              varchar(256) comment '商户实际办公地',
   icp                  varchar(20) comment 'ICP 备案编号',
   level                varchar(2) comment '风险信息等级',
   occurtimeb           date comment '风险事件发生时间',
   occurtimee           date comment '风险事件结束时间',
   occurchan            varchar(2) comment '风险事件发生渠道',
   stop_num             varchar(10) comment '终止合作的机构数量',
   refuse_num           varchar(10) comment '拒绝拓展的机构数量',
   use_rise_num         varchar(10) comment '暂停办理资金结算的机构数量',
   frozen_num           varchar(10) comment '冻结账户的机构数量',
   adjustment_cycle_num varchar(10) comment '调整结算周期的机构数量',
   delay_num            varchar(10) comment '延迟资金结算的机构数量',
   quota_num            varchar(10) comment '设置收款限额的机构数量',
   anti_money_num       varchar(10) comment '报送反洗钱可疑交易的机构数量',
   other_num            varchar(10) comment '其他的机构数量',
   risk_find_time       date comment '风险事件发现时间',
   amount               varchar(11) comment '交易金额',
   suspend_num          varchar(10) comment '暂停银行卡交易的机构数量',
   close_num            varchar(10) comment '收回受理终端 (关闭网络支付接口) 的机构数
            收回受理终端 (关闭网络支付接口) 的机构数量',
   follow_num           varchar(10) comment '暂未采取控制措施,持续关注客户的机构数量',
   valid_status         varchar(2) comment '有效性',
   occurarea            varchar(256) comment '风险事件发生地域',
   note                 varchar(2048) comment '风险事件描述',
   valid_date           date comment '有效期',
   registered_area      varchar(2) comment '商户注册国家或地区',
   registered_code      varchar(256) comment '商户注册号码',
   source_channel       varchar(4) comment '风险信息来源',
   currency             varchar(3) comment '交易币种',
   leg_control_name     varchar(64) comment '实控人姓名',
   leg_control_card_type varchar(2) comment '实控人证件类型',
   leg_control_card_code varchar(64) comment '实控人证件号',
   remarks              varchar(2048) comment '备注',
   leg_ben_name         varchar(64) comment '受益人姓名',
   leg_ben_card_type    varchar(2) comment '受益人证件类型',
   leg_ben_card_code    varchar(64) comment '受益人证件号',
   push_status          varchar(2) default '0' comment '推送状态0为未推送，1为已推送',
   result_status        varchar(2) comment '交易结果',
   result_code          varchar(6) comment '交易返回码',
   up_date              varchar(20) comment '推送日期',
   err_info             varchar(128) comment '错误信息',
   operate_time         date comment '操作时间',
   merc_ids         varchar(32) DEFAULT NULL comment '商户编号',
   primary key (query_pcac_merchant_risk_info_id)
)comment = '查询协会商户风险信息表 ';


drop table if exists business_info;

/*==============================================================*/
/* Table: business_info                                         */
/*==============================================================*/
create table business_info
(
   business_info_id     int(64) not null auto_increment comment '序号id',
   cus_type             varchar(2) comment '商户类型',
   cus_name_en          varchar(64) comment '商户英文名称',
   cus_nature           varchar(2) comment '商户属性',
   cus_name             varchar(128) comment '商户简称',
   reg_name             varchar(128) comment '商户名称/企业名称',
   cus_code             varchar(64) comment '商户代码，最长不能超过 32 个字符',
   doc_type             varchar(2) comment '法人证件类型',
   doc_code             varchar(64) comment '法人证件号码',
   indu_type            varchar(100) comment '商户行业类别',
   leg_doc_name         varchar(64) comment '法定代表人姓名',
   reg_addr_prov        varchar(6) comment '商户注册地址省市',
   reg_addr_detail      varchar(256) comment '商户注册地址',
   addr_detail          varchar(256) comment '商户经营地址',
   out_service_card_type varchar(2) comment '外包服务机构法人证件类型',
   org_id               varchar(32) comment '上报机构',
   rep_date             datetime comment '上报日期',
   rep_type             varchar(2) comment '上传方式',
   rep_person           varchar(32) comment '上传人',
   out_service_card_code varchar(64) comment '外包服务机构法人证件号码',
   out_service_leg_card_type varchar(2) comment '外包服务机构法定代表人证件类型',
   out_service_leg_card_code varchar(64) comment '外包服务机构法定代表人证件号码',
   unit_prop            varchar(2) comment '单位性质',
   share_holder         varchar(1024) comment '股东信息',
   open_type            varchar(32) comment '开通业务种类',
   chage_type           varchar(2) comment '计费类型',
   account_type         varchar(2) comment '支持账户类型',
   expand_type          varchar(2) comment '拓展方式',
   out_service_name     varchar(128) comment '外包服务机构名称',
   status               varchar(2) comment '商户状态',
   start_time           varchar(10) comment '服务起始时间',
   end_time             varchar(10) comment '服务终止时间',
   risk_status          varchar(2) comment '合规风险状况',
   result_status        varchar(2) comment '交易结果',
   cont_name            varchar(64) comment '商户联系人',
   cont_phone           varchar(32) comment '商户联系电话',
   cus_email            varchar(64) comment '商户 E-mail',
   network_type         varchar(32) comment '清算网络',
   addr_prov            varchar(6) comment '商户经营地址(省)',
   leg_doc_type         varchar(2) comment '法定代表人（负责人） 证件类型',
   leg_doc_code         varchar(64) comment '法定代表人（负责人）证件号码',
   bank_no              varchar(64) comment '银行结算账号',
   open_bank            varchar(128) comment '开户行（支付账户开立机构）',
   url                  varchar(512) comment '网址',
   server_ip            varchar(512) comment '服务器 IP',
   icp                  varchar(20) comment 'ICP 备案编号',
   occurarea            varchar(256) comment '商户经营地区范围',
   submit_status        varchar(2) default '0' comment '报送状态0为未报送，1为已报送',
   result_code          varchar(6) comment '交易返回码',
   primary key (business_info_id)
)comment = '企业商户信息表 ';


drop table if exists sys_lan;

/*==============================================================*/
/* Table: sys_lan                                         */
/*==============================================================*/

CREATE TABLE  sys_lan  (
   lan_id  varchar(30) NOT NULL COMMENT '城市ID',
   lan_name  varchar(256) DEFAULT NULL COMMENT '城市名',
   lan_code  varchar(30) DEFAULT NULL COMMENT '商户英文名称',
   province_id  varchar(32) DEFAULT NULL COMMENT '省份ID',
  PRIMARY KEY ( lan_id )
) comment = '地域编码字典表';

