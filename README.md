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

|字段名称|字段说明|参数类型|枚举|
|-------|------|-----|---|
|cusType|商户类型|String|01:自然人 02:企业商户 03:个体工商户 04:境外企业商户|
|riskType|风险类型|String|01 ：虚假申请 02 ：套现、套积分 03 ：违法违规经营 04 ：销赃或协助转移赃款 05 ： 买卖或租借银行（支付）账户 06 ：侧录点(恶意) 07 ：伪卡集中使用点(恶意) 08 ：泄露账户及交易信息 09 ：恶意倒闭 10：恶意分单 11 ：移机 12 ：高风险商户 13 ：商户合谋欺诈  14 ：破产或停业商户 15 ：强迫交易 17：频繁变更服务机构 18：关联商户涉险 19：买卖银行卡信息 20：拒刷信用卡 21：转嫁手续费 22:支付敏感信息泄露 23:非法改装终端 24:切机 25:二清 26:套码 27:冒用申请 28:侧录点(非恶意) 29:洗钱行为 30:套汇 31:逃汇 32:骗汇 33:分拆交易 34:按金交易 35:境内外有权机构发布名单 36:发卡侧风险 37:恶意注册 38:伪造、变造票据 39:伪造、变造签章 40:跨境支付虚假、盗用或冒用申请 41:跨境支付大额交易客户、异常客户 42:跨境赌博 43:跨境赌博资金中转 44:伪卡集中使用点(非恶意) 45:受理终端(网络支付接口、收款码)挪作违法违规用途 46：赌博 47：赌博资金中转 99：其他|
|cusNature|商户属性|String|01 实体特约商户 02 网络特约商户 03 实体兼网络特约商户|
|cusCode|商户编号|String||
|level|风险信息等级|String||
|validDate|有效期|Date||
|occurtimeb|风险事件发生时间|Date||
|occurtimee|风险事件结束时间|Date||
|note|风险事件描述|String||
|sourceChannel|风险信息来源|String|GA:公检法等外部行政机构 RH:人民银行等监管机构 HY:会员机构 QS:清算机构 XH:协会风险模型预警 LHG:联合国 OFAC:美国财政部海外资产控制办公室 QT:其他|
|operator|操作人|String||
|operateTime|操作时间|Date||

* 请求报文示例：
```json
[
    {
        "cusType": "",
        "riskType": "",
        "cusNature": "",
        "cusCode": "",
        "level": "",
        "validDate": "",
        "occurtimeb": "",
        "occurtimee": "",
        "note": "",
        "sourceChannel": "",
        "operator": "",
        "operateTime": ""
    },
    {
        "cusType": "",
        "riskType": "",
        "cusNature": "",
        "cusCode": "",
        "level": "",
        "validDate": "",
        "occurtimeb": "",
        "occurtimee": "",
        "note": "",
        "sourceChannel": "",
        "operator": "",
        "operateTime": ""
    },
    ...
]
```

* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|resCode|同步状态码(详见附录)|String|
|resMsg|同步状态码说明|String|

* 响应报文示例：

```json
{
  "data": {},
  "resCode": "string",
  "resMsg": "string"
}
```

#### 4.1.2风险商户查询请求接口

>* 请求类型：POST
>* 请求路径：/localRisk/localRiskReg/query

* 请求报文字段

|字段名称|字段说明|参数类型|枚举|
|-------|------|-----|----|
|cusCode|商户编号|String||
|regName|商户名称|String||
|docType|法人证件类型|String|01:营业执照编码 02:统一社会信息代码 03:组织机构代码证 04:经营许可证 05：税务登记证 99:其他|
|docCode|法人证件号码|String||
|legDocType|法定代表人证件类型|String||
|legDocCode|法定代表人证件号码|String||
|submitStartTime|上报开始时间|Date||
|submitEndTime|上报结束时间|Date||
|operateStartTime|操作开始时间|Date||
|operateEndTime|操作结束时间|Date||
|submitStatus|报送状态|String||
|operator|操作人|String||

* 请求报文示例：

```json
{
    "cusCode": "",
    "regName": "",
    "docType": "",
    "docCode": "",
    "legDocType": "",
    "legDocCode": "",
    "submitStartTime": "",
    "submitEndTime": "",
    "operateStartTime": "",
    "operateEndTime": "",
    "submitStatus": "",
    "operator": ""
}
```

* 响应报文字段

*注意：法定代表人和受益人字段一样*

|字段名称|字段说明|参数类型|枚举|
|-------|------|-----|---|
|cusCode|商户代码|String||
|cusName|商户简称|String||
|RegName|商户名称|String||
|cusType|商户类型|String|01:自然人 02:企业商户 03:个体工商户 04:境外企业商户|
|cusProperty|信息类型|String||
|riskType|风险类型|String|01 ：虚假申请 02 ：套现、套积分 03 ：违法违规经营 04 ：销赃或协助转移赃款 05 ： 买卖或租借银行（支付）账户 06 ：侧录点(恶意) 07 ：伪卡集中使用点(恶意) 08 ：泄露账户及交易信息 09 ：恶意倒闭 10：恶意分单 11 ：移机 12 ：高风险商户 13 ：商户合谋欺诈  14 ：破产或停业商户 15 ：强迫交易 17：频繁变更服务机构 18：关联商户涉险 19：买卖银行卡信息 20：拒刷信用卡 21：转嫁手续费 22:支付敏感信息泄露 23:非法改装终端 24:切机 25:二清 26:套码 27:冒用申请 28:侧录点(非恶意) 29:洗钱行为 30:套汇 31:逃汇 32:骗汇 33:分拆交易 34:按金交易 35:境内外有权机构发布名单 36:发卡侧风险 37:恶意注册 38:伪造、变造票据 39:伪造、变造签章 40:跨境支付虚假、盗用或冒用申请 41:跨境支付大额交易客户、异常客户 42:跨境赌博 43:跨境赌博资金中转 44:伪卡集中使用点(非恶意) 45:受理终端(网络支付接口、收款码)挪作违法违规用途 46：赌博 47：赌博资金中转 99：其他|
|level|风险信息等级|String||
|cusNature|商户属性|String|01 实体特约商户 02 网络特约商户 03 实体兼网络特约商户|
|docType|法人证件类型|String|01:营业执照编码 02:统一社会信息代码 03:组织机构代码证 04:经营许可证 05：税务登记证 99:其他|
|docCode|法人证件号码|String||
|legRepName|法定代表人（负责人）姓名|String||
|legDocType|法定代表人（负责人）证件类型|String||
|legDocCode|法定代表人（负责人）证件号码|String||
|bankNo|银行结算账号（支付账户）|String||
|openBank|开户行|String||
|validDate|有效期|Date||
|validStatus|有效性|String|01：有效 02：失效|
|occurtimeb|风险事件发生时间|Date||
|occurarea|风险事件发生地域|String||
|note|风险事件描述|String||
|sourceChannel|风险信息来源|String|GA:公检法等外部行政机构 RH:人民银行等监管机构 HY:会员机构 QS:清算机构 XH:协会风险模型预警 LHG:联合国 OFAC:美国财政部海外资产控制办公室 QT:其他|
|operator|操作人|String||
|operateTime|操作时间|Date||
|submitTime|上报时间|Date||
|submitStatus|报送状态|String||
|msgDetail|失败原因|String||

