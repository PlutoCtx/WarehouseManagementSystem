package com.chentx.attempts.onlineexamples.ex05;
//
//import com.google.gson.Gson;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import com.google.common.collect.Lists;
//import apple.laf.JRSUIUtils;
//
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
///**
// * @author MaxBrooks chentingxian195467@163.com
// * @version 2023/2/16 10:44
// * @since JDK17
// */
//
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//public class TreeVo {
//
//    private int id;
//    private String name;
//    private int parent;
//    private List<TreeVo> children;
//
//    public static List<TreeVo> allTreeVoList(){
//
//        List<TreeVo> list = Lists.newArrayList();
//        TreeVo hebeiTreeVo = TreeVo.builder().id(1).name("河北").parent(0).children(Lists.newArrayList()).build();
//        list.add(hebeiTreeVo);
//        TreeVo hanTreeVo = TreeVo.builder().id(1).name("han").parent(0).children(Lists.newArrayList()).build();
//        list.add(hanTreeVo);
//        TreeVo weiTreeVo = TreeVo.builder().id(1).name("wei").parent(0).children(Lists.newArrayList()).build();
//        list.add(weiTreeVo);
//        TreeVo beiTreeVo = TreeVo.builder().id(1).name("bei").parent(0).children(Lists.newArrayList()).build();
//        list.add(beiTreeVo);
//        TreeVo jinTreeVo = TreeVo.builder().id(1).name("jin").parent(0).children(Lists.newArrayList()).build();
//        list.add(jinTreeVo);
//        TreeVo chaoTreeVo = TreeVo.builder().id(1).name("chao").parent(0).children(Lists.newArrayList()).build();
//        list.add(chaoTreeVo);
//        return list;
//    }
//
//
//    /**
//     * 组装树
//     */
//    public void wrapperTreeTest() {
//        Gson gson = new Gson();
//        List<TreeVo> list = TreeVo.allTreeVoList();
//        logger.info("结果是:{}", gson.toJson(list));
//        Map<Integer, TreeVo> treeVoMap = list.stream().collect(Collectors.toMap(i -> i.getId(), i -> i));
//        //获取顶级树节点
//        List<TreeVo> rootList = list.stream().filter(i -> !treeVoMap.containsKey(i.getParent())).collect(toList());
//        logger.info("rootList is:{}", gson.toJson(rootList));
//        for (TreeVo treeVo : list) {
//            if (treeVoMap.containsKey(treeVo.getParent())) {
//                TreeVo parentTree = treeVoMap.get(treeVo.getParent());
//                List<TreeVo> children = parentTree.getChildren();
//                children.add(treeVo);
//            }
//        }
//        logger.info("最后树结构是:{}", gson.toJson(rootList));
//    }
//
//
//}
