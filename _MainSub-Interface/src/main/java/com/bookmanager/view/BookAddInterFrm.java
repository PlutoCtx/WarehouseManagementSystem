package com.bookmanager.view;

import com.bookmanager.dao.BookDao;
import com.bookmanager.dao.BookTypeDao;
import com.bookmanager.model.Book;
import com.bookmanager.model.BookType;
import com.bookmanager.utils.DBUtil;
import com.bookmanager.utils.StringUtil;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * @author Max chenmochen1954@163.com
 * since jdk17
 * @version 2022/12/21 12:03
 */
public class BookAddInterFrm extends JInternalFrame {
    private JTextField bookNameTxt;
    private JTextField authorTxt;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTextField priceTxt;
    private JComboBox bookTypeJcb;
    private JTextArea bookDescTxt;
    private JRadioButton manJrb;
    private JRadioButton femaleJrb;

    private DBUtil dbUtil=new DBUtil();
    private BookTypeDao bookTypeDao=new BookTypeDao();
    private BookDao bookDao=new BookDao();


    /**
     * Create the frame.
     */
    public BookAddInterFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("\u56FE\u4E66\u6DFB\u52A0");
        setBounds(100, 100, 450, 467);

        JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");

        bookNameTxt = new JTextField();
        bookNameTxt.setColumns(10);

        JLabel label1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");

        authorTxt = new JTextField();
        authorTxt.setColumns(10);

        JLabel label2 = new JLabel("\u4F5C\u8005\u6027\u522B\uFF1A");

        manJrb = new JRadioButton("\u7537");
        buttonGroup.add(manJrb);
        manJrb.setSelected(true);

        femaleJrb = new JRadioButton("\u5973");
        buttonGroup.add(femaleJrb);

        JLabel label3 = new JLabel("\u56FE\u4E66\u4EF7\u683C\uFF1A");

        priceTxt = new JTextField();
        priceTxt.setColumns(10);

        JLabel label4 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");

        bookDescTxt = new JTextArea();

        JLabel label5 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");

        bookTypeJcb = new JComboBox();

        JButton button = new JButton("\u6DFB\u52A0");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookAddActionPerformed(e);
            }
        });
//        button.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/add.png")));

        JButton button1 = new JButton("\u91CD\u7F6E");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetValueActionPerformed(e);
            }
        });
//        button1.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/reset.png")));
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(42)
                    .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addComponent(button)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(button1)
                            .addGap(232))
                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(label5)
                            .addGroup(groupLayout.createSequentialGroup()
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(label4)
                                    .addComponent(label2)
                                    .addComponent(label))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(groupLayout.createSequentialGroup()
                                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                            .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(manJrb)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(femaleJrb))
                                            .addComponent(bookTypeJcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(35)
                                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(label1)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(groupLayout.createSequentialGroup()
                                                    .addComponent(label3)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(priceTxt))))
                                    .addComponent(bookDescTxt))
                                .addContainerGap(44, Short.MAX_VALUE)))))
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(42)
                    .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label)
                        .addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1)
                        .addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(29)
                    .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(manJrb)
                        .addComponent(femaleJrb)
                        .addComponent(label3)
                        .addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(33)
                    .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(30)
                    .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(label4)
                        .addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                    .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button)
                        .addComponent(button1))
                    .addGap(42))
        );
        getContentPane().setLayout(groupLayout);

        /**
         * 设置文本域边框
         */
        bookDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
        fillBookType();
    }





    /**
     * 重置事件处理
     * @param e
     */
    private void resetValueActionPerformed(ActionEvent e) {
        this.resetValue();
    }


    /**
     * 图书添加事件处理
     * @param evt
     */
    private void bookAddActionPerformed(ActionEvent evt) {
        String bookName= this.bookNameTxt.getText();
        String author=this.authorTxt.getText();
        String price=this.priceTxt.getText();
        String bookDesc=this.bookDescTxt.getText();

        if(StringUtil.isEmpty(bookName)){
            JOptionPane.showMessageDialog(null, "图书名称不能为空");
            return;
        }

        if(StringUtil.isEmpty(author)){
            JOptionPane.showMessageDialog(null, "图书作者不能为空");
            return;
        }

        if(StringUtil.isEmpty(price)){
            JOptionPane.showMessageDialog(null, "图书价格不能为空");
            return;
        }

        String sex="";
        if(manJrb.isSelected()){
            sex="男";
        }else if(femaleJrb.isSelected()){
            sex="女";
        }

        BookType bookType=(BookType) bookTypeJcb.getSelectedItem();
        int bookTypeId=bookType.getId();

        Book book=new Book(bookName,author, sex, Float.parseFloat(price) , bookTypeId,  bookDesc);

        Connection con=null;
        try{
            con=dbUtil.getConnection();
            int addNum=bookDao.add(con, book);
            if(addNum==1){
                JOptionPane.showMessageDialog(null, "图书添加成功");
                resetValue();
            }else{
                JOptionPane.showMessageDialog(null, "图书添加失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "图书添加失败");
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
        this.bookNameTxt.setText("");
        this.authorTxt.setText("");
        this.priceTxt.setText("");
        this.manJrb.setSelected(true);
        this.bookDescTxt.setText("");
        if(this.bookTypeJcb.getItemCount()>0){
            this.bookTypeJcb.setSelectedIndex(0);
        }
    }


    /**
     * 初始化图书类别下拉框
     */
    private void fillBookType(){
        Connection con=null;
        BookType bookType=null;
        try{
            con=dbUtil.getConnection();
            ResultSet rs=bookTypeDao.list(con, new BookType());
            while(rs.next()){
                bookType=new BookType();
                bookType.setId(rs.getInt("id"));
                bookType.setBookTypeName(rs.getString("bookTypeName"));
                this.bookTypeJcb.addItem(bookType);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{

        }
    }
}
