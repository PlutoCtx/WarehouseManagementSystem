package com.chentx.attempts;

/**
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/15 20:02
 * @since JDK17
 */

import java.sql.*;
import java.util.logging.Logger;

public class Query {
    /**
     * 数据库名
     */
    String databaseName = "warehousemanagementsystem";
    /**
     * SQL语句
     */
    String sql;
    /**
     * 全部字段（列）名
     */
    String [] columnName;
    /**
     * 查询到的记录
     */
    String [][] record;
    String DB_URL= "jdbc:mysql://localhost:3306/" + databaseName + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASSWORD = "Yuhuangtao111";

    /**
     * 加载JDBC-MySQL驱动
     */
    public Query() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(Exception e){
            e.printStackTrace();
        }
    }


    public void setSql(String sql) {
        this.sql = sql;
    }

//    public void setDatabaseName(String databaseName) {
//        this.databaseName = databaseName;
//    }

    /**
     * 获取数据库表中的字段名
     * @return [] columnName
     */
    public String[] getColumnName() {
        if(columnName ==null ){
            // 先查询记录
            Logger.getGlobal().info("\u5148\u67E5\u8BE2\u8BB0\u5F55");
            // 原本是 return null
            return new String[0];
        }
        return columnName;
    }

    /**
     * 获取记录
     * @return  返回获取到的记录内容
     */
    public String[][] getRecord() {
        startQuery();
        return record;
    }

    /**
     * 查询数据库
     */
    private void startQuery() {
        Connection con;
        Statement stmt;
        ResultSet resultSet;

        try {
            con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            resultSet = stmt.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            // 字段数目，也就是列数
            int columnCount = metaData.getColumnCount();
            // 获取字段名
            columnName = new String[columnCount];
            for(int i = 1;i <= columnCount;i++){
                columnName[i-1] = metaData.getColumnName(i);
            }
            resultSet.last();

            // 结果集中的记录数目，recordAmount是记录数目
            int recordAmount = resultSet.getRow();
            record = new String[recordAmount][columnCount];
            int i = 0;
            resultSet.beforeFirst();
            while(resultSet.next()) {
                for(int j = 1;j <= columnCount;j++){
                    // 第i条记录，放入二维数组的第i行，也就是数组的第i-1号位置行
                    record[i][j-1] = resultSet.getString(j);
                }
                i++;
            }
            con.close();
        } catch(SQLException e) {
            Logger.getGlobal().warning("请输入正确的表名：\n" + e);
        }
    }
}



