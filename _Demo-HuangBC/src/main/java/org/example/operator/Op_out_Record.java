package org.example.operator;

import org.example.tables.Out_Record;
import org.example.tool.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Op_out_Record {
    public static int insert(Out_Record out) {

        String sql="insert into out_record values(null,?,?,?,?,?,?,0,0)";
        Connection conn= DBConnect.conn;
        int res=0;
        try {
            conn.setAutoCommit(false);
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, out.getCname());
            ps.setString(2, out.getPno());
            ps.setInt(3, out.getNum());
            ps.setDouble(4, out.getPrice());
            ps.setDouble(5, out.getSum_price());
            ps.setInt(6, out.getBj());
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

    public static Out_Record findOut_RecordById(int id) {
        String sql="select * from out_record where id=?";
        Connection conn= DBConnect.conn;
        Out_Record out = null;
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                out=new Out_Record(id, rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5),
                        rs.getDouble(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return out;
    }

    public static int updateCheck(Out_Record out) {
        String sql="update out_record set checked=1 where id=?";
        if(out.getChecked()!=0)return 0;
        Connection conn= DBConnect.conn;
        int res=0;
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, out.getId());
            res=ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return res;
    }

    public static int updateVis(int id,int vs) {
        String sql="update out_record set vs=? where id=?";
        Connection conn= DBConnect.conn;
        int res=0;
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, vs);
            ps.setInt(2, id);
            res=ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return res;
    }
}
