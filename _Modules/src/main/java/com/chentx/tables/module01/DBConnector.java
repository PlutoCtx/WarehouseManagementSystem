package com.chentx.tables.module01;

import lombok.Data;

/**
 * 数据库连接类
 *
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/17 18:16
 * @since JDK17
 */

@Data
public class DBConnector {
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
    String DB_URL= "jdbc:mysql://localhost:3306/" + databaseName + "?useSSL=true&serverTimezone=GMT&characterEncoding=utf-8";
    static final String USER = "root";
    static final String PASSWORD = "Yuhuangtao111";



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
