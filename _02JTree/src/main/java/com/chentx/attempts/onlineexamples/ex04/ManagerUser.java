package com.chentx.attempts.onlineexamples.ex04;
//
//import javax.swing.*;
//import javax.swing.event.TreeSelectionEvent;
//import javax.swing.event.TreeSelectionListener;
//import javax.swing.tree.DefaultMutableTreeNode;
//import javax.swing.tree.TreeSelectionModel;
//import java.awt.*;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//
//
//
//
//
//import java.awt.BorderLayout;
//import java.awt.Button;
//import java.awt.Container;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.GridLayout;
//import java.awt.MenuItem;
//import java.awt.PopupMenu;
//import java.awt.ScrollPane;
//import java.awt.Window;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Calendar;
//import java.util.Date;
//
//import javax.swing.Action;
//import javax.swing.Box;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JMenuItem;
//import javax.swing.JPanel;
//import javax.swing.JPopupMenu;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//import javax.swing.JTree;
//import javax.swing.ScrollPaneConstants;
//import javax.swing.event.TreeSelectionEvent;
//import javax.swing.event.TreeSelectionListener;
//import javax.swing.tree.DefaultMutableTreeNode;
//import javax.swing.tree.TreePath;
//import javax.swing.tree.TreeSelectionModel;
//
///**
// * @author MaxBrooks chentingxian195467@163.com
// * @version 2023/2/16 10:24
// * @since JDK17
// */
//
//public class ManagerUser extends JFrame implements TreeSelectionListener {
//    JTree tree;
//    private JPanel p;
//    ManagerUser ManagerUser=this;
//    ManagerUser(){
//        Container c = this.getContentPane();
//        DefaultMutableTreeNode root=new DefaultMutableTreeNode("??????");
//        DefaultMutableTreeNode route=new DefaultMutableTreeNode("????????????");
//        DefaultMutableTreeNode people=new DefaultMutableTreeNode("????????????");
//        DefaultMutableTreeNode add=new DefaultMutableTreeNode("????????????");
//        DefaultMutableTreeNode revice=new DefaultMutableTreeNode("??????????????????");
//        DefaultMutableTreeNode delete=new DefaultMutableTreeNode("????????????");
//        DefaultMutableTreeNode See=new DefaultMutableTreeNode("??????????????????");
//        DefaultMutableTreeNode show=new DefaultMutableTreeNode("??????????????????");
//        DefaultMutableTreeNode chat=new DefaultMutableTreeNode("??????????????????");
//        root.add(route);
//        root.add(people);
//        route.add(add);
//        route.add(revice);
//        route.add(delete);
//        route.add(See);
//        people.add(show);
//        people.add(chat);
//        tree=new JTree(root);
//        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
//        tree.addTreeSelectionListener(this);
//        p=new JPanel();
//        p.setSize(1000,1000);
//        c.add(tree,BorderLayout.WEST);
//        c.add(p,BorderLayout.CENTER);
//
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setVisible(true);
//
//        //validate();
//    }
//    public void valueChanged(TreeSelectionEvent e) {
//        DefaultMutableTreeNode selectionNode=(DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
//        if(selectionNode.isLeaf()){ //?????????????????????
//            System.out.println(selectionNode.toString());
//            if(selectionNode.toString()=="????????????") {    //????????????
//                AddRouteListener computer = new AddRouteListener();
//
//                JPanel p1=new JPanel();
//                System.out.println(selectionNode.toString());
//                JTextField textInput1;
//                JTextField textInput2;
//                JTextField textInput3;
//                JTextField textInput4;
//                JTextField textInput5;
//                JTextField textInput6;
//                JTextField textInput7;
//                JTextField textInput8;
//                JTextField textInput9;
//                JTextField textInput10;
//                JButton button1,button2,button3;
//                Box box,box1,box2,box3,box4,box5;
//                box= Box.createVerticalBox();
//                box1 = Box.createHorizontalBox();
//                box4 = Box.createHorizontalBox();
//                box2 = Box.createVerticalBox();//???????????????
//                box3 = Box.createVerticalBox();
//                box2.add(new JLabel("?????????????????????"));
//                box2.add(Box.createHorizontalStrut(1));
//                box2.add(new JLabel("????????????"));
//                box2.add(Box.createHorizontalStrut(1));
//                box2.add(new JLabel("????????????"));
//                box2.add(Box.createHorizontalStrut(1));
//                box2.add(new JLabel("???????????????"));
//                box2.add(Box.createHorizontalStrut(1));
//                box2.add(new JLabel("???????????????"));
//                box2.add(Box.createHorizontalStrut(1));
//                box2.add(new JLabel("???????????????"));
//                box2.add(Box.createHorizontalStrut(1));
//                box2.add(new JLabel("???????????????"));
//                box2.add(Box.createHorizontalStrut(1));
//                box2.add(new JLabel("???????????????"));
//                box2.add(Box.createHorizontalStrut(1));
//                box2.add(new JLabel("???????????????"));
//                box2.add(Box.createHorizontalStrut(1));
//                box2.add(new JLabel("???????????????"));
//                button1 = new JButton("??????");
//                button2 = new JButton("??????");
//                button3 = new JButton("??????");
//                textInput1 = new JTextField(10);
//                box3.add(textInput1);
//                box3.add(Box.createHorizontalStrut(1));
//                textInput2 = new JTextField(10);
//                box3.add(textInput2);
//                box3.add(Box.createHorizontalStrut(1));
//                textInput3 = new JTextField(10);
//                box3.add(textInput3);
//                box3.add(Box.createHorizontalStrut(1));
//                textInput4 = new JTextField(10);
//                box3.add(textInput4);
//                textInput5 = new JTextField(10);
//                box3.add(textInput5);
//
//                textInput6 = new JTextField(10);
//                box3.add(textInput6);
//                textInput7 = new JTextField(10);
//                box3.add(textInput7);
//                textInput8 = new JTextField(10);
//                box3.add(textInput8);
//                textInput9 = new JTextField(10);
//                box3.add(textInput9);
//                textInput10 = new JTextField(10);
//                box3.add(textInput10);
//                box4.add(button1);
//                box4.add(Box.createHorizontalStrut(20));
//                box4.add(button2);
//                box4.add(button3);
//                box1.add(box2);
//                box1.add(box3);
//                box.add(box1);
//                box.add(box4);
//
//                p.addMouseListener(new MouseAdapter() {
//                    public void mouseClicked(MouseEvent e) {
//                        if (e.getButton() == MouseEvent.BUTTON3) {
//                            // ????????????
//                            jp.show(p, e.getX(), e.getY());
//                        }
//                    }
//				  /* void copy_mousePressed(ActionEvent e) {
//					   String str=e.getActionCommand();
//					   if(str.equals(copy.getText())) {
//						   this.copy();
//					   }
//					   else if(str.equals(copy.getText())) {
//						   this.paste();
//					   }
//				   }*/
//                });
//                p.setVisible(true);
//
//
//                p1.add(box);
//                p1.setSize(800,800);
//                //p1.setBounds(0, 0, 200, 100);
//                p.removeAll();
//                p.add(p1);
//
//            }
//
//            if(selectionNode.toString()=="??????????????????") {    //????????????
//                ReviseRouteListener computer = new ReviseRouteListener();
//                JPanel p1=new JPanel();
//                System.out.println(selectionNode.toString());
//                JTextField textInput1;
//                JTextField textInput2;
//                JTextField textInput3;
//                JTextField textInput4;
//                JTextField textInput5;
//                JTextField textInput6;
//                JTextField textInput7;
//                JTextField textInput8;
//                JTextField textInput9;
//                JTextField textInput10;
//                JButton button1,button2,button3;
//                Box box,box1,box2,box3,box4,box5;
//                box= Box.createVerticalBox();
//                box1 = Box.createHorizontalBox();
//                box4 = Box.createHorizontalBox();
//                box2 = Box.createVerticalBox();//???????????????
//                box3 = Box.createVerticalBox();
//                box2.add(new JLabel("?????????????????????"));
//                box2.add(Box.createHorizontalStrut(1));
//                box2.add(new JLabel("????????????"));
//                box2.add(Box.createHorizontalStrut(1));
//                box2.add(new JLabel("????????????"));
//                box2.add(Box.createHorizontalStrut(1));
//                box2.add(new JLabel("???????????????"));
//                box2.add(Box.createHorizontalStrut(1));
//                box2.add(new JLabel("???????????????"));
//                box2.add(Box.createHorizontalStrut(1));
//                box2.add(new JLabel("???????????????"));
//                box2.add(Box.createHorizontalStrut(1));
//                box2.add(new JLabel("???????????????"));
//                box2.add(Box.createHorizontalStrut(1));
//                box2.add(new JLabel("???????????????"));
//                box2.add(Box.createHorizontalStrut(1));
//                box2.add(new JLabel("???????????????"));
//                box2.add(Box.createHorizontalStrut(1));
//                box2.add(new JLabel("???????????????"));
//                button1 = new JButton("??????");
//                button2 = new JButton("??????");
//                button3 = new JButton("??????");
//                textInput1 = new JTextField(10);
//                box3.add(textInput1);
//                box3.add(Box.createHorizontalStrut(1));
//                textInput2 = new JTextField(10);
//                box3.add(textInput2);
//                box3.add(Box.createHorizontalStrut(1));
//                textInput3 = new JTextField(10);
//                box3.add(textInput3);
//                box3.add(Box.createHorizontalStrut(1));
//                textInput4 = new JTextField(10);
//                box3.add(textInput4);
//                textInput5 = new JTextField(10);
//                box3.add(textInput5);
//
//                textInput6 = new JTextField(10);
//                box3.add(textInput6);
//                textInput7 = new JTextField(10);
//                box3.add(textInput7);
//                textInput8 = new JTextField(10);
//                box3.add(textInput8);
//                textInput9 = new JTextField(10);
//                box3.add(textInput9);
//                textInput10 = new JTextField(10);
//                box3.add(textInput10);
//                box4.add(button1);
//                box4.add(Box.createHorizontalStrut(20));
//                box4.add(button2);
//                box4.add(button3);
//                box1.add(box2);
//                box1.add(box3);
//                box.add(box1);
//                box.add(box4);
//                p1.add(box);
//                p1.setBounds(0, 0, 800, 800);
//
//                p.addMouseListener(new MouseAdapter() {
//                    public void mouseClicked(MouseEvent e) {
//                        if (e.getButton() == MouseEvent.BUTTON3) {
//                            // ????????????
//                            jp.show(p, e.getX(), e.getY());
//                        }
//                    }
//                });
//                p.setVisible(true);
//
//
//
//                p.removeAll();
//                p.add(p1);
//
//            }
//            if(selectionNode.toString()=="????????????") {    //????????????
//                DeleteRouteListener computer = new DeleteRouteListener();
//                JPanel p1=new JPanel();
//                System.out.println(selectionNode.toString());
//                JTextField textInput1;
//                JTextField textInput2;
//                JTextField textInput3;
//                JTextField textInput4;
//                JTextField textInput5;
//                JTextField textInput6;
//                JButton button1,button2,button3;
//                Box box,box1,box2,box3,box4,box5;
//                box= Box.createVerticalBox();
//                box1 = Box.createHorizontalBox();
//                box4 = Box.createHorizontalBox();
//                box2 = Box.createVerticalBox();//???????????????
//                box3 = Box.createVerticalBox();
//                box2.add(new JLabel("?????????????????????"));
//
//                button1 = new JButton("??????");
//                button2 = new JButton("??????");
//                button3 = new JButton("??????");
//                textInput1 = new JTextField(10);
//                box3.add(textInput1);
//                box4.add(button1);
//                box4.add(Box.createHorizontalStrut(20));
//                box4.add(button2);
//                box4.add(button3);
//                box1.add(box2);
//                box1.add(box3);
//                box.add(box1);
//                box.add(box4);
//                p1.add(box);
//                p1.setBounds(0, 0, 800, 800);
//
//                p.addMouseListener(new MouseAdapter() {
//                    public void mouseClicked(MouseEvent e) {
//                        if (e.getButton() == MouseEvent.BUTTON3) {
//                            // ????????????
//                            jp.show(p, e.getX(), e.getY());
//                        }
//                    }
//                });
//                p.setVisible(true);
//
//
//                p.removeAll();
//                p.add(p1);
//
//            }
//            if(selectionNode.toString()=="??????????????????") {
//                JButton button1=new JButton("??????????????????");
//                JPanel p1=new JPanel();
//                p1.setLayout(new java.awt.BorderLayout());
//                JTable table; Object a[][];
//                a=new Object[1000][11];
//                Object name[]= {"??????","?????????","?????????","????????????","????????????","????????????","??????????????????","??????????????????","??????????????????","??????????????????","??????"};
//                table=new JTable(a,name);
//                table.setSize(1000,1000);
//                //?????????
//                JScrollPane jsp=new JScrollPane(table);
//                p1.add(jsp,BorderLayout.SOUTH);
//                //p1.add(jsp,BorderLayout.CENTER);
//                //a[45][3]="?????????";
//                for(int i=0;i<11;i++) {
//                    a[0][i]=name[i];
//                }
//                jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);//???????????????????????????
//                jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//???????????????????????????
//                p1.add(button1, BorderLayout.NORTH);
//
//
//                table.getColumnModel().getColumn(0).setPreferredWidth(50);//???????????????????????????
//                table.getColumnModel().getColumn(1).setPreferredWidth(80);
//                table.getColumnModel().getColumn(2).setPreferredWidth(80);
//                table.getColumnModel().getColumn(3).setPreferredWidth(80);
//                table.getColumnModel().getColumn(4).setPreferredWidth(80);
//                table.getColumnModel().getColumn(5).setPreferredWidth(80);
//                table.getColumnModel().getColumn(6).setPreferredWidth(80);
//                table.getColumnModel().getColumn(7).setPreferredWidth(80);
//                table.getColumnModel().getColumn(8).setPreferredWidth(80);
//                table.getColumnModel().getColumn(9).setPreferredWidth(80);
//                table.getColumnModel().getColumn(10).setPreferredWidth(80);
//                //p1.add(table,BorderLayout.SOUTH);
//                p1.setBounds(0, 0, 800, 800);
//                p.removeAll();
//                p.add(p1);
//
//
//                //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//                table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//???????????????JTable????????????????????????JTable?????????????????????
//                // off???????????????~
//
//
//
//
//
//
//
//            }
//            if(selectionNode.toString()=="??????????????????") {
//                JButton button1=new JButton("????????????????????????");
//                JPanel p1=new JPanel();
//                p1.setLayout(new java.awt.BorderLayout());
//                JTable table; Object a[][];
//                a=new Object[100][7];
//                Object name[]= {"??????","??????","??????","????????????","????????????","??????","????????????"};
//                table=new JTable(a,name);
//                //a[99][3]="?????????";
//                for(int i=0;i<7;i++) {
//                    a[0][i]=name[i];
//                }
//
//                //?????????
//                JScrollPane jsp=new JScrollPane(table);
//                p1.add(jsp,BorderLayout.SOUTH);
//                p1.add(button1, BorderLayout.NORTH);
//
//                jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);//???????????????????????????
//                jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//???????????????????????????
//                //p1.add(table,BorderLayout.SOUTH);
//                p1.setBounds(0, 0, 800, 800);
//                p.removeAll();
//                p.add(p1);
//                table.getColumnModel().getColumn(0).setPreferredWidth(100);//???????????????????????????
//                table.getColumnModel().getColumn(1).setPreferredWidth(80);
//                table.getColumnModel().getColumn(2).setPreferredWidth(80);
//                table.getColumnModel().getColumn(3).setPreferredWidth(80);
//                table.getColumnModel().getColumn(4).setPreferredWidth(110);
//                table.getColumnModel().getColumn(5).setPreferredWidth(80);
//                table.getColumnModel().getColumn(6).setPreferredWidth(80);
//                table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//???????????????JTable????????????????????????JTable?????????????????????
//                // off???????????????~
//
//            }
//            if(selectionNode.toString()=="??????????????????") {
//                ChatWindow win=new ChatWindow();
//                win.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//            }
//        }
//    }
//
//
//
//}
//
//
