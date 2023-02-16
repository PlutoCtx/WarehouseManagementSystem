package com.chentx.attempts;

/**
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/15 20:03
 * @since JDK17
 */

import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        // 返回全部字段名称
        String [] tableHead;

        // 返回二维数组，即查询的全部记录
        String [][] content;
        JTable table ;
        JFrame win = new JFrame();
        Query findRecord = new  Query();
        findRecord.setSql("SELECT * FROM clggb");
        // findRecord.setDatabaseName("warehousemanagementsystem");

        content = findRecord.getRecord();
        tableHead = findRecord.getColumnName();

        table = new JTable(content,tableHead);

        win.add(new JScrollPane(table));
        win.setBounds(12,100,800,400);
        win.setVisible(true);
        // JFrame.EXIT_ON_CLOSE
        win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}