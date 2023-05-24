package com.help.first;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class RegretJFrame extends JFrame implements MouseListener, ActionListener {
    //当前用户
    String UserName;

    //创建加载按键
    JButton[] save = new JButton[10];
    File directory;
    File[] file = new File[10];

    //加载的数据

    String step;

    //加载界面
    public RegretJFrame(String UserName) {
        this.UserName = UserName;
        directory = new File("User\\" + UserName);
        for (int i = 1; i <= 9; i++) save[i] = new JButton(new ImageIcon("image\\saveButton\\save" + i + ".png"));
        for (int i = 1; i <= 9; i++) file[i] = new File(directory, "save\\save" + i + ".txt");
        initJFrame();
       // initJButton();
        this.setVisible(true);
    }
    private void initJFrame() {
        //设置宽高
        this.setSize(333, 333);
        //设置标题
        this.setTitle("载入游戏");
        //设置置顶
        this.setAlwaysOnTop(true);
        //设置居中
        this.setLocationRelativeTo(null);
        //设置默认关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认的组件居中方式
        this.setLayout(null);
        //给整个界面添加鼠标监听事件
        this.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
