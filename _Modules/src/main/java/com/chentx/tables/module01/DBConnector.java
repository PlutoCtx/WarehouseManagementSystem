package com.chentx.tables.module01;

import lombok.Data;

import java.sql.*;
import java.util.logging.Logger;

/**
 * 数据库连接类
 *
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/17 18:16
 * @since JDK17
 */

@Data
public class DBConnector {

    public static Connection connectionDB(String DBName, String id, String p){
        Connection conn = null;
        String DB_URL= "jdbc:mysql://localhost:3306/" + DBName + "?useSSL=true&serverTimezone=GMT&characterEncoding=utf-8";

        new DBConnector();

        try {
            conn = DriverManager.getConnection(DB_URL, id, p);
        } catch (SQLException e) {
            Logger.getGlobal().info("" + e);
        }
        return conn;

    }

    /**
     * 加载JDBC-MySQL驱动
     */
    public DBConnector() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(Exception e){
            e.printStackTrace();
        }
    }


}
