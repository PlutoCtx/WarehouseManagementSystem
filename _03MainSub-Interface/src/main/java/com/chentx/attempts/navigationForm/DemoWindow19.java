package com.chentx.attempts.navigationForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @author Max chenmochen1954@163.com
 * since jdk17
 * @version 2023/2/17 12:23
 */
class DemoWindow19 extends JFrame implements ActionListener {
    Transaction19 trans = new Transaction19("warehousemanagementsystem", "clggb");

    JPanel[] jps = null;
    JPanel controlPanel = new JPanel();
    JPanel operatePanel = new JPanel();

    JTextField[] jtfs = null;

    JButton jbFirst = new JButton("第一条");
    JButton jbPrevious = new JButton("上一条");
    JButton jbNext = new JButton("下一条");
    JButton jbLast = new JButton("最后一条");
    JButton jbInsert = new JButton("插入记录");
    JButton jbUpdate = new JButton("更新记录");
    JButton jbDelete = new JButton("删除记录");
    JButton jbCancel = new JButton("取消更新");

    public DemoWindow19(String title) {
        super(title);

        setLayout(new GridLayout(trans.getColumnCount() + 3, 1));

        add(new JLabel("数据库：" + trans.getDatabase() + "|表：" + trans.getTable(),
                JLabel.CENTER));

        jps = new JPanel[trans.getColumnCount()];
        jtfs = new JTextField[trans.getColumnCount()];

        for (int i = 0; i < trans.getColumnCount(); i++) {
            jps[i] = new JPanel();
            jps[i].add(new JLabel(trans.getColumnNames()[i]));
            jtfs[i] = new JTextField(20);
            jps[i].add(jtfs[i]);
            add(jps[i]);
        }
        controlPanel.add(jbFirst);
        controlPanel.add(jbPrevious);
        controlPanel.add(jbNext);
        controlPanel.add(jbLast);
        add(controlPanel);

        operatePanel.add(jbInsert);
        operatePanel.add(jbUpdate);
        operatePanel.add(jbDelete);
        operatePanel.add(jbCancel);
        add(operatePanel);

        jbFirst.addActionListener(this);
        jbPrevious.addActionListener(this);
        jbNext.addActionListener(this);
        jbLast.addActionListener(this);
        jbInsert.addActionListener(this);
        jbUpdate.addActionListener(this);
        jbDelete.addActionListener(this);
        jbCancel.addActionListener(this);

        fill(trans.getFirstRecord());
    }

    public void fill(String[] values) {
        for (int i = 0; i < trans.getColumnCount(); i++) {
            jtfs[i].setText(values[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbFirst) {
            fill(trans.getFirstRecord());
        } else if (e.getSource() == jbPrevious) {
            try {
                fill(trans.getPreviousRecord());
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } else if (e.getSource() == jbNext) {
            try {
                fill(trans.getNextRecord());
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } else if (e.getSource() == jbLast) {
            try {
                fill(trans.getLastRecord());
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } else if (e.getSource() == jbInsert) {
            trans.insertRecord(getAllStrings());
            trans.load();
            try {
                fill(trans.getLastRecord());
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } else if (e.getSource() == jbUpdate) {
            trans.updateRecord(getAllStrings());
            trans.load();
            fill(trans.getAbsoluteRecord(trans.getCurrentRow()));
        } else if (e.getSource() == jbDelete) {
            trans.deleteRecord(getAllStrings());
            trans.load();
            fill(trans.getAbsoluteRecord(trans.getCurrentRow()));
        } else if (e.getSource() == jbCancel) {
            fill(trans.getAbsoluteRecord(trans.getCurrentRow()));
        }
    }

    public String[] getAllStrings() {
        String[] content = new String[trans.getColumnCount()];
        for (int i = 0; i < trans.getColumnCount(); i++) {
            content[i] = jtfs[i].getText();
        }
        return content;
    }
}
