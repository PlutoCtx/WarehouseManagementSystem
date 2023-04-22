package org.example.Example02.CS;

import org.example.Example02.tool.Get_Connect;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main_Frame extends JFrame {
    public JMenuBar menuBar = new JMenuBar();
    public Main_Frame() {
        super("主页面");
        setVisible(true);
        setBounds(50, 50, 1100, 900);
        init();
    }
    public void init() {
        JMenu myMenu[]=new JMenu[4];

        Get_Connect.getConnection();
        Connection conn=Get_Connect.conn;
        String sql="select * from menu";
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
        Get_Connect.close();
        setJMenuBar(menuBar);
    }
}