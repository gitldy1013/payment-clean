package com.cmcc.paymentclean.utils;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/** 文件上传到ftp服务器工具类 */
@Slf4j
public class SFTPUtils {

  public static String OPERATE_UPLOAD = "upload";
  public static String OPERATE_DOWNLOAD = "download";

  private ChannelSftp sftp = null;
  private Session sshSession = null;

  /** 通过SFTP连接服务器 */
  private void connect(String username, String host, String port, String password) {
    try {
      JSch jsch = new JSch();
      sshSession = jsch.getSession(username, host, Integer.parseInt(port));
      log.info("Session created.");
      sshSession.setPassword(password);
      Properties sshConfig = new Properties();
      sshConfig.put("StrictHostKeyChecking", "no");
      sshSession.setConfig(sshConfig);
      sshSession.connect();
      log.info("Session connected.");
      Channel channel = sshSession.openChannel("sftp");
      channel.connect();
      log.info("Opening Channel.");
      sftp = (ChannelSftp) channel;
      log.info("Connected to " + host + ".");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /** 关闭连接 */
  private void disconnect() {
    if (this.sftp != null) {
      if (this.sftp.isConnected()) {
        this.sftp.disconnect();
        log.info("sftp is closed already");
      }
    }
    if (this.sshSession != null) {
      if (this.sshSession.isConnected()) {
        this.sshSession.disconnect();
        log.info("sshSession is closed already");
      }
    }
  }

  /**
   * 下载单个文件
   *
   * @param remotePath：远程下载目录(以路径符号结束)
   * @param remoteFileName：下载文件名
   * @param localPath：本地保存目录(以路径符号结束)
   * @param localFileName：保存文件名
   * @return 是否成功
   */
  private boolean downloadFile(
      String remotePath, String remoteFileName, String localPath, String localFileName) {
    FileOutputStream fieloutput = null;
    try {
      File file = new File(localPath + localFileName);
      fieloutput = new FileOutputStream(file);
      sftp.get(remotePath + remoteFileName, fieloutput);
      log.info("===DownloadFile:" + remoteFileName + " success from sftp.");
      return true;
    } catch (FileNotFoundException | SftpException e) {
      e.printStackTrace();
    } finally {
      if (null != fieloutput) {
        try {
          fieloutput.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return false;
  }

  /**
   * 上传单个文件
   *
   * @param remotePath：远程保存目录
   * @param remoteFileName：保存文件名
   * @param localPath：本地上传目录(以路径符号结束)
   * @param localFileName：上传的文件名
   * @return 是否成功
   */
  private boolean uploadFile(
      String remotePath, String remoteFileName, String localPath, String localFileName) {
    FileInputStream in = null;
    String tempRemoteFileName = remoteFileName + ".temp";
    try {
      createDir(remotePath);
      File file = new File(localPath + localFileName);
      in = new FileInputStream(file);
      sftp.put(in, tempRemoteFileName);
      sftp.rename(remotePath + tempRemoteFileName, remotePath + remoteFileName);
      return true;
    } catch (FileNotFoundException | SftpException e) {
      e.printStackTrace();
    } finally {
      if (in != null) {
        try {
          in.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return false;
  }

  /**
   * 创建目录
   *
   * @param createpath 目录
   */
  private void createDir(String createpath) {
    try {
      if (isDirExist(createpath)) {
        this.sftp.cd(createpath);
        return;
      }
      String[] pathArry = createpath.split("/");
      StringBuilder filePath = new StringBuilder("/");
      for (String path : pathArry) {
        if (path.equals("")) {
          continue;
        }
        filePath.append(path).append("/");
        if (isDirExist(filePath.toString())) {
          sftp.cd(filePath.toString());
        } else {
          // 建立目录
          sftp.mkdir(filePath.toString());
          // 进入并设置为当前目录
          sftp.cd(filePath.toString());
        }
      }
      this.sftp.cd(createpath);
    } catch (SftpException e) {
      e.printStackTrace();
    }
  }

  /**
   * 判断目录是否存在
   *
   * @param directory 文件夹
   * @return 是否存在
   */
  private boolean isDirExist(String directory) {
    boolean isDirExistFlag = false;
    try {
      SftpATTRS sftpATTRS = sftp.lstat(directory);
      isDirExistFlag = true;
      return sftpATTRS.isDir();
    } catch (Exception e) {
      if (e.getMessage().toLowerCase().equals("no such file")) {
        isDirExistFlag = false;
      }
    }
    return isDirExistFlag;
  }

  /**
   * @param username 用户名
   * @param host 地址
   * @param port 端口
   * @param password 密码
   * @param remotePath 远程地址
   * @param remoteFileName 远程文件名
   * @param localPath 本地路径
   * @param localFileName 本地文件名
   * @param operateType 操作类型
   * @return
   */
  public static boolean operateSFTP(
      String username,
      String host,
      String port,
      String password,
      String remotePath,
      String remoteFileName,
      String localPath,
      String localFileName,
      String operateType) {
    SFTPUtils sftp = null;
    try {
      sftp = new SFTPUtils();
      sftp.connect(username, host, port, password);
      if (OPERATE_UPLOAD.equals(operateType)) {
        return sftp.uploadFile(remotePath, remoteFileName, localPath, localFileName);
      } else if (OPERATE_DOWNLOAD.equals(operateType)) {
        return sftp.downloadFile(remotePath, remoteFileName, localPath, localFileName);
      } else {
        log.info("操作类型不在已知的范围内");
      }
    } catch (Exception e) {
      e.printStackTrace();
      log.info("文件操作异常：{}", localFileName + operateType + "失败!");
    } finally {
      assert sftp != null;
      sftp.disconnect();
    }
    return false;
  }
}
