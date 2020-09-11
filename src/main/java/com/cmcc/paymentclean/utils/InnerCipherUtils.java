package com.cmcc.paymentclean.utils;

import com.cmcc.paymentclean.exception.InnerCipherException;
import com.union.api.UnionCSSP;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;

/**
 * @author zhaolei
 * @date 2020-09-11 22:41
 */
@Slf4j
public class InnerCipherUtils {

    final static Charset default_charset = Charset.forName("GBK");

    private static UnionCSSP cssp = new UnionCSSP();

    public static String encrypt(String message) throws InnerCipherException {
        /*
         * keyname为：HX.Userdata.zek，UAT测试环境访问地址与端口，172.16.50.233，22200。
         * 需要配置到jar包里面的servicerList.conf文件CSSP栏。
         * */
        log.debug("需加密数据：{}",message);
        String mode = "1";
        //String keyName = "EWM.test.zek";
        String keyName = "HX.USERDATA.zek";
        String keyValue = "";
        String algorithmID = "0";
        byte[] data = message.getBytes();
        String iv = "";
        String format = "2";
        String dataType = "0";
        String separator = "";
        UnionCSSP.Recv recv = cssp.servE160(mode, keyName, keyValue, algorithmID, data, iv, format, dataType, separator);
        if (recv != null) {
            if (recv.getResponseCode() == 0) {
                log.info("数据加密成功！！");
                return new String(recv.getData());
            } else {
                    throw  new InnerCipherException(recv.getResponseCode(),recv.getResponseRemark());
            }
        }else {
            throw  new InnerCipherException("内部加密服务异常");
        }
    }

    public static String  decrypt(String message) throws InnerCipherException {
        log.debug("需解密数据：{}",message);
        String mode = "1";
        String keyName = "HX.USERDATA.zek";
        String keyValue = "";
        String algorithmID = "0";
        String exportFlag = "0";
        byte[] data = message.getBytes();
        String iv = "";
        String format = "0";
        String separator = ";";
        UnionCSSP.Recv recv = cssp.servE161(mode, keyName, keyValue, algorithmID, exportFlag, data, iv, format, separator);
        if (recv != null) {
            if (recv.getResponseCode() == 0) {
                log.info("数据解密成功！！");
                return new String(recv.getData());

            } else {
                throw  new InnerCipherException(recv.getResponseCode(),recv.getResponseRemark());
            }
        }else {
            throw  new InnerCipherException("内部加密服务异常");
        }
    }

    public static void main(String[] args) {
        try {
            String encrypt = encrypt("110225199111182217");
            String decrypt = decrypt(encrypt);
        } catch (InnerCipherException e) {
            e.printStackTrace();
        }

    }
}
