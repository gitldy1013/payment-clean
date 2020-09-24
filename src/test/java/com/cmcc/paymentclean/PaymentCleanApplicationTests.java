package com.cmcc.paymentclean;

import com.cmcc.paymentclean.controller.PcacAssistanceController;
import com.cmcc.paymentclean.controller.PcacRiskInfoPushController;
import com.cmcc.paymentclean.cron.SubmitPcacPersonRiskInfo;
import com.cmcc.paymentclean.entity.LoginResult;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.resquest.ReissueRiskInfoReq;
import com.cmcc.paymentclean.service.LoginPcacService;
import com.cmcc.paymentclean.utils.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.Random;

@SpringBootTest
@ActiveProfiles("dev")
class PaymentCleanApplicationTests {

    @Autowired
    private SubmitPcacPersonRiskInfo submitPcacPersonRiskInfo;
    @Autowired
    private LoginPcacService loginPcacService;

    @Autowired
    private PcacRiskInfoPushController pcacRiskInfoPushController;

    @Autowired
    private PcacAssistanceController pcacAssistanceController;

    @Test
    void contextLoads() {
    }


    /**
     * 测试个人风险信息上报接口
     */
    @Test
    public void test01() {
        submitPcacPersonRiskInfo.submit();
    }


    /**
     * 测试登录登出接口
     */
    @Test
    public void test02() {
        LoginResult result = loginPcacService.login();
        // LoginResult result = loginPcacService.logout();
        System.out.println("----------------登录结果--------------");
        System.out.println(result);
    }

