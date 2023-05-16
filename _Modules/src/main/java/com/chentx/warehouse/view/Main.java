package com.chentx.warehouse.view;


import com.chentx.warehouse.mapper.MapMenu;
import com.chentx.warehouse.utils.Database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试界面
 * 本代码有一点问题，在程序运行之后，界面会显示，但是菜单栏不会显示，只有在调整了本界面的大小后才会出现菜单栏
 * 本菜单栏是活菜单，会根据数据库中的菜单栏表的变化而改变
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/3/23 23:34
 * @since JDK17
 */

public class Main extends JFrame {

    final JMenuBar jMenuBar = new JMenuBar();

    /**
     * 主方法，其实就是再一次进行封装
     * @throws Exception only God knows it
     */
    public Main() throws Exception {
        super("仓库管理系统");
        init();
        setVisible(true);
        setBounds(100,100,1100,900);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * 初始化界面，菜单栏
     * @throws Exception how do I know
     */
    private void init() throws Exception {
        // 初始化菜单栏，有四个主菜单项
        JMenu[] menu = new JMenu[4];

        Database database = new Database();
        Connection connection = database.getConnection();

        String sql = "SELECT * FROM menu";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String code = resultSet.getString("itemNumber").trim();

                int length = code.length() / 2 - 1;
                if (resultSet.getInt("isMenu") == 1){
                    menu[length] = new JMenu(title);
                    if (length == 0){
                        jMenuBar.add(menu[length]);
                    }else {
                        menu[length - 1].add(menu[length]);
                    }
                }else {
                    String className = resultSet.getString("classname");
                    MapMenu item = new MapMenu(title, className);
                    menu[length - 1].add(item);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            database.closeConnection(connection);
            connection.close();
        }
        setJMenuBar(jMenuBar);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
