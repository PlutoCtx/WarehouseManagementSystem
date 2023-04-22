package com.chentx.attempts.attempt01;

import java.sql.*;
import java.util.logging.Logger;

/**
 * 数据库连接
 *
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/16 14:27
 * @since JDK17
 */

public class DBConnection {
    /**
     * 数据库名
     */
    String databaseName = "warehousemanagementsystem";
    /**
     * SQL语句
     */
    String sql = "SELECT * FROM materialSpecificationSheet";
    /**
     * 全部字段（列）名
     */
    String [] columnName;
    /**
     * 查询到的记录
     */
    String [][] records;
    String DB_URL= "jdbc:mysql://localhost:3306/" + databaseName + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASSWORD = "Shangxiao111";

    /**
     * 加载JDBC-MySQL驱动
     */
    public DBConnection() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 获取数据库表中字段名
     * @return  columnName
     */
    public String[] getColumnName() {
        if(columnName == null ){
            // 先查询记录
            Logger.getGlobal().info("\u5148\u67E5\u8BE2\u8BB0\u5F55");
            // 原本是 return null
            return new String[0];
        }
        return columnName;
    }

    /**
     * 获取除字段名外的所有记录数据
     * @return [][] records
     */
    public String[][] getRecord() {
        startQuery();
        return records;
    }


    /**
     * 获取数据库中的所有数据，并与getRecord()方法共同获取除字段名外的所有记录数据
     */
    private void startQuery() {
        Connection con;
        Statement stmt;
        ResultSet resultSet;

        try {
            con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            resultSet=stmt.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            // 字段数目
            int columnCount = metaData.getColumnCount();
            // 获取字段名
            columnName=new String[columnCount];
            for(int i=1;i<=columnCount;i++){
                columnName[i-1]=metaData.getColumnName(i);
            }
            resultSet.last();

            // 结果集中的记录数目
            int recordAmount = resultSet.getRow();
            records = new String[recordAmount][columnCount];
            int i = 0;
            resultSet.beforeFirst();
            while(resultSet.next()) {
                for(int j=1;j<=columnCount;j++){
                    // 第i条记录，放入二维数组的第i行
                    records[i][j-1]=resultSet.getString(j);
                }
                i++;
            }
            con.close();
        } catch(SQLException e) {
            Logger.getGlobal().warning("请输入正确的表名：\n" + e);
        }
    }

}
