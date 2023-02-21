package com.chentx.tables.module04;

import javax.swing.*;
import java.awt.*;

/**
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/21 17:57
 * @since JDK17
 */

public class JFrameTest extends JInternalFrame{


    /**
     * 内部窗体
     */
    public JFrameTest() {
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
}
