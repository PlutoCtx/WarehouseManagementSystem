package org.example.operator;


import org.example.tables.In_Record;
import org.example.tool.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author chent
 */
public class Op_in_Record {
    public static int insert(In_Record in) {
        String sql="insert into in_record values(null,?,?,?,?,?,?,0,0)";
        Connection conn= DBConnect.conn;
        int res=0;
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, in.getCname());
            ps.setString(2, in.getPno());
            ps.setInt(3, in.getNum());
            ps.setDouble(4, in.getPrice());
            ps.setDouble(5, in.getSum_price());
            ps.setInt(6, in.getBj());
            res=ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return res;
    }

    public static In_Record findIn_RecordById(int id) {
        String sql="select * from in_record where id=?";
        Connection conn= DBConnect.conn;
        In_Record in = null;
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                in=new In_Record(id, rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5),
                        rs.getDouble(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return in;
    }

    public static int updateCheck(In_Record in) {
        int id=in.getId();
        String sql="update in_record set checked=1 where id=?";
        Connection conn= DBConnect.conn;
        if(in.getChecked()!=0)return 0;
        int res=0;
        try {
            conn.setAutoCommit(false);
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, id);
            res=ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return res;
    }

    public static int updateVs(In_Record in) {
        int id=in.getId();
        String sql="update in_record set vs=1 where id=?";
        Connection conn= DBConnect.conn;
        int res=0;
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, id);
            res=ps.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return res;
    }
}
