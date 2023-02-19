package com.chentx.tables.module03.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * database connection
 * @author MaxBrooks chentingxian195467@163.com
 * @since JDK17
 * @version 2023/2/18 17:32
*/

public class DBUtil {
    /**
     * 数据库链接，最后一段rewriteBatchedStatements=true表示开启批处理
     */
    private String url = "jdbc:mysql://localhost:3306/warehousemanagementsystem?" +
            "useUnicode=true" +
            "&characterEncoding=utf8" +
            "&useSSL=false" +
            "&serverTimezone=UTC" +
            "&allowPublicKeyRetrieval=true" +
            "&rewriteBatchedStatements=true";
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
