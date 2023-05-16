package com.chentx.warehouse.view.operation;


import com.chentx.warehouse.mapper.MenuItemFunction;

import javax.swing.*;
import java.awt.*;

/**
 * WarehouseManagementSystem
 * 入库操作界面
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/4/24 19:14
 * @since JDK17
 */

public class InBoundFrame extends JInternalFrame implements MenuItemFunction {

    @Override
    public void execute(JMenuItem src) {
        Frame frame = new Frame();
        frame.setVisible(true);
        frame.setBounds(100, 100, 100, 100);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }
}
