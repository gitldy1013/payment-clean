package com.cmcc.paymentclean.utils;

import cfca.sadk.algorithm.common.Mechanism;
import cfca.sadk.lib.crypto.JCrypto;
import cfca.sadk.lib.crypto.Session;
import cfca.sadk.util.Base64;
import cfca.sadk.util.EncryptUtil;
import cfca.sadk.util.KeyUtil;
import cfca.sadk.util.Signature;
import cfca.sadk.x509.certificate.X509Cert;
import com.cmcc.paymentclean.consts.DocTypeEnum;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import static com.cmcc.paymentclean.utils.CodeGenerator.BASE_MAPPER_ROOT;
import static com.cmcc.paymentclean.utils.CodeGenerator.PROJECT_PATH;

/**
 * @author zhaolei
 * @date 2020-09-02 08:49
 */
public class CFCACipherUtils {


    private static final Logger logger = LoggerFactory.getLogger(CFCACipherUtils.class);
    // 签名证书（带私钥）
    //private static String pfxFilePath = "E:/cert/协会证书私钥证书.pfx";
    // 签名证书保护密码
    //private static String pfxFilePwd = "11111111";
    // 签名证书公钥证书
    //private static String publicCertFilePath = PROJECT_PATH + BASE_MAPPER_ROOT +"/cert/pcac.cer";
    private static String publicCertFilePath = PROJECT_PATH + BASE_MAPPER_ROOT + "cert/pcac.cer";

    // 解密证书（带私钥）
    private static String encPfxFilePath = PROJECT_PATH + BASE_MAPPER_ROOT + "cert/huiyuan.pfx";
    // 解密证书保护密码
    private static String encPfxFilePwd = "cfca1234";
    // 加密证书公钥证书
    //private static String encPublicCertFilePath = PROJECT_PATH + BASE_MAPPER_ROOT +"/cert/huiyuan.cer";
    private static Session session = null;

