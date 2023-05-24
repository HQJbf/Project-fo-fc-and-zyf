package com.help.first;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class RegisterJFrame extends JFrame implements MouseListener {

    int mark = 0;//错误标志
    String UserName;
    String password;
    String passwordAgain;

    //注册按键
    ImageIcon registerUp = new ImageIcon("image/register/registerUp(1).jpg");
    ImageIcon registerDown = new ImageIcon("image/register/registerUp(1).jpg");
    JLabel register = new JLabel(registerUp);
    //重置按键
    ImageIcon resetUp = new ImageIcon("image/register/resetUp.png");
    ImageIcon resetDown = new ImageIcon("image/register/resetDown.png");
    JLabel reset = new JLabel(resetUp);
    //输入框
    JTextField inputbox1 = new JTextField();
    JTextField inputbox2 = new JTextField();
    JTextField inputbox3 = new JTextField();

    //登录界面
    public RegisterJFrame() {
        initJFrame();
        initImage();
        setVisible(true);
    }

    //初始化界面
    private void initJFrame() {
        //设置宽高
        this.setSize(485, 427);
        //设置标题
        this.setTitle("Load Game");
        //设置置顶
        this.setAlwaysOnTop(true);
        //设置居中
        this.setLocationRelativeTo(null);
        //设置默认关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认的组件居中方式
        this.setLayout(null);
    }

    //初始化图片
    private void initImage() {
        this.getContentPane().removeAll();//清空原本已经出现的所有图片

        //添加注册用户名文字
        JLabel userName = new JLabel(new ImageIcon("image/register/registerUserName.png"));
        userName.setBounds(65, 105, 80, 20);
        this.getContentPane().add(userName);
        //添加注册用户名输入框
        inputbox1.setBounds(175, 105, 200, 30);
        this.getContentPane().add(inputbox1);
        //添加注册密码文字
        JLabel password = new JLabel(new ImageIcon("image/register/registerPassword.png"));
        password.setBounds(80, 165, 65, 18);
        this.getContentPane().add(password);
        //添加注册密码输入框
        inputbox2.setBounds(175, 165, 200, 30);
        this.getContentPane().add(inputbox2);
        //添加再次输入密码文字
        JLabel passwordAgain = new JLabel(new ImageIcon("image/register/passwordAgain.png"));
        passwordAgain.setBounds(55, 225, 96, 20);
        this.getContentPane().add(passwordAgain);
        //添加再次输入密码输入框
        inputbox3.setBounds(175, 225, 200, 30);
        this.getContentPane().add(inputbox3);
        //添加注册按键
        register.setBounds(90, 280, 128, 47);
        register.addMouseListener(this);
        this.getContentPane().add(register);
        //添加重置按键
        reset.setBounds(280, 280, 128, 47);
        reset.addMouseListener(this);
        this.getContentPane().add(reset);
        //添加背景图片
        JLabel background = new JLabel(new ImageIcon("image/register/background.png"));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);

        this.getContentPane().repaint();//刷新一下界面
    }

    public boolean judge(String userName, String password, String passwordAgain) {
        File file = new File("User\\" + userName);
        if (userName.equals("") || password.equals("") || passwordAgain.equals("")) {
            mark = 6;
            return false;
        }
        if (file.exists()) {
            mark = 7;
            return false;
        }
        if (!password.equals(passwordAgain)) {
            mark = 8;
            return false;
        }
        return true;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object obj = e.getSource();
        if (obj == register) {
            UserName = inputbox1.getText();
            password = inputbox2.getText();
            passwordAgain = inputbox3.getText();
            if (!judge(UserName, password, passwordAgain)) {
                new WrongJFrame(mark);
            } else {
                CreatUtil creatUtil = new CreatUtil(UserName, password);
                try {
                    creatUtil.createFile();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                setVisible(false);
                new LoginJFrame();
                new RightJFrame(1, UserName);
            }
        } else if (obj == reset) {
            inputbox1.setText(null);
            inputbox2.setText(null);
            inputbox3.setText(null);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object obj = e.getSource();
        if (obj == register) {
            register.setIcon(registerDown);
        } else if (obj == reset) {
            reset.setIcon(resetDown);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Object obj = e.getSource();
        if (obj == register) {
            register.setIcon(registerUp);
        } else if (obj == reset) {
            reset.setIcon(resetUp);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}