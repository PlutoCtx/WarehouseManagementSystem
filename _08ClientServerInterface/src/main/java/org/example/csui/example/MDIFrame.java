package org.example.csui.example;

import javax.swing.*;
import java.awt.*;

/**
 * WarehouseManagementSystem
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/5/15 17:13
 * @since JDK17
 */

public class MDIFrame extends JFrame {
    private static JDesktopPane desktopPane;
    Container contentPane;
    JMenuBar menubar;
    JMenu menu;
    JMenu subMenu;

    MapMenuItem itemLiterature;
    MapMenuItem itemCooking;

    public MDIFrame(){
        this("");
    }
    public MDIFrame(String s) {

        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());

        init(s);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        desktopPane = new JDesktopPane();
        contentPane.add(desktopPane, BorderLayout.CENTER);
    }

    void init(String s){
        menubar=new JMenuBar();
        menu=new JMenu("菜单");
        subMenu=new JMenu("体育话题");
        itemLiterature=new MapMenuItem("文学话题",new ImageIcon("a.gif"),"LiteratureForm");
        itemCooking=new MapMenuItem("烹饪话题",new ImageIcon("b.gif"),"CookingForm");
        menu.add(itemLiterature);
        menu.addSeparator();   //在菜单之间增加分隔线
        menu.add(itemCooking);
        menu.add(subMenu);
        subMenu.add(new MapMenuItem("足球",new ImageIcon("c.gif"),"FootballForm"));
        subMenu.add(new MapMenuItem("篮球",new ImageIcon("d.gif"),"BasketballForm"));
        menubar.add(menu);
        setJMenuBar(menubar);
    }

    public static JDesktopPane getDesktopPane() {
        return desktopPane;
    }

}