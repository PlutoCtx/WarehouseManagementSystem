package com.bookmanager.view;

import com.bookmanager.mapper.MenuItemFunction;

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


    /**
     * 内部窗体
     */
    public InBoundFrame() {
        getContentPane().setBackground(Color.RED);
        setIconifiable(true);
        setClosable(true);
        setTitle("\u5173\u4E8EJava1234");
        setBounds(100, 100, 450, 300);
        setMaximizable(true);

        JLabel lblNewLabel = new JLabel("haha");
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(98)
                                .addComponent(lblNewLabel)
                                .addContainerGap(126, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(48)
                                .addComponent(lblNewLabel)
                                .addContainerGap(149, Short.MAX_VALUE))
        );
        getContentPane().setLayout(groupLayout);
    }

    @Override
    public void execute(JMenuItem src) {
//        Frame frame = new Frame();
//        frame.setVisible(true);
//        frame.setBounds(100, 100, 100, 100);
    }
}
