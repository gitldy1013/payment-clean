package com.cmcc.paymentclean.utils;

import com.cmcc.paymentclean.exception.InnerCipherException;
import com.union.api.UnionCSSP;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.nio.charset.Charset;

/**
 * @author zhaolei
 * @date 2020-09-11 22:41
 */
@Slf4j
public class InnerCipherUtils {

  static final Charset default_charset = Charset.forName("GBK");

  private static UnionCSSP cssp = new UnionCSSP();

  private static final String BANKKN = "HX.Bankdata.edk";
  private static final String USERKN = "HX.Userdata.edk";

  /** 加密用户身份证号 */
  public static String encryptUserData(String message) {
    return StringUtils.isEmpty(message) ? "" : encrypt(message, USERKN);
  }

  private static String encrypt(String message, String keyName) {
    /*
     * keyname为：HX.Userdata.zek，UAT测试环境访问地址与端口，172.16.50.233，22200。
     * 需要配置到jar包里面的servicerList.conf文件CSSP栏。
     * */
    log.debug("需加密数据：{}", message);
    String mode = "1";
    // String keyName = "EWM.test.zek";
    // String keyName = "HX.USERDATA.zek";
    String keyValue = "";
    String algorithmID = "0";
    //byte[] data = message.getBytes();
    byte[] data = message.getBytes(Charset.forName("GBK"));
    String iv = "000000000000";
    String format = "1";
    String dataType = "0";
    String separator = null;
    UnionCSSP.Recv recv =
        cssp.servE160(mode, keyName, keyValue, algorithmID, data, iv, format, dataType, separator);
    if (recv != null) {
      if (recv.getResponseCode() == 0) {
        log.info("数据加密成功！！");
        return new String(recv.getData());
      } else {
        try {
          throw new InnerCipherException(recv.getResponseCode(), recv.getResponseRemark());
        } catch (InnerCipherException e) {
          log.error("异常:" + e);
          return message;
        }
      }
    } else {
      try {
        throw new InnerCipherException("内部加密服务异常");
      } catch (InnerCipherException e) {
        log.error("异常:" + e);
        return message;
      }
    }
  }

  /** 解密用户身份证号 */
  public static String decryptUserData(String message) {
    return StringUtils.isEmpty(message) ? "" : decrypt(message, USERKN);
  }

  /** 加密银行卡号 */
  public static String encryptBankData(String message) {
    return StringUtils.isEmpty(message) ? "" : encrypt(message, BANKKN);
  }

  private static String decrypt(String message, String keyName) {
    log.debug("需解密数据：{}", message);
    String mode = "1";
    // String keyName = "HX.BANKDATA.zek";
    String keyValue = "";
    String algorithmID = "0";
    String exportFlag = "0";
    //byte[] data = message.getBytes();
    byte[] data = message.getBytes(Charset.forName("GBK"));
    String iv = "000000000000";
    String format = "1";
    String separator = null;
    UnionCSSP.Recv recv =
        cssp.servE161(
            mode, keyName, keyValue, algorithmID, exportFlag, data, iv, format, separator);
    if (recv != null) {
      if (recv.getResponseCode() == 0) {
        log.info("数据解密成功！！");
        return new String(recv.getData());

      } else {
        try {
          throw new InnerCipherException(recv.getResponseCode(), recv.getResponseRemark());
        } catch (InnerCipherException e) {
          log.error("异常:" + e);
          return message;
        }
      }
    } else {
      try {
        throw new InnerCipherException("内部加密服务异常");
      } catch (InnerCipherException e) {
        log.error("异常:" + e);
        return message;
      }
    }
  }

  /** 解密银行卡号 */
  public static String decryptBankData(String message) {
    return StringUtils.isEmpty(message) ? "" : decrypt(message, BANKKN);
  }

  public static void main(String[] args) {

    String abc123123123123 = encryptUserData("330225199808274828");
    System.out.println(abc123123123123);

    String decrypt =
        decryptUserData(abc123123123123);
    System.out.println(decrypt);

  }
}
