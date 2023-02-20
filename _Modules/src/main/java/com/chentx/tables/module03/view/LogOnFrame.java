package com.chentx.tables.module03.view;

import com.chentx.tables.module03.dao.EmployeeDao;
import com.chentx.tables.module03.model.Employee;
import com.chentx.tables.module03.utils.DBUtil;
import com.chentx.tables.module03.utils.StringUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.Objects;

/**
 * 登录界面（起始界面）
 *
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/20 20:24
 * @since JDK17
 */

public class LogOnFrame extends JFrame {
    /**
     * 登录界面
     */
    private JPanel contentPane;
    /**
     * 用户名输入栏
     */
    private JTextField userNameText;
    /**
     * 密码框
     */
    private JPasswordField passwordText;
    private DBUtil dbUtil = new DBUtil();
    private Employee.EmployeeBuilder builder;
    private Employee employee;
    private EmployeeDao employeeDao = new EmployeeDao();


    /**
     * Launch the application
     * @param args ignored
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    // 调用LogOnFrame构造方法，生成界面
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
        Enumeration<Object> keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()){
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource){
                UIManager.put(key, font);
            }
        }
        // 设定登录界面的窗口大小不能调整
        setResizable(false);
        // 管理员登录，ascii码，中文显示不太正常
        setTitle("\u7BA1\u7406\u5458\u767B\u5F55");
        // 关闭窗口程序会结束运行
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置登录窗口的大小
        setBounds(500,250,450,343);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);

        // 图书管理系统
        JLabel lblNewLabel = new JLabel("\u4ed3\u5e93\u7ba1\u7406\u7cfb\u7edf");
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 23));
//        lblNewLabel.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/logo.png"))));

        // 用户名：
        JLabel lblNewLabel1 = new JLabel("\u7528\u6237\u540D\uFF1A");
//        lblNewLabel1.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/userName.png"))));

        // 密码：
        JLabel lblNewLabel2 = new JLabel("\u5BC6\u7801\uFF1A");
//        lblNewLabel2.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/password.png"))));

        userNameText = new JTextField();
        userNameText.setColumns(10);

        passwordText = new JPasswordField();

        // 登录
        JButton btnNewButton1 = new JButton("\u767B\u5F55");
        // 使用登录方法
        btnNewButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginActionPerformed(e);
            }
        });
//        btnNewButton1.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/login.png"))));

        // 重置
        JButton btnNewButton2 = new JButton("\u91CD\u7F6E");
        // 使用重置方法
        btnNewButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetValueActionPerformed(e);
            }
        });
//        btnNewButton2.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/reset.png"))));


        
        GroupLayout groupLayoutContentPane = new GroupLayout(contentPane);
        groupLayoutContentPane.setHorizontalGroup(
                groupLayoutContentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayoutContentPane.createSequentialGroup()
                                .addGroup(groupLayoutContentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(groupLayoutContentPane.createSequentialGroup()
                                                .addGap(111)
                                                .addComponent(lblNewLabel))
                                        .addGroup(groupLayoutContentPane.createSequentialGroup()
                                                .addGap(101)
                                                .addGroup(groupLayoutContentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblNewLabel1)
                                                        .addComponent(lblNewLabel2)
                                                        .addComponent(btnNewButton1))
                                                .addGap(32)
                                                .addGroup(groupLayoutContentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnNewButton2)
                                                        .addGroup(groupLayoutContentPane.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(passwordText)
                                                                .addComponent(userNameText, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)))))
                                .addContainerGap(111, Short.MAX_VALUE))
        );
        groupLayoutContentPane.setVerticalGroup(
                groupLayoutContentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayoutContentPane.createSequentialGroup()
                                .addGap(30)
                                .addComponent(lblNewLabel)
                                .addGap(26)
                                .addGroup(groupLayoutContentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(groupLayoutContentPane.createSequentialGroup()
                                                .addComponent(lblNewLabel1)
                                                .addGap(29)
                                                .addGroup(groupLayoutContentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblNewLabel2)
                                                        .addComponent(passwordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(userNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(36)
                                .addGroup(groupLayoutContentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
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
        //        String password = new String(this.passwordText.getPassword());
        String password = String.valueOf(this.passwordText.getPassword());
        // 判断用户名是否为空
        if (StringUtil.isEmpty(userName)){
            JOptionPane.showMessageDialog(null, "用户名不能为空");
            return;
        }
        // 判断密码是否为空
        if (StringUtil.isEmpty(password)){
            JOptionPane.showMessageDialog(null, "密码不能为空");
            return;
        }

        Employee build = builder.withName(userName).withPassword(password).build();
//        System.out.println(builder);
//        employee = new Employee
//        Employee employee = Employee.EmployeeBuilder.create("server").withAge(45).build();
//        System.out.println(employee.getEmployeeNumber() + "  " + employee.getAge());
//        Employee employeeOne = Employee.EmployeeBuilder.anEmployee().withAge(46).build();

//        builder = Employee.EmployeeBuilder.anEmployee();
//        System.out.println(builder);

//        User user = new User(userName, password);
        Connection con = null;
        try {
            con = dbUtil.getConnection();
//            Employee employee = new Employee.EmployeeBuilder();
            Employee currentEmployee = employeeDao.login(con, build);



//            User currentUser = userDao.login(con, user);
            if (currentEmployee != null){
                dispose();
                System.out.println("hhhhhhhhhhhhhhhhhhhhhhhh");
//                new MainFrame().setVisible(true);
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





