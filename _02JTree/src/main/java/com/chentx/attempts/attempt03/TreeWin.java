package com.chentx.attempts.attempt03;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

/**
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/16 20:52
 * @since JDK17
 */

public class TreeWin extends JFrame implements TreeSelectionListener {
    JTree tree;
    DefaultMutableTreeNode[] alyerNode = new DefaultMutableTreeNode[9];
    String [] tableHead;
    String [][] content;
    JTextArea showText;
    TreeWin(){
        get();
        creat();
        tree = new JTree(alyerNode[0]);
        tree.addTreeSelectionListener(this);
        showText = new JTextArea();
        setLayout(new GridLayout(1,2));
        add(new JScrollPane(tree));
        add(new JScrollPane(showText));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(80,80,900,500);
        Font f = new Font("宋体",Font.PLAIN,22);
        SetFont.setFont(f, showText, tree);
        validate();
    }

    void creat(){
        alyerNode[0] = new DefaultMutableTreeNode(new Node(content[0]));
        for(int i = 1,n = content.length;i < n;i++){
            for(int j = 0,m = content[i].length;j < m;j++){
                content[i][j] = content[i][j].trim();
            }
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(new Node(content[i]));
            String s = content[i][2];
            int len = s.length();
            int now_layer = len/2;
            alyerNode[now_layer-1].add(node);
            alyerNode[now_layer] = node;
        }
    }

    void get(){
        Database findRecord = new Database();
        findRecord.setDatabaseName("warehousemanagementsystem");
        findRecord.setSQL("select * from clggb");
        content = findRecord.getRecord();
        tableHead = findRecord.getColumnName();
    }

    void setalter(int c,DefaultMutableTreeNode s){
        alyerNode[c] = s;
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node=(DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if(node == null) {
            return;
        }
        if(node.isLeaf()){
            Node s = (Node)node.getUserObject();
            showText.append(s.toString() + "\n");
        }else{
            showText.setText(null);
        }
    }
}


