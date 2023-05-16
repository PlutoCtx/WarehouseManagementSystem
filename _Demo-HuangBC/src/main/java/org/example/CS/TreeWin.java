package org.example.CS;

import org.example.tool.DBConnect;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.sql.*;
public class TreeWin extends JPanel implements TreeSelectionListener {
    JTree tree;
    DefaultMutableTreeNode alyernode[]=new DefaultMutableTreeNode[9];
    String [] tableHead;
    String [][] content;
    String dataTable;
    EditPanel editPanel;
    public void setDataTable(String dataTable) {
        this.dataTable=dataTable;
    }
    public TreeWin(EditPanel editPanel,String dataTable)
    {
        this.editPanel = editPanel;
        System.out.println(dataTable);
        setDataTable(dataTable);
        get();
        creat();
        tree=new JTree(alyernode[0]);
        tree.addTreeSelectionListener(this);
        setLayout(new GridLayout(1,1));
        add(new JScrollPane(tree));
        setVisible(true);
        setBounds(80,80,600,500);
        Font f = new Font("宋体",Font.PLAIN,22);
        //SetFont.setFont(f,showText,tree);
        validate();
    }
    void creat()
    {
        alyernode[0]=new DefaultMutableTreeNode(new Node(content[0]));
        for(int i=1,n=content.length;i<n;i++)
        {
            for(int j=0,m=content[i].length;j<m;j++)
            {
                content[i][j]=content[i][j].trim();
            }
            DefaultMutableTreeNode node=new DefaultMutableTreeNode(new Node(content[i]));
            String s=content[i][2];
            int len=s.length();
            int now_layer = len/2;
            alyernode[now_layer-1].add(node);
            alyernode[now_layer]=node;
        }
    }
    void get()
    {
        String sql="select * from clggb";
        try {
            Connection con= DBConnect.conn;
            PreparedStatement ps=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            tableHead=new String[columnCount];
            for(int i=1;i<=columnCount;i++){
                tableHead[i-1]=metaData.getColumnName(i);
            }
            rs.last();
            int recordAmount =rs.getRow();
            content = new String[recordAmount][columnCount];
            int i=0;
            rs.beforeFirst();
            while(rs.next()) {
                for(int j=1;j<=columnCount;j++){
                    content[i][j-1]=rs.getString(j);
                }
                i++;
            }
            //con.close();
        }
        catch(SQLException e) {
            System.out.println("请输入正确的表名"+e);
        }
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node=(DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if(node==null) {
            return;
        }
        if(node.isLeaf()) {
            System.out.println(node.toString());
            System.out.println(dataTable);
            String pno=node.toString().split(":")[1];
            System.out.println(pno);
            String sql="select * from "+dataTable+" where pno=?";
            try {
                DBConnect.getConnection();
                Connection conn= DBConnect.conn;
                PreparedStatement ps=conn.prepareStatement(sql);
                ps.setString(1, pno);
                ResultSet rs=ps.executeQuery();
                int f=1;

                while(rs.next()) {
                    f=0;

                    for(int i=0;i<editPanel.getItemCount();i++) {
                        editPanel.getTextField(i).setText(rs.getString(i+1));
                    }
                    break;
                }
                if(f==1) {
                    JOptionPane.showMessageDialog(new JPanel(),"无该货物记录");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            // showText.setText(null);
        }
    }
}
class Node {
    String name;
    String ggxh;
    String hh;
    String dw;
    String kcs;
    String pjj;
    String kczj;
    Node()
    {

    }
    Node(String s[])
    {
        setname(s[0]+":"+s[2]);
        setggxh(s[1]);
        sethh(s[2]);
        setdw(s[3]);
        setkcs(s[4]);
        setpjj(s[5]);
        setkczj(s[6]);
    }

    @Override
    public String toString()
    {
        return name;
    }
    public void setname(String s) {
        name=s;
    }
    public void setggxh(String s) {
        ggxh=s;
    }
    public void sethh(String s) {
        hh=s;
    }
    public void setdw(String s) {
        dw=s;
    }
    public void setkcs(String s) {
        kcs=s;
    }
    public void setpjj(String s) {
        pjj=s;
    }
    public void setkczj(String s) {
        kczj=s;
    }
}