package org.example.CS;


import org.example.tables.In_Record;
import org.example.tables.Out_Record;
import org.example.operator.Op_Depository;
import org.example.operator.Op_Total_Depository;
import org.example.operator.Op_in_Record;
import org.example.operator.Op_out_Record;
import org.example.service.Delivery_sev;
import org.example.service.Warehous_sev;
import org.example.tool.DBConnect;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ButtonPanel extends JPanel implements ActionListener {
    public Map<String,JButton> map=new HashMap<>();
    public int len;
    public String name;
    public EditPanel editPanel;

    public JButton next=new JButton("下一条");
    public JButton pre=new JButton("上一条");
    public JButton first=new JButton("第一条");
    public JButton last=new JButton("最后一条");
    public JButton update=new JButton("更新");
    public JButton inRecordInsert=new JButton("入库制单");
    public JButton inRecordCheck=new JButton("入库审核");
    public JButton inRecordExecute=new JButton("材料入库");
    public JButton inRecordFind=new JButton("入库查询");
    public JButton outRecordInsert=new JButton("出库插入");
    public JButton outRecordCheck=new JButton("出库审核");
    public JButton outRecordExecute=new JButton("材料出库");
    public JButton outRecordFind=new JButton("出库查询");
    public JButton find=new JButton("库存查询");
    public ResultSet rs;
    public ButtonPanel(EditPanel editPanel) {
        this.editPanel=editPanel;
        map.put("next", next);
        map.put("pre", pre);
        map.put("first", first);
        map.put("last", last);
        map.put("update", update);
        map.put("inRecordInsert", inRecordInsert);
        map.put("inRecordCheck", inRecordCheck);
        map.put("inRecordExecute", inRecordExecute);
        map.put("inRecordFind", inRecordFind);
        map.put("outRecordInsert", outRecordInsert);
        map.put("outRecordCheck", outRecordCheck);
        map.put("outRecordExecute", outRecordExecute);
        map.put("outRecordFind", outRecordFind);
        map.put("find", find);
        setBorder(new TitledBorder(null,"控制栏",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("宋体",0,20),Color.BLACK));
        //init("clggb");
    }
    void init(String name)
    {
        this.name=name;
        len=editPanel.getItemCount();

        setLayout(new GridLayout(0,5));
        addButton("next");
        addButton("pre");
        addButton("first");
        addButton("last");
        addButton("update");

        getrs();
    }
    public void addButton(String s)
    {
        add(map.get(s));
        map.get(s).addActionListener(this);
    }
    public void write(String s[])
    {
        for(int i=0;i<len;i++) {
            editPanel.getTextField(i).setText(s[i]);
        }
    }
    public void getrs() {
        DBConnect.getConnection();
        Connection conn= DBConnect.conn;
        String sql="select * from "+name;
        try {
            PreparedStatement ps=conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs=ps.executeQuery();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==next)
        {
            write(getnextval());
        }
        else if(e.getSource()==pre)
        {
            write(getpreval());
        }
        else if(e.getSource()==last)
        {
            write(getlastval());
        }
        else if(e.getSource()==first)
        {
            write(getfirstval());
        }
        else if(e.getSource()==update)
        {
            getrs();
        }
        else if(e.getSource()==inRecordInsert)
        {
            insert_In_Record();
        }
        else if(e.getSource()==inRecordCheck)
        {
            check_In_Record();
        }
        else if(e.getSource()==inRecordExecute)
        {
            Excute_In_Record();
        }
        else if(e.getSource()==inRecordFind) {
            try {
                inRecordFind();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        else if(e.getSource()==outRecordInsert) {
            insert_out_Record();
        }
        else if(e.getSource()==outRecordCheck) {
            check_out_Record();
        }
        else if(e.getSource()==outRecordExecute) {
            Excute_out_Record();
        }
        else if(e.getSource()==outRecordFind) {
            try {
                outRecordFind();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        else if(e.getSource()==find) {
            try {
                find();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public String[] getnextval()
    {
        String res[]=new String[len];
        try
        {
            rs.next();
            if(rs.isAfterLast()) {
                rs.last();
            }
            for(int i=0;i<len;i++) {
                res[i]=rs.getString(i+1);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return res;
    }
    public String[] getpreval()
    {
        String res[]=new String[len];
        try
        {
            rs.previous();
            if(rs.isBeforeFirst()) {
                rs.first();
            }
            for(int i=0;i<len;i++) {
                res[i]=rs.getString(i+1);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return res;
    }
    public String[] getfirstval()
    {
        String res[]=new String[len];
        try
        {
            rs.first();
            for(int i=0;i<len;i++) {
                res[i]=rs.getString(i+1);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return res;
    }
    public String[] getlastval()
    {
        String res[]=new String[len];
        try
        {
            rs.last();
            for(int i=0;i<len;i++) {
                res[i]=rs.getString(i+1);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return res;
    }
    //入库操作
    public In_Record getIn_Recordval()
    {
        String res[] = new String[len];
        for(int i=0;i<len;i++)
        {
            res[i]=editPanel.getTextField(i).getText();
        }
        In_Record in=new In_Record(res[0],res[1],res[2],res[3],res[4],res[5],res[6],res[7],res[8]);
        return in;
    }
    public void insert_In_Record()
    {
        try{
            In_Record in=getIn_Recordval();
            Op_in_Record.insert(in);
            JOptionPane.showMessageDialog(new JPanel(),"制单成功");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(new JPanel(),"制单失败");
            e.printStackTrace();
        }
    }
    public void check_In_Record()
    {
        try{
            In_Record in=getIn_Recordval();
            String cname=in.getCname();
            String pno=in.getPno();
            if(Op_Depository.findDepositoryRecord(cname,pno)==null)
            {
                Op_Depository.insert(cname,pno);
            }
            if(Op_Total_Depository.findTotalDepositoryRecord(pno)==null)
            {
                Op_Total_Depository.insert(pno);
            }
            if(Op_in_Record.updateCheck(in)!=0)
            {
                JOptionPane.showMessageDialog(new JPanel(),"审核成功");
            }
            else
            {
                JOptionPane.showMessageDialog(new JPanel(),"该记录已经审核");
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(new JPanel(),"审核失败");
            e.printStackTrace();
        }
    }
    public void Excute_In_Record() {
        try {
            In_Record in = getIn_Recordval();
            Warehous_sev.Warehousing(in.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Out_Record getOut_RecordVal() {
        String value[]=new String[len];
        for(int i=0;i<len;i++) {
            value[i]=editPanel.getTextField(i).getText();
        }
        Out_Record out=new Out_Record(value[0], value[1], value[2], value[3], value[4], value[5],
                value[6], value[7], value[8]);
        return out;
    }

    public void insert_out_Record() {

        try {
            Out_Record out=getOut_RecordVal();
            Op_out_Record.insert(out);
            JOptionPane.showMessageDialog(new JPanel(),"出库插入成功");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JPanel(),"出库插入失败");
            e.printStackTrace();
        }

    }

    public void check_out_Record() {
        try {
            Out_Record out=getOut_RecordVal();
            String cname=out.getCname();
            String pno=out.getPno();
            if(Op_Depository.findDepositoryRecord(cname,pno)==null)
            {
                Op_Depository.insert(cname,pno);
            }
            if(Op_Total_Depository.findTotalDepositoryRecord(pno)==null)
            {
                Op_Total_Depository.insert(pno);
            }
            if(Op_out_Record.updateCheck(out)!=0) {
                JOptionPane.showMessageDialog(new JPanel(),"审核成功");
            }
            else {
                JOptionPane.showMessageDialog(new JPanel(),"该出库记录已审核，无需再次审核");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JPanel(),"审核失败");
            e.printStackTrace();
        }
    }

    public void Excute_out_Record() {
        try {
            Out_Record out=getOut_RecordVal();
            Delivery_sev.Delivery(out.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void inRecordFind() throws Exception {
        String date=JOptionPane.showInputDialog(new JPanel(),"输入日期","输入对话框",JOptionPane.PLAIN_MESSAGE);
        String wname=JOptionPane.showInputDialog(new JPanel(),"输入仓库","输入对话框",JOptionPane.PLAIN_MESSAGE);
        String pno=JOptionPane.showInputDialog(new JPanel(),"输入货号","输入对话框",JOptionPane.PLAIN_MESSAGE);
        PreparedStatement ps=null;
        if(wname.equals("")) {
            String sql="select * from "+name+" where pno=?";
            Connection conn= DBConnect.conn;
            ps=conn.prepareStatement(sql);
            ps.setString(1, pno);
        }
        else {
            String sql="select * from "+name+" where pno=? and cname=?";
            System.out.println(sql);
            Connection conn= DBConnect.conn;
            ps=conn.prepareStatement(sql);
            ps.setString(1, pno);
            ps.setString(2, wname);
        }
        rs=ps.executeQuery();
        int f=1;
        while(rs.next()) {
            f=0;
            for(int i=0;i<editPanel.getItemCount();i++) {
                editPanel.getTextField(i).setText(rs.getString(i+1));
            }
            break;
        }
        if(f==1) {
            JOptionPane.showMessageDialog(new JPanel(),"无该货物的入库记录");
        }
    }

    public void outRecordFind() throws Exception {
        String date=JOptionPane.showInputDialog(new JPanel(),"输入日期","输入对话框",JOptionPane.PLAIN_MESSAGE);
        String wname=JOptionPane.showInputDialog(new JPanel(),"输入仓库","输入对话框",JOptionPane.PLAIN_MESSAGE);
        String pno=JOptionPane.showInputDialog(new JPanel(),"输入货号","输入对话框",JOptionPane.PLAIN_MESSAGE);
        PreparedStatement ps=null;
        if(wname.equals("")) {
            String sql="select * from "+name+" where pno = ?";
            Connection conn= DBConnect.conn;
            ps=conn.prepareStatement(sql);
            ps.setString(1, pno);
        }
        else {
            String sql="select * from " + name +" where pno=? and cname=?";
            Connection conn= DBConnect.conn;
            ps=conn.prepareStatement(sql);
            ps.setString(1, pno);
            ps.setString(2, wname);
        }
        rs=ps.executeQuery();
        int f=1;
        while(rs.next()) {
            f = 0;
            for(int i=0;i<editPanel.getItemCount();i++) {
                editPanel.getTextField(i).setText(rs.getString(i+1));
            }
            break;
        }
        if(f==1) {
            JOptionPane.showMessageDialog(new JPanel(),"无该货物的出库记录");
        }
    }

    public void find() throws Exception {
        String pno=JOptionPane.showInputDialog(new JPanel(),"输入货号","输入对话框",JOptionPane.PLAIN_MESSAGE);
        String wname=JOptionPane.showInputDialog(new JPanel(),"输入仓库","输入对话框",JOptionPane.PLAIN_MESSAGE);
        PreparedStatement ps=null;
        if(wname.equals("")) {
            String sql="select * from total_depository where pno=?";
            Connection conn= DBConnect.conn;
            ps=conn.prepareStatement(sql);
            ps.setString(1, pno);
        } else {
            String sql="select * from "+name+" where pno=? and cname=?";
            Connection conn= DBConnect.conn;
            ps=conn.prepareStatement(sql);
            ps.setString(1, pno);
            ps.setString(2, wname);
        }
        rs=ps.executeQuery();
        int f=1;
        while(rs.next()) {
            f=0;
            for(int i=0;i<editPanel.getItemCount();i++) {
                if(wname.equals("")) {
                    if(i==6) {
                        break;
                    }
                    if(i==1) {
                        continue;
                    } else if(i>1) {
                        editPanel.getTextField(i).setText(rs.getString(i));
                    } else {
                        editPanel.getTextField(i).setText(rs.getString(i+1));
                    }
                }
                else {
                    editPanel.getTextField(i).setText(rs.getString(i+1));
                }
            }
            break;
        }
        if(f==1) {
            JOptionPane.showMessageDialog(new JPanel(),"无该货物的库存记录");
        }
    }
}