* 响应报文示例：

```json
{
  "resMsg": "success",
  "resCode": "000",
  "data": {
    "records": [
      {
        "cusCode":"",
        "cusName":"",
        "RegName":"",
        "cusType":"",
        "cusProperty":"",
        "riskType":"",
        "level":"",
        "cusNature":"",
        "docType":"",
        "docCode":"",
        "legRepName":"",
        "legDocType":"",
        "legDocCode":"",
        "bankNo":"",
        "openBank":"",
        "validDate":"",
        "validStatus":"",
        "occurtimeb":"",
        "occurarea":"",
        "note":"",
        "sourceChannel":"",
        "operator":"",
        "operateTime":"",
        "submitTime":"",
        "submitStatus":"",
        "msgDetail":""
      }
    ],
    "total": 1,
    "size": 10,
    "current": 1,
    "orders": [],
    "optimizeCountSql": true,
    "hitCount": false,
    "countId": null,
    "maxLimit": null,
    "searchCount": true,
    "pages": 0
  }
}
```


#### 4.1.3风险个人上报请求接口

>* 请求类型：POST
>* 请求路径：/localRisk/localRiskPer/sync

* 请求报文字段

|字段名称|字段说明|参数类型|枚举|
|-------|------|-----|-----|
|riskType|风险类型|String(枚举)|01：虚假申请（受害人信息） 02：虚假申请（嫌疑人信息） 03：伪卡（受害人信息） 04：失窃卡（受害人信息） 05：未达卡（受害人信息） 06：银行卡转移（受害人信息） 07：盗用银行卡（嫌疑人信息） 08：银行卡网络欺诈（受害人信息） 09：银行卡网络欺诈（嫌疑人信息） 10：虚拟账户被盗（受害人信息） 11：盗用虚拟账户（嫌疑人信息） 12：套现(嫌疑人信息) 13 ：协助转移赃款 14 ：买卖或租借银行（支付）账户 15：专案风险信息 17: 套利行为 18:发卡侧风险 19:伪造、变造票据 20:伪造、变造签章 21:ETC 恶意欠款(客车) 22:ETC 恶意欠款(货车) 23:套取 ETC 设备(嫌疑人信息) 24:套取 ETC 设备(受害人信息) 25:ETC 专案风险信息 26:跨境赌博账户 (受害人) 27:跨境赌博付款账户(参赌嫌疑人) 28:跨境赌博资金中转账户 (受害人) 29:跨境赌博资金中转账户(赌博庄家共同嫌疑人) 30：跨境赌博收款账户(赌博庄家) 31：电信网络诈骗 99 ：其他|
|usrNo|内部用户号|String||
|validDate|有效期|Date||
|occurtimeb|风险事件发生时间|Date||
|occurtimee|风险事件结束时间|Date||
|occurchan|风险事件发生渠道|String|01、线上 02、线下 03 线上兼线下|
|note|风险事件描述|String||
|sourceChannel|风险信息来源|String|GA:公检法等外部行政机构 RH:人民银行等监管机构 HY:会员机构 QS:清算机构 XH:协会风险模型预警 LHG:联合国 OFAC:美国财政部海外资产控制办公室 QT:其他|
|occurarea|风险事件发生地域|String||
|operator|操作人|String||
|operateTime|操作时间|Date||

* 请求报文示例：

```json
[
    {
      "riskType":"",
      "usrNo":"",
      "validDate":"",
      "occurtimeb":"",
      "occurtimee":"",
      "occurchan":"",
      "note":"",
      "sourceChannel":"",
      "occurarea":"",
      "operator":"",
      "operateTime":""
    },
    {
      "riskType":"",
      "usrNo":"",
      "validDate":"",
      "occurtimeb":"",
      "occurtimee":"",
      "occurchan":"",
      "note":"",
      "sourceChannel":"",
      "occurarea":"",
      "operator":"",
      "operateTime":""
    },
    ...
]
```

* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|resCode|同步状态码(详见附录)|String|
|resMsg|同步状态码说明|String|

* 响应报文示例：

```json
{
  "data": {},
  "resCode": "string",
  "resMsg": "string"
}
```

#### 4.1.4风险个人查询请求接口

>* 请求类型：POST
>* 请求路径：/localRisk/localRiskPer/query

* 请求报文字段

