package org.example.csui.example.views;

import org.example.csui.example.CardTemplateFrame;
import org.example.csui.example.InterfaceForm;
import org.example.csui.example.MDIFrame;

import javax.swing.*;

/**
 * WarehouseManagementSystem
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/5/15 17:10
 * @since JDK17
 */

class BasketballForm extends CardTemplateFrame implements InterfaceForm {
    public BasketballForm(){
        super(2);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public  void ExecuteForm(JMenuItem src){
        try {
            MDIFrame.getDesktopPane().add(this);
            setMaximum(true);
            repaint();
            closable =true;
            setVisible(true);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
