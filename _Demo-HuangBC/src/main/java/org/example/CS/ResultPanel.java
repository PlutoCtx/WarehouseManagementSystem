package org.example.CS;


import org.example.tool.DBConnect;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ResultPanel extends JTabbedPane {
    JPanel treePanel,tablePanel;
    JTable table;
    EditPanel editPanel;
    public ResultPanel(EditPanel editPanel) {
        this.editPanel=editPanel;
        initTable();
        addTab("表格", tablePanel);
    }
    void init(String dataTable)
    {
        treePanel=new TreeWin(editPanel,dataTable);
        addTab("目录树", treePanel);
    }
    public void initTable() {
        tablePanel=new JPanel();
        tablePanel=new JPanel();
        tablePanel.setLayout(new GridLayout(1,1));
        Object a[][];
        Object name[]={"名称","规范型号","货号","单位","库存量","平均价","库存资金"};
        a=new Object[1300][7];
        String sql = "select * from clggb";
        try {
            DBConnect.getConnection();
            Connection conn= DBConnect.conn;
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            int row=0;
            while(rs.next()){
                a[row][0]=rs.getString(1);
                a[row][1]=rs.getString(2);
                a[row][2]=rs.getString(3);
                a[row][3]=rs.getString(4);
                a[row][4]=rs.getString(5);
                a[row][5]=rs.getString(6);
                a[row][6]=rs.getString(7);
                row++;
            }
            DBConnect.close();
        } catch (Exception e) {
            System.out.println("表格初始化失败");
            e.printStackTrace();
        }
        table=new JTable(a,name);
        tablePanel.add(new JScrollPane(table));
    }
}
