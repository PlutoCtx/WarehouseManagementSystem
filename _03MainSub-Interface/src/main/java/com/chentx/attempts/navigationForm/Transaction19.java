package com.chentx.attempts.navigationForm;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Logger;

/**
 * @author Max chenmochen1954@163.com
 * since jdk17
 * @version 2023/2/17 12:23
 */
class Transaction19 {
    private String database;
    private String table;

    private Connection con = null;
    private Statement stm = null;
    private ResultSet rs = null;
    private ResultSetMetaData rsmd = null;

    private int rowCount = 0;
    private int columnCount = 0;

    private String[] columnNames = null;
    private String[] result = null;

    private int currentRow = 0;

    public Transaction19(String database, String table) {
        this.database = database;
        this.table = table;

        init();
        load();
    }

    public void init() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;DatabaseName=" + database,
                    "root", "Shangxiao111");
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void load() {
        try {
            rs = stm.executeQuery("select count(*) from " + table);
            rs.next();
            rowCount = rs.getInt(1);

            rs = stm.executeQuery("select * from " + table);
            rsmd = rs.getMetaData();
            columnCount = rsmd.getColumnCount();

            columnNames = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = rsmd.getColumnName(i);
            }

            result = new String[columnCount];
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public int getColumnCount() {
        return columnCount;
    }

    public String getDatabase() {
        return database;
    }

    public String getTable() {
        return table;
    }

    public String[] getColumnNames() {
        return columnNames;
    }

    public String[] getFirstRecord() {
        try {
            rs.first();
            for (int i = 1; i <= columnCount; i++) {
                result[i - 1] = rs.getString(i);
            }
            currentRow = rs.getRow();
            System.out.println(rs.getRow());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public String[] getPreviousRecord() throws SQLException {
        rs.previous();
        if (rs.isBeforeFirst()) {
            rs.first();
        }
        for (int i = 1; i <= columnCount; i++) {
            result[i - 1] = rs.getString(i);
        }
        currentRow = rs.getRow();
        System.out.println(rs.getRow());
        return result;
    }

    public String[] getNextRecord() throws SQLException {
        rs.next();
        if (rs.isAfterLast()) {
            rs.last();
        }
        for (int i = 1; i <= columnCount; i++) {
            result[i - 1] = rs.getString(i);
        }
        currentRow = rs.getRow();
        System.out.println(rs.getRow());
        return result;
    }

    public String[] getLastRecord() throws SQLException {
        rs.last();
        for (int i = 1; i <= columnCount; i++) {
            result[i - 1] = rs.getString(i);
        }
        currentRow = rs.getRow();
        System.out.println(rs.getRow());
        return result;
    }

    public void insertRecord(String[] values) {
        StringBuilder sql = new StringBuilder();

        try {
            for (int i = 0; i < values.length; i++) {
                if (rsmd.getColumnType(i + 1) == Types.VARCHAR
                        || rsmd.getColumnType(i + 1) == Types.TIMESTAMP) {
                    sql.append("'").append(values[i]).append("'");
                } else {
                    sql.append(values[i]);
                }
                if (i < values.length - 1) {
                    sql.append(",");
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            Statement insertStm = con.createStatement();
            insertStm.execute("insert into " + table + " values(" + sql + ")");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void updateRecord(String[] values) {
        StringBuilder sql = new StringBuilder();

        StringBuilder whereSQL = new StringBuilder();
        try {
            for (int i = 0; i < values.length; i++) {
                Vector keyFields = getKeyFields();

                if (rsmd.getColumnType(i + 1) == Types.VARCHAR
                        || rsmd.getColumnType(i + 1) == Types.TIMESTAMP) {
                    sql.append(rsmd.getColumnName(i + 1)).append("='").append(values[i]).append("'");
                    if (keyFields.contains(rsmd.getColumnName(i + 1))) {
                        whereSQL.append(rsmd.getColumnName(i + 1)).append("='").append(values[i]).append("'");
                    }
                } else {
                    sql.append(rsmd.getColumnName(i + 1)).append("=").append(values[i]);
                    if (keyFields.contains(rsmd.getColumnName(i + 1))) {
                        whereSQL.append(rsmd.getColumnName(i + 1)).append("=").append(values[i]);
                    }
                }
                if (i < values.length - 1) {
                    sql.append(",");
                }
            }
            Statement updateStm = con.createStatement();
            updateStm.executeUpdate("update " + table + " set " + sql
                    + " where " + whereSQL);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * 获取主键字段的函数
     * @return
     */
    private Vector getKeyFields() {
        // 主键字段可能包含多个字段，所以使用向量存储
        Vector key = new Vector();
        try {
            // 创建数据库元数据类变量
            DatabaseMetaData dmd = con.getMetaData();

            // 得到指定表的主键信息
            ResultSet keys = dmd.getPrimaryKeys(null, null, table);

            // 记录数与主键字段数相等，结果集的第4个字段为字段名称
            while (keys.next()) {
                key.add(keys.getString(4));
                System.out.println("keys.getString(4)=" + keys.getString(4));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return key;
    }

    public String[] getAbsoluteRecord(int number) {
        try {
            rs.beforeFirst();
            while (rs.next()) {
                if (rs.getRow() == number) {
                    break;
                }
            }
            if (rs.isAfterLast()) {
                rs.last();
            }
            for (int i = 1; i <= columnCount; i++) {
                result[i - 1] = rs.getString(i);
            }
            currentRow = number;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public void deleteRecord(String[] values) {
        StringBuilder whereSQL = new StringBuilder();
        try {
            Vector keyFields = getKeyFields();

            for (int i = 0; i < values.length; i++) {
                if (keyFields.contains(rsmd.getColumnName(i + 1))) {
                    if (rsmd.getColumnType(i + 1) == Types.VARCHAR
                            || rsmd.getColumnType(i + 1) == Types.TIMESTAMP) {
                        whereSQL.append(rsmd.getColumnName(i + 1)).append("='").append(values[i]).append("'");
                    } else {
                        whereSQL.append(rsmd.getColumnName(i + 1)).append("=").append(values[i]);
                    }
                }
            }
            Statement deleteStm = con.createStatement();
            deleteStm.executeUpdate("delete from " + table + " where "
                    + whereSQL);
        } catch (Exception e) {
            Logger.getGlobal().warning("" + e);
            e.printStackTrace();
        }
    }

    public int getCurrentRow() {
        return currentRow;
    }
}
