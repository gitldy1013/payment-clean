drop table if exists pcac_assistance_info;

/*==============================================================*/
/* Table: pcac_assistance_info                                  */
/*==============================================================*/
create table pcac_assistance_info
(
   id                   int(64) not null comment 'id序号',
   up_date              varchar(10) comment '推送日期',
   cus_code             varchar(64) comment '商户代码',
   reg_name             varchar(64) comment '商户名称',
   leg_doc_name         varchar(128) comment '法定代表人（负责人）姓名'
);

alter table pcac_assistance_info comment '商户信息比对协查信息表';