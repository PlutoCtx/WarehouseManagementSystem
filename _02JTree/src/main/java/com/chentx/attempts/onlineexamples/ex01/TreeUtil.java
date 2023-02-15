package com.chentx.attempts.onlineexamples.ex01;

/**
 * 树生成类
 *
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/16 0:51
 * @since JDK17
 */

import com.alibaba.fastjson.JSONObject;

import java.util.*;
import java.util.stream.Collectors;

public class TreeUtil {
    public static void main(String[] args) {
        createData();
        // dataList.forEach(e-> System.out.println(e.toString()));
        System.out.println(JSONObject.toJSONString(getTreeByColl(dataList)));
    }
    //保存数据
    public static List<Menu> dataList=new ArrayList();
    //创建数据
    public static  void  createData(){
        dataList.add(new Menu.Builder().id(0).menuName("根节点").parId(-2).type(0).url("").build());
        for (int i = 1; i <50 ; i++) {
            if (i<11) {
                dataList.add(new Menu.Builder().id(i).menuName("1级节点"+i).parId(0).type(0).url("").build());
            }else {
                dataList.add(new Menu.Builder().id(i).menuName(((i/10)+1)+"级节点"+i).parId(i-10).type(0).url("").build());
            }
        }
    }
//System.out.println(getTreeByColl(dataList));
    /**
     * 通过集合方式生成树
     * @param list
     * @return
     */
    public static Map<String, Object> getTreeByColl(List<Menu> list) {
        Map<String, Object> resmap=new HashMap<>();
        Map<Integer, Menu> map;
        List<Menu> treelist= new ArrayList<>();

        if (null==list||list.isEmpty()){
            return null;
        }
        map = list.stream().collect(Collectors.toMap(Menu::getId, a -> a,(k1, k2)->k1));
        /*List<Map.Entry<Integer, Menu>> listMap = new ArrayList<Map.Entry<Integer, Menu>>(map.entrySet());
        Collections.sort(listMap, new Comparator<Map.Entry<Integer, Menu>>() {
            public int compare(Map.Entry<Integer, Menu> o1, Map.Entry<Integer, Menu> o2) {
                return o2.getKey().compareTo(o1.getKey());
            }
        });*/
        // 将list集合对象转换为json的字符串
        // 如果id是父级的话就放入tree中treelist
        for (Menu menu : list) {
            if (null==map.get(menu.getParId())) {
                treelist.add(menu);
            } else {
                // 子级通过父id获取到父级的类型
                Menu parent = map.get(menu.getParId());
                // 父级获得子级，再将子级放到对应的父级中
                parent.addChildren(menu);
            }
        }


        resmap.put("data",treelist);
        return resmap;
    }

}