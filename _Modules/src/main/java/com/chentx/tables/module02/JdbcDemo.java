package com.chentx.tables.module02;

import lombok.Data;

import java.sql.*;
import java.util.logging.Logger;

/**
 * ISBN:978-7-302-58165-9     9-1
 *
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/18 10:03
 * @since JDK17
 */

@Data
public class JdbcDemo {
    public static void main(String[] args) {

        String databaseName = "warehousemanagementsystem";
        String url = "jdbc:mysql://localhost:3306/" + databaseName + "?useSSL=true&serverTimezone=GMT&characterEncoding=utf-8";
        String user = "root";
        String password = "Shangxiao111";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        }catch (ClassNotFoundException | InstantiationException | IllegalAccessException e){
            Logger.getGlobal().warning("warning" + e);
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            queryAndDisplay(stmt, rs);
            stmt.executeUpdate("INSERT INTO inboundandoutboundtable VALUES (, 'FWE', 'WEF', 'RTH', 15, 'REG', 15.2, 12.3, 'UJ', 'IK', 111, , 1, 'ERHY', 'QEF')");

            System.out.println("添加数据后的信息：");
            queryAndDisplay(stmt, rs);

            stmt.executeUpdate("DELETE FROM inboundandoutboundtable WHERE name = 'FWE'");
            System.out.println("删除数据后的信息：");
            queryAndDisplay(stmt, rs);

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs != null){
                try {
                    rs.close();
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (stmt != null){
                try {
                    stmt.close();
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null){
                try {
                    conn.close();
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }





















    }



    private static void queryAndDisplay(Statement stmt, ResultSet rs) throws SQLException {
        rs = stmt.executeQuery("SELECT * FROM inboundandoutboundtable");
        while (rs.next()) {
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
        }
    }

}
