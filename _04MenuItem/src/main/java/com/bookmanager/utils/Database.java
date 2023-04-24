package com.bookmanager.utils;

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
    private final String url = "jdbc:mysql://localhost:3306/warehouseManagementSystem" +
            "?useUnicode=true" +
            "&characterEncoding=utf8" +
            "&useSSL=false" +
            "&serverTimezone=UTC" +
            "&allowPublicKeyRetrieval=true";
    /**
     * 用户名
     */
    private final String username = "root";
    /**
     * 密码
     */
    private final String password = "Shangxiao111";
    /**
     * 驱动名称
     */
    private final String jdbcName = "com.mysql.cj.jdbc.Driver";

    /**
     * 获取数据库连接
     * @return  返回连接
     * @throws Exception 没连上
     */
    public Connection getConnection() throws Exception{
        Class.forName(jdbcName);
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
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
