# 支付清算综合服务平台技术方案文档

>*   文档修订时间：2020-08-31

>*   文档修订人：刘东阳

## 1.概述

本文主要针对支付清算平台，大数据平台，风控平台之间数据交互和报文传输服务的整体技术方案做出详细说明，包含接口流程图，技术设计方案架构图，数据库库表设计，项目代码架构设计，服务模块联调方式等。

## 2.系统设计

### 2.1涉及服务：

>*   1.风控平台

>*   2.大数据平台

>*   3.支付清算平台

>*   4.商户系统

### 2.2涉及技术栈：

>*   后台语言为Java，springboot整合mybatis-plus架构开发。

>*   数据库为Mysql存储数据，sftp服务推送商户黑名单。

>*   采用ngnix解决证书及安全限制问题。

## 3.接口流程图

>*   风险商户，企业，个人同步上报流程图

![](doc\1_风险商户_企业_个人同步上报流程图.png)

>*   清算协会黑名单，风险商户信息推送流程图

![](doc\2-1_清算协会黑名单_风险商户信息推送流程图.png)

>*   风险商户信息补发请求流程图

![](doc\2-2_风险商户信息补发请求流程图.png)

>*   关联本地商户和协会商户信息查询与反馈流程图

![](doc\3_关联本地商户和协会商户信息查询与反馈流程图.png)

>*   商户风险信息查询，反馈流程图

![](doc\4_商户风险信息查询&反馈流程图.png)

>*   企业商户信息上报，查询，协查信息推送流程图

![](doc\5_企业商户信息上报&查询&协查信息推送流程图.png)

## 4.接口详情定义

### 4.1本地风险信息共享相关接口

#### 4.1.1风险商户同步请求接口

>* 接口类型：同步  请求类型：POST 请求路径：/localRisk/localRiskReg/sync

* 请求报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|cusType|商户类型|String|
|cusNature|商户属性|String|
|cusNumber|商户编号|String|
|regName|商户名称|String|
|riskType|风险类型|String|
|validDate|有效期|String|
|level|风险信息等级|String|
|occurtimeb|风险事件发生时间|String|
|occurtimee|风险事件结束时间|String|
|submitType|报送类型（新增/修改）|String|

* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|resCode|同步状态码(详见附录)|String|
|resMsg|同步状态码说明|String|

#### 4.1.2风险商户查询请求接口

>* 接口类型：同步  请求类型：POST 请求路径：/localRisk/localRiskReg/query

* 请求报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|cusNumber|商户编号|String|
|regName|商户名称|String|
|busLicenseNumber|营业执照编号|String|
|docCode|法人身份证|String|
|submitStartTime|报送开始时间|String|
|submitEndTime|报送结束时间|String|
|status|状态|String|

* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|msgType|信息类型|String|
|cusType|商户类型|String|
|cusProperty|客户属性|String|
|cusNature|商户属性|String|
|cusNumber|商户编号|String|
|riskType|风险类型|String|
|RegName|商户名称|String|
|docType|法人证件类型|String|
|docCode|法人证件号码|String|
|legRepName|法定代表人（负责人）姓名|String|
|legDocType|法定代表人（负责人）证件类型|String|
|legDocCode|法定代表人（负责人）证件号码|String|
|bankNo|银行结算账号（支付账户）|String|
|openBank|开户行|String|
|sourceChannel|风险信息来源渠道|String|
|validDate|有效期|String|
|level|风险信息等级|String|
|occurtimeb|风险事件发生时间|String|
|occurtimee|风险事件结束时间|String|
|occurchan|风险事件发生渠道|String|
|occurarea|风险事件发生地域|String|
|note|风险事件描述|String|
|createTime|录入时间|String|
|unvalidTime|失效时间|String|
|status|状态|String|
|operator|操作人|String|
|operateTime|操作时间|String|


#### 4.1.3风险个人同步请求接口

>* 接口类型：同步  请求类型：POST 请求路径：/localRisk/localRiskPer/sync

* 请求报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|riskType|风险类型|String|
|sourceChannel|风险信息来源渠道|String|
|mobileNo|手机号|String|
|bankNo|付款账户/付款银行卡号（支付账户）|String|
|openBank|开户机构|String|
|collectAccount|收款账户/收款银行卡号（支付账户）|String|
|amount|交易金额|String|
|currency|交易币种|String|
|docType|证件类型|String|
|docCode|证件号码|String|
|cusName|个人姓名|String|
|riskFindTime|风险事件发现时间|String|
|occurtimeb|风险事件发生开始时间|String|
|occurtimee|风险事件发生结束时间|String|
|occurchan|风险事件发生渠道|String|
|occurarea|风险事件发生地域|String|
|validDate|有效期|String|
|validStatus|有效性|String|
|note|风险事件描述|String|

* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|resCode|同步状态码(详见附录)|String|
|resMsg|同步状态码说明|String|

#### 4.1.4风险个人查询请求接口

>* 接口类型：同步  请求类型：GET 请求路径：/localRisk/localRiskPer/query

* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|riskType|风险类型|String|
|sourceChannel|风险信息来源渠道|String|
|mobileNo|手机号|String|
|bankNo|付款账户/付款银行卡号（支付账户）|String|
|openBank|开户机构|String|
|collectAccount|收款账户/收款银行卡号（支付账户）|String|
|amount|交易金额|String|
|currency|交易币种|String|
|docType|证件类型|String|
|docCode|证件号码|String|
|cusName|个人姓名|String|
|riskFindTime|风险事件发现时间|String|
|occurtimeb|风险事件发生开始时间|String|
|occurtimee|风险事件发生结束时间|String|
|occurchan|风险事件发生渠道|String|
|occurarea|风险事件发生地域|String|
|validDate|有效期|String|
|validStatus|有效性|String|
|note|风险事件描述|String|
|status|状态|String|
|operator|操作人|String|
|operateTime|操作时间|String|
|remark|备注（当状态为失败时，备注为失败原因）|String|

#### 4.1.5风险企业同步请求接口

>* 接口类型：同步  请求类型：GET 请求路径：/localRisk/localRiskCom/sync

* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|resCode|同步状态码(详见附录)|String|
|resMsg|同步状态码说明|String|

#### 4.1.6风险企业查询请求接口

>* 接口类型：同步  请求类型：GET 请求路径：/localRisk/localRiskCom/query

* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|sourceChannelIdentify|来源渠道标识|String|
|riskInfoCode|风险信息编码|String|
|cusType|商户类型|String|
|cusCode|机构代码|String|
|msgType|信息类型|String|
|riskType|风险类型|String|
|cusNature|商户属性|String|
|cusName|商户简称|String|
|regName|商户名称|String|
|cusCode|商户代码|String|
|legDocType|法人证件类型|String|
|legDocCode|法人证件号码|String|
|taxRegCer|税务登记证|String|
|legRepName|法定代表人姓名（负责人）|String|
|legDocType|法定代表人证件类型（负责人|String|
|legDocCode|法定代表人证件号码（负责人|String|
|legBenName|受益所有人姓名|String|
|legBenCardType|受益所有人证件类型|String|
|legBenCardCode|受益所有人证件号码|String|
|legControlName|实控人姓名|String|
|legControlCardType|实控人证件类型|String|
|legControlCardCode|实控人证件号码|String|
|bankNo|银行结算账号（支付账户）|String|
|openBank|开户行（支付账户开立 机构）|String|
|amount|交易金额|String|
|currency|交易币种|String|
|url|网址|String|
|serverIp|服务器 IP|String|
|icp|ICP 备案编 号|String|
|mobileNo|法定代表人（负责人）手机号|String|手
/address/商户实际办公地|String|
|level|风险信息等级|String|
|riskFindTime|风险事件发现时间|String|
|occurtimeb|风险事件发生开始时间|String|
|occurtimee|风险事件发生结束时间|String|
|occurchan|风险事件发生渠道|String|
|occurarea|风险事件发生地域|String|
|note|风险事件描述|String|
|sourceChannel|风险信息来源|String|
|validDate|有效期|String|
|validStatus|有效性|String|
|status|状态|String|
|operator|操作人|String|
|operateTime|操作时间|String|

### 4.2协会风险商户共享

#### 4.2.1加黑推送sftp方式实现

>* sftp服务IP：localhost
>* sftp服务port：8090
>* sftp服务用户名：root
>* sftp服务密码：root
>* sftp服务获取目录：/blacklist

#### 4.2.2风险商户查询

>* 接口类型：同步  请求类型：POST 请求路径：/isocRisk/isocRiskReg/query

* 请求报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|pushStartTime|推送开始时间|String|
|pushEndTime|推送结束时间|String|
|regName|商户名称|String|
|busLicenseNumber|营业执照编号|String|
|docCode|法人身份证|String|
|riskType|风险类型|String|

* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|pushListType推送名单类型|String|
|pushTime|推送时间|String|
|level/风险信息等级|String|
|riskType|风险类型|String|
|cusName|商户简称|String|
|regName|商户名称|String|
|legDocType|法人证件类型|String|
|legDocCode|法人证件号码|String|
|legRepName|法人（负责人）代表姓名|String|
|legDocType|法人（负责人）证件类型|String|
|validDate|有效期|String|
|validStatus|有效性|String|
|cusType|商户类型|String|
|occurarea|风险事件发生地域|String|

#### 4.2.3风险信息补发

>* 接口类型：同步  请求类型：POST 请求路径：/localRisk/localRiskMsg/

* 请求报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|occurtimeb|风险事件发生时间|String|
|occurtimee|风险事件结束时间|String|

* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|resCode|同步状态码(详见附录)|String|
|resMsg|同步状态码说明|String|

### 4.3本地商户关联反馈

#### 4.3.1本地关联风险商户查询

>* 接口类型：同步  请求类型：POST 请求路径：/localRisk/localRiskMsg/query

* 请求报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|pushStartTime|推送开始时间|String|
|pushEndTime|推送结束时间|String|
|cusNumber|商户编号|String|
|regName|商户名称|String|
|busLicenseNumber|营业执照编号|String|
|docCode|法人身份证|String|
|riskType|风险类型|String|
|status|反馈状态|String|

* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|pushListType|推送名单类型|String|
|pushTime|推送时间|String|
|level|风险信息等级|String|
|riskType|风险类型|String|
|cusName|商户简称|String|
|regName|商户名称|String|
|legDocType|法人证件类型|String|
|legDocCode|法人证件号码|String|
|legRepName|法人（负责人）代表姓名|String|
|legDocType|法人（负责人）证件类型|String|
|legDocCode|法人（负责人）证件号码|String|
|validDate|有效期|String|
|validStatus|有效性|String|
|cusType|商户类型|String|
|occurarea|风险事件发生地域|String|
|assMerNumber|关联商户编号|String|
|status|商户状态|String|
|isBlack|是否加黑|String|
|assFieldCnt|关联字段个数|String|
|assFieldName|关联字段名称|String|
|feedback|反馈情况|String|

#### 4.3.2本地关联风险商户反馈

>* 接口类型：同步  请求类型：POST 请求路径：/localRisk/localRiskMsg/back

* 请求报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|feedback|反馈情况|String|
|dealTime|处理时间|String|
|Amount|涉及结算金额(后台计算)|String|
|currency|币种|String|
|explain|说明|String|
|cusType|商户类型|String|
|regName|商户名称|String|
|/|处理方式|String|
|/|证件类型|String|
|/|证件号码|String|

* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|resCode|同步状态码(详见附录)|String|
|resMsg|同步状态码说明|String|

### 4.4查询商户风险信息及反馈

#### 4.4.1查询商户风险信息

>* 接口类型：同步  请求类型：POST 请求路径：/isocRisk/isocRegRisk/query

* 请求报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|/|商户反馈主键编码|String|
|/|商户类型|String|
|/|反馈情况|String|
|/|处理时间|String|
|/|涉及结算金额（参考查询时间，近90天内结算总金额）|String|
|/|币种|String|
|/|说明|String|

* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|resCode|同步状态码(详见附录)|String|
|resMsg|同步状态码说明|String|

#### 4.4.2商户风险信息查询使用情况反馈

>* 接口类型：同步  请求类型：POST 请求路径：/isocRisk/isocRegRisk/back

* 请求报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|/|商户名称|String|
|/|营业执照编号|String|
|/|法人身份证|String|

* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|/|商户名称|String|
|/|营业执照编号|String|
|/|法人身份证|String|
|/|涉及机构数|String|
|/|商户个数|String|
|/|涉及结算金额（参考查询时间，近90天内结算总金额）|String|

### 4.5特约商户信息报送

#### 4.5.1企业商户批量查询

>* 接口类型：同步  请求类型：POST 请求路径：/specReg/specRegCom/query

* 请求报文字段

待确认

* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|resCode|同步状态码(详见附录)|String|
|resMsg|同步状态码说明|String|

## 5.项目架构图

![](doc\架构图.jpg)

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
| 001         | 未知错误               |
| 002         | 服务暂不可用           |
| 003         | 未知的方法             |
| 100         | 请求参数无效           |
| 114         | 无效的ip参数           |
| 801         | 无效的操作方法         |
| 805         | 数据库操作出错，请重试 |
