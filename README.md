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

>*   风险商户，企业，个人同步上报流程图

![](doc\1_风险商户_企业_个人同步上报流程图.png)

>*   清算协会黑名单，风险商户信息推送及补发流程图

![](doc\2_清算协会黑名单_风险商户信息推送及补发流程图.png)

>*   关联本地商户和协会商户信息查询与反馈流程图

![](doc\3_关联本地商户和协会商户信息查询与反馈流程图.png)

>*   商户风险信息查询，反馈流程图

![](doc\4_商户风险信息查询&反馈流程图.png)

>*   企业商户信息上报，查询，协查信息推送流程图

![](doc\5_企业商户信息上报&查询&协查信息推送流程图.png)

![](doc\接口流程图.jpg)

## 4.接口详情定义

### 4.1本地风险信息共享相关接口

#### 4.1.1风险商户同步请求接口

>* 接口类型：同步  请求类型：POST 请求路径：/localRisk/localRiskReg/sync

* 请求报文字段

*商户类型 风险类型 商户属性 商户编号 风险信息等级 有效期 风险事件发生时间 风险事件结束时间 风险事件描述 风险信息来源   操作人 操作时间*

|字段名称|字段说明|参数类型|
|-------|------|-----|
|cusType|商户类型|String|
|riskType|风险类型|String|
|cusNature|商户属性|String|
|cusNumber|商户编号|String|
|level|风险信息等级|String|
|validDate|有效期|String|
|occurtimeb|风险事件发生时间|String|
|occurtimee|风险事件结束时间|String|
|note|风险事件描述|String|
|sourceChannel|风险信息来源|String|
|operator|操作人|String|
|operateTime|操作时间|String|

* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|resCode|同步状态码(详见附录)|String|
|resMsg|同步状态码说明|String|

#### 4.1.2风险商户查询请求接口

>* 接口类型：同步  请求类型：POST 请求路径：/localRisk/localRiskReg/query

* 请求报文字段
*商户编号、商户名称（模糊查询）、法人证件类型、法人证件号码、法定代表人证件类型、法定代表人证件号码，上报起止日期、操作起止日期、报送状态，操作人*

|字段名称|字段说明|参数类型|
|-------|------|-----|
|cusNumber|商户编号|String|
|regName|商户名称|String|
|docType|法人证件类型|String|
|docCode|法人证件号码|String|
|legDocType|法定代表人证件类型|String|
|legDocCode|法定代表人证件号码|String|
|submitStartTime|上报开始时间|String|
|submitEndTime|上报结束时间|String|
|operateStartTime|操作开始时间|String|
|operateEndTime|操作结束时间|String|
|submitStatus|报送状态|String|
|operator|操作人|String|


* 响应报文字段
*商户代码	商户简称	商户名称	商户类型	信息类型	风险类型	风险信息等级	商户属性	法人证件类型	法人证件号码	法定代表人（负责人） 姓名	
法定代表人（负责人） 证件类型	法定代表人（负责人） 证件号码	受益所有人姓名	受益所有人证件类型	受益所有人证件号码	银行结算账号（支付账户）	开户行（支付账户开立机构）	
有效期	有效性	风险事件发生时间	风险事件发生地域	风险事件描述	风险信息来源	操作人	操作时间	上报时间	上报状态	失败原因*
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
|validDate|有效期|String|
|validStatus|有效性|String|
|occurtimeb|风险事件发生时间|String|
|occurarea|风险事件发生地域|String|
|note|风险事件描述|String|
|sourceChannel|风险信息来源|String|
|operator|操作人|String|
|operateTime|操作时间|String|
|submitTime|上报时间|String|
|submitStatus|报送状态|String|
|failureReason|失败原因|String|


#### 4.1.3风险个人同步请求接口

>* 接口类型：同步  请求类型：POST 请求路径：/localRisk/localRiskPer/sync

*风险类型	内部用户号 有效期 风险事件发生时间 风险事件结束时间 风险事件发生渠道 风险事件描述 风险信息来源 风险事件发生地域 操作人 操作时间*

* 请求报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|riskType|风险类型|String(枚举)|
|usrNo|内部用户号|String|
|validDate|有效期|String|
|occurtimeb|风险事件发生时间|String|
|occurtimee|风险事件结束时间|String|
|occurchan|风险事件发生渠道|String|
|note|风险事件描述|String|
|sourceChannel|风险信息来源|String(枚举)|
|occurarea|风险事件发生地域|String|
|operator|操作人|String|
|operateTime|操作时间|String|


* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|resCode|同步状态码(详见附录)|String|
|resMsg|同步状态码说明|String|

