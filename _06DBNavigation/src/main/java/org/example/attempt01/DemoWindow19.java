package org.example.attempt01;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * WarehouseManagementSystem
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/4/22 18:07
 * @since JDK17
 */

class DemoWindow19 extends JFrame implements ActionListener {
    DBNavigation trans = new DBNavigation("e:/ck/ckgl.mdb", "clggb");
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

    public DemoWindow19(String var1) {
        super(var1);
        this.setLayout(new GridLayout(this.trans.getColumnCount() + 3, 1));
        this.add(new JLabel("数据库：" + this.trans.getDatabase() + "|表：" + this.trans.getTable(), 0));
        this.jps = new JPanel[this.trans.getColumnCount()];
        this.jtfs = new JTextField[this.trans.getColumnCount()];

        for(int var2 = 0; var2 < this.trans.getColumnCount(); ++var2) {
            this.jps[var2] = new JPanel();
            this.jps[var2].add(new JLabel(this.trans.getColumnNames()[var2]));
            this.jtfs[var2] = new JTextField(20);
            this.jps[var2].add(this.jtfs[var2]);
            this.add(this.jps[var2]);
        }

        this.controlPanel.add(this.jbFirst);
        this.controlPanel.add(this.jbPrevious);
        this.controlPanel.add(this.jbNext);
        this.controlPanel.add(this.jbLast);
        this.add(this.controlPanel);
        this.operatePanel.add(this.jbInsert);
        this.operatePanel.add(this.jbUpdate);
        this.operatePanel.add(this.jbDelete);
        this.operatePanel.add(this.jbCancel);
        this.add(this.operatePanel);
        this.jbFirst.addActionListener(this);
        this.jbPrevious.addActionListener(this);
        this.jbNext.addActionListener(this);
        this.jbLast.addActionListener(this);
        this.jbInsert.addActionListener(this);
        this.jbUpdate.addActionListener(this);
        this.jbDelete.addActionListener(this);
        this.jbCancel.addActionListener(this);
        this.fill(this.trans.getFirstRecord());
    }

    public void fill(String[] var1) {
        for(int var2 = 0; var2 < this.trans.getColumnCount(); ++var2) {
            this.jtfs[var2].setText(var1[var2]);
        }

    }

    @Override
    public void actionPerformed(ActionEvent var1) {
        if (var1.getSource() == this.jbFirst) {
            this.fill(this.trans.getFirstRecord());
        } else if (var1.getSource() == this.jbPrevious) {
            try {
                this.fill(this.trans.getPreviousRecord());
            } catch (SQLException var6) {
                var6.printStackTrace();
            }
        } else if (var1.getSource() == this.jbNext) {
            try {
                this.fill(this.trans.getNextRecord());
            } catch (SQLException var5) {
                var5.printStackTrace();
            }
        } else if (var1.getSource() == this.jbLast) {
            try {
                this.fill(this.trans.getLastRecord());
            } catch (SQLException var4) {
                var4.printStackTrace();
            }
        } else if (var1.getSource() == this.jbInsert) {
            this.trans.insertRecord(this.getAllStrings());
            this.trans.load();

            try {
                this.fill(this.trans.getLastRecord());
            } catch (SQLException var3) {
                var3.printStackTrace();
            }
        } else if (var1.getSource() == this.jbUpdate) {
            this.trans.updateRecord(this.getAllStrings());
            this.trans.load();
            this.fill(this.trans.getAbsoluteRecord(this.trans.getCurrentRow()));
        } else if (var1.getSource() == this.jbDelete) {
            this.trans.deleteRecord(this.getAllStrings());
            this.trans.load();
            this.fill(this.trans.getAbsoluteRecord(this.trans.getCurrentRow()));
        } else if (var1.getSource() == this.jbCancel) {
            this.fill(this.trans.getAbsoluteRecord(this.trans.getCurrentRow()));
        }

    }

    public String[] getAllStrings() {
        String[] var1 = new String[this.trans.getColumnCount()];

        for(int var2 = 0; var2 < this.trans.getColumnCount(); ++var2) {
            var1[var2] = this.jtfs[var2].getText();
        }

        return var1;
    }
}
