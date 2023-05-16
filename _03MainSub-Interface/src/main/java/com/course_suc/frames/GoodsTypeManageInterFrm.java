package com.course_suc.frames;



import com.course_suc.InterfaceForm;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * @author Max chenmochen1954@163.com
 * since jdk17
 * @version 2022/12/21 11:52
 */
public class GoodsTypeManageInterFrm extends JInternalFrame  implements InterfaceForm {
    private JTable bookTypeTable;
    private JTextArea bookTypeDescTxt ;

    private JTextField s_bookTypeNameTxt;
    private JTextField idTxt;
    private JTextField bookTypeNameTxt;


    /**
     * Create the frame.
     */
    public GoodsTypeManageInterFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
        setBounds(100, 100, 507, 481);
        setMaximizable(true);

        JScrollPane scrollPane = new JScrollPane();

        JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");

        s_bookTypeNameTxt = new JTextField();
        s_bookTypeNameTxt.setColumns(10);

        JButton button = new JButton("\u67E5\u8BE2");


        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(42)
                    .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(panel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.LEADING, groupLayout.createSequentialGroup()
                            .addComponent(label)
                            .addGap(18)
                            .addComponent(s_bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                            .addGap(18)
                            .addComponent(button))
                        .addComponent(scrollPane, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
                    .addGap(48))
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(33)
                    .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label)
                        .addComponent(s_bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button))
                    .addGap(39)
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(25, Short.MAX_VALUE))
        );

        JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");

        idTxt = new JTextField();
        idTxt.setEditable(false);
        idTxt.setColumns(10);

        JLabel label_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");

        bookTypeNameTxt = new JTextField();
        bookTypeNameTxt.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("\u63CF\u8FF0\uFF1A");

        bookTypeDescTxt = new JTextArea();

        JButton btnNewButton = new JButton("\u4FEE\u6539");


        JButton btnNewButton_1 = new JButton("\u5220\u9664");


        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
            gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_panel.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(gl_panel.createSequentialGroup()
                            .addComponent(lblNewLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(31)
                            .addComponent(label_1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_panel.createSequentialGroup()
                            .addComponent(lblNewLabel_1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bookTypeDescTxt))
                        .addGroup(gl_panel.createSequentialGroup()
                            .addComponent(btnNewButton)
                            .addGap(26)
                            .addComponent(btnNewButton_1)))
                    .addContainerGap(37, Short.MAX_VALUE))
        );
        gl_panel.setVerticalGroup(
            gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_panel.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_panel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNewLabel)
                        .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_1)
                        .addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblNewLabel_1)
                        .addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_panel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNewButton)
                        .addComponent(btnNewButton_1))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel.setLayout(gl_panel);

        bookTypeTable = new JTable();

        bookTypeTable.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] {"\u7F16\u53F7", "\u56FE\u4E66\u7C7B\u522B\u540D\u79F0", "\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0"}
        ) {
            boolean[] columnEditables = new boolean[] {
                    false, false, false
            };
            @Override
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        bookTypeTable.getColumnModel().getColumn(1).setPreferredWidth(110);
        bookTypeTable.getColumnModel().getColumn(2).setPreferredWidth(123);
        scrollPane.setViewportView(bookTypeTable);
        getContentPane().setLayout(groupLayout);

    }


    @Override
    public void ExecuteForm(JMenuItem src) {
        bookTypeDescTxt.setBorder(new LineBorder(new Color(127,157,185), 1, false));
    }
}
