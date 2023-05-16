package org.example.csui.example;

import javax.swing.*;
import java.awt.*;

/**
 * WarehouseManagementSystem
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/5/15 17:11
 * @since JDK17
 */


public class CardTemplateFrame extends JInternalFrame {//JInternalFrame
    CardPanel cardpanel;    //卡片输入面板部分
    ButtonGroupPanel buttonspanel; //数据导航条面板
    PagePanel tabpanel;  //多页面板

    public CardTemplateFrame(){
        super();
        tabpanel=new PagePanel();
        cardpanel=new CardPanel();
        buttonspanel=new ButtonGroupPanel();
        add(buttonspanel, BorderLayout.SOUTH);
        add(cardpanel, BorderLayout.WEST);
        add(tabpanel, BorderLayout.CENTER);
        maximizable = true;
        resizable=true;
        closable = true;
        setVisible(true);
        validate();
    }
    public CardTemplateFrame(int type){
        super();
        tabpanel=new PagePanel(type);
        cardpanel=new CardPanel();
        buttonspanel=new ButtonGroupPanel();
        add(buttonspanel, BorderLayout.SOUTH);
        add(cardpanel, BorderLayout.WEST);
        add(tabpanel, BorderLayout.CENTER);
        maximizable = true;
        resizable=true;
        closable = true;
        setVisible(true);
        validate();
    }
    public CardTemplateFrame(String title){
        super(title);
    }
}