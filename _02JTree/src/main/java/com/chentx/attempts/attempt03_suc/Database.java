package com.chentx.attempts.attempt03_suc;

import java.sql.*;
import java.util.logging.Logger;


/**
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/16 20:48
 * @since JDK17
 */

public class Database {
    String databaseName = "";
    String SQL;
    String [] columnName;
    String [][] record;
    public Database() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(Exception e){}
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
        return record;
    }

    private void startQuery() {
        Connection con;
        Statement sql;
        ResultSet rs;
        String uri = "jdbc:mysql://localhost:3306/" + databaseName;
        try {
            con = DriverManager.getConnection(uri,"root","Yuhuangtao111");
            sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = sql.executeQuery(SQL);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            columnName = new String[columnCount];
            for(int i = 1;i <= columnCount;i++){
                columnName[i-1] = metaData.getColumnName(i);
            }
            rs.last();
            int recordAmount = rs.getRow();
            record = new String[recordAmount][columnCount];
            int i = 0;
            rs.beforeFirst();
            while(rs.next()) {
                for(int j = 1;j <= columnCount;j++){
                    record[i][j-1] = rs.getString(j);
                }
                i++;
            }
            con.close();
        }catch(SQLException e) {
            Logger.getGlobal().info("请输入正确的表名"+e);
        }
    }

}

