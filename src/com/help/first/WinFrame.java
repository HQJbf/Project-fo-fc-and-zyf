package com.help.first;

import javax.swing.*;
import java.awt.*;

public class WinFrame extends JFrame {
    String Username;
String condition="";
    public WinFrame(String username) {
        this.Username = username;
        initJFrame();
        initJLabel();
        setVisible(true);
    }

    private void initJFrame() {
        //设置宽高
        this.setSize(250, 200);
        //设置标题
        this.setTitle("游戏结束");
        //设置置顶
        this.setAlwaysOnTop(true);
        //设置居中
        this.setLocationRelativeTo(null);
        //设置默认关闭模式
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //取消默认的组件居中方式
        this.setLayout(null);
    }

    private void initJLabel() {
        JLabel jLabel2 = new JLabel("亲爱的"+Username);
        jLabel2.setBounds(50, 20, 150, 30);
        jLabel2.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
        this.getContentPane().add(jLabel2);
        JLabel jLabel = new JLabel("本届游戏已经结束");
        jLabel.setBounds(50, 50, 150, 30);
        jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
        this.getContentPane().add(jLabel);
        jLabel = new JLabel("请重新开始游戏！");
        jLabel.setBounds(50, 80, 160, 30);
        jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
        this.getContentPane().add(jLabel);
    }
}
