package org.example.csui.example;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * WarehouseManagementSystem
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/5/15 17:10
 * @since JDK17
 */

public class CardPanel extends JPanel {
    private Box leftbox;
    private Box rightbox;
    private Box rowbox;
    public CardPanel(){
        super();
        setPreferredSize(new Dimension(400, 0));//此方法设置大小才有效
        Border lineBorder = new LineBorder(Color.DARK_GRAY, 2);
        setBorder(lineBorder);
        leftbox=Box.createVerticalBox();
        rightbox=Box.createVerticalBox();
        rowbox=Box.createHorizontalBox();
        rowbox.add(leftbox);
        rowbox.add(Box.createHorizontalStrut(8));
        rowbox.add(rightbox);
        add(rowbox);
    }

    public void addTitle(String title){//加字段的标签
    }

    public void addEditComponent(){//加编辑的组件，参数考虑：字段，数据类型，是否可编辑
    }

}
