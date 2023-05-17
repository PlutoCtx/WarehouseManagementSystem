package org.example.CS;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.logging.Logger;

/**
 * @author chent
 */
public class MapMenu extends JMenuItem implements ActionListener {
    String winClassName;

    public MapMenu(String text, String winClassName) {
        super(text);
        addActionListener(this);
        this.winClassName = winClassName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MenuItemFuction menuItemFuction;
        try {
            Class cs = Class.forName("org.example.CS." + winClassName);
            menuItemFuction = (MenuItemFuction) cs.newInstance();
            menuItemFuction.execute(this);
        } catch (Exception e2) {
            Logger.getGlobal().info("窗口:(" + winClassName + ")没定义!");
            e2.printStackTrace();
        }
    }
}