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

        String databaseName = "warehouseManagementSystem";
        String url = "jdbc:mysql://localhost:3306/" + databaseName + "?useSSL=true&serverTimezone=GMT&characterEncoding=utf-8";
        String user = "root";
        String password = "Shangxiao111";

        Connection conn = null;
        Statement stmt = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        }catch (ClassNotFoundException | InstantiationException | IllegalAccessException e){
            Logger.getGlobal().warning("warning" + e);
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            queryAndDisplay(stmt, resultSet);
            stmt.executeUpdate(
                    "INSERT INTO " +
                    "inboundtable(checkId, businessType, warehouseNumber, " +
                    "itemNumber, transactionNumber, unit, averagePrice, " +
                    "totalInventoryPrice, vendorNumber, vendorName, done, " +
                    "warehouseKeeperNumber, warehouseManagerNumber) " +
                    "VALUES ('asd', 'FWE', 'WEF', 'RTH', 15, 'REG', " +
                    "15.2, 12.3, 'UJ', 'IK', 1, 'ERHY', 'QEF')"
            );

            Logger.getGlobal().info("添加数据后的信息：");
            queryAndDisplay(stmt, resultSet);

            stmt.executeUpdate("DELETE FROM inboundtable WHERE businessType = 'FWE'");
            Logger.getGlobal().info("删除数据后的信息：");
            queryAndDisplay(stmt, resultSet);

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (resultSet != null){
                try {
                    resultSet.close();
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



    private static void queryAndDisplay(Statement stmt, ResultSet resultSet) throws SQLException {
        resultSet = stmt.executeQuery("SELECT * FROM inboundtable");
        while (resultSet.next()) {
            Logger.getGlobal().info("" + resultSet.getInt(1));
            Logger.getGlobal().info("" + resultSet.getString(2));
        }
    }

}
