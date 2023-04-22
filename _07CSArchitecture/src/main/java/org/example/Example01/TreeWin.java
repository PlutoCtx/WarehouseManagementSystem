//package org.example.Example01;
//
///**
// * WarehouseManagementSystem
// *
// * @author MaxBrooks 15905898514@163.com
// * @version 2023/4/22 18:37
// * @since JDK17
// */
//
//import tool.Get_Connect;
//
//import javax.swing.*;
//import javax.swing.event.TreeSelectionEvent;
//import javax.swing.event.TreeSelectionListener;
//import javax.swing.tree.DefaultMutableTreeNode;
//import java.awt.*;
//import java.sql.*;
//public class TreeWin extends JPanel implements TreeSelectionListener {
//    JTree tree;
//    DefaultMutableTreeNode alyernode[]=new DefaultMutableTreeNode[9];
//    String [] tableHead;
//    String [][] content;
//    public TreeWin()
//    {
//        get();
//        creat();
//        tree=new JTree(alyernode[0]);
//        tree.addTreeSelectionListener(this);
//        setLayout(new GridLayout(1,1));
//        add(new JScrollPane(tree));
//        setVisible(true);
//        setBounds(80,80,600,500);
//        Font f = new Font("宋体",Font.PLAIN,22);
//        //SetFont.setFont(f,showText,tree);
//        validate();
//    }
//    void creat()
//    {
//        alyernode[0]=new DefaultMutableTreeNode(new Node(content[0]));
//        for(int i=1,n=content.length;i<n;i++)
//        {
//            for(int j=0,m=content[i].length;j<m;j++)
//            {
//                content[i][j]=content[i][j].trim();
//            }
//            DefaultMutableTreeNode node=new DefaultMutableTreeNode(new Node(content[i]));
//            String s=content[i][2];
//            int len=s.length();
//            int now_layer = len/2;
//            alyernode[now_layer-1].add(node);
//            alyernode[now_layer]=node;
//        }
//    }
//    void get()
//    {
//        String sql="select * from clggb";
//        try {
//            Get_Connect.getConnection();
//            Connection con=Get_Connect.conn;
//            PreparedStatement ps=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
//            ResultSet rs=ps.executeQuery();
//            ResultSetMetaData metaData = rs.getMetaData();
//            int columnCount = metaData.getColumnCount();
//            tableHead=new String[columnCount];
//            for(int i=1;i<=columnCount;i++){
//                tableHead[i-1]=metaData.getColumnName(i);
//            }
//            rs.last();
//            int recordAmount =rs.getRow();
//            content = new String[recordAmount][columnCount];
//            int i=0;
//            rs.beforeFirst();
//            while(rs.next()) {
//                for(int j=1;j<=columnCount;j++){
//                    content[i][j-1]=rs.getString(j);
//                }
//                i++;
//            }
//            con.close();
//        }
//        catch(SQLException e) {
//            System.out.println("请输入正确的表名"+e);
//        }
//    }
//
//    @Override
//    public void valueChanged(TreeSelectionEvent e) {
//        DefaultMutableTreeNode node=(DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
//        if(node==null)return;
//        if(node.isLeaf())
//        {
//            Node s =(Node)node.getUserObject();
//            //showText.append(s.name+",);
//        }
//        else
//        {
//            // showText.setText(null);
//        }
//    }
//}
