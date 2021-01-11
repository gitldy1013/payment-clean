package com.cmcc.paymentclean.utils;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

/** http工具类 */
public class HttpClientUtils {

  private static final Logger log = LoggerFactory.getLogger(HttpClientUtils.class);

  /**
   * 发送http+get请求
   *
   * @param url
   * @return 返回结果
   * @throws Exception
   */
  public static String sendHttpGet(String url) throws Exception {
    CloseableHttpClient httpClient = HttpClients.createDefault();
    return doGet(url, httpClient);
  }

  /**
   * 发送https+get请求，绕过证书
   *
   * @param url 请求地址
   * @return 返回结果
   * @throws Exception
   */
  public static String sendHttpsGet(String url) {
    CloseableHttpClient httpClient = null;
    try {
      httpClient = createIgnoreVerifyHttpClient();
      return doGet(url, httpClient);
    } catch (Exception e) {
      log.error("异常:" + e);
      log.info("发送https get请求失败");
      return null;
    }
  }

  /**
   * 发送http+post请求
   *
   * @param url 请求地址
   * @param params 请求参数 json字符串
   * @return 返回结果
   * @throws Exception
   */
  public static String sendHttpPost(String url, String params) throws Exception {
    CloseableHttpClient httpClient = HttpClients.createDefault();
    return doPost(httpClient, url, params);
  }

  /**
   * 发送https+post请求
   *
   * @param url 请求地址
   * @param params 请求参数 json字符串
   * @return 返回结果
   * @throws Exception
   */
  public static String sendHttpsPost(String url, String params) {
    CloseableHttpClient httpClient = null;
    try {
      httpClient = createIgnoreVerifyHttpClient();
      return doPostPcac(httpClient, url, params);
    } catch (Exception e) {
      log.error("异常:" + e);
      log.info("发送https post请求失败");
      return null;
    }
  }

  /** 封装get请求方式的处理 */
  private static String doGet(String url, CloseableHttpClient httpClient) throws Exception {
    log.info("HGet请求url={}", url);
    HttpGet httpGet = new HttpGet(url);
    return execute(httpClient, httpGet);
  }

  /** 封装post请求方式的处理 */
  private static String doPost(CloseableHttpClient httpClient, String url, String params)
      throws Exception {
    log.info("Post请求url：{}", url);
    log.info("Post请求params：{}", params);
    HttpPost httpPost = new HttpPost(url);
    httpPost.addHeader("Content-Type", "application/json; charset=utf-8");
    httpPost.setEntity(new StringEntity(params));
    return execute(httpClient, httpPost);
  }

  /** 执行发送 */
  private static String execute(CloseableHttpClient httpClient, HttpRequestBase requestBase)
      throws Exception {
    String result = null;
    CloseableHttpResponse response = null;
    try {
      response = httpClient.execute(requestBase);
      int statusCode = response.getStatusLine().getStatusCode();
      log.info("HttpClient响应码={}", statusCode);
      if (statusCode == 200) {
        result = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
      } else {
        log.error("HttpClient请求失败，错误码={}", statusCode);
      }
    } catch (Exception e) {
      log.error("HttpClient请求异常：", e);
    } finally {
      if (null != httpClient) {
        httpClient.close();
      }
      if (null != response) {
        response.close();
      }
    }
    log.info("HttpClient请求结果：{}", result);
    return result;
  }

  /**
   * 绕过验证
   *
   * @return
   * @throws NoSuchAlgorithmException
   * @throws KeyManagementException
   */
  public static CloseableHttpClient createIgnoreVerifyHttpClient() throws Exception {
    SSLContext sslContext = SSLContext.getInstance("TLS");
    // 实现一个X509TrustManager接口
    X509TrustManager trustManager =
        new X509TrustManager() {
          @Override
          public void checkClientTrusted(
              X509Certificate[] paramArrayOfX509Certificate, String paramString)
              throws CertificateException {}

          @Override
          public void checkServerTrusted(
              X509Certificate[] paramArrayOfX509Certificate, String paramString)
              throws CertificateException {}

          @Override
          public X509Certificate[] getAcceptedIssuers() {
            return new java.security.cert.X509Certificate[0];
          }
        };
    sslContext.init(null, new TrustManager[] {trustManager}, null);
    Registry<ConnectionSocketFactory> socketFactoryRegistry =
        RegistryBuilder.<ConnectionSocketFactory>create()
            .register("http", PlainConnectionSocketFactory.INSTANCE)
            .register("https", new SSLConnectionSocketFactory(sslContext))
            .build();
    PoolingHttpClientConnectionManager connManager =
        new PoolingHttpClientConnectionManager(socketFactoryRegistry);
    CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connManager).build();
    return httpClient;
  }

  /** 封装post请求方式的处理 */
  private static String doPostPcac(CloseableHttpClient httpClient, String url, String xml)
      throws Exception {
    log.info("Post请求url：{}", url);
    log.info("Post请求params：{}", xml);
    ArrayList<BasicNameValuePair> basicNameValuePairsList = new ArrayList<>();
    basicNameValuePairsList.add(new BasicNameValuePair("xml", xml));
    UrlEncodedFormEntity urlEncodedFormEntity =
        new UrlEncodedFormEntity(basicNameValuePairsList, StandardCharsets.UTF_8);
    HttpPost httpPost = new HttpPost(url);
    // httpPost.addHeader("Content-Type", "application/json; charset=utf-8");
    httpPost.setEntity(urlEncodedFormEntity);
    return execute(httpClient, httpPost);
  }

  public static void main(String[] args) throws Exception{
    //String s = sendHttpPost("https://openapi.t.payeco.com/risk-dna-pcac-service/riskInfo/receivePush", "---asdfadf---");
    //String s = sendHttpPost("https://zyjk.cmftit.com:9001/localRisk/pcacPushInfo", "---asdfadf---");
    String s = sendHttpPost("http://localhost:8081/specReg/specRegCom/businessInfoQuery", "{\"docCode\":\"123456789123456\"}");
    //String s = sendHttpPost("http://172.16.48.224:8081/specReg/specRegCom/businessInfoQuery", "555555555555555");
    //String s = sendHttpPost("http://localhost:8081/localRisk/pcacPushInfo", "12341234");
    //String s = sendHttpPost("https://blog.csdn.net/pzysoft/article/details/62888780", "---asdfadf---");
    //String s = sendHttpPost("https://pcspinterface.pcac.org.cn/ries_interface/loginServlet", "---asdfadf---");
    //String s = sendHttpPost("https://www.baidu.com/", "---asdfadf---");
    //String s = sendHttpPost("https://sms.liudongyang.top/", "---asdfadf---");
    System.out.println(s);
  }
}
