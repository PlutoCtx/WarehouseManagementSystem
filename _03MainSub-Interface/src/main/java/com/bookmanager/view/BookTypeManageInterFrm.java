package com.bookmanager.view;

import com.bookmanager.dao.BookDao;
import com.bookmanager.dao.BookTypeDao;
import com.bookmanager.model.BookType;
import com.bookmanager.utils.DBUtil;
import com.bookmanager.utils.StringUtil;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

/**
 * @author Max chenmochen1954@163.com
 * since jdk17
 * @version 2022/12/21 11:52
 */
public class BookTypeManageInterFrm extends JInternalFrame {
    private JTable bookTypeTable;
    private JTextArea bookTypeDescTxt ;

    private DBUtil dbUtil=new DBUtil();
    private BookTypeDao bookTypeDao=new BookTypeDao();
    private BookDao bookDao=new BookDao();
    private JTextField s_bookTypeNameTxt;
    private JTextField idTxt;
    private JTextField bookTypeNameTxt;

//    /**
//     * Launch the application.
//     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    BookTypeManageInterFrm frame = new BookTypeManageInterFrm();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    /**
     * Create the frame.
     */
    public BookTypeManageInterFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
        setBounds(100, 100, 507, 481);

        JScrollPane scrollPane = new JScrollPane();

        JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");

        s_bookTypeNameTxt = new JTextField();
        s_bookTypeNameTxt.setColumns(10);

        JButton button = new JButton("\u67E5\u8BE2");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookTypeSearchActionPerformed(e);
            }
        });

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
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookTypeUpdateActionEvent(e);
            }
        });

        JButton btnNewButton_1 = new JButton("\u5220\u9664");
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookTypeDeleteActionEvent(e);
            }
        });

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
        bookTypeTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                bookTypeTableMousePressed(e);
            }
        });
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

        this.fillTable(new BookType());

        bookTypeDescTxt.setBorder(new LineBorder(new Color(127,157,185), 1, false));
    }


    /**
     * 图书类别删除事件处理
     * @param evt   how do I know
     */
    private void bookTypeDeleteActionEvent(ActionEvent evt) {
        String id=idTxt.getText();
        if(StringUtil.isEmpty(id)){
            JOptionPane.showMessageDialog(null, "请选择要删除的记录");
            return;
        }
        int n=JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
        if(n==0){
            Connection con=null;
            try{
                con=dbUtil.getConnection();
                boolean flag=bookDao.existBookByBookTypeId(con, id);
                if(flag){
                    JOptionPane.showMessageDialog(null, "当前图书类别下有图书，不能删除此类别");
                    return;
                }
                int deleteNum=bookTypeDao.delete(con, id);
                if(deleteNum==1){
                    JOptionPane.showMessageDialog(null, "删除成功");
                    this.resetValue();
                    this.fillTable(new BookType());
                }else{
                    JOptionPane.showMessageDialog(null, "删除失败");
                }
            }catch(Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "删除失败");
            }finally{
                try {
                    dbUtil.closeConnection(con);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 图书类别修改事件处理
     * @param evt   how do I know
     */
    private void bookTypeUpdateActionEvent(ActionEvent evt) {
        String id=idTxt.getText();
        String bookTypeName=bookTypeNameTxt.getText();
        String bookTypeDesc=bookTypeDescTxt.getText();
        if(StringUtil.isEmpty(id)){
            JOptionPane.showMessageDialog(null, "请选择要修改的记录");
            return;
        }
        if(StringUtil.isEmpty(bookTypeName)){
            JOptionPane.showMessageDialog(null, "图书类别名称不能为空");
            return;
        }
        BookType bookType=new BookType(Integer.parseInt(id),bookTypeName,bookTypeDesc);
        Connection con=null;
        try{
            con=dbUtil.getConnection();
            int modifyNum=bookTypeDao.update(con, bookType);
            if(modifyNum==1){
                JOptionPane.showMessageDialog(null, "修改成功");
                this.resetValue();
                this.fillTable(new BookType());
            }else{
                JOptionPane.showMessageDialog(null, "修改失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "修改失败");
        }finally{
            try {
                dbUtil.closeConnection(con);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }



    /**
     * 表格行点击事件处理
     * @param evt   how do I know
     */
    private void bookTypeTableMousePressed(MouseEvent evt) {
        int row=bookTypeTable.getSelectedRow();
        idTxt.setText((String)bookTypeTable.getValueAt(row, 0));
        bookTypeNameTxt.setText((String)bookTypeTable.getValueAt(row, 1));
        bookTypeDescTxt.setText((String)bookTypeTable.getValueAt(row, 2));
    }


    /**
     * 图书类别搜索事件处理
     * @param evt   how do I know
     */
    private void bookTypeSearchActionPerformed(ActionEvent evt) {
        String s_bookTypeName = this.s_bookTypeNameTxt.getText();
        BookType bookType=new BookType();
        bookType.setBookTypeName(s_bookTypeName);
        this.fillTable(bookType);
    }


    /**
     * 初始化表格
     * @param bookType  bookType
     */
    private void fillTable(BookType bookType){
        DefaultTableModel dtm=(DefaultTableModel) bookTypeTable.getModel();
        // 设置成0行
        dtm.setRowCount(0);
        Connection con=null;
        try{
            con = dbUtil.getConnection();
            ResultSet rs = bookTypeDao.list(con, bookType);
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("bookTypeName"));
                v.add(rs.getString("bookTypeDesc"));
                dtm.addRow(v);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                dbUtil.closeConnection(con);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * 重置表单
     */
    private void resetValue(){
        this.idTxt.setText("");
        this.bookTypeNameTxt.setText("");
        this.bookTypeDescTxt.setText("");
    }
}
