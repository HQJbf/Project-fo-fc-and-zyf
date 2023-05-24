package com.help.first;

import javax.swing.*;
import java.awt.*;

public class WrongJFrame extends JFrame{

    //错误提示界面
    public WrongJFrame(int mark){
        initJFrame();
        initText(mark);
        setVisible(true);
    }

    //初始化界面
    private void initJFrame() {
        //设置宽高
        this.setSize(250,200);
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
    private void initText(int mark){
        JLabel jLabel;
        switch (mark)
        {
            case 1:
            {
                jLabel=new JLabel("错误编码:101");
                jLabel.setBounds(75,60,150,30);
                jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE,15));
                this.getContentPane().add(jLabel);
                break;
            }
            case 2:
            {
                jLabel=new JLabel("错误编码:102");
                jLabel.setBounds(75,60,150,30);
                jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE,15));
                this.getContentPane().add(jLabel);
                break;
            }
            case 3:
            {
                jLabel=new JLabel("错误编码:103");
                jLabel.setBounds(75,60,150,30);
                jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE,15));
                this.getContentPane().add(jLabel);
                break;
            }
            case 4:
            {
                jLabel=new JLabel("错误编码:104");
                jLabel.setBounds(75,60,150,30);
                jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE,15));
                this.getContentPane().add(jLabel);
                break;
            }
            case 5:
            {
                jLabel=new JLabel("错误编码:105");
                jLabel.setBounds(75,60,150,30);
                jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE,15));
                this.getContentPane().add(jLabel);
                break;
            }
            case 6:
            {
                jLabel=new JLabel("输入为空！");
                jLabel.setBounds(85,60,150,30);
                jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE,15));
                this.getContentPane().add(jLabel);
                break;
            }
            case 7:
            {
                jLabel=new JLabel("用户已存在！");
                jLabel.setBounds(80,60,150,30);
                jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE,15));
                this.getContentPane().add(jLabel);
                break;
            }
            case 8:
            {
                jLabel=new JLabel("两次密码输入不一致");
                jLabel.setBounds(50,50,150,30);
                jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE,15));
                this.getContentPane().add(jLabel);
                jLabel=new JLabel("请重新输入！");
                jLabel.setBounds(80,80,100,30);
                jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE,15));
                this.getContentPane().add(jLabel);
                break;
            }
            case 9:
            {
                jLabel=new JLabel("用户不存在！");
                jLabel.setBounds(80,60,150,30);
                jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE,15));
                this.getContentPane().add(jLabel);
                break;
            }
            case 10:
            {
                jLabel=new JLabel("密码不正确！");
                jLabel.setBounds(80,60,150,30);
                jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE,15));
                this.getContentPane().add(jLabel);
                break;
            }
            case 11:
            {
                jLabel=new JLabel("验证码不正确！");
                jLabel.setBounds(75,60,150,30);
                jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE,15));
                this.getContentPane().add(jLabel);
                break;
            }
            case 12:
            {
                jLabel=new JLabel("存档为空！");
                jLabel.setBounds(85,60,150,30);
                jLabel.setFont(new Font("宋体", Font.CENTER_BASELINE,15));
                this.getContentPane().add(jLabel);
                break;
            }
            default:break;
        }
    }
}