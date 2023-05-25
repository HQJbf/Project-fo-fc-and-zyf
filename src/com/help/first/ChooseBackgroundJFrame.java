package com.help.first;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class ChooseBackgroundJFrame extends JFrame implements MouseListener {
    String UserName;
    public ChooseBackgroundJFrame(String UserName) {
        this.UserName = UserName;
//        directory = new File("User\\" + UserName);
//        for (int i = 1; i <= 9; i++) save[i] = new JButton(new ImageIcon("image\\saveButton\\save" + i + ".png"));
//        for (int i = 1; i <= 9; i++) file[i] = new File(directory, "save\\save" + i + ".txt");
        initJFrame();
        initJButton();
        this.setVisible(true);
    }
    private void initJFrame() {
        //设置宽高
        this.setSize(333, 333);
        //设置标题
        this.setTitle("背景切换");
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
    private void initJButton() {
//        int x, y, dx, dy, width = 80, height = 33;
//        for (int i = 1; i <= 9; i++) {
//            dx = i % 3 == 0 ? 2 : i % 3 - 1;
//            dy = (i - 1) / 3;
//            x = 20 + dx * 100;
//            y = 40 + dy * 50;
//            save[i].setBounds(x, y, width, height);
//            save[i].addActionListener(this);
//            this.add(save[i]);
//        }
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
