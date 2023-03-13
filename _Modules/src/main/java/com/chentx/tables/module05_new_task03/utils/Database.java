package com.chentx.tables.module05_new_task03.utils;

import java.sql.*;
import java.util.logging.Logger;


/**
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/16 20:48
 * @since JDK17
 */

public class Database {
    /**
     * 数据库名
     */
    String databaseName = "";
    /**
     * sql语句
     */
    String SQL;
    /**
     * 查询到的记录的第一行，也就是指字段名
     */
    String [] columnName;
    /**
     * 查询到的所有记录
     */
    String [][] records;
    /**
     * 数据库连接
     */
    private final String url = "jdbc:mysql://localhost:3306/warehousemanagementsystem?" +
            "useUnicode=true" +
            "&characterEncoding=utf8" +
            "&rewriteBatchedStatements=true";
    /**
     * 用户
     */
    private static final String user = "root";
    /**
     * 密码
     */
    private final String password = "Shangxiao111";
    /**
     * 数据库连接
     */
    private Connection connection = null ;
    /**
     * "org.gjt.mm.mysql.Driver"似乎也是可以的， 但这是以前的时候用的，可能会出问题
     */
    String dbDriver = "com.mysql.cj.jdbc.Driver";
    public Database() {
        try{
            Class.forName(dbDriver);
        } catch(Exception e){
            e.printStackTrace();
        }
    }


    public Connection getConnection() {
        try {
            Class.forName(dbDriver) ;
            connection = DriverManager.getConnection(url, user, password) ;
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

    public void setDatabaseName(String s) {
        databaseName = s.trim();
    }

    public void setSQL(String SQL) {
        this.SQL = SQL.trim();
    }

    public String[] getColumnName() {
        if(columnName == null ){
            Logger.getGlobal().info("先查询记录");
            return new String[0];
        }
        return columnName;
    }

    public String[][] getRecord() {
        startQuery();
        return records;
    }

    private void startQuery() {
        Connection con;
        Statement sql;
        ResultSet rs;
        try {
            con = DriverManager.getConnection(url, user, password);
            sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = sql.executeQuery(SQL);
            ResultSetMetaData metaData = rs.getMetaData();
            // 字段数目，也就是列数
            int columnCount = metaData.getColumnCount();
            // 获取字段名
            columnName = new String[columnCount];
            for(int i = 1;i <= columnCount;i++){
                columnName[i-1] = metaData.getColumnName(i);
            }
            rs.last();
            // 结果集中的记录数目，recordAmount是记录数目
            int recordAmount = rs.getRow();
            records = new String[recordAmount][columnCount];
            int i = 0;
            rs.beforeFirst();
            while(rs.next()) {
                for(int j = 1; j <= columnCount; j++){
                    // 第i条记录，放入二维数组的第i行，也就是数组的第i-1号位置行
                    records[i][j-1] = rs.getString(j);
                }
                i++;
            }
            con.close();
        }catch(SQLException e) {
            Logger.getGlobal().info("请输入正确的表名"+e);
        }
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

