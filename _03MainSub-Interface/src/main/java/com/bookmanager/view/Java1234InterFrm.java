package com.bookmanager.view;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.*;

/**
 * 内部窗体
 *
 * @author Max chenmochen1954@163.com
 * since jdk17
 * @version 2022/12/21 10:08
 */

public class Java1234InterFrm extends JInternalFrame {

//    /**
//     * Launch the application.
//     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Java1234InterFrm frame = new Java1234InterFrm();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    /**
     * 内部窗体
     */
    public Java1234InterFrm() {
        getContentPane().setBackground(Color.RED);
        setIconifiable(true);
        setClosable(true);
        setTitle("\u5173\u4E8EJava1234");
        setBounds(100, 100, 450, 300);

        JLabel lblNewLabel = new JLabel("");
//        lblNewLabel.setIcon(new ImageIcon(Java1234InterFrm.class.getResource("/images/java1234.png")));
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(98)
                                .addComponent(lblNewLabel)
                                .addContainerGap(126, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(48)
                                .addComponent(lblNewLabel)
                                .addContainerGap(149, Short.MAX_VALUE))
        );
        getContentPane().setLayout(groupLayout);
    }
}