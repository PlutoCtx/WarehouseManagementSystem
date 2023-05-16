package org.example.operation;

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

public class InBoundFrame extends JInternalFrame {

    /**
     * 内部窗体
     */
    public InBoundFrame() {
        getContentPane().setBackground(Color.RED);
        setIconifiable(true);
        setClosable(true);
        setTitle("Java1234");
        setBounds(100, 100, 450, 300);
        setMaximizable(true);

        JLabel lblNewLabel = new JLabel("haha");
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


//    @Override
//    public void execute(JMenuItem src) {
//        // 设置JFrame最大化
//        this.setVisible(true);
////        this.setBounds(Frame.MAXIMIZED_BOTH);
////        this.setExtendedState(Frame.MAXIMIZED_BOTH);
//    }
}