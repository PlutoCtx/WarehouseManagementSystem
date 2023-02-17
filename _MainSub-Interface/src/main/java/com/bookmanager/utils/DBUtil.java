package com.bookmanager.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库连接类
 *
 * @author Max chenmochen1954@163.com
 * since jdk17
 * @version 2022/12/18 23:13
 */
public class DBUtil {

    //数据库
    private String url = "jdbc:mysql://localhost:3306/sys";
    //用户名
    private String username = "root";
    //密码
    private String password = "Yuhuangtao111";
    //驱动名称
    private String jdbcName = "com.mysql.cj.jdbc.Driver";

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



/*package com.bookmanager.utils;

/**
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/13 18:12
 * @since JDK17
 *

public class DBUtil {
}*/
