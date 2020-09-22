package com.cmcc.paymentclean.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Created by lumma on 2020/9/14.
 */
public class TxtFileUtil {

    /**
     * 将list按行写入到txt文件中
     * @param strings
     * @param path
     * @throws Exception
     */
    public static void writeFileContext(List<String> strings, String path) throws Exception {
        File file = new File(path);
        //如果没有文件就创建
        if (!file.isFile()) {
            file.createNewFile();
        }
        FileOutputStream writerStream = new FileOutputStream(file);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(writerStream, StandardCharsets.UTF_8));

        for (String l:strings){
            writer.write(l + "\r\n");
        }
        writer.close();
    }
}
