package com.chentx.attempts.onlineexamples.ex06;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/16 11:00
 * @since JDK17
 */

public class MenuTree {
    private List<Menu> menuList = new ArrayList<Menu>();
    public MenuTree(List<Menu> menuList) {
        this.menuList=menuList;
    }

    // 建立树形结构
    public List<Menu> buildTree(){
        List<Menu> treeMenus =new  ArrayList<Menu>();
        for(Menu menuNode : getRootNode()) {
            menuNode=buildChildTree(menuNode);
            treeMenus.add(menuNode);
        }
        return treeMenus;
    }

    //递归，建立子树形结构
    private Menu buildChildTree(Menu pNode){
        List<Menu> chilMenus =new  ArrayList<Menu>();
        for(Menu menuNode : menuList) {
            if(menuNode.getParentId().equals(pNode.getId())) {
                chilMenus.add(buildChildTree(menuNode));
            }
        }
        pNode.setChildren(chilMenus);
        return pNode;
    }

    // 获取根节点
    private List<Menu> getRootNode() {
        List<Menu> rootMenuLists =new  ArrayList<Menu>();
        for(Menu menuNode : menuList) {
            if(menuNode.getParentId().equals("0")) {
                rootMenuLists.add(menuNode);
            }
        }
        return rootMenuLists;
    }
}