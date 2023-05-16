package org.example.csui.example.views;

import org.example.csui.example.CardTemplateFrame;
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

public class LiteratureForm extends CardTemplateFrame implements InterfaceForm {
    public LiteratureForm(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    @Override
    public  void ExecuteForm(JMenuItem src) {
        closable = true;
        try {
            MDIFrame.getDesktopPane().add(this);
            setMaximum(true);
            repaint();
            setVisible(true);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
