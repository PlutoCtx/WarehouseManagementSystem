package org.example.Example02.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Get_Connect {
    private static String url = "jdbc:mysql://127.0.0.1:3306/warehouseManagementSystem";
    private static String name = "com.mysql.cj.jdbc.Driver";
    private static String user = "root";
    private static String password = "Shangxiao111";

    public static Connection conn=null;
    public static PreparedStatement pst = null;

    static{
        try {
            Class.forName(name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void getConnection() {
        try {
            conn= DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close() {
        if(conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        Get_Connect.url = url;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Get_Connect.name = name;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        Get_Connect.user = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Get_Connect.password = password;
    }
}
