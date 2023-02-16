package com.chentx.attempts.onlineexamples.ex03;
//
//import java.util.List;
//
//import javax.swing.JScrollPane;
//import javax.swing.JTree;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//
///**
// * 主面板
// *
// * @author MaxBrooks chentingxian195467@163.com
// * @version 2023/2/16 8:22
// * @since JDK17
// */
//
//@SuppressWarnings({"serial","unchecked"})
//public class TestPane extends JScrollPane{
//    private static final Log log = LogFactory.getLog(TestPane.class);
//    private static TestPane instance;//实例变量
//    public JTree myTree;//面板中的树
//    JTreeNode rootNode ;//自定义根节点
//    public TestPane(){
//        instance = this;
//        init();
//    }
//
//    private void init() {
//        log.info("开始初始化主面板......");
//        setAutoscrolls(true);
//        getViewport().removeAll();
//        rootNode = new JTreeNode("中国");
//        JTreeNode secondTreeNode = null;//第二层节点
//        JTreeNode leafTreeNode = null;//叶子节点
//        List provinceList = DataTestDao.getProvinceList();//省份的集合
//        String provinceId = null;
//        /**如果省份和城市的集合不为空，并且元素个数大于0**/
//        if (provinceList != null && provinceList.size() > 0) {
//            for (int i = 0; i < provinceList.size(); i++) {
//                secondTreeNode = (JTreeNode) provinceList.get(i);//获取二层节点
//                provinceId = secondTreeNode.getId();//获取省份ID
//                List<JTreeNode> cityList = DataTestDao.getCityListByProID(provinceId);//根据省份ID查询城市
//                if(cityList != null && cityList.size() > 0){
//                    for(int j = 0;j < cityList.size();j ++){
//                        leafTreeNode = cityList.get(j);//获取叶子节点，即城市
//                        secondTreeNode.add(leafTreeNode);//将叶子节点挂到第二层节点上
//                    }
//                }
//                rootNode.add(secondTreeNode);//把第2层节点，添加到根节点
//            }
//        }
//
//        myTree = new JTree(rootNode);//以rootNode为根节点，创建一个树形结构
//        myTree.putClientProperty("JTree.lineStyle", "Horizontal");//树形结构的线条风格
//        myTree.setVisible(true);
//        myTree.updateUI();
//        instance.setViewportView(myTree);
//        /**注册事件**/
//        MyTreeAdapter treeAdapter = new MyTreeAdapter();
//        myTree.addTreeSelectionListener(treeAdapter);
//    }
//    public static TestPane getInstance() {
//        return instance;
//    }
//}