|字段名称|字段说明|参数类型|枚举|
|-------|------|-----|----|
|usrNo|内部用户号|String||
|mobileNo|手机号|String||
|docType|证件类型|String| 01:身份证 02:护照 03:军官证 04:户口簿 05:士兵证 06:港澳居民来往内地通行证 07:台湾同胞来往内地通行证 08:临时身份证 09:外国人居留证 10:警官证 11:港澳居民居住证 12:台湾居民居住证 99:其他|
|docCode|证件号码|String||
|operateStartTime|操作开始时间|Date||
|operateEndTime|操作结束时间|Date||
|submitStartTime|上报开始时间|Date||
|submitEndTime|上报结束时间|Date||
|submitStatus|报送状态|String||
|operator|操作人|String||

* 请求报文示例：

```json
{
    "usrNo":"",
    "mobileNo":"",
    "docType":"",
    "docCode":"",
    "operateStartTime":"",
    "operateEndTime":"",
    "submitStartTime":"",
    "submitEndTime":"",
    "submitStatus":"",
    "operator":""
}
```

* 响应报文字段

|字段名称|字段说明|参数类型|枚举|
|-------|------|-----|---|
|usrNo|内部用户号|String||
|mobileNo|手机号|String||
|cusName|个人姓名|String||
|cusProperty|客户属性|String|01：个人 02：商户 03: ETC 04：企业|
|riskType|风险类型|String|01：虚假申请（受害人信息） 02：虚假申请（嫌疑人信息） 03：伪卡（受害人信息） 04：失窃卡（受害人信息） 05：未达卡（受害人信息） 06：银行卡转移（受害人信息） 07：盗用银行卡（嫌疑人信息） 08：银行卡网络欺诈（受害人信息） 09：银行卡网络欺诈（嫌疑人信息） 10：虚拟账户被盗（受害人信息） 11：盗用虚拟账户（嫌疑人信息） 12：套现(嫌疑人信息) 13 ：协助转移赃款 14 ：买卖或租借银行（支付）账户 15：专案风险信息 17: 套利行为 18:发卡侧风险 19:伪造、变造票据 20:伪造、变造签章 21:ETC 恶意欠款(客车) 22:ETC 恶意欠款(货车) 23:套取 ETC 设备(嫌疑人信息) 24:套取 ETC 设备(受害人信息) 25:ETC 专案风险信息 26:跨境赌博账户 (受害人) 27:跨境赌博付款账户(参赌嫌疑人) 28:跨境赌博资金中转账户 (受害人) 29:跨境赌博资金中转账户(赌博庄家共同嫌疑人) 30：跨境赌博收款账户(赌博庄家) 31：电信网络诈骗 99 ：其他|
|docType|证件类型|String|01:身份证 02:护照 03:军官证 04:户口簿 05:士兵证 06:港澳居民来往内地通行证 07:台湾同胞来往内地通行证 08:临时身份证 09:外国人居留证 10:警官证 11:港澳居民居住证 12:台湾居民居住证 99:其他|
|docCode|证件号码|String||
|bankNo|付款账户/付款银行卡号（支付账户）|String||
|openBank|开户机构|String||
|validDate|有效期|Date||
|validStatus|有效性|String|01：有效 02：失效|
|occurtimeb|风险事件发生时间|Date||
|occurarea|风险事件发生地域|Date||
|note|风险事件描述|String||
|sourceChannel|风险信息来源渠道|String|GA:公检法等外部行政机构 RH:人民银行等监管机构 HY:会员机构 QS:清算机构 XH:协会风险模型预警 LHG:联合国 OFAC:美国财政部海外资产控制办公室 QT:其他|
|operator|操作人|String||
|operateTime|操作时间|Date||
|submitTime|上报时间|Date||
|submitStatus|报送状态|String||
|msgDetail|失败原因|String||

* 响应报文示例：

```json
{
  "resMsg": "success",
  "resCode": "000",
  "data": {
    "records": [
      {
        "usrNo": "",
        "mobileNo": "",
        "cusName": "",
        "cusProperty": "",
        "riskType": "",
        "docType": "",
        "docCode": "",
        "bankNo": "",
        "openBank": "",
        "validDate": "",
        "validStatus": "",
        "occurtimeb": "",
        "occurarea": "",
        "note": "",
        "sourceChannel": "",
        "operator": "",
        "operateTime": "",
        "submitTime": "",
        "submitStatus": "",
        "msgDetail": ""
      }
    ],
    "total": 1,
    "size": 10,
    "current": 1,
    "orders": [],
    "optimizeCountSql": true,
    "hitCount": false,
    "countId": null,
    "maxLimit": null,
    "searchCount": true,
    "pages": 0
  }
}
```

#### 4.1.5风险企业上报请求接口

>* 请求类型：POST
>* 请求路径：/localRisk/localRiskCom/sync

* 请求报文字段

|字段名称|字段说明|参数类型|枚举|
|-------|------|-----|---|
|riskType|风险类型|String|01: 企业开户行为异常 02: 企业开户信息异常 03: 境内外有权机构发布名单|
|payAccountNo|单位支付账户编号|String||
|occurtimeb|风险事件发生时间|Date||
|occurtimee|风险事件结束时间|Date||
|note|风险事件描述|String||
|sourceChannel|风险信息来源|String|GA:公检法等外部行政机构 RH:人民银行等监管机构 HY:会员机构 QS:清算机构 XH:协会风险模型预警 LHG:联合国 OFAC:美国财政部海外资产控制办公室 QT:其他|
|validDate|有效期|Date||
|operator|操作人|String||
|operateTime|操作时间|Date||

* 请求报文示例：

```json
[
    {
        "riskType": "",
        "paymentAccountNo": "",
        "occurtimeb": "",
        "occurtimee": "",
        "note|风险事件描述": "",
        "sourceChannel": "",
        "validDate": "",
        "operator": "",
        "operateTime": ""
    },
    {
        "riskType": "",
        "paymentAccountNo": "",
        "occurtimeb": "",
        "occurtimee": "",
        "note|风险事件描述": "",
        "sourceChannel": "",
        "validDate": "",
        "operator": "",
        "operateTime": ""
    },
    ...
]
```

* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|resCode|同步状态码(详见附录)|String|
|resMsg|同步状态码说明|String|

* 响应报文示例：

