# 支付清算综合服务平台技术方案文档

|文档修订时间|文档修订人|
|---------|--------|
|2020-08-31 | 刘东阳|
|2020-09-03 | 刘东阳 赵磊|

## 1.概述

本文主要针对支付清算平台，大数据平台，风控平台之间数据交互和报文传输服务的整体技术方案做出详细说明，包含接口流程图，技术设计方案架构图，数据库库表设计，项目代码架构设计，服务模块联调方式等。

## 2.系统设计

### 2.1涉及服务：

>*   1.风控平台

>*   2.大数据平台

>*   3.支付清算平台

>*   4.商户系统

### 2.2项目架构图

![](doc\架构图.jpg)

### 2.2涉及技术栈：

>*   后台语言为Java，springboot整合mybatis-plus架构开发。

>*   数据库为Mysql存储数据，sftp服务推送商户黑名单。

>*   采用ngnix解决证书及安全限制问题。

## 3.接口流程图

![](doc\接口流程图.vsdx)

## 4.接口详情定义

### 4.1本地风险信息共享相关接口

#### 4.1.1风险商户上报请求接口

>* 请求类型：POST 
>* 请求路径：/localRisk/localRiskReg/sync

* 请求报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|cusType|商户类型|String|
|riskType|风险类型|String|
|cusNature|商户属性|String|
|cusNumber|商户编号|String|
|level|风险信息等级|String|
|validDate|有效期|Date|
|occurtimeb|风险事件发生时间|Date|
|occurtimee|风险事件结束时间|Date|
|note|风险事件描述|String|
|sourceChannel|风险信息来源|String|
|operator|操作人|String|
|operateTime|操作时间|Date|

* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|resCode|同步状态码(详见附录)|String|
|resMsg|同步状态码说明|String|

#### 4.1.2风险商户查询请求接口

>* 请求类型：POST
>* 请求路径：/localRisk/localRiskReg/query

* 请求报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|cusNumber|商户编号|String|
|regName|商户名称|String|
|docType|法人证件类型|String|
|docCode|法人证件号码|String|
|legDocType|法定代表人证件类型|String|
|legDocCode|法定代表人证件号码|String|
|submitStartTime|上报开始时间|Date|
|submitEndTime|上报结束时间|Date|
|operateStartTime|操作开始时间|Date|
|operateEndTime|操作结束时间|Date|
|submitStatus|报送状态|String|
|operator|操作人|String|


* 响应报文字段
*注意：法定代表人和受益人字段一样*

|字段名称|字段说明|参数类型|
|-------|------|-----|
|cusCode|商户代码|String|
|cusName|商户简称|String|
|RegName|商户名称|String|
|cusType|商户类型|String|
|msgType|信息类型|String|
|riskType|风险类型|String|
|level|风险信息等级|String|
|cusNature|商户属性|String|
|docType|法人证件类型|String|
|docCode|法人证件号码|String|
|legRepName|法定代表人（负责人）姓名|String|
|legDocType|法定代表人（负责人）证件类型|String|
|legDocCode|法定代表人（负责人）证件号码|String|
|bankNo|银行结算账号（支付账户）|String|
|openBank|开户行|String|
|validDate|有效期|Date|
|validStatus|有效性|String|
|occurtimeb|风险事件发生时间|Date|
|occurarea|风险事件发生地域|String|
|note|风险事件描述|String|
|sourceChannel|风险信息来源|String|
|operator|操作人|String|
|operateTime|操作时间|Date|
|submitTime|上报时间|Date|
|submitStatus|报送状态|String|
|failureReason|失败原因|String|


#### 4.1.3风险个人上报请求接口

>* 请求类型：POST
>* 请求路径：/localRisk/localRiskPer/sync

* 请求报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|riskType|风险类型|String(枚举)|
|usrNo|内部用户号|String|
|validDate|有效期|Date|
|occurtimeb|风险事件发生时间|Date|
|occurtimee|风险事件结束时间|Date|
|occurchan|风险事件发生渠道|String|
|note|风险事件描述|String|
|sourceChannel|风险信息来源|String(枚举)|
|occurarea|风险事件发生地域|String|
|operator|操作人|String|
|operateTime|操作时间|Date|


* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|resCode|同步状态码(详见附录)|String|
|resMsg|同步状态码说明|String|

#### 4.1.4风险个人查询请求接口

>* 请求类型：GET
>* 请求路径：/localRisk/localRiskPer/query

* 请求报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|usrNo|内部用户号|String|
|mobileNo|手机号|String|
|docType|证件类型|String|
|docCode|证件号码|String|
|operateStartTime|操作开始时间|Date|
|operateEndTime|操作结束时间|Date|
|submitStartTime|上报开始时间|Date|
|submitEndTime|上报结束时间|Date|
|submitStatus|报送状态|String|
|operator|操作人|String|

* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|usrNo|内部用户号|String|
|mobileNo|手机号|String|
|cusName|个人姓名|String|
|cusProperty|客户属性|String|
|riskType|风险类型|String|
|docType|证件类型|String|
|docCode|证件号码|String|
|bankNo|付款账户/付款银行卡号（支付账户）|String|
|openBank|开户机构|String|
|validDate|有效期|Date|
|validStatus|有效性|String|
|occurtimeb|风险事件发生时间|Date|
|occurarea|风险事件发生地域|Date|
|note|风险事件描述|String|
|sourceChannel|风险信息来源渠道|String|
|operator|操作人|String|
|operateTime|操作时间|Date|
|submitTime|上报时间|Date|
|submitStatus|报送状态|String|
|failureReason|失败原因|String|

#### 4.1.5风险企业上报请求接口

>* 请求类型：POST
>* 请求路径：/localRisk/localRiskCom/sync

* 请求报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|riskType|风险类型|String|
|payAccountNo|单位支付账户编号|String|
|occurtimeb|风险事件发生时间|Date|
|occurtimee|风险事件结束时间|Date|
|note|风险事件描述|String|
|sourceChannel|风险信息来源|String(枚举)|
|validDate|有效期|Date|
|operator|操作人|String|
|operateTime|操作时间|Date|


* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|resCode|同步状态码(详见附录)|String|
|resMsg|同步状态码说明|String|

#### 4.1.6风险企业查询请求接口

>* 请求类型：GET
>* 请求路径：/localRisk/localRiskCom/query

* 请求报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|cusCode|机构代码|String|
|regName|企业名称|String|
|docCode|法人证件号码|String|
|docType|法人证件类型|String|
|submitStartTime|上报开始时间|Date|
|submitEndTime|上报结束时间|Date|
|submitStatus|报送状态|String|
|legDocCode|法定代表人证件类型|String|
|legDocType|法定代表人证件号码|String|
|operateStartTime|操作开始时间|Date|
|operateEndTime|操作结束时间|Date|
|operator|操作人|String|

* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|cusCode|机构代码|String|
|cusName|企业简称|String|
|regName|企业简称|String|
|msgType|信息类型|String|
|riskType|风险类型|String|
|docType|法人证件类型|String|
|docCode|法人证件号码|String|
|legRepName|法定代表人姓名（负责人）|String|
|legDocType|法定代表人证件类型（负责人）|String|
|legDocCode|法定代表人证件号码（负责人）|String|
|regAddress|企业注册地址|String|
|validDate|有效期|Date|
|validStatus|有效性|String|
|occurtimeb|风险事件发生时间|Date|
|occurarea|风险事件发生地域|String|
|note|风险事件描述|String|
|sourceChannel|风险信息来源|String|
|operator|操作人|String|
|operateTime|操作时间|Date|
|submitTime|上报时间|Date|
|submitStatus|报送状态|String|
|failureReason|失败原因|String|



### 4.2协会风险商户共享

#### 4.2.1加黑推送sftp方式实现

(待确认 sftp服务器)
>* sftp服务IP：localhost
>* sftp服务port：8090
>* sftp服务用户名：root
>* sftp服务密码：root
>* sftp服务获取目录：/blacklist
(加黑判断的口径同步数据库表状态)

#### 4.2.2风险商户查询

>* 请求类型：POST
>* 请求路径：/isocRisk/isocRiskReg/query

* 请求报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|regName|商户名称|String|
|legDocCode|法定代表人证件号码|String|
|docCode|法人证件号码|String|
|pushStartTime|推送开始时间|Date|
|pushEndTime|推送结束时间|Date|
|docType|法人证件类型|String|
|legDocType|法定代表人证件类型（负责人）|String|


* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|pushListType|推送名单类型|String|
|upDate|推送日期|Date|
|level|风险信息等级|String|
|riskType|风险类型|String|
|cusName|商户简称|String|
|regName|商户名称|String|
|docType|法人证件类型|String|
|docCode|法人证件号码|String|
|legRepName|法人（负责人）代表姓名|String|
|legDocType|法人（负责人）证件类型|String|
|legDocCode|法人（负责人）证件号码|String|
|validDate|有效期|Date|
|validStatus|有效性|String|
|cusType|商户类型|String|
|occurarea|风险事件发生地域|String|

#### 4.2.3风险信息补发

>* 请求类型：POST
>* 请求路径：/localRisk/localRiskMsg/

* 请求报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|occurtimeb|风险事件发生时间|Date|
|occurtimee|风险事件结束时间|Date|
|riskType|补发信息类型|String|

* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|resCode|同步状态码(详见附录)|String|
|resMsg|同步状态码说明|String|

### 4.3本地商户关联反馈

#### 4.3.1本地关联风险商户查询

>* 请求类型：POST
>* 请求路径：/localRisk/localRiskMsg/query

* 请求报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|cusNumber|商户编号|String|
|regName|商户名称|String|
|docCode|法人证件号码|String|
|docType|法人证件类型|String|
|legDocType|法人（负责人）证件类型|String|
|legDocCode|法人（负责人）证件号码|String|
|riskType|风险类型|String|
|status|反馈状态|String|
|pushListType|推送名单类型|String|
|feedbackStartDate|反馈开始日期|Date|
|feedbackEndDate|反馈结束日期|Date|
|pushStartDate|推送开始日期|Date|
|pushEndDate|推送结束日期|Date|




* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|cusNumber|商户编号|String|
|pushListType|推送名单类型|String|
|upDate|推送日期|Date|
|level|风险信息等级|String|
|riskType|风险类型|String|
|cusName|商户简称|String|
|regName|商户名称|String|
|handleResult|处理结果|String|
|feedbackStatus|反馈状态|
|feedbackDate|反馈日期|Date|
|docType|法人证件类型|String|
|docCode|法人证件号码|String|
|legRepName|法人（负责人）代表姓名|String|
|legDocType|法定代表人证件类型|String|
|legDocCode|法定代表人证件号码|String|
|validDate|有效期|Date|
|validStatus|有效性|String|
|cusType|商户类型|String|
|occurarea|风险事件发生地域|String|
|assMerNumber|关联商户编号|String|
|status|商户状态|String|
|isBlack|是否加黑|String|
|assFieldCnt|关联字段个数|String|
|assFieldName|关联字段名称|String|
|operator|操作人|String|
|failureReason|失败原因|String|
|Amount|涉及结算金额(后台计算)|String|



#### 4.3.2本地关联风险商户反馈

>* 请求类型：POST
>* 请求路径：/localRisk/localRiskMsg/back

* 请求报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|docType|法人证件类型|String|
|docCode|法人证件号码|String|
|legDocType|法人（负责人）证件类型|String|
|legDocCode|法人（负责人）证件号码|String|
|Amount|涉及结算金额(后台计算)|String|
|handleResult|处理结果|String|
|feedbackDate|反馈日期|Date|


* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|resCode|同步状态码(详见附录)|String|
|resMsg|同步状态码说明|String|

### 4.4查询商户风险信息及反馈

#### 4.4.1查询商户风险信息

>* 请求类型：POST 
>* 请求路径：/isocRisk/isocRegRisk/query

* 请求报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|cusProperty|客户属性|String|
|keyWord|关键字|String|
|infos|查询条件信息（多条数据以逗号分隔）|String|

* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|resCode|同步状态码(详见附录)|String|
|resMsg|同步状态码说明|String|

>* ftp

*注意涉及结算金额是大数据方计算近90天的交易金额，查询的时候需要自己从库里获取值*

