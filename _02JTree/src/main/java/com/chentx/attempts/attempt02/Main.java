package com.chentx.attempts.attempt02;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.List;

/**
 *
 * 还有问题，不算完成
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



/*

    public int  setJMenuItem(String nameString, String idstString, String fathetidString, JMenu jmenu) throws SQLException{
        int Cycle_Index = 0;
        boolean isSetSeparator = false;
        boolean ifHeadhasItem = false;

        if (fathetidString.equals("0000"))
            jmenbTopBar.add(jmenu);
        while (result.next()){
            Cycle_Index++;

            String id = result.getString("Menu_Id");
            String Name = result.getString("Menu_Name");
            className = result.getString("Class_Name");
            String fatherIdString = result.getString("Father_Id");
            int type = result.getInt("Menu_Type");

            if (fatherIdString.equals(idstString)){
                if (0 == type){
                    if(ifHeadhasItem && isSetSeparator){
                        jmenu.addSeparator();
                        isSetSeparator = false;
                    }
                    if (arrayListDo.contains(id)){
                        JMenu  tempjmenu = new JMenu(Name);
                        //递归调用
                        int count = setJMenuItem(Name, id,  fatherIdString, tempjmenu);
                        jmenu.add(tempjmenu);
                        //将 result的游标往回指
                        result.absolute(-count);
                    }
                }
                else {
                    if(Name.equals("-"))
                        isSetSeparator = true;
                    else{	//添加分隔线，因为根据不同用户的权限不同，出现多根分隔线时只能添加一条，这里保证了
                        //既不多添加，也不少添加
                        if(ifHeadhasItem && isSetSeparator) {
                            jmenu.addSeparator();
                            isSetSeparator = false;
                            ifHeadhasItem = false;
                        }

                        if (arrayListDo.contains(id)) {
                            //建立菜单项
                            final JMenuItem tempJMenuItem = new JMenuItem(Name);
                            tempJMenuItem.setName(className);
                            jmenu.add(tempJMenuItem);
                            ifHeadhasItem = true;
                            //判断是否可用
                            if (arrayListIsCanUse.contains(id))
                                tempJMenuItem.setEnabled(false);
                            tempJMenuItem.addActionListener (
                                            new ActionListener(){
									 <span style="white-space:pre">	</span>public void actionPerformed(ActionEvent arg0){
										<span style="white-space:pre">	</span>String ItemName = tempJMenuItem.getName();
                                                try {
                                                    if (!(arrayListWindowCanSee.contains(ItemName)))
                                                    {//计算器和万年历窗口要依附在我的主窗口中，两个是特殊处理
                                                        if (!ItemName.equals("MECCalender") && !ItemName.equals("Calculator"))												    {																<span style="white-space:pre">				</span> <span style="white-space:pre">		</span>creatNewWindow(ItemName, userId, userName);
                                                            arrayListWindowCanSee.add(ItemName);
                                                            DealAction(tempJMenuItem);
                                                        }
                                                        else
                                                            creatSpecliWindow(ItemName, userId, userName);
                                                    }
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                            }
                                    );
                        }
                    }
                }
            }
        }
        return Cycle_Index + 1;
    }

*/