```json
{
  "data": {},
  "resCode": "string",
  "resMsg": "string"
}
```

#### 4.1.6风险企业查询请求接口

>* 请求类型：POST
>* 请求路径：/localRisk/localRiskCom/query

* 请求报文字段

|字段名称|字段说明|参数类型|枚举|
|-------|------|-----|---|
|cusCode|机构代码|String||
|regName|企业名称|String||
|docCode|法人证件号码|String||
|docType|法人证件类型|String|01:营业执照编码 02:统一社会信息代码 03:组织机构代码证 04:经营许可证 05：税务登记证 99:其他|
|submitStartTime|上报开始时间|Date||
|submitEndTime|上报结束时间|Date||
|submitStatus|报送状态|String||
|legDocCode|法定代表人证件类型|String||
|legDocType|法定代表人证件号码|String||
|operateStartTime|操作开始时间|Date||
|operateEndTime|操作结束时间|Date||
|operator|操作人|String||

* 请求报文示例：

```json
{
    "cusCode":"",
    "regName":"",
    "docCode":"",
    "docType":"",
    "submitStartTime":"",
    "submitEndTime":"",
    "submitStatus":"",
    "legDocCode":"",
    "legDocType":"",
    "operateStartTime":"",
    "operateEndTime":"",
    "operator":""
}
```

* 响应报文字段

|字段名称|字段说明|参数类型|枚举|
|-------|------|-----|----|
|cusCode|机构代码|String||
|cusName|企业简称|String||
|regName|企业简称|String||
|cusProperty|信息类型|String||
|riskType|风险类型|String|01: 企业开户行为异常 02: 企业开户信息异常 03: 境内外有权机构发布名单|
|docType|法人证件类型|String|01:营业执照编码 02:统一社会信息代码 03:组织机构代码证 04:经营许可证 05：税务登记证 99:其他|
|docCode|法人证件号码|String||
|legRepName|法定代表人姓名（负责人）|String||
|legDocType|法定代表人证件类型（负责人）|String||
|legDocCode|法定代表人证件号码（负责人）|String||
|regAddress|企业注册地址|String||
|validDate|有效期|Date||
|validStatus|有效性|String|01：有效 02：失效|
|occurtimeb|风险事件发生时间|Date||
|occurarea|风险事件发生地域|String||
|note|风险事件描述|String||
|sourceChannel|风险信息来源|String|GA:公检法等外部行政机构 RH:人民银行等监管机构 HY:会员机构 QS:清算机构 XH:协会风险模型预警 LHG:联合国 OFAC:美国财政部海外资产控制办公室 QT:其他|
|operator|操作人|String||
|operateTime|操作时间|Date||
|submitTime|上报时间|Date||
|submitStatus|报送状态|String||
|msgDetail|失败原因|String||

* 响应报文示例：

```json
{
  "resMsg": "success",
  "resCode": "000",
  "data": {
    "records": [
      {
        "cusCode":"",
        "cusName":"",
        "regName":"",
        "cusProperty":"",
        "riskType":"",
        "docType":"",
        "docCode":"",
        "legRepName":"",
        "legDocType":"",
        "legDocCode":"",
        "regAddress":"",
        "validDate":"",
        "validStatus":"",
        "occurtimeb":"",
        "occurarea":"",
        "note":"",
        "sourceChannel":"",
        "operator":"",
        "operateTime":"",
        "submitTime":"",
        "submitStatus":"",
        "msgDetail":""
      }
    ],
    "total": 1,
    "size": 10,
    "current": 1,
    "orders": [],
    "optimizeCountSql": true,
    "hitCount": false,
    "countId": null,
    "maxLimit": null,
    "searchCount": true,
    "pages": 0
  }
}
```

### 4.2协会风险商户共享

#### 4.2.1加黑推送sftp方式实现

>* 此接口获取数据先异步异步存储在数据库表中，然后推送到ftp服务器供给风控平台获取，
>*     blackList/Black_时间戳命名.txt:
>*     |推送日期|商户名称|商户简称|法人证件类型|法人证件号码|法定代表人姓名|法定代表人类型|法定代表人（负责人） 证件号码|风险信息等级|风险类型|有效期|有效性|商户类型|风险事件发生地域|银行结算账户|网址|商户注册号|

#### 4.2.2风险商户查询

>* 请求类型：POST
>* 请求路径：/isocRisk/isocRiskReg/query

* 请求报文字段

|字段名称|字段说明|参数类型|枚举|
|-------|------|-----|---|
|regName|商户名称|String||
|legDocCode|法定代表人证件号码|String||
|docCode|法人证件号码|String||
|pushStartTime|推送开始时间|Date||
|pushEndTime|推送结束时间|Date||
|docType|法人证件类型|String|01:营业执照编码 02:统一社会信息代码 03:组织机构代码证 04:经营许可证 05：税务登记证 99:其他|
|legDocType|法定代表人证件类型（负责人）|String||

* 请求报文示例：

```json
{
    "regName":"",
    "legDocCode":"",
    "docCode":"",
    "pushStartTime":"",
    "pushEndTime":"",
    "docType":"",
    "legDocType":""
}
```

* 响应报文字段

