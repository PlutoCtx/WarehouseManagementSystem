package org.example.operator;

import org.example.tables.Depository;
import org.example.tool.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Op_Depository {
    public static int update(String cname,String pno,int num,double price,double sum_price) {
        String sql="update depository set num=?,price=?,sum_price=? where cname=? and pno=?";
        Connection conn = DBConnect.conn;
        int res=0;
        try {
            conn.setAutoCommit(false);
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, num);
            ps.setDouble(2, price);
            ps.setDouble(3, sum_price);
            ps.setString(4, cname);
            ps.setString(5, pno);

            res=ps.executeUpdate();

            if(res==0) {
                conn.rollback();				//修改失败回滚
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return res;
    }

    public static Depository findDepositoryRecord(String cname, String pno) {
        String sql="select * from depository where cname=? and pno=?";
        Connection conn= DBConnect.conn;
        Depository dRecord = null;
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, cname);
            ps.setString(2, pno);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                dRecord=new Depository(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
                        rs.getDouble(5), rs.getDouble(6));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dRecord;
    }
    public static int insert(String cname,String pno) {
        String sql="insert into depository values(null,?,?,0,0,0)";
        Connection conn= DBConnect.conn;
        int res=0;
        try {
            conn.setAutoCommit(false);
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, cname);
            ps.setString(2, pno);

            res=ps.executeUpdate();

            if(res==0) {
                conn.rollback();				//修改失败回滚
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return res;
    }
}
