package org.example.operator;

import org.example.tables.Standing_Book;
import org.example.tool.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Op_Standing_Book {
    public static int insert(Standing_Book sRecord) {
        String sql="insert into standing_book values(null,?,?,?,?,?,?,?,?,?)";
        Connection conn= DBConnect.conn;
        int res=0;
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, sRecord.getCname());
            ps.setString(2, sRecord.getPno());
            ps.setInt(3, sRecord.getBj());
            ps.setInt(4, sRecord.getNum());
            ps.setDouble(5, sRecord.getPrice());
            ps.setDouble(6, sRecord.getSum_price());

            ps.setInt(7, sRecord.getD_num());
            ps.setDouble(8, sRecord.getD_price());
            ps.setDouble(9, sRecord.getD_sum_price());
            res=ps.executeUpdate();
            System.out.println("StandingBookManager.insert()   "+res);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return res;
    }
}
