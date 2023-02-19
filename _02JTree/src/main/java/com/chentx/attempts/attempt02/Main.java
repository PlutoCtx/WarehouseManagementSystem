package com.chentx.attempts.attempt02;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.List;

/**
 *
 * there is some bug remaining,which I can't find out,cause the same codes run perfectly in my another computer
 *
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/16 17:15
 * @since JDK17
 */

public class Main {
    public static void main(String[] args) {
        DBConnector dbConnector = new DBConnector();
        Material rootMaterial = dbConnector.queryMaterialByHH("B");
        JFrame jFrame = new JFrame();
        jFrame.setSize(1200, 800);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel jPanel = new JPanel();
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(rootMaterial);
        JTree jTree = new JTree(root);
        jTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree
                        .getLastSelectedPathComponent();
                if (node.isLeaf()) {
                    Material material = (Material) node.getUserObject();
                    List<Material> materialList = dbConnector.queryNodeByHH(material.getHh());
                    for (Material m : materialList) {
                        node.add(new DefaultMutableTreeNode(m));
                    }
                    jPanel.validate();
                }
            }
        });

        jPanel.add(jTree);
        jFrame.setContentPane(jPanel);
        jFrame.setTitle("材料目录树");
        jFrame.setVisible(true);
    }
}
