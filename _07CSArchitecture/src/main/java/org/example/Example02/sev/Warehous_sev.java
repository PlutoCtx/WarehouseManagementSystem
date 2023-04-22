package org.example.Example02.sev;

import org.example.Example02.biao.Depository;
import org.example.Example02.biao.In_Record;
import org.example.Example02.biao.Standing_Book;
import org.example.Example02.biao.Total_Depository;
import org.example.Example02.operator.Op_Depository;
import org.example.Example02.operator.Op_Standing_Book;
import org.example.Example02.operator.Op_Total_Depository;
import org.example.Example02.operator.Op_in_Record;
import org.example.Example02.tool.Get_Connect;

import java.sql.SQLException;

import javax.swing.*;
public class Warehous_sev {
    public static void Warehousing(int id) {

        Get_Connect.getConnection();

        In_Record in= Op_in_Record.findIn_RecordById(id);
        //如果无该记录，则返回
        if(in==null)return;
        //检查vis、checked、bj三个字段是否符合条件
        if(in.getBj()!=0&&in.getBj()!=1) {
            JOptionPane.showMessageDialog(new JPanel(),"该记录不是入库记录，无法处理");
            return;
        }
        if(in.getChecked()==0) {
            JOptionPane.showMessageDialog(new JPanel(),"该记录尚未通过审核，无法处理");
            return;
        }
        if(in.getVs()==1) {
            JOptionPane.showMessageDialog(new JPanel(),"该记录已处理过，无需再处理");
            return;
        }
        Depository dRecord= Op_Depository.findDepositoryRecord(in.getCname(), in.getPno());
        if(dRecord==null) {
            dRecord=new Depository(0, in.getCname(), in.getPno(), in.getNum(),
                    in.getPrice(), in.getSum_price());
        }
        else {
            dRecord.setNum(dRecord.getNum()+in.getNum());
            dRecord.setSum_price(dRecord.getSum_price()+in.getSum_price());
            try {
                dRecord.setPrice(dRecord.getSum_price()/dRecord.getNum());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Total_Depository tRecord= Op_Total_Depository.findTotalDepositoryRecord(in.getPno());
        if(tRecord==null) {
            tRecord=new Total_Depository(0, in.getPno(), in.getNum(), in.getPrice(), in.getSum_price());
        }
        else {
            tRecord.setNum(tRecord.getNum()+in.getNum());
            tRecord.setSum_price(tRecord.getSum_price()+in.getSum_price());
            try {
                tRecord.setPrice(tRecord.getSum_price()/tRecord.getNum());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //开始事务处理
        try {
            Get_Connect.conn.setAutoCommit(false);
            //更新vis
            int res1=Op_in_Record.updateVs(in);
            if(res1==0) {
                Get_Connect.conn.rollback();		//更新vis失败回滚
                return;
            }

            //更新本仓
            String s="  ";
            System.out.println(dRecord.getCname()+s+ dRecord.getPno()+s+ dRecord.getNum()
                    +s+ dRecord.getPrice()+s+dRecord.getSum_price());
            int res2=Op_Depository.update(dRecord.getCname(), dRecord.getPno(), dRecord.getNum()
                    , dRecord.getPrice(), dRecord.getSum_price());
            if(res2==0) {
                Get_Connect.conn.rollback();
                return;
            }

            //更新总仓
            int res3=Op_Total_Depository.update(tRecord.getPno(), tRecord.getNum(),
                    tRecord.getPrice(), tRecord.getSum_price());
            if(res3==0) {
                Get_Connect.conn.rollback();
                return;
            }

            //插入台账
            int res4= Op_Standing_Book.insert(new Standing_Book(0, in.getCname(), in.getPno(), in.getBj(),
                    in.getNum(), in.getPrice(), in.getSum_price(), dRecord.getNum(), dRecord.getPrice(),
                    dRecord.getSum_price()));
            if(res4==0) {
                Get_Connect.conn.rollback();
                return;
            }

            Get_Connect.conn.commit();
            Get_Connect.conn.close();
            JOptionPane.showMessageDialog(new JPanel(),"材料入库成功");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new JPanel(),"材料入库事务处理异常");
            try {
                Get_Connect.conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

    }
}
