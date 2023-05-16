package org.example.csui.example;

import javax.swing.*;

/**
 * WarehouseManagementSystem
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/5/15 17:13
 * @since JDK17
 */

public class PagePanel extends JTabbedPane {
    private JTree  goodstree;
    private JTable goodstable;

    public PagePanel(){
        super();
        JScrollPane scrolltree = new JScrollPane();
        JScrollPane scrolltable = new JScrollPane();
        goodstree=new JTree();
        goodstable=new JTable();
        goodstree.setModel(null);
        scrolltree.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrolltree.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrolltable.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrolltable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrolltree.add(goodstree);
        scrolltable.add(goodstable);
        add("目录树",scrolltree);
        add("清单",scrolltable);
    }

    public PagePanel(int type){
        super();
        if (type == 1){
            JScrollPane scrolltree = new JScrollPane();
            goodstree=new JTree();
            goodstree.setModel(null);
            scrolltree.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            scrolltree.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrolltree.add(goodstree);
            add("目录树",scrolltree);
        } else {
            JScrollPane scrolltable = new JScrollPane();
            goodstable=new JTable();
            scrolltable.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            scrolltable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrolltable.add(goodstable);
            add("清单",scrolltable);
        }
    }

    public JTree getGoodsTree(){
        return goodstree;
    }
    public JTable getGoodsTable(){
        return goodstable;
    }
}