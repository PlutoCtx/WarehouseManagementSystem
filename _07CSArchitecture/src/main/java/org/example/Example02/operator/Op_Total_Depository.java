package org.example.Example02.operator;


import org.example.Example02.biao.Total_Depository;
import org.example.Example02.tool.Get_Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Op_Total_Depository {
    public static int update(String pno,int num,double price,double sum_price) {
        String sql="update total_depository set num=?,price=?,sum_price=? where pno=?";
        Connection conn= Get_Connect.conn;
        int res=0;
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, num);
            ps.setDouble(2, price);
            ps.setDouble(3, sum_price);
            ps.setString(4, pno);
            res=ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return res;
    }

    public static Total_Depository findTotalDepositoryRecord(String pno) {
        String sql="select * from total_depository where pno=?";
        Connection conn=Get_Connect.conn;
        Total_Depository tRecord = null;
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, pno);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                tRecord=new Total_Depository(rs.getInt(1), rs.getString(2), rs.getInt(3),
                        rs.getDouble(4), rs.getDouble(5));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tRecord;
    }
    public static int insert(String pno) {
        String sql="insert into Total_depository values(null,?,0,0,0)";
        Connection conn=Get_Connect.conn;
        int res=0;
        try {
            conn.setAutoCommit(false);
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, pno);

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
