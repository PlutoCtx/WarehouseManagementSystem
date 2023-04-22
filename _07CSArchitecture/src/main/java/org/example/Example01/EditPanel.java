//package org.example.Example01;
//
//import javax.swing.*;
//import javax.swing.border.TitledBorder;
//import java.awt.*;
//import java.util.Vector;
//
///**
// * WarehouseManagementSystem
// *
// * @author MaxBrooks 15905898514@163.com
// * @version 2023/4/22 18:35
// * @since JDK17
// */
//
//public class EditPanel extends JPanel {
//    Vector<MyItem> items;
//    public EditPanel() {
//        setBorder(new TitledBorder(null,"编辑栏",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("宋体",0,20),Color.BLACK));
//        init();
//    }
//    public void init()
//    {
//        setLayout(new GridLayout(0,2));
//        items=new Vector<MyItem>();
//        MyItem myItem=new MyItem("记录id");
//        addMyItem(myItem);
//        myItem=new MyItem("仓库");
//        addMyItem(myItem);
//        myItem=new MyItem("货号");
//        addMyItem(myItem);
//        myItem=new MyItem("数量");
//        addMyItem(myItem);
//        myItem=new MyItem("单价");
//        addMyItem(myItem);
//    }
//    public void addMyItem(MyItem item) {
//
//        add(item.label);
//        add(item.field);
//        items.add(item);
//    }
//    public int getItemCount() {
//        return items.size();
//    }
//
//    public JTextField getTextField(int id) {
//        return items.get(id).field;
//    }
//}