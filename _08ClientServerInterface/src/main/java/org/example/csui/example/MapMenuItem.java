package org.example.csui.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

/**
 * WarehouseManagementSystem
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/5/15 17:12
 * @since JDK17
 */

class MapMenuItem extends JMenuItem implements ActionListener {
    String buttonFunctionClassName;
    MapMenuItem(String buttonFunctionClassName) {
        super();
        addActionListener(this);
        this.buttonFunctionClassName=buttonFunctionClassName;
    }

    MapMenuItem(String text, Icon icon,String buttonFunctionClassName) {
        super(text,icon);
        addActionListener(this);
        this.buttonFunctionClassName=buttonFunctionClassName;
    }
    MapMenuItem(String text,String buttonFunctionClassName) {
        super(text);
        addActionListener(this);
        this.buttonFunctionClassName=buttonFunctionClassName;
    }

    MapMenuItem(Icon icon,String buttonFunctionClassName) {
        super(icon);
        addActionListener(this);
        this.buttonFunctionClassName=buttonFunctionClassName;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        InterfaceForm curForm;
        try{
            Class cs=Class.forName(buttonFunctionClassName);
            curForm=(InterfaceForm)cs.newInstance();
            curForm.ExecuteForm(this);
        } catch(Exception e){
            Logger.getGlobal().info("类:("+buttonFunctionClassName+")不存在！");
        }
    }
}

