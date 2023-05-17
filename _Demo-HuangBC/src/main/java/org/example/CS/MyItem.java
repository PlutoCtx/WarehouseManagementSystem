package org.example.CS;

import javax.swing.*;

/**
 * @author chent
 */
public class MyItem {
    public JLabel label;
    public JTextField field;

    public MyItem(String name) {
        label = new JLabel(name);
        field = new JTextField();
    }

    public void setEditable(boolean editable) {
        field.setEditable(editable);
    }
}