    /**
     * 测试黑名单推送，风险提示信息推送
     */
    @Test
    public void test03() {


        String doxml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Document><Request><Head><Version>V1.3.0</Version><Identification>202009226750826702</Identification><OrigSender>Z2004343000017</OrigSender><OrigSenderSID>Z2004343000017</OrigSenderSID><RecSystemId>R0001</RecSystemId><TrnxCode>TS0001</TrnxCode><TrnxTime>20200922161100</TrnxTime><UserToken>pcac</UserToken><SecretKey>VaZTiEkbpkKq8FnTvhE0O0qxhqWbxawXcQVPynvrNhtFjoqXP5A8+Twf4Rflp6Sbw2BcDPIybNX9oAulmzAbPH8k5508FTSWFcNFuzzYRTJuvZyOkU2tFz9RzrBpItwv5TPstXYuXtALmBfVn8HGP35jLtIldIX513TVliyNVzSxYG0gAip0Dn6sWWts+Ar66/0b/VT/5f7+qsC6SScOat8kisZSqt8moQs9jlLSr9r7/DzbvkL6p6vE447GxKQGquHgjnK63yu3/QtZS5nQtjEHrRySdG4ZtbpW2yOWWttiTrqvBx1B1ALPsO70EFZ6Jd06wN4BoeHO8g6rApea9g==</SecretKey></Head><Body><PcacList><Count>41</Count><UpDate>2020-09-22</UpDate><RiskInfo><RegName>/Lbog21fiOGcMPMPpPdsYg==</RegName><CusName></CusName><DocType>99</DocType><DocCode></DocCode><LegDocName>tyyRrWxmst3KTJr3PhJkeg==</LegDocName><LegDocType>01</LegDocType><LegDocCode>vsC27WK2nUMA8ET4NyzrC4UrlzJLbdr9tlClVAIS3JI=</LegDocCode><Level>01</Level><RiskType>01</RiskType><ValidDate>2020-09-30</ValidDate><ValidStatus>01</ValidStatus><CusType>01</CusType><Occurarea>210000</Occurarea><BankNo>XAsQElN/kiwCjqG+szPWaQ==</BankNo><Url></Url><RegisteredCode></RegisteredCode></RiskInfo><RiskInfo><RegName>ILHrVv/xpJgj97K1Vhf/Rg==</RegName><CusName></CusName><DocType></DocType><DocCode></DocCode><LegDocName>npDZQCtnCpHa8twV80OUkg==</LegDocName><LegDocType>01</LegDocType><LegDocCode>qlTb27P+HVLTyJVhAXt9D0w9a/gSMWY5yfcR3VvPFls=</LegDocCode><Level>01</Level><RiskType>01</RiskType><ValidDate>2020-09-30</ValidDate><ValidStatus>01</ValidStatus><CusType>01</CusType><Occurarea>110000</Occurarea><BankNo>66pfQYd6VwmAgQrVqdlGFQ==</BankNo><Url></Url><RegisteredCode></RegisteredCode></RiskInfo><RiskInfo><RegName>GvZdXri+YfxwqFxue7Ve7A==</RegName><CusName>fZJEMAPRDanbzEqD977IoA==</CusName><DocType>01</DocType><DocCode>i6cWtxbud+IrcURloQQTDQ==</DocCode><LegDocName>Wsd1+9dUAnHBaE/2pjisvg==</LegDocName><LegDocType>01</LegDocType><LegDocCode>FQtpQRGMtmLLAWy6qDi8gQ==</LegDocCode><Level>01</Level><RiskType>01</RiskType><ValidDate>2021-08-07</ValidDate><ValidStatus>01</ValidStatus><CusType>01</CusType><Occurarea>659000</Occurarea><BankNo>tOPBX5+WHQhmRctCU5xQZA==</BankNo><Url></Url><RegisteredCode></RegisteredCode></RiskInfo><RiskInfo><RegName>vcxZZ64mMfs6envpIEpWmA==</RegName><CusName>44fMzpz/IIJeE/5VfMNxxg==</CusName><DocType>99</DocType><DocCode>Wd31VgcIG4rILBhBqdGL3RtUfUJYX8bG/Hxsj90m/4Y=</DocCode><LegDocName>7ZZgsWjjJwFo0nQBfQcOow==</LegDocName><LegDocType>01</LegDocType><LegDocCode>Wd31VgcIG4rILBhBqdGL3RtUfUJYX8bG/Hxsj90m/4Y=</LegDocCode><Level>01</Level><RiskType>42</RiskType><ValidDate>2020-12-01</ValidDate><ValidStatus>01</ValidStatus><CusType>01</CusType><Occurarea>440300</Occurarea><BankNo></BankNo><Url>h1KhqAtEkdff65VvTwYvJQ==</Url><RegisteredCode>VmMVweyksP2hzTprnGkdIg==</RegisteredCode></RiskInfo><RiskInfo><RegName>a+5KoSukYp4SSvJbzFQJwbypJ+NWKSZYty5Mo4YFr3vEpIWPJJGpPFzcFA7vbTV9</RegName><CusName>J+PfXcmoL7If+fzzIUSfnw==</CusName><DocType>04</DocType><DocCode>Vo97DWtRNZUCA72LrO5Pm+ck3DXZYJcF4+apitgu+kA=</DocCode><LegDocName>hrdf7FB2tm+j0SsNqJ1anA==</LegDocName><LegDocType>01</LegDocType><LegDocCode>Qz0OzpP1dDVxeUYypqBGOqXHoO3Txs7M682DHRBpUNc=</LegDocCode><Level>01</Level><RiskType>42</RiskType><ValidDate>2021-01-01</ValidDate><ValidStatus>01</ValidStatus><CusType>01</CusType><Occurarea>450100</Occurarea><BankNo></BankNo><Url>I304rV4Y9fn/P9mJQXx/Ng==</Url><RegisteredCode></RegisteredCode></RiskInfo><RiskInfo><RegName>kbG2LKboFHDUYRVlXfJakw==</RegName><CusName>vKiuINIFiIfA0ViWlmg1og==</CusName><DocType>01</DocType><DocCode>JYATYHJMqKWn5G8RvvDo9w==</DocCode><LegDocName>rDqAD++WdEt9MPj/q5kswA==</LegDocName><LegDocType>01</LegDocType><LegDocCode>pBTsQd2wjupwb3UhKNZVE+5Ip4a7yr/CPH9CC60mjQk=</LegDocCode><Level>01</Level><RiskType>42</RiskType><ValidDate>2020-11-30</ValidDate><ValidStatus>01</ValidStatus><CusType>01</CusType><Occurarea>810000</Occurarea><BankNo></BankNo><Url>2FLBb/ftHPpW//osHYqx0Q==</Url><RegisteredCode>kTyuzJWr4Un4YMHwpfa1ew==</RegisteredCode></RiskInfo><RiskInfo><RegName>CgP8Ru8sXUvHUNcwzUHbrHfZ4FCr73UT58cB3hQ0xc0=</RegName><CusName>yeF6zqF/00Z64TuAV+bghA==</CusName><DocType>03</DocType><DocCode>8fWiP7uU/qaBt2yeWKP/5A==</DocCode><LegDocName>CgP8Ru8sXUvHUNcwzUHbrHfZ4FCr73UT58cB3hQ0xc0=</LegDocName><LegDocType>04</LegDocType><LegDocCode>AuDcjet3hTvaW32i8PCHgw==</LegDocCode><Level>01</Level><RiskType>42</RiskType><ValidDate>2023-09-21</ValidDate><ValidStatus>01</ValidStatus><CusType>01</CusType><Occurarea>130000</Occurarea><BankNo></BankNo><Url>SYmPjBEqNi61b9owc7X3xA==</Url><RegisteredCode></RegisteredCode></RiskInfo><RiskInfo><RegName>+zgFaXxx8ppREr5M6mC0Gw==</RegName><CusName>duwuN7o7awMKR2+UB07P4A==</CusName><DocType>99</DocType><DocCode>3/exOmy+pF9WM5kK7bffY0w9a/gSMWY5yfcR3VvPFls=</DocCode><LegDocName>+zgFaXxx8ppREr5M6mC0Gw==</LegDocName><LegDocType>99</LegDocType><LegDocCode>3/exOmy+pF9WM5kK7bffY0w9a/gSMWY5yfcR3VvPFls=</LegDocCode><Level>01</Level><RiskType>01</RiskType><ValidDate>2020-10-10</ValidDate><ValidStatus>01</ValidStatus><CusType>01</CusType><Occurarea>430000</Occurarea><BankNo></BankNo><Url>KROubgIKMJktMzWV0dsR3sA1aVdtlHRtPufpvvMZXTQ=</Url><RegisteredCode></RegisteredCode></RiskInfo><RiskInfo><RegName>xlE62UYLxAGXMtVaoB7tGQ==</RegName><CusName>xlE62UYLxAGXMtVaoB7tGQ==</CusName><DocType>01</DocType><DocCode>r84o3WDbGZeHAbexbRpQ5g==</DocCode><LegDocName>xlE62UYLxAGXMtVaoB7tGQ==</LegDocName><LegDocType>01</LegDocType><LegDocCode>M2CU1/PbYVVwlnQlxcaziU+yXi/HheUBUFGlJU4dRCw=</LegDocCode><Level>01</Level><RiskType>19</RiskType><ValidDate>2020-09-30</ValidDate><ValidStatus>01</ValidStatus><CusType>03</CusType><Occurarea>110000,110100</Occurarea><BankNo>ZknoPsm4Ngr7PsVm2TMF++gp0PwHYvVb6xEPHTpWTVk=</BankNo><Url>4hDv5jFKYW6DPp9uD9l8/q6JcqLB3XdfrRqr03y5brjebZwbnu2vaRAjm/gCYy8u</Url><RegisteredCode>vvUXtaYU4jvMPowhsdknWg==</RegisteredCode></RiskInfo><RiskInfo><RegName>c1bVpCsG021ym435QCZhXQYg6076HksOSNHRRjJTSmL/EbB/ukgMnLQox3JMNcKt</RegName><CusName>c1bVpCsG021ym435QCZhXQYg6076HksOSNHRRjJTSmL/EbB/ukgMnLQox3JMNcKt</CusName><DocType>01</DocType><DocCode>x/R1wRX2tvZmN0yJ+I23Dw==</DocCode><LegDocName>lMJJrixGG9ybKhlquDBvOg==</LegDocName><LegDocType>01</LegDocType><LegDocCode>8djXR1jznfAaEGev8q3biPZuCDQhfbQU260X7rfDSQI=</LegDocCode><Level>01</Level><RiskType>12</RiskType><ValidDate>2026-11-26</ValidDate><ValidStatus>01</ValidStatus><CusType>02</CusType><Occurarea>510000</Occurarea><BankNo></BankNo><Url>1Pp5+cFTGh9/zKkXkayN3Q==</Url><RegisteredCode></RegisteredCode></RiskInfo><RiskInfo><RegName>clSdWxORpgDzPEs2JxcsOf6nFlUKQNMuvJLAexwMfDY=</RegName><CusName>Y4QKcm3pfiaxuzw7Xk83/yxhJB9WT6Adte80K0vIw18=</CusName><DocType>02</DocType><DocCode>aCo5kiDqjjZgk+JUoMAPF3J8XF8Z+u4JiAAsyPoe/tc=</DocCode><LegDocName>IprBmLSUNYF+CVoRAVmzpA==</LegDocName><LegDocType>01</LegDocType><LegDocCode>sqe4tsoYMEMB2DU52g87cg==</LegDocCode><Level>01</Level><RiskType>01</RiskType><ValidDate>2023-12-31</ValidDate><ValidStatus>01</ValidStatus><CusType>02</CusType><Occurarea>110000</Occurarea><BankNo>yfhXAtE6u1k73ghZChoz8suMCYL8Y0HdJh6y06G/VSQ=</BankNo><Url>Ob84c4Rqz9+9nHYI0G8Kn0oOuIwdwl390RTKwREC61w=</Url><RegisteredCode>KJeGAsII0vO6SEYbm/2KqQ==</RegisteredCode></RiskInfo><RiskInfo><RegName>VJX2Vm/HwXbDCc0DgBLoty+4zt1X7oABG1u8cKYhzkf0kTy0GbzsYU+sxEBkmrEh</RegName><CusName>LdsD0WGDzbfCNVx5NrR2ug==</CusName><DocType>01</DocType><DocCode>ye4KBaiUGSZYNdEvDtef+A==</DocCode><LegDocName>wOIECUVi+elT/P13+bAWTQ==</LegDocName><LegDocType>01</LegDocType><LegDocCode>HS65gMurBxhsw2WFb11IG1EBvQdWV4Mp2Btzp5pK8U8=</LegDocCode><Level>01</Level><RiskType>42</RiskType><ValidDate>2020-09-30</ValidDate><ValidStatus>01</ValidStatus><CusType>02</CusType><Occurarea>340000</Occurarea><BankNo></BankNo><Url>FhsKdLUas/ZrfDeKgwdhZw==</Url><RegisteredCode></RegisteredCode></RiskInfo><RiskInfo><RegName>+vyF2ue9QfmwRR+Hp+Su07LffI0mZvyfvlXtoz06Cw+vpKTvLCVE1mIAYR+SnFzf92wKR2WKZIZPMft7PCvVZTJCc4B8hbPz7DrnmbsGOSg=</RegName><CusName>BExVM9K9F8Cw5LanVbYA/g==</CusName><DocType>02</DocType><DocCode>RsPfotYEZJib6x29i5KNDh/eJP6gAP5chMrHNLYE6zE=</DocCode><LegDocName>wOIECUVi+elT/P13+bAWTQ==</LegDocName><LegDocType>01</LegDocType><LegDocCode>yBM/AYRb5GPWvC+Hdyhp9MImOIgmKuc1ihVSaSM1p4E=</LegDocCode><Level>01</Level><RiskType>01</RiskType><ValidDate>2020-10-02</ValidDate><ValidStatus>01</ValidStatus><CusType>02</CusType><Occurarea>210100</Occurarea><BankNo>GIRukELUCNvgCznv4tFEPg==</BankNo><Url>FhsKdLUas/ZrfDeKgwdhZw==</Url><RegisteredCode></RegisteredCode></RiskInfo><RiskInfo><RegName>1OD305o3aXz5fOX9aZyRWt4A9SjyWwyzcwulzyqTGYbiC+MvJtjmztZN6aYL7u9S3zojuuUWb3IFOmU54gTYfg==</RegName><CusName>1OD305o3aXz5fOX9aZyRWt4A9SjyWwyzcwulzyqTGYbiC+MvJtjmztZN6aYL7u9S3zojuuUWb3IFOmU54gTYfg==</CusName><DocType>02</DocType><DocCode>qBvU4jZnjRTvFcFSII9XVK28JKYsiRTiGIQa+XuURpA=</DocCode><LegDocName>41ZecsStwtnUWjyrwzbK5Q==</LegDocName><LegDocType>01</LegDocType><LegDocCode>aIp5kyR1JoOdr8K3X+slluAA2a9lieNqXO8yOOA6Jcs=</LegDocCode><Level>01</Level><RiskType>01</RiskType><ValidDate>2020-09-24</ValidDate><ValidStatus>01</ValidStatus><CusType>02</CusType><Occurarea>110109</Occurarea><BankNo>7QEnzYd5z5i295gujjGsY67iKQOkfKHKN894u08ODfg=</BankNo><Url>Ob84c4Rqz9+9nHYI0G8Kn0oOuIwdwl390RTKwREC61w=</Url><RegisteredCode></RegisteredCode></RiskInfo><RiskInfo><RegName>FNHUFvrnTe5aFluls0ftqQ==</RegName><CusName>ALRD9vVMAb6dFb55ou86sA==</CusName><DocType>01</DocType><DocCode>fJekHEPlSE4aMa/Ivsg+DQ==</DocCode><LegDocName>0CA3l0YmOJD4gWazh8cThg==</LegDocName><LegDocType>01</LegDocType><LegDocCode>Ba3t6i4HA2Sy51jqB8BjepvD1wQtoc+IyKDCvSwmFDM=</LegDocCode><Level>01</Level><RiskType>37</RiskType><ValidDate>2020-09-30</ValidDate><ValidStatus>01</ValidStatus><CusType>02</CusType><Occurarea>120000,120100</Occurarea><BankNo>Ba3t6i4HA2Sy51jqB8BjepvD1wQtoc+IyKDCvSwmFDM=</BankNo><Url></Url><RegisteredCode></RegisteredCode></RiskInfo><RiskInfo><RegName>jCpHq/BbYQymp3K3IjEiYgkaXzPrUNT3yxC5sG003i0=</RegName><CusName>wuKYJCXpcXSegDvoM+2skA==</CusName><DocType>02</DocType><DocCode>Etjug+zS8IBObMYs4Mmp9R/eJP6gAP5chMrHNLYE6zE=</DocCode><LegDocName>wOIECUVi+elT/P13+bAWTQ==</LegDocName><LegDocType>01</LegDocType><LegDocCode>CtnAs3rsfV7Em2o5kWSbxFkQ8cJtIQGKD3iFxljuQX0=</LegDocCode><Level>01</Level><RiskType>09</RiskType><ValidDate>2020-10-10</ValidDate><ValidStatus>01</ValidStatus><CusType>02</CusType><Occurarea>340000</Occurarea><BankNo>c5AM4dQVwl7CFUz5sxqDZw==</BankNo><Url>FhsKdLUas/ZrfDeKgwdhZw==</Url><RegisteredCode></RegisteredCode></RiskInfo><RiskInfo><RegName>dYT0NEWKmZLljP11HmOl+dfDwKw9q7GmgVdTaTp772A=</RegName><CusName>F8uUb8ele97XP+ORTfRpdg==</CusName><DocType>01</DocType><DocCode>oCG1gZNKNi0hRhw4Sx+l2A==</DocCode><LegDocName>SgjhHyOpwPea+glgNc+Qgw==</LegDocName><LegDocType>01</LegDocType><LegDocCode>/lXtwOaE9NemU6PfVcbkGtFlsrvQ0XL7iA8yzGlZLBA=</LegDocCode><Level>01</Level><RiskType>01</RiskType><ValidDate>2020-12-30</ValidDate><ValidStatus>01</ValidStatus><CusType>02</CusType><Occurarea>610000</Occurarea><BankNo>ZPrqtB3q53HpC1WESsFkkLqAtLoMnxUh9k4NH9Mjhp8=</BankNo><Url>QpEspjeiwMrVXV6Z5QjFuqwARfJXtN5npqHVQRCBItc=</Url><RegisteredCode>NHGyBEV45GGDSn2a776HBw==</RegisteredCode></RiskInfo><RiskInfo><RegName>U2gTHe4Hp/JrYbwlV2dkQA==</RegName><CusName></CusName><DocType>01</DocType><DocCode>FQtpQRGMtmLLAWy6qDi8gQ==</DocCode><LegDocName>U2gTHe4Hp/JrYbwlV2dkQA==</LegDocName><LegDocType>01</LegDocType><LegDocCode>+yZPIYg20nPqKEalJnZX3SXjAmPCe0DNpoUr8O+8BQs=</LegDocCode><Level>01</Level><RiskType>01</RiskType><ValidDate>2020-09-30</ValidDate><ValidStatus>01</ValidStatus><CusType>02</CusType><Occurarea>340100</Occurarea><BankNo>Exe8Sb6Fx9lwZDxuG95qLcuMCYL8Y0HdJh6y06G/VSQ=</BankNo><Url></Url><RegisteredCode></RegisteredCode></RiskInfo><RiskInfo><RegName>+vyF2ue9QfmwRR+Hp+Su020FuMq7ukJiOKKlctZN8dhFfZVzm3HLNGPnl5NTAa+2</RegName><CusName>aFB67aHoydA/BUIE7p6GIQ==</CusName><DocType>02</DocType><DocCode>yYmNtXQr0i+KZ5nv48PGJR/eJP6gAP5chMrHNLYE6zE=</DocCode><LegDocName>wOIECUVi+elT/P13+bAWTQ==</LegDocName><LegDocType>01</LegDocType><LegDocCode>JUDomc3FDNeHsyeGRCqMtlEBvQdWV4Mp2Btzp5pK8U8=</LegDocCode><Level>01</Level><RiskType>01</RiskType><ValidDate>2020-10-09</ValidDate><ValidStatus>01</ValidStatus><CusType>03</CusType><Occurarea>340000</Occurarea><BankNo>YG+Fyi2MBEs5uiEzUmIivg==</BankNo><Url>FhsKdLUas/ZrfDeKgwdhZw==</Url><RegisteredCode></RegisteredCode></RiskInfo><RiskInfo><RegName>+CtXdZOWRSU7WACPDECL5A==</RegName><CusName>rUY8slM8ksIJYzZheCOThQ==</CusName><DocType>01</DocType><DocCode>jUa748gw5bnfjFbsdLzrAg==</DocCode><LegDocName>VK+GjnErtL1fRnXUB5kzzA==</LegDocName><LegDocType>01</LegDocType><LegDocCode>IO9yPuUTOFVQdIDYiO9X5B/eJP6gAP5chMrHNLYE6zE=</LegDocCode><Level>01</Level><RiskType>02</RiskType><ValidDate>2020-09-30</ValidDate><ValidStatus>01</ValidStatus><CusType>02</CusType><Occurarea>430000</Occurarea><BankNo>ENA9/BLKyjJgtgZeehIZyg==</BankNo><Url>5T6xy9UkXWFkNBojoK7/IQ==</Url><RegisteredCode>7PcP+bUtrViSjhpk9gseew==</RegisteredCode></RiskInfo><RiskInfo><RegName>YW/h1LpTL6/XnblAizLCew==</RegName><CusName>rUY8slM8ksIJYzZheCOThQ==</CusName><DocType>01</DocType><DocCode>jUa748gw5bnfjFbsdLzrAg==</DocCode><LegDocName>tXtN8aqIn/lNGXICks1njQ==</LegDocName><LegDocType>01</LegDocType><LegDocCode>IO9yPuUTOFVQdIDYiO9X5Ka7lp3kxs7XfHZ0b2kcjFY=</LegDocCode><Level>01</Level><RiskType>02</RiskType><ValidDate>2020-09-30</ValidDate><ValidStatus>01</ValidStatus><CusType>02</CusType><Occurarea>430000</Occurarea><BankNo>+RAeauGnVVO7jMNZ5E4koA==</BankNo><Url>FhsKdLUas/ZrfDeKgwdhZw==</Url><RegisteredCode>+RAeauGnVVO7jMNZ5E4koA==</RegisteredCode></RiskInfo><RiskInfo><RegName>CgP8Ru8sXUvHUNcwzUHbrNhw343rkvqzqPiC1tY+YPw=</RegName><CusName>CgP8Ru8sXUvHUNcwzUHbrNhw343rkvqzqPiC1tY+YPw=</CusName><DocType>03</DocType><DocCode>sInqs+8UFsjtqPiIBsUxUA==</DocCode><LegDocName>jMKCo/BzY7AaXyw6exWz7w==</LegDocName><LegDocType>02</LegDocType><LegDocCode>GusPxCQqhI3RWqQhWYV6wg==</LegDocCode><Level>01</Level><RiskType>03</RiskType><ValidDate>2023-09-21</ValidDate><ValidStatus>01</ValidStatus><CusType>03</CusType><Occurarea>130000,140000</Occurarea><BankNo>OKJPSgdLUHixPPVuCdFzMQ==</BankNo><Url>l3JbkooSLEMThnGUR8AgbQ==</Url><RegisteredCode></RegisteredCode></RiskInfo><RiskInfo><RegName>CgP8Ru8sXUvHUNcwzUHbrF+TxadZqlK/ZBzjurg0VoA=</RegName><CusName>CgP8Ru8sXUvHUNcwzUHbrF+TxadZqlK/ZBzjurg0VoA=</CusName><DocType>03</DocType><DocCode>/XwjV9cvlugYREP/vmma8g==</DocCode><LegDocName>CgP8Ru8sXUvHUNcwzUHbrF+TxadZqlK/ZBzjurg0VoA=</LegDocName><LegDocType>04</LegDocType><LegDocCode>r9mQQKVQpr15HUYrQtb1hA==</LegDocCode><Level>01</Level><RiskType>01</RiskType><ValidDate>2023-09-21</ValidDate><ValidStatus>01</ValidStatus><CusType>02</CusType><Occurarea>130000</Occurarea><BankNo>GusPxCQqhI3RWqQhWYV6wg==</BankNo><Url>UdPsN1KitGVOd9GxV7wbFg==</Url><RegisteredCode></RegisteredCode></RiskInfo><RiskInfo><RegName>FPOL+AJeztrPMxQzRTjP/bVqJbWFrFpnAdm2eFE3+F4=</RegName><CusName>vsr3W7hCuG/FTRnaG40w4g==</CusName><DocType>99</DocType><DocCode>frzngH0pe5Dls/oLtMhVzg==</DocCode><LegDocName>tDBLjaq+5ZGOkfrFUWAZ9A==</LegDocName><LegDocType>04</LegDocType><LegDocCode>dyffdOSsP6KZdZJ0OouEkw==</LegDocCode><Level>01</Level><RiskType>01</RiskType><ValidDate>2020-09-29</ValidDate><ValidStatus>01</ValidStatus><CusType>02</CusType><Occurarea>350800</Occurarea><BankNo>qFS0/LMGiMM0cn/+03DgZg==</BankNo><Url></Url><RegisteredCode></RegisteredCode></RiskInfo><RiskInfo><RegName>S9dZl34zwL6acJG4mRlYVA==</RegName><CusName>qg+jg2ZHNSicuXRK7mzZ1w==</CusName><DocType>99</DocType><DocCode>Eq6+KtVItfhm03CyuziKiQ==</DocCode><LegDocName>pGABIPJpAKo96O8yjhBirQ==</LegDocName><LegDocType>99</LegDocType><LegDocCode>q9yAnUqD4PDprN08vkigDA==</LegDocCode><Level>01</Level><RiskType>01</RiskType><ValidDate>2020-12-01</ValidDate><ValidStatus>01</ValidStatus><CusType>02</CusType><Occurarea>450000</Occurarea><BankNo>IZoxi34R+QDJTYdBDS1UcGSyE4Obr+Lbaa8qXOUHkLQ=</BankNo><Url>FhsKdLUas/ZrfDeKgwdhZw==</Url><RegisteredCode></RegisteredCode></RiskInfo><RiskInfo><RegName>IA2m4/LUU330FHhaLgmiaQ==</RegName><CusName></CusName><DocType>99</DocType><DocCode></DocCode><LegDocName>EuOCfa178O5n7Gv8Bxpbkw==</LegDocName><LegDocType>01</LegDocType><LegDocCode>vsC27WK2nUMA8ET4NyzrC6fXtZ0/MWRN/LfQq2kK3Ts=</LegDocCode><Level>01</Level><RiskType>01</RiskType><ValidDate>2020-09-30</ValidDate><ValidStatus>01</ValidStatus><CusType>04</CusType><Occurarea>120101</Occurarea><BankNo>k1hbwHdPsMAovOdHOUWHDA==</BankNo><Url></Url><RegisteredCode>ARfGUmvfWXJ/ytQhRKuCyA==</RegisteredCode></RiskInfo><RiskInfo><RegName>VX/2/b23ka9c2diDKAi6C96sbFEKsEKKokqZ86+FFbvHH/PsRaNfea9KB0XPmt0bvCSzZEt7Yxv7lppkHQSuUCMXDgDCSBGpewFoShiKWkM=</RegName><CusName></CusName><DocType></DocType><DocCode></DocCode><LegDocName>wOIECUVi+elT/P13+bAWTQ==</LegDocName><LegDocType>01</LegDocType><LegDocCode>rnq62OOgizvNJIp2sK403R/eJP6gAP5chMrHNLYE6zE=</LegDocCode><Level>01</Level><RiskType>42</RiskType><ValidDate>2020-10-09</ValidDate><ValidStatus>01</ValidStatus><CusType>04</CusType><Occurarea>340000</Occurarea><BankNo></BankNo><Url>FhsKdLUas/ZrfDeKgwdhZw==</Url><RegisteredCode>dX2Mii4DDPpWV+lRRPxrvg==</RegisteredCode></RiskInfo><RiskInfo><RegName>dwQzvTU0kUsWj9VVcsGAoey/zmXL2XbG2zHbZCqu1AtjE1P8j/wiw4pHTHNTQuYb</RegName><CusName>kC+BmYxmVbuIM0rHPBA+lw==</CusName><DocType>02</DocType><DocCode>JiqspbI4QN/AaDVJtzueomoxmsXFDctUqid4Utv9Wr8=</DocCode><LegDocName>rsDK808P+xUNmbOsU56kHg==</LegDocName><LegDocType>01</LegDocType><LegDocCode>omJLNjI/+3taQAaS3ClFmfOBYDANKkqHlFyuJrKi38g=</LegDocCode><Level>01</Level><RiskType>01</RiskType><ValidDate>2020-09-25</ValidDate><ValidStatus>01</ValidStatus><CusType>04</CusType><Occurarea>110102</Occurarea><BankNo>abLLgng7KpXGQGPX/VmR0A==</BankNo><Url></Url><RegisteredCode>FHEK9nN5rcoDNMHI/HbOvw==</RegisteredCode></RiskInfo><RiskInfo><RegName>U2gTHe4Hp/JrYbwlV2dkQA==</RegName><CusName></CusName><DocType>01</DocType><DocCode>FQtpQRGMtmLLAWy6qDi8gQ==</DocCode><LegDocName>U2gTHe4Hp/JrYbwlV2dkQA==</LegDocName><LegDocType>01</LegDocType><LegDocCode>+yZPIYg20nPqKEalJnZX3a7iKQOkfKHKN894u08ODfg=</LegDocCode><Level>01</Level><RiskType>42</RiskType><ValidDate>2020-09-30</ValidDate><ValidStatus>01</ValidStatus><CusType>04</CusType><Occurarea>340100</Occurarea><BankNo></BankNo><Url></Url><RegisteredCode></RegisteredCode></RiskInfo><RiskInfo><RegName>n9QaEcqDivxO8tifQfEIMl+TxadZqlK/ZBzjurg0VoA=</RegName><CusName></CusName><DocType></DocType><DocCode></DocCode><LegDocName>n9QaEcqDivxO8tifQfEIMl+TxadZqlK/ZBzjurg0VoA=</LegDocName><LegDocType>03</LegDocType><LegDocCode>l3JbkooSLEMThnGUR8AgbQ==</LegDocCode><Level>01</Level><RiskType>01</RiskType><ValidDate>2023-09-21</ValidDate><ValidStatus>01</ValidStatus><CusType>04</CusType><Occurarea>120000,130000</Occurarea><BankNo>9BBIu+mrZN/E7QZW8En58w==</BankNo><Url>kbqecZHcSK2z9bgFN8Rs1w==</Url><RegisteredCode>yd2WDNr9oNa4LONZBX2Sjg==</RegisteredCode></RiskInfo><RiskInfo><RegName>MP/1zdqEd5MYgSGUDev7XW2tSPB5278ar8QoehtCkEI=</RegName><CusName></CusName><DocType></DocType><DocCode></DocCode><LegDocName>tchLiw4ORFr6D77c0fOptw==</LegDocName><LegDocType>05</LegDocType><LegDocCode>6tmmBrXRvyIXxVLGOvyZoA==</LegDocCode><Level>01</Level><RiskType>42</RiskType><ValidDate>2020-09-30</ValidDate><ValidStatus>01</ValidStatus><CusType>04</CusType><Occurarea>210200</Occurarea><BankNo></BankNo><Url>UEJK6xjrWQCr27ayoCmmRg==</Url><RegisteredCode>qjt0ouDyYaF4nYSpjuXPVw==</RegisteredCode></RiskInfo><RiskInfo><RegName>5FTjes9erRpPqi1TPNbCKmoXCAmVg/GPG0I3jkYEzic=</RegName><CusName>iSmMbMNzub6NAgDVXPIZ5A==</CusName><DocType>01</DocType><DocCode>WVsXXy5mat+6sKk1REcNog==</DocCode><LegDocName>9rhJu9Rf+7K8CdUJqvrOyQ==</LegDocName><LegDocType>99</LegDocType><LegDocCode>Xow7kU2RHO6dFNXjHhOtww==</LegDocCode><Level>02</Level><RiskType>03</RiskType><ValidDate>2020-09-28</ValidDate><ValidStatus>01</ValidStatus><CusType>02</CusType><Occurarea>510300</Occurarea><BankNo>ke55383Ub+HTzgd771J4Lg==</BankNo><Url></Url><RegisteredCode></RegisteredCode></RiskInfo><RiskInfo><RegName>yjH/aiK4Szl62NY666Glt8c/PIqwV/4lfLucQoJrTnw=</RegName><CusName>odxMfP1oS+tmKrBfo7VGqShmt9VF7o4h/5rRvEuhHUk=</CusName><DocType>01</DocType><DocCode>G1tSWJkU1seitJrIzjV3Dg==</DocCode><LegDocName>4vmsbk5bapBcwegNedG4jg==</LegDocName><LegDocType>01</LegDocType><LegDocCode>jUa748gw5bnfjFbsdLzrAg==</LegDocCode><Level>02</Level><RiskType>12</RiskType><ValidDate>2020-09-22</ValidDate><ValidStatus>01</ValidStatus><CusType>02</CusType><Occurarea>110000</Occurarea><BankNo>u7gh25DbIw4Yv9oaAcEsr3t6DkG56BZwewhW/nrK1y4=</BankNo><Url></Url><RegisteredCode></RegisteredCode></RiskInfo><RiskInfo><RegName>wXGBIfJpT4W1SlsLugwIwkLeBgQ1VfJgiSho8j1UXUw=</RegName><CusName>5naPsynlql2w14jVKPSTuw==</CusName><DocType>02</DocType><DocCode>dqJ7ZmStg6dUJY5LzsndP9eDHXcsR0hKqbveNCjyNUM=</DocCode><LegDocName>IxT/F5GZcbEehhfvUfzugA==</LegDocName><LegDocType>01</LegDocType><LegDocCode>omJLNjI/+3taQAaS3ClFmfOBYDANKkqHlFyuJrKi38g=</LegDocCode><Level>02</Level><RiskType>22</RiskType><ValidDate>2020-09-30</ValidDate><ValidStatus>01</ValidStatus><CusType>02</CusType><Occurarea>110102</Occurarea><BankNo>abLLgng7KpXGQGPX/VmR0A==</BankNo><Url></Url><RegisteredCode>dNy8kyHjvcf157ZmQJNzAQ==</RegisteredCode></RiskInfo><RiskInfo><RegName>4VaLBNXoIAmr+neww9AVVQ==</RegName><CusName>4VaLBNXoIAmr+neww9AVVQ==</CusName><DocType>01</DocType><DocCode>cNW0aHLYqrgMeld7YgaFHg==</DocCode><LegDocName>AgD+LPKdOnuixvbTzElbCA==</LegDocName><LegDocType>01</LegDocType><LegDocCode>tORNW1KXCCPMsN4AS3DxeSWBFqnQ3npYrnCMrBj32vI=</LegDocCode><Level>02</Level><RiskType>07</RiskType><ValidDate>2020-10-10</ValidDate><ValidStatus>01</ValidStatus><CusType>01</CusType><Occurarea>110000</Occurarea><BankNo>tORNW1KXCCPMsN4AS3DxeSWBFqnQ3npYrnCMrBj32vI=</BankNo><Url></Url><RegisteredCode></RegisteredCode></RiskInfo><RiskInfo><RegName>wSB8CK9fVsyVun30Z/tsVNfDwKw9q7GmgVdTaTp772A=</RegName><CusName>xnUAytVbAFp6PahuXKwyfw==</CusName><DocType>01</DocType><DocCode>+A1tLRBkUGe0kVtrHwo2GA==</DocCode><LegDocName>gaDDCIvmToP3vmn7RXFwMA==</LegDocName><LegDocType>01</LegDocType><LegDocCode>Yh01poabLTDhtjgsBfQvDhE2wKOy1C3OvI9/y5U7jZw=</LegDocCode><Level>02</Level><RiskType>06</RiskType><ValidDate>2020-12-30</ValidDate><ValidStatus>01</ValidStatus><CusType>02</CusType><Occurarea>610000</Occurarea><BankNo>ZPrqtB3q53HpC1WESsFkkL6cuWcoSBft5NI6Z6MBPxk=</BankNo><Url>QpEspjeiwMrVXV6Z5QjFuqwARfJXtN5npqHVQRCBItc=</Url><RegisteredCode>NHGyBEV45GGDSn2a776HBw==</RegisteredCode></RiskInfo><RiskInfo><RegName>xb0az8s747y6USLqBF2A7U8JDHumkThUFgJyv+hewhP7vJWo7yBaMB5iRwuBH/lr</RegName><CusName></CusName><DocType>01</DocType><DocCode>KuFohiefaMgEOARog9nRnA==</DocCode><LegDocName>Gb09C6zmkl1zq4n/TV0idg==</LegDocName><LegDocType>01</LegDocType><LegDocCode>fKv+uq/0bu2Yj3s+eoAWRsvkgWKdOLL+CfIGKy6lFOI=</LegDocCode><Level>02</Level><RiskType>11</RiskType><ValidDate>2021-10-21</ValidDate><ValidStatus>01</ValidStatus><CusType>02</CusType><Occurarea>511500</Occurarea><BankNo>TyLlZJDuhsDuW2sW7n5dMsuMCYL8Y0HdJh6y06G/VSQ=</BankNo><Url></Url><RegisteredCode></RegisteredCode></RiskInfo><RiskInfo><RegName>L6EM6sHTGfSzXRcMrkXf7XbSOW4LhjnSMvmIHEw9fh0=</RegName><CusName>sKRbiN/VGOqcKer1zGHQuA==</CusName><DocType>02</DocType><DocCode>ogInbLH1xGSpmgx6E10PMB/eJP6gAP5chMrHNLYE6zE=</DocCode><LegDocName>wOIECUVi+elT/P13+bAWTQ==</LegDocName><LegDocType>01</LegDocType><LegDocCode>aWITuAd7DQxdiFpuLqus/R/eJP6gAP5chMrHNLYE6zE=</LegDocCode><Level>01</Level><RiskType>01</RiskType><ValidDate>2020-09-30</ValidDate><ValidStatus>02</ValidStatus><CusType>03</CusType><Occurarea>220000</Occurarea><BankNo>toA4/yxhzVK1TJHiC/M/iw==</BankNo><Url>FhsKdLUas/ZrfDeKgwdhZw==</Url><RegisteredCode></RegisteredCode></RiskInfo><RiskInfo><RegName>B+EfR6EPrfzEJWAkQFk6nMuMCYL8Y0HdJh6y06G/VSQ=</RegName><CusName>kojBq+6+utjnAMuWvCLMvQ==</CusName><DocType>99</DocType><DocCode>Eq6+KtVItfhm03CyuziKiQ==</DocCode><LegDocName>pGABIPJpAKo96O8yjhBirQ==</LegDocName><LegDocType>99</LegDocType><LegDocCode>q9yAnUqD4PDprN08vkigDA==</LegDocCode><Level>01</Level><RiskType>01</RiskType><ValidDate>2022-02-01</ValidDate><ValidStatus>02</ValidStatus><CusType>01</CusType><Occurarea>450000</Occurarea><BankNo>aLdjzhFAHbSumZrFOKCUuw==</BankNo><Url>aM/d7D2iIKd8I8Hf0jVxSEoOuIwdwl390RTKwREC61w=</Url><RegisteredCode>fVeLsOKMwuOIXluKO6uqIw==</RegisteredCode></RiskInfo><RiskInfo><RegName>cfvEQGsDjGG+eeBdXbyA0A==</RegName><CusName>cfvEQGsDjGG+eeBdXbyA0A==</CusName><DocType>01</DocType><DocCode>F/ndw/ioTTlnIjJ/yqT+Ug==</DocCode><LegDocName>VeDOslPdLmtwLGhgdgH/yw==</LegDocName><LegDocType>01</LegDocType><LegDocCode>KUqtT0vGY06g0Y6TjYrxuh/eJP6gAP5chMrHNLYE6zE=</LegDocCode><Level>01</Level><RiskType>01</RiskType><ValidDate>2020-09-24</ValidDate><ValidStatus>02</ValidStatus><CusType>01</CusType><Occurarea>340000</Occurarea><BankNo>6U2L4DX49y6c72junb0rsw==</BankNo><Url>FhsKdLUas/ZrfDeKgwdhZw==</Url><RegisteredCode></RegisteredCode></RiskInfo><RiskInfo><RegName>kI66D9CVH9GV3si5a0fmDySiGVfYP3sbQ8TtqQsib7M=</RegName><CusName>2QURyl52M+d85q7OS9Yo9A==</CusName><DocType>02</DocType><DocCode>SPRXKGqYD/b+kJGQCkU/jB/eJP6gAP5chMrHNLYE6zE=</DocCode><LegDocName>wOIECUVi+elT/P13+bAWTQ==</LegDocName><LegDocType>01</LegDocType><LegDocCode>g3G4HS3I2w0BnD0v1YB4/B/eJP6gAP5chMrHNLYE6zE=</LegDocCode><Level>01</Level><RiskType>01</RiskType><ValidDate>2020-09-30</ValidDate><ValidStatus>02</ValidStatus><CusType>03</CusType><Occurarea>340000,340100</Occurarea><BankNo>rx7OVCoFbTjfpTk/ovj37A==</BankNo><Url>FhsKdLUas/ZrfDeKgwdhZw==</Url><RegisteredCode></RegisteredCode></RiskInfo></PcacList></Body></Request><Signature>GKShbbdHURZE8zWbIFyLrzK6gJ764utS4K3FiX8YgBRVFKRK4auEOjf/3G7bsSpSq6p09d7/YckPmjvXBlqpifvPs/PnJQj0xe7lqVAf3/0WFBfG77Ln+7xmkX6lM/FNE+bcMEuCshO3XbjiRSqE8nWIUofF2AumHCU6cCb/ebQQpuYSgti2c5RnCwC8PEIq/yDAAKi1fEuEQd/52smSQqTcxJ5/BMkvxa3fYk8e2I1UjUD7VyFxmN6EewNTzcuDqx9JeCu9x6X5JA12IYm4AqqKWyucQWaVju1UirMtf6gNKisqdcFRxEeE0htXSqxBLo5Uztq5o7wiyR8mgiZuyA==</Signature></Document>";
        String s = pcacRiskInfoPushController.blackListAndTipsInfo(doxml);
        System.out.println(s);
    }

