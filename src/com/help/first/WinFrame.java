package com.help.first;

import javax.swing.*;

public class WinFrame extends JFrame{
    String Username;
    public WinFrame(String username) {
        this.Username=username;
        initJFrame();
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
}
