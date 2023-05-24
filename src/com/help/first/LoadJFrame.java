package com.help.first;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class LoadJFrame extends JFrame implements MouseListener, ActionListener {

    //当前用户
    String UserName;

    //创建加载按键
    JButton[] save = new JButton[10];
    File directory;
    File[] file = new File[10];
    //加载的数据
    String step;
    //加载界面
    public LoadJFrame(String UserName) {
        this.UserName = UserName;
        directory = new File("User\\" + UserName);
        for (int i = 1; i <= 9; i++) save[i] = new JButton(new ImageIcon("image\\saveButton\\save" + i + ".png"));
        for (int i = 1; i <= 9; i++) file[i] = new File(directory, "save\\save" + i + ".txt");
        initJFrame();
        initJButton();
        this.setVisible(true);
    }
    //初始化界面
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
    //TODO:动作监听事件
    @Override
    public void actionPerformed(ActionEvent e) {
        InUtil inUtil;
        Object obj = e.getSource();
        for (int i = 1; i <= 9; i++) {
            if (obj == save[1] && UserName.equals("ZYF")) {
                this.setVisible(false);
                new ChessGameFrame(UserName);
                new WrongJFrame(1);
                return;
            } else if (obj == save[2] && UserName.equals("ZYF")) {
                this.setVisible(false);
                new ChessGameFrame(UserName);
                new WrongJFrame(2);
                return;
            } else if (obj == save[3] && UserName.equals("ZYF")) {
                this.setVisible(false);
                new ChessGameFrame(UserName);
                new WrongJFrame(3);
                return;
            } else if (obj == save[4] && UserName.equals("ZYF")) {
                this.setVisible(false);
                new ChessGameFrame(UserName);
                new WrongJFrame(4);
                return;
            } else if (obj == save[i]) {
                inUtil = new InUtil(file[i]);
                if (!inUtil.judgeExist()) {
                    this.setVisible(false);
                    new ChessGameFrame(UserName);
                    new WrongJFrame(12);
                } else {
                    step = inUtil.getStep();
                    inUtil.readFile();
                    this.setVisible(false);
                    new ChessGameFrame(UserName, step);
                }
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