package com.course_suc;


import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * @author Max chenmochen1954@163.com
 * since jdk17
 * @version 2022/12/21 12:04
 */
public class GoodsManageInterFrm extends JInternalFrame implements InterfaceForm {
    private JTable bookTable;
    private JTextField s_bookNameTxt;
    private JTextField s_authorTxt;
    private JComboBox s_bookTypeJcb;
    private JRadioButton manJrb ;
    private JRadioButton femaleJrb ;
    private JTextArea bookDescTxt;
    private JComboBox bookTypeJcb ;


    private JTextField idTxt;
    private JTextField bookNameTxt;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTextField priceTxt;
    private JTextField authorTxt;

    /**
     * Create the frame.
     */
    public GoodsManageInterFrm() {
        setClosable(true);
        setIconifiable(true);
        // 图书管理
        setTitle("\u56FE\u4E66\u7BA1\u7406");
        setBounds(100, 100, 677, 487);
        JScrollPane scrollPane = new JScrollPane();
        JPanel panel = new JPanel();
        // 搜索条件
        panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        JPanel panel1 = new JPanel();
        // 表单操作
        panel1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));


        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(panel1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.LEADING, groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scrollPane)))
                    .addContainerGap(66, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(28)
                    .addComponent(panel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .addContainerGap())
        );
        // 编号：
        JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");
        idTxt = new JTextField();
        idTxt.setEditable(false);
        idTxt.setColumns(10);

        // 图书名称：
        JLabel lblNewLabel1 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
        bookNameTxt = new JTextField();
        bookNameTxt.setColumns(10);

        // 作者性别：
        JLabel label3 = new JLabel("\u4F5C\u8005\u6027\u522B\uFF1A");
        // 男
        manJrb = new JRadioButton("\u7537");
        buttonGroup.add(manJrb);
        manJrb.setSelected(true);
        // 女
        femaleJrb = new JRadioButton("\u5973");
        buttonGroup.add(femaleJrb);

        // 价格：
        JLabel label4 = new JLabel("\u4EF7\u683C\uFF1A");
        priceTxt = new JTextField();
        priceTxt.setColumns(10);
        // 图书作者：
        JLabel lblNewlabel2 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
        authorTxt = new JTextField();
        authorTxt.setColumns(10);

        // 图书类别：
        JLabel label5 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
        bookTypeJcb = new JComboBox();
        // 图书描述：
        JLabel label6 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");
        bookDescTxt = new JTextArea();

        // 修改
        JButton button1 = new JButton("\u4FEE\u6539");


        JButton button2 = new JButton("\u5220\u9664");

        
        GroupLayout gl_panel1 = new GroupLayout(panel1);
        gl_panel1.setHorizontalGroup(
            gl_panel1.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_panel1.createSequentialGroup()
                    .addGap(19)
                    .addGroup(gl_panel1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_panel1.createSequentialGroup()
                            .addComponent(button1)
                            .addGap(18)
                            .addComponent(button2)
                            .addGap(386))
                        .addGroup(gl_panel1.createSequentialGroup()
                            .addGroup(gl_panel1.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(gl_panel1.createSequentialGroup()
                                    .addComponent(label6)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(bookDescTxt))
                                .addGroup(gl_panel1.createSequentialGroup()
                                .addGroup(gl_panel1.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(gl_panel1.createSequentialGroup()
                                            .addComponent(label4)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(priceTxt))
                                        .addGroup(gl_panel1.createSequentialGroup()
                                            .addComponent(lblNewLabel)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(26)
                                    .addGroup(gl_panel1.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(gl_panel1.createSequentialGroup()
                                            .addComponent(lblNewLabel1)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_panel1.createSequentialGroup()
                                            .addComponent(lblNewlabel2)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(authorTxt)))
                                    .addGap(26)
                                    .addGroup(gl_panel1.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(gl_panel1.createSequentialGroup()
                                            .addComponent(label3)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(manJrb)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(femaleJrb))
                                        .addGroup(gl_panel1.createSequentialGroup()
                                            .addComponent(label5)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(bookTypeJcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addContainerGap(86, Short.MAX_VALUE))))
        );
        gl_panel1.setVerticalGroup(
            gl_panel1.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_panel1.createSequentialGroup()
                    .addGap(21)
                    .addGroup(gl_panel1.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNewLabel)
                        .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNewLabel1)
                        .addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3)
                        .addComponent(manJrb)
                        .addComponent(femaleJrb))
                    .addGap(18)
                    .addGroup(gl_panel1.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNewlabel2)
                        .addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label5)
                        .addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_panel1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(label6)
                        .addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                    .addGroup(gl_panel1.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2)))
        );
        panel1.setLayout(gl_panel1);

        // 图书名称：
        JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");

        s_bookNameTxt = new JTextField();
        s_bookNameTxt.setColumns(10);

        // 图书作者：
        JLabel label1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");

        s_authorTxt = new JTextField();
        s_authorTxt.setColumns(10);

        // 图书类别：
        JLabel label2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");

        s_bookTypeJcb = new JComboBox();

        // 查询
        JButton button = new JButton("\u67E5\u8BE2");


        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
            gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_panel.createSequentialGroup()
                    .addGap(19)
                    .addComponent(label)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(label2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(s_bookTypeJcb, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(button)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_panel.setVerticalGroup(
            gl_panel.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addGroup(gl_panel.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(gl_panel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label)
                        .addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1)
                        .addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2)
                        .addComponent(s_bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button))
                    .addGap(16))
        );
        panel.setLayout(gl_panel);

        bookTable = new JTable();

        scrollPane.setViewportView(bookTable);
        bookTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                // 编号 图书名称 图书作者 作者性别 图书价格 图书描述 图书类别
                new String[] {
                        "\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4F5C\u8005", "\u4F5C\u8005\u6027\u522B", "\u56FE\u4E66\u4EF7\u683C", "\u56FE\u4E66\u63CF\u8FF0", "\u56FE\u4E66\u7C7B\u522B"
                }
        ) {
            boolean[] columnEditables = new boolean[] {
                    false, false, false, false, false, false, false
            };
            @Override
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        bookTable.getColumnModel().getColumn(5).setPreferredWidth(119);
        getContentPane().setLayout(groupLayout);

    }


    /**
     * 重置表单
     */
    private void resetValue(){
        this.idTxt.setText("");
        this.bookNameTxt.setText("");
        this.authorTxt.setText("");
        this.priceTxt.setText("");
        this.manJrb.setSelected(true);
        this.bookDescTxt.setText("");
        if(this.bookTypeJcb.getItemCount()>0){
            this.bookTypeJcb.setSelectedIndex(0);
        }
    }


    @Override
    public void ExecuteForm(JMenuItem src) {
        // 设置文本域边框
        bookDescTxt.setBorder(new LineBorder(new Color(127,157,185), 1, false));
    }
}
