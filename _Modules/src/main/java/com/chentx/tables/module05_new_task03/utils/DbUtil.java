package com.chentx.tables.module05_new_task03.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * 数据库连接类
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/3/11 11:05
 * @since JDK17
 */

public class DbUtil {

    private final String url = "jdbc:mysql://localhost:3306/warehousemanagementsystem?" +
            "useUnicode=true" +
            "&characterEncoding=utf8" +
            "&rewriteBatchedStatements=true";
    private final String USER = "root" ;
    private final String PASSWORD = "Shangxiao111" ;
    /**
     * "org.gjt.mm.mysql.Driver"似乎也是可以的， 但这是以前的时候用的，可能会出问题
     */
    private final String dbDriver = "com.mysql.cj.jdbc.Driver" ;
    private Connection connection = null ;

    public Connection getConnection() {
        try {
            Class.forName(dbDriver) ;
            connection = DriverManager.getConnection(url, USER, PASSWORD) ;
            Logger.getGlobal().info("数据库连接成功！");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection ;
    }


    public void closeConnection() {
        if(connection !=null) {
            try {
                connection.close();
                Logger.getGlobal().info("数据库连接关闭");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

//    public static void main(String[] args) {
//        DBUtil dbUtil = new DBUtil() ;
//        dbUtil.getConnection();
//    }


    /**
     * 批量输入，并发插入数据
     *
     * @throws SQLException guess
     */
    public static void testInsert2() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 计算花费时间
            long start = System.currentTimeMillis();

            String sql = "insert into goods(name) values(?)";
            ps = conn.prepareStatement(sql);
            for(int i = 1;i <= 20000 ; i++){
                ps.setObject(1,"name_"+i);
                //1、“攒”sql
                ps.addBatch();
                if(i % 500 == 0){
                    //2、执行batch
                    ps.executeBatch();
                    //3、清空batch
                    ps.clearBatch();
                }
            }
            long end = System.currentTimeMillis();
            Logger.getGlobal().info(end-start+"ms");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            assert conn != null;
            conn.close();
        }
    }


}
