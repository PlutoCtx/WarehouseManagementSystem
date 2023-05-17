package org.example.CS;

import javax.swing.*;

/**
 * @author chent
 */
public class User_Manger extends In_Frame implements MenuItemFuction{
    @Override
    public void execute(JMenuItem src) {
        setTitle(src.getText());
        setLocation(100,100);
        setSize(500,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
