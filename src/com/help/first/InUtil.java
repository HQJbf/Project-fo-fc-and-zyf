package com.help.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class InUtil {
    private File file;
    //读取的数据
    private String step=new String();
    public InUtil(File file){
        this.file=file;
    }
    public boolean judgeExist() {
        Scanner sc;
        try {
            sc=new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        step=sc.next();
        if(step.length()==0)return false;
        return true;
    }

    public void readFile(){
        Scanner sc;
        try {
            sc=new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //读取step
        this.step=sc.next();
    }
    public String getStep() {
        return this.step;
    }
}