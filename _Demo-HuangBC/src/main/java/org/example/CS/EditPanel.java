package org.example.CS;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Vector;

public class EditPanel extends JPanel {
    Vector<MyItem> items;
    public EditPanel() {
        setBorder(new TitledBorder(null,"编辑栏",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("宋体",0,20),Color.BLACK));
    }
    public void init(String[] in) {
        setLayout(new GridLayout(0,2));
        items=new Vector<MyItem>();
        for(int i=0;i<in.length;i++) {
            MyItem myItem=new MyItem(in[i]);
            addMyItem(myItem);
        }
    }
    public void addMyItem(MyItem item) {
        add(item.label);
        add(item.field);
        items.add(item);
    }

    public int getItemCount() {
        return items.size();
    }

    public JTextField getTextField(int id) {
        return items.get(id).field;
    }
}
