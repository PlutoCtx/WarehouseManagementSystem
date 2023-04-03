package com.bookmanager.view;

import com.bookmanager.mapper.MapMenu;
import com.bookmanager.utils.Database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试界面
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/3/23 23:34
 * @since JDK17
 */

public class Main extends JFrame {

    public JMenuBar menuBar = new JMenuBar();

    public Main() throws Exception {
        super("测试界面");
        setVisible(true);
        setBounds(50,50,1100,900);
        init();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void init() throws Exception {

        JMenu[] menu = new JMenu[4];

        Database database = new Database();
        Connection connection = database.getConnection();

        String sql = "select * from men";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String code = resultSet.getString("hh").trim();

                int length = code.length() / 2 - 1;
                if (resultSet.getInt("ismenu") == 1){
                    menu[length] = new JMenu(title);
                    if (length == 0){
                        menuBar.add(menu[length]);
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
        }
        connection.close();
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