    static {
        try {
            JCrypto.getInstance().initialize(JCrypto.JSOFT_LIB, null);

            session = JCrypto.getInstance().openSession(JCrypto.JSOFT_LIB);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 数据加签
     * 发送方使用会员单位私钥对原文信息进行签名
     */
    public static String doSignature(String srcData) {
        String encodedSignature = null;
        // 初始化加密会话
        try {
            logger.info("需要加签原数据:{}", srcData);
            /*JCrypto.getInstance().initialize(JCrypto.JSOFT_LIB, null);
            Session session = JCrypto.getInstance().openSession(JCrypto.JSOFT_LIB);*/
            logger.debug("私钥路径:{}", encPfxFilePath);
            // 获取私钥
            PrivateKey priKey = KeyUtil.getPrivateKeyFromPFX(encPfxFilePath, encPfxFilePwd);

            Signature sigUtil = new Signature();
            byte[] signature = sigUtil.p1SignMessage(Mechanism.SHA1_RSA, srcData.getBytes(StandardCharsets.UTF_8), priKey, session);
            /********注意***********/
            // 签名结果已经做过Base64编码
            encodedSignature = new String(signature);
        } catch (Exception e) {
            logger.info("-----数据加签失败");
            e.printStackTrace();
        }

        return encodedSignature;

    }

    /**
     * 数据验签
     * 发送方使用清算协会公钥对信息进行验签
     */
    public static boolean verifySignature(String srcData, String encodedSignature) {

        try {
            // 初始化加密会话
            /*JCrypto.getInstance().initialize(JCrypto.JSOFT_LIB, null);
            Session session = JCrypto.getInstance().openSession(JCrypto.JSOFT_LIB);*/

            // 获取清算协会公钥
            //FileInputStream fin = new FileInputStream(publicCertFilePath);
            FileInputStream fin = new FileInputStream(publicCertFilePath);
            X509Cert cert = new X509Cert(fin);
            Signature sigUtil = new Signature();
            PublicKey pubKey = cert.getPublicKey();
            if (sigUtil.p1VerifyMessage(Mechanism.SHA1_RSA, srcData.getBytes("UTF-8"), Base64.decode(encodedSignature), pubKey, session)) {
                logger.info("RSA P1 verify OK!");
                return true;
            }
        } catch (Exception e) {
            logger.info("RSA P1 verify FAILER!");
            e.printStackTrace();
        }
        logger.info("RSA P1 verify FAILER!");
        return false;
    }

    /**
     * 获取AES加密随机密码
     */
    public static byte[] getSymmetricKeyEncoded() {

        byte[] symmetricKeyEncoded = null;
        // 生成对称AES密钥
        KeyGenerator kgen = null;
        try {
            kgen = KeyGenerator.getInstance("AES");
            logger.info("---------------AES密钥:{}", new SecureRandom());
            kgen.init(128, new SecureRandom());
            SecretKey secretKey = kgen.generateKey();

            symmetricKeyEncoded = secretKey.getEncoded();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return symmetricKeyEncoded;
    }

    /**
     * 获取经过rsa公钥加密的AES密码密钥串
     */
    public static String getSecretKey(byte[] symmetricKeyEncoded) {

        //AES密钥加密后数据
        String encryptedKey = null;

        try {
            // 获取接收方公钥
            FileInputStream fin = new FileInputStream(publicCertFilePath);
            X509Cert cert = new X509Cert(fin);
            //*********************************************//*
            // 去掉外层Base64编码，在方法体内部已经做过Base64编码
            encryptedKey = new String(EncryptUtil.encryptMessageByRSA(symmetricKeyEncoded, cert, session));
            logger.info("使用对方公钥加密后的密钥密文（经Base64编码）:{}", encryptedKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedKey;
    }


    /**
     * 数据加密，AES密钥加密字符串数据
     */
    public static String encrypt(byte[] symmetricKeyEncoded, String toBeEncData) {
        //AES加密后数据
        String encrytedData = null;
        if(StringUtils.isEmpty(toBeEncData)){
            return "";
        }

        Map<String, String> encryptMap = new HashMap<String, String>();
        try {


            SecretKeySpec key = new SecretKeySpec(symmetricKeyEncoded, "AES");

            // 对称加密
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            byte[] byteContent = toBeEncData.getBytes("UTF-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result = cipher.doFinal(byteContent);

            encrytedData = new String(Base64.encode(result));
            logger.info("使用AES对称密钥加密后的密文（经Base64编码）:{}", encrytedData);

        } catch (Exception e) {
            logger.info("加密数据失败");
            e.printStackTrace();
        }
        return encrytedData;
    }


    /**
     * 数据解密
     * secretKey为加密后的AES密钥
     * toBeDecStr为需要解密的字符串
     */
    public static String decrypt(String secretKey, String toBeDecStr) {
        if(StringUtils.isEmpty(toBeDecStr)){
            return "";
        }
        String decryptedData = null;
        try {
            // 初始化加密会话
            /*JCrypto.getInstance().initialize(JCrypto.JSOFT_LIB, null);
            Session session = JCrypto.getInstance().openSession(JCrypto.JSOFT_LIB);*/

            // 解密对称密钥
            PrivateKey priKey = KeyUtil.getPrivateKeyFromPFX(encPfxFilePath, encPfxFilePwd);
            /*********************************************/
            // 去掉外层Base64解码，在方法体内部已经做过Base64解码
            byte[] keyData = EncryptUtil.decryptMessageByRSA(secretKey.getBytes(), priKey, session);
            SecretKeySpec symmetricKey = new SecretKeySpec(keyData, "AES");

            // 解密被加密的项，可使用对称密钥对多个加密项进行解密
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, symmetricKey);
            byte[] result = cipher.doFinal(Base64.decode(toBeDecStr));
            decryptedData = new String(result, "UTF-8");
            logger.info("解密后的原文数据:{}", decryptedData);

        } catch (Exception e) {
            logger.info("解密数据失败");
            e.printStackTrace();
        }
        return decryptedData;
    }


    public static String getInnerToCFCA(String docType, String docCode, byte[] symmetrickeyencoded) {
        if (DocTypeEnum.DOCTYPEENUM_01.getCode().equals(docType)) {
            //内部解密
            //docCode = InnerCipherUtils.decryptUserData(docCode);
        }
        //协会加密
        return CFCACipherUtils.encrypt(symmetrickeyencoded, docCode);
    }

    public static void main(String[] args) {
        String signature = "Gx5kFLHK13WFj50I1HggC1cCOgA5RXLzs2sxk7WmyBq5ZYnrrFnkrYaym9jIbMOFBJsXb03/JWrtNAVXMiuZlNwCNudiKCmfzin84pAmLJUYTsa+MeMlkxagNkPPtEM2SSdn0pybWBVmTqYISswwcNOzZ8hfDIt3ezvK49oyMqrS6+5Tl8UfmKewecQAKGKSedJVAyD8uHkjZLgLjR4JvhWUZgz+SzRANnf4q5xf061v2Ek8c63bk0dPlc1YI5Ckq77Q9sBLnCUSBq/AuAsBaR6CrQySo7LgvAUnW/Y2ELW5WSgsxU4ZtZPiqnmpA5/MWud8HN8mCwqzbr845apg2A==";
        String a = "           <?xml version=\"1.0\" encoding=\"UTF-8\"?><Document><Request><Head><Version>V1.3.0</Version><Identification>202009161000001642</Identification><OrigSender>Z2015044000015</OrigSender><OrigSenderSID>zf_sysstem</OrigSenderSID><RecSystemId>R0001</RecSystemId><TrnxCode>LR0001</TrnxCode><TrnxTime>20200916164519</TrnxTime><SecretKey></SecretKey></Head></Request><Signature>EA1UBKVE2nr1tA+CwEc+8UNEgTiBFcUBv/mu8QsOqXhiQ23cwvGaOXeF4pARIoocA0qj+N83ROUzo2KoNT9snIm6Ogq/0/bwz+y07C/Hl18tflmPZQzYXQeZ+ETOZl9hJ2rvzH/GNtGUlALwHfz2ixHL8ngZwL7ZrjcRG55xqEDCmh5XlpvD27/8+eheAahnzCykvhX+p3aZ9yYHqTNfvSIXSCld8RVkYTNlnJnIt9bDMNqzoAM8dxocdw3XBn+0VF006ts8me+j/JtrcW1aJ/khqAM+yONJQ0ctMKDTY9ZEQzxYKBNqcydUWzhuvR66yHgMkoLfVOdhPC5EjSsSVg==</Signature></Document>";
        String srcData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Document><Respone><Head><Version>V1.3.0</Version><Identification>202009161000001371</Identification><OrigSender>Z2015044000015</OrigSender><OrigSenderSID>zf_sysstem</OrigSenderSID><RecSystemId>R0001</RecSystemId><TrnxCode>LR0001</TrnxCode><TrnxTime>20200916153928</TrnxTime><SecretKey></SecretKey></Head><Body><RespInfo><ResultStatus>02</ResultStatus><ResultCode>F00005</ResultCode><MsgDetail>验证签名失败</MsgDetail></RespInfo></Body></Respone></Document>";
        boolean b = verifySignature(srcData, signature);
        System.out.println("验签结果：" + b);
    }

}
