package com.help.first;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChessGameFrame extends JFrame implements KeyListener, MouseListener, ActionListener {
    String UserName;
    int count = 0;
    int countBlue;
    int countRed;
    boolean winFlag;
    boolean isRedTurn;
    String step = "";
    char lsTurn;

    private int[][] data = new int[8][10];
    private int[][] pos = new int[8][10];
    //创建一个菜单对象
    JMenuBar jMenuBar = new JMenuBar();
    //创建N个菜单
    JMenu functionJmenu = new JMenu("功能");
    //创建N个可以点的对象
    JMenuItem reloginItem = new JMenuItem("重新登录");
    JMenuItem saveItem = new JMenuItem("保存游戏");
    JMenuItem loadItem = new JMenuItem("加载游戏");
    JMenuItem recallItem = new JMenuItem("复盘游戏");
    String pathChessboard = "image/chessboard/chessboard.jpg";
    String pathBackground = "image/background/background1.jpg";
    //创建一些按钮
    JButton restartButton = new JButton("重新游戏");
    JButton regretButton = new JButton("悔棋");
    JButton changeBackgroundButton = new JButton("取消悔棋");

    public ChessGameFrame(String UserName) {
        this.UserName = UserName;
        initZero();
        initChessGameJFrame();
        initChessGameJMenuBar();
        initChessGameButton();
        initChessGameData();
        initChessGameImage();
        setVisible(true);
    }

    //TODO:读档
    public ChessGameFrame(String UserName, String step) {
        this.UserName = UserName;
        initZero();
        initChessGameJFrame();
        initChessGameJMenuBar();
        initChessGameData();
        //先判断现在是谁下棋
        if (step.length() != 0) {
            if (step.charAt(step.length() - 127) == 'R') {
                isRedTurn = true;
            } else {
                isRedTurn = false;
            }
            countBlue = 0;
            countRed = 0;
            //判断目前回合数
            for (int i = 0; i < step.length() / 127; i++) {
                if (i % 2 == 0) {
                    countBlue++;
                }
                if (i % 2 == 1) {
                    countRed++;
                }
            }
            int row = 1;
            int col = 1;
            //再把每一个棋子塞到新的棋盘里
            for (int i = step.length() - 126; i < step.length(); i += 2) {
                char c = step.charAt(i);
                char d = step.charAt(i + 1);
                if (c == 'R') data[col][row] = d - '0' + 10;
                if (c == 'B') data[col][row] = d - '0';
                if (c == 'n') data[col][row] = 0;
                if (row == 9) {
                    col++;
                    row = 1;
                } else {
                    row++;
                }
            }
        }
        // oldFrame.setVisible(false); // 隐藏原来的窗体
        initChessGameImage();
        setVisible(true);
    }

    //TODO：按照step来改变data里面的元素
    private int[][] changeData() {
        if (isRedTurn) countBlue--;
        else countRed--;
        isRedTurn = !isRedTurn;
        int row = 1;
        int col = 1;
        //再把每一个棋子塞到新的棋盘里
        for (int i = step.length() - 126 - 127; i < step.length() - 127; i += 2) {
            char c = step.charAt(i);
            char d = step.charAt(i + 1);
            if (c == 'R') data[col][row] = d - '0' + 10;
            if (c == 'B') data[col][row] = d - '0';
            if (c == 'n') data[col][row] = 0;
            if (row == 9) {
                col++;
                row = 1;
            } else {
                row++;
            }
        }
        step = step.substring(0, step.length() - 127);
        return data;
    }


    //TODO：初始化界面
    private void initChessGameJFrame() {
        //设置宽高
        setSize(1000, 750);
        //设置标题
        setTitle("2023 CS109 Project by FC and ZYF");
        // 使得窗体居中
        setLocationRelativeTo(null);
        //设置使得程序置顶在最上层
//        setAlwaysOnTop(true);
        //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认布局（如果不加的话每一个加入的新东西都会出现在默认的位置）
        setLayout(null);
        //给整个界面添加键盘监听事件
        this.addKeyListener(this);
        //给整个界面添加鼠标监听事件
        this.addMouseListener(this);
    }

    //TODO：初始化菜单
    private void initChessGameJMenuBar() {
        //将条目添加到选项当中
        functionJmenu.add(reloginItem);
        functionJmenu.add(saveItem);
        functionJmenu.add(loadItem);
        functionJmenu.add(recallItem);
        //将选项添加到菜单当中
        jMenuBar.add(functionJmenu);
        //给条目绑定事件
        reloginItem.addActionListener(this);
        saveItem.addActionListener(this);
        loadItem.addActionListener(this);
        recallItem.addActionListener(this);
        //给游戏界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    //TODO：添加按钮，此方法在initimage里面调用
    private void initChessGameButton() {
//        ImageIcon chessboardIcon = new ImageIcon("image/chessboard/chessboard.jpg");
//        JLabel chessboardLabel = new JLabel(chessboardIcon);
//        chessboardLabel.setBounds(0, 0, 600, 600);
//        add(chessboardLabel);
        //修改按钮背景为透明，并添加图片
        ImageIcon restartIcon = new ImageIcon("image/FrameButton/重新游戏(3).jpg");
        restartButton.setIcon(restartIcon);
        restartButton.setOpaque(false);
        restartButton.setBorderPainted(false);

        ImageIcon regretIcon = new ImageIcon("image/FrameButton/悔棋(1).jpg");
        regretButton.setIcon(regretIcon);
        regretButton.setOpaque(false);
        regretButton.setBorderPainted(false);

        ImageIcon cancelRegretIcon = new ImageIcon("image/FrameButton/切换背景(1).jpg");
        changeBackgroundButton.setIcon(cancelRegretIcon);
        changeBackgroundButton.setOpaque(false);
        changeBackgroundButton.setBorderPainted(false);
        //添加重新开始按键
        restartButton.setLocation(600 + 50, 270);
        restartButton.setSize(220, 60);
        restartButton.setFont(new Font("黑体", Font.BOLD, 20));
        restartButton.setForeground(Color.white);
        restartButton.setContentAreaFilled(false);
        restartButton.addActionListener(this);
        add(restartButton);
        //添加悔棋按键
        regretButton.setLocation(600 + 50, 370);
        regretButton.setSize(220, 60);
        regretButton.setFont(new Font("黑体", Font.BOLD, 20));
        regretButton.setForeground(Color.white);
        regretButton.setContentAreaFilled(false);
        regretButton.addActionListener(this);
        add(regretButton);
        //添加取消悔棋按键
        changeBackgroundButton.setLocation(600 + 50, 470);
        changeBackgroundButton.setSize(220, 60);
        changeBackgroundButton.setFont(new Font("黑体", Font.BOLD, 20));
        changeBackgroundButton.setForeground(Color.white);
        changeBackgroundButton.setContentAreaFilled(false);
        changeBackgroundButton.addActionListener(this);
        add(changeBackgroundButton);
    }

    //TODO：添加按钮，此方法在initimage里面调用
    private void initChessGameButtonPosition() {
        //添加重新开始按键
        restartButton.setLocation(600+50, 270);
        restartButton.setSize(220, 60);
        restartButton.setFont(new Font("黑体", Font.BOLD, 20));
        restartButton.setForeground(Color.white);
        restartButton.setContentAreaFilled(false);
        add(restartButton);
        //添加悔棋按键
        regretButton.setLocation(600+50, 370);
        regretButton.setSize(220, 60);
        regretButton.setFont(new Font("黑体", Font.BOLD, 20));
        regretButton.setForeground(Color.white);
        regretButton.setContentAreaFilled(false);
        add(regretButton);
        changeBackgroundButton.setLocation(600 + 50, 470);
        changeBackgroundButton.setSize(220, 60);
        changeBackgroundButton.setFont(new Font("黑体", Font.BOLD, 20));
        changeBackgroundButton.setForeground(Color.white);
        changeBackgroundButton.setContentAreaFilled(false);
        changeBackgroundButton.addActionListener(this);
        add(changeBackgroundButton);
    }

    //TODO：初始数据清零
    private void initZero() {
        step = "";
        count = 0;
        countBlue = 0;
        countRed = 0;
        winFlag = false;
        isRedTurn = false;
    }
    //TODO：初始化动物、地面、兽穴和河流陷阱的数据
    private void initChessGameData() {
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 9; j++) {
                data[i][j] = 0;
            }
        }
        //兽
        data[1][3] = 1;
        data[6][2] = 2;
        data[2][2] = 3;
        data[5][3] = 4;
        data[3][3] = 5;
        data[7][1] = 6;
        data[1][1] = 7;
        data[7][3] = 8;
        data[7][7] = 11;
        data[2][8] = 12;
        data[6][8] = 13;
        data[3][7] = 14;
        data[5][7] = 15;
        data[1][9] = 16;
        data[7][9] = 17;
        data[1][7] = 18;
        //地面
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 9; j++) {
                pos[i][j] = 1;
            }
        }
        //兽穴
        pos[4][1] = 2;
        pos[4][9] = 12;
        //陷阱
        pos[3][1] = 3;
        pos[5][1] = 3;
        pos[4][2] = 3;
        pos[4][8] = 5;
        pos[3][9] = 5;
        pos[5][9] = 5;
        //河
        for (int i = 2; i <= 3; i++) {
            for (int j = 4; j <= 6; j++) {
                pos[i][j] = 4;
            }
        }
        for (int i = 5; i <= 6; i++) {
            for (int j = 4; j <= 6; j++) {
                pos[i][j] = 4;
            }
        }
    }
    //TODO：初始化图片
    private void initChessGameImage() {
        this.getContentPane().removeAll();//清空原本已经出现的所有图片
        initTurnAndStep();//添加回合和步数显示
        initChessGameButtonPosition();//添加按键位置
        initChessPiece();//添加棋子
        initPositions();//添加兽穴和陷阱
        // initChessGameButton();
        initChessBoard();//添加棋盘
        initBackground();//添加背景
        this.getContentPane().repaint();//刷新一下界面
    }

    //TODO：游戏复盘
    public void recallGame() {
        int count1 = step.length() / 127;
        int count2 = 1;
        for (int i = 0; i < count1; i++) {
            if (step.length() != 0) {
                if (step.charAt(127 * count2) == 'R') {
                    isRedTurn = true;
                } else {
                    isRedTurn = false;
                }
                countBlue = 0;
                countRed = 0;
//判断目前回合数
                for (int j = 0; j < count2; j++) {
                    if (j % 2 == 0) {
                        countBlue++;
                    }
                    if (j % 2 == 1) {
                        countRed++;
                    }
                }
                int row = 1;
                int col = 1;
//再把每一个棋子塞到新的棋盘里
                for (int j = count2 * 127 + 1; j < count2 * 127 + 127; j += 2) {
                    char c = step.charAt(i);
                    char d = step.charAt(i + 1);
                    if (c == 'R') data[col][row] = d - '0' + 10;
                    if (c == 'B') data[col][row] = d - '0';
                    if (c == 'n') data[col][row] = 0;
                    if (row == 9) {
                        col++;
                        row = 1;
                    } else {
                        row++;
                    }
                }
            }
            initChessBoard();
            setVisible(true);
//            LoadJFrame loadFrame = new LoadJFrame(UserName);
//            loadFrame.setVisible(true);
            // while (loadFrame.isVisible()) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //  }
            count2++;
        }
    }

    //TODO:添加回合数和步数显示
    private void initTurnAndStep() {
        if (isRedTurn) {
            JLabel turn = new JLabel("当前回合：红方");
            turn.setFont(new Font("微软雅黑", Font.BOLD, 25));
            turn.setForeground(Color.white);
            turn.setBounds(600, 10, 250, 40);
            this.getContentPane().add(turn);
        } else {
            JLabel turn = new JLabel("当前回合：蓝方");
            turn.setFont(new Font("微软雅黑", Font.BOLD, 25));
            turn.setForeground(Color.white);
            turn.setBounds(600, 10, 250, 40);
            this.getContentPane().add(turn);
        }
        JLabel stepCount1 = new JLabel("蓝方步数：" + countBlue);
        stepCount1.setBounds(600, 60, 250, 40);
        stepCount1.setFont(new Font("微软雅黑", Font.BOLD, 25));
        stepCount1.setForeground(Color.white);
        this.getContentPane().add(stepCount1);
        JLabel stepCount2 = new JLabel("红方步数：" + countRed);
        stepCount2.setBounds(600, 100, 250, 40);
        stepCount2.setFont(new Font("微软雅黑", Font.BOLD, 25));
        stepCount2.setForeground(Color.white);
        this.getContentPane().add(stepCount2);
    }

    //TODO:按照数组来添加棋子
    private void initChessPiece() {
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 9; j++) {
                if (data[i][j] == 0) continue;
                ImageIcon icon = new ImageIcon("image/piece/" + data[i][j] + ".png");
                Image img = icon.getImage();
                int width = icon.getIconWidth() / 14; // 缩小为原来的十四分之一
                int height = icon.getIconHeight() / 14;
                Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                JLabel piece = new JLabel(new ImageIcon(scaledImg));
                piece.setBounds(60 + 65 * (i - 1), 30 + 65 * (j - 1), 65, 65);
                this.getContentPane().add(piece);
            }
        }
    }

    //TODO：添加兽穴和陷阱
    private void initPositions() {
        ImageIcon icon1 = new ImageIcon("image/piece/红陷阱.png");
        ImageIcon icon2 = new ImageIcon("image/piece/蓝陷阱.png");
        ImageIcon icon3 = new ImageIcon("image/piece/红兽穴.png");
        ImageIcon icon4 = new ImageIcon("image/piece/蓝兽穴.png");
        for (int i = 0; i < 4; i++) {
            if (i == 0) {//添加红方陷阱
                for (int j = 0; j < 3; j++) {
                    Image img = icon1.getImage();
                    int width = icon1.getIconWidth() / 14; // 缩小为原来的一半
                    int height = icon1.getIconHeight() / 14;
                    Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                    JLabel piece = new JLabel(new ImageIcon(scaledImg));
                    if (j == 0) {
                        piece.setBounds(60 + 65 * 2, 30 + 65 * 8, 65, 65);
                    }
                    if (j == 1) {
                        piece.setBounds(60 + 65 * 3, 30 + 65 * 7, 65, 65);
                    }
                    if (j == 2) {
                        piece.setBounds(60 + 65 * 4, 30 + 65 * 8, 65, 65);
                    }
                    this.getContentPane().add(piece);
                }
            }
            if (i == 1) {//添加蓝方陷阱
                for (int j = 0; j < 3; j++) {
                    Image img = icon2.getImage();
                    int width = icon2.getIconWidth() / 14; // 缩小为原来的一半
                    int height = icon2.getIconHeight() / 14;
                    Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                    JLabel piece = new JLabel(new ImageIcon(scaledImg));
                    if (j == 0) {
                        piece.setBounds(60 + 65 * 2, 30, 65, 65);
                    }
                    if (j == 1) {
                        piece.setBounds(60 + 65 * 3, 30 + 65, 65, 65);
                    }
                    if (j == 2) {
                        piece.setBounds(60 + 65 * 4, 30, 65, 65);
                    }
                    this.getContentPane().add(piece);
                }
            }
            if (i == 2) {//添加红方兽穴
                Image img = icon3.getImage();
                int width = icon3.getIconWidth() / 14; // 缩小为原来的十四分之一
                int height = icon3.getIconHeight() / 14;
                Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                JLabel piece = new JLabel(new ImageIcon(scaledImg));
                piece.setBounds(60 + 65 * 3, 30 + 65 * 8, 65, 65);
                this.getContentPane().add(piece);
            }
            if (i == 3) {//添加蓝方兽穴
                Image img = icon4.getImage();
                int width = icon4.getIconWidth() / 14; // 缩小为原来的十四分之一
                int height = icon4.getIconHeight() / 14;
                Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                JLabel piece = new JLabel(new ImageIcon(scaledImg));
                piece.setBounds(60 + 65 * 3, 30, 65, 65);
                this.getContentPane().add(piece);
            }
        }


    }

    //TODO:添加棋盘
    private void initChessBoard() {
        //在点击菜单栏上面的选项时修改这里的路径，在菜单栏的每一个选项上添加监听器
        JLabel chessboard = new JLabel(new ImageIcon(pathChessboard));
        chessboard.setBounds(60, 30, 455, 580);
        this.getContentPane().add(chessboard);
    }

    //TODO:添加背景
    private void initBackground() {
        JLabel background = new JLabel(new ImageIcon(pathBackground));
        background.setBounds(0, 0, 1000, 810);
        this.getContentPane().add(background);
    }

    //TODO：监听器
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == reloginItem) {
            this.setVisible(false);
            new LoginJFrame();
        } else if (obj == saveItem) {
            new SaveJFrame(UserName, step);
        } else if (obj == loadItem) {
            new LoadJFrame(UserName);
            setVisible(false);
        } else if (obj == recallItem) {
            recallGame();
        } else if (obj == restartButton) {
            if(winFlag){
                new WinFrame(UserName);
            }else{
                initZero();
                initChessGameData();
                initChessGameImage();
            }
        } else if (obj == regretButton) {
            if (step.length() <= 127) {
                initZero();
                initChessGameData();
                initChessGameImage();
            } else {
                changeData();
                initChessGameImage();
                System.out.println(count);
            }
            //new RegretJFrame(UserName);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    //TODO:canMove方法判断是否能移动
    private boolean canMove(int preX, int preY, int x, int y, int k) {
        if (x < 1 || x > 7 || y < 1 || y > 9) return false;
        if (k == 1 || k == 11) {
            if (pos[x][y] == 1 || pos[x][y] == 3 || pos[x][y] == 4 || pos[x][y] == 5) {
                if (preX == x && Math.abs(preY - y) == 1) return true;
                if (preY == y && Math.abs(preX - x) == 1) return true;
                return false;
            } else if (pos[x][y] == 2) {
                if (k < 10) return false;
                if (preX == x && Math.abs(preY - y) == 1) {
                    winFlag = true;
                    return true;
                }
                if (preY == y && Math.abs(preX - x) == 1) {
                    winFlag = true;
                    return true;
                }
                return false;
            } else if (pos[x][y] == 12) {
                if (k > 10) return false;
                if (preX == x && Math.abs(preY - y) == 1) {
                    winFlag = true;
                    return true;
                }
                if (preY == y && Math.abs(preX - x) == 1) {
                    winFlag = true;
                    return true;
                }
                return false;
            }
            return false;
        }
        if (k == 6 || k == 7 || k == 16 || k == 17) {
            if (pos[x][y] == 1 || pos[x][y] == 3 || pos[x][y] == 5) {
                if (preX == x && Math.abs(preY - y) == 1) return true;
                if (preY == y && Math.abs(preX - x) == 1) return true;
                if (preX == x && preY == 7 && y == 3 && (x == 2 || x == 3 || x == 5 || x == 6)) {
                    if (data[x][y + 1] == 0 && data[x][y + 2] == 0 && data[x][y + 3] == 0) return true;
                    return false;
                }
                if (preX == x && y == 7 && preY == 3 && (x == 2 || x == 3 || x == 5 || x == 6)) {
                    if (data[x][preY + 1] == 0 && data[x][preY + 2] == 0 && data[x][preY + 3] == 0) return true;
                    return false;
                }
                if (preY == y && preX == 4 && x == 1 && (y == 4 || y == 5 || y == 6)) {
                    if (data[x + 1][y] == 0 && data[x + 2][y] == 0) return true;
                    return false;
                }
                if (preY == y && x == 4 && preX == 1 && (y == 4 || y == 5 || y == 6)) {
                    if (data[preX + 1][y] == 0 && data[preX + 2][y] == 0) return true;
                    return false;
                }
                if (preY == y && preX == 7 && x == 4 && (y == 4 || y == 5 || y == 6)) {
                    if (data[x + 1][y] == 0 && data[x + 2][y] == 0) return true;
                    return false;
                }
                if (preY == y && x == 7 && preX == 4 && (y == 4 || y == 5 || y == 6)) {
                    if (data[preX + 1][y] == 0 && data[preX + 2][y] == 0) return true;
                    return false;
                }
                return false;
            } else if (pos[x][y] == 2) {
                if (k < 10) return false;
                if (preX == x && Math.abs(preY - y) == 1) {
                    winFlag = true;
                    return true;
                }
                if (preY == y && Math.abs(preX - x) == 1) {
                    winFlag = true;
                    return true;
                }
                return false;
            } else if (pos[x][y] == 12) {
                if (k > 10) return false;
                if (preX == x && Math.abs(preY - y) == 1) {
                    winFlag = true;
                    return true;
                }
                if (preY == y && Math.abs(preX - x) == 1) {
                    winFlag = true;
                    return true;
                }
                return false;
            }
            return false;
        }
        if (k == 2 || k == 3 || k == 4 || k == 5 || k == 8 || k == 12 || k == 13 || k == 14 || k == 15 || k == 18) {
            if (pos[x][y] == 1 || pos[x][y] == 3 || pos[x][y] == 5) {
                if (preX == x && Math.abs(preY - y) == 1) return true;
                if (preY == y && Math.abs(preX - x) == 1) return true;
                return false;
            } else if (pos[x][y] == 2) {
                if (k < 10) return false;
                if (preX == x && Math.abs(preY - y) == 1) {
                    winFlag = true;
                    return true;
                }
                if (preY == y && Math.abs(preX - x) == 1) {
                    winFlag = true;
                    return true;
                }
                return false;
            } else if (pos[x][y] == 12) {
                if (k > 10) return false;
                if (preX == x && Math.abs(preY - y) == 1) {
                    winFlag = true;
                    return true;
                }
                if (preY == y && Math.abs(preX - x) == 1) {
                    winFlag = true;
                    return true;
                }
                return false;
            } else if (pos[x][y] == 4) {
                return false;
            }
            return false;
        } else {
            return false;
        }
    }

    //TODO:canEat方法判断是否能吃
    private boolean canEat(int preX, int preY, int x, int y, int k) {
        int preK;
        if (x < 1 || x > 7 || y < 1 || y > 9) return false;
        if (canMove(preX, preY, x, y, k)) {
            if (pos[x][y] == 1) {
                if (pos[preX][preY] == 4) return false;
                if (pos[preX][preY] == 1 || pos[preX][preY] == 3 || pos[preX][preY] == 5) {
                    if (data[preX][preY] < 10 && data[x][y] < 10) return false;
                    if (data[preX][preY] > 10 && data[x][y] > 10) return false;
                    preK = data[preX][preY];
                    if (preK > 10) preK -= 10;
                    k = data[x][y];
                    if (k > 10) k -= 10;
                    if (preK == 8 && k == 1) return false;
                    if (preK == 1 && k == 8) return true;
                    if (preK >= k) return true;
                }
            }
            if (pos[x][y] == 3) {
                if (data[preX][preY] < 10 && data[x][y] > 10) return true;
                if (data[preX][preY] > 10 && data[x][y] < 10) {
                    preK = data[preX][preY];
                    if (preK > 10) preK -= 10;
                    k = data[x][y];
                    if (k > 10) k -= 10;
                    if (preK == 8 && k == 1) return false;
                    if (preK == 1 && k == 8) return true;
                    if (preK >= k) return true;
                }
                return false;
            }
            if (pos[x][y] == 5) {
                if (data[preX][preY] > 10 && data[x][y] < 10) return true;
                if (data[preX][preY] < 10 && data[x][y] > 10) {
                    preK = data[preX][preY];
                    if (preK > 10) preK -= 10;
                    k = data[x][y];
                    if (k > 10) k -= 10;
                    if (preK == 8 && k == 1) return false;
                    if (preK == 1 && k == 8) return true;
                    if (preK >= k) return true;
                }
                return false;
            }
            if (pos[x][y] == 4) {
                if (pos[preX][preY] != 4) return false;
                return true;
            }
        }
        return false;
    }

    int preX = -1, preY = -1;

    //TODO：行棋逻辑和每走一步都存档
    @Override
    public void mouseClicked(MouseEvent e) {
        //这里obj指的是点击的东西
        Object obj = e.getSource();
        int x = e.getX();
        x = (x - 60) / 65 + 1;
        int y = e.getY();
        y = (y - 80) / 65 + 1;
        //如果胜利就点击就失效
        if (!winFlag) {
            if (preX == -1 && preY == -1) {
                if ((isRedTurn && data[x][y] > 10) || ((!isRedTurn) && data[x][y] < 10)) {
                    if (data[x][y] != 0) {
                        preX = x;
                        preY = y;
                    }
                }
            } else {
                if (data[x][y] == 0) {
                    if (canMove(preX, preY, x, y, data[preX][preY])) {
                        data[x][y] = data[preX][preY];
                        data[preX][preY] = 0;
                        isRedTurn = !isRedTurn;
                        if (isRedTurn) countBlue++;
                        if (!isRedTurn) countRed++;
                        initChessGameImage();//TODO:刷新界面
                        if (isRedTurn) lsTurn = 'R';
                        else lsTurn = 'B';
                        step += lsTurn;
                        for (int i = 1; i <= 7; i++) {
                            for (int j = 1; j <= 9; j++) {
                                if (data[i][j] == 0) step += "nn";
                                if (data[i][j] >= 1 && data[i][j] <= 8) step = step + "B" + data[i][j];
                                if (data[i][j] >= 11 && data[i][j] <= 18) step = step + "R" + (data[i][j] - 10);
                            }
                        }
                    }
                } else {
                    if (canEat(preX, preY, x, y, data[preX][preY])) {
                        data[x][y] = data[preX][preY];
                        data[preX][preY] = 0;
                        isRedTurn = !isRedTurn;
                        if (isRedTurn) countBlue++;
                        if (!isRedTurn) countRed++;
                        initChessGameImage();//TODO：刷新界面
                        //TODO：存档，存到step这个字符串里面
                        if (isRedTurn) lsTurn = 'R';
                        else lsTurn = 'B';
                        step += lsTurn;
                        for (int i = 1; i <= 7; i++) {
                            for (int j = 1; j <= 9; j++) {
                                if (data[i][j] == 0) step += "nn";
                                if (data[i][j] >= 1 && data[i][j] <= 8) step = step + "B" + data[i][j];
                                if (data[i][j] >= 11 && data[i][j] <= 18) step = step + "R" + (data[i][j] - 10);
                            }
                        }
                    }
                }
                preX = -1;
                preY = -1;
            }
        } else {
            new WinFrame(UserName);
        }
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