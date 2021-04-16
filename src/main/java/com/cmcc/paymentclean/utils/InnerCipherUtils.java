package com.cmcc.paymentclean.utils;

import com.cmcc.paymentclean.exception.InnerCipherException;
import com.union.api.UnionCSSP;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * @author zhaolei
 * @date 2020-09-11 22:41
 */
@Slf4j
public class InnerCipherUtils {

  static final Charset DEFAULT_CHARSET = Charset.forName("GBK");
  // 1504172011060120302044800171819
  private static final String BANKKN = "HX.BANKCARD.EDK";
  private static final String USERKN = "HX.Userdata.edk";
  private static final String CIPHERSTR =
      "578F87458E1B8877AF22C3ACADC3CF49EA3664FA367959A595127BD852B4852507918FBD1515DE3C";
  private static UnionCSSP cssp = new UnionCSSP();

  /** 加密用户身份证号 */
  public static String encryptUserData(String message) {
    return StringUtils.isEmpty(message) ? "" : encrypt(message);
  }

  private static String encrypt(String message) {
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
    // byte[] data = message.getBytes();
    byte[] data = message.getBytes(DEFAULT_CHARSET);
    String iv = "000000000000";
    String format = "1";
    String dataType = "0";
    String separator = null;
    UnionCSSP.Recv recv =
        cssp.servE160(mode, InnerCipherUtils.USERKN, keyValue, algorithmID, data, iv, format, dataType, separator);
    if (recv != null) {
      if (recv.getResponseCode() == 0) {
        log.info("数据加密成功！！");
        return new String(recv.getData());
      } else {
        try {
          throw new InnerCipherException(recv.getResponseCode(), recv.getResponseRemark());
        } catch (InnerCipherException e) {
          e.printStackTrace();
          log.error("异常:" + e.getMessage());
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
    try {
      log.debug("银行卡密钥明文：{}", decrypt(CIPHERSTR, BANKKN));
      return StringUtils.isEmpty(message) ? "" : encryptMode(decrypt(CIPHERSTR, BANKKN), message);
    } catch (NoSuchAlgorithmException
        | InvalidKeyException
        | NoSuchPaddingException
        | BadPaddingException
        | InvalidKeySpecException
        | IllegalBlockSizeException
        | IOException e) {
      log.error("银行卡加密异常：" + e);
      return message;
    }
  }

  private static String decrypt(String message, String keyName) {
    log.debug("需解密数据：{}", message);
    String mode = "1";
    // String keyName = "HX.BANKDATA.zek";
    String keyValue = "";
    String algorithmID = "0";
    String exportFlag = "0";
    // byte[] data = message.getBytes();
    byte[] data = message.getBytes(DEFAULT_CHARSET);
    String iv = "000000000000";
    String format = "1";
    String separator = null;
    UnionCSSP.Recv recv =
        cssp.servE161(
            mode, keyName, keyValue, algorithmID, exportFlag, data, iv, format, separator);
    if (recv != null) {
      if (recv.getResponseCode() == 0) {
        log.debug("数据解密成功！！");
        return new String(recv.getData());

      } else {
        try {
          throw new InnerCipherException(recv.getResponseCode(), recv.getResponseRemark());
        } catch (InnerCipherException e) {
          e.printStackTrace();
          log.error("异常:" + e.getMessage());
          return message;
        }
      }
    } else {
      try {
        throw new InnerCipherException("内部加密服务异常");
      } catch (InnerCipherException e) {
        e.printStackTrace();
        log.error("异常:" + e.getMessage());
        return message;
      }
    }
  }

  /** 解密银行卡号 */
  public static String decryptBankData(String message) {
    try {
      log.debug("银行卡密钥明文：{}", decrypt(CIPHERSTR, BANKKN));
      return StringUtils.isEmpty(message) ? "" : decryptMode(decrypt(CIPHERSTR, BANKKN), message);
    } catch (Exception e) {
      e.printStackTrace();
      log.error("银行卡解密异常：" + e.getMessage());
      return message;
    }
  }

  public static void main(String[] args) {

    /*  String abc123123123123 = encryptUserData("330225199808274828");
    System.out.println(abc123123123123);

    String decrypt =
        decryptUserData(abc123123123123);
    System.out.println(decrypt);*/
    String encryptBankData = encryptBankData("626699000032111");
    System.out.println(encryptBankData);
    String decryptBankData = decryptBankData(encryptBankData);
    System.out.println(decryptBankData);
  }

  public static String decryptMode(String skey, String sdata) throws Exception {
    byte[] key = new BASE64Decoder().decodeBuffer(skey);
    byte[] data = new BASE64Decoder().decodeBuffer(sdata);

    Key deskey;
    DESedeKeySpec spec = new DESedeKeySpec(key);
    SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
    deskey = keyfactory.generateSecret(spec);
    Cipher cipher = Cipher.getInstance("desede/ECB/PKCS5Padding");
    cipher.init(2, deskey);
    byte[] bOut = cipher.doFinal(data);
    return new String(bOut, StandardCharsets.UTF_8);
  }

  public static String encryptMode(String skey, String sdata)
      throws IOException, InvalidKeyException, InvalidKeySpecException, NoSuchPaddingException,
          NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException {
    byte[] key = new BASE64Decoder().decodeBuffer(skey);
    byte[] data = sdata.getBytes(StandardCharsets.UTF_8);

    Key deskey;
    DESedeKeySpec spec = new DESedeKeySpec(key);
    SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
    deskey = keyfactory.generateSecret(spec);

    Cipher cipher = Cipher.getInstance("desede/ECB/PKCS5Padding");
    cipher.init(1, deskey);
    byte[] bOut = cipher.doFinal(data);

    return new BASE64Encoder().encode(bOut);
  }
}
