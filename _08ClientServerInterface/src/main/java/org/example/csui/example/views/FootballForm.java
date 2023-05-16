package org.example.csui.example.views;

import org.example.csui.example.InterfaceForm;
import org.example.csui.example.MDIFrame;

import javax.swing.*;

/**
 * WarehouseManagementSystem
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/5/15 17:12
 * @since JDK17
 */

class FootballForm extends JInternalFrame implements InterfaceForm {
    public FootballForm(){
        closable =true;
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public  void ExecuteForm(JMenuItem src) {
        try {
            MDIFrame.getDesktopPane().add(this);
            setMaximum(true);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}