package org.example.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnect {
    private static String url = "jdbc:mysql://127.0.0.1:3306/test";
    private static String name = "com.mysql.cj.jdbc.Driver";
    private static String user = "root";
    private static String password = "Shangxiao111";

    public static Connection conn = null;
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
        DBConnect.url = url;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        DBConnect.name = name;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        DBConnect.user = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        DBConnect.password = password;
    }
}
