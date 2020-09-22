package com.cmcc.paymentclean.service.impl;

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

/**
 * Created by lumma on 2020/9/22.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@ActiveProfiles("dev")
public class BusinessInfoServiceImplTest {

    @Autowired
    private BusinessInfoService businessInfoService;

    @Test
    void testBusinessInfo2(){
        List<BusinessInfoReq> businessInfoReqs = new ArrayList<>();
        BusinessInfoReq req = new BusinessInfoReq();
        req.setRegName("123");
        businessInfoReqs.add(req);
        businessInfoService.batchQuery(businessInfoReqs);
//        2020-09-22 22:28:52.419 [ INFO] 19104 --- [   scheduling-1] c.c.p.u.HttpClientUtils                  : Post请求url：http://210.12.239.161:10001/ries_interface/httpServlet
//        2020-09-22 22:28:52.419 [ INFO] 19104 --- [   scheduling-1] c.c.p.u.HttpClientUtils                  : Post请求params：<?xml version="1.0" encoding="UTF-8"?><Document><Request><Head><Version>V1.3.0</Version><Identification>202009226427330728</Identification><OrigSender>Z2004343000017</OrigSender><OrigSenderSID>zf_sysstem</OrigSenderSID><RecSystemId>R0001</RecSystemId><TrnxCode>QE0004</TrnxCode><TrnxTime>20200922222847</TrnxTime><UserToken>Io2lrHofKybUc%2BmKeG6qo%2FMQwXMQTOQ6IwrnIfgvhyHTf2SAN63W0wKbw%2FODal5I</UserToken><SecretKey>etPTlniuwy+rZgYt2UOPGKw5YeVgDL7bNORdC8wT4CGg8ZMNqCYhWLr5H6rf4X7nEqEkqDzEEaDwUZLHEgh6lqoz2N4KN0OEglCPHGBIo1opuwsHODraH39LKIiOTP/mWyQOPWOdogyoX7CMbh1S0MSxwQMPUc5IVT7WSKGtk2f1I/qVTSNew0rPvLgcG7FabD9XWQWUvwW4J5T6zmNmQlrx7dOdbYTMgbBBG8JnzICRMZv97Hoi1vIDhf5JPu3WFEpkGa3u7DFFIEO0RzA5tBi50vgmdVwFdUUE4BaUb8rHKaPJGc5auXMcComdD43QBRXHn3+SyphYPTP/6hettw==</SecretKey></Head><Body><PcacList><Count>1</Count><BaseInfo><DocCode></DocCode><RegName>MPW48HaZjoZsbGw1AZcdYA==</RegName><LegDocCode></LegDocCode><LegDocName></LegDocName></BaseInfo></PcacList></Body></Request><Signature>LHTUTSxsVDjz3xA6FrJar4HWa5FHyyCpwUURNhBuugUeOIGbR8r+ZKfKudV+s5OPBdLYkSphCElGxUy4zawn9spwAzrB/rX0/d37yFqkivDL6Za7WNhwOLnTQXZhE46eZUoggJotKCIFmTRKZhnKntiO2FH4An9dhRYx9TrYXpik8YKS2tBvKBMoeTpVSdOt/np1MEaxNfMcIi2XUfuqmA/MYxG2ldF1VeX4NGB4WMXlf//d47M3hW81Vh3Hp/jYdvJaAFpQPfE8GB9npscuHBN0REj8O/42lHoawSsGxq8sanbfRdsQxViQjItdfiUSADQnCHDsh69IeDf1aFQj5A==</Signature></Document>
//        2020-09-22 22:28:53.011 [ INFO] 19104 --- [   scheduling-1] c.c.p.u.HttpClientUtils                  : HttpClient响应码=200
//        2020-09-22 22:28:53.013 [ INFO] 19104 --- [   scheduling-1] c.c.p.u.HttpClientUtils                  : HttpClient请求结果：<?xml version="1.0" encoding="UTF-8"?><Document><Respone><Head><Version>V1.3.0</Version><Identification>202009226427330728</Identification><OrigSender>Z2004343000017</OrigSender><OrigSenderSID>zf_sysstem</OrigSenderSID><RecSystemId>R0001</RecSystemId><TrnxCode>QE0004</TrnxCode><TrnxTime>20200922222853</TrnxTime><SecretKey>etPTlniuwy+rZgYt2UOPGKw5YeVgDL7bNORdC8wT4CGg8ZMNqCYhWLr5H6rf4X7nEqEkqDzEEaDwUZLHEgh6lqoz2N4KN0OEglCPHGBIo1opuwsHODraH39LKIiOTP/mWyQOPWOdogyoX7CMbh1S0MSxwQMPUc5IVT7WSKGtk2f1I/qVTSNew0rPvLgcG7FabD9XWQWUvwW4J5T6zmNmQlrx7dOdbYTMgbBBG8JnzICRMZv97Hoi1vIDhf5JPu3WFEpkGa3u7DFFIEO0RzA5tBi50vgmdVwFdUUE4BaUb8rHKaPJGc5auXMcComdD43QBRXHn3+SyphYPTP/6hettw==</SecretKey></Head><Body><RespInfo><ResultStatus>01</ResultStatus><ResultCode>S00000</ResultCode><ResultSequence>rGnfRobTLOQGiAUqQM65BXEJIO8uEg/+UhygKtQ3TD26MlNBaaZm4ZFz9JOxMoVR</ResultSequence></RespInfo></Body></Respone><Signature>Ht5z6L8/AFDY2cJx+MGF0FT0q3Wri1Bxp3KadRJ6sU668VAqfPksnA7LnID1DZzb31/8E1UCuptymFWPU4XuyihaszFDl9X2bOS1jjDb2Hnc3NPqggIcjuKFuc1Cz4RcH9KQaG1vSS+BzCrqpq8ow8UZvTFBksT5AxIIiTJ6oILRJWpdWRBxANFj+iLXMmAZmw7x8ivHsE0hvlGD8JNHKErlxkeSD55NfABqbYtR9MVAo8ukn0fQCrkliZaIZ++rr4K6asxsVuotXI9EGcmW0L6BlCX0I6rdVnpCS8ryXzsmU+MBPRAwCPtlRAi2+YFjM6T+zdSJKDr85rmIBPkGaw==</Signature></Document>
//                2020-09-22 22:28:53.013 [ INFO] 19104 --- [   scheduling-1] c.c.p.s.i.BusinessInfoServiceImpl        : url:http://210.12.239.161:10001/ries_interface/httpServlet
//        2020-09-22 22:28:53.029 [ INFO] 19104 --- [   scheduling-1] c.c.p.s.i.BusinessInfoServiceImpl        : 协会返回数据对象:Document(Respone=Respone(Head=Head(Version=V1.3.0, Identification=202009226427330728, OrigSender=Z2004343000017, OrigSenderSID=zf_sysstem, RecSystemId=R0001, TrnxCode=QE0004, TrnxTime=20200922222853, SecretKey=etPTlniuwy+rZgYt2UOPGKw5YeVgDL7bNORdC8wT4CGg8ZMNqCYhWLr5H6rf4X7nEqEkqDzEEaDwUZLHEgh6lqoz2N4KN0OEglCPHGBIo1opuwsHODraH39LKIiOTP/mWyQOPWOdogyoX7CMbh1S0MSxwQMPUc5IVT7WSKGtk2f1I/qVTSNew0rPvLgcG7FabD9XWQWUvwW4J5T6zmNmQlrx7dOdbYTMgbBBG8JnzICRMZv97Hoi1vIDhf5JPu3WFEpkGa3u7DFFIEO0RzA5tBi50vgmdVwFdUUE4BaUb8rHKaPJGc5auXMcComdD43QBRXHn3+SyphYPTP/6hettw==), Body=Body(RespInfo=RespInfo(ResultStatus=01, ResultCode=S00000, UserToken=null, MsgDetail=null, ResultSequence=rGnfRobTLOQGiAUqQM65BXEJIO8uEg/+UhygKtQ3TD26MlNBaaZm4ZFz9JOxMoVR), QueryInfo=null, PcacList=null)), Signature=Ht5z6L8/AFDY2cJx+MGF0FT0q3Wri1Bxp3KadRJ6sU668VAqfPksnA7LnID1DZzb31/8E1UCuptymFWPU4XuyihaszFDl9X2bOS1jjDb2Hnc3NPqggIcjuKFuc1Cz4RcH9KQaG1vSS+BzCrqpq8ow8UZvTFBksT5AxIIiTJ6oILRJWpdWRBxANFj+iLXMmAZmw7x8ivHsE0hvlGD8JNHKErlxkeSD55NfABqbYtR9MVAo8ukn0fQCrkliZaIZ++rr4K6asxsVuotXI9EGcmW0L6BlCX0I6rdVnpCS8ryXzsmU+MBPRAwCPtlRAi2+YFjM6T+zdSJKDr85rmIBPkGaw==)
    }

    @Test
    void test(){
        businessInfoService.queryBusinessInfoAndPushPcac();
        //    2020-09-22 22:44:22.224 [ INFO] 17636 --- [   scheduling-1] c.c.p.u.HttpClientUtils                  : Post请求url：http://210.12.239.161:10001/ries_interface/httpServlet
//            2020-09-22 22:44:22.224 [ INFO] 17636 --- [   scheduling-1] c.c.p.u.HttpClientUtils                  : Post请求params：<?xml version="1.0" encoding="UTF-8"?><Document><Request><Head><Version>V1.3.0</Version><Identification>202009225049461242</Identification><OrigSender>Z2004343000017</OrigSender><OrigSenderSID>zf_sysstem</OrigSenderSID><RecSystemId>R0001</RecSystemId><TrnxCode>EER001</TrnxCode><TrnxTime>20200922224417</TrnxTime><UserToken>Io2lrHofKybUc%2BmKeG6qo%2FMQwXMQTOQ6IwrnIfgvhyHTf2SAN63W0wKbw%2FODal5I</UserToken><SecretKey>S3M+FQlEZ43N43lQzG0BFBw4eWkXq4Q2qqwgDUokvoOUeP88ZseJbg8hdOmqZy52jMcDyr9iqz8mxqZqjqXc8A2FCNIt7DJg2kp/faPsB8EilCZgOnlcH2gd0KyuPW+0keAL8RomdtaB8nuTX5CVE/78su+UYcKf4I6GXr2NsKaWb6NpPalOm6HC2Ra7FBAtVZHJG0RTjUqDsg4CfxOkgVIx3D5oHRDbawjylsa19FYYVyL9LsHlFFlSexGel3lJDc17USDi8+l+MYnKddP13ps+LXm28HVmvyCMgm76avGZVRa/NJc3lI+p7dSjqtRXHoiq3e/HWFvKviZcoxGWXg==</SecretKey></Head><Body><PcacList><Count>9</Count><BaseInfo><CusType>02</CusType><CusNature>01</CusNature><RegName>qt3Cih3IWjPTxYQFt1ZlOSHxiliCl/3xjFnynpvtH04aLtjf3jv7r665PPx6cnNDPRVqiW+WX3Fhk+yX9xJj9w==</RegName><CusName>ly3COvSOP+Gcl9DMh1WZRQ==</CusName><CusNameEn>T10</CusNameEn><DocType>02</DocType><DocCode>4JWfTUSPLRhxoNbQgWYjbA==</DocCode><LegDocName>uRtcGdaLlvYsMKMIMPg3EA==</LegDocName><LegDocType>01</LegDocType><LegDocCode>ESkNO6phGhBtvx37BHdYrQ==</LegDocCode><CusCode>4bBih7tgIoyoDx8W/8qoRQ==</CusCode><InduType>商户行业类别</InduType><BankNo></BankNo><OpenBank>123</OpenBank><RegAddrProv>长沙</RegAddrProv><RegAddrDetail>天府新区成都片区大林星光五金经营部</RegAddrDetail><AddrProv>1</AddrProv><AddrDetail>长沙</AddrDetail><Url>wtNNLmdLGVnzeWnHYg9oDQ==</Url><ServerIp>vpyRjVcX17gg80Ete8LZ/Q==</ServerIp><Icp>qt3Cih3IWjPTxYQFt1ZlOSHxiliCl/3xjFnynpvtH04aLtjf3jv7r665PPx6cnNDPRVqiW+WX3Fhk+yX9xJj9w==</Icp><ContName>ESkNO6phGhBtvx37BHdYrQ==</ContName><ContPhone>2jIipGP7fSkwVMQ4Fjrw9Q==</ContPhone><CusEmail>123@qq.com</CusEmail><Occurarea>123</Occurarea><NetworkType>1</NetworkType><Status>1</Status><StartTime>2020-09-21</StartTime><EndTime>2020-09-22</EndTime><RiskStatus>99</RiskStatus><ShareHolder>1</ShareHolder><OpenType>1</OpenType><ChageType>1</ChageType><AccountType>01</AccountType><ExpandType>01</ExpandType><OutServiceName>1</OutServiceName><OutServiceCardType>01</OutServiceCardType><OutServiceCardCode>ESkNO6phGhBtvx37BHdYrQ==</OutServiceCardCode><OutServiceLegCardType>01</OutServiceLegCardType><OutServiceLegCardCode>886edvJCu81ELdpCzXDbCg==</OutServiceLegCardCode><OrgId>1</OrgId><RepDate>2020-09-22 22:44:17</RepDate><RepType>01</RepType><RepPerson>1</RepPerson><UnitProp>1</UnitProp></BaseInfo></PcacList></Body></Request><Signature>YGmHrqmOybL7YbFg5TyzmNv0cZICRqgoXbVu36BV/kX/QEnnOkH0xE3xU0hbFdFZ/tzSdhqGWkD30OupWadcPDiJHmNxd+vkDPnofzdiaFxSnsTVuB1DCpsYjtTxzTRO1e6QHFWbNQiOBk0Vt8dO+BeljtsKHhigiSZ4CYk+9IdUDCSk4Iokl6yunmKk4i5OpkNanNf2ZQnfOoDmuU1+n6bT5K1soqJDD4KeJtv2K27jZEaFwcXb/bSFqY9yRYjDsiKzDCy9jrCE8AC8KxO9utmU3K1GpE9f1bbZe6c6WPsv2p7/a8RuXgjcihrrJKFGL+5QuNlF8mvWi/0QEg3ppw==</Signature></Document>
//            2020-09-22 22:44:22.375 [ INFO] 17636 --- [   scheduling-1] c.c.p.u.HttpClientUtils                  : HttpClient响应码=200
//            2020-09-22 22:44:22.376 [ INFO] 17636 --- [   scheduling-1] c.c.p.u.HttpClientUtils                  : HttpClient请求结果：<?xml version="1.0" encoding="UTF-8"?><Document><Respone><Head><Version>V1.3.0</Version><Identification>202009225049461242</Identification><OrigSender>Z2004343000017</OrigSender><OrigSenderSID>zf_sysstem</OrigSenderSID><RecSystemId>R0001</RecSystemId><TrnxCode>EER001</TrnxCode><TrnxTime>20200922224422</TrnxTime><SecretKey>S3M+FQlEZ43N43lQzG0BFBw4eWkXq4Q2qqwgDUokvoOUeP88ZseJbg8hdOmqZy52jMcDyr9iqz8mxqZqjqXc8A2FCNIt7DJg2kp/faPsB8EilCZgOnlcH2gd0KyuPW+0keAL8RomdtaB8nuTX5CVE/78su+UYcKf4I6GXr2NsKaWb6NpPalOm6HC2Ra7FBAtVZHJG0RTjUqDsg4CfxOkgVIx3D5oHRDbawjylsa19FYYVyL9LsHlFFlSexGel3lJDc17USDi8+l+MYnKddP13ps+LXm28HVmvyCMgm76avGZVRa/NJc3lI+p7dSjqtRXHoiq3e/HWFvKviZcoxGWXg==</SecretKey></Head><Body><RespInfo><ResultStatus>02</ResultStatus><ResultCode>F00007</ResultCode><MsgDetail>报文解密失败</MsgDetail></RespInfo></Body></Respone><Signature>HR7U2cDDhewQxvOAEfOH1b6DP+d0bxVCSBo+TRVA2xPC6XAlj/X71C6GzOm0ahrs+hIq3XVX5Cxo8C2wNp2/NJmuugYxG9W8AouS1+a86nDHCo7hZ/teQ8T5RQ6PsdxF5hj2sthuW+9tcJtUUkqeUP8vTemdt4R46BNHPTk5hIlRG3TJ2niyUZBiswV1V5tAmbtYJcibRydoOf9ucqrHAA7rUugBBNvOKYnz86VwhcE9H+oF96hvnoaRmeIGRazgM3QNMFMbGnGDCc5uTpijKN5lrAMGwRI3ssMdsLWn35QSoeOlBxD5ot/wSSG2ijta3kVx9C5cIm2a9iDEjobPhw==</Signature></Document>
//            2020-09-22 22:44:22.801 [ INFO] 17636 --- [   scheduling-1] c.c.p.s.i.BusinessInfoServiceImpl        : url:http://210.12.239.161:10001/ries_interface/httpServlet
//            2020-09-22 22:44:25.834 [ INFO] 17636 --- [   scheduling-1] c.c.p.s.i.BusinessInfoServiceImpl        : 协会返回数据对象:Body(RespInfo=RespInfo(ResultStatus=02, ResultCode=F00007, UserToken=null, MsgDetail=报文解密失败, ResultSequence=null), QueryInfo=null, PcacList=null)

    }



}
