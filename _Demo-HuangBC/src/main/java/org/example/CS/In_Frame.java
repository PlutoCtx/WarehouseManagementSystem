package org.example.CS;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author chent
 */
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
        GridBagConstraints gbcLeft = new GridBagConstraints();
        gbcLeft.gridheight=6;
        gbcLeft.insets=new Insets(0, 0, 5, 5);
        gbcLeft.fill = GridBagConstraints.BOTH;
        gbcLeft.gridx = 0;
        gbcLeft.gridy = 0;
        contentPane.add(left, gbcLeft);
    }

    public void addResultPanel(EditPanel editPanel) {
        right=new ResultPanel(editPanel);
        GridBagConstraints gbcRight = new GridBagConstraints();
        gbcRight.gridheight=6;
        gbcRight.insets=new Insets(0, 0, 5, 0);
        gbcRight.fill = GridBagConstraints.BOTH;
        gbcRight.gridx = 1;
        gbcRight.gridy = 0;
        contentPane.add(right, gbcRight);
    }
    public void addBottomPanel(EditPanel editPanel) {
        bottom=new ButtonPanel(editPanel);
        GridBagConstraints gbcBottom = new GridBagConstraints();
        gbcBottom.gridwidth = 2;
        gbcBottom.fill = GridBagConstraints.BOTH;
        gbcBottom.gridx = 0;
        gbcBottom.gridy = 6;
        contentPane.add(bottom, gbcBottom);
    }
}
