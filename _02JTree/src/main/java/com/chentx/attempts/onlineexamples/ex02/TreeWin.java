package com.chentx.attempts.onlineexamples.ex02;

/**
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/16 0:54
 * @since JDK17
 */


import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import javax.swing.event.*;

public class TreeWin extends JFrame implements TreeSelectionListener{
    JTree tree;
    JTextArea showText;
    TreeWin(){
        DefaultMutableTreeNode root=new DefaultMutableTreeNode("图书馆");
        //根节点
        DefaultMutableTreeNode yishu=new DefaultMutableTreeNode("艺术类");  //节点
        DefaultMutableTreeNode yishu_sheying=new DefaultMutableTreeNode("摄影");
        DefaultMutableTreeNode yishu_yinyue=new DefaultMutableTreeNode("音乐");

        DefaultMutableTreeNode shuli=new DefaultMutableTreeNode("数理类");
        DefaultMutableTreeNode shuli_shuxue=new DefaultMutableTreeNode("数学");//节点
        DefaultMutableTreeNode shui_ligong=new DefaultMutableTreeNode("理工");

        DefaultMutableTreeNode yuyan=new DefaultMutableTreeNode("语言类");
        DefaultMutableTreeNode yuyan_hanyu=new DefaultMutableTreeNode("汉语");
        DefaultMutableTreeNode yuyan_yingyu=new DefaultMutableTreeNode("英语");

        DefaultMutableTreeNode jisuanji=new DefaultMutableTreeNode("计算机类");
        DefaultMutableTreeNode jisuanji_zidonghua=new DefaultMutableTreeNode("自动化");
        DefaultMutableTreeNode jisuanji_jisuanji=new DefaultMutableTreeNode("计算机");
        DefaultMutableTreeNode sheying1=
                new DefaultMutableTreeNode(new Book("美国纽约摄影学院-摄影教材","中国摄影出版社"));              //节点
        DefaultMutableTreeNode sheying2=
                new DefaultMutableTreeNode(new Book("摄影的艺术","人民邮电出版社"));              //节点
        DefaultMutableTreeNode yinyue1=
                new DefaultMutableTreeNode(new Book("表演练声课：释放天然噪音","文化发展出版社"));            //节点
        DefaultMutableTreeNode yinyue2=
                new DefaultMutableTreeNode(new Book("京剧原来如此美丽","中信出版社"));  //节点
        DefaultMutableTreeNode shuxue1=
                new DefaultMutableTreeNode(new Book("数学分析","北京大学出版社"));
        DefaultMutableTreeNode shuxue2=
                new DefaultMutableTreeNode(new Book("高等数学","北京大学出版社"));
        DefaultMutableTreeNode ligong1=
                new DefaultMutableTreeNode(new Book("机械工程","暨南大学出版社"));
        DefaultMutableTreeNode ligong2=
                new DefaultMutableTreeNode(new Book("电学","中山大学出版社"));
        DefaultMutableTreeNode hanyu1=
                new DefaultMutableTreeNode(new Book("大学语文","中文出版社"));
        DefaultMutableTreeNode hanyu2=
                new DefaultMutableTreeNode(new Book("唐诗三百首","中文出版社"));
        DefaultMutableTreeNode yingyu1=
                new DefaultMutableTreeNode(new Book("大学英语","外语出版社"));
        DefaultMutableTreeNode yingyu2=
                new DefaultMutableTreeNode(new Book("听说教程","外研出版社"));
        DefaultMutableTreeNode zidonghua1=
                new DefaultMutableTreeNode(new Book("自动化","工业大学出版社"));
        DefaultMutableTreeNode zidonghua2=
                new DefaultMutableTreeNode(new Book("操作系统","工业出版社"));
        DefaultMutableTreeNode jisuanji1=
                new DefaultMutableTreeNode(new Book("计算机应用","电子出版社"));
        DefaultMutableTreeNode jisuanji2=
                new DefaultMutableTreeNode(new Book("电脑系统","信息出版社"));
        root.add(yishu);//确定节点之间的关系
        yishu.add(yishu_sheying);
        yishu.add(yishu_yinyue);
        yishu_sheying.add(sheying1);                                        //确定节点之间的关系
        yishu_sheying.add(sheying2);
        yishu_yinyue.add(yinyue1);
        yishu_yinyue.add(yinyue2);

        root.add(shuli);
        shuli.add(shuli_shuxue);
        shuli.add(shui_ligong);
        shuli_shuxue.add(shuxue1);
        shuli_shuxue.add(shuxue2);
        shui_ligong.add(ligong1);
        shui_ligong.add(ligong2);

        root.add(yuyan);
        yuyan.add(yuyan_hanyu);
        yuyan.add(yuyan_yingyu);
        yuyan_hanyu.add(hanyu1);
        yuyan_hanyu.add(hanyu2);
        yuyan_yingyu.add(yingyu1);
        yuyan_yingyu.add(yingyu2);

        root.add(jisuanji);
        jisuanji.add(jisuanji_zidonghua);
        jisuanji.add(jisuanji_jisuanji);
        jisuanji_zidonghua.add(zidonghua1);
        jisuanji_zidonghua.add(zidonghua2);
        jisuanji_jisuanji.add(jisuanji1);
        jisuanji_jisuanji.add(jisuanji2);

        tree=new JTree(root);                                   // 用root做根的树组件
        tree.addTreeSelectionListener(this);                    // 监视树组件上的事件
        showText=new JTextArea();
        setLayout(new GridLayout(1,2));
        add(new JScrollPane(tree));
        add(new JScrollPane(showText));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(80,80,300,300);
        validate();
    }
    @Override
    public void valueChanged(TreeSelectionEvent e){
        DefaultMutableTreeNode node=
                (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
        if(node.isLeaf()){
            Book s=(Book)node.getUserObject();                // 得到节点中存放的对象
            showText.append(s.name+","+s.publishingHouse+"\n");
        }
        else{
            showText.setText(null);
        }
    }
}


