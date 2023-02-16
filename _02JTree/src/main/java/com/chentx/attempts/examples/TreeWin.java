package com.chentx.attempts.examples;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

/**
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/16 12:58
 * @since JDK17
 */

public class TreeWin extends JFrame implements TreeSelectionListener {
    JTree tree;
    JTextArea showText;
    TreeWin(){
        // 根节点
        DefaultMutableTreeNode root=new DefaultMutableTreeNode("商品");
        // 节点
        DefaultMutableTreeNode nodeTV=new DefaultMutableTreeNode("电视机类");
        // 节点
        DefaultMutableTreeNode nodePhone=new DefaultMutableTreeNode("手机类");
        // 节点
        DefaultMutableTreeNode tv1=
                new DefaultMutableTreeNode(new Goods("长虹电视",5699));
        // 节点
        DefaultMutableTreeNode tv2=
                new DefaultMutableTreeNode(new Goods("海尔电视",7832));
        // 节点
        DefaultMutableTreeNode phone1=
                new DefaultMutableTreeNode(new Goods("诺基亚手机",3600));
        // 节点
        DefaultMutableTreeNode phone2=
                new DefaultMutableTreeNode(new Goods("三星手机",2155));

        root.add(nodeTV);
        root.add(nodePhone);
        // 确定节点之间的关系
        nodeTV.add(tv1);
        nodeTV.add(tv2);
        nodePhone.add(phone1);
        nodePhone.add(phone2);
        // 用root做根的树组件
        tree=new JTree(root);
        // 监视树组件上的事件
        tree.addTreeSelectionListener(this);
        showText = new JTextArea();
        setLayout(new GridLayout(1,2));
        add(new JScrollPane(tree));
        add(new JScrollPane(showText));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(80,80,600,500);
        Font f = new Font("宋体",Font.PLAIN,22);
        SetFont.setFont(f,showText,tree);
        validate();
    }
    public void valueChanged(TreeSelectionEvent e){
        DefaultMutableTreeNode node=
                (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
        if (node == null) {
            return;
        }
        if(node.isLeaf()){
            // 得到节点中存放的对象
            Goods s=(Goods)node.getUserObject();
            showText.append(s.name+","+s.price+"元\n");
        }
        else{
            showText.setText(null);
        }
    }
}