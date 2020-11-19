package com.wuss.util;


import java.io.File;
import java.io.FileWriter;

/**
 *
 */
public class FileUtil {
//    默认生成目录在 /src/main/test 目录下
    private static String defaultFilePath = "./src/main/test/";

    public static void writeFile(String fileName,String content){
        File file = new File(defaultFilePath,fileName);

        try(FileWriter fw = new FileWriter(file) ){
            fw.write(content);
            System.out.println(file.getName()+" 生成完成，路径："+ file.getAbsolutePath());
        }catch (Exception e){
           e.printStackTrace();
        }
    }
}