#### 4.1.4风险个人查询请求接口

>* 接口类型：同步  请求类型：GET 请求路径：/localRisk/localRiskPer/query

* 请求报文字段

*内部用户号 ，手机号，证件类型，证件号码 ，操作起/止日期，报送起/止日期，上报状态(枚举) ，操作人*

|字段名称|字段说明|参数类型|
|-------|------|-----|
|usrNo|内部用户号|String|
|mobileNo|手机号|String|
|docType|证件类型|String|
|docCode|证件号码|String|
|operateStartTime|操作开始时间|String|
|operateEndTime|操作结束时间|String|
|submitStartTime|上报开始时间|String|
|submitEndTime|上报结束时间|String|
|submitStatus|报送状态|String|
|operator|操作人|String|

* 响应报文字段

*内部用户号	手机号 	个人姓名 	客户属性	风险类型	证件类型	证件号码	付款银行账户/卡号	付款银行账户/卡号开户行	
有效期	有效性	风险事件发生时间	风险事件发生地域	风险事件描述	风险事件来源渠道	操作人	操作时间	上报时间	上报状态	失败原因
*

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
|validDate|有效期|String|
|validStatus|有效性|String|
|occurtimeb|风险事件发生时间|String|
|occurarea|风险事件发生地域|String|
|note|风险事件描述|String|
|sourceChannel|风险信息来源渠道|String|
|operator|操作人|String|
|operateTime|操作时间|String|
|submitTime|上报时间|String|
|submitStatus|报送状态|String|
|failureReason|失败原因|String|



#### 4.1.5风险企业同步请求接口

>* 接口类型：同步  请求类型：POST 请求路径：/localRisk/localRiskCom/sync

* 请求报文字段
*风险类型	单位支付账户编号	风险事件发生时间	风险事件结束时间	风险事件描述	风险信息来源	有效期  操作人 操作时间*

|字段名称|字段说明|参数类型|
|-------|------|-----|
|riskType|风险类型|String|
|paymentAccountNo|单位支付账户编号|String|
|occurtimeb|风险事件发生时间|String|
|occurtimee|风险事件结束时间|String|
|note|风险事件描述|String|
|sourceChannel|风险信息来源|String(枚举)|
|validDate|有效期|String|
|operator|操作人|String|
|operateTime|操作时间|String|


* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|resCode|同步状态码(详见附录)|String|
|resMsg|同步状态码说明|String|

#### 4.1.6风险企业查询请求接口

>* 接口类型：同步  请求类型：GET 请求路径：/localRisk/localRiskCom/query

* 请求报文字段

*单位支付账户编号（对应接口字段机构代码）、单位名称（模糊查询）、法人证件号码、法人证件类型、报送起止日期、报送状态。法定代表人证件类型、法定代表人证件号码，操作起止日期，操作人*

|字段名称|字段说明|参数类型|
|-------|------|-----|
|cusCode|机构代码|String|
|regName|企业名称|String|
|docCode|法人证件号码|String|
|docType|法人证件类型|String|
|submitStartTime|上报开始时间|String|
|submitEndTime|上报结束时间|String|
|submitStatus|报送状态|String|
|legDocCode|法定代表人证件类型|String|
|legDocType|法定代表人证件号码|String|
|operateStartTime|操作开始时间|String|
|operateEndTime|操作结束时间|String|
|operator|操作人|String|

* 响应报文字段

*单位账户编号	 企业简称 	企业简称	信息类型	风险类型	法人证件类型	法人证件号码	法定代表人（负责人） 姓名	法定代表人（负责人） 证件类型	法定代表人（负责人） 证件号码	
企业注册地址	有效期	有效性	风险事件发生时间	风险事件发生地域	风险事件描述	风险信息来源	操作人	操作时间	上报时间	上报状态	失败原因
*

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
|validDate|有效期|String|
|validStatus|有效性|String|
|occurtimeb|风险事件发生时间|String|
|occurarea|风险事件发生地域|String|
|note|风险事件描述|String|
|sourceChannel|风险信息来源|String|
|operator|操作人|String|
|operateTime|操作时间|String|
|submitTime|上报时间|String|
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

>* 接口类型：同步  请求类型：POST 请求路径：/isocRisk/isocRiskReg/query

* 请求报文字段

*商户名称（模糊查询）、法定代表人证件号码、法人证件号码，推送日期，法人证件类型，法定代表人证件类型*

