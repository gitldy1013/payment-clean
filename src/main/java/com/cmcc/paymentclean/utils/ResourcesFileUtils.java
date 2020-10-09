package com.cmcc.paymentclean.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;

@Slf4j
public class ResourcesFileUtils {

  public static File getResourcesFile(String resourceFilePath) {

    ClassPathResource resource = new ClassPathResource(resourceFilePath);
    try {
      return resource.getFile();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void main(String[] args) {
    File resourcesFile = getResourcesFile("xsds/pcac.ries.001.xsd");
    assert resourcesFile != null;
    System.out.println("文件名称：" + resourcesFile.getAbsolutePath());
  }
}
