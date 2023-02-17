package com.chentx.attempts.attempt03_suc;

import javax.swing.*;
import java.awt.*;

/**
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/16 13:40
 * @since JDK17
 */

public class SetFont {

    private void setFont(){}
    public static void setFont(Font f, JComponent...component){
        for(JComponent c:component) {
            c.setFont(f);
        }
    }
}