|字段名称|字段说明|参数类型|
|-------|------|-----|
|id|风险反馈主键编码|String|
|cusType|商户类型|String|
|cusProperty|客户属性|String|
|riskType|风险类型|String|
|cusNature|商户属性|String|
|RegName|商户名称|String|
|cusCode|商户编码|String|
|submitAmount|涉及结算金额(后台计算)|String|
|docType|法人证件类型|String|
|docCode|法人证件号码|String|
|legDocType|法人（负责人）证件类型|String|
|legDocCode|法人（负责人）证件号码|String|
|legRepName|法定代表人姓名（负责人）|String|
|count|返回数量|String|
|isTransfer|是否中转账户|String|
|bankNo|银行账号|String|
|openBank|开户行|String|
|url|网址|String|
|serverIp|服务器 IP|String|
|mobileNo|法定代表人（负责人）手机号|String|
|address|商户实际办公地|String|
|icp|ICP 备案编号|String|
|level|信息级别|String|
|occurtimeb|风险事件发生时间|Date|
|occurtimee|风险事件结束时间|Date|
|occurchan|风险事件发生渠道|String|
|occurarea|风险事件发生地域|String|
|note|风险事件描述|String|
|validDate|有效期|Date|
|validStatus|有效性|String|
|stopNum|终止合作的机构数量|String|
|refuseNum|拒绝拓展的机构数量|String|
|useRiseNum|暂停办理资金结算的机构数量|String|
|frozenNum|冻结账户的机构数量|String|
|adjustmentCycleNum|调整结算周期的机构数量|String|
|delayNum|延迟资金结算的机构数量|String|
|quotaNum|设置收款限额的机构数量|String|
|suspendNum|暂停银行卡交易的机构数量|String|
|closeNum|收回受理终端 (关闭网络支付接口) 的机构数量 |String|
|followNum|暂未采取控制措施,持续关注客户的机构数量|String|
|antiMoneyNum|报送反洗钱可疑交易的机构数量|String|
|otherNum|其他的机构数量|String|
|registeredArea|商户注册国家或地区|String|
|registeredCode|商户注册号码|String|
|sourceChannel|风险信息来源|String|
|amount|交易金额|String|
|riskFindTime|风险事件发现时间|Date|
|legControlName|实控人姓名|String|
|legControlCardType|实控人证件类型|String|
|legControlCardCode|实控人证件号|String|
|remarks|备注|String|
|count|返回总数量|String|
|legBenName|受益人姓名|String|
|legBenCardType|受益人证件类型|String|
|legBenCardCode|受益人证件号|String|
|handleResult|处理结果|String|
|feedbackStatus|反馈状态|String|
|feedbackDate|反馈日期|Date|
|operator|操作人|String|


#### 4.4.2商户风险信息查询使用情况反馈

>* 导入查询

>* 请求类型：POST
>* 请求路径：/isocRisk/isocRegRisk/back

* 请求报文字段

*风险反馈主键编码，商户类型，涉及结算金额，处理结果 处理时间YYYY-MM-DD*

|字段名称|字段说明|参数类型|
|-------|------|-----|
|id|风险反馈主键编码|String|
|cusType|商户类型|String|
|amount|涉及结算金额（参考查询时间，近90天内结算总金额）|String|
|handleResult|处理结果|String|
|handleTime|处理时间|Date|
|currency|交易币种|String|


* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|resCode|同步状态码(详见附录)|String|
|resMsg|同步状态码说明|String|

### 4.5特约商户信息报送

#### 4.5.1企业商户批量查询

>* 请求类型：POST
>* 请求路径：/specReg/specRegCom/query

* 请求报文字段

*收单机构组装单个查询请求时，必须在以下查询条件组合中选择一种进行查询：*
>* 企业商户法人名称
>* 法人证件号码
>* 法定代表人（负责人）证件号码+法定代表人姓名

|字段名称|字段说明|参数类型|
|-------|------|-----|
|regName|企业商户法人名称|String|
|docCode|法人证件号码|String|
|legDocName|法人（负责人）代表姓名|String|
|legDocCode|法人（负责人）证件号码|String|

* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|resCode|同步状态码(详见附录)|String|
|resMsg|同步状态码说明|String|

## 5.服务对接方式

### 5.1网络方面

>* 对接风控平台和商户系统：内网互通访问方式，大数据平台提供http协议接口，同步响应json数据。
>* 对接支付清算协会：需要申请外网IP端口映射内网服务IP端口，通过https协议方式提供推送数据接口服务。证书(沟通)

