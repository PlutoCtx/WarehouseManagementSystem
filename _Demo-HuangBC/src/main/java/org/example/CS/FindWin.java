package org.example.CS;

import javax.swing.*;

public class FindWin extends In_Frame implements MenuItemFuction{
    @Override
    public void execute(JMenuItem src) {

        setTitle(src.getText());
        setLocation(100,100);
        setSize(1000,800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        String[] in = new String[6];
        in[0] = "id";
        in[1] = "仓库名";
        in[2] = "材料编号";
        in[3] = "数量";
        in[4] = "单价";
        in[5] = "总价";
        left.init(in);
        bottom.init("depository");
        bottom.addButton("find");

        right.init("depository");
    }
}