|字段名称|字段说明|参数类型|
|-------|------|-----|
|regName|商户名称|String|
|legDocCode|法定代表人证件号码|String|
|docCode|法人证件号码|String|
|pushStartTime|推送开始时间|String|
|pushEndTime|推送结束时间|String|
|docType|法人证件类型|String|
|legDocType|法定代表人证件类型（负责人）|String|


* 响应报文字段

*推送名单类型	推送日期	风险信息等级	风险类型	商户简称	商户名称	法人证件类型	法人证件号码	法人（负责人）代表姓名	法人（负责人）证件类型	法人（负责人）证件号码	
有效期	有效性	商户类型	风险事件发生地域*

|字段名称|字段说明|参数类型|
|-------|------|-----|
|pushListType|推送名单类型|String|
|pushDate|推送日期|String|
|level|风险信息等级|String|
|riskType|风险类型|String|
|cusName|商户简称|String|
|regName|商户名称|String|
|docType|法人证件类型|String|
|docCode|法人证件号码|String|
|legRepName|法人（负责人）代表姓名|String|
|legDocType|法人（负责人）证件类型|String|
|legDocCode|法人（负责人）证件号码|String|
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
|riskType|补发信息类型|String|

* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|resCode|同步状态码(详见附录)|String|
|resMsg|同步状态码说明|String|

### 4.3本地商户关联反馈

#### 4.3.1本地关联风险商户查询

>* 接口类型：同步  请求类型：POST 请求路径：/localRisk/localRiskMsg/query

* 请求报文字段

*关联商户编号、商户名称（清算协会推送名称，支持模糊匹配）、法人证件号码、法人证件类型、法定代表人证件号码、法定代表人证件类型、风险类型、反馈状态, 
推送名单类型（黑名单、风险提示名单），反馈起止日期、推送起止日期*

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
|feedbackStartDate|反馈开始日期|String|
|feedbackEndDate|反馈结束日期|String|
|pushStartDate|推送开始日期|String|
|pushEndDate|推送结束日期|String|




* 响应报文字段

*关联商户编号	推送名单类型	推送日期	风险信息等级	风险类型	商户简称	商户名称	反馈情况	反馈状态	反馈时间	推送时间	法人证件类型	法人证件号码	法人（负责人）代表姓名	
法定代表人证件类型	法定代表人证件号码	有效期	有效性	商户类型	风险事件发生地域	商户状态	是否加黑	关联字段个数	关联字段名称	失败原因	操作人	涉及结算金额*

|字段名称|字段说明|参数类型|
|-------|------|-----|
|cusNumber|商户编号|String|
|pushListType|推送名单类型|String|
|pushDate|推送日期|String|
|level|风险信息等级|String|
|riskType|风险类型|String|
|cusName|商户简称|String|
|regName|商户名称|String|
|handleResult|处理结果|String|
|feedbackStatus|反馈状态|
|feedbackDate|反馈日期|String|
|pushDate|推送日期|String|
|docType|法人证件类型|String|
|docCode|法人证件号码|String|
|legRepName|法人（负责人）代表姓名|String|
|legDocType|法定代表人证件类型|String|
|legDocCode|法定代表人证件号码|String|
|validDate|有效期|String|
|validStatus|有效性|String|
|cusType|商户类型|String|
|occurarea|风险事件发生地域|String|
|status|商户状态|String|
|isBlack|是否加黑|String|
|assFieldCnt|关联字段个数|String|
|assFieldName|关联字段名称|String|
|operator|操作人|String|
|failureReason|失败原因|String|
|Amount|涉及结算金额(后台计算)|String|



#### 4.3.2本地关联风险商户反馈

>* 接口类型：同步  请求类型：POST 请求路径：/localRisk/localRiskMsg/back

* 请求报文字段

*法人证件类型，法人证件号码，法定代表人证件类型，法定代表人证件号码,涉及结算金额，处理结果，反馈日期*

|字段名称|字段说明|参数类型|
|-------|------|-----|
|docType|法人证件类型|String|
|docCode|法人证件号码|String|
|legDocType|法人（负责人）证件类型|String|
|legDocCode|法人（负责人）证件号码|String|
|Amount|涉及结算金额(后台计算)|String|
|handleResult|处理结果|String|
|feedbackDate|反馈日期|String|


* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|resCode|同步状态码(详见附录)|String|
|resMsg|同步状态码说明|String|

### 4.4查询商户风险信息及反馈

#### 4.4.1查询商户风险信息

>* 接口类型：同步  请求类型：POST 请求路径：/isocRisk/isocRegRisk/query
>
* 请求报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|cusProperty|客户属性|String|
|keyWord|关键字|String|
|infos|查询条件信息（多条数据以逗号分隔）|String|

* 响应报文字段

