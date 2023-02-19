package com.chentx.tables.module01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/18 0:02
 * @since JDK17
 */

public class Main {

    public static void main(String[] args) {
//        String[][] results;
//
//        DBConnector dbConnector = new DBConnector();
//        dbConnector.setSql("SELECT * FROM inboundandoutboundtable");
//
//        results = dbConnector.getRecord();
//        String[] tableHead = dbConnector.getColumnName();
//        for (String s : tableHead) {
//            System.out.print(s + " ");
//        }
//        for (int i = 0; i < results.length; i++){
//            for (int j = 0; j < results[i].length; j++) {
//                System.out.println(results[i][j] + "  ");
//            }
//            System.out.println();
//        }

        Connection con;
        Statement sql;
        ResultSet rs;

        con = DBConnector.connectionDB("warehousemanagementsystem", "root", "Shangxiao111");
        if (con == null) {
            return;
        }

        try {
            sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            rs = sql.executeQuery("SELECT * FROM inboundandoutboundtable");
            rs.last();
            int max = rs.getRow();
            System.out.println("the table has " + max + " records");

            int[] a = GetRandomNumber.getRandomNumber(max, max);
            for (int i : a) {
                rs.absolute(i);
                int z = rs.getInt(1);
                String x = rs.getString(2);
                String c = rs.getString(3);
                String v = rs.getString(4);
                int b = rs.getInt(5);
//                String n = rs.getString(6);
//                String m = rs.getString(7);
//                String l = rs.getString(8);
//                String k = rs.getString(9);
//                String j = rs.getString(10);
//                String h = rs.getString(11);
                System.out.printf("%d\t", z);
                System.out.printf("%s\t", x);
                System.out.printf("%s\t", c);
                System.out.printf("%s\t", v);
                System.out.printf("%d\t\n", b);
            }
            con.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
