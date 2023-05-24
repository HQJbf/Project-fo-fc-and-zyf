package com.help.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class OutUtil {
    private final File file;

    public OutUtil(File file){
        this.file=file;
    }

    public void modifyFile(String step){
        PrintWriter printWriter;
        try {
            printWriter = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //修改step
        printWriter.print(step);
        printWriter.print('\n');
        //关闭输出流
        printWriter.close();
    }
}