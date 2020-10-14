package com.cmcc.paymentclean.service.impl;

import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.resquest.BusinessInfoReq;
import com.cmcc.paymentclean.service.BusinessInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/** Created by lumma on 2020/9/22. */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@ActiveProfiles("dev")
class BusinessInfoServiceImplTest {

  @Autowired private BusinessInfoService businessInfoService;

  @Test
  void testBusinessInfo2() {
    List<BusinessInfoReq> businessInfoReqs = new ArrayList<>();
    BusinessInfoReq req = new BusinessInfoReq();
    //req.setRegName("123");
    req.setDocCode("123456123456123456");
    businessInfoReqs.add(req);
    businessInfoService.batchQuery(businessInfoReqs);
    //        2020-09-22 22:28:52.419 [ INFO] 19104 --- [scheduling-1] c.c.p.u.HttpClientUtils
    //            : Post请求url：http://210.12.239.161:10001/ries_interface/httpServlet
    //        2020-09-22 22:28:52.419 [ INFO] 19104 --- [scheduling-1] c.c.p.u.HttpClientUtils
    //            : Post请求params：<?xml version="1.0"
    // encoding="UTF-8"?><Document><Request><Head><Version>V1.3.0</Version><Identification>202009226427330728</Identification><OrigSender>Z2004343000017</OrigSender><OrigSenderSID>zf_sysstem</OrigSenderSID><RecSystemId>R0001</RecSystemId><TrnxCode>QE0004</TrnxCode><TrnxTime>20200922222847</TrnxTime><UserToken>Io2lrHofKybUc%2BmKeG6qo%2FMQwXMQTOQ6IwrnIfgvhyHTf2SAN63W0wKbw%2FODal5I</UserToken><SecretKey>etPTlniuwy+rZgYt2UOPGKw5YeVgDL7bNORdC8wT4CGg8ZMNqCYhWLr5H6rf4X7nEqEkqDzEEaDwUZLHEgh6lqoz2N4KN0OEglCPHGBIo1opuwsHODraH39LKIiOTP/mWyQOPWOdogyoX7CMbh1S0MSxwQMPUc5IVT7WSKGtk2f1I/qVTSNew0rPvLgcG7FabD9XWQWUvwW4J5T6zmNmQlrx7dOdbYTMgbBBG8JnzICRMZv97Hoi1vIDhf5JPu3WFEpkGa3u7DFFIEO0RzA5tBi50vgmdVwFdUUE4BaUb8rHKaPJGc5auXMcComdD43QBRXHn3+SyphYPTP/6hettw==</SecretKey></Head><Body><PcacList><Count>1</Count><BaseInfo><DocCode></DocCode><RegName>MPW48HaZjoZsbGw1AZcdYA==</RegName><LegDocCode></LegDocCode><LegDocName></LegDocName></BaseInfo></PcacList></Body></Request><Signature>LHTUTSxsVDjz3xA6FrJar4HWa5FHyyCpwUURNhBuugUeOIGbR8r+ZKfKudV+s5OPBdLYkSphCElGxUy4zawn9spwAzrB/rX0/d37yFqkivDL6Za7WNhwOLnTQXZhE46eZUoggJotKCIFmTRKZhnKntiO2FH4An9dhRYx9TrYXpik8YKS2tBvKBMoeTpVSdOt/np1MEaxNfMcIi2XUfuqmA/MYxG2ldF1VeX4NGB4WMXlf//d47M3hW81Vh3Hp/jYdvJaAFpQPfE8GB9npscuHBN0REj8O/42lHoawSsGxq8sanbfRdsQxViQjItdfiUSADQnCHDsh69IeDf1aFQj5A==</Signature></Document>
    //        2020-09-22 22:28:53.011 [ INFO] 19104 --- [scheduling-1] c.c.p.u.HttpClientUtils
    //            : HttpClient响应码=200
    //        2020-09-22 22:28:53.013 [ INFO] 19104 --- [scheduling-1] c.c.p.u.HttpClientUtils
    //            : HttpClient请求结果：<?xml version="1.0"
    // encoding="UTF-8"?><Document><Respone><Head><Version>V1.3.0</Version><Identification>202009226427330728</Identification><OrigSender>Z2004343000017</OrigSender><OrigSenderSID>zf_sysstem</OrigSenderSID><RecSystemId>R0001</RecSystemId><TrnxCode>QE0004</TrnxCode><TrnxTime>20200922222853</TrnxTime><SecretKey>etPTlniuwy+rZgYt2UOPGKw5YeVgDL7bNORdC8wT4CGg8ZMNqCYhWLr5H6rf4X7nEqEkqDzEEaDwUZLHEgh6lqoz2N4KN0OEglCPHGBIo1opuwsHODraH39LKIiOTP/mWyQOPWOdogyoX7CMbh1S0MSxwQMPUc5IVT7WSKGtk2f1I/qVTSNew0rPvLgcG7FabD9XWQWUvwW4J5T6zmNmQlrx7dOdbYTMgbBBG8JnzICRMZv97Hoi1vIDhf5JPu3WFEpkGa3u7DFFIEO0RzA5tBi50vgmdVwFdUUE4BaUb8rHKaPJGc5auXMcComdD43QBRXHn3+SyphYPTP/6hettw==</SecretKey></Head><Body><RespInfo><ResultStatus>01</ResultStatus><ResultCode>S00000</ResultCode><ResultSequence>rGnfRobTLOQGiAUqQM65BXEJIO8uEg/+UhygKtQ3TD26MlNBaaZm4ZFz9JOxMoVR</ResultSequence></RespInfo></Body></Respone><Signature>Ht5z6L8/AFDY2cJx+MGF0FT0q3Wri1Bxp3KadRJ6sU668VAqfPksnA7LnID1DZzb31/8E1UCuptymFWPU4XuyihaszFDl9X2bOS1jjDb2Hnc3NPqggIcjuKFuc1Cz4RcH9KQaG1vSS+BzCrqpq8ow8UZvTFBksT5AxIIiTJ6oILRJWpdWRBxANFj+iLXMmAZmw7x8ivHsE0hvlGD8JNHKErlxkeSD55NfABqbYtR9MVAo8ukn0fQCrkliZaIZ++rr4K6asxsVuotXI9EGcmW0L6BlCX0I6rdVnpCS8ryXzsmU+MBPRAwCPtlRAi2+YFjM6T+zdSJKDr85rmIBPkGaw==</Signature></Document>
    //        2020-09-22 22:28:53.013 [ INFO] 19104 --- [scheduling-1]
    // c.c.p.s.i.BusinessInfoServiceImpl        :
    // url:http://210.12.239.161:10001/ries_interface/httpServlet
    //        2020-09-22 22:28:53.029 [ INFO] 19104 --- [scheduling-1]
    // c.c.p.s.i.BusinessInfoServiceImpl        :
    // 协会返回数据对象:Document(Respone=Respone(Head=Head(Version=V1.3.0,
    // Identification=202009226427330728, OrigSender=Z2004343000017, OrigSenderSID=zf_sysstem,
    // RecSystemId=R0001, TrnxCode=QE0004, TrnxTime=20200922222853,
    // SecretKey=etPTlniuwy+rZgYt2UOPGKw5YeVgDL7bNORdC8wT4CGg8ZMNqCYhWLr5H6rf4X7nEqEkqDzEEaDwUZLHEgh6lqoz2N4KN0OEglCPHGBIo1opuwsHODraH39LKIiOTP/mWyQOPWOdogyoX7CMbh1S0MSxwQMPUc5IVT7WSKGtk2f1I/qVTSNew0rPvLgcG7FabD9XWQWUvwW4J5T6zmNmQlrx7dOdbYTMgbBBG8JnzICRMZv97Hoi1vIDhf5JPu3WFEpkGa3u7DFFIEO0RzA5tBi50vgmdVwFdUUE4BaUb8rHKaPJGc5auXMcComdD43QBRXHn3+SyphYPTP/6hettw==), Body=Body(RespInfo=RespInfo(ResultStatus=01, ResultCode=S00000, UserToken=null, MsgDetail=null, ResultSequence=rGnfRobTLOQGiAUqQM65BXEJIO8uEg/+UhygKtQ3TD26MlNBaaZm4ZFz9JOxMoVR), QueryInfo=null, PcacList=null)), Signature=Ht5z6L8/AFDY2cJx+MGF0FT0q3Wri1Bxp3KadRJ6sU668VAqfPksnA7LnID1DZzb31/8E1UCuptymFWPU4XuyihaszFDl9X2bOS1jjDb2Hnc3NPqggIcjuKFuc1Cz4RcH9KQaG1vSS+BzCrqpq8ow8UZvTFBksT5AxIIiTJ6oILRJWpdWRBxANFj+iLXMmAZmw7x8ivHsE0hvlGD8JNHKErlxkeSD55NfABqbYtR9MVAo8ukn0fQCrkliZaIZ++rr4K6asxsVuotXI9EGcmW0L6BlCX0I6rdVnpCS8ryXzsmU+MBPRAwCPtlRAi2+YFjM6T+zdSJKDr85rmIBPkGaw==)
  }

