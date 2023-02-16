package com.chentx.attempts.attempt01;

import com.chentx.attempts.examples.SetFont;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

/**
 * 生成树
 *
 * 还有问题，不算完成
 *
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/16 14:59
 * @since JDK17
 */

public class TreeWin extends JFrame implements TreeSelectionListener {

    /**
     * 种树（冷笑话）
     */
    JTree jTree;

    /**
     * 显示信息
     */
    JTextArea jTextArea;

    /**
     * 材料规格表的数据记录
     */
    String[][] materialSpecificationSheet;

    DBConnection dbConnection = new DBConnection();

    private void treeNodesSort(){
        materialSpecificationSheet = dbConnection.getRecord();

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("材料");

        DefaultMutableTreeNode[] nodes = null;
        for (int i = 0; i < materialSpecificationSheet.length; i++) {
            nodes[i] = new DefaultMutableTreeNode(new Material(materialSpecificationSheet[i][0], materialSpecificationSheet[i][2]));
        }


        for (int i = 0; i < materialSpecificationSheet.length; i++) {
            for (int j = i + 1; j < materialSpecificationSheet.length; j++) {
                if (materialSpecificationSheet[j][2].length() - materialSpecificationSheet[i][2].length() == 2){
                    nodes[i].add(nodes[j]);
                    break;
                }
            }
        }

        jTree = new JTree(root);
        jTree.addTreeSelectionListener(this);
        jTextArea = new JTextArea();
        setLayout(new GridLayout(1,2));
        add(new JScrollPane(jTree));
        add(new JScrollPane(jTextArea));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(80,80,600,500);
        Font f = new Font("宋体",Font.PLAIN,22);
        SetFont.setFont(f,jTextArea,jTree);
        validate();
    }


    public void valueChanged(TreeSelectionEvent e){
        DefaultMutableTreeNode node=
                (DefaultMutableTreeNode)jTree.getLastSelectedPathComponent();
        if (node == null) {
            return;
        }
        if(node.isLeaf()){
            // 得到节点中存放的对象
            Material s = (Material)node.getUserObject();
            jTextArea.append(s.toString() + "\n");
        }
        else{
            jTextArea.setText(null);
        }
    }


    public static void main(String[] args) {

        new TreeWin().treeNodesSort();


    }


}
