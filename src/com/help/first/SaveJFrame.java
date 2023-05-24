package com.help.first;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class SaveJFrame extends JFrame implements MouseListener, ActionListener {

    //当前用户
    String UserName;

    //创建保存按键
    JButton[] save = new JButton[10];
    File directory;
    File[] file = new File[10];

    //保存的数据
    String step;

    //保存界面
    public SaveJFrame(String UserName, String step) {
        this.UserName = UserName;
        directory = new File("User\\" + UserName);
        for (int i = 1; i <= 9; i++) save[i] = new JButton(new ImageIcon("image\\saveButton\\save" + i + ".png"));
        for (int i = 1; i <= 9; i++) file[i] = new File(directory, "save\\save" + i + ".txt");
        initJFrame();
        initJButton();
        this.step = step;
        this.setVisible(true);
    }

    //初始化界面
    private void initJFrame() {
        //设置宽高
        this.setSize(333, 333);
        //设置标题
        this.setTitle("SaveJFrame by FC and ZYF");
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

    //初始化按键
    private void initJButton() {
        int x, y, dx, dy, width = 80, height = 33;
        for (int i = 1; i <= 9; i++) {
            dx = i % 3 == 0 ? 2 : i % 3 - 1;
            dy = (i - 1) / 3;
            x = 20 + dx * 100;
            y = 40 + dy * 50;
            save[i].setBounds(x, y, width, height);
            save[i].addActionListener(this);
            this.add(save[i]);
        }
    }

    @Override//动作监听事件
    public void actionPerformed(ActionEvent e) {
        OutUtil outUtil;
        Object obj = e.getSource();
        for (int i = 1; i <= 9; i++) {
            if (obj == save[i]) {
                outUtil = new OutUtil(file[i]);
                outUtil.modifyFile(step);
                this.setVisible(false);
                break;
            }
        }
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