|字段名称|字段说明|参数类型|枚举|
|-------|------|-----|----|
|pushListType|推送名单类型|String||
|upDate|推送日期|Date||
|level|风险信息等级|String||
|riskType|风险类型|String|01 ：虚假申请 02 ：套现、套积分 03 ：违法违规经营 04 ：销赃或协助转移赃款 05 ： 买卖或租借银行（支付）账户 06 ：侧录点(恶意) 07 ：伪卡集中使用点(恶意) 08 ：泄露账户及交易信息 09 ：恶意倒闭 10：恶意分单 11 ：移机 12 ：高风险商户 13 ：商户合谋欺诈  14 ：破产或停业商户 15 ：强迫交易 17：频繁变更服务机构 18：关联商户涉险 19：买卖银行卡信息 20：拒刷信用卡 21：转嫁手续费 22:支付敏感信息泄露 23:非法改装终端 24:切机 25:二清 26:套码 27:冒用申请 28:侧录点(非恶意) 29:洗钱行为 30:套汇 31:逃汇 32:骗汇 33:分拆交易 34:按金交易 35:境内外有权机构发布名单 36:发卡侧风险 37:恶意注册 38:伪造、变造票据 39:伪造、变造签章 40:跨境支付虚假、盗用或冒用申请 41:跨境支付大额交易客户、异常客户 42:跨境赌博 43:跨境赌博资金中转 44:伪卡集中使用点(非恶意) 45:受理终端(网络支付接口、收款码)挪作违法违规用途 46：赌博 47：赌博资金中转 99：其他|
|cusName|商户简称|String||
|regName|商户名称|String||
|docType|法人证件类型|String|01:营业执照编码 02:统一社会信息代码 03:组织机构代码证 04:经营许可证 05：税务登记证 99:其他|
|docCode|法人证件号码|String||
|legRepName|法人（负责人）代表姓名|String||
|legDocType|法人（负责人）证件类型|String||
|legDocCode|法人（负责人）证件号码|String||
|validDate|有效期|Date||
|validStatus|有效性|String|01：有效 02：失效|
|cusType|商户类型|String|01:自然人 02:企业商户 03:个体工商户 04:境外企业商户|
|occurarea|风险事件发生地域|String||

* 响应报文示例：

```json
{
  "resMsg": "success",
  "resCode": "000",
  "data": {
    "records": [
      {
        "pushListType":"",
        "pushDate":"",
        "level":"",
        "riskType":"",
        "cusName":"",
        "regName":"",
        "docType":"",
        "docCode":"",
        "legRepName":"",
        "legDocType":"",
        "legDocCode":"",
        "validDate":"",
        "validStatus":"",
        "cusType":"",
        "occurarea":""
      }
    ],
    "total": 1,
    "size": 10,
    "current": 1,
    "orders": [],
    "optimizeCountSql": true,
    "hitCount": false,
    "countId": null,
    "maxLimit": null,
    "searchCount": true,
    "pages": 0
  }
}
```

#### 4.2.3风险信息补发

>* 请求类型：POST
>* 请求路径：/localRisk/localRiskMsg/

* 请求报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|occurtimeb|风险事件发生时间|Date|
|occurtimee|风险事件结束时间|Date|
|riskType|补发信息类型|String|

* 请求报文示例：

```json
{
    "reqDate":"",
    "reqDateEnd":"",
    "riskType":""
}
```

* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|resCode|同步状态码(详见附录)|String|
|resMsg|同步状态码说明|String|

* 响应报文示例：

```json
{
  "data": {},
  "resCode": "string",
  "resMsg": "string"
}
```

### 4.3本地商户关联反馈

#### 4.3.1本地关联风险商户查询

>* 请求类型：POST
>* 请求路径：/localRisk/localRiskMsg/query

* 请求报文字段

|字段名称|字段说明|参数类型|枚举|
|-------|------|-----|---|
|cusCode|商户编号|String||
|regName|商户名称|String||
|docCode|法人证件号码|String||
|docType|法人证件类型|String|01:营业执照编码 02:统一社会信息代码 03:组织机构代码证 04:经营许可证 05：税务登记证 99:其他|
|legDocType|法人（负责人）证件类型|String||
|legDocCode|法人（负责人）证件号码|String||
|riskType|风险类型|String|01 ：虚假申请 02 ：套现、套积分 03 ：违法违规经营 04 ：销赃或协助转移赃款 05 ： 买卖或租借银行（支付）账户 06 ：侧录点(恶意) 07 ：伪卡集中使用点(恶意) 08 ：泄露账户及交易信息 09 ：恶意倒闭 10：恶意分单 11 ：移机 12 ：高风险商户 13 ：商户合谋欺诈  14 ：破产或停业商户 15 ：强迫交易 17：频繁变更服务机构 18：关联商户涉险 19：买卖银行卡信息 20：拒刷信用卡 21：转嫁手续费 22:支付敏感信息泄露 23:非法改装终端 24:切机 25:二清 26:套码 27:冒用申请 28:侧录点(非恶意) 29:洗钱行为 30:套汇 31:逃汇 32:骗汇 33:分拆交易 34:按金交易 35:境内外有权机构发布名单 36:发卡侧风险 37:恶意注册 38:伪造、变造票据 39:伪造、变造签章 40:跨境支付虚假、盗用或冒用申请 41:跨境支付大额交易客户、异常客户 42:跨境赌博 43:跨境赌博资金中转 44:伪卡集中使用点(非恶意) 45:受理终端(网络支付接口、收款码)挪作违法违规用途 46：赌博 47：赌博资金中转 99：其他|
|status|反馈状态|String||
|pushListType|推送名单类型|String||
|feedbackStartDate|反馈开始日期|Date||
|feedbackEndDate|反馈结束日期|Date||
|pushStartDate|推送开始日期|Date||
|pushEndDate|推送结束日期|Date||

* 请求报文示例：

```json
{
    "cusCode":"",
    "regName":"",
    "docCode":"",
    "docType":"",
    "legDocType":"",
    "legDocCode":"",
    "riskType":"",
    "status":"",
    "pushListType":"",
    "feedbackStartDate":"",
    "feedbackEndDate":"",
    "pushStartDate":"",
    "pushEndDate":""
}
```

* 响应报文字段