  @Test
  void test() {
    businessInfoService.queryBusinessInfoAndPushPcac();
    //        2020-09-23 13:08:48.398 [ INFO] 23068 --- [scheduling-1] c.c.p.u.HttpClientUtils
    //            : Post请求url：http://210.12.239.161:10001/ries_interface/httpServlet
    //        2020-09-23 13:08:48.399 [ INFO] 23068 --- [scheduling-1] c.c.p.u.HttpClientUtils
    //            : Post请求params：<?xml version="1.0"
    // encoding="UTF-8"?><Document><Request><Head><Version>V1.3.0</Version><Identification>202009239274253230</Identification><OrigSender>Z2004343000017</OrigSender><OrigSenderSID>zf_sysstem</OrigSenderSID><RecSystemId>R0001</RecSystemId><TrnxCode>EER001</TrnxCode><TrnxTime>20200923130847</TrnxTime><UserToken>Io2lrHofKybUc%2BmKeG6qo%2FMQwXMQTOQ6IwrnIfgvhyHTf2SAN63W0wKbw%2FODal5I</UserToken><SecretKey>jYJex/iEu7RZ+X29EXxoq3mwOCkHnYaxo/onWlyLiVNqHLsp1PId4ILrOeue6ES6RabqFpD2u3vW+Dru8glpKDHpNngdPWpYmpOpzU+zlDLM0q4aRsT+0hSGF8FnbXcCGpjK2IG5q8oh0oGdtczSk3cnVB0a9RwfHL6ORaUb+5r/dzf7x4vRZmmNTkj4WtIMMzdYiAKpnuKDMUfkaRz0CCtwCc4zh2yTZEbrmYTfvYNDYs0LshnR0TNLBSYVVIgFjNDFzjdGYC1eRnTHem7rRfctYnCAbb7ziy8iq9SJiPnK0kWdqsAhV6lOhb3cIg3DWwxBin+YYcLOUkywAgXxHw==</SecretKey></Head><Body><PcacList><Count>2</Count><BaseInfo><CusType>02</CusType><CusNature>01</CusNature><RegName>TyPxjdo/iWZnCsuE2XCDIg==</RegName><CusName>5nhYBN9zyUed2k2/ldT6JA==</CusName><CusNameEn>5nhYBN9zyUed2k2/ldT6JA==</CusNameEn><DocType>02</DocType><DocCode>/i5siiTifm7PCDTC2a430h97vOMyeS613ny0gsSquMY=</DocCode><LegDocName>qf8lBdN+pTx3sUBZKvRB0w==</LegDocName><LegDocType>01</LegDocType><LegDocCode>/i5siiTifm7PCDTC2a430h97vOMyeS613ny0gsSquMY=</LegDocCode><CusCode>NgDHuJqw/Cn2Gz9zaiMVjfOuKFQS2QbuDrqb2vEJG0A=</CusCode><InduType>商户行业类别</InduType><BankNo>TkpFOX3CM4scWsMooTON+g==</BankNo><OpenBank>招商银行</OpenBank><RegAddrProv>110000</RegAddrProv><RegAddrDetail>WaRIOcQu2AvjcAm/31V2oSFmf2cLNI17jItyzoAzZiw=</RegAddrDetail><AddrProv>1</AddrProv><AddrDetail>zQIeJULCQC4csFiF+zvxCQ==</AddrDetail><Url>FDNceyWUJKla8OeFoLPf2w==</Url><ServerIp>75ougmDL85hdhziqfbpHGQ==</ServerIp><Icp>TyPxjdo/iWZnCsuE2XCDIg==</Icp><ContName>MeomuBwRtvex0QKcVzvX6w==</ContName><ContPhone>6ChbguD4AiSx8B1RNdNX2w==</ContPhone><CusEmail>123@qq.com</CusEmail><Occurarea>110000</Occurarea><NetworkType>01</NetworkType><Status>01</Status><StartTime>2020-09-21</StartTime><EndTime>2020-09-22</EndTime><RiskStatus>01</RiskStatus><ShareHolder>xCuHevUAi8n6Fdh2G5ywAg==</ShareHolder><OpenType>01</OpenType><ChageType>01</ChageType><AccountType>01</AccountType><ExpandType>01</ExpandType><OutServiceName>xCuHevUAi8n6Fdh2G5ywAg==</OutServiceName><OutServiceCardType>01</OutServiceCardType><OutServiceCardCode>bd+07Ph3IDErcK5ZWc3A2Q==</OutServiceCardCode><OutServiceLegCardType>01</OutServiceLegCardType><OutServiceLegCardCode>/i5siiTifm7PCDTC2a430h97vOMyeS613ny0gsSquMY=</OutServiceLegCardCode><OrgId>1</OrgId><RepDate>2020-09-23 13:08:47</RepDate><RepType>03</RepType><RepPerson>1</RepPerson><UnitProp>01</UnitProp></BaseInfo><BaseInfo><CusType>02</CusType><CusNature>01</CusNature><RegName>TyPxjdo/iWZnCsuE2XCDIg==</RegName><CusName>mkQXICUGzJlwx608g2SWSw==</CusName><CusNameEn>mkQXICUGzJlwx608g2SWSw==</CusNameEn><DocType>02</DocType><DocCode>/i5siiTifm7PCDTC2a430h97vOMyeS613ny0gsSquMY=</DocCode><LegDocName>adxPNvbGgVykDY13G7Imag==</LegDocName><LegDocType>01</LegDocType><LegDocCode>/i5siiTifm7PCDTC2a430h97vOMyeS613ny0gsSquMY=</LegDocCode><CusCode>1J83ywXseFjdLfDXce9PBURuEVCTbMMVuvlgd1CORog=</CusCode><InduType>商户行业类别</InduType><BankNo>TkpFOX3CM4scWsMooTON+g==</BankNo><OpenBank>招商银行</OpenBank><RegAddrProv>110000</RegAddrProv><RegAddrDetail>BEIM1SX5A4iATN+JgVVbo5c+huM1NkXL4i3WxiKKnv0=</RegAddrDetail><AddrProv>1</AddrProv><AddrDetail>zQIeJULCQC4csFiF+zvxCQ==</AddrDetail><Url>FDNceyWUJKla8OeFoLPf2w==</Url><ServerIp>75ougmDL85hdhziqfbpHGQ==</ServerIp><Icp>TyPxjdo/iWZnCsuE2XCDIg==</Icp><ContName>MeomuBwRtvex0QKcVzvX6w==</ContName><ContPhone>6ChbguD4AiSx8B1RNdNX2w==</ContPhone><CusEmail>123@qq.com</CusEmail><Occurarea>110000</Occurarea><NetworkType>01</NetworkType><Status>01</Status><StartTime>2020-09-21</StartTime><EndTime>2020-09-22</EndTime><RiskStatus>01</RiskStatus><ShareHolder>xCuHevUAi8n6Fdh2G5ywAg==</ShareHolder><OpenType>01</OpenType><ChageType>01</ChageType><AccountType>01</AccountType><ExpandType>01</ExpandType><OutServiceName>xCuHevUAi8n6Fdh2G5ywAg==</OutServiceName><OutServiceCardType>01</OutServiceCardType><OutServiceCardCode>bd+07Ph3IDErcK5ZWc3A2Q==</OutServiceCardCode><OutServiceLegCardType>01</OutServiceLegCardType><OutServiceLegCardCode>/i5siiTifm7PCDTC2a430h97vOMyeS613ny0gsSquMY=</OutServiceLegCardCode><OrgId>1</OrgId><RepDate>2020-09-23 13:08:47</RepDate><RepType>03</RepType><RepPerson>1</RepPerson><UnitProp>01</UnitProp></BaseInfo></PcacList></Body></Request><Signature>ivAN4ilf6jjnxisK9FtJIhkAHi7vZeL1mcidQbfuiCh/hGuZ/zqIGz0e3eBzyVjtTV3SUw/mWtqz2Jr/I8XaeSM53ULukT0nuXX22uCeOXgy95AtsXj3cn2VwJYR3VZzMkUAM3ARu7XoxXdxp1xKQqtCzsle6adSsdRpurUw2MHNUxIspZLAZftWSA7eXNCqblV0eoIxsqFYlef/hkNJ5K8Y+bJQm9Qts6LJQTOSRtsqC4SLXKPOYIkb4oyLtCfPeMWWgEaZozsqdRZMAYbvzmhTwdFodw1sdO6IhR7cD/Ld3d7Fb9R60KBg+Ov1doVGDkw2xFWEADLSLX5NM3IgWA==</Signature></Document> 2020-09-23 13:08:48.733 [ INFO] 23068 --- [   scheduling-1] c.c.p.u.HttpClientUtils                  : HttpClient响应码=200
    //        2020-09-23 13:08:48.735 [ INFO] 23068 --- [scheduling-1] c.c.p.u.HttpClientUtils
    //            : HttpClient请求结果：<?xml version="1.0"
    // encoding="UTF-8"?><Document><Respone><Head><Version>V1.3.0</Version><Identification>202009239274253230</Identification><OrigSender>Z2004343000017</OrigSender><OrigSenderSID>zf_sysstem</OrigSenderSID><RecSystemId>R0001</RecSystemId><TrnxCode>EER001</TrnxCode><TrnxTime>20200923130848</TrnxTime><SecretKey>jYJex/iEu7RZ+X29EXxoq3mwOCkHnYaxo/onWlyLiVNqHLsp1PId4ILrOeue6ES6RabqFpD2u3vW+Dru8glpKDHpNngdPWpYmpOpzU+zlDLM0q4aRsT+0hSGF8FnbXcCGpjK2IG5q8oh0oGdtczSk3cnVB0a9RwfHL6ORaUb+5r/dzf7x4vRZmmNTkj4WtIMMzdYiAKpnuKDMUfkaRz0CCtwCc4zh2yTZEbrmYTfvYNDYs0LshnR0TNLBSYVVIgFjNDFzjdGYC1eRnTHem7rRfctYnCAbb7ziy8iq9SJiPnK0kWdqsAhV6lOhb3cIg3DWwxBin+YYcLOUkywAgXxHw==</SecretKey></Head><Body><RespInfo><ResultStatus>01</ResultStatus><ResultCode>S00000</ResultCode><MsgDetail>企业特约商户信息第1条,上报成功!企业特约商户信息第2条,上报成功!</MsgDetail></RespInfo></Body></Respone><Signature>JPrssBKRG42/f16Ehg7xg92qPS5JjO6AgA1wxYg9DI0vjWj0BL7ZryuxV0CoI2PendXnl2IDiLF0THsMYi5xpWbJeA5XZ6W25ig9fZnukZv2JTL8bz3RCuHlmE3Ef9SP6lpqiBGJtMOuD/hQtPQiUmSu9wZrMFUwquKiqJHxxGCvHVkezCkhmXc7CQID1a6UIaQ6Iyupju+vGOHQvwpbo6MpZcNfN3bcXicb2gozTrZDEP4/6dM0TxYqJ9E1Ois/8Qlu5Hpj+GftZpLMk6+/ZJTE6Zc8V4/owLonjqn51jojuE8o2s2Ee2FpR2E2lvhBFMMObfijVtw0X1nO5NrixQ==</Signature></Document> 2020-09-23 13:08:48.735 [ INFO] 23068 --- [   scheduling-1] c.c.p.s.i.BusinessInfoServiceImpl        : url:http://210.12.239.161:10001/ries_interface/httpServlet
    //        2020-09-23 13:08:48.764 [ INFO] 23068 --- [scheduling-1]
    // c.c.p.s.i.BusinessInfoServiceImpl        : 协会返回数据对象:Body(RespInfo=RespInfo(ResultStatus=01,
    // ResultCode=S00000, UserToken=null, MsgDetail=企业特约商户信息第1条,上报成功!企业特约商户信息第2条,上报成功!,
    // ResultSequence=null), QueryInfo=null, PcacList=null)

  }
}
