package com.chentx.tables.module01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/18 0:02
 * @since JDK17
 */

public class Main {

    public static void main(String[] args) {

        Connection con;
        Statement sql;
        ResultSet rs;

        con = DBConnector.connectionDB("warehouseManagementSystem", "root", "Shangxiao111");
        if (con == null) {
            return;
        }

        try {
            sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            rs = sql.executeQuery("SELECT * FROM inboundtable");
            rs.last();
            int max = rs.getRow();
            Logger.getGlobal().info("the table has " + max + " records");

            int[] a = GetRandomNumber.getRandomNumber(max, max);
            for (int i : a) {
                rs.absolute(i);
                int z = rs.getInt(1);
                String x = rs.getString(2);
                String c = rs.getString(3);
                String v = rs.getString(4);
                String b = rs.getString(5);

                Logger.getGlobal().info(z + "\t" + x + "\t" + c + "\t" + v + "\t" + b + "\n");
            }
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
