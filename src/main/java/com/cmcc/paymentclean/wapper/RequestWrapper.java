package com.cmcc.paymentclean.wapper;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Slf4j
public class RequestWrapper extends HttpServletRequestWrapper {
  private final String body;

  public RequestWrapper(HttpServletRequest request) {
    super(request);
    StringBuilder stringBuilder = new StringBuilder();
    BufferedReader bufferedReader = null;
    InputStream inputStream = null;
    try {
      inputStream = request.getInputStream();
      if (inputStream != null) {
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        char[] charBuffer = new char[128];
        int bytesRead;
        while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
          stringBuilder.append(charBuffer, 0, bytesRead);
        }
      }
    } catch (IOException e) {
      log.error("获取请求体数据流异常：", e);
    } finally {
      if (inputStream != null) {
        try {
          inputStream.close();
        } catch (IOException e) {
          log.error("获取请求体数据流异常：", e);
        }
      }
      if (bufferedReader != null) {
        try {
          bufferedReader.close();
        } catch (IOException e) {
          log.error("获取请求体数据流异常：", e);
        }
      }
    }
    body = stringBuilder.toString();
  }

  @Override
  public ServletInputStream getInputStream() throws IOException {
    final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body.getBytes());
    ServletInputStream servletInputStream =
        new ServletInputStream() {
          @Override
          public boolean isFinished() {
            return false;
          }

          @Override
          public boolean isReady() {
            return false;
          }

          @Override
          public void setReadListener(ReadListener readListener) {}

          @Override
          public int read() {
            return byteArrayInputStream.read();
          }
        };
    return servletInputStream;
  }

  @Override
  public BufferedReader getReader() throws IOException {
    return new BufferedReader(new InputStreamReader(this.getInputStream()));
  }

  public String getBody() {
    return this.body;
  }
}
