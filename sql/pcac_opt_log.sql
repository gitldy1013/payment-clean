drop table if exists paca_opt_log;
create table paca_opt_log
(
    id            int(64) not null comment 'id序号',
    created_by    varchar(32)    comment '操作人' ,
    opt_content   varchar(128)    comment '操作内容' ,
    created_time  datetime    comment '操作时间' ,
    updated_by    varchar(32)    comment '更新人' ,
    updated_time  datetime    comment '更新时间'
) comment = '操作日志表 ';

alter table paca_opt_log comment '操作日志表';
