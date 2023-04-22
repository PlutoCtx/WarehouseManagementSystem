package org.example.attempt01;

import lombok.Data;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Logger;

/**
 * WarehouseManagementSystem
 * 数据导航条
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/4/22 17:56
 * @since JDK17
 */

@Data
class DBNavigation {
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

    public DBNavigation(String var1, String var2) {
        this.database = var1;
        this.table = var2;
        this.init();
        this.load();
    }

    public void init() {
//        String var1 = "com.hxtt.sql.access.AccessDriver";
//        String var2 = "jdbc:access:////";

        String var1 = "com.mysql.cj.jdbc.Driver";
        String var2 = "jdbc:mysql://127.0.0.1:3306/warehouseManagementSystem";

        try {
            Class.forName(var1);
            this.con = DriverManager.getConnection(var2 + this.database, "root", "Shangxiao111");
            this.stm = this.con.createStatement(1005, 1007);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public void load() {
        try {
            this.rs = this.stm.executeQuery("select count(*) from " + this.table);
            this.rs.next();
            this.rowCount = this.rs.getInt(1);
            this.rs = this.stm.executeQuery("select * from " + this.table);
            this.rsmd = this.rs.getMetaData();
            this.columnCount = this.rsmd.getColumnCount();
            this.columnNames = new String[this.columnCount];

            for(int var1 = 1; var1 <= this.columnCount; ++var1) {
                this.columnNames[var1 - 1] = this.rsmd.getColumnName(var1);
            }

            this.result = new String[this.columnCount];
        } catch (SQLException var2) {
            var2.printStackTrace();
        }

        }

        public int getColumnCount() {
            return this.columnCount;
        }

        public String getDatabase() {
            return this.database;
        }

        public String getTable() {
            return this.table;
        }

        public String[] getColumnNames() {
            return this.columnNames;
        }

        public String[] getFirstRecord() {
        try {
            this.rs.first();

            for(int var1 = 1; var1 <= this.columnCount; ++var1) {
                this.result[var1 - 1] = this.rs.getString(var1);
            }

            this.currentRow = this.rs.getRow();
            Logger.getGlobal().info(String.valueOf(this.rs.getRow()));
        } catch (SQLException var2) {
            var2.printStackTrace();
        }

        return this.result;
    }

    public String[] getPreviousRecord() throws SQLException {
        this.rs.previous();
        if (this.rs.isBeforeFirst()) {
            this.rs.first();
        }

        for(int var1 = 1; var1 <= this.columnCount; ++var1) {
            this.result[var1 - 1] = this.rs.getString(var1);
        }

        this.currentRow = this.rs.getRow();
        System.out.println(this.rs.getRow());
        return this.result;
    }

    public String[] getNextRecord() throws SQLException {
        this.rs.next();
        if (this.rs.isAfterLast()) {
            this.rs.last();
        }

        for(int var1 = 1; var1 <= this.columnCount; ++var1) {
            this.result[var1 - 1] = this.rs.getString(var1);
        }

        this.currentRow = this.rs.getRow();
        System.out.println(this.rs.getRow());
        return this.result;
    }

    public String[] getLastRecord() throws SQLException {
        this.rs.last();

        for(int var1 = 1; var1 <= this.columnCount; ++var1) {
            this.result[var1 - 1] = this.rs.getString(var1);
        }

        this.currentRow = this.rs.getRow();
        System.out.println(this.rs.getRow());
        return this.result;
    }

    public void insertRecord(String[] var1) {
        String var2 = "";

        try {
            for(int var3 = 0; var3 < var1.length; ++var3) {
                if (this.rsmd.getColumnType(var3 + 1) != 12 && this.rsmd.getColumnType(var3 + 1) != 93) {
                    var2 = var2 + var1[var3];
                } else {
                    var2 = var2 + "'" + var1[var3] + "'";
                }

                if (var3 < var1.length - 1) {
                    var2 = var2 + ",";
                }
            }
        } catch (SQLException var5) {
            var5.printStackTrace();
        }

        try {
            Statement var6 = this.con.createStatement();
            var6.execute("insert into " + this.table + " values(" + var2 + ")");
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

    }

    public void updateRecord(String[] var1) {
        String var2 = "";
        String var3 = "";

        try {
            for(int var4 = 0; var4 < var1.length; ++var4) {
                Vector var5 = this.getKeyFields();
                if (this.rsmd.getColumnType(var4 + 1) != 12 && this.rsmd.getColumnType(var4 + 1) != 93) {
                    var2 = var2 + this.rsmd.getColumnName(var4 + 1) + "=" + var1[var4] + "";
                    if (var5.contains(this.rsmd.getColumnName(var4 + 1))) {
                        var3 = var3 + this.rsmd.getColumnName(var4 + 1) + "=" + var1[var4];
                    }
                } else {
                    var2 = var2 + this.rsmd.getColumnName(var4 + 1) + "='" + var1[var4] + "'";
                    if (var5.contains(this.rsmd.getColumnName(var4 + 1))) {
                        var3 = var3 + this.rsmd.getColumnName(var4 + 1) + "='" + var1[var4] + "'";
                    }
                }

                if (var4 < var1.length - 1) {
                    var2 = var2 + ",";
                }
            }

            Statement var7 = this.con.createStatement();
            var7.executeUpdate("update " + this.table + " set " + var2 + " where " + var3);
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

    }

    private Vector getKeyFields() {
        Vector var1 = new Vector();

        try {
            DatabaseMetaData var2 = this.con.getMetaData();
            ResultSet var3 = var2.getPrimaryKeys((String)null, (String)null, this.table);

            while(var3.next()) {
                var1.add(var3.getString(4));
                System.out.println("keys.getString(4)=" + var3.getString(4));
            }
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

        return var1;
    }

    public String[] getAbsoluteRecord(int var1) {
        try {
            this.rs.beforeFirst();

            while(this.rs.next() && this.rs.getRow() != var1) {
            }

            if (this.rs.isAfterLast()) {
                this.rs.last();
            }

            for(int var2 = 1; var2 <= this.columnCount; ++var2) {
                this.result[var2 - 1] = this.rs.getString(var2);
            }

            this.currentRow = var1;
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

        return this.result;
    }

    public void deleteRecord(String[] var1) {
        String var2 = "";

        try {
            Vector var3 = this.getKeyFields();

            for(int var4 = 0; var4 < var1.length; ++var4) {
                if (var3.contains(this.rsmd.getColumnName(var4 + 1))) {
                    if (this.rsmd.getColumnType(var4 + 1) != 12 && this.rsmd.getColumnType(var4 + 1) != 93) {
                        var2 = var2 + this.rsmd.getColumnName(var4 + 1) + "=" + var1[var4];
                    } else {
                        var2 = var2 + this.rsmd.getColumnName(var4 + 1) + "='" + var1[var4] + "'";
                    }
                }
            }

            Statement var6 = this.con.createStatement();
            var6.executeUpdate("delete from " + this.table + " where " + var2);
        } catch (Exception var5) {
        }

    }

    public int getCurrentRow() {
        return this.currentRow;
    }
}


