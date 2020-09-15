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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
    private static String publicCertFilePath = PROJECT_PATH + BASE_MAPPER_ROOT +"/cert/pcac.cer";

    // 解密证书（带私钥）
    private static String encPfxFilePath = PROJECT_PATH + BASE_MAPPER_ROOT +"/cert/huiyuan.pfx";
    // 解密证书保护密码
    private static String encPfxFilePwd = "cfca1234";
    // 加密证书公钥证书
    private static String encPublicCertFilePath = PROJECT_PATH + BASE_MAPPER_ROOT +"/cert/huiyuan.cer";
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
            byte[] signature = sigUtil.p1SignMessage(Mechanism.SHA1_RSA, srcData.getBytes("UTF8"), priKey, session);
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
            if (sigUtil.p1VerifyMessage(Mechanism.SHA1_RSA, srcData.getBytes("UTF8"), Base64.decode(encodedSignature), pubKey, session)) {
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
            FileInputStream fin = new FileInputStream(encPublicCertFilePath);
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
     * 使用AES随机密钥对map数据进行加密
     */
    public static Map<String, String> encrypt(byte[] symmetricKeyEncoded, Map<String, String> toBeEncMap) {
        //AES加密后数据
        String encrytedData = null;
        try {

            SecretKeySpec key = new SecretKeySpec(symmetricKeyEncoded, "AES");

            // 对称加密
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器

            Set<String> keySet = toBeEncMap.keySet();
            Iterator<String> iterator = keySet.iterator();
            while (iterator.hasNext()) {
                String mapkey = iterator.next();
                String toBeEncData = toBeEncMap.get(mapkey);
                byte[] byteContent = toBeEncData.getBytes("UTF-8");
                cipher.init(Cipher.ENCRYPT_MODE, key);
                byte[] result = cipher.doFinal(byteContent);

                encrytedData = new String(Base64.encode(result));
                logger.info("使用AES对称密钥加密后的密文（经Base64编码）:{}", encrytedData);
                toBeEncMap.put(mapkey, encrytedData);

            }

        } catch (Exception e) {
            logger.info("加密数据失败");
            e.printStackTrace();
        }
        return toBeEncMap;
    }



    /* *//*
     * 数据加密，AES密钥加密
     * *//*
    public static Map<String,String> encrypt(String toBeEncData) {
        //AES加密后数据
        String encrytedData = null;
        //AES密钥加密后密钥key
        String encryptedKey = null;
        Map<String,String> encryptMap = new HashMap<String,String>();
        try{
            // 初始化加密会话
            JCrypto.getInstance().initialize(JCrypto.JSOFT_LIB, null);
            Session session = JCrypto.getInstance().openSession(JCrypto.JSOFT_LIB);

            // 生成对称AES密钥
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom());
            SecretKey secretKey = kgen.generateKey();
            logger.info("---------------AES密钥:", secretKey.toString());
            byte[] symmetricKeyEncoded = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(symmetricKeyEncoded, "AES");

            // 对称加密
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            byte[] byteContent = toBeEncData.getBytes("UTF-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result = cipher.doFinal(byteContent);

            encrytedData = new String(Base64.encode(result));
            logger.info("使用AES对称密钥加密后的密文（经Base64编码）:{}" , encrytedData);

            // 获取接收方公钥
            //FileInputStream fin = new FileInputStream(publicCertFilePath);
            FileInputStream fin = new FileInputStream(encPublicCertFilePath);
            X509Cert cert = new X509Cert(fin);


    */

    /*********************************************//*
            // 去掉外层Base64编码，在方法体内部已经做过Base64编码
            encryptedKey = new String(EncryptUtil.encryptMessageByRSA(symmetricKeyEncoded, cert, session));
            logger.info("使用对方公钥加密后的会话密钥密文（经Base64编码）:{}" ,encryptedKey);
            encryptMap.put("encrytedData",encrytedData);
            encryptMap.put("encryptedKey",encryptedKey);
        }catch(Exception e){
            logger.info("加密数据失败");
            e.printStackTrace();
        }
        return encryptMap;
    }


    /**
     * 数据解密
     * secretKey为加密后的AES密钥
     * toBeDecMap为需要加密的字段map集合
     * */
    public static Map<String, String> decrypt(String secretKey, Map<String, String> toBeDecMap) {

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
            Set<String> keySet = toBeDecMap.keySet();
            Iterator<String> iterator = keySet.iterator();
            while (iterator.hasNext()) {
                String mapkey = iterator.next();
                String encrytedData = toBeDecMap.get(mapkey);
                byte[] result = cipher.doFinal(Base64.decode(encrytedData));
                String decryptedData = new String(result, "UTF-8");
                logger.info("解密后的原文数据:{}", decryptedData);
                toBeDecMap.put(mapkey, decryptedData);
            }
        } catch (Exception e) {
            logger.info("解密数据失败");
            e.printStackTrace();
        }
        return toBeDecMap;
    }

    public static String getInnerToCFCA(String docType, String docCode, byte[] symmetrickeyencoded) {
        if (DocTypeEnum.DOCTYPEENUM_01.getCode().equals(docType)) {
            //内部解密
            docCode = InnerCipherUtils.decrypt(docCode);
        }
        //协会加密
        return CFCACipherUtils.encrypt(symmetrickeyencoded, docCode);
    }

}