|字段名称|字段说明|参数类型|枚举|
|-------|------|-----|---|
|cusCode|商户编号|String||
|pushListType|推送名单类型|String||
|upDate|推送日期|Date||
|level|风险信息等级|String||
|riskType|风险类型|String|01 ：虚假申请 02 ：套现、套积分 03 ：违法违规经营 04 ：销赃或协助转移赃款 05 ： 买卖或租借银行（支付）账户 06 ：侧录点(恶意) 07 ：伪卡集中使用点(恶意) 08 ：泄露账户及交易信息 09 ：恶意倒闭 10：恶意分单 11 ：移机 12 ：高风险商户 13 ：商户合谋欺诈  14 ：破产或停业商户 15 ：强迫交易 17：频繁变更服务机构 18：关联商户涉险 19：买卖银行卡信息 20：拒刷信用卡 21：转嫁手续费 22:支付敏感信息泄露 23:非法改装终端 24:切机 25:二清 26:套码 27:冒用申请 28:侧录点(非恶意) 29:洗钱行为 30:套汇 31:逃汇 32:骗汇 33:分拆交易 34:按金交易 35:境内外有权机构发布名单 36:发卡侧风险 37:恶意注册 38:伪造、变造票据 39:伪造、变造签章 40:跨境支付虚假、盗用或冒用申请 41:跨境支付大额交易客户、异常客户 42:跨境赌博 43:跨境赌博资金中转 44:伪卡集中使用点(非恶意) 45:受理终端(网络支付接口、收款码)挪作违法违规用途 46：赌博 47：赌博资金中转 99：其他|
|cusName|商户简称|String||
|regName|商户名称|String||
|handleResult|处理结果|String|01. 终止合作 02. 拒绝拓展 03. 暂停办理资金结算 04. 冻结账户 05. 调整结算周期 06. 延迟资金结算 07. 设置收款限额 08. 暂停银行卡交易 09. 收回受理终端 (关闭网络支付接口) 10. 暂未采取控制措施,持续关注客户 11. 报送反洗钱可疑交易 99. 其他|
|feedbackStatus|反馈状态||
|feedbackDate|反馈日期|Date||
|docType|法人证件类型|String|01:营业执照编码 02:统一社会信息代码 03:组织机构代码证 04:经营许可证 05：税务登记证 99:其他|
|docCode|法人证件号码|String||
|legRepName|法人（负责人）代表姓名|String||
|legDocType|法定代表人证件类型|String||
|legDocCode|法定代表人证件号码|String||
|validDate|有效期|Date||
|validStatus|有效性|String|01：有效 02：失效|
|cusType|商户类型|String|01:自然人 02:企业商户 03:个体工商户 04:境外企业商户|
|occurarea|风险事件发生地域|String||
|assMerNumber|关联商户编号|String||
|status|商户状态|String|01.启用、 02.关闭（暂停） 03.注销|
|isBlack|是否加黑|String||
|assFieldCnt|关联字段个数|String||
|assFieldName|关联字段名称|String||
|operator|操作人|String||
|msgDetail|失败原因|String||
|Amount|涉及结算金额(后台计算)|String||

* 响应报文示例：

```json
{
  "resMsg": "success",
  "resCode": "000",
  "data": {
    "records": [
      {
        "cusCode":"",
        "pushListType":"",
        "pushDate":"",
        "level":"",
        "riskType":"",
        "cusName":"",
        "regName":"",
        "handleResult":"",
        "feedbackStatus":"",
        "feedbackDate":"",
        "pushDate":"",
        "docType":"",
        "docCode":"",
        "legRepName":"",
        "legDocType":"",
        "legDocCode":"",
        "validDate":"",
        "validStatus":"",
        "cusType":"",
        "occurarea":"",
        "assMerNumber":"",
        "status":"",
        "isBlack":"",
        "assFieldCnt":"",
        "assFieldName":"",
        "operator":"",
        "msgDetail":"",
        "Amount":""
      }
    ],
    "total": 1,
    "size": 10,
    "current": 1,
    "orders": [],
    "optimizeCountSql": true,
    "hitCount": false,
    "countId": null,
    "maxLimit": null,
    "searchCount": true,
    "pages": 0
  }
}
```

#### 4.3.2本地关联风险商户反馈

>* 请求类型：POST
>* 请求路径：/localRisk/localRiskMsg/back

* 请求报文字段

|字段名称|字段说明|参数类型|枚举|
|-------|------|-----|----|
|docType|法人证件类型|String|01:营业执照编码 02:统一社会信息代码 03:组织机构代码证 04:经营许可证 05：税务登记证 99:其他|
|docCode|法人证件号码|String||
|Amount|涉及结算金额(后台计算)|String||
|handleResult|处理结果|String|01. 终止合作 02. 拒绝拓展 03. 暂停办理资金结算 04. 冻结账户 05. 调整结算周期 06. 延迟资金结算 07. 设置收款限额 08. 暂停银行卡交易 09. 收回受理终端 (关闭网络支付接口) 10. 暂未采取控制措施,持续关注客户 11. 报送反洗钱可疑交易 99. 其他|
|operator|操作人|String||

* 请求报文示例：

```json
{
    "docType":"",
    "docCode":"",
    "Amount":"",
    "handleResult":"",
    "operator":""
}
```

* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|resCode|同步状态码(详见附录)|String|
|resMsg|同步状态码说明|String|

* 响应报文示例：

```json
{
  "data": {},
  "resCode": "string",
  "resMsg": "string"
}
```

### 4.4查询商户风险信息及反馈

#### 4.4.1查询商户风险信息

>* 请求类型：POST 
>* 请求路径：/isocRisk/isocRegRisk/query

* 请求报文字段

|字段名称|字段说明|参数类型|枚举|
|-------|------|-----|----|
|cusProperty|客户属性|String|01：个人 02：商户 03: ETC 04：企业|
|keyWord|关键字|String|01：商户简称 03：法人证件号码 04：服务器 IP 05：法定代表人（负责人）手机号 06：商户名称 07：法定代表人（负责人）证件号码 08：银行结算账号 09：网址 10：ICP 备案编号|
|infos|查询条件信息（多条数据以逗号分隔）|String||

* 请求报文示例：

```json
{
    "cusProperty":"",
    "keyWord":"",
    "infos":""
}
```

* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|resCode|同步状态码(详见附录)|String|
|resMsg|同步状态码说明|String|

* 响应报文示例：

```json
{
  "data": {},
  "resCode": "string",
  "resMsg": "string"
}
```

