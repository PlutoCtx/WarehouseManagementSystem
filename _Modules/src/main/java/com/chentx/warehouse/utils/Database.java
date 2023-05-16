package com.chentx.warehouse.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库连接
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/3/23 23:31
 * @since JDK17
 */

public class Database {

    /**
     * 数据库
     */
    private static final String URL = "jdbc:mysql://localhost:3306/warehouseManagementSystem" +
            "?useUnicode=true" +
            "&characterEncoding=utf8" +
            "&useSSL=false" +
            "&serverTimezone=UTC" +
            "&allowPublicKeyRetrieval=true";
    /**
     * 用户名
     */
    private static final String USERNAME = "root";
    /**
     * 密码
     */
    private static final String PASSWORD = "Shangxiao111";
    /**
     * 驱动名称
     */
    private static final String JDBC_NAME = "com.mysql.cj.jdbc.Driver";
    /**
     * 获取数据库连接
     * @return  返回连接
     * @throws Exception 没连上
     */
    public Connection getConnection() throws Exception{
        Class.forName(JDBC_NAME);
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    /**
     * 关闭数据库连接
     * @param connection    数据库连接
     * @throws Exception    异常
     */
    public void closeConnection(Connection connection) throws Exception{
        if (connection != null){
            connection.close();
        }
    }

}
