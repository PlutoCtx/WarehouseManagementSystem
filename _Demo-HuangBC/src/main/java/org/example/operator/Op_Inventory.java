package org.example.operator;

import org.example.tables.Inventory;
import org.example.tool.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author chent
 */
public class Op_Inventory {
    public static Inventory findInventoryRecord(int id) {
        String sql="select * from inventory where id=?";
        Connection conn= DBConnect.conn;
        Inventory record=null;
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                record=new Inventory(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return record;
    }

}
