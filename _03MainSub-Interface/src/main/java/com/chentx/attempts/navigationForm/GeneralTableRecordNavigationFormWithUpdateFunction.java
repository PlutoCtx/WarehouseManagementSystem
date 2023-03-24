package com.chentx.attempts.navigationForm;

import javax.swing.*;

/**
 * 带有更新功能的表记录 导航窗体
 *
 * @author Max chenmochen1954@163.com
 * since jdk17
 * @version 2023/2/17 11:14
 */
public class GeneralTableRecordNavigationFormWithUpdateFunction {

    /**
     * @param args args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DemoWindow19 dw = new DemoWindow19("带有更新功能的表记录 导航窗体");
        dw.pack();
        dw.setBounds(
                dw.getToolkit().getScreenSize().width / 2 - dw.getWidth() / 2,
                dw.getToolkit().getScreenSize().height / 2 - dw.getHeight() / 2,
                dw.getWidth(), dw.getHeight());
        dw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dw.setVisible(true);
    }

}