>* 此接口获取数据先异步异步存储在数据库表中，然后推送到ftp服务器供给风控平台获取，
>*     Risk/Risk_时间戳命名.txt:
>*     |风险反馈主键编码|商户类型|客户属性|风险类型|商户属性|商户名称|涉及结算金额|法人证件类型|法人证件号码|法定代表人姓名|法定代表人（负责人）证件类型|法定代表人（负责人）证件号码|有效期|有效性|风险事件发生时间|风险事件结束时间|风险事件发生渠道|风险事件发生地域|风险信息来源渠道|风险事件描述|终止合作的机构数量|拒绝拓展的机构数量|暂停办理资金结算的机构数量|冻结账户的机构数量|调整结算周期的机构数量|延迟资金结算的机构数量|设置收款限额的机构数量|暂停银行卡交易的机构数量|收回受理终端 (关闭网络支付接口) 的机构数量|暂未采取控制措施,持续关注客户的机构数量|报送反洗钱可疑交易的机构数量|其他的机构数量|交易金额|商户编号（和包侧商户编号，多个时用，隔开）|商户个数（和包侧商户编号个数）|涉及结算金额（参考查询时间，近90天内结算和包侧多个商户编号总金额）|操作人|操作时间|

>* 注意涉及结算金额是大数据方计算近90天的交易金额，查询的时候需要自己从库里获取值。

#### 4.4.2商户风险信息查询使用情况查询

>* 请求类型：POST
>* 请求路径：/isocRisk/isocRegRisk/query

>* 请求报文字段

|字段名称|字段说明|参数类型|
|---|---|---|
|id|风险反馈主键编码|String|
|cusType|商户类型|String|
|cusCode|商户编号（模糊查询）|String|
|feedbackStartDate|反馈开始日期|Date|
|feedbackEndDate|反馈结束日期|Date|
|feedbackStatus|反馈状态|String|

>* 请求报文示例：

```json
{
    "id": "",
    "cusType": "",
    "cusCode": "",
    "feedbackStartDate": "",
    "feedbackEndDate": "",
    "feedbackStatus": ""
}
```

>* 响应报文字段

|字段名称|字段说明|参数类型|枚举|
|-------|------|-----|-----|
|id|风险反馈主键编码|String||
|cusType|商户类型|String|01:自然人 02:企业商户 03:个体工商户 04:境外企业商户|
|cusProperty|客户属性|String|01：个人 02：商户 03: ETC 04：企业|
|riskType|风险类型|String|01 ：虚假申请 02 ：套现、套积分 03 ：违法违规经营 04 ：销赃或协助转移赃款 05 ： 买卖或租借银行（支付）账户 06 ：侧录点(恶意) 07 ：伪卡集中使用点(恶意) 08 ：泄露账户及交易信息 09 ：恶意倒闭 10：恶意分单 11 ：移机 12 ：高风险商户 13 ：商户合谋欺诈  14 ：破产或停业商户 15 ：强迫交易 17：频繁变更服务机构 18：关联商户涉险 19：买卖银行卡信息 20：拒刷信用卡 21：转嫁手续费 22:支付敏感信息泄露 23:非法改装终端 24:切机 25:二清 26:套码 27:冒用申请 28:侧录点(非恶意) 29:洗钱行为 30:套汇 31:逃汇 32:骗汇 33:分拆交易 34:按金交易 35:境内外有权机构发布名单 36:发卡侧风险 37:恶意注册 38:伪造、变造票据 39:伪造、变造签章 40:跨境支付虚假、盗用或冒用申请 41:跨境支付大额交易客户、异常客户 42:跨境赌博 43:跨境赌博资金中转 44:伪卡集中使用点(非恶意) 45:受理终端(网络支付接口、收款码)挪作违法违规用途 46：赌博 47：赌博资金中转 99：其他|
|cusNature|商户属性|String|01 实体特约商户 02 网络特约商户 03 实体兼网络特约商户|
|regName|商户名称|String||
|cusCode|商户编码|String||
|submitAmount|涉及结算金额(后台计算)|String||
|docType|法人证件类型|String|01:营业执照编码 02:统一社会信息代码 03:组织机构代码证 04:经营许可证 05：税务登记证 99:其他|
|docCode|法人证件号码|String||
|legDocType|法人（负责人）证件类型|String||
|legDocCode|法人（负责人）证件号码|String||
|legRepName|法定代表人姓名（负责人）|String||
|count|返回数量|String||
|isTransfer|是否中转账户|String||
|bankNo|银行账号|String||
|openBank|开户行|String||
|url|网址|String||
|serverIp|服务器 IP|String||
|mobileNo|法定代表人（负责人）手机号|String||
|address|商户实际办公地|String||
|icp|ICP 备案编号|String||
|level|信息级别|String|01：一级 02：二级 03：三级|
|occurtimeb|风险事件发生时间|Date||
|occurtimee|风险事件结束时间|Date||
|occurchan|风险事件发生渠道|String|01、线上 02、线下 03 线上兼线下|
|occurarea|风险事件发生地域|String||
|note|风险事件描述|String||
|validDate|有效期|Date||
|validStatus|有效性|String|01：有效 02：失效|
|stopNum|终止合作的机构数量|String||
|refuseNum|拒绝拓展的机构数量|String||
|useRiseNum|暂停办理资金结算的机构数量|String||
|frozenNum|冻结账户的机构数量|String||
|adjustmentCycleNum|调整结算周期的机构数量|String||
|delayNum|延迟资金结算的机构数量|String||
|quotaNum|设置收款限额的机构数量|String||
|suspendNum|暂停银行卡交易的机构数量|String||
|closeNum|收回受理终端 (关闭网络支付接口) 的机构数量 |String||
|followNum|暂未采取控制措施,持续关注客户的机构数量|String||
|antiMoneyNum|报送反洗钱可疑交易的机构数量|String||
|otherNum|其他的机构数量|String||
|registeredArea|商户注册国家或地区|String|AD:安道尔 AE:阿联酋 AF:阿富汗 AG:安提瓜和巴布达 AI:安圭拉 AL:阿尔巴尼亚 ...|
|registeredCode|商户注册号码|String||
|sourceChannel|风险信息来源|String|GA:公检法等外部行政机构 RH:人民银行等监管机构 HY:会员机构 QS:清算机构 XH:协会风险模型预警 LHG:联合国 OFAC:美国财政部海外资产控制办公室 QT:其他|
|amount|交易金额|String||
|riskFindTime|风险事件发现时间|Date||
|legControlName|实控人姓名|String||
|legControlCardType|实控人证件类型|String||
|legControlCardCode|实控人证件号|String||
|remarks|备注|String||
|count|返回总数量|String||
|legBenName|受益人姓名|String||
|legBenCardType|受益人证件类型|String||
|legBenCardCode|受益人证件号|String||
|handleResult|处理结果|String|01. 终止合作 02. 拒绝拓展 03. 暂停办理资金结算 04. 冻结账户 05. 调整结算周期 06. 延迟资金结算 07. 设置收款限额 08. 暂停银行卡交易 09. 收回受理终端 (关闭网络支付接口) 10. 暂未采取控制措施,持续关注客户 11. 报送反洗钱可疑交易 99. 其他|
|feedbackStatus|反馈状态|String||
|feedbackDate|反馈日期|Date||
|operator|操作人|String||
|errInfo|失败原因|String||

