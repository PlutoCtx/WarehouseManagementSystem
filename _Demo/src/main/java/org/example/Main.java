package org.example;

import org.example.mapper.MapMenu;
import org.example.utils.Database;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * 主窗体
 *
 * @author Max chenmochen1954@163.com
 * since jdk17
 * @version 2022/12/21 9:55
 */
public class Main extends JFrame{
    final JMenuBar jMenuBar = new JMenuBar();


    /**
     * Create the frame.
     */
    public Main() throws Exception {
        // 仓库管理系统
        setTitle("仓库管理系统");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 默认最小化界面大小
        setBounds(100, 100, 450, 300);
        // 打开时自动最大化界面
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        init();
    }

    /**
     * 初始化界面的菜单栏
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
                } else {
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
        new Main().setVisible(true);
    }

}
