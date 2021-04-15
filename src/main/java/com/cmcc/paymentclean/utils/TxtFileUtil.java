package com.cmcc.paymentclean.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Created by lumma on 2020/9/14.
 */
@Slf4j
public class TxtFileUtil {

    /**
     * 将list按行写入到txt文件中
     *
     * @param strings
     * @param path
     * @param fileName
     * @throws Exception
     */
    public static void writeFileContext(List<String> strings, String path, String fileName)
            throws Exception {
        BufferedWriter writer = null;
        try {
            File fileDir = new File(path);
            fileDir.mkdirs();
            // 如果没有文件就创建
            File file = new File(path + fileName);
            if (!file.isFile()) {
                file.createNewFile();
            }
            FileOutputStream writerStream = new FileOutputStream(file);
            writer =
                    new BufferedWriter(new OutputStreamWriter(writerStream, StandardCharsets.UTF_8));

            for (String l : strings) {
                writer.write(l + "\r\n");
            }

        } catch (IOException e) {
            log.error("异常：", e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    log.error("异常:" + e);
                }
            }
        }

    }
}
