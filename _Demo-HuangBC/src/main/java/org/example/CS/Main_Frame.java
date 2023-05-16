package org.example.CS;

import org.example.tool.DBConnect;

import javax.swing.*;
import java.sql.*;

public class Main_Frame extends JFrame {
    public JMenuBar menuBar = new JMenuBar();
    public Main_Frame() {
        super("主页面");
        setVisible(true);
        setBounds(50, 50, 1100, 900);
        init();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void init() {
        JMenu myMenu[]=new JMenu[4];

        DBConnect.getConnection();
        Connection conn= DBConnect.conn;
        String sql="select * from menu_order";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                String title=rs.getString("title");
                String code=rs.getString("hh").trim();
                //System.out.println(code);
                int len=code.length()/2-1;
                //System.out.println(len);
                if(rs.getInt("ismenu")==1) {
                    myMenu[len]=new JMenu(title);
                    if(len==0) {
                        menuBar.add(myMenu[len]);
                    } else {
                        myMenu[len-1].add(myMenu[len]);
                    }
                }
                else {
                    String className=rs.getString("classname");
                    MapMenu item=new MapMenu(title, className);
                    myMenu[len-1].add(item);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBConnect.close();
        setJMenuBar(menuBar);
    }
}