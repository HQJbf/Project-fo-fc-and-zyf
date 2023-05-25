package com.help.first;

import javax.swing.*;
import java.awt.*;

public class WrongJFrame extends JFrame {

    //错误提示界面
    public WrongJFrame(int mark) {
        initJFrame();
        initText(mark);
        setVisible(true);
    }

    //初始化界面
    private void initJFrame() {
        //设置宽高
        this.setSize(260, 200);
        //设置标题
        this.setTitle("Wrong");
        //设置置顶
        this.setAlwaysOnTop(true);
        //设置居中
        this.setLocationRelativeTo(null);
        //设置默认关闭模式
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //取消默认的组件居中方式
        this.setLayout(null);
    }

    //初始化文字
    private void initText(int mark) {
        JLabel jLabel;
        if (mark == 1) {
            jLabel = new JLabel("错误编码:101");
            jLabel.setBounds(75, 60, 150, 30);
            jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            this.getContentPane().add(jLabel);
        }
        if (mark == 2) {
            jLabel = new JLabel("错误编码:102");
            jLabel.setBounds(75, 60, 150, 30);
            jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            this.getContentPane().add(jLabel);
        }

        if (mark == 3) {
            jLabel = new JLabel("错误编码:103");
            jLabel.setBounds(75, 60, 150, 30);
            jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            this.getContentPane().add(jLabel);
        }
        if (mark == 4) {
            jLabel = new JLabel("错误编码:104");
            jLabel.setBounds(75, 60, 150, 30);
            jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            this.getContentPane().add(jLabel);
        }
//        if (mark == 5) {
//            jLabel = new JLabel("错误编码:105");
//            jLabel.setBounds(75, 60, 150, 30);
//            jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
//            this.getContentPane().add(jLabel);
//        }
        if (mark == 6) {
            jLabel = new JLabel("输入为空！");
            jLabel.setBounds(85, 60, 150, 30);
            jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            this.getContentPane().add(jLabel);
        }
        if (mark == 7) {
            jLabel = new JLabel("用户已存在！");
            jLabel.setBounds(80, 60, 150, 30);
            jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            this.getContentPane().add(jLabel);
        }
        if (mark == 8) {
            jLabel = new JLabel("两次密码输入不一致");
            jLabel.setBounds(50, 50, 150, 30);
            jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            this.getContentPane().add(jLabel);
            jLabel = new JLabel("请重新输入！");
            jLabel.setBounds(80, 80, 100, 30);
            jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            this.getContentPane().add(jLabel);
        }
        if (mark == 9) {
            jLabel = new JLabel("用户不存在！");
            jLabel.setBounds(80, 60, 150, 30);
            jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            this.getContentPane().add(jLabel);
        }
        if (mark == 10) {
            jLabel = new JLabel("密码不正确！");
            jLabel.setBounds(80, 60, 150, 30);
            jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            this.getContentPane().add(jLabel);
        }
        if (mark == 11) {
            jLabel = new JLabel("验证码不正确！");
            JLabel jLabel2 = new JLabel("提示：验证码包括两位字母和数字");
            jLabel2.setBounds(5, 65, 250, 30);
            jLabel.setBounds(70, 50, 150, 30);
            jLabel2.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            this.getContentPane().add(jLabel);
            this.getContentPane().add(jLabel2);
        }
        if (mark == 12) {
            jLabel = new JLabel("存档为空！");
            jLabel.setBounds(85, 60, 150, 30);
            jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            this.getContentPane().add(jLabel);
        }

    }
}