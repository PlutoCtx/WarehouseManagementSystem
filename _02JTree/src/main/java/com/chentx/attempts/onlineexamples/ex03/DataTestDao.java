package com.chentx.attempts.onlineexamples.ex03;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 用户模拟数据的DAO
// *
// * @author MaxBrooks chentingxian195467@163.com
// * @version 2023/2/16 8:30
// * @since JDK17
// */
//@SuppressWarnings("unchecked")
//public class DataTestDao {
//
//    public static List getProvinceList() {
//        List<String> provinces = new ArrayList<String>();
//        provinces.add("北京市");
//        provinces.add("天津市");
//        provinces.add("上海市");
//        provinces.add("重庆市");
//        provinces.add("山东省");
//        provinces.add("江苏省");
//        provinces.add("浙江省");
//        provinces.add("广东省");
//
//        List<JTreeNode> returnList = new ArrayList<JTreeNode>();
//        JTreeNode treeNode = null;
//        for(int i=0;i < provinces.size();i++){
//            treeNode = new JTreeNode(provinces.get(i));
//            treeNode.setId(i+"");
//            returnList.add(treeNode);
//        }
//        return returnList;
//    }
//
//    public static List<JTreeNode> getCityListByProID(String provinceId) {
//        List<City> citys = new ArrayList<City>();
//        List<JTreeNode> returnList = new ArrayList<JTreeNode>();
//        JTreeNode treeNode = null;
//        if(provinceId.equals("0")){
//            //北京市
//            citys.add(new City(provinceId,"海淀区"));
//            citys.add(new City(provinceId,"东城区"));
//            citys.add(new City(provinceId,"西城区"));
//        }else if(provinceId.equals("1")){
//            //天津市
//            citys.add(new City(provinceId,"河东区"));
//            citys.add(new City(provinceId,"河西区"));
//            citys.add(new City(provinceId,"塘沽区"));
//        }else if(provinceId.equals("2")){
//            //上海市
//            citys.add(new City(provinceId,"浦东新区"));
//            citys.add(new City(provinceId,"黄浦区"));
//            citys.add(new City(provinceId,"宝山区"));
//        }else if(provinceId.equals("3")){
//            //重庆市
//            citys.add(new City(provinceId,"渝北区"));
//            citys.add(new City(provinceId,"巫山县"));
//            citys.add(new City(provinceId,"涪陵区"));
//        }else if(provinceId.equals("4")){
//            //山东省
//            citys.add(new City(provinceId,"济南市"));
//            citys.add(new City(provinceId,"青岛市"));
//            citys.add(new City(provinceId,"烟台市"));
//            citys.add(new City(provinceId,"潍坊市"));
//            citys.add(new City(provinceId,"日照市"));
//            citys.add(new City(provinceId,"聊城市"));
//        }else if(provinceId.equals("5")){
//            //江苏省
//            citys.add(new City(provinceId,"南京市"));
//            citys.add(new City(provinceId,"徐州市"));
//            citys.add(new City(provinceId,"苏州市"));
//            citys.add(new City(provinceId,"无锡市"));
//            citys.add(new City(provinceId,"镇江市"));
//            citys.add(new City(provinceId,"扬州市"));
//        }else if(provinceId.equals("6")){
//            //浙江省
//            citys.add(new City(provinceId,"杭州市"));
//            citys.add(new City(provinceId,"温州市"));
//            citys.add(new City(provinceId,"宁波市"));
//            citys.add(new City(provinceId,"绍兴市"));
//            citys.add(new City(provinceId,"金华市"));
//            citys.add(new City(provinceId,"衢州市"));
//        }else if(provinceId.equals("7")){
//            //广东省
//            citys.add(new City(provinceId,"广州市"));
//            citys.add(new City(provinceId,"深圳市"));
//            citys.add(new City(provinceId,"珠海市"));
//            citys.add(new City(provinceId,"东莞市"));
//            citys.add(new City(provinceId,"惠州市"));
//            citys.add(new City(provinceId,"肇庆市"));
//        }else{
//
//        }
//        for(int i=0;i < citys.size();i++){
//            treeNode = new JTreeNode(citys.get(i).getName());
//            treeNode.setId(i+"");
//            returnList.add(treeNode);
//        }
//        return returnList;
//    }
//
//}