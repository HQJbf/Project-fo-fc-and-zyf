package com.help.first;

import javax.swing.*;
import java.awt.*;

public class WrongJFrame extends JFrame {

    //错误提示界面
    public WrongJFrame(String condition) {
        initJFrame();
        initText(condition);
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
    private void initText(String condition) {
        JLabel jLabel;
        if (condition.equals("错误编码101")) {
            jLabel = new JLabel("错误编码:101");
            jLabel.setBounds(75, 60, 150, 30);
            jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            this.getContentPane().add(jLabel);
        }
        if (condition.equals("错误编码102")) {
            jLabel = new JLabel("错误编码:102");
            jLabel.setBounds(75, 60, 150, 30);
            jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            this.getContentPane().add(jLabel);
        }

        if (condition.equals("错误编码103")){
            jLabel = new JLabel("错误编码:103");
            jLabel.setBounds(75, 60, 150, 30);
            jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            this.getContentPane().add(jLabel);
        }
        if (condition.equals("错误编码104")){
            jLabel = new JLabel("错误编码:104");
            jLabel.setBounds(75, 60, 150, 30);
            jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            this.getContentPane().add(jLabel);
        }
        if (condition.equals("请完善信息")) {
            jLabel = new JLabel("请完善信息！");
            jLabel.setBounds(85, 60, 150, 30);
            jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            this.getContentPane().add(jLabel);
        }
        if (condition.equals("用户名已存在")) {
            jLabel = new JLabel("用户名已存在！");
            jLabel.setBounds(80, 60, 150, 30);
            jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            this.getContentPane().add(jLabel);
        }
        if (condition.equals("两次密码输入不一致")) {
            jLabel = new JLabel("两次密码输入不一致");
            jLabel.setBounds(50, 50, 150, 30);
            jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            this.getContentPane().add(jLabel);
            jLabel = new JLabel("请重新输入！");
            jLabel.setBounds(80, 80, 100, 30);
            jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            this.getContentPane().add(jLabel);
        }
        if (condition.equals("用户不存在")) {
            jLabel = new JLabel("用户不存在！");
            jLabel.setBounds(80, 60, 150, 30);
            jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            this.getContentPane().add(jLabel);
        }
        if (condition.equals("密码不正确")) {
            jLabel = new JLabel("密码不正确！");
            jLabel.setBounds(80, 60, 150, 30);
            jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            this.getContentPane().add(jLabel);
        }
        if (condition.equals("验证码不正确")) {
            jLabel = new JLabel("验证码不正确！");
            JLabel jLabel2 = new JLabel("提示：验证码包括两位字母和数字");
            jLabel2.setBounds(5, 65, 250, 30);
            jLabel.setBounds(70, 50, 150, 30);
            jLabel2.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            this.getContentPane().add(jLabel);
            this.getContentPane().add(jLabel2);
        }
        if (condition.equals("存档为空")) {
            jLabel = new JLabel("存档为空！");
            jLabel.setBounds(85, 60, 150, 30);
            jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            this.getContentPane().add(jLabel);
        }

    }
}