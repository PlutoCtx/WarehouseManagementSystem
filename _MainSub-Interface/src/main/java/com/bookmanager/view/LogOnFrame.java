package com.bookmanager.view;

import com.bookmanager.dao.UserDao;
import com.bookmanager.model.User;
import com.bookmanager.utils.DBUtil;
import com.bookmanager.utils.StringUtil;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.Objects;

/**
 * 登录界面
 *
 * @author Max chenmochen1954@163.com
 * since jdk17
 * @version 2022/12/20 18:06
 */
public class LogOnFrame extends JFrame {

    private JPanel contentPane;
    private JTextField userNameText;
    private JPasswordField passwordText;

    private DBUtil dbUtil = new DBUtil();
    private UserDao userDao = new UserDao();

    /**
     * Launch the application
     * @param args ignored
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    LogOnFrame frame = new LogOnFrame();
                    frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame
     */
    public LogOnFrame(){
        //改变系统默认字体
        Font font = new Font("Dialog", Font.PLAIN, 12);
        // java.util.Enumeration keys = UIManager.getDefaults().keys();
        Enumeration<Object> keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()){
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource){
                UIManager.put(key, font);
            }
        }
        setResizable(false);
        // 管理员登录
        setTitle("\u7BA1\u7406\u5458\u767B\u5F55");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500,250,450,343);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 23));
        lblNewLabel.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/logo.png"))));

        JLabel lblNewLabel1 = new JLabel("\u7528\u6237\u540D\uFF1A");
        lblNewLabel1.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/userName.png"))));


        JLabel lblNewLabel2 = new JLabel("\u5BC6  \u7801\uFF1A");
        lblNewLabel2.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/password.png"))));

        userNameText = new JTextField();
        userNameText.setColumns(10);

        passwordText = new JPasswordField();

        JButton btnNewButton1 = new JButton("\u767B\u5F55");
        btnNewButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginActionPerformed(e);
            }
        });
        btnNewButton1.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/login.png"))));

        JButton btnNewButton2 = new JButton("\u91CD\u7F6E");
        btnNewButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginActionPerformed(e);
            }
        });
        btnNewButton2.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/reset.png"))));


        GroupLayout groupLayoutContentPane = new GroupLayout(contentPane);
        groupLayoutContentPane.setHorizontalGroup(
            groupLayoutContentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayoutContentPane.createSequentialGroup()
                    .addGroup(groupLayoutContentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayoutContentPane.createSequentialGroup()
                            .addGap(111)
                            .addComponent(lblNewLabel))
                        .addGroup(groupLayoutContentPane.createSequentialGroup()
                            .addGap(101)
                            .addGroup(groupLayoutContentPane.createParallelGroup(Alignment.LEADING)
                                .addComponent(lblNewLabel1)
                                .addComponent(lblNewLabel2)
                                .addComponent(btnNewButton1))
                            .addGap(32)
                            .addGroup(groupLayoutContentPane.createParallelGroup(Alignment.LEADING)
                                .addComponent(btnNewButton2)
                                .addGroup(groupLayoutContentPane.createParallelGroup(Alignment.LEADING, false)
                                    .addComponent(passwordText)
                                    .addComponent(userNameText, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)))))
                    .addContainerGap(111, Short.MAX_VALUE))
        );
        groupLayoutContentPane.setVerticalGroup(
            groupLayoutContentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayoutContentPane.createSequentialGroup()
                    .addGap(30)
                    .addComponent(lblNewLabel)
                    .addGap(26)
                    .addGroup(groupLayoutContentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayoutContentPane.createSequentialGroup()
                            .addComponent(lblNewLabel1)
                            .addGap(29)
                            .addGroup(groupLayoutContentPane.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblNewLabel2)
                                .addComponent(passwordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addComponent(userNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(36)
                    .addGroup(groupLayoutContentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnNewButton1)
                        .addComponent(btnNewButton2))
                    .addContainerGap(60, Short.MAX_VALUE))
        );
        contentPane.setLayout(groupLayoutContentPane);
        // 居中
        this.setLocationRelativeTo(null);
    }

    /**
     * 登录事件处理
     * @param evt action
     */
    private void loginActionPerformed(ActionEvent evt) {
        String userName = this.userNameText.getText();
        String password = new String(this.passwordText.getPassword());
        if (StringUtil.isEmpty(userName)){
            JOptionPane.showMessageDialog(null, "用户名不能为空");
            return;
        }
        if (StringUtil.isEmpty(password)){
            JOptionPane.showMessageDialog(null, "密码不能为空");
            return;
        }
        User user = new User(userName, password);
        Connection con = null;
        try {
            con = dbUtil.getConnection();
            User currentUser = userDao.login(con, user);
            if (currentUser != null){
                dispose();
                new MainFrame().setVisible(true);
//                JOptionPane.showMessageDialog(null, "登录成功");
            }else {
                JOptionPane.showMessageDialog(null, "用户名或密码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                dbUtil.closeConnection(con);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 重置事件处理
     * @param evt action
     */
    private void resetValueActionPerformed(ActionEvent evt){
        this.userNameText.setText("");
        this.passwordText.setText("");
    }

}