* 响应报文示例：

```json
{
  "resMsg": "success",
  "resCode": "000",
  "data": {
    "records": [
      {
        "id":"",
        "cusType":"",
        "cusProperty":"",
        "riskType":"",
        "cusNature":"",
        "regName":"",
        "cusCode":"",
        "submitAmount":"",
        "docType":"",
        "docCode":"",
        "legDocType":"",
        "legDocCode":"",
        "legRepName":"",
        "count":"",
        "isTransfer":"",
        "bankNo":"",
        "openBank":"",
        "url":"",
        "serverIp":"",
        "mobileNo":"",
        "address":"",
        "icp":"",
        "level":"",
        "occurtimeb":"",
        "occurtimee":"",
        "occurchan":"",
        "occurarea":"",
        "note":"",
        "validDate":"",
        "validStatus":"",
        "stopNum":"",
        "refuseNum":"",
        "useRiseNum":"",
        "frozenNum":"",
        "adjustmentCycleNum":"",
        "delayNum":"",
        "quotaNum":"",
        "suspendNum":"",
        "closeNum":"",
        "followNum":"",
        "antiMoneyNum":"",
        "otherNum":"",
        "registeredArea":"",
        "registeredCode":"",
        "sourceChannel":"",
        "amount":"",
        "riskFindTime":"",
        "legControlName":"",
        "legControlCardType":"",
        "legControlCardCode":"",
        "remarks":"",
        "count":"",
        "legBenName":"",
        "legBenCardType":"",
        "legBenCardCode":"",
        "handleResult":"",
        "feedbackStatus":"",
        "feedbackDate":"",
        "operator":"",
        "errInfo":""
      }
    ],
    "total": 1,
    "size": 10,
    "current": 1,
    "orders": [],
    "optimizeCountSql": true,
    "hitCount": false,
    "countId": null,
    "maxLimit": null,
    "searchCount": true,
    "pages": 0
  }
}
```

#### 4.4.3商户风险信息查询使用情况反馈

>* 请求类型：POST
>* 请求路径：/isocRisk/isocRegRisk/back

* 请求报文字段

|字段名称|字段说明|参数类型|枚举|
|-------|------|-----|----|
|id|风险反馈主键编码|String||
|cusType|商户类型|String|01:自然人 02:企业商户 03:个体工商户 04:境外企业商户|
|amount|涉及结算金额（参考查询时间，近90天内结算总金额）|String||
|handleResult|处理结果|String|01. 终止合作 02. 拒绝拓展 03. 暂停办理资金结算 04. 冻结账户 05. 调整结算周期 06. 延迟资金结算 07. 设置收款限额 08. 暂停银行卡交易 09. 收回受理终端 (关闭网络支付接口) 10. 暂未采取控制措施,持续关注客户 11. 报送反洗钱可疑交易 99. 其他|
|handleTime|处理时间 YYYY-MM-DD|Date||
|currency|交易币种|String|CNY:人民币 USD:美元 EUR:欧元 GBP:英镑 AUD:澳元 ……|

>* 请求报文示例：

```json
{
    "id":"",
    "cusType":"",
    "amount":"",
    "handleResult":"",
    "handleTime":"",
    "currency":""
}
```

* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|resCode|同步状态码(详见附录)|String|
|resMsg|同步状态码说明|String|

* 响应报文示例：

```json
{
  "data": {},
  "resCode": "string",
  "resMsg": "string"
}
```

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

>* 请求报文示例：

```json
{
    "regName":"",
    "docCode":"",
    "legDocName":"",
    "legDocCode":""
}
```

* 响应报文字段

|字段名称|字段说明|参数类型|
|-------|------|-----|
|resCode|同步状态码(详见附录)|String|
|resMsg|同步状态码说明|String|

* 响应报文示例：

```json
{
  "data": {},
  "resCode": "string",
  "resMsg": "string"
}
```

>* 大数据平台与特约商户系统相关接口统一按照支付清算协会接口规范开发。
>* [支付清算综合服务平台系统接口规范V3.2.1(修订版).pdf](doc/支付清算综合服务平台系统接口规范V3.2.1(修订版).pdf)

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
|操作时间| created_time | 操作时间 | Date |
|操作内容| opt_content  | 操作内容 | varchar(128) |
|更新人| updated_by | 更新人 | varchar(32) |
|更新时间| updated_time | 更新时间 | Date |

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

(待确认 sftp服务器)
>* sftp服务IP：localhost
>* sftp服务port：8090
>* sftp服务用户名：root
>* sftp服务密码：root
>* sftp服务获取目录：/Blacklist和/Risk

数据加解密算法接口开发
