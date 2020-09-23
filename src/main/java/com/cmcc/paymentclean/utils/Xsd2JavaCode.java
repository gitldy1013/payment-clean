package com.cmcc.paymentclean.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.cmcc.paymentclean.utils.CodeGenerator.BASE_MAPPER_ROOT;
import static com.cmcc.paymentclean.utils.CodeGenerator.BASE_SRC_ROOT;
import static com.cmcc.paymentclean.utils.CodeGenerator.PROJECT_PATH;

public class Xsd2JavaCode {

    private static final String BASE_PACKAGE = "com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac";

    public static final String XSD_DIR = PROJECT_PATH + BASE_MAPPER_ROOT + "xsds/";


    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        try {
            String res = "";
            String XSD_CODE = CodeGenerator.scanner("请输入对应的报文编号：");
            //xjc -encoding UTF-8 -p com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac059 C:\Users\liudongyang\IdeaProjects\payment-clean\src\main\resources\xsds\pcac.ries.013.xsd -d C:\Users\liudongyang\IdeaProjects\payment-clean\src\main\java\
            String execStr = "xjc -encoding UTF-8 -p " + BASE_PACKAGE + XSD_CODE +" "+ XSD_DIR + "pcac.ries." + XSD_CODE + ".xsd -d " + PROJECT_PATH + BASE_SRC_ROOT + "\n";
            System.out.println(execStr);
            Process exec = runtime.exec(execStr);
            InputStream in = exec.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = in.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            baos.close();
            in.close();
            byte[] lens = baos.toByteArray();
            String result = new String(lens, "GBK");//内容乱码处理
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
