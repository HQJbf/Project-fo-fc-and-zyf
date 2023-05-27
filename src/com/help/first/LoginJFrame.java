package com.help.first;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class LoginJFrame extends JFrame implements MouseListener, KeyListener, ActionListener {
    String condition = "";//错误标志
    String UserName;
    String theKey;
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
    //TODO：注册按键down
    ImageIcon registerDown = new ImageIcon("image/login/registerDown(1).jpg");
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
    private static boolean isPlaying = false; // 静态标志位，表示当前是否正在播放音乐
    private static Clip clip; // 成员变量，表示音乐播放器
    //登录界面
    public LoginJFrame() {
        randomCode = produceRandom();
        initJFrame();
        initImage();
        register.addMouseListener(this);
        code.addMouseListener(this);
        login.addMouseListener(this);
        inputbox3.addKeyListener(this);
        playMusic();
        setVisible(true);
    }
    public LoginJFrame(String string1){
        randomCode = produceRandom();
        initJFrame();
        initImage();
        register.addMouseListener(this);
        code.addMouseListener(this);
        login.addMouseListener(this);
        inputbox3.addKeyListener(this);
        setVisible(true);
    }

    private void playMusic() {
        try {
            File musicPath = new File("music/0520.wav");
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            clip = AudioSystem.getClip();
            clip.open(audioInput);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(0.0f); // 设置音量，范围为 -60.0f 到 6.0f
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            isPlaying = true; // 设为true，表示正在播放音乐
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

//    @Override
//    public void setVisible(boolean b) {
//        super.setVisible(b);
//        if (!b) { // 窗口被隐藏
//            if (isPlaying) {
//                clip.stop(); // 暂停音乐
//            }
//        }
//    }

    public static void pauseMusic() { // 静态方法，暂停音乐
        if (isPlaying) {
            clip.stop();
            isPlaying = false;
        }
    }

    public static void resumeMusic() { // 静态方法，继续播放音乐
        if (!isPlaying) {
            clip.start();
            isPlaying = true;
        }
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
        // this.setAlwaysOnTop(true);
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
        JLabel background = new JLabel(new ImageIcon("image/login/登录界面背景(1).jpg"));
        background.setBounds(0, 0, 800, 600);
        this.getContentPane().add(background);
        this.getContentPane().repaint();//刷新一下界面
    }

    //TODO:生成随机验证码
    public String produceRandom() {
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
            condition = "请完善信息";
            return false;
        }
        if (!directory.exists()) {
            condition = "用户不存在";
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
            condition = "密码不正确";
            return false;
        }
        if (!this.randomCode.equals(verification)) {
            condition = "验证码不正确";
            return false;
        }
        return true;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object obj = e.getSource();
        if (obj == code) {
            randomCode = produceRandom();
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
            theKey = isShowPassword ? showTrue.getText() : showFalse.getText();
            verification = inputbox3.getText();
            if (!judge(UserName, theKey, verification)) {
             //   System.out.println(condition);
                new WrongJFrame(condition);
            } else {
                this.setVisible(false);
                new ChessGameFrame(UserName);
                new RightJFrame("no", UserName);
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
            this.getContentPane().add(register);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Object obj = e.getSource();
        if (obj == login) {
            login.setIcon(loginUp);
        } else if (obj == register) {
            register.setIcon(registerUp);
            this.getContentPane().add(register);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        String v = inputbox3.getText();
        if (v.length() == 4) {
            if (code == 10) {
                UserName = inputbox1.getText();
                theKey = isShowPassword ? showTrue.getText() : showFalse.getText();
                verification = inputbox3.getText();
                if (!judge(UserName, theKey, verification)) {
                    new WrongJFrame(condition);
                } else {
                    this.setVisible(false);
                    new ChessGameFrame(UserName);
                    new RightJFrame("no", UserName);
                }
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
//        int code=e.getKeyCode();
//        if (code==10){
//            UserName = inputbox1.getText();
//            theKey = isShowPassword ? showTrue.getText() : showFalse.getText();
//            verification = inputbox3.getText();
//            if (!judge(UserName, theKey, verification)) {
//                new WrongJFrame(mark);
//            } else {
//                this.setVisible(false);
//                new ChessGameFrame(UserName);
//                new RightJFrame(2, UserName);
//            }
//        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}