package com.help.first;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class CreatUtil {
    private String userName;
    private String password;

    public CreatUtil() {
    }

    public CreatUtil(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void createFile() throws IOException {
        //创建文件和文件夹
        File directory = new File("User\\" + userName);
        File file = new File(directory, userName + ".txt");
        PrintWriter[] printWriter = new PrintWriter[10];
        directory.mkdirs();
        file.createNewFile();
        //储存密码
        printWriter[0] = new PrintWriter(file);
        printWriter[0].print(password);
        printWriter[0].close();
        //创建存档文件夹和文件
        File directorySave = new File(directory, "save");
        File[] save = new File[10];
        directorySave.mkdirs();
        for (int i = 1; i <= 9; i++) {
            save[i] = new File(directorySave, "save" + i + ".txt");
            save[i].createNewFile();
            printWriter[i] = new PrintWriter(save[i]);
            printWriter[i].println("false");
            printWriter[i].close();
        }
    }
}