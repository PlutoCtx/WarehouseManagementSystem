package org.example.service;

import org.example.tables.Depository;
import org.example.tables.Out_Record;
import org.example.tables.Standing_Book;
import org.example.tables.Total_Depository;
import org.example.operator.Op_Depository;
import org.example.operator.Op_Standing_Book;
import org.example.operator.Op_Total_Depository;
import org.example.operator.Op_out_Record;
import org.example.tool.DBConnect;

import java.sql.SQLException;


import javax.swing.*;

public class Delivery_sev {

    public static void Delivery(int id) {

        //Get_Connect.getConnection();

        Out_Record out= Op_out_Record.findOut_RecordById(id);
        //如果无该记录，则返回
        if(out==null) {
            return;
        }
        //检查vis、checked、bj三个字段是否符合条件
        if(out.getBj()!=2&&out.getBj()!=3) {
            JOptionPane.showMessageDialog(new JPanel(),"该记录不是领料或退料记录，无法处理");
            return;
        }
        if(out.getChecked()==0) {
            JOptionPane.showMessageDialog(new JPanel(),"该记录尚未通过审核，无法处理");
            return;
        }
        if(out.getVs()==1) {
            JOptionPane.showMessageDialog(new JPanel(),"该出库记录已处理过，无需再处理");
            return;
        }

        Depository dRecord= Op_Depository.findDepositoryRecord(out.getCname(), out.getPno());
        if(dRecord==null) {
            dRecord=new Depository(0, out.getCname(), out.getPno(), out.getNum(),
                    out.getPrice(), out.getSum_price());
        }
        else {
            dRecord.setNum(dRecord.getNum()-out.getNum());

            dRecord.setSum_price(dRecord.getSum_price()-out.getSum_price());
            //使用try-catch防止除零错误
            try {
                dRecord.setPrice(dRecord.getSum_price()/dRecord.getNum());
            } catch (Exception e) {
                System.out.println("PurchaseService.purchase().本仓除0错误");
                e.printStackTrace();
            }
        }

        Total_Depository tRecord= Op_Total_Depository.findTotalDepositoryRecord(out.getPno());
        if(tRecord==null) {
            tRecord=new Total_Depository(0, out.getPno(), out.getNum(), out.getPrice(), out.getSum_price());
        }
        else {
            tRecord.setNum(tRecord.getNum()-out.getNum());
            tRecord.setSum_price(tRecord.getSum_price()-out.getSum_price());
            try {
                tRecord.setPrice(tRecord.getSum_price()/tRecord.getNum());
            } catch (Exception e) {
                System.out.println("PurchaseService.purchase().总仓除0错误");
                e.printStackTrace();
            }
        }

        //开始事务处理
        try {
            DBConnect.conn.setAutoCommit(false);
            //更新vis
            int res1=Op_out_Record.updateVis(out.getId(), 1);
            if(res1==0) {
                DBConnect.conn.rollback();		//更新vis失败回滚
                return;
            }

            //更新本仓
            String s="  ";
            System.out.println(dRecord.getCname()+s+ dRecord.getPno()+s+ dRecord.getNum()
                    +s+ dRecord.getPrice()+s+dRecord.getSum_price());
            int res2=Op_Depository.update(dRecord.getCname(), dRecord.getPno(), dRecord.getNum()
                    , dRecord.getPrice(), dRecord.getSum_price());
            if(res2==0) {
                System.out.println("res2为0");
                DBConnect.conn.rollback();
                return;
            }

            //更新总仓
            int res3=Op_Total_Depository.update(tRecord.getPno(), tRecord.getNum(),
                    tRecord.getPrice(), tRecord.getSum_price());
            if(res3==0) {
                DBConnect.conn.rollback();
                return;
            }

            //插入台账
            int res4= Op_Standing_Book.insert(new Standing_Book(0, out.getCname(), out.getPno(), out.getBj(),
                    out.getNum(), out.getPrice(), out.getSum_price(), dRecord.getNum(), dRecord.getPrice(),
                    dRecord.getSum_price()));
            if(res4==0) {
                DBConnect.conn.rollback();
                return;
            }

            DBConnect.conn.commit();
            DBConnect.conn.close();
            JOptionPane.showMessageDialog(new JPanel(),"材料出库成功");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new JPanel(),"材料出库事务处理异常");
            System.out.println("");
            try {
                DBConnect.conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

    }
}
