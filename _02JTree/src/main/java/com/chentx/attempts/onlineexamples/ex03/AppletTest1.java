package com.chentx.attempts.onlineexamples.ex03;
//
//import javax.swing.*;
//import java.awt.*;
//
//import java.awt.Container;
//
//import javax.swing.JApplet;
//import javax.swing.SwingUtilities;
//import javax.swing.UIManager;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//
//
///**
// * 实现树形结构的Applet
// *
// * @author MaxBrooks chentingxian195467@163.com
// * @version 2023/2/16 8:23
// * @since JDK17
// */
//
//
//@SuppressWarnings("serial")
//public class AppletTest1 extends JApplet {
//    private static final Log log = LogFactory.getLog(AppletTest1.class);// 日志记录
//    private static AppletTest1 instance;
//    public static Container container;// 一个可包含其他 AWT 组件的组件。
//
//    public void init() {
//        log.info("Applet初始化......");
//        instance = this;
//        SwingUtilities.invokeLater(new Runnable() {
//
//            public void run() {
//                try {
//                    UIManager.setLookAndFeel(UIManager
//                            .getSystemLookAndFeelClassName());//设置外观感觉
//                    container = getContentPane();//获取内容面板
//                    TestPane pane = new TestPane();//初始化主面板
//                    container.add(pane);//将主面板添加到内容面板
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            }
//
//        });
//    }
//
//    public static AppletTest1 getInstance() {
//        return instance;
//    }
//
//    public void destroy() {
//        log.info("程序正在关闭.....");
//    }
//
//}