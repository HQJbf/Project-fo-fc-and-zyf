package com.help.first;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class LoginJFrame extends JFrame implements MouseListener {
    int mark = 0;//错误标志
    String UserName;
    String password;
    String verification;
    String randomCode;
    String nowInput = "";
    boolean isShowPassword = false;
    JLabel code = new JLabel();//验证码
    //登录按键
    ImageIcon loginUp = new ImageIcon("image/login/登录(1).jpg");
    ImageIcon loginDown = new ImageIcon("image/login/登录(1).jpg");
    JLabel login = new JLabel(loginUp);
    //TODO：注册按键up
    ImageIcon registerUp = new ImageIcon("image/login/registerUp(1).jpg");
    Image img2 = registerUp.getImage();
    int width2 = registerUp.getIconWidth() / 2; // 缩小为原来的一半
    int height2 = registerUp.getIconHeight() / 2;
    Image scaledImg2 = img2.getScaledInstance(width2, height2, Image.SCALE_SMOOTH);
    ImageIcon registerUp2 = new ImageIcon(scaledImg2);
    //TODO：注册按键down
    ImageIcon registerDown = new ImageIcon("image/login/registerUp(1).jpg");
//    Image img1 = registerDown.getImage();
//    int width1 = registerDown.getIconWidth() / 2; // 缩小为原来的一半
//    int height1 = registerDown.getIconHeight() / 2;
//    Image scaledImg1 = img1.getScaledInstance(width1, height1, Image.SCALE_SMOOTH);
    JLabel register = new JLabel(registerDown);
    //TODO：显示密码按键
    ImageIcon showPasswordUp = new ImageIcon("image/login/showPasswordUp.png");
    ImageIcon showPasswordDown = new ImageIcon("image/login/showPasswordDown.png");
    JLabel showPassword = new JLabel(showPasswordUp);
    //密码显示
    JTextField showTrue = new JTextField();
    JPasswordField showFalse = new JPasswordField();
    //输入框
    JTextField inputbox1 = new JTextField();
    JTextField inputbox2 = showFalse;
    JTextField inputbox3 = new JTextField();
    //登录界面
    public LoginJFrame() {
        randomCode = toRandom();
        initJFrame();
        initImage();
        code.addMouseListener(this);
        login.addMouseListener(this);
        register.addMouseListener(this);
        setVisible(true);
    }

    //初始化界面
    private void initJFrame() {
        //设置标题
        this.setTitle(".                                                                  " + "登录游戏");
        //设置标题字体
        this.setFont(new Font("System", Font.PLAIN, 14));
        //设置宽高
        this.setSize(650, 520);
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
        //添加用户名文字
        JLabel userName = new JLabel("用户名");
        userName.setBounds(100 + 70, 110 + 10, 200, 18);
        userName.setFont(new Font("黑体", Font.BOLD, 20));
        userName.setForeground(Color.white);
        this.getContentPane().add(userName);
        //添加用户名输入框
        inputbox1.setBounds(175 + 70, 105 + 10, 200, 30);
        this.getContentPane().add(inputbox1);
        //添加密码文字
        //  JLabel password=new JLabel(new ImageIcon("image/login/password.png"));
        JLabel password = new JLabel("密码");
        password.setBounds(110 + 70, 172 + 10, 200, 18);
        password.setFont(new Font("黑体", Font.BOLD, 20));
        password.setForeground(Color.white);
        this.getContentPane().add(password);
        //添加密码输入框
        if (!isShowPassword) {
            showFalse.setText(nowInput);
            inputbox2 = showFalse;
        } else {
            showTrue.setText(nowInput);
            inputbox2 = showTrue;
        }
        inputbox2.setBounds(175 + 70, 165 + 10, 200, 30);
        this.getContentPane().add(inputbox2);
        //添加显示密码按键
        if (!isShowPassword) showPassword = new JLabel(showPasswordUp);
        else showPassword = new JLabel(showPasswordDown);
        showPassword.setBounds(378 + 70, 165 + 10, 18, 29);
        showPassword.addMouseListener(this);
        this.getContentPane().add(showPassword);
        //添加验证码文字
        JLabel verificationCode = new JLabel("验证码");
        verificationCode.setBounds(100 + 70, 230 + 10, 80, 21);
        verificationCode.setFont(new Font("黑体", Font.BOLD, 20));
        verificationCode.setForeground(Color.white);
        this.getContentPane().add(verificationCode);
        //添加验证码输入框
        inputbox3.setBounds(175 + 70, 225 + 10, 150, 30);
        this.getContentPane().add(inputbox3);
        //添加验证码
        code.setText(randomCode);
        code.setForeground(Color.white);
        code.setBounds(330 + 75, 225 + 10, 100, 30);
        code.setFont(new Font("Rockwell", Font.BOLD, 20));
        this.getContentPane().add(code);
        //添加登录按键
        login.setBounds(90 + 70, 280 + 10, 128, 47);
        this.getContentPane().add(login);
        //添加注册按键
        register.setBounds(280 + 70, 280 + 10, 128, 47);
        this.getContentPane().add(register);
        //添加背景图片
        JLabel background = new JLabel(new ImageIcon("image/login/background.png"));
        background.setBounds(0, 0, 800, 600);
        this.getContentPane().add(background);
        this.getContentPane().repaint();//刷新一下界面
    }

    //TODO:生成随机验证码
    public String toRandom() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            char ch;
            if (i <= 2) {
                int r = random.nextInt(26);
                ch = (char) ('a' + r);
            } else {
                int r = random.nextInt(10);
                ch = (char) ('0' + r);
            }
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }

    //TODO:判断是否能登录（信息是否正确）
    public boolean judge(String userName, String password, String verification) {
        File directory = new File("User\\" + userName);
        File file = new File(directory, userName + ".txt");
        if (userName.equals("") || password.equals("") || verification.equals("")) {
            mark = 6;
            return false;
        }
        if (!directory.exists()) {
            mark = 9;
            return false;
        }
        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String truePassword;
        truePassword = sc.next();
        if (!truePassword.equals(password)) {
            mark = 10;
            return false;
        }
        if (!this.randomCode.equals(verification)) {
            mark = 11;
            return false;
        }
        return true;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object obj = e.getSource();
        if (obj == code) {
            randomCode = toRandom();
            if (!isShowPassword) nowInput = showFalse.getText();
            else nowInput = showTrue.getText();
            initImage();
        } else if (obj == showPassword) {
            if (!isShowPassword) {
                nowInput = showFalse.getText();
                isShowPassword = true;
                initImage();
            } else {
                nowInput = showTrue.getText();
                isShowPassword = false;
                initImage();
            }
        } else if (obj == login) {
            UserName = inputbox1.getText();
            password = isShowPassword ? showTrue.getText() : showFalse.getText();
            verification = inputbox3.getText();
            if (!judge(UserName, password, verification)) {
                new WrongJFrame(mark);
            } else {
                this.setVisible(false);
                new ChessGameFrame(UserName);
                new RightJFrame(2, UserName);
            }
        } else if (obj == register) {
            this.setVisible(false);
            new RegisterJFrame();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object obj = e.getSource();
        if (obj == login) {
            login.setIcon(loginDown);
        } else if (obj == register) {
            register.setIcon(registerDown);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Object obj = e.getSource();
        if (obj == login) {
            login.setIcon(loginUp);
        } else if (obj == register) {
            register.setIcon(registerUp2);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}