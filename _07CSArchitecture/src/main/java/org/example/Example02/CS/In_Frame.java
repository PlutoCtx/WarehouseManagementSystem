package org.example.Example02.CS;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class In_Frame extends JFrame{
    public JPanel contentPane;
    public EditPanel left;
    public ResultPanel right;
    public ButtonPanel bottom;

    public In_Frame() {
        setVisible(true);
        setBounds(100, 100, 1100, 900);
        contentPane=new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gLayout = new GridBagLayout();
        gLayout.columnWidths = new int[]{0, 0, 0};
        gLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        gLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        gLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        contentPane.setLayout(gLayout);

        addEditPanel();
        addResultPanel(left);
        addBottomPanel(left);
    }
    public void addEditPanel() {
        left=new EditPanel();
        GridBagConstraints gbc_left = new GridBagConstraints();
        gbc_left.gridheight=6;
        gbc_left.insets=new Insets(0, 0, 5, 5);
        gbc_left.fill = GridBagConstraints.BOTH;
        gbc_left.gridx = 0;
        gbc_left.gridy = 0;
        contentPane.add(left, gbc_left);
    }

    public void addResultPanel(EditPanel editPanel) {
        right=new ResultPanel(editPanel);
        GridBagConstraints gbc_right = new GridBagConstraints();
        gbc_right.gridheight=6;
        gbc_right.insets=new Insets(0, 0, 5, 0);
        gbc_right.fill = GridBagConstraints.BOTH;
        gbc_right.gridx = 1;
        gbc_right.gridy = 0;
        contentPane.add(right, gbc_right);
    }
    public void addBottomPanel(EditPanel editPanel) {
        bottom=new ButtonPanel(editPanel);
        GridBagConstraints gbc_bottom = new GridBagConstraints();
        gbc_bottom.gridwidth = 2;
        gbc_bottom.fill = GridBagConstraints.BOTH;
        gbc_bottom.gridx = 0;
        gbc_bottom.gridy = 6;
        contentPane.add(bottom, gbc_bottom);
    }
}
