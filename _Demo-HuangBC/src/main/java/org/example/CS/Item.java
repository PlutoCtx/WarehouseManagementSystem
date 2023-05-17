package org.example.CS;

import javax.swing.*;

/**
 * @author chent
 */
public class Item {
    public JLabel label;
    public JTextField field;

    public Item(String name) {
        label = new JLabel(name);
        field = new JTextField();
    }

    public void setEditable(boolean editable) {
        field.setEditable(editable);
    }
}
