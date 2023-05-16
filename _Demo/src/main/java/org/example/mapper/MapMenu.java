package org.example.mapper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

/**
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/3/23 23:49
 * @since JDK17
 */

public class MapMenu extends JMenuItem implements ActionListener {

    String winClassName;

    public MapMenu(String text, String winClassName){
        super(text);
        addActionListener(this);
        this.winClassName = winClassName;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MenuItemFunction menuItemFunction;
        Class clazz = null;
        try {
            clazz = Class.forName("org.example.operation." + winClassName);
            menuItemFunction = (MenuItemFunction) clazz.newInstance();
            menuItemFunction.execute(this);
        }catch (Exception e2) {
            Logger.getGlobal().info("窗口:(" + winClassName + ")没定义!");
            e2.printStackTrace();
        }
    }
}
