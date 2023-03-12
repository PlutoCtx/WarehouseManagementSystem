package com.chentx.tables.module05_new_task03.view;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * 界面显示类
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/3/11 11:08
 * @since JDK17
 */

public class JTabbedPaneFrame {

    JFrame frame;
    JPanel panel1, panel2;
    JLabel jLabel1, jLabel2;
    JTabbedPane jTabbedPane;

    JTabbedPaneFrame(){
        frame = new JFrame("this is a test");
        // 选项卡一
        panel1 = new JPanel();
        // 选项卡二
        panel2 = new JPanel();

        jLabel1 = new JLabel("card one");
        jLabel2 = new JLabel("card two");

        //采用默认的选项卡面板
        jTabbedPane = new JTabbedPane();
    }

    public void displayWindow(){
        // BorderLayout
        panel1.setLayout(new BorderLayout());
        panel2.setLayout(new BorderLayout());

        ImageIcon imageIcon1 = new ImageIcon("_Modules/src/main/resources/add.png");
        imageIcon1.setImage(imageIcon1.getImage().getScaledInstance(15, 15, 1));
        ImageIcon imageIcon2 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/logo.png")));
        imageIcon2.setImage(imageIcon2.getImage().getScaledInstance(15, 15, 1));

        panel1.add(jLabel1);
        panel2.add(jLabel2);
        jTabbedPane.addTab("card 1", imageIcon1, panel1);
        jTabbedPane.addTab("card 2", imageIcon2, panel2);

        frame.setContentPane(jTabbedPane);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new JTabbedPaneFrame().displayWindow();
    }





}


/*
 * 学习并掌握选项卡JTabbedPane（教材p255),树组件与表格组件（p292）
 * mysql的多关联表的存储过程、触发器编程
 * jdbc的预处理编程
 * jdbc的事务处理编程
 * 提交（word文档）：
 * 4项内容的程序及截图
 */

