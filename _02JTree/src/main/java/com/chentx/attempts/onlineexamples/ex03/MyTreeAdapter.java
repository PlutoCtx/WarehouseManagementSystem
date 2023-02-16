package com.chentx.attempts.onlineexamples.ex03;
//
//import javax.swing.JOptionPane;
//import javax.swing.event.TreeSelectionEvent;
//import javax.swing.event.TreeSelectionListener;
//import javax.swing.tree.TreePath;
//
///**
// * @author MaxBrooks chentingxian195467@163.com
// * @version 2023/2/16 8:32
// * @since JDK17
// */
//public class MyTreeAdapter implements TreeSelectionListener {
//
//    @Override
//    public void valueChanged(TreeSelectionEvent e) {
//        TreePath treePath = e.getNewLeadSelectionPath();// 例如[中国, 江苏省, 南京市]
//        if (treePath != null) {
//            // 返回路径上最底层的组件，对于树形结构，即叶子节点
//            // this will return an instance of TreeNode.
//            JTreeNode node = (JTreeNode) treePath.getLastPathComponent();
//            StringBuilder sb = new StringBuilder();
//            sb.append("您选择的是：");
//            sb.append(node);
//            sb.append("\r\n");
//            sb.append("路径为：");
//            sb.append(treePath);
//            JOptionPane.showMessageDialog(null, sb, "提示",
//                    JOptionPane.INFORMATION_MESSAGE);
//        } else {
//            JOptionPane.showMessageDialog(null, "您尚未选择省份或城市！", "错误",
//                    JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//}