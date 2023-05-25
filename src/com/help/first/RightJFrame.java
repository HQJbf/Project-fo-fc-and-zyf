package com.help.first;

import javax.swing.*;
import java.awt.*;

public class RightJFrame extends JFrame {
    String Username;
    //正确提示界面
    public RightJFrame(int mark,String username) {
        this.Username=username;
        initJFrame();
        initText(mark);
    }
    //初始化界面
    private void initJFrame() {
        //设置宽高
        this.setSize(240, 210);
        //设置标题
        this.setTitle("成功登录");
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
        if (mark == 1) {
                JLabel jLabel;
                jLabel = new JLabel("注册成功！");
                jLabel.setBounds(85, 50, 150, 30);
                jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
                this.getContentPane().add(jLabel);
                jLabel = new JLabel("请重新登录！");
                jLabel.setBounds(80, 80, 100, 30);
                jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
                this.getContentPane().add(jLabel);
            }else {
                JOptionPane.showMessageDialog(this, "登录成功！欢迎"+Username);
            }
        }
}