    @Test
    public  void test04(){
        ReissueRiskInfoReq reissueRiskInfoReq = new ReissueRiskInfoReq();
        reissueRiskInfoReq.setReqDate("2020-09-01");
        reissueRiskInfoReq.setReqDateEnd("2020-09-05");
        reissueRiskInfoReq.setRiskType("01");
        ResultBean resultBean = pcacRiskInfoPushController.reissueRiskInfo(reissueRiskInfoReq);
        System.out.println("响应结果："+resultBean);
    }

    @Test
    public  void test05(){
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Document><Request><Head><Version>V1.3.0</Version><Identification>202009226750826702</Identification><OrigSender>Z2004343000017</OrigSender><OrigSenderSID>Z2004343000017</OrigSenderSID><RecSystemId>R0001</RecSystemId><TrnxCode>TS0001</TrnxCode><TrnxTime>20200922161100</TrnxTime><UserToken>pcac</UserToken><SecretKey>VaZTiEkbpkKq8FnTvhE0O0qxhqWbxawXcQVPynvrNhtFjoqXP5A8+Twf4Rflp6Sbw2BcDPIybNX9oAulmzAbPH8k5508FTSWFcNFuzzYRTJuvZyOkU2tFz9RzrBpItwv5TPstXYuXtALmBfVn8HGP35jLtIldIX513TVliyNVzSxYG0gAip0Dn6sWWts+Ar66/0b/VT/5f7+qsC6SScOat8kisZSqt8moQs9jlLSr9r7/DzbvkL6p6vE447GxKQGquHgjnK63yu3/QtZS5nQtjEHrRySdG4ZtbpW2yOWWttiTrqvBx1B1ALPsO70EFZ6Jd06wN4BoeHO8g6rApea9g==</SecretKey></Head><Body><PcacList><Count>41</Count><UpDate>2020-09-24</UpDate><EntInfo><CusCode>zyjk</CusCode><RegName>中医金科</RegName><LegDocName>刘东</LegDocName><Differents><CusCode>zyjkdd</CusCode><RegName>中医金科dd</RegName><LegDocName>刘东dd</LegDocName></Differents><Differents><CusCode>111zyjkdd</CusCode><RegName>111中医金科dd</RegName><LegDocName>111刘东dd</LegDocName></Differents></EntInfo></PcacList></Body></Request><Signature>GKShbbdHURZE8zWbIFyLrzK6gJ764utS4K3FiX8YgBRVFKRK4auEOjf/3G7bsSpSq6p09d7/YckPmjvXBlqpifvPs/PnJQj0xe7lqVAf3/0WFBfG77Ln+7xmkX6lM/FNE+bcMEuCshO3XbjiRSqE8nWIUofF2AumHCU6cCb/ebQQpuYSgti2c5RnCwC8PEIq/yDAAKi1fEuEQd/52smSQqTcxJ5/BMkvxa3fYk8e2I1UjUD7VyFxmN6EewNTzcuDqx9JeCu9x6X5JA12IYm4AqqKWyucQWaVju1UirMtf6gNKisqdcFRxEeE0htXSqxBLo5Uztq5o7wiyR8mgiZuyA==</Signature></Document>\n";
        String result = pcacAssistanceController.assistanceInfo(xml);
        System.out.println(result);
    }

    public static void main(String[] args) {
        Date date = new Date();
        for (int i = 0; i <10000 ; i++) {

            int random = new Random().nextInt(1000) + 1000;
            String identification = DateUtils.formatTime(date, "yyyyMMdd") + "100000" + random;
            System.out.println(identification);
        }
    }

}
