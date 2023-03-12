package com.course_suc;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Objects;

/**
 * 主窗体
 *
 * @author Max chenmochen1954@163.com
 * since jdk17
 * @version 2022/12/21 9:55
 */

public class MainFrame extends JFrame  implements InterfaceForm{

    private JPanel contentPane;
    private JDesktopPane table =null;


    /**
     * Create the frame.
     */
    public MainFrame() {
        // 图书管理系统主界面图书
        setTitle("\u56fe\u4e66\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        // 老师要求加的01
        this.setExtendedState(Frame.MAXIMIZED_BOTH);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        // 基本数据维护
        JMenu mnNewMenu = new JMenu("\u57FA\u672C\u6570\u636E\u7EF4\u62A4");
        mnNewMenu.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/base.png"))));
        menuBar.add(mnNewMenu);
        // 图书类别管理
        JMenu mnNewMenu1 = new JMenu("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
        mnNewMenu1.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/bookTypeManager.png"))));
        mnNewMenu.add(mnNewMenu1);
        // 图书类别添加
        JMenuItem menuItem = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
        menuItem.addActionListener(e -> {
            GoodsTypeAddInterFrm goodsTypeAddInterFrm = new GoodsTypeAddInterFrm();
            goodsTypeAddInterFrm.setVisible(true);
            table.add(goodsTypeAddInterFrm);
        });
        menuItem.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/add.png"))));
        mnNewMenu1.add(menuItem);
        // 图书类别维护
        JMenuItem menuItem1 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
        menuItem1.addActionListener(e -> {
            GoodsTypeManageInterFrm goodsTypeManageInterFrm =new GoodsTypeManageInterFrm();
            goodsTypeManageInterFrm.setVisible(true);
            table.add(goodsTypeManageInterFrm);
        });
        menuItem1.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/edit.png"))));
        mnNewMenu1.add(menuItem1);
        // 图书管理
        JMenu mnNewMenu2 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
        mnNewMenu2.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/bookManager.png"))));
        mnNewMenu.add(mnNewMenu2);
        // 图书添加
        JMenuItem menuItem2 = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
        menuItem2.addActionListener(arg0 -> {
            GoodsAddInterFrm goodsAddInterFrm =new GoodsAddInterFrm();
            goodsAddInterFrm.setVisible(true);
            table.add(goodsAddInterFrm);
        });
        menuItem2.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/add.png"))));
        mnNewMenu2.add(menuItem2);
        // 图书维护
        JMenuItem menuItem3 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
        menuItem3.addActionListener(arg0 -> {
            GoodsManageInterFrm goodsManageInterFrm =new GoodsManageInterFrm();
            goodsManageInterFrm.setVisible(true);
            table.add(goodsManageInterFrm);
        });
        menuItem3.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/edit.png"))));
        mnNewMenu2.add(menuItem3);

        JMenuItem menuItem4 = new JMenuItem("\u5B89\u5168\u9000\u51FA");
        menuItem4.addActionListener(e -> {
            int result=JOptionPane.showConfirmDialog(null, "是否退出系统");
            if(result==0){
                dispose();
            }
        });
        menuItem4.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/exit.png"))));
        mnNewMenu.add(menuItem4);
        // 关于我们
        JMenu menu = new JMenu("\u5173\u4E8E\u6211\u4EEC");
        menu.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/about.png"))));
        menuBar.add(menu);


        JMenuItem jMenuItem = new JMenuItem("\u5173\u4E8EJava");
        jMenuItem.addActionListener(arg0 -> {
            Java1234InterFrm java1234InterFrm=new Java1234InterFrm();
            java1234InterFrm.setVisible(true);
            table.add(java1234InterFrm);
        });
        jMenuItem.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/about.png"))));
        menu.add(jMenuItem);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        table = new JDesktopPane();
        contentPane.add(table, BorderLayout.CENTER);
    }

    @Override
    public void ExecuteForm(JMenuItem src) {
        // 设置JFrame最大化
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
    }
}
