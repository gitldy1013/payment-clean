package com.cmcc.paymentclean.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Slf4j
public class ResourcesFileUtils {

    public static File getResourcesFile(String resourceFilePath) {
        OutputStream os = null;
        try {
            File file = new File("./temp.xsd");
            ClassPathResource resource = new ClassPathResource(resourceFilePath);
            InputStream inputStream = resource.getInputStream();
            os = new FileOutputStream(file);
            int len = 0;
            byte[] buffer = new byte[8192];
            while ((len = inputStream.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
            return file;
        } catch (IOException e) {
            log.error("异常:" + e);
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    log.error("异常:" + e);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        File resourcesFile = getResourcesFile("xsds/pcac.ries.001.xsd");
        assert resourcesFile != null;
        System.out.println("文件名称：" + resourcesFile.getAbsolutePath());
    }
}