### 5.2安全方面

#### 5.2.1数据安全

>*	Mysql数据实现数据存储。按照集团要求，对证件号等敏感信息进行加密存储。
>*	通过需求分析，数据安全需要考虑数据输出，其中外部系统包括：支付清算协会，内部系统包括：商户系统和风控平台；针对不同级别的数据需要对应的安全审批流程。
    
#### 5.2.2传输安全

>* 运行过程中涉及的所有数据以及信息都只会保留在内网中，且对外开放的接口都是以https加密模式传输数据。

## 6.接口异常处理

>*   1.风控平台数据同步和清算协会报文上送的请求处理超时时间为20秒.请求失败视为异常信息，协调数据传送量，排查网络和接口实现问题。

>*   2.风控平台请求报文的错误处理统一按照报文中的错误码相应处理，错误码详见附录。

>*   3.商户加黑处理采用sftp服务器方式进行推送数据，风控平台在获取文件异常时需要注意权限和获取路径。

## 7.数据库表设计

>*   商户黑名单提示信息表

| 字段含义                     | 字段名          | 字段说明                                        | 字段类型       |
|------------------------------|-----------------|-------------------------------------------------|----------------|
| 推送日期                     | up_date         | 推送日期                                        | varchar(10)    |
| 商户名称                     | reg_name        | 商户名称                                        | varbinary(128) |
| 商户简称                     | cus_name        | 商户简称                                        | varchar(128)   |
| 法人证件类型                 | doc_type        | 法人证件类型                                    | varchar(2)     |
| 法人证件号码                 | doc_code        | 法人证件号码                                    | varchar(64)    |
| 法定代表人姓名               | leg_doc_name    | 法定代表人姓名                                  | varchar(64)    |
| 法定代表人类型               | leg_doc_type    | 法定代表人姓名                                  | varchar(2)     |
| 法定代表人（负责人）证件号码 | leg_doc_code    | 法定代表人（负责人）证件号码                    | varchar(64)    |
| 风险信息等级                 | level           | 风险信息等级                                    | varchar(2)     |
| 风险类型                     | risk_type       | 风险类型                                        | varchar(2)     |
| 有效期                       | valid_date      | 有效期                                          | varchar(10)    |
| 有效性                       | valid_status    | 有效性                                          | varchar(2)     |
| 商户类型                     | cus_type        | 商户类型                                        | varchar(2)     |
| 风险事件发生地               | occurarea       | "风险事件发生地域，省级/地市，可多选，逗号隔开" | varchar(256)   |
| 银行结算账户                 | bank_no         | 银行结算账户                                    | varchar(128)   |
| 网址                         | url             | 网址                                            | varchar(512)   |
| 商户注册号                   | registered_code | 商户注册号                                      | varchar(256)   |

>*   商户信息比对协查信息表

| 字段含义                 | 字段名       | 字段说明                 | 字段类型     |
|--------------------------|--------------|--------------------------|--------------|
| 推送日期                 | up_date      | 推送日期                 | varchar(10)  |
| 商户代码                 | cus_code     | 商户代码                 | varchar(64)  |
| 商户名称                 | reg_name     | 商户名称                 | varchar(64)  |
| 法定代表人（负责人）姓名 | leg_doc_name | 法定代表人（负责人）姓名 | varchar(128) |

>*   操作日志表

|字段含义| 字段名 | 字段说明 | 字段类型 | 
|-------| ------------ | ------------ | ------------ |
|主键id| id | 主键id | int |  |  |
|操作人| created_by | 操作人 | varchar(32) |
|操作时间| created_time | 操作时间 | datetime |
|操作内容| opt_content  | 操作内容 | varchar(128) |
|更新人| updated_by | 更新人 | varchar(32) |
|更新时间| updated_time | 更新时间 | datetime |

## 8.附录

| 错误/状态码 | 错误码说明             |
|-------------|------------------------|
| 000         | 成功                   |
| 500         | 未知错误               |
| 002         | 服务暂不可用           |
| 003         | 未知的方法             |
| 100         | 请求参数无效           |
| 114         | 无效的ip参数           |
| 801         | 无效的操作方法         |
| 805         | 数据库操作出错，请重试 |
