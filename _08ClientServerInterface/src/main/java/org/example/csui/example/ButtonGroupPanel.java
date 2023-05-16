package org.example.csui.example;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.Logger;

/**
 * WarehouseManagementSystem
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/5/15 17:10
 * @since JDK17
 */

public class ButtonGroupPanel extends JPanel{
    ResultSet rs;
    Vector<JButton> toolbts;
    public ButtonGroupPanel(){
        super();
        toolbts=new Vector();
        setPreferredSize(new Dimension(0, 60));//此方法设置大小才有效
        Border lineBorder = new LineBorder(Color.GRAY, 2);
        setBorder(lineBorder);
    }
    public void setResultSet(ResultSet rs) {
        this.rs=rs;
    }

    public void addButton(String clsname) {
        JButton bt;
        try{
            Class cs=Class.forName(clsname);
            bt = (JButton)cs.newInstance();
            toolbts.add(bt);
        } catch(Exception e){
            Logger.getGlobal().info("按钮类:("+clsname+")没定义!");
        }

    }
}