*风险反馈主键编码，商户类型，客户属性，风险类型，商户属性，商户名称，商户编码，涉及结算金额，法人证件类型，法人证件号码，法定代表人姓名，
法定代表人（负责人）证件类型，法定代表人（负责人）证件号码，返回数量，是否中转账户，银行账号，开户行，网址，服务器 IP，法定代表人（负责人）手机号，
商户实际办公地，ICP 备案编号，信息级别，风险事件发生时间，风险事件结束时间，风险事件发生渠道，风险事件发生地域，风险事件描述，有效期，有效性，终止合作的机构数量，
拒绝拓展的机构数量，暂停办理资金结算的机构数量，冻结账户的机构数量，调整结算周期的机构数量，延迟资金结算的机构数量，设置收款限额的机构数量，暂停银行卡交易的机构数量，
收回受理终端 (关闭网络支付接口) 的机构数量 ，暂未采取控制措施,持续关注客户的机构数量，报送反洗钱可疑交易的机构数量，其他的机构数量，商户注册国家或地区，商户注册号码，
风险信息来源渠道，交易金额，风险事件发现时间，实控人姓名，实控人证件类型，实控人证件号，备注，返回总数量，受益人姓名，受益人证件类型，受益人证件号，反馈情况，反馈状态，反馈时间，操作人*

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
|occurtimeb|风险事件发生时间|String|
|occurtimee|风险事件结束时间|String|
|occurchan|风险事件发生渠道|String|
|occurarea|风险事件发生地域|String|
|note|风险事件描述|String|
|validDate|有效期|String|
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
|riskFindTime|风险事件发现时间|String|
|legControlName|实控人姓名|String|
|legControlCardType|实控人证件类型|String|
|legControlCardCode|实控人证件号|String|
|remarks|备注|String|
|count|返回总数量|String|
|legBenName|受益人姓名|String|
|legBenCardType|受益人证件类型|String|
|legBenCardCode|受益人证件号|String|
|handleResult|处理结果|String|
|feedbackStatus|反馈状态|
|feedbackDate|反馈日期|String|
|operator|操作人|String|


#### 4.4.2商户风险信息查询使用情况反馈

>* 接口类型：同步  请求类型：POST 请求路径：/isocRisk/isocRegRisk/back

* 请求报文字段

*风险反馈主键编码，商户类型，涉及结算金额，处理结果 处理时间YYYY-MM-DD*

|字段名称|字段说明|参数类型|
|-------|------|-----|
|id|风险反馈主键编码|String|
|cusType|商户类型|String|
|amount|涉及结算金额（参考查询时间，近90天内结算总金额）|String|
|handleResult|处理结果|String|
|handleTime|处理时间|String|
|currency|交易币种|String|


* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|resCode|同步状态码(详见附录)|String|
|resMsg|同步状态码说明|String|

### 4.5特约商户信息报送

#### 4.5.1企业商户批量查询

>* 接口类型：同步  请求类型：POST 请求路径：/specReg/specRegCom/query

* 请求报文字段

*收单机构组装单个查询请求时，必须在以下查询条件组合中选择一种进行查询：
 ⚫ 企业商户法人名称
 ⚫ 法人证件号码
 ⚫ 法定代表人（负责人）证件号码+法定代表人姓名*

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

#### 5.1网络方面

>* 对接风控平台和商户系统：内网互通访问方式，大数据平台提供http协议接口，同步响应json数据。
>* 对接支付清算协会：需要申请外网IP端口映射内网服务IP端口，通过https协议方式提供推送数据接口服务。证书(沟通)

#### 5.2安全方面

>* 由于大数据平台需要对风控平台，商户系统和清算协会分别提供查询数据和上报数据，需要考虑安全问题，提交安全审批确认。(沟通)

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

## 8.数据流向

### 8.1大数据平台提供给清算协会：
    1.风险商户信息
    2.风险个人信息
    3.风险企业信息
    4.企业商户信息
### 8.2清算协会提供给大数据平台：
    1.商户黑名单信息
    2.商户风险提示信息
    3.商户信息比对协查信息
    4.商户风险情况信息
    5.企业商户批量查询结果信息
### 8.3风控系统提供给大数据平添：
    1.风险商户部分信息
    2.风险个人部分信息
    3.风险企业部分信息
### 8.4大数据平台提供给风控系统：
    1.风险商户全量信息
    2.风险个人全量信息
    3.风险企业全量信息
    4.商户黑名单信息
    5.商户风险情况信息
    6.企业商户风险情况信息
### 8.5大数据平台提供给商户系统：
    1.企业商户批量查询结果信息

## 9.附录